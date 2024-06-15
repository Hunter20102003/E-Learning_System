<%-- 
    Document   : forgot-password
    Created on : May 22, 2024, 11:27:57 PM
    Author     : LEGION
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <script src="./js/scripts.js"></script>

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Forgot Password</title>
        <link rel="stylesheet" href="./css/forgot.css">
    </head>

    <body>
        <div class="container">
            <div class="bubbles"></div>
            <div class="form">
                <form action="forgot-password" method="post">
                    <h2>Forgot Password</h2>
                    <div class="error-message" id="error-message">${errorMess}</div> <br>

                    <div class="inputBox">
                        <input type="text" id="email" name="email" value="${email}">
                        <span>Email</span>
                        <i></i>
                    </div>
                    <div class="button-group">

                        <button type="button" class="back-btn" onclick="window.location.href = 'login.jsp';">Back</button>

                        <input type="submit" value="Submit" id="submitBtn">
                    </div>
                </form>
            </div>
        </div>

    </body>

</html>
