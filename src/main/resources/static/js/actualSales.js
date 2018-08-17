

var allPlanData=[];
var findData={
    "category":new Array(),
    "bpName":new Array(),
    "brand":new Array(),
    "ppName":new Array(),
    "bg":new Array(),
};
var monthList=['JAN','FEB','MAR','APR','MAY','JUN','JUL','AUG','SEP','OCT','NOV','DEC'];
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
        elem: '#actual-year-month'
        ,type: 'month'
        ,value: initActualYearMonth()
    });

    laydate.render({
        elem: '#actual-sales-report-year'
        ,type: 'month'
        ,done: function(value, date, endDate){
            if(value!=null && value!=""){
                $("#actual-sales-report-year").val(value)
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

    /**
     * 初始化年月选择器
     * @returns {string}
     */
    function initActualYearMonth() {
        var month = new Date().getMonth();
        if(month<10){
            month="0"+month;
        }
        return new Date().getFullYear()+"-"+month;
    }

    //选择文件按钮
    $("#actual-sales-choose-file").bind("click",function() {
        allPlanData=[];
        document.getElementById("actual-sales-acceptFile").click();
    });
    //绑定文件input方法
    document.getElementById("actual-sales-acceptFile").onchange=actualSalesAcceptFile;
    //覆盖导入按钮
    $("#actual-sales-cover-import").bind("click",function() {
        renewNewFileAcceptInput();
        allPlanData=[];
        document.getElementById("actual-sales-acceptFile").click();
    });
    //追加导入按钮
    $("#actual-sales-add-import").bind("click",function() {
        renewNewFileAcceptInput();
        document.getElementById("actual-sales-acceptFile").click();
    });
    //删除按钮
    $("#actual-sales-delete-import").bind("click",function(){
        allPlanData=[];
        //清空数据
        table.render({
            elem: '#actual-sales-table'
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


    /**
     * 导入的Excel内容展示在当前页面
     * @param obj
     */
    function showExcelDetailInHtml(obj) {
        //获得当前选中的年月
        var nowYearAndMonth = $("#actual-year-month").val();
        //当前年
        var nowYear = nowYearAndMonth.substring(0,4);
        //当前月
        var nowMonth = parseInt(nowYearAndMonth.substring(5,7));
        //不需要显示的月份
        var noNeedShowMonth=[];
        for(var i=nowMonth;i<12;i++){
            noNeedShowMonth.push(monthList[i]);
        }
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
                if(noNeedShowMonth.indexOf(keyArray[j])==-1){
                    //只显示到当前选中的月份
                    newData[formatWord(keyArray[j])]=data[i][keyArray[j]];
                }else{
                    //未选中的置空
                    newData[formatWord(keyArray[j])]="";
                }

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
            elem: '#actual-sales-table'
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

    function allowToUploadPlanData(){
        if(allPlanData.length>0){
            $("#upload-actual-sales").removeClass("layui-btn-disabled");
            $("#upload-actual-sales").bind("click",commitUploadPlanData);
        }
    }
    function forbidToUploadPlanData(){
        if(allPlanData.length==0){
            $("#upload-actual-sales").addClass("layui-btn-disabled");
            $("#upload-actual-sales").unbind();
        }
    }


    /**
     * 文件选择
     */
    function actualSalesAcceptFile(){
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

    //弹窗
    function alertFunction(title,content){
        layer.open({
            title: title
            ,content: content
        });
    }


    /**
     * AS-Creating确认提交
     */
    function commitUploadPlanData() {
        //开启loading
        layer.msg('上传中，请稍等', {
            time:0
            ,icon: 16
            ,shade: 0.01
        });
        var data={"actualSalesList":allPlanData,"year":$("#actual-year-month").val().substring(0,4),"month":$("#actual-year-month").val().substring(5,7)};
        $.ajax({
            url: "/cola/uploadActualSalesData.do",
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
                    layer.closeAll();
                    alertFunction("上传成功","success");
                }
            },
            error: function (data) {
                alertFunction("上传失败","请重试或联系管理员");
            }
        });
    }


    /**
     * 重新增加文件选择
     */
    function renewNewFileAcceptInput() {
        $("#actual-sales-acceptFile").remove();
        //可重复选择同一个Excel
        $(".bottom-actual-sales-creating-part").before('<input id="actual-sales-acceptFile" type="file" style="display: none;" accept="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet, application/vnd.ms-excel"/>');
        document.getElementById("actual-sales-acceptFile").onchange=actualSalesAcceptFile;
    }


    /**
     * Actual Sales Creating -> Report
     */
    $("#actual-sales-report").click(function () {
        $("#creating-part").hide();
        $("#report-part").show();
        $("#actual-sales").addClass("layui-this");
        //report年份初始化
        $("#actual-sales-report-year").val($("#actual-year-month").val());
        //初始化搜索下拉框
        initActualSalesReportSelect();
        getNowPageData();
    });

    /**
     * 初始化数据表单
     * @param page
     */
    function getNowPageData() {
        layer.msg('AS report in the query. . .', {
            time:0
            ,icon: 16
            ,shade: 0.01
        });
        var page ={"pageSize":"10","currentPage":"1"};
        var actualSalesInparameter ={
            "year":$("#actual-sales-report-year").val().substring(0,4),
            "month":$("#actual-sales-report-year").val().substring(5,7),
            "category":findData.category,
            "bpName":findData.bpName,
            "brand":findData.brand,
            "ppName":findData.ppName,
            "bg":findData.bg,
            "page":page
        };
        $.ajax({
            url: "/cola/selectActualSalesReportData.do",
            type: "post",
            data: JSON.stringify(actualSalesInparameter),
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
                    elem: '#actual-sales-report-data-table'
                    ,cols: [colsData]
                    ,data: data.result.records
                    ,cellMinWidth: 120
                    ,even: true
                });

                //初始化分页控件
                laypage.render({
                    elem: 'actual-sales-report-page'
                    ,count: data.result.totalRecord
                    ,layout: ['count', 'prev', 'page', 'next', 'refresh', 'skip']
                    ,jump: function(obj,first){
                        if(!first){
                            var page ={"pageSize":"10","currentPage":obj.curr};
                            actualSalesInparameter.page=page;
                            $.ajax({
                                url: "/cola/selectActualSalesReportData.do",
                                type: "post",
                                data: JSON.stringify(actualSalesInparameter),
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


    /**
     * 初始化Actual Sales的下拉框
     */
    function initActualSalesReportSelect() {
        $.ajax({
            url: "/cola/distinctActualSalesSelect.do",
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
     * 清空Actual Sales Report下拉框的内容，重新初始化
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
     * Actual Sales Report -> Creating
     */

    $("#actual-sales-creating").click(function () {
        $("#creating-part").show();
        $("#report-part").hide();
    });


    /**
     * 查询按钮
     */
    $("#inquireActualSalesReport").click(function () {
        getNowPageData();
    });



    /**
     * 导出按钮
     */
    $("#export").click(function () {
        var actualSalesInparameter ={
            "year":$("#actual-sales-report-year").val().substring(0,4),
            "month":$("#actual-sales-report-year").val().substring(5,7),
            "category":findData.category,
            "bpName":findData.bpName,
            "brand":findData.brand,
            "ppName":findData.ppName,
            "bg":findData.bg,
        };
        var url = "/cola/actualSalesReportExport.do?flag=1";
        if($("#actual-sales-report-year").val()!=null && $("#actual-sales-report-year").val()!=""){
            url=url+"&year="+$("#actual-sales-report-year").val().substring(0,4);
            url=url+"&month="+$("#actual-sales-report-year").val().substring(5,7);
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









});