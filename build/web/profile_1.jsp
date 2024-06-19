<%-- 
    Document   : profile
    Created on : May 22, 2024, 11:30:12 PM
    Author     : LEGION
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>User Profile</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700&display=swap" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="Free HTML Templates" name="keywords">
    <meta content="Free HTML Templates" name="description">
    <script src="./js/scripts.js"></script>

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
            background-color: #fff;
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
        }

        .profile-img {
            text-align: center;
            margin-bottom: 20px;
        }

        .profile-img img {
            border-radius: 50%;
            width: 150px;
            height: 150px;
            object-fit: cover;
            border: 3px solid #FF6600;
        }

        .profile-info {
            text-align: center;
        }

        .profile-info h2 {
            margin: 10px 0;
            color: #FF6600;
        }

        .profile-info p {
            margin: 5px 0;
        }

        .profile-info label {
            font-weight: bold;
        }

        .buttons {
            text-align: center;
            margin-top: 20px;
        }

        .buttons button {
            padding: 10px 20px;
            margin: 5px;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
        }

        .back-button {
            background-color: #ccc;
            color: #fff;
        }

        .edit-button {
            background-color: #FF6600;
            color: #fff;
        }

        .back-button:hover,
        .edit-button:hover {
            opacity: 0.8;
        }
    </style>
</head>

<body>
    <!-- Topbar Start -->
    <jsp:include page="header.jsp"></jsp:include>
    <!-- Navbar End -->

    <div class="container">
        <div class="profile-img">
            <img src="img/user.jpg" alt="User Image">
        </div>
        <div class="profile-info">
            <h2>John Doe</h2>
            <p><label>Username:</label> johndoe</p>
            <p><label>FullName:</label> Mr.johndoe</p>
            <p><label>Email:</label> johndoe@example.com</p>
        </div>
        <div class="buttons">
            <button class="back-button" onclick="window.location.href='index.jsp'">Back</button>
            <button class="edit-button" onclick="window.location.href='editProfile.jsp'">Edit Profile</button>
        </div>
    </div>

    <!-- Footer Start -->
    <jsp:include page="footer.jsp"></jsp:include>
    <!-- Footer End -->

    <!-- JavaScript Libraries -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
    <script src="lib/easing/easing.min.js"></script>
    <script src="lib/owlcarousel/owl.carousel.min.js"></script>

    <!-- Contact Javascript File -->
    <script src="mail/jqBootstrapValidation.min.js"></script>
    <script src="mail/contact.js"></script>

    <!-- Template Javascript -->
    <script src="js/main.js"></script>
</body>

</html>
