<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/css/bootstrap.min.css"/>
<link rel="stylesheet" href="/resources/css/index.css"/>
</head>
<body>
	<div class="container center-contents">
		<div class="row">
			<h1 class="title display-5">메인페이지</h1>
		</div>
		<div class="links">
		<%-- !isAuthenticated() : 인증된 사용자라면 true --%>
			<sec:authorize access="!isAuthenticated()">
				<div class="link">
					<a href="/login">로그인</a>
				</div>
			</sec:authorize>
			<sec:authorize access="isAuthenticated()">
				<div class="link">
					<a href="/user-page">유저페이지</a>
				</div>
			</sec:authorize>
			<sec:authorize access="isAuthenticated()">
				<div class="link">
					<a href="/admin-page">관리자 페이지</a>
				</div>
			</sec:authorize>
			<sec:authorize access="isAuthenticated()">
				<div class="link">
					<form action="/logout" method="post">
						<button class="btn btn-info" type="submit">로그아웃</button>
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
					</form>
				</div>
			</sec:authorize>
		</div>
	</div>
</body>
</html>