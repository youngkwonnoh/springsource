<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${test}
	<h1>로그인 값 출력</h1>
	<ul>
		<!-- LoginVO => loginVO -->
		<%--
		<li>userid : ${loginVO.userid}</li>
		<li>password : ${loginVO.password}</li>
		 --%>
		
		<%-- ModelAttribute 사용 --%>
		<li>userid : ${vo.userid}</li>
		<li>password : ${vo.password}</li>
		<li>page : ${page}</li>
		
		
	</ul>		
</body>
</html>