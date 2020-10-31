<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>E-Library Application</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<header>
    <%
        int admin = (Integer) session.getAttribute("isAdmin");

        if (admin == 1){
    %>
    <jsp:include page="nav-bar-admin.jsp" />
    <%
        }else{
    %>
    <jsp:include page="nav-bar.jsp" />
    <%
        }
    %>
</header>
<br>

<div class="row">


    <div class="container">
        <h3 class="text-center">Profile page</h3>
    </div>
    <div class="container text-left">
        <h5 class="text-left">Username: <%= session.getAttribute("username2") %></h5>
        <h5 class="text-left">Name: <%= session.getAttribute("name2") %></h5>
        <h5 class="text-left">Email: <%= session.getAttribute("email2") %></h5>
    </div>
    <br>
    <br>
    <div class="container text-left">
        <a href="Borrow?id=<%= session.getAttribute("id_user")%>" class="btn btn-success">Borrow List</a>
    </div>
    <%
        if(admin == 1){
    %>
    <div class="container text-left">
        <a href="ChangeUser?id=<%= session.getAttribute("id_user")%>" class="btn btn-success">Change</a>
    </div>
    <div class="container text-left">
        <a href="DeleteUser?id=<%= session.getAttribute("id_user")%>" class="btn btn-success">Delete</a>
    </div>
    <%
        }
    %>
</div>
</body>
</html>