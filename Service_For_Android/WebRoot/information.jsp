<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>My JSP 'information.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript" src="js/jquery-1.9.0.min.js"></script>
<script type="text/javascript" src="images/login.js"></script>
<link href="css/login2.css" rel="stylesheet" type="text/css" />
<style type="text/css">
#links_foot {
	font-size: 12px;
	margin: 5px 0px 0px 0px;
	padding: 0px;
	position: relative;
}

#links_foot ul {
	list-style-type: none;
	padding: 0px;
	margin: 0px;
	width: 950px;
}

#links_foot ul li {
	text-align: center;
	width: auto;
	display: block;
	padding-left: 4px;
	padding-right: 4px;
	float: left;
	border-right: dotted;
	color: #D4D0C8;
	border-width: 1px;
}

#links_foot .First {
	padding-left: 100px;
}

#links_foot br {
	display: none;
}

#links_foot_first a:link {
	font-size: 16px;
	color: #FF9933;
}
</style>
</head>

<body>
	</table>
	<center>
		<h1>简历资讯</h1>
		<table border="1" width="400">
			<tr>
				<th>姓名</th>
				<th>简历</th>
				<th>照片</th>
			</tr>

			<s:iterator value="#request.infoList" id="st">
				<tr>
					<td align="center" id="name"><s:property value="#st.name" /></td>
					<td align="center" width="500" id="information"><s:property
							value="#st.information" /></td>
					<td align="center" id="path"><img
						src='<s:property value="#st.url" />' height="100" width="100"></td>
					<td><a href="change.jsp?id=<s:property value='#st.id'/>">更新</a></td>

				</tr>
			</s:iterator>
		</table>
	</center>
	<div id="links_foot">
		<ul>
			<li id="links_foot_first"><a href="addInformation.jsp">添加简历信息</a></li>
			<li id="links_foot_first"><a href="index.html">退出登录</a></li>
		</ul>
	</div>
</body>
</html>
