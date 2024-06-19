<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Payment Interface</title>
<<<<<<< HEAD
<<<<<<< HEAD
=======
    <script src="./js/scripts.js"></script>
>>>>>>> origin/front-end
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
<<<<<<< HEAD
<<<<<<< HEAD
            <div class="title">Waiting for Payment</div>
            <div class="timer" id="timer">05:00</div>
            <div class="course-info">
                <p><strong>Course Name:</strong> ${list.name}</p>
                <p><strong>Order Code:</strong> ${random}</p>
            </div>
          
            <div class="price-details">
                <p class="old-price">2,500,000 VND</p>
                <p class="new-price">${list.price}</p>
                <p class="total-price">Total Price: ${list.price}</p>
            </div>
            <div >
                <p>After completing the payment, please verify!</p>
=======
=======
>>>>>>> origin/profile
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
<<<<<<< HEAD
>>>>>>> origin/front-end
=======
>>>>>>> origin/profile
                
            </div>
            
            <div class="input-group">
<<<<<<< HEAD
<<<<<<< HEAD
                <a href="course_learing_lession?id=${list.id}&random=${random}" class="btn" style="color: black">Verify</a>
=======
                <a href="GetDataServlet?id=${list.id}&random=${random}" class="btn" style="color: black">Xác minh</a>
>>>>>>> origin/front-end
=======
                <a href="GetDataServlet?id=${list.id}&random=${random}" class="btn" style="color: black">Xác minh</a>
>>>>>>> origin/profile
            </div>
            <div>
                <p>${check}</p>
            </div>
        </div>
        <div class="right">
            <div class="qr-code">
<<<<<<< HEAD
<<<<<<< HEAD
                <p>Transfer via QR Code</p>
                <img src="${qrLink}" alt="QR Code">
            </div>
            <div class="bank-details">
                <p><strong>Account Number:</strong> 4271051995</p>
                <p><strong>Content:</strong> ${random}</p>
                <p><strong>Account Name:</strong> BUI QUANG THAI</p>
                <p><strong>Branch:</strong> MBBANK</p>
            </div>
            <div class="note">
                <p><strong>Note:</strong></p>
                <p>The content must match the provided code. If the system does not respond within 5 minutes after the transfer, please contact support immediately.</p>
=======
=======
>>>>>>> origin/profile
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
<<<<<<< HEAD
>>>>>>> origin/front-end
=======
>>>>>>> origin/profile
            </div>
            <div class="contact">
                <p><strong>Phone:</strong> 0393454486</p>
                <p><strong>Email:</strong> phucdqhe173065@fpt.edu.vn</p>
<<<<<<< HEAD
<<<<<<< HEAD
                <p><strong>Address:</strong> FPT University Hanoi</p>
=======
                <p><strong>Address:</strong> Đại học FPT Hà Nội</p>
>>>>>>> origin/front-end
=======
                <p><strong>Address:</strong> Đại học FPT Hà Nội</p>
>>>>>>> origin/profile
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
<<<<<<< HEAD
<<<<<<< HEAD
=======

          
>>>>>>> origin/front-end
=======

          
>>>>>>> origin/profile
        });
    </script>
</body>
</html>
