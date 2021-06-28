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
<meta charset="UTF_8">
<title>插入</title>
<link href = "../css/style.css" type="text/css" rel="stylesheet"/>
</head>
<body>
	<div class="header">
 		<h1>数据库设计lab4——插入操作返回页面</h1>
	</div>

	<div class="topnav">
  		<a href="show_db.jsp">查看数据库数据</a>
 	 	<a href="index.jsp">返回数据库操作</a>
	</div>

	<h1>数据库操作结果</h1>
	<h2>
		<%
			String username = (String)application.getAttribute("username1");
			Integer flagtemp = (Integer)application.getAttribute("flag");
			int flag = flagtemp.intValue();
			if(flag == 1) out.println("更新成功："+username);
			else out.println("插入成功："+username);
		%>
	</h2>
		
</body>
</html>
