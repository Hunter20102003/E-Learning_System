<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Enter OTP</title>
    <link rel="stylesheet" href="./css/OTP.css">
    <style>
        .container {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 50vh;
            background: #f0f0f0;
        }

        .form {
            background: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        .inputBox {
            position: relative;
            margin-bottom: 20px;
        }

        .inputBox input {
            width: 100%;
            padding: 10px;
            background: none;
            border: none;
            border-bottom: 1px solid #000;
            outline: none;
            color: #000;
            font-size: 18px;
        }

        .inputBox span {
            position: absolute;
            left: 0;
            padding: 10px;
            pointer-events: none;
            font-size: 18px;
            transition: 0.5s;
            color: #666;
        }

        .inputBox input:focus~span,
        .inputBox input:valid~span {
            transform: translateY(-20px);
            font-size: 12px;
            color: #ff6600;
        }

        .inputBox i {
            position: absolute;
            bottom: 0;
            left: 0;
            width: 100%;
            height: 2px;
            background: #ff6600;
            border-radius: 4px;
            transition: 0.5s;
            pointer-events: none;
            opacity: 0;
        }

        .inputBox input:focus~i {
            opacity: 1;
        }

        .button-group {
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .button-group button,
        .button-group input[type="submit"] {
            padding: 10px 20px;
            border: none;
            background: #ff6600;
            color: #fff;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
        }

        .button-group button:hover,
        .button-group input[type="submit"]:hover {
            background: #e65c00;
        }

        .error-message {
            color: red;
            margin-bottom: 10px;
        }

        .countdown,
        .resend {
            margin-top: 10px;
            text-align: center;
        }

        .resend a {
            color: #ff6600;
            cursor: not-allowed;
            text-decoration: none;
        }

        .resend a.enabled {
            cursor: pointer;
            text-decoration: none; /* Xóa dấu gạch chân */
            color: #ff0000; /* Màu đỏ */
        }

        .resend a.disabled {
            color: #666; /* Màu xám */
        }
    </style>
</head>

<body>
    <div class="container">
        <div class="bubbles"></div>
        <div class="form">
            <form action="${controller}" method="get">
                <h2>Enter OTP</h2>
                <div id="error-message" class="error-message">${errorOTP}</div>
                <div class="inputBox">
                    <input type="text" id="otp" name="otp">
                    <span>OTP</span>
                    <i></i>
                </div>
                <div class="button-group">
                        <button type="button" class="back-btn" onclick="window.location.href = 'login.jsp';">Back</button>
                    <input type="submit" value="Activate" onclick="validateOTP(event)">
                </div>
                <br>
                <div>${messSendOTP}</div>
                <div class="countdown" id="countdown">Time left: 60s</div>
                <div class="resend">
                    <a id="resendLink" class="disabled" onclick="resendOTP()">Resend OTP</a>
                </div>
            </form>
        </div>
    </div>

    <script>
        let countdownElement = document.getElementById('countdown');
        let resendLink = document.getElementById('resendLink');
        let timeLeft = 60; // Bắt đầu từ 60 giây

        function startCountdown() {
            let countdownInterval = setInterval(() => {
                countdownElement.textContent = `Time left: ${timeLeft}s`; // Hiển thị giờ đếm ngược hiện tại
                if (timeLeft <= 0) {
                    clearInterval(countdownInterval);
                    resendLink.textContent = "Resend OTP";
                    resendLink.classList.remove('disabled');
                    resendLink.classList.add('enabled');
                    resendLink.style.color = '#ff0000'; // Chuyển sang màu đỏ
                    resendLink.style.cursor = 'pointer';
                    resendLink.onclick = resendOTP;
                }
                timeLeft--; // Giảm thời gian còn lại
            }, 1000); // Mỗi giây
        }

        function resendOTP() {
            if (resendLink.classList.contains('enabled')) {
                window.location.href = '${controller}?resendOTP=true'; // Thay đổi 'resendOtpPage.jsp' thành trang bạn muốn điều hướng đến
            }
        }

        startCountdown();
    </script>
</body>

</html>
