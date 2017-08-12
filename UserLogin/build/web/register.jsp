<%-- 
    Document   : register
    Created on : Jul 27, 2017, 6:37:04 PM
    Author     : Kodyscharf
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EJD Registration Page</title>
        <link href="css2.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <h1>Registration Form</h1>
        <div>
            
            <!--Print out register Message. -->
            
            <span><p>${registerMessage}</p></span>
            <form action="Register" method="POST">
                Please fill out the form below...
                <br><br>
                Choose user ID: <input type="text" name="userId"/>
                <br><br>
                Choose your password: <input type="password" name="userPass" />
                <br><br>
                Enter your email address: <input type="email" name="userEmail" />
                <br><br>
                <input type="submit" value="Signup" />
            </form>
        </div>
    </body>
</html>
