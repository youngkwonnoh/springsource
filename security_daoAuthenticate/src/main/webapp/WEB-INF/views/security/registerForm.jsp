<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/css/bootstrap.min.css" />
<link rel="stylesheet" href="/resources/css/login.css" />
</head>
<body>
	<div class="container center-contents">
		<div class="row">
			<form class="form-signin" name="loginform" action="register" method="post">
				<h1 class="h3 mb-3 font-weight-normal">회원가입</h1>
				<div class="form-group">
					<label for="userid">아이디</label>
					<input type="text" id="userid" name="userid" class="form-control"
						placeholder="아이디를 입력해 주세요" required autofocus> 
				</div>
				<div class="form-group">
					<label for="password">비밀번호</label>
					<input type="password" id="password" name="password" class="form-control" 
						placeholder="비밀번호를 입력해 주세요" required>
				</div>
				<div class="form-group">
					<label for="email">이메일</label>
					<input type="email" id="email" name="email" class="form-control" 
						placeholder="이메일을 입력해 주세요" required>
				</div>
				<div class="form-group">
					<button class="btn btn-lg btn-primary btn-black" type="submit">회원가입</button>
				</div>
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			</form>
		</div>
	</div>
</body>
</html>