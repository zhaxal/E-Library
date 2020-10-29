<nav class="navbar navbar-expand-md navbar-dark"
     style="background-color: blue">
    <div>
        <a href="" class="navbar-brand"> E-Commerce Application </a>
    </div>

    <ul class="navbar-nav">

        <form class="form-inline" action="User" method="post">
        <li ><input name="topic" type="submit" value="Engines"></li>
        <li ><input name="topic" type="submit" value="Gearboxes"></li>
        <li ><input name="topic" type="submit" value="Fuel Cell"></li>
        </form>

    </ul>

    <ul class="navbar-nav" style="left: 20px">
        <li ><a href="Cart"> >Shopping Cart</a>
        <li><a href=""> >Hello, <%= session.getAttribute( "name" ) %></a></li>
        <li><a href="Logout"> >Logout</a></li>
        <span id="timeleft" class="text-right"></span>
    </ul>
</nav>

