<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Enter OTP</title>
    <link rel="stylesheet" href="./css/OTP.css">
<<<<<<< HEAD
<<<<<<< HEAD
=======
    <script src="./js/scripts.js"></script>
>>>>>>> origin/front-end
=======
>>>>>>> origin/profile
    <style>
        /* CSS styles */
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .container {
            width: 400px;
        }

        .form {
            background: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        /* Other CSS styles */
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
                <div class="countdown" id="countdown">Time left: <span id="timeLeft">30</span>s</div>
                <div class="resend">
                    <a id="resendLink" class="disabled" onclick="resendOTP()">Resend OTP</a>
                </div>
            </form>
        </div>
    </div>

    <script>
        let timeLeft = 30; // Thay ??i th?i gian ??m ng??c thành 30 giây
        let timeLeftElement = document.getElementById('timeLeft');
        let resendLink = document.getElementById('resendLink');

        function startCountdown() {
            let countdownInterval = setInterval(() => {
                timeLeftElement.textContent = timeLeft;
                if (timeLeft <= 0) {
                    clearInterval(countdownInterval);
                    resendLink.textContent = "Resend OTP";
                    resendLink.classList.remove('disabled');
                    resendLink.classList.add('enabled');
                    resendLink.style.color = '#ff0000'; // Chuy?n sang màu ??
                    resendLink.style.cursor = 'pointer';
                    resendLink.onclick = resendOTP;
                }
                timeLeft--; // Gi?m th?i gian còn l?i
            }, 1000); // M?i giây
        }

        function resendOTP() {
            if (resendLink.classList.contains('enabled')) {
                window.location.href = '${controller}?resendOTP=true'; // Thay ??i 'resendOtpPage.jsp' thành trang b?n mu?n ?i?u h??ng ??n
            }
        }

        startCountdown(); // B?t ??u ??m ng??c khi trang ???c t?i lên
    </script>
</body>
</html>
