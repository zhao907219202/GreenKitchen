<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<style type="text/css">
* {
	margin: 0;
	padding: 0
}

#imgslide {
	margin: 0px auto;
	height: 296 px;
	width: 1000px;
	position: relative;
	-moz-user-select: none
}

#imgslide img {
	margin-left:30px;
	height: 296px;
	width: 940px
}

#imgslide #pre {
	position: absolute;
	display: block;
	height: 100%;
	background: #003366;
	filter: Alpha(Opacity = 0);
	opacity: 0;
	left: 0;
	top: 0;
	z-index: 2;
	width: 50%;
	cursor: url(${pageContext.request.contextPath}/images/index/pre.cur), auto;
}

#imgslide #next {
	position: absolute;
	z-index: 2;
	display: block;
	background: #00CC99;
	filter: Alpha(Opacity = 0);
	opacity: 0;
	height: 100%;
	width: 50%;
	top: 0;
	right: 0;
	cursor: url(${pageContext.request.contextPath}/images/index/next.cur), auto;
}
-->
</style>
</head>

<body>
	<div id="imgslide">
		<span id="pre"></span> <span id="next"></span><img id="showimg"
			src="${pageContext.request.contextPath}/images/index/index_1.jpg" />
	</div>
	<script type="text/javascript">
		$ = function(obj) {
			return document.getElementById(obj);
		};

		//图片地址
		var imgsrc = new Array();
		imgsrc[0] = "${pageContext.request.contextPath}/images/index/index_1.jpg";
		imgsrc[1] = "${pageContext.request.contextPath}/images/index/index_2.jpg";
		imgsrc[2] = "${pageContext.request.contextPath}/images/index/index_3.jpg";
		imgsrc[3] = "${pageContext.request.contextPath}/images/index/index_4.jpg";

		//图片预加载
		var arr = new Array();
		for (var i = 1; i <= imgsrc.length; i++) {
			arr[i] = new Image();
			arr[i].src = imgsrc[i];
			arr[i].onload;
		}

		i = 0;

		$("next").onclick = function() {
			i++;
			if (i >= imgsrc.length) {
				i = 0;
			}
			$("showimg").setAttribute("src", imgsrc[i]);
			$("intro").innerHTML = title[i];
		};

		$("pre").onclick = function() {
			i--;
			if (i < 0) {
				i = imgsrc.length - 1;
			}
			$("showimg").setAttribute("src", imgsrc[i]);
			$("intro").innerHTML = title[i];

		};
	</script>
</body>
</html>
