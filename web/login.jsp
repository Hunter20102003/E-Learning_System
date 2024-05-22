<%-- 
    Document   : login
    Created on : May 16, 2024, 10:39:18 PM
    Author     : LEGION
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Login</title>
        <style>
            * {
                margin: 0;
                padding: 0;
                box-sizing: border-box;
            }

            body {
                display: flex;
                justify-content: center;
                align-items: center;
                min-height: 100vh;
                background: url('https://images.pexels.com/photos/1323550/pexels-photo-1323550.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1') no-repeat center center/cover; /* Change the URL to your image */
                font-family: 'Open Sans', sans-serif;
                overflow: hidden;
            }

            .container {
                position: relative;
                max-width: 400px;
                width: 100%;
                padding: 60px;
                background: rgba(255, 255, 255, 0.8); /* Add some transparency to blend with the background image */
                border-radius: 8px;
                box-shadow: 0 10px 10px rgba(0, 0, 0, 0.1);
                overflow: hidden;
            }

            .container::before {
                content: '';
                position: absolute;
                top: -50%;
                left: -50%;
                width: 200%;
                height: 200%;
                background: linear-gradient(45deg, rgba(0, 0, 0, 0), #FF6600, rgba(0, 0, 0, 0));
                animation: animate 6s linear infinite;
            }

            @keyframes animate {
                0% {
                    transform: translate(-50%, -50%) rotate(0deg);
                }

                100% {
                    transform: translate(-50%, -50%) rotate(360deg);
                }
            }

            .form {
                position: relative;
                z-index: 1;
            }

            .form h2 {
                color: #FF6600;
                font-weight: 700;
                font-size: 32px;
                text-align: center;
                letter-spacing: 0.1em;
                margin-bottom: 30px;
            }

            .inputBox {
                position: relative;
                width: 100%;
                margin-bottom: 20px;
            }

            .inputBox input {
                width: 100%;
                padding: 10px 0;
                background: transparent;
                border: none;
                outline: none;
                color: black;
                font-size: 18px;
                letter-spacing: 0.05em;
                border-bottom: 2px solid #FF6600;
                transition: border-color 0.3s, padding 0.3s;
            }

            .inputBox input:focus {
                border-color: #fff;
                padding-left: 10px;
            }

            .inputBox span {
                position: absolute;
                left: 0;
                bottom: 10px;
                font-size: 18px;
                color: black;
                pointer-events: none;
                letter-spacing: 0.05em;
                transition: 0.3s;
            }

            .inputBox input:focus~span,
            .inputBox input:valid~span {
                color: #FF6600;
                transform: translateX(-10px) translateY(-30px);
                font-size: 14px;
            }

            .inputBox i {
                position: absolute;
                left: 0;
                bottom: 0;
                width: 100%;
                height: 2px;
                background: #FF6600;
                transition: width 0.3s;
            }

            .inputBox input:focus~i,
            .inputBox input:valid~i {
                width: 100%;
            }

            .links {
                display: flex;
                justify-content: space-between;
                width: 100%;
                margin-top: 30px;
            }

            .links a {
                font-size: 16px;
                color: black;
                text-decoration: none;
                transition: color 0.3s;
            }

            .links a:hover {
                color: #FF6600;
            }

            .bubbles {
                position: absolute;
                top: 0;
                left: 0;
                width: 100%;
                height: 100%;
                pointer-events: none;
                z-index: 0;
                overflow: hidden;
            }

            .bubble {
                position: absolute;
                border-radius: 50%;
                background-color: #FF6600;
                pointer-events: none;
                animation: bubble 8s infinite ease-in-out;
                animation-delay: calc(-50s * var(--i));
            }

            @keyframes bubble {
                0% {
                    transform: translate(0, 0) scale(1);
                    opacity: 1;
                }

                50% {
                    transform: translate(50%, -20px) scale(2);
                    opacity: 0.8;
                }

                100% {
                    transform: translate(100%, -40px) scale(1);
                    opacity: 1;
                }
            }

            input[type="submit"],
            .google-btn {
                border: none;
                outline: none;
                padding: 14px 30px;
                border-radius: 25px;
                font-weight: 600;
                cursor: pointer;
                font-size: 18px;
                color: #fff;
                transition: background 0.3s, transform 0.3s;
                position: relative;
                z-index: 1;
                width: 48%;
            }

            input[type="submit"] {
                background: #FF6600;
            }

            .google-btn {
                background: #FF6600;
                display: flex;
                justify-content: center;
                align-items: center;
            }

            .google-btn img {
                margin-right: 10px;
            }

            input[type="submit"]:hover,
            .google-btn:hover {
                transform: translateY(-3px);
            }

            input[type="submit"]:active,
            .google-btn:active {
                transform: translateY(1px);
            }

            .button-group {
                display: flex;
                justify-content: space-between;
                align-items: center;
                margin-bottom: 20px;
            }

            .remember-me {
                display: flex;
                align-items: center;
                font-size: 16px;
                color: black;
                margin-bottom: 20px;
            }

            .remember-me input {
                margin-right: 10px;
            }
        </style>
    </head>

    <body>
        <div class="container">
            <div class="bubbles">
                <!-- Add bubble elements here if needed -->
            </div>
            <div class="form">
                <h2>Login</h2>
                <div style="color:red">${mess}</div>
                <form action="LoginController" method="post">
                    <div class="inputBox">
                        <input type="text" id="username" name="username" value="${cookie.username.value}" required>
                        <span>UserName</span>
                        <i></i>
                    </div>
                    <div class="inputBox">
                        <input type="password" id="password" name="password" value="${cookie.password.value}"required>
                        <span>Password</span>
                        <i></i>
                    </div>
                    <div class="remember-me">
                        <input type="checkbox" id="remember" name="remember" ${cookie.remember.value eq "selected"?"checked":""}>
                        <label for="remember">Remember Me</label>
                    </div>
                    <div class="button-group">
                        <input type="submit" value="Login">
                     </form>
                        <button class="google-btn">
                            <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/c/c1/Google_%22G%22_logo.svg/1024px-Google_%22G%22_logo.svg.png"
                                 alt="Google Logo" width="20" height="20">
                            Google
                        </button>
                    </div>
                    <div class="links">
                        <a href="#">Forgot password?</a>
                        <a href="signup.jsp">Sign Up</a>
                    </div>
            </div>
        </div>
    </body>

</html>
