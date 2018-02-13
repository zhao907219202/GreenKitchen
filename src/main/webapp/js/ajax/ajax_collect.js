var xmlrequest;
function createXMLHttpRequest() {
	
	if (window.ActiveXObject) {
		xmlrequest = new ActiveXObject("Microsoft.XMLHTTP");
	} else {
		xmlrequest = new XMLHttpRequest();
		
	}
}

function doCollect() {
	var recipe_id = document.getElementById("recipe_id").value;
	createXMLHttpRequest();
	if (xmlrequest) {
		//准备发送请求
		var req = "/ajax/doCollect.action?recipe_id="+recipe_id;
			//打开请求
		xmlrequest.open("get", req, true);
			//指定处理结果的函数
		xmlrequest.onreadystatechange = handleCollect;
			//发送请求
		xmlrequest.send();
	}
}

function handleCollect(){
	if (xmlrequest.readyState == 4) {
		if (xmlrequest.status == 200) {
				var result=xmlrequest.responseText.toString();
				if(result=="true"){
					alert("收藏成功");
					$("#cancelCollect").show();
					$("#doCollect").hide();
				}
				else if(result=="false"){
					alert("请先登录！");
					window.location.href="/info/goLoginView.action";
				}
			}
		}
}

function cancelCollect() {
	var recipe_id = document.getElementById("recipe_id").value;
	createXMLHttpRequest();
	if (xmlrequest) {
		//准备发送请求
		var req = "/ajax/cancelCollect.action?recipe_id="+recipe_id;
			//打开请求
		xmlrequest.open("get", req, true);
			//指定处理结果的函数
		xmlrequest.onreadystatechange = handleCancelCollect;
			//发送请求
		xmlrequest.send();
	}
}

function handleCancelCollect(){
	if (xmlrequest.readyState == 4) {
		if (xmlrequest.status == 200) {
			var result=xmlrequest.responseText.toString();
			if(result=="true"){
				alert("取消收藏成功");
				$("#cancelCollect").hide();
				$("#doCollect").show();
			}
			else if(result=="false"){
				alert("请先登录！");
				window.location.href="/info/goLoginView.action";
			}
		}
	}
}


function judgeHasCollected(){
	var hasCollected = document.getElementById("hasCollected").value;
	if(hasCollected=="yes"){
		$("#cancelCollect").show();
		$("#doCollect").hide();
	}else if(hasCollected=="no"){
		$("#cancelCollect").hide();
		$("#doCollect").show();
	}
		
}
