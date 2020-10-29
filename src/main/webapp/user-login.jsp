
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>E-Commerce Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
	<link rel="stylesheet" href="css/style.css">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: blue">
			<div>
				<a href="" class="navbar-brand"> E-Library Application </a>
			</div>

			<ul class="navbar-nav">

			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">

				<form action="Login" method="post">
				<caption>
					<h2>
						Login
					</h2>
				</caption>

				<fieldset class="form-group">
					<label>User Name</label> <input type="text"
						 class="form-control"
						name="username" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Password</label> <input type="password"
						 class="form-control"
						name="password" required="required">
				</fieldset>

				<button type="submit" class="btn btn-success">Login</button>
				</form>
			</div>
		</div>
	</div>
</body>

</html>