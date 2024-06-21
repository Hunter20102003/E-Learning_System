<%-- 
    Document   : signup
    Created on : May 22, 2024, 11:31:22 PM
    Author     : LEGION
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Sign Up</title>
        <link rel="stylesheet" href="./css/signup.css">
        <script src="./js/scripts.js"></script>
    </head>

    <body>
        <div class="container">
            <div class="bubbles"></div>
            <div class="form">
                <form action="register" method="post">
                    <h2>Sign Up</h2>
                    <div id="error-message" class="error-message">${errorMessage}</div>

                    <div class="inputBox">
                        <div style="color:red">${errorUserName}</div> <br>
                        <input type="text" id="username" name="username"  value="${requestScope.username}">
                        <span>UserName</span>
                        <i></i>
                    </div>
                    <div class="inputBox">
                        
                        <input type="text" id="fisrtname" name="firstname" value="${requestScope.firstname}">
                        <span>Fisrt name</span>
                        <i></i>
                    </div>
                    <div class="inputBox">
                        <input type="text" id="lastname" name="lastname" value="${requestScope.lastname}">
                        <span>Last name</span>
                        <i></i>
                    </div>
                    <div class="inputBox">
                         <div style="color:red">${errorEmail}</div> <br>
                        <input type="text" id="email" name="email" value="${requestScope.email}">
                        <span>Email</span>
                        <i></i>
                    </div>
                    <div class="inputBox">
                         <div style="color:red">${errorPassword}</div> <br>
                        <input type="password" id="password" name="password" value="${requestScope.password}">
                        <span>Password</span>
                        <i></i>
                    </div>
                    <div class="inputBox">
                         <div style="color:red">${errorRePassword}</div> <br>
                        <input type="password" id="repassword" name="repassword" value="${requestScope.repassword}">
                        <span>Confirm Password</span>
                        <i></i>
                    </div>
                    <div class="button-group">
                        <a href="login.jsp" class="back-button">Back</a>
                        <input type="submit" value="SignUp" onclick="validateForm(event)">
                    </div>
                    <div class="links">
                        <a href="forgot-password.jsp">Forgot password?</a>
                        <a href="login.jsp">Login</a>
                    </div>
                </form>
            </div>
        </div>
    </body>

</html>
