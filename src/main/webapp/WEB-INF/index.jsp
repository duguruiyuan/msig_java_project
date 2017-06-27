<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
</head>
<body>
	Hello ${ip}, ${user_data.username}, ${user_data.loginTime}

	<form action="<c:url value="/logout"/>" method="post">
		<button type="submit">登出</button>
	</form>
</body>
</html>
