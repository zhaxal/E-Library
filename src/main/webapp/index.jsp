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
    <jsp:include page="nav-bar-public.jsp" />
</header>
<br>

<div class="row">


    <div class="container">
        <h3 class="text-center"><%=
        request.getAttribute( "welcome" )
        %></h3>

        <h4 class="text-center"><%= request.getAttribute( "shop" ) %></h4>
        <h5 class="text-center"><%= request.getAttribute( "part" ) %> <%= request.getAttribute( "cars" ) %></h5>

    </div>
</div>
</body>
</html>