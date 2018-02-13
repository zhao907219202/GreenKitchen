var xmlrequest;
function createXMLHttpRequest() {
	
	if (window.ActiveXObject) {
		xmlrequest = new ActiveXObject("Microsoft.XMLHTTP");
	} else {
		xmlrequest = new XMLHttpRequest();
		
	}
}

function doConcern() {
	var user_id = document.getElementById("user_id").value;
	createXMLHttpRequest();
	if (xmlrequest) {
		//准备发送请求
		var req = "/ajax/doConcern.action?user_id="+user_id;
			//打开请求
		xmlrequest.open("get", req, true);
			//指定处理结果的函数
		xmlrequest.onreadystatechange = handleConcern;
			//发送请求
		xmlrequest.send();
	}
}

function handleConcern(){
	if (xmlrequest.readyState == 4) {
		if (xmlrequest.status == 200) {
				var result=xmlrequest.responseText.toString();
				if(result=="true"){
					alert("关注成功");
					$("#cancelConcern").show();
					$("#doConcern").hide();
				}
				else if(result=="false"){
					alert("请先登录！");
					window.location.href="/info/goLoginView.action";
				}
			}
		}
}

function cancelConcern() {
	var user_id = document.getElementById("user_id").value;
	createXMLHttpRequest();
	if (xmlrequest) {
		//准备发送请求
		var req = "/ajax/cancelConcern.action?user_id="+user_id;
			//打开请求
		xmlrequest.open("get", req, true);
			//指定处理结果的函数
		xmlrequest.onreadystatechange = handleCancelConcern;
			//发送请求
		xmlrequest.send();
	}
}

function handleCancelConcern(){
	if (xmlrequest.readyState == 4) {
		if (xmlrequest.status == 200) {
			var result=xmlrequest.responseText.toString();
			if(result=="true"){
				alert("取消关注成功");
				$("#cancelConcern").hide();
				$("#doConcern").show();
			}
			else if(result=="false"){
				alert("请先登录！");
				window.location.href="/info/goLoginView.action";
			}
		}
	}
}


function judgeHasConcerned(){
	var hasConcerned = document.getElementById("hasConcerned").value;
	if(hasConcerned=="yes"){
		$("#cancelConcern").show();
		$("#doConcern").hide();
	}else if(hasConcerned=="no"){
		$("#cancelConcern").hide();
		$("#doConcern").show();
	}
		
}
