<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Login</title>
<link rel="stylesheet" href="../resources/login.css">
</head>
<body>
<div class="wrapper">
	<form role="form" method="post" autocomplete="off" action="/msweb/admin/login">
		<div class="wrap">
			<div class="logo_wrap">
				<span>직원 관리 시스템 로그인</span>
			</div>
			<div class="id_wrap">
				<label class="id_name" for="id">아이디</label>
				<div class="id_input_box">
					<input class="id_input" type="text" id="id" name="id"/>
				</div>
			</div>
			<div class="pw_wrap">
				<label class="pw_name" for="pw">비밀번호</label>
				<div class="pw_input_box">
					<input class="pw_input" type="password" id="pw" name="pw"/>
				</div>
			</div>
			<div class="login_button_wrap">
			<button class="login_button" type="submit">로그인</button>
			</div>
			<div align=center>
				<c:url value="/" var="url"/><a href="${url}">메인 페이지 돌아가기</a>
			</div>
		</div>
	</form>
</div>
<c:if test="${msg==false}">
	<p style="color:#f00;">로그인에 실패하였습니다. 아이디 또는 패스워드를 다시 입력해주세요.</p>
</c:if>
</body>
</html>