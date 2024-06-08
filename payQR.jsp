<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Payment Interface</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #1f2937;
            color: #fff;
            margin: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            display: flex;
            background-color: #2d3748;
            border-radius: 8px;
            overflow: hidden;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            width: 800px; /* Increased width */
            height: auto; /* Changed to auto */
        }
        .left, .right {
            padding: 20px;
        }
        .left {
            border-right: 1px solid #4a5568;
            flex: 2; /* Adjusted to allow more space for the left side */
        }
        .right {
            flex: 1; /* Adjusted to reduce the space for the right side */
            max-width: 300px;
        }
        .title {
            font-size: 1.5em;
            margin-bottom: 10px;
        }
        .timer {
            font-size: 2em;
            color: #63b3ed;
            margin-bottom: 20px;
        }
        .input-group {
            display: flex;
            margin-bottom: 20px;
        }
        .input-group input {
            flex: 1;
            padding: 8px;
            border: 1px solid #4a5568;
            border-radius: 4px 0 0 4px;
        }
        .input-group button {
            padding: 8px 16px;
            background-color: #63b3ed;
            border: none;
            border-radius: 0 4px 4px 0;
            cursor: pointer;
        }
        .input-group button:hover {
            background-color: #4299e1;
        }
        .price-details {
            background-color: #1a202c;
            padding: 20px;
            border-radius: 8px;
        }
        .price-details p {
            margin: 10px 0;
        }
        .old-price {
            text-decoration: line-through;
            color: #718096;
        }
        .new-price {
            font-size: 1.5em;
            color: #63b3ed;
        }
        .total-price {
            font-size: 1.5em;
            color: #63b3ed;
            margin-top: 10px;
        }
        .qr-code {
            margin-bottom: 10px; /* Reduced margin */
            text-align: center;
        }
        .qr-code img {
            width: 150px; /* Reduced width */
            height: 150px; /* Reduced height */
        }
        .bank-details {
            background-color: #1a202c;
            padding: 10px; /* Reduced padding */
            border-radius: 8px;
        }
        .bank-details p {
            margin: 5px 0; /* Reduced margin */
            font-size: 0.9em; /* Reduced font size */
        }
        .note {
            margin-top: 10px; /* Reduced margin */
        }
        .note p {
            margin: 5px 0;
            font-size: 0.9em; /* Reduced font size */
        }
        .contact {
            margin-top: 10px; /* Reduced margin */
        }
        .contact p {
            margin: 5px 0;
            font-size: 0.9em; /* Reduced font size */
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="left">
            <div class="title">Đang chờ thanh toán</div>
            <div class="timer" id="timer">05:00</div>
            <div class="course-info">
                <p><strong>Tên khóa học:</strong> HTML CSS Pro</p>
                <p><strong>Mã đơn hàng:</strong> F8C167G4</p>
            </div>
            <div class="input-group">
                <input type="text" placeholder="Nhập mã khuyến mãi">
                <button>Áp dụng</button>
            </div>
            <div class="price-details">
                <p class="old-price">2.500.000đ</p>
                <p class="new-price">1.299.000đ</p>
                <p class="total-price">Tổng tiền: 1.299.000đ</p>
            </div>
        </div>
        <div class="right">
            <div class="qr-code">
                <p>Chuyển khoản bằng QR</p>
                <img src="./img/QRCode.jpg" alt="QR Code">
            </div>
            <div class="bank-details">
                <p><strong>Số tài khoản:</strong> 2801205325746</p>
                <p><strong>Nội dung:</strong> F8C167G4</p>
                <p><strong>Tên tài khoản:</strong> Dương Quang Phục</p>
                <p><strong>Chi nhánh:</strong> Agribank</p>
            </div>
            <div class="note">
                <p><strong>Lưu ý:</strong></p>
                <p>Tối đa 5 phút sau thời gian chuyển khoản, nếu hệ thống không phản hồi vui lòng liên hệ ngay bộ phận hỗ trợ.</p>
            </div>
            <div class="contact">
                <p><strong>Phone:</strong> 0393454486</p>
                <p><strong>Email:</strong> phucdqhe173065@fpt.edu.vn</p>
                <p><strong>Address:</strong> Đại học FPT Hà Nội</p>
            </div>
        </div>
    </div>
    <script>
        let timer = document.getElementById('timer');
        let time = 300; // 5 minutes in seconds

        function updateTimer() {
            let minutes = Math.floor(time / 60);
            let seconds = time % 60;
            if (seconds < 10) seconds = '0' + seconds;
            timer.textContent = `${minutes}:${seconds}`;
            time--;
            if (time >= 0) {
                setTimeout(updateTimer, 1000);
            }
        }

        updateTimer();
    </script>
</body>
</html>
