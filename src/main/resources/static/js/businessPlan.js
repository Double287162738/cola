
var allPlanData=[];
var findData={
    "category":new Array(),
    "bpName":new Array(),
    "brand":new Array(),
    "ppName":new Array(),
    "bg":new Array(),
};
layui.use(['jquery', 'laydate', 'laypage', 'layer', 'table','upload', 'form', 'element'], function(){
    var $ = layui.$ //重点处
        , form = layui.form
        , laydate = layui.laydate //日期
        , laypage = layui.laypage //分页
        , layer = layui.layer //弹层
        , table = layui.table //表格
        , upload = layui.upload //上传
        , element = layui.element; //元素操作

    laydate.render({
        elem: '#plan-year'
        ,type: 'year'
        ,value: new Date().getFullYear()
    });

    laydate.render({
        elem: '#report-year'
        ,type: 'year'
        ,done: function(value, date, endDate){
            if(value!=null && value!=""){
                $("#report-year").val(value)
                getNowPageData();
            }
        },
    });

    form.on('select(category)', function (data) {
        // console.log(data.value); //得到被选中的值
        // console.log(data.current_value); //当前操作的值
        findData["category"]=data.value

    })
    form.on('select(bpName)', function (data) {
        findData["bpName"]=data.value
    })
    form.on('select(brand)', function (data) {
        findData["brand"]=data.value

    })
    form.on('select(ppName)', function (data) {
        findData["ppName"]=data.value

    })
    form.on('select(bg)', function (data) {
        findData["bg"]=data.value

    })
    document.getElementById("acceptFile").onchange=acceptFile;

    /**
     * 导入的Excel内容展示在当前页面
     * @param obj
     */
    function showExcelDetailInHtml(obj) {
        var colsData=[];
        var data = JSON.parse(obj);
        var keyArray=[];
        for(var key in data[0]){
            keyArray.push(key);
        }
        var noBlankData=[];
        for(var i=0;i<data.length;i++){
            var newData={};
            for(var j=0;j<keyArray.length;j++){
                newData[formatWord(keyArray[j])]=data[i][keyArray[j]];
            }
            noBlankData.push(newData);
        }
        if(allPlanData.length==0){
            allPlanData=noBlankData;
        }else{
            allPlanData.push.apply(allPlanData,noBlankData);
        }
        for(var key in noBlankData[0]){
            var col = {"field": key,"title": key,"width":"120"};
            colsData.push(col);
        }
        allowToUploadPlanData();
        table.render({
            elem: '#plan-data-table'
            ,cols: [colsData]
            ,data: allPlanData
            ,cellMinWidth: 120
            //,skin: 'line' //表格风格
            ,even: true
            ,page: true //是否显示分页
            ,limits: [20, 30, 40]
            ,limit: 20 //每页默认显示的数量
        });
        //关闭loading
        layer.closeAll();
    }


    var wb;//读取完成的数据
    var rABS = false; //是否将文件读取为二进制字符串
    function fixdata(data) {
        var o = "",
            l = 0,
            w = 10240;
        for(; l < data.byteLength / w; ++l) o += String.fromCharCode.apply(null, new Uint8Array(data.slice(l * w, l * w + w)));
        o += String.fromCharCode.apply(null, new Uint8Array(data.slice(l * w)));
        return o;
    }



    $("#choose-file").bind("click",function() {
        allPlanData=[];
        document.getElementById("acceptFile").click();
    });
    $("#cover-import").bind("click",function() {
        renewNewFileAcceptInput();
        allPlanData=[];
        document.getElementById("acceptFile").click();
    });
    $("#add-import").bind("click",function() {
        renewNewFileAcceptInput();
        document.getElementById("acceptFile").click();
    });
    $("#delete-import").bind("click",function(){
        allPlanData=new Array();
        //清空数据
        table.render({
            elem: '#plan-data-table'
            ,cols: []
            ,data: []
        });
        //禁用上传
        forbidToUploadPlanData();
        renewNewFileAcceptInput();
        //清空文件名，表名
        document.getElementById("file-name").innerHTML="文件名:***";
        document.getElementById("sheet-name").innerHTML="工作表:***";
    });

    //弹窗
    function alertFunction(title,content){
        layer.open({
            title: title
            ,content: content
        });
    }



    //确认上传
    function commitUploadPlanData(){
        //开启loading
        layer.msg('上传中，请稍等', {
            time:0
            ,icon: 16
            ,shade: 0.01
        });
        var data={"planDataList":allPlanData,"year":$("#plan-year").val()};
        $.ajax({
            url: "/cola/uploadPlanData.do",
            type: "post",
            contentType: "application/json",
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (data) {
                if(data["error"]!=null){
                    layer.closeAll();
                    alertFunction("上传失败",data["error"]);
                    return;
                }
                else{
                    alertFunction("上传成功","success");
                }
            },
            error: function (data) {
                alertFunction("上传失败","请重试或联系管理员");
            }
        });
    }

    function allowToUploadPlanData(){
        if(allPlanData.length>0){
            $("#upload-plan").removeClass("layui-btn-disabled");
            $("#upload-plan").bind("click",commitUploadPlanData);
        }
    }
    function forbidToUploadPlanData(){
        if(allPlanData.length==0){
            $("#upload-plan").addClass("layui-btn-disabled");
            $("#upload-plan").unbind();
        }
    }

    function acceptFile(){
        if(!this.files) {
            return;
        }
        var fileName = this.value;
        var fileFormat=fileName.substring(fileName.lastIndexOf("."),fileName.length);
        if(fileFormat!=".xls" && fileFormat!=".xlsx"){
            alertFunction("Waring","Please select an Excel file");
            return;
        }
        //开启loading
        layer.msg('导入Excel中，请稍等', {
            time:0
            ,icon: 16
            ,shade: 0.01
        });
        var f = this.files[0];
        var reader = new FileReader();
        reader.onload = function(e) {
            var data = e.target.result;
            if(rABS) {
                wb = XLSX.read(btoa(fixdata(data)), {//手动转化
                    type: 'base64'
                });
            } else {
                wb = XLSX.read(data, {
                    type: 'binary'
                });
            }
            document.getElementById("file-name").innerHTML="文件名:"+fileName.substring(fileName.lastIndexOf("\\")+1,fileName.length);
            document.getElementById("sheet-name").innerHTML="工作表:"+wb.SheetNames[0];
            showExcelDetailInHtml(JSON.stringify( XLSX.utils.sheet_to_json(wb.Sheets[wb.SheetNames[0]]) ));
        };
        if(rABS) {
            reader.readAsArrayBuffer(f);
        } else {
            reader.readAsBinaryString(f);
        }
    }


    /**
     * 字段名称格式化
     * 去除'-'和" "
     * DEC为SQL关键字，需要特殊处理为DECE
     * @param e
     * @returns {*}
     */
    function formatWord(e){
        if(e.toLowerCase()=="dec"){
            return "dece";
        }
        if(e.indexOf("_")==-1 && e.indexOf(" ")==-1){
            return e.toLowerCase();
        }
        var index;
        if(e.indexOf("_")!=-1){
            index=e.indexOf("_");
            e=e.toLowerCase().replace("_","");
        }
        if(e.indexOf(" ")!=-1){
            index=e.indexOf(" ");
            e=e.toLowerCase().replace(" ","");
        }
        var lowerCase = e.charAt(index);
        var newS = e.substring(0,index)+lowerCase.toUpperCase()+e.substring(index+1,e.length);
        return newS;
    }


    /**
     * Business Plan ==> report
     */
    $("#business-plan-report").click(function () {
        $("#creating-part").hide();
        $("#report-part").show();
        //report年份初始化
        $("#report-year").val($("#plan-year").val());
        //初始化搜索下拉框
        initBusinessPlanReportSelect();
        getNowPageData();
    });

    /**
     * Business report ==> Plan
     */
    $("#business-plan-creating").click(function () {
        $("#creating-part").show();
        $("#report-part").hide();
    });


    /**
     *
     * @param page
     */
    function getNowPageData() {
        layer.msg('BP report in the query. . .', {
            time:0
            ,icon: 16
            ,shade: 0.01
        });
        var page ={"pageSize":"10","currentPage":"1"};
        var businessPlanInparameter ={
            "year":$("#report-year").val(),
            "category":findData.category,
            "bpName":findData.bpName,
            "brand":findData.brand,
            "ppName":findData.ppName,
            "bg":findData.bg,
            "page":page
        };
        $.ajax({
            url: "/cola/selectBusinessPlanData.do",
            type: "post",
            data: JSON.stringify(businessPlanInparameter),
            contentType: "application/json",
            dataType: 'json',
            success: function (data) {
                //取所有字段名称
                var colsData = [];
                for(var key in data.result.records[0]){
                    var col = {"field": key,"title": key,"width":"120"};
                    colsData.push(col);
                }
                //初始化表单
                table.render({
                    elem: '#business-plan-report-data-table'
                    ,cols: [colsData]
                    ,data: data.result.records
                    ,cellMinWidth: 120
                    ,even: true
                });

                //初始化分页控件
                laypage.render({
                    elem: 'business-plan-report-page'
                    ,count: data.result.totalRecord
                    ,layout: ['count', 'prev', 'page', 'next', 'refresh', 'skip']
                    ,jump: function(obj,first){
                        if(!first){
                            var page ={"pageSize":"10","currentPage":obj.curr};
                            businessPlanInparameter.page=page;
                            $.ajax({
                                url: "/cola/selectBusinessPlanData.do",
                                type: "post",
                                data: JSON.stringify(businessPlanInparameter),
                                contentType: "application/json",
                                dataType: 'json',
                                success: function (data) {
                                    var size = data.result.records.length;
                                    $(".report-data tbody tr").each(function () {
                                        var value=[];
                                        for(var key in data.result.records[$(this).index()]){
                                            value.push(data.result.records[$(this).index()][key]);
                                        }
                                        if($(this).index()<size){
                                            $(this).find("td div").each(function () {
                                                $(this).text(value[$(this).parent().index()]);
                                            });
                                        }else{
                                            $(this).find("td div").each(function () {
                                                $(this).text("");
                                            });
                                        }

                                    });
                                },
                                error: function (data) {
                                    alertFunction("查询失败","请重试或联系管理员");
                                }
                            });
                        }
                    }
                });
                layer.closeAll();
            },
            error: function (data) {
                alertFunction("查询失败","请重试或联系管理员");
            }
        });
    }
    
    
    function initBusinessPlanReportSelect() {
        $.ajax({
            url: "/cola/distinctSelect.do",
            type: "post",
            dataType: 'json',
            success: function (data) {
                var category = data.category;
                var bpName = data.bpName;
                var brand = data.brand;
                var ppName = data.ppName;
                var bg = data.bg;
                initSelect("category",category);
                initSelect("bpName",bpName);
                initSelect("brand",brand);
                initSelect("ppName",ppName);
                initSelect("bg",bg);
            },
            error: function (data) {
                alertFunction("message","Initialization of search criteria failed");
            }
        });
    }


    /**
     * 清空Business Plan Report下拉框的内容，重新初始化
     * @param id
     * @param list
     */
    function initSelect(id,list) {
        var appendHTML = '<option value="">ALL</option>';
        for(var i=0;i<list.length;i++){
            appendHTML=appendHTML+'<option value="'+list[i]+'">'+list[i]+'</option>';
        }
        $("#"+id).empty();
        $("#"+id).append(appendHTML);
        form.render();
    }


    /**
     * 查询按钮
     */
    $("#inquireBusinessPlanReport").click(function () {
        getNowPageData();
    });

    /**
     * 导出按钮
     */
    $("#export").click(function () {
        var businessPlanInparameter ={
            "year":$("#report-year").val(),
            "category":findData.category,
            "bpName":findData.bpName,
            "brand":findData.brand,
            "ppName":findData.ppName,
            "bg":findData.bg,
        };
        var url = "/cola/businessReportExport.do?flag=1";
        if($("#report-year").val()!=null && $("#report-year").val()!=""){
            url=url+"&year="+$("#report-year").val()
        }
        if(findData.category!=null && findData.category.length>0){
            url=url+"&category="+findData.category;
        }
        if(findData.bpName!=null && findData.bpName.length>0){
            url=url+"&bpName="+findData.bpName;
        }
        if(findData.brand!=null && findData.brand.length>0){
            url=url+"&brand="+findData.brand;
        }
        if(findData.ppName!=null && findData.ppName.length>0){
            url=url+"&ppName="+findData.ppName;
        }
        if(findData.bg!=null && findData.bg.length>0){
            url=url+"&bg="+findData.bg;
        }
        location.href=url;
    });



    /**
     * 重新增加文件选择
     */
    function renewNewFileAcceptInput() {
        $("#acceptFile").remove();
        //可重复选择同一个Excel
        $(".bottom-business-plan-creating-part").before('<input id="acceptFile" type="file" style="display: none;" accept="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet, application/vnd.ms-excel"/>');
        document.getElementById("acceptFile").onchange=acceptFile;
    }
});







