<nav class="navbar navbar-expand-md navbar-dark"
     style="background-color: blue">
    <div>
        <a href="" class="navbar-brand"> E-Library Application </a>
    </div>

    <ul class="navbar-nav" >
        <li <c:out value="${(page == 'signup') ? 'class=active' : ''}"/>
            <a href="Signup"> Sign Up</a>
        </li>
        <li <c:out value="${(page == 'login') ? 'class=active' : ''}"/>
            <a href="Login"> Login</a>
        </li>
    </ul>
</nav>