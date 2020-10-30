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
        <h3 class="text-center">Book Change</h3>
    </div>
    <br>
    <div class="container col-md-5">
        <div class="card">
            <div class="card-body">
                <form action="ChangeBook" method="post">
                    <input type = "hidden" name = "id" value = "<%= session.getAttribute("isbn") %>" />
                    <h5 class="text-left">Current isbn: <%= session.getAttribute("isbn") %></h5>
                    <h5 class="text-left">Current name: <%= session.getAttribute("bookName") %></h5>
                    <fieldset class="form-group">
                        <label>New Book name</label> <input type="text"
                                                        class="form-control"
                                                        name="bookName">
                    </fieldset>
                    <h5 class="text-left">Current author: <%= session.getAttribute("author") %></h5>
                    <fieldset class="form-group">
                        <label>New Author name</label> <input type="text"
                                                            class="form-control"
                                                            name="author">
                    </fieldset>
                    <h5 class="text-left">Current amount: <%= session.getAttribute("amount") %></h5>
                    <fieldset class="form-group">
                        <label>New Amount</label> <input type="text"
                                                            class="form-control"
                                                            name="amount">
                    </fieldset>
                    <button type="submit" class="btn btn-success">Change</button>
                </form>
            </div>
        </div>
    </div>



</div>
</body>
</html>