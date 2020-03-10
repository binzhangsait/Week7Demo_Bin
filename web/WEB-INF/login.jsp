<%-- 
    Document   : login
    Created on : Mar 5, 2020, 4:35:34 PM
    Author     : 798419
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Login</h1>
        <!--<p>Logged in as : ${sessionScope.user}</p>-->
        <p>${error}</p>
        <form method="post">
            User Name: <input type="text" name="username" /><br>
            Password1: <input type="text" name="password" /><br>
            <input type="submit" name="login" value="Login" /><br>
        </form>
    </body>
</html>
