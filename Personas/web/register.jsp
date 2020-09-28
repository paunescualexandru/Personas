<%-- 
    Document   : register
    Created on : Jun 20, 2020, 6:37:08 PM
    Author     : Dinamo
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>REGISTER</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="./css/testcss.css">
      <script src="https://www.google.com/recaptcha/api.js?render=v3_site_key"></script>
    <script>
      grecaptcha.ready(() => {
        grecaptcha.render('html_element', {
           'sitekey' : '6LdhxboZAAAAAP4XnHAd-GPSwRHThz0kiOhhnfEI'
        });
      });
    </script>
    <script>
      function onSubmit() {
        grecaptcha.ready(() => {
            grecaptcha.execute('6Ld0w7oZAAAAAAlZPdHpZ7t0Oog0V6VB0UUs-lY2', {action: 'homepage'}).then((token) => {
               ...
            });
        });
      }
    </script>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <form action="./Registration" method="POST">
                    <div class="form-group">
                        <h2>Registration</h2>
                        <tr>
                            <td><label>Firstname</label></td>
                            <td><input type="text" id="fname" name="fname" class="form-contol" required></td>
                        </tr>
                    </div>
                    <div>
                        <tr>
                            <td><label>Surname</label></td>
                            <td><input type="text" id="fname" name="surname" class="form-contol" required></td>
                         </tr>
                    </div>
                    <div>
                        <tr>
                            <td><label>Address</label><td>
                            <td><input type="text" id="address" name="address" class="form-contol" required></td>
                            </tr>
                    </div>
                    <div>
                        <td><label>Phone Number</label></td>
                        <td><input type="text" id="phone" name="phone" class="form-contol" required></td>
                    </div>
                    <div>
                        <label>Account</label>
                        <input type="account" name="account" id="account" >
                    </div>
                    <div>
                        <%-- 
                        <label>ID</label>
                        <input type="admin_users_id" name="admin_users_id" id="admin_users_id" >
                        --%>
                    </div>
                    <div>
                        <label>Password</label>
                        <input type="password" name="password" id="password" required>
                    </div>    
                    <div>
                        <label for="email">Email</label>
                        <input type="email" name="email" id="email" required>
                    </div>
                    <div>
                        <label for="age">Age</label>
                        <input type="number" name="age" id="age" min="1" max="99" step="1">
                    </div>
                    <div>
                        <label for="date">Birthdate</label>
                        <input type="date" name="date" id="date" min="1900-01-01">
                    </div>
                    <div>
                        <div>
                            Gender
                            <div>
                                <label for="male">Male</label>
                                <input type="radio" name="gender" id="male" value="male">
                                <label for="female">Female</label>
                                <input type="radio" name="gender" id="female" value="female">
                            </div>
                            <div>

 <form action="?" method="POST">
      <div id="html_element"></div>
      <br>
     
    </form>
    <script src="https://www.google.com/recaptcha/api.js?onload=onloadCallback&render=explicit"
        async defer>
    </script>
                            </div>
                            <button type="reset" class="btn btn-success" >Reset</button>
                            <h1><button type="submit" class="btn btn-success" >Register</button></h1>
                        </div>
                    </div>
                    </div>
            </div>
        </div>
    </div>
</div>
</center>
</form>
</body>
</html>
