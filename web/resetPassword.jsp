<%-- 
    Document   : resetPassword
    Created on : May 16, 2024, 10:39:50 PM
    Author     : LEGION
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Reset Password</title>
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
            background: url('https://images.pexels.com/photos/1323550/pexels-photo-1323550.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1') no-repeat center center/cover;
            font-family: 'Open Sans', sans-serif;
            overflow: hidden;
        }

        .container {
            position: relative;
            max-width: 300px;
            width: 100%;
            padding: 40px;
            background: white;
            border-radius: 8px;
            box-shadow: 0 10px 10px rgba(0, 0, 0, 1);
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
            font-size: 28px;
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
            width: calc(100% - 20px);
            padding: 15px 10px;
            background: transparent;
            border: none;
            outline: none;
            color: black;
            font-size: 16px;
            letter-spacing: 0.05em;
            border-bottom: 2px solid #FF6600;
            transition: border-color 0.3s;
        }

        .inputBox input:focus {
            border-color: #fff;
        }

        .inputBox span {
            position: absolute;
            left: 0;
            bottom: 8px;
            padding: 0 5px;
            font-size: 16px;
            color: black;
            pointer-events: none;
            letter-spacing: 0.05em;
            transition: 0.5s;
        }

        .inputBox input:valid~span,
        .inputBox input:focus~span {
            color: #FF6600;
            transform: translateY(-30px);
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

        .inputBox input:valid~i,
        .inputBox input:focus~i {
            width: 100%;
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

        .button-group {
            display: flex;
            justify-content: space-between;
            margin-top: 20px;
        }

        .btn,
        .back-button {
            border: none;
            outline: none;
            padding: 12px 30px;
            border-radius: 25px;
            font-weight: 600;
            cursor: pointer;
            font-size: 16px;
            color: #fff;
            transition: background 0.3s, transform 0.3s;
            position: relative;
            z-index: 1;
            width: 48%;
            text-align: center;
        }

        .btn {
            background: #FF6600;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .btn:hover {
            background: #FF6600;
            transform: translateY(-3px);
        }

        .btn:active {
            transform: translateY(1px);
        }

        .back-button {
            background: gray;
            text-decoration: none;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .back-button:hover {
            background: gray;
            transform: translateY(-3px);
        }

        .back-button:active {
            transform: translateY(1px);
        }
    </style>
</head>

<body>
    <div class="container">
        <div class="bubbles"></div>
        <div class="form">
            <h2>Reset Password</h2>
            <div class="inputBox">
                <input type="password" id="newpassword" name="newpassword" required>
                <span>New Password</span>
                <i></i>
            </div>
            <div class="inputBox">
                <input type="password" id="confirmnewpassword" name="confirmnewpassword" required>
                <span>Confirm New Password</span>
                <i></i>
            </div>
            <div class="button-group">
                <a href="#" class="back-button">Back</a>
                <button class="btn">Continue</button>
            </div>
        </div>
    </div>
</body>

</html>
