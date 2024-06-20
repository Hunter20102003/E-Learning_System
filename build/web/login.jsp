<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="./css/AboutAlllogin.css">
    <script src="./js/scripts.js"></script>
    <style>
        .toggle-password {
            position: absolute;
            right: 10px;
            top: 50%;
            transform: translateY(-50%);
            cursor: pointer;
        }

        .toggle-password img {
            width: 20px;
            height: 20px;
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
            <div id="error-message" class="error-message">${registerError}</div>
            <div id="error-message" class="error-message" style="color:green">${registerSuccess}</div>
            <div id="error-message" class="error-message">${resetPasswordError}</div>
            <div id="error-message" class="error-message" style="color:green">${resetPasswordSuccess}</div>
            <div id="error-message" class="error-message">${mess}</div>
            <form action="login" method="post">
                <div class="inputBox">
                    <input type="text" id="username" name="username" value="${cookie.username.value}" required>
                    <span>UserName</span>
                    <i></i>
                </div>
                <div class="inputBox">
                    <input type="password" id="password" name="password" value="${cookie.password.value}" required>
                    <span>Password</span>
                    <i></i>
                    <div class="toggle-password" onclick="togglePasswordVisibility()">
                        <img src="https://img.icons8.com/ios-filled/50/000000/visible.png" alt="Show Password" id="toggle-icon">
                    </div>
                </div>
                <div class="remember-me">
                    <input type="checkbox" id="remember" name="remember" ${cookie.remember.value eq "selected" ? "checked" : ""}>
                    <label for="remember">Remember Me</label>
                </div>
                <div class="button-group">
                    <input type="submit" value="Login">
                    <a href="https://accounts.google.com/o/oauth2/auth?scope=email profile openid&redirect_uri=http://localhost:8080/E-Learning_System/google-login&response_type=code&client_id=665871395394-tf055etljg95kb05rk9hicmn5ounhh8f.apps.googleusercontent.com&approval_prompt=force"
                       class="google-btn">
                        <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/c/c1/Google_%22G%22_logo.svg/1024px-Google_%22G%22_logo.svg.png" alt="Google Logo" width="20" height="20">
                        Google
                    </a>
                </div>
            </form>
            <div class="links">
                <a href="forgot-password.jsp">Forgot password?</a>
                <a href="signup.jsp">Sign Up</a>
            </div>
        </div>
    </div>
    <script>
        function togglePasswordVisibility() {
            const passwordInput = document.getElementById('password');
            const toggleIcon = document.getElementById('toggle-icon');
            if (passwordInput.type === 'password') {
                passwordInput.type = 'text';
                toggleIcon.src = 'https://img.icons8.com/ios-filled/50/000000/invisible.png';
            } else {
                passwordInput.type = 'password';
                toggleIcon.src = 'https://img.icons8.com/ios-filled/50/000000/visible.png';
            }
        }
    </script>
</body>

</html>
