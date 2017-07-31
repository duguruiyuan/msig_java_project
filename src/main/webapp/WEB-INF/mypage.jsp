<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">
</head>
<body>

	<form action='<c:url value="/my_page"/>' method="get">

		<div class="container-fluid">
			<div class="row">
				<div class="col-md-12">
					<form role="form">
						<div class="form-group">

							<label for="employeeId"> 員工編號  </label> <input
								type="text" class="form-control" name = "employeeId" id="employeeId" />
						</div>
						<div class="form-group">

							<label for="name"> 姓名 </label> <input
								type="text" class="form-control" name = "name" id="name" />
						</div>
						<div class="form-group">

							<label for="departmentId"> 部門  </label> <input
								type="text" class="form-control" name = "departmentId" id="departmentId" />
						</div>
						<div class="form-group">

							<label for="email"> email  </label> <input
								type="email" class="form-control" name = "email" id="email" />
						</div>
						<div class="form-group">

							<label for="phoneNumber"> 電話號碼  </label> <input
								type="text" class="form-control" name = "phoneNumber" id="phoneNumber" />
						</div>
						<div class="form-group">

							<label for="hireDate"> 到職日  </label> <input
								type="text" class="form-control" name = "hireDate" id="hireDate" />
						</div>						
						<div class="form-group">

							<label for="jobId"> 職別  </label> <input
								type="text" class="form-control" name = "jobId" id="jobId" />
						</div>	
						<div class="form-group">

							<label for="managerId"> 主管  </label> <input
								type="text" class="form-control" name = "managerId" id="managerId" />
						</div>	
						<div class="form-group">

							<label for="password"> 密碼 </label> <input
								type="password" class="form-control" name = "password" id="password" />
						</div>						

						<button type="submit" class="btn btn-default">存檔</button>
					</form>
				</div>
			</div>
		</div>

	</form>


</body>

<script type="text/javascript"
	src='<c:url value="/resources/jquery-3.2.1.min.js" />'></script>
<script type="text/javascript"
	src='<c:url value="/resources/bootstrap.min.js" />'></script>
<script type="text/javascript" src='<c:url value="/resources/npm.js" />'></script>


</html>
