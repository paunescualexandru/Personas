 <%-- 
    Document   : getallpersons
    Created on : Jun 8, 2020, 8:19:00 PM
    Author     : Dinamo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- <%@ taglib uri="/WEB-INF/tlds/astiro" prefix="astiro" %>--%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Display all perosns</title>
        <link rel="stylesheet" type="text/css" href="./css/mystyle.css">
    </head>
    <body>
        <form action="${pageContext.request.contextPath}/GetAllPersons" >
            <%@ include file="jspf/menu.jspf" %>
    <sql:setDataSource
                          var="snapshot"
                          driver="org.apache.derby.jdbc.ClientDriver"
                          url="jdbc:derby://localhost:1527/persoane;create=true"
                          user="test"
                          password="1234"/>
        <%--
        <astiro:connectdb 
                        dbconnection="snapshot" 
                        dbdriver="org.apache.derby.jdbc.ClientDriver"
                        dburl="dbc:derby://localhost:1527/persoane;create=true"
                        dbusername="test"
                        dbpassword="1234">
        </astiro:connectdb>
        --%>
                          <sql:query dataSource="${snapshot}" var="result"> 
                              SELECT PERSOANE.CNP AS CNP,PERSOANE.NAME AS NAME,PERSOANE.SURNAME AS SURNAME,LOCALITATI.DENUMIRE AS LOCALITATE, JUDETE.DENUMIRE AS JUDET 
                              FROM PERSOANE, LOCALITATI, JUDETE 
                              WHERE PERSOANE.COD_LOCALITATE=LOCALITATI.COD AND LOCALITATI.COD_JUDET=JUDETE.COD_JUDETE
                          </sql:query>
                              <table border="1" width="100%"> 
                                     <tr>
                            <td width="10%" class="tdc"><c:out value="CNP"/>
                            <td width="10%" class="tdc"><c:out value="SURNAME"/></td>
                            <td width="10%" class="tdc"><c:out value="NAME"/></td>
                            <td width="10%" class="tdc"><c:out value="LOCALITATE"/></td>
                            <td width="10%" class="tdc"><c:out value="JUDET"/></td>
                                     </tr>    
                                  <c:forEach var="row" varStatus="loop" items="${result.rows}">
                                      <tr>
                                         
                                          <td><c:out value="${row.cnp}"/></td>
                                          <td><c:out value="${row.name}"/></td>
                                          <td><c:out value="${row.surname}"/></td>
                                          <td><c:out value="${row.localitate}"/></td>
                                          <td><c:out value="${row.judet}"/></td>
                                      </tr>
                                  </c:forEach>
                                      <tr>
                                          <td></td><td></td>
                                           <td class="tdc"><input type="submit" class="ebooksstorebutton" name="report_allpersons_back" value="Back"></td>
                                           <td></td><td></td>
                                      </tr>
                              </table>    
        </form>
    </body>
</html>
