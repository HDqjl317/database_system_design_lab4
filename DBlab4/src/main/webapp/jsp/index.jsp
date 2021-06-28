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
	<title>CodeFriday</title>
	<link href = "../css/style.css" type="text/css" rel="stylesheet"/>
</head>

<body background = "../img/2p.jpg">
	<div class="header">
 		<h1>数据库设计lab4——数据库操作页面</h1>
	</div>

	<div class="topnav">
  		<a href="show_db.jsp">查看数据库数据</a>
 	 	<a href="index.jsp">返回数据库操作</a>
	</div>

	<br><br><br>
	<form action = "../AddPerson" onsubmit="return check();" method="post">
		<table>
			<tr><th colspan="8" style="font-size:20pt">数据表persons插入信息</th></tr>
			<tr>
				<td ><b>用户名 </b></td>
				<td width="500px">
					<input 	onkeyup="value=value.replace(/[^\a-\z\A-\Z0-9]/g,'')" 
							onpaste="value=value.replace(/[^\a-\z\A-\Z0-9]/g,'')" 
							oncontextmenu = "value=value.replace(/[^\a-\z\A-\Z0-9]/g,'')"
							style="font-size:18pt;width:500px;" required="required" placeholder="请输入10个以内的字符" 
							maxlength="10" type="text" name ="username"/>
				</td>
			</tr>
			<tr>
				<td><b>姓名</b></td>
				<td width="500px">
					<input 	onkeyup="value=value.replace(/[^\a-\z\A-\Z0-9\u4E00-\u9FA5]/g,'')" 
							onpaste="value=value.replace(/[^\a-\z\A-\Z0-9\u4E00-\u9FA5]/g,'')" 
							oncontextmenu = "value=value.replace(/[^\a-\z\A-\Z0-9\u4E00-\u9FA5]/g,'')"
							style="font-size:18pt;width:500px;" required="required" placeholder="请输入20个以内的字符" 
							maxlength="20" type="text" name ="name"/>
				</td>
			</tr>
			<tr>
				<td><b>年龄</b></td>
				<td width="500px">
					<input 	style="font-size:18pt;width:500px;" placeholder="请输入一个整数" type="text" 
							id = "age"name ="age"/>
				</td>
			</tr>
			<tr>
				<td><b>电话号码</b></td>
				<td width="500px">
					<input 	onkeyup="value=value.replace(/[^0-9]/g,'')" 
							onpaste="value=value.replace(/[^0-9]/g,'')" 
							oncontextmenu = "value=value.replace(/[^0-9]/g,'')"
							style="font-size:18pt;width:500px;" placeholder="请输入11个字符" type="text" 
							maxlength="11"name ="teleno"id = "teleno"/>
				</td>
			</tr>
			<tr>
				<td colspan="8">
					<input style="font-size:18pt" type="reset" value = "清空">
					<input style="font-size:18pt" type="submit" value = "插入">
				</td>
			</tr>
		</table>
		<br>
	</form>
	
	<script type="text/javascript" >
		function check()
		{	
			var jude = 0;
			var n = document.getElementById("age");
			var reg=/^(?:[1-9][0-9]?|1[01][0-9]|120)$/;
			n = n.value;
			if(n.length == 0) jude = 1;
			if(!reg.test(n)&&jude==0){
				alert("年龄必须为1-100整数");
				return false;
			}
			return true;
		}

	</script>
	
	<form action = "../Deleteuser" onsubmit="return notice();" method="GET">
		<table>
			<tr><th colspan="8" style="font-size:20pt">数据表users删除信息</th></tr>
			<tr>
				<td><b>用户名</b></td>
				<td width="500px">
					<input 	onkeyup="value=value.replace(/[^\a-\z\A-\Z0-9\u4E00-\u9FA5]/g,'')" 
							onpaste="value=value.replace(/[^\a-\z\A-\Z0-9\u4E00-\u9FA5]/g,'')" 
							oncontextmenu = "value=value.replace(/[^\a-\z\A-\Z0-9\u4E00-\u9FA5]/g,'')"
							style="font-size:18pt;width:500px;" required="required" placeholder="请输入10个以内的字符" 
							maxlength="10" type="text" name ="username"/>
				</td>
			</tr>
			<tr>
				<td colspan="8">
					<input style="font-size:18pt" type="reset" value = "清空">
					<input style="font-size:18pt" type="submit" value = "删除">
				
				</td>
			</tr>
		</table>
	</form>
	
	<script type="text/javascript">
		function notice()
		{
			var r=confirm("您确定要删除？");
			return r;
		}
	</script>
	<br><br>

	</body>
</html>

