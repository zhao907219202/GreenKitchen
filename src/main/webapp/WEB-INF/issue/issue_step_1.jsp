<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>绿色厨房</title>
	<link rel="stylesheet" type="text/css" href="/GreenKitchen/css/public/common.css" />
	<link rel="stylesheet" type="text/css" href="/GreenKitchen/css/issue/issue_step_1.css" />
	<script type='text/javascript' language="javascript">
	function checkValue(){
		var title=document.issue_step_1.title.value;
		if(title==""||title=="菜谱名称"){window.alert("请填写菜谱名称");return false;}
	}
	function imgClick(){
		document.getElementById("upload_input").click();
	}
	function imgPreview(fileDom){
		document.getElementById("origin").style.display="none";
		document.getElementById("preview").style.display="";
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
            var img = document.getElementById("preview");
            //图片路径设置为读取的图片
            img.src = e.target.result;
        };
        reader.readAsDataURL(file);
    }
	</script> 
</head>

<body>
	<jsp:include page="/WEB-INF/public/head.jsp" />
	
	<div class="main_body">
		<div class="title">
			<font class="font8">创建菜谱(Step 1)</font>
			<font class="font7">从现在起，不做孤独的美食家。</font>
		</div>
		<div class="issue_input">
			<form action="/GreenKitchen/issue/stepOne.action" method="post" enctype="multipart/form-data" name="issue_step_1">
			<input type="text" name="title" value="菜谱名称" style="width:595px;height:40px;"/>
			<img id="origin" onclick="imgClick()" src="/GreenKitchen/images/issue/cover.jpg" style="width:600px;height:400px;margin-top:15px;"/>
			<img id="preview" style="width:600px;height:400px;margin-top:15px;display:none"/>
			<input type="file" name="recipe_pic" style="display:none" id="upload_input" onchange="imgPreview(this)"/>
			<div class="issue_diff_time">
				<font class="font7">烹饪难度：</font>
				<select name="difficulty">
					<option value="切墩(初级)" selected="selected">切墩(初级)</option>
					<option value="配菜(中级)">配菜(中级)</option>
					<option value="掌勺(高级)">掌勺(高级)</option>
				</select>　
				<font class="font7">烹饪时间：</font>
				<select name="time">
					<option value="10分钟左右" selected="selected">10分钟左右</option>
					<option value="10-30分钟">10-30分钟</option>
					<option value="30-60分钟">30-60分钟</option>
					<option value="1小时以上">1小时以上</option>
				</select>
			</div>
			<div class="recipe_description">
				<textarea name="description" rows="10" cols="82" style="resize:none;">这道菜背后的故事(选填)...</textarea>
			</div>
			<div class="submit_button">
				<input type="submit" value="点击进入下一步" style="width:200px;height:40px;" onclick="return checkValue()"/>
			</div>
			</form>
		</div>
	
	</div>
	
	
	<div style="float:left;margin-left: 400px;margin-top: 20px;"><jsp:include page="/WEB-INF/public/foot.jsp" /></div>
</body>
</html>
