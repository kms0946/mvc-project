<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<title>직원 관리 프로그램</title>
<link rel="stylesheet" href="../resources/member.css" type="text/css"></link>
</head>
<body>
	<form role="form" method="post" autocomplete="off" action="../admin/login">
 <p>
  <label for="userId">아이디</label>
  <input type="text" id="id" name="id" />
 </p>
 <p>
  <label for="userPass">아이디</label>
  <input type="password" id="pw" name="pw" />
 </p>
 <p><button type="submit">로그인</button></p>
 <p><a href="/msweb/admin/register">회원가입</a></p>
</form>
<p>${admin.name}님 환영합니다</p>
</body>
</html>