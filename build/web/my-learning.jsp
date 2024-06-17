<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>My Learning</title>

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
            background-color: #f8f9fa;
        }
        .container {
            margin-top: 50px;
        }
        .btn-primary {
            background-color: #ff6600;
            border: none;
        }
        .btn-primary:hover {
            background-color: #e65c00;
        }
        .course-container {
            display: none;
        }
        .course {
            display: flex;
            align-items: center;
            background: #fff;
            border: 1px solid #ddd;
            margin: 10px 0;
            padding: 15px;
            border-radius: 5px;
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
        }
        .course img {
            width: 80px;
            height: 80px;
            object-fit: cover;
            border-radius: 5px;
            margin-right: 15px;
        }
        .course-info {
            flex-grow: 1;
        }
        .course h3 {
            font-size: 18px;
            margin-bottom: 10px;
        }
        .course p {
            margin: 5px 0;
            color: #555;
        }
        .course .progress {
            width: 100%;
            height: 8px;
            background-color: #ddd;
            border-radius: 5px;
            overflow: hidden;
            margin-top: 10px;
            margin-bottom: 10px;
        }
        .course .progress-bar {
            height: 100%;
            background-color: #ff6600;
        }
        .buttons {
            margin-bottom: 20px;
            text-align: center;
        }
        .buttons button {
            padding: 10px 20px;
            margin-right: 10px;
            cursor: pointer;
            border: none;
            border-radius: 5px;
            background-color: #ff6600;
            color: #fff;
            font-weight: 500;
        }
        .buttons button:hover {
            background-color: #e65c00;
        }
        .btn-primary a {
            color: #fff;
            text-decoration: none;
        }
        .btn-primary a:hover {
            color: #fff;
        }
    </style>
</head>
<body>
    <!-- Navbar Start -->
    <div class="container-fluid">
        <div class="row border-top px-xl-5">
            <div class="col-lg-3 d-none d-lg-block">
                <a class="d-flex align-items-center justify-content-between bg-secondary w-100 text-decoration-none" data-toggle="collapse" href="#navbar-vertical" style="height: 67px; padding: 0 30px;">
                    <h5 class="text-primary m-0"><i class="fa fa-book-open mr-2"></i>Subjects</h5>
                    <i class="fa fa-angle-down text-primary"></i>
                </a>
                <nav class="collapse position-absolute navbar navbar-vertical navbar-light align-items-start p-0 border border-top-0 border-bottom-0 bg-light" id="navbar-vertical" style="width: calc(100% - 30px); z-index: 9;">
                    <div class="navbar-nav w-100">
                        <div class="nav-item dropdown">
                            <a href="#" class="nav-link" data-toggle="dropdown">Web Design <i class="fa fa-angle-down float-right mt-1"></i></a>
                            <div class="dropdown-menu position-absolute bg-secondary border-0 rounded-0 w-100 m-0">
                                <a href="" class="dropdown-item">HTML</a>
                                <a href="" class="dropdown-item">CSS</a>
                                <a href="" class="dropdown-item">jQuery</a>
                            </div>
                        </div>
                        <a href="" class="nav-item nav-link">Apps Design</a>
                        <a href="" class="nav-item nav-link">Marketing</a>
                        <a href="" class="nav-item nav-link">Research</a>
                        <a href="" class="nav-item nav-link">SEO</a>
                    </div>
                </nav>
            </div>
            <div class="col-lg-9">
                <nav class="navbar navbar-expand-lg bg-light navbar-light py-3 py-lg-0 px-0">
                    <a href="" class="text-decoration-none d-block d-lg-none">
                        <h1 class="m-0"><span class="text-primary">E</span>COURSES</h1>
                    </a>
                    <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse justify-content-between" id="navbarCollapse">
                        <div class="navbar-nav py-0">
                            <a href="index.html" class="nav-item nav-link active">Home</a>
                            <a href="about.html" class="nav-item nav-link">About</a>
                            <a href="course.html" class="nav-item nav-link">Courses</a>
                            <a href="teacher.html" class="nav-item nav-link">Teachers</a>
                            <div class="nav-item dropdown">
                                <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">Blog</a>
                                <div class="dropdown-menu rounded-0 m-0">
                                    <a href="blog.html" class="dropdown-item">Blog List</a>
                                    <a href="single.html" class="dropdown-item">Blog Detail</a>
                                </div>
                            </div>
                            <a href="contact.html" class="nav-item nav-link">Contact</a>
                        </div>
                        <div class="dropdown ml-auto d-none d-lg-block">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <img src="img/avatar.png" alt="User Avatar" class="rounded-circle" style="width: 40px; height: 40px;">
                            </a>
                            <div class="dropdown-menu dropdown-menu-right">
                                <a href="#" class="dropdown-item"><i style="margin-right: 5px;" class="fas fa-user-alt"></i>Profile </a>
                                <a href="#" class="dropdown-item"><i style="margin-right: 5px;" class="fas fa-sign-out-alt"></i>Logout</a>
                            </div>
                        </div>
                    </div>
                </nav>
            </div>
        </div>
    </div>
    <!-- Navbar End -->

    <div class="container">
        <h1 class="text-center">My Learning</h1>
        <div class="buttons">
            <button id="btnInProgress">In Progress</button>
            <button id="btnCompleted">Completed</button>
        </div>

        <div id="inProgressCourses" class="course-container">
            <h2>In Progress</h2>
            <!-- Add your in-progress courses here -->
            <div class="course">
                <img src="./img/course-1.jpg" alt="Course Image">
                <div class="course-info">
                    <h3>Course 1: Spring Boot</h3>
                    <p>Learn how to build applications with Spring Boot.</p>
                    <div class="progress">
                        <div class="progress-bar" style="width: 60%;"></div>
                    </div>
                    <button class="btn btn-primary"><a href="#">Continue</a></button>
                </div>
            </div>
            <div class="course">
                <img src="./img/course-2.jpg" alt="Course Image">
                <div class="course-info">
                    <h3>Course 2: C#</h3>
                    <p>Master the fundamentals of C# programming.</p>
                    <div class="progress">
                        <div class="progress-bar" style="width: 30%;"></div>
                    </div>
                    <button class="btn btn-primary"><a href="#">Continue</a></button>
                </div>
            </div>
        </div>

        <div id="completedCourses" class="course-container">
            <h2>Completed</h2>
            <div class="course">
                <img src="./img/course-3.jpg" alt="Course Image">
                <div class="course-info">
                    <h3>CertNexus Certified Ethical Emerging Technologist Professional Certificate</h3>
                    <p>Certified course on ethical technology and practices.</p>
                    <button class="btn btn-primary"><a href="#">View course</a></button>
                </div>
            </div>
            <div class="course">
                <img src="./img/course-4.jpg" alt="Course Image">
                <div class="course-info">
                    <h3>Software Development Lifecycle Specialization</h3>
                    <p>Complete specialization on software development lifecycle.</p>
                    <button class="btn btn-primary"><a href="#">View course</a></button>
                </div>
            </div>
        </div>
    </div>

    <script>
        document.getElementById('btnInProgress').addEventListener('click', function() {
            document.getElementById('inProgressCourses').style.display = 'block';
            document.getElementById('completedCourses').style.display = 'none';
        });

        document.getElementById('btnCompleted').addEventListener('click', function() {
            document.getElementById('inProgressCourses').style.display = 'none';
            document.getElementById('completedCourses').style.display = 'block';
        });

        // Show completed courses by default
        document.getElementById('btnCompleted').click();
    </script>

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
