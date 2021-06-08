<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<p>
	<a href="/board/insert.jsp">insert</a>
	<a href="/board/update.jsp">update</a>
	<a href="/board/remove.jsp">remove</a>
	<a href="/board/read.jsp">read</a>
</p>
<p>${age}</p> <%-- RedirectAttrubutes 객체 addFlashAttrubute 사용 --%>
<p><%=request.getParameter("age1")%></p> <%-- RedirectAttrubutes 객체 addFlashAttrubute 사용 --%>
</body>
</html>
