<%-- 
    Document   : login
    Created on : Jul 27, 2017, 6:36:52 PM
    Author     : Kodyscharf
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <link href="css2.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        
        
        <p style="color: red;">${loginMessage}</p> 
        
        <form action="Login" method="POST">
            User ID: <input type="text" name="userId" />
            <br><br>
            Password: <input type="password" name="password"/>
            <br><br>
            <input type="submit" value="Login" />
            <br><br>
            Not registered yet? <a href="Register">Sign up here</a>
        </form>
    </body>
</html>
