<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Login</title>
</head>
<body>
	<h1>�α���</h1>
	<hr>
	<form action="login.do" method="post">
		<table border="1">
			<tr>
				<td>���̵�</td>
				<td><input type="text" name="id" /></td>
			</tr>
			<tr>
				<td>��й�ȣ</td>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="�α���" /></td>
			</tr>
		</table>
	</form>
</body>
</html>