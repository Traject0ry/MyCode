<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'change.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript" src="js/jquery-1.9.0.min.js"></script>
<script type="text/javascript" src="images/login.js"></script>
<link href="css/login2.css" rel="stylesheet" type="text/css" />
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<%
	String id = request.getParameter("id");
%>

<body>

	<h1>请输入你要修改的简历</h1>
	<div>
		<s:form action="update.action" method="post">
		<input type="hidden" name="id" value="<%=id %>"/>
  请填写简介：<s:textarea name="information" style="width:200px;height:80px;"></s:textarea>
			<br>

			<s:submit value="上传" style="margin-top:10px;margin-left:85px;"
				cssClass="button_blue" />
		</s:form>
	</div>
</body>
</html>
