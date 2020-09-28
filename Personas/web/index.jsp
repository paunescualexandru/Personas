<%-- 
    Document   : index
    Created on : Jun 7, 2020, 5:55:06 PM
    Author     : Dinamo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PERSONS LOGIN</title>
        <link rel="stylesheet" type="text/css" href="./css/mystyle.css">
        <script src="https://kit.fontawesome.com/d1cae46213.js" crossorigin="anonymous"></script>
    </head>
    <body>
        <form action="./Login" method="POST">
            <table class="tablecenterdwithborder">
                <tr>
                    <td>Username:</td><td><input name="personas_login_username" type="text" size="90" ></td>
                </tr>
                <tr>
                    <td>Password:</td><td><input name="personas_login_password" type="password" ></td>
                </tr>
                <tr>
                    <td></td><td><input name="personas_login_login" type="submit" value="Login"></td>
                </tr>
                <tr>
                    <td></td><td><a href="register.jsp"><input type="button" value="Registration" /></a></td>
                </tr>
                <div class="social-icons">
               
                    <td><td>    
                <a class="btn" href="https://www.facebook.com/"><i class="fab fa-facebook-square"></i></a>
                <a class="btn" href="https://www.instagram.com/"><i class="fab fa-instagram-square"></i></a>
                <a class="btn" href="/www.linkedin.com/"><i class="fab fa-linkedin"></i></a>
                    </td></td>
               
                </div>
            </table>
        </form>
    </body>
</html>
