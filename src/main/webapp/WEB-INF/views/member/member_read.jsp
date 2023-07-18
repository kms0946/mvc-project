<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>학생 정보</title>
	<link rel="stylesheet" href="../resources/member.css" type="text/css"></link>
</head>
<body>
	<div align=center>
		<header>직원 정보</header><br>
		<table>
		    <tr><th> LoginID </th><td><c:out value="${member.id}"/></td></tr>
			<tr><th> LoginPWD </th><td><c:out value="${member.passwd}"/></td></tr>
			<tr><th> YourName </th><td><c:out value="${member.username}"/></td></tr>
			<tr><th> EmailNumber </th><td><c:out value="${member.email}"/></td></tr>
		</table>
		<c:url value="/member/list" var="url"/><a href="${url}">직원 목록 보기</a>
	</div>
</body>
</html>