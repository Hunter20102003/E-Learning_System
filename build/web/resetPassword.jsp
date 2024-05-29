<%-- 
    Document   : resetPassword
    Created on : May 22, 2024, 11:30:43 PM
    Author     : LEGION
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Reset Password</title>
        <link rel="stylesheet" href="./css/reset.css">
    </head>

    <body>
        <div class="container">
            <div class="bubbles"></div>
            <div class="form">
                <form action="reset-password" method="post">
                    <h2>Reset Password</h2>
                    <div id="error-message" class="error-message">${mess}</div>
                    <div class="inputBox">
                        <input type="password" id="newpassword" name="newpassword" >
                        <span>New Password</span>
                        <i></i>
                    </div>
                    <div class="inputBox">
                        <input type="password" id="confirmnewpassword" name="confirmnewpassword" >
                        <span>Confirm New Password</span>
                        <i></i>
                    </div>
                    <div class="button-group">
                        <a href="forgot-password.jsp" class="back-button">Back</a>
                        <button class="btn" onclick="validatePasswords(event)">Continue</button>
                    </div>
                </form>
            </div>
        </div>
    </body>

</html>

