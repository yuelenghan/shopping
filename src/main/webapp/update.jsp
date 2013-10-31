<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
<script type="text/javascript" src="script/jquery-1.7.2.js"
	charset="utf-8"></script>
<script type="text/javascript" src="script/login.js" charset="utf-8"></script>
</head>
<body>
	<form action="register.do" method="post">
		<table align="center">
			<tr>
				<td>用户名：</td>
				<td>
					<input type="text" name="userName" id="userName" value="${param.userName}"/>
					<span id="result"></span>
				</td>
			</tr>
			<tr>
				<td>年&nbsp&nbsp龄：</td>
				<td><input type="password" name="password" id="password"/></td>
			</tr>
			<tr>
				<td>手&nbsp&nbsp机：</td>
				<td><input type="text" name="phone" id="phone" onblur="checkPhone()"/></td>
			</tr>
			<tr>
				<td>地&nbsp&nbsp址</td>
				<td><textarea rows="5" cols="30"></textarea></td>
			</tr>
			<tr>
				<td><input type="submit" value="注册" /></td>
				<td><input type="reset" value="撤销" /></td>
			</tr>
		</table>
	</form>
</body>
</html>