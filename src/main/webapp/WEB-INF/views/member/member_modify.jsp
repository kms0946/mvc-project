<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>정보 수정</title>
	<link rel="stylesheet" href="../resources/member.css" type="text/css"></link>
</head>
<body>
	<div align=center>
		<header>직원 정보 수정</header>
		<form name=form1 action="../member/modify/" method="post">
		<table>
			<tr><th>LoginID</th><td><input type="text" name="id" readonly value="${student.id}"></td></tr>
			<tr><th>LoginPWD</th><td><input type="text" name="passwd" value="${student.passwd}"></td></tr>
			<tr><th>YourName</th><td><input type="text" name="username" value="${student.username}"></td></tr>
			<tr><th>EmailAddress</th><td><input type="text" name="email" value="${student.email}"></td></tr>
		</table><br>
			<input type="submit" name="submit" value="최종 수정">
			<input type="reset" name="reset" value="다시작성">
		</form>
	</div>
</body>
</html>