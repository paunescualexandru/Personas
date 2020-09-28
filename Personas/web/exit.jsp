<%-- 
    Document   : exit
    Created on : Jun 18, 2020, 11:05:34 AM
    Author     : Dinamo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Exit</title>
    </head>
    <body>
                <%-- test if a valid user is logged in--%>  
                
        <c:choose>
            <c:when test="${validUser == true}">
                <c:set var="validUser" value="false" scope="session"></c:set>
                <c:set var="actualUserRole" value="" scope="session"></c:set>
                <c:set var="actual_user" value="" scope="session"></c:set>
                <c:redirect url="./index.jsp"></c:redirect>
            </c:when>
            <c:otherwise>
                <c:redirect url="./index.jsp"></c:redirect>
            </c:otherwise>
        </c:choose>
    </body>
</html>

