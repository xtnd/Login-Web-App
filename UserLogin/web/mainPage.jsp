<%-- 
    Document   : mainPage
    Created on : Jul 27, 2017, 6:37:17 PM
    Author     : Kodyscharf
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Main Page</title>
        <link href="css2.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        
        

        <p>Hello ${user.id}, You logged in successfully.</p>
        <br>
        Your Profile:
        <br>
        <br>
        User ID: ${user.id}
        <br>
        Email: ${user.email}
        <br>
        <br>
        <a href="logout.jsp">Log out</a>
        
    </body>
</html>
