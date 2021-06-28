<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import = "netlink.*" %>
<%@ page import = "table.*" %>
<%@ page import = "operate.*" %>
<%@ page import = "java.sql.*" %>
<%@ page import = "servlet.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>删除</title>
<link href = "../css/style.css" type="text/css" rel="stylesheet"/>
</head>
<body>
	<div class="header">
 		<h1>数据库设计lab4——删除操作返回页面</h1>
	</div>

	<div class="topnav">
  		<a href="show_db.jsp">查看数据库数据</a>
 	 	<a href="index.jsp">返回数据库操作</a>
	</div>

	<% 
		String username = (String)application.getAttribute("username2");
		Integer flagtemp =(Integer)application.getAttribute("flag1");
		int flag = flagtemp.intValue();
	%>
	<h1>数据库操作结果</h1>
	<h2>
		<%
			if(flag == 1) out.println("删除成功："+username);
			else out.println("删除失败，"+username+"不存在");
		%>
	</h2>
</body>
</html>
