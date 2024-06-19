<<<<<<< HEAD
<%-- 
    Document   : editProfile
    Created on : May 22, 2024, 11:26:41 PM
    Author     : LEGION
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
=======
<!DOCTYPE html>
<html lang="en">

>>>>>>> origin/profile
<head>
    <meta charset="UTF-8">
    <title>Edit Profile</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700&display=swap" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
<<<<<<< HEAD
    <meta charset="utf-8">
    <title>ECOURSES - Online Courses HTML Template</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="Free HTML Templates" name="keywords">
    <meta content="Free HTML Templates" name="description">
<<<<<<< HEAD
=======
    <script src="./js/scripts.js"></script>
>>>>>>> origin/front-end
=======
>>>>>>> origin/profile

    <!-- Favicon -->
    <link href="img/favicon.ico" rel="icon">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.gstatic.com">
<<<<<<< HEAD
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700&display=swap" rel="stylesheet"> 
=======
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700&display=swap" rel="stylesheet">
>>>>>>> origin/profile

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
<<<<<<< HEAD
=======

>>>>>>> origin/profile
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
<<<<<<< HEAD
=======

>>>>>>> origin/profile
        .profile-img {
            text-align: center;
            margin-bottom: 20px;
            position: relative;
<<<<<<< HEAD
            display: inline-block;
        }
=======
            display: flex;
            justify-content: center;
            align-items: center;
        }

>>>>>>> origin/profile
        .profile-img img {
            border-radius: 50%;
            width: 150px;
            height: 150px;
            object-fit: cover;
            border: 3px solid #FF6600;
        }
<<<<<<< HEAD
        .profile-img .edit-text {
=======

        .profile-img input[type="file"] {
            display: none;
        }

        .profile-img button {
>>>>>>> origin/profile
            position: absolute;
            bottom: 0;
            left: 50%;
            transform: translateX(-50%);
            background-color: rgba(255, 255, 255, 0.7);
            padding: 5px 10px;
            border-radius: 5px;
<<<<<<< HEAD
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
=======
            cursor: pointer;
            border: none;
            transition: opacity 0.3s ease;
        }

        .profile-img button:hover {
            opacity: 0.8;
        }

        .edit-profile-form {
            margin-top: 20px;
            width: 100%;
        }

        .edit-profile-form label {
            font-weight: bold;
        }

        .edit-profile-form input[type="text"],
        .edit-profile-form input[type="password"],
        .edit-profile-form input[type="email"],
        .edit-profile-form input[type="file"] {
>>>>>>> origin/profile
            width: 100%;
            padding: 10px;
            margin: 5px 0;
            border: 1px solid #ddd;
            border-radius: 5px;
        }
<<<<<<< HEAD
=======

>>>>>>> origin/profile
        .button-container {
            width: 100%;
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-top: 20px;
        }
<<<<<<< HEAD
=======

>>>>>>> origin/profile
        .button-container button {
            flex: 1;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            font-size: 16px;
<<<<<<< HEAD
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
    </style>
</head>
<body>

    <!-- Topbar Start -->
    <jsp:include page="header.jsp"></jsp:include>
    <!-- Navbar End -->

<div class="container">
    <div class="profile-img">
        <img src="${user.avatar}" alt="User Image">
        <div class="edit-text">Edit</div>
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
<<<<<<< HEAD
            <button class="back-button" onclick="window.location.href='profile.html'">Back</button>
            <button class="save-button" type="submit">Save Changes</button>
=======
            <button class="back-button" onclick="window.location.href='profile.jsp'">Back</button>
            <button style="margin-top: 20px" class="save-button" type="submit">Save Changes</button>
>>>>>>> origin/front-end
        </div>
    </form>
</div>

<<<<<<< HEAD
=======
        <!-- Footer Start -->
    <jsp:include page="footer.jsp"></jsp:include>
    <!-- Footer End -->
>>>>>>> origin/front-end
</body>
=======
            text-align: center;
            text-decoration: none;
            color: #fff;
            cursor: pointer;
            max-width: 48%;
        }

        .back-button {
            background-color: #ccc;
            margin-top: 0;
        }

        .back-button:hover {
            opacity: 0.8;
        }

        .save-button {
            background-color: #ff6600;
        }

        .save-button:hover {
            opacity: 0.8;
        }
         .error-message {
            color: red;
        }
    </style>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script>
        function chooseFile(input) {
            const file = input.files[0];
            if (file) {
                const reader = new FileReader();
                reader.onload = function(e) {
                    document.getElementById('image').src = e.target.result;
                };
                reader.readAsDataURL(file);
            }
        }
    </script>
</head>

<body>
    <!-- Topbar Start -->
    <jsp:include page="header.jsp" />
    <!-- Navbar End -->

    <div class="container">
        <form class="edit-profile-form" action="${pageContext.request.contextPath}/update-profile" method="post" enctype="multipart/form-data">
            <div class="profile-img">
                <img src="${pageContext.request.contextPath}/${user.avatar}" alt="User Image" id="image">
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
            <div class="button-container">
                <button class="back-button" onclick="window.location.href = 'index.jsp'" type="button">Back</button>
                <button class="save-button" type="submit">Save Changes</button>
            </div>
        </form>
    </div>

    <!-- Footer Start -->
    <div class="container-fluid bg-dark text-white py-5 px-sm-3 px-lg-5" style="margin-top: 90px;">
        <div class="row pt-5">
            <div class="col-lg-7 col-md-12">
                <div class="row">
                    <div class="col-md-6 mb-5">
                        <h5 class="text-primary text-uppercase mb-4" style="letter-spacing: 5px;">Get In Touch</h5>
                        <p><i class="fa fa-map-marker-alt mr-2"></i>123 Street, New York, USA</p>
                        <p><i class="fa fa-phone-alt mr-2"></i>+012 345 67890</p>
                        <p><i class="fa fa-envelope mr-2"></i>info@example.com</p>
                        <div class="d-flex justify-content-start mt-4">
                            <a class="btn btn-outline-light btn-square mr-2" href="#"><i class="fab fa-twitter"></i></a>
                            <a class="btn btn-outline-light btn-square mr-2" href="#"><i class="fab fa-facebook-f"></i></a>
                            <a class="btn btn-outline-light btn-square mr-2" href="#"><i class="fab fa-linkedin-in"></i></a>
                            <a class="btn btn-outline-light btn-square" href="#"><i class="fab fa-instagram"></i></a>
                        </div>
                    </div>
                    <div class="col-md-6 mb-5">
                        <h5 class="text-primary text-uppercase mb-4" style="letter-spacing: 5px;">Our Courses</h5>
                        <div class="d-flex flex-column justify-content-start">
                            <a class="text-white mb-2" href="#"><i class="fa fa-angle-right mr-2"></i>Web Design</a>
                            <a class="text-white mb-2" href="#"><i class="fa fa-angle-right mr-2"></i>Apps Design</a>
                            <a class="text-white mb-2" href="#"><i class="fa fa-angle-right mr-2"></i>Marketing</a>
                            <a class="text-white mb-2" href="#"><i class="fa fa-angle-right mr-2"></i>Research</a>
                            <a class="text-white" href="#"><i class="fa fa-angle-right mr-2"></i>SEO</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-5 col-md-12 mb-5">
                <h5 class="text-primary text-uppercase mb-4" style="letter-spacing: 5px;">Newsletter</h5>
                <p>Rebum labore lorem dolores kasd est, et ipsum amet et at kasd, ipsum sea tempor magna tempor. Accu kasd sed ea duo ipsum. Dolor duo eirmod sea justo no lorem est diam</p>
                <div class="w-100">
                    <div class="input-group">
                        <input type="text" class="form-control border-light" style="padding: 30px;" placeholder="Your Email Address">
                        <div class="input-group-append">
                            <button class="btn btn-primary px-4">Sign Up</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="container-fluid bg-dark text-white border-top py-4 px-sm-3 px-md-5" style="border-color: rgba(256, 256, 256, .1) !important;">
        <div class="row">
            <div class="col-lg-6 text-center text-md-left mb-3 mb-md-0">
                <p class="m-0 text-white">&copy; <a href="#">Domain Name</a>. All Rights Reserved. Designed by <a href="https://htmlcodex.com">HTML Codex</a>
                </p>
            </div>
            <div class="col-lg-6 text-center text-md-right">
                <ul class="nav d-inline-flex">
                    <li class="nav-item">
                        <a class="nav-link text-white py-0" href="#">Privacy</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-white py-0" href="#">Terms</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-white py-0" href="#">FAQs</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-white py-0" href="#">Help</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    <!-- Footer End -->
</body>

>>>>>>> origin/profile
</html>
