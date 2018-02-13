var xmlrequest;
function createXMLHttpRequest() {
	
	if (window.ActiveXObject) {
		xmlrequest = new ActiveXObject("Microsoft.XMLHTTP");
	} else {
		xmlrequest = new XMLHttpRequest();
		
	}
}

function checkName() {
	createXMLHttpRequest();
	if (xmlrequest) {
		//准备发送请求
		//window.alert($('input[name=name]').val());
		var req = "/CheckUserName?name=" +$('input[name=name]').val();
			//打开请求
		xmlrequest.open("get", req, true);
			//指定处理结果的函数
		xmlrequest.onreadystatechange = showResult;
			//发送请求
		xmlrequest.send();
	}
}
var staticResult;
function showResult(){
	if (xmlrequest.readyState == 4) {
		if (xmlrequest.status == 200) {
				var result=xmlrequest.responseText.toString();
				if(result=="true"){
					$("#true").show();
					staticResult="true";
				}
				else if(result=="false"){
					$("#false").show();
					staticResult="false";
				}
			}
		}
}

function hide(){
	$("#false").hide();
	$("#true").hide();
}

function submitCheck(){
	if(staticResult=="false"){
		window.alert("用户名已存在，请更改")
		return false;
	}
}