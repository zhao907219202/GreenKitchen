var stepNum = 3;

function addOneRow(obj){
	var index = parseInt(obj.id)+1;
	document.getElementById(obj.id).id=index;
	$("#step_table").append("<tr><td style=\"width:150px\">" +
			"<img id=\"origin_"+index+"\"  onclick=\"imgClick(this)\" src=\"/GreenKitchen/images/issue/issue_step.jpg\" " +
			"style=\"width:140px;height:90px;\"/><img id=\"preview_"+index+"\" style=\"width:140px;height:90px;display:none\"/>"+
			"<input type=\"file\" name=\"files\" style=\"display:none\" id=\"upload_"+index+"\" onchange=\"imgPreview(this)\"/>" +
			"</td><td><textarea name=\"step_content_"+index+"\" rows=\"6\" cols=\"60\" style=\"resize: none;\"></textarea></td></tr>");
	stepNum = index;
}

function imgClick(obj){
	var origin = obj.id;
	var position = origin.indexOf("_");
	var index = origin.substring(position+1);
	document.getElementById("upload_"+index).click();
	
}

function imgPreview(fileDom){
	var upload = fileDom.id;
	var position = upload.indexOf("_");
	var index = upload.substring(position+1);
	
	document.getElementById("origin_"+index).style.display="none";
	document.getElementById("preview_"+index).style.display="";
    //判断是否支持FileReader
    if (window.FileReader) {
        var reader = new FileReader();
    } else {
        alert("您的设备不支持图片预览功能，如需该功能请升级您的设备！");
    }

    //获取文件
    var file = fileDom.files[0];
    var imageType = /^image\//;
    //是否是图片
    if (!imageType.test(file.type)) {
        alert("请选择图片！");
        return;
    }
    //读取完成
    reader.onload = function(e) {
        //获取图片dom
        var img = document.getElementById("preview_"+index);
        //图片路径设置为读取的图片
        img.src = e.target.result;
    };
    reader.readAsDataURL(file);
}

function findStepNum(){
	document.getElementById("stepNum").value = stepNum;
}