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
        <h3 class="text-center">List of Users</h3>
        <hr>
        <div class="container text-left">

        </div>
        <br>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>ID</th>
                <th>Username</th>
                <th>Name</th>
                <th>Email</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach var="books" items="${resultset}">

                <tr>
                    <td><c:out value="${books.id}" /></td>
                    <td><c:out value="${books.username}" /></td>
                    <td><c:out value="${books.name}" /></td>
                    <td><c:out value="${books.email}" /></td>
                    <td>
                        <a style="color: black" href="User?id=<c:out value='${books.id}' />">Profile</a>
                    </td>
                </tr>
            </c:forEach>

            </tbody>

        </table>
    </div>
</div>
</body>
</html>