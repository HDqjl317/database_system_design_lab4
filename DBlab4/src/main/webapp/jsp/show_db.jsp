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
	<title>查看数据库</title>
	<link href = "../css/style.css" type="text/css" rel="stylesheet"/>
</head>

<body background = "../img/2p.jpg">
	<div class="header">
 		<h1>数据库设计lab4——数据库数据表展示页面</h1>
	</div>

	<div class="topnav">
  		<a href="show_db.jsp">查看数据库数据</a>
 	 	<a href="index.jsp">返回数据库操作</a>
	</div>


	<h1>数据表users信息</h1>
	<table>
		<tr>
			<th style="font-size:20pt">用户名</th>
			<th style="font-size:20pt">密码</th>
		</tr>
	
	<%
		String sql = "select * from users";
		ConnectMysql con1 = new ConnectMysql();
		Statement state = con1.getCon().createStatement();
		ResultSet rs = state.executeQuery(sql);
		while(rs.next()) {
			String username = rs.getString(1);
	   	 	String pass = rs.getString(2);
	%>
	    	<tr>
	    		<td><%= username %></td>
	    		<td><%= pass %></td>
	    	</tr>
	<%
		}
		rs.close();
		state.close();
	%>	
	</table>
	<br>
	<h1>数据表persons信息</h1>
	<table>
		<tr>
			<th style="font-size:20pt">姓名</th>
			<th style="font-size:20pt">用户名</th>
			<th style="font-size:20pt">年龄</th>
			<th style="font-size:20pt">电话号码</th>
		</tr>
	
	<%
		String sql1 = "select username,name,age,teleno from persons";
		ConnectMysql con2 = new ConnectMysql();
		Statement state1 = con2.getCon().createStatement();
		ResultSet rs1 = state1.executeQuery(sql1);
		
		
		while(rs1.next()) {
			String username = rs1.getString(1);
		    String name = rs1.getString(2);	
		    Integer age = rs1.getInt(3);
		    String sage = String.valueOf(age);
		    if(age==0) sage = "";	
		    String teleno = rs1.getString(4);
		    if(teleno.length()==0) teleno = "";		
	%>
	    	<tr>
	    		<td><%= name %></td>
	    		<td><%= username %></td>
	    		<td><%= sage %></td>
	    		<td><%= teleno %></td>
	    	</tr>
	<%
		}
		rs1.close();
		state1.close();
	%>	
	</table>
	
</body>
</html>
