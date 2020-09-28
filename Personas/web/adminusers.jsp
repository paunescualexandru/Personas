<%-- 
    Document   : adminusers
    Created on : Jun 18, 2020, 10:58:08 AM
    Author     : Dinamo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin users</title>
        <link rel="stylesheet" type="text/css" href="css/mystyle.css"/>
    </head>
    <body>
         <%-- Test if actual user is authenticated and authorized --%>
        <c:choose>
            <c:when test="${validUser == true}">
                <%-- include menu --%>
                <%@ include file="jspf/menu.jspf" %>
                <%-- Master view --%>
                <form action="${pageContext.request.contextPath}/AdminUsers">
                    <sql:setDataSource 
                        var="snapshot" 
                        driver="org.apache.derby.jdbc.ClientDriver"
                        url="jdbc:derby://localhost:1527/persoane;create=true;"
                        user="test"  
                        password="1234"></sql:setDataSource>
                    <sql:query dataSource="${snapshot}" var="result">
                    SELECT USERS.ID,USERS.USERNAME,USERS.PASSWORD,USERS.ROLE
                    FROM USERS, USERS_ROLES
                    WHERE USERS.ROLE=USERS_ROLES.ROLE
                    </sql:query>
                    <table border="1" width="100%">
                        <tr>
                            <td width="4%" class="tdc"><c:out value="S"/>
                            <td width="24%" class="tdc"><c:out value="ID"/></td>
                            <td width="24%" class="tdc"><c:out value="USERNAME"/></td>
                            <td width="24%" class="tdc"><c:out value="PASSWORD"/></td>
                            <td width="24%" class="tdc"><c:out value="ROLE"/></td>
                        </tr>    
                        <c:forEach var="row" varStatus="loop" items="${result.rows}">
                        <tr>
                            <td width="4%" class="tdc"><input type="checkbox" name="admin_users_checkbox" value="${row.id}"></td>
                            <td width="24%" class="tdc"><c:out value="${row.id}"/></td>
                            <td width="24%" class="tdc"><c:out value="${row.username}"/></td>
                            <td width="24%" class="tdc"><c:out value="${row.password}"/></td>
                            <td width="24%" class="tdc"><c:out value="${row.role}"/></td>
                        </tr>
                        </c:forEach>
                    </table>  
                    <%-- details --%>
                    <%-- prepare content for list of roles taken from table roles --%>
                    <sql:setDataSource 
                        var="snapshot" 
                        driver="org.apache.derby.jdbc.ClientDriver"
                        url="jdbc:derby://localhost:1527/persoane;create=true;"
                        user="test"  
                        password="1234"/>
                    <sql:query dataSource="${snapshot}" var="resultroles">
                    SELECT ROLE
                    FROM USERS_ROLES
                    ORDER BY ROLE ASC
                    </sql:query>
                    <table class="tablecenterdwithborder"> <%-- table with fields used to introduce data for insert or update --%>
                        <tr>
                            <td>
                                <table>
                                    <tr>
                                        <td> ID: </td><td><input type="text" name="admin_users_id"></td>
                                    </tr>
                                    <tr>
                                        <td> USERNAME: </td><td><input type="text" name="admin_users_username"></td>
                                    </tr>
                                    <tr>
                                        <td> PASSWORD: </td><td><input type="password" name="admin_users_password"></td>
                                    </tr>
                                    <tr>
                                        <td> ROLE: </td>
                                        <td>
                                            <select name="admin_user_role">
                                                <c:forEach var="rowrole" items="${resultroles.rows}">
                                                    <option name="admin_users_roles" value="${rowrole.role}">${rowrole.role}</option>
                                                </c:forEach>
                                            </select>
                                        </td>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <table> <%-- table of buttons --%>
                                    <tr>
                                        <td class="tdc"><input type="submit"  name="admin_users_insert" value="Insert"></td>
                                        <td class="tdc"><input type="submit" class="ebooksstorebutton" name="admin_users_update" value="Update"></td>
                                        <td class="tdc"><input type="submit" class="ebooksstorebutton" name="admin_users_delete" value="Delete"></td>
                                        <td class="tdc"><input type="submit" class="ebooksstorebutton" name="admin_users_cancel" value="Cancel"></td>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                    </table>    
                </form>
            </c:when>
        </c:choose>
    </body>
</html>

