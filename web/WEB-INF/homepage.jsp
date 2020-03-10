<%-- 
    Document   : homepage
    Created on : Mar 5, 2020, 5:14:54 PM
    Author     : 798419
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Home page</h1>

    <!--<p>Logged in as : ${sessionScope.validated}</p>-->
        
        <p>Logged in as2 : ${sessionScope.username}</p>
        <!--<a href="logout?logout">Log out </a>-->
        <a href="/Week7Demo_Bin/login?logout=logout">Log out </a>


    </body>
</html>
