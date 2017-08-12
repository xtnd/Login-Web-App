<%-- 
    Document   : logout
    Created on : Jul 27, 2017, 6:37:26 PM
    Author     : Kodyscharf
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logout</title>
        <link href="css2.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        
        <!--Close session. And remove any attributes set. -->
        <% session.invalidate(); %>
        
        <p>Goodbye, you successfully logged out.</p>
        
        <a href="index.html">Go to Home page.</a>
    </body>
</html>
