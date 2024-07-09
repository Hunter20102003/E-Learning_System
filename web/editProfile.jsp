<<<<<<< Updated upstream
<%-- 
    Document   : editProfile
    Created on : May 22, 2024, 11:26:41 PM
    Author     : LEGION
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
=======
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
>>>>>>> Stashed changes
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit Profile</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700&display=swap" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
    <meta charset="utf-8">
    <title>ECOURSES - Online Courses HTML Template</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="Free HTML Templates" name="keywords">
    <meta content="Free HTML Templates" name="description">

    <!-- Favicon -->
    <link href="img/favicon.ico" rel="icon">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700&display=swap" rel="stylesheet"> 

    <!-- Font Awesome -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

    <!-- Customized Bootstrap Stylesheet -->
    <link href="css/style.css" rel="stylesheet">
    <style>
        body {
            font-family: 'Poppins', sans-serif;
            background-color: white;
            color: #333;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 100%;
            max-width: 600px;
            margin: 50px auto;
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 10px;
            background-color: #fff;
            display: flex;
            flex-direction: column;
            align-items: center;
        }
        .profile-img {
            text-align: center;
            margin-bottom: 20px;
            position: relative;
            display: inline-block;
        }
        .profile-img img {
            border-radius: 50%;
            width: 150px;
            height: 150px;
            object-fit: cover;
            border: 3px solid #FF6600;
        }
        .profile-img .edit-text {
            position: absolute;
            bottom: 0;
            left: 50%;
            transform: translateX(-50%);
            background-color: rgba(255, 255, 255, 0.7);
            padding: 5px 10px;
            border-radius: 5px;
            opacity: 0;
            transition: opacity 0.3s ease;
        }
        .profile-img:hover .edit-text {
            opacity: 1;
        }
        .edit-profile-form {
            margin-top: 20px;
            width: 100%; /* Ensure form width matches container width */
        }
        .edit-profile-form label {
            font-weight: bold;
        }
        .edit-profile-form input[type="text"],
        .edit-profile-form input[type="password"],
        .edit-profile-form input[type="email"] {
            width: 100%;
            padding: 10px;
            margin: 5px 0;
            border: 1px solid #ddd;
            border-radius: 5px;
        }
        .button-container {
            width: 100%;
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-top: 20px;
        }
        .button-container button {
            flex: 1;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
        }
        .back-button {
            background-color: #ccc;
            color: #fff;
            margin-right: 10px;
        }
        .back-button:hover {
            opacity: 0.8;
        }
        .save-button {
            background-color: #FF6600;
            color: #fff;
            margin-left: 10px;
        }
        .save-button:hover {
            opacity: 0.8;
        }
<<<<<<< Updated upstream
=======
         .error-message {
            color: red;
        }
        .complete-message{
            color : green;
        }
>>>>>>> Stashed changes
    </style>
</head>
<body>

    <!-- Topbar Start -->
    <jsp:include page="header.jsp"></jsp:include>
    <!-- Navbar End -->

<<<<<<< Updated upstream
<div class="container">
    <div class="profile-img">
        <img src="${user.avatar}" alt="User Image">
        <div class="edit-text">Edit</div>
=======
    <div class="container">
        <form class="edit-profile-form" action="${pageContext.request.contextPath}/update-profile" method="post" enctype="multipart/form-data">
            <div class="profile-img">
                <img src="${user.avatar}" alt="User Image" id="image">
                <input type="file" id="profile-pic" name="avatar" onchange="chooseFile(this)" accept="image/png, image/jpeg, image/gif">
                <button type="button" id="upload-btn" onclick="document.getElementById('profile-pic').click()">Edit</button>
            </div>
            <div>
                <label for="firstname">First Name:</label>
                <input type="text" id="firstname" name="firstname" value="${user.firstName}">
            </div>
            <div>
                <label for="lastname">Last Name:</label>
                <input type="text" id="lastname" name="lastname" value="${user.lastName}">
            </div>
            <div>
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" value="${user.email}">
            </div>
            <div id="error-message" class="error-message">${errorEmail}</div>
            <div id="error-message" class="error-message">${errorName}</div>
            <div id="complete-message" class="complete-message">${complete}</div>
            <div class="button-container">
                <button class="back-button" onclick="window.location.href = 'index.jsp'" type="button">Back</button>
                <button class="save-button" type="submit">Save Changes</button>
            </div>
        </form>
>>>>>>> Stashed changes
    </div>
    <form class="edit-profile-form" action="/update_profile" method="post">
<!--        <div>
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" value="${user.username}">
        </div>-->
        <div>
            <label for="fullname">First Name</label>
            <input type="text" id="fisrtname" name="firstname" value="${user.firstName}">
        </div>
        <div>
            <label for="fullname">Last Name</label>
            <input type="text" id="lastname" name="lastname" value="${user.lastName}">
        </div>
        <div>
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" value="${user.email}">
        </div>
        <div class="button-container">
            <button class="back-button" onclick="window.location.href='profile.jsp'">Back</button>
            <button style="margin-top: 20px" class="save-button" type="submit">Save Changes</button>
        </div>
    </form>
</div>

        <!-- Footer Start -->
    <jsp:include page="footer.jsp"></jsp:include>
    <!-- Footer End -->
</body>
<<<<<<< Updated upstream
</html>
=======

</html>
>>>>>>> Stashed changes
