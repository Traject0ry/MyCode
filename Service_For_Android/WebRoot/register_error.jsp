<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

<title>My JSP 'login_error.jsp' starting page</title>

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

<body>
	Register Failed!!
	<br>用户名已被占用
	<p style="text-indent: 2em; margin-top: 30px;">
		系统将在 <span id="time">5</span> 秒钟后自动跳转至新网址，如果未能跳转，<a href="/Service_For_Android/index.html"
			title="点击访问">请点击</a>。
	</p>
	<script type="text/javascript">  
    delayURL();    
    function delayURL() { 
        var delay = document.getElementById("time").innerHTML;
 var t = setTimeout("delayURL()", 1000);
        if (delay > 0) {
            delay--;
            document.getElementById("time").innerHTML = delay;
        } else {
     clearTimeout(t); 
            window.location.href = "/Service_For_Android/index.html";
        }        
    } 
</script>
	

</body>
</html>
