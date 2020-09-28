<%-- 
    Document   : main
    Created on : Jun 14, 2020, 2:27:31 PM
    Author     : Dinamo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Persons main page</title>
        <link rel="stylesheet" type="text/css" href="css/mystyle.css"/>
    </head>
    <body>
        
        <c:catch var="validUser">
            <c:if test="${validUser == true}">
                <%@include file="./jspf/menu.jspf" %>

            </c:if>
            <c:otherwise>
                <c:redirect url="./index.jsp">
                </c:redirect>
            </c:otherwise>
        </c:catch>
        
    </body>
</html>
