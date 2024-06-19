<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Payment Interface</title>
<<<<<<< HEAD
    <script src="./js/scripts.js"></script>
=======
>>>>>>> origin/profile
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
            width: 800px;
            height: auto;
        }
        .left, .right {
            padding: 20px;
        }
        .left {
            border-right: 1px solid #4a5568;
            flex: 2;
        }
        .right {
            flex: 1;
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
        .input-group .btn {
            padding: 8px 16px;
            background-color: #63b3ed;
            border: none;
            border-radius: 0 4px 4px 0;
            color: white;
            text-align: center;
            text-decoration: none;
            cursor: pointer;
        }
        .input-group .btn:hover {
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
            margin-bottom: 10px;
            text-align: center;
        }
        .qr-code img {
            width: 150px;
            height: 150px;
        }
        .bank-details {
            background-color: #1a202c;
            padding: 10px;
            border-radius: 8px;
        }
        .bank-details p {
            margin: 5px 0;
            font-size: 0.9em;
        }
        .note {
            margin-top: 10px;
        }
        .note p {
            margin: 5px 0;
            font-size: 0.9em;
        }
        .contact {
            margin-top: 10px;
        }
        .contact p {
            margin: 5px 0;
            font-size: 0.9em;
        }
        .btn {
            display: inline-block;
            padding: 8px 16px;
            background-color: #63b3ed;
            border: none;
            border-radius: 4px;
            color: white;
            text-align: center;
            text-decoration: none;
            cursor: pointer;
        }
        .btn:hover {
            background-color: #4299e1;
        }
    </style>
</head>
<body>
    <div class="container">
        <c:set var="list" value="${listcourse}"/>
            <c:set var="random" value="${random}"/>
        <div class="left">
            <div class="title">Đang chờ thanh toán</div>
            <div class="timer" id="timer">05:00</div>
            <div class="course-info">
                <p><strong>Tên khóa học:</strong> ${list.name}</p>
                <p><strong>Mã đơn hàng:</strong> ${random}</p>
            </div>
          
            <div class="price-details">
                <p class="old-price">2.500.000đ</p>
                <p class="new-price">${list.price}</p>
                <p class="total-price">Tổng tiền: ${list.price}</p>
            </div>
            <div >
                <p>Sau khi đã thanh toán hãy xác minh !</p>
                
            </div>
            
            <div class="input-group">
                <a href="GetDataServlet?id=${list.id}&random=${random}" class="btn" style="color: black">Xác minh</a>
            </div>
            <div>
                <p>${check}</p>
            </div>
        </div>
        <div class="right">
            <div class="qr-code">
                <p>Chuyển khoản bằng QR</p>
                <img src="${qrLink}" alt="QR Code">
            </div>
            <div class="bank-details">
                <p><strong>Số tài khoản:</strong> 4271051995</p>
                <p><strong>Nội dung:</strong> ${random}</p>
                <p><strong>Tên tài khoản:</strong> BUI QUANG THAI</p>
                <p><strong>Chi nhánh:</strong> MBBANK</p>
            </div>
            <div class="note">
                <p><strong>Lưu ý:</strong></p>
                <p>Nội dung phải đúng mã đã cung cấp Và Tối đa 5 phút sau thời gian chuyển khoản, nếu hệ thống không phản hồi vui lòng liên hệ ngay bộ phận hỗ trợ.</p>
            </div>
            <div class="contact">
                <p><strong>Phone:</strong> 0393454486</p>
                <p><strong>Email:</strong> phucdqhe173065@fpt.edu.vn</p>
                <p><strong>Address:</strong> Đại học FPT Hà Nội</p>
            </div>
        </div>
    </div>
   <script>
        document.addEventListener('DOMContentLoaded', function() {
            let timerElement = document.getElementById('timer');
            let time = 300; // 5 minutes in seconds

            function updateTimer() {
                let minutes = Math.floor(time / 60);
                let seconds = time % 60;
                if (seconds < 10) seconds = '0' + seconds;
                timerElement.textContent = minutes + ':' + seconds;
                if (time > 0) {
                    time--;
                    setTimeout(updateTimer, 1000);
                }
            }

            updateTimer();

          
        });
    </script>
</body>
</html>
