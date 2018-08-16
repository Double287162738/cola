
var wb;//读取完成的数据
var rABS = false; //是否将文件读取为二进制字符串
$(function () {



})

function previewExcel(obj) {
    if(!obj.files) {
        return;
    }
    var fileName = obj.value;
    var fileFormat=fileName.substring(fileName.lastIndexOf("."),fileName.length);
    console.log("fileFormat:"+fileFormat);
    if(fileFormat!=".xls" && fileFormat!=".xlsx"){
        alert("请选择正确的Excel文件");
        return;
    }
    var f = obj.files[0];
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
        //wb.SheetNames[0]是获取Sheets中第一个Sheet的名字
        //wb.Sheets[Sheet名]获取第一个Sheet的数据
        //将json展示
        showExcelDetailInHtml(JSON.stringify( XLSX.utils.sheet_to_json(wb.Sheets[wb.SheetNames[0]]) ));
        document.getElementById("demo").innerHTML= JSON.stringify( XLSX.utils.sheet_to_json(wb.Sheets[wb.SheetNames[0]]) );
    };
    if(rABS) {
        reader.readAsArrayBuffer(f);
    } else {
        reader.readAsBinaryString(f);
    }
}

function fixdata(data) {
    var o = "",
        l = 0,
        w = 10240;
    for(; l < data.byteLength / w; ++l) o += String.fromCharCode.apply(null, new Uint8Array(data.slice(l * w, l * w + w)));
    o += String.fromCharCode.apply(null, new Uint8Array(data.slice(l * w)));
    return o;
}
function showExcelDetailInHtml(obj) {
    console.log(obj);
    var data = JSON.parse(obj);
    console.log("长度："+data.length);
    var keyArray=[];
    for(var key in data[0]){
        keyArray.push(key);
    }
    console.log("表头："+keyArray);
}

function choseFile() {
    document.getElementById("acceptFile").click();
}