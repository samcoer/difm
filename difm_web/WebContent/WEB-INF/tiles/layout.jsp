<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ page errorPage="/jsp/jsp-exception.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>
		<tiles:insertAttribute name="title" ignore="true" />
	</title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/shadowbox.css">
	<script>
		//	window.history.forward(1);
		document.attachEvent("onkeydown", my_onkeydown_handler);
		function my_onkeydown_handler(){
			switch (event.keyCode){
				case 27 : // 'ESC'
					event.returnValue = false;
					event.keyCode = 0;
					window.status = "We have disabled ESC Key";
					break;
			}
		}
	</script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/shadowbox.js"></script>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/main.css"/>
</head>
<body bgcolor="#ffffff" onload="highlightSelectedTreeNode();my_onkeydown_handler();">
	<div id="header">
		<tiles:insertAttribute name="header"/>
	</div>
	<div id="content">
		<tiles:insertAttribute	name="content"/>
	</div>
	<div id="footer">
		<tiles:insertAttribute name="footer"/>
	</div>
</body>
</html>