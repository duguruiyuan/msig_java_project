<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
</head>
<body>
	<form action="<c:url value="/login"/>" method="post">
		<label for="username">帳號</label>
		<input id="username" name="username">
		<br>
		<label for="password">密碼</label>
		<input id="password" name="password">
		<br>
		<button type="submit">登入</button>
	</form>
</body>
</html>
