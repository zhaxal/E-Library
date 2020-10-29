<nav class="navbar navbar-expand-md navbar-dark"
     style="background-color: blue">
    <div>
        <a href="" class="navbar-brand"> E-Library Application </a>
    </div>


    <ul class="navbar-nav" style="left: 20px">
        <li ><a href="UserList"> User List</a>
        <li ><a href="BookList"> Book List</a>
        <li ><a href="Profile"> Profile</a>
        <li><a href=""> Hello, <%= session.getAttribute( "name" ) %></a></li>
        <li><a href="Logout"> Logout</a></li>
    </ul>
</nav>

