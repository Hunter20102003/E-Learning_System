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
<<<<<<< HEAD
<<<<<<< HEAD
=======
        <script src="./js/scripts.js"></script>
>>>>>>> origin/front-end
=======
>>>>>>> origin/profile
    </head>

    <body>
        <div class="container">
            <div class="bubbles"></div>
            <div class="form">
                <form action="change-password" method="post">
                    <h2>Change Password</h2>
                    <div id="error-message" class="error-message">${errorMessage}</div>
                    <div id="error-message" class="error-message" style="color:green">${message}</div>
                    <div class="inputBox">
                        <div id="error-message" class="error-message">${errorOldPassword}</div>

                        <input type="password" id="oldPassword" name="oldPassword" >
                        <span>Old Password</span>
                        <i></i>
                    </div>
                    <div class="inputBox">
                        <div id="error-message" class="error-message">${errorNewPassword}</div>

                        <input type="password" id="newPassword" name="newPassword" >
                        <span>New Password</span>
                        <i></i>
                    </div>
                    <div class="inputBox">
                        <div id="error-message" class="error-message">${errorReNewPassword}</div>

                        <input type="password" id="renewPassword" name="reNewPassword" >
                        <span>Confirm New Password</span>
                        <i></i>
                    </div>
                    <div class="button-group">
                        <a href="index.jsp" class="back-button">Back</a>
                        <button class="btn" onclick="validatePasswords(event)">Continue</button>
                    </div>
                </form>
            </div>
        </div>
    </body>

</html>

