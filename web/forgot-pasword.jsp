<%-- 
    Document   : forgot-pasword
    Created on : May 16, 2024, 10:39:05 PM
    Author     : LEGION
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Forgot Password</title>
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
            max-width: 400px;
            width: 100%;
            padding: 60px;
            background: rgba(255, 255, 255, 0.8);
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
            transition: border-color 0.3s, padding-left 0.3s;
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

        .button-group button, .button-group input[type="submit"] {
            width: 48%;
            padding: 14px;
            border: none;
            border-radius: 25px;
            font-weight: 600;
            cursor: pointer;
            font-size: 18px;
            color: #fff;
            transition: background 0.3s, transform 0.3s;
        }

        .button-group input[type="submit"] {
            background: #FF6600;
        }

        .button-group button {
            background: #6c757d;
        }

        .button-group input[type="submit"]:hover, .button-group button:hover {
            transform: translateY(-3px);
        }

        .button-group input[type="submit"]:active, .button-group button:active {
            transform: translateY(1px);
        }
    </style>
</head>

<body>
    <div class="container">
        <div class="bubbles"></div>
        <div class="form">
            <h2>Forgot Password</h2>
            <div class="inputBox">
                <input type="email" id="email" name="email" required>
                <span>Email</span>
                <i></i>
            </div>
            <div class="button-group">
                <button class="back-btn">Back</button>
                <input type="submit" value="Submit">
            </div>
        </div>
    </div>
</body>

</html>
