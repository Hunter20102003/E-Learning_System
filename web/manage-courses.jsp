<<<<<<< HEAD
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

=======
<%-- 
    Document   : manage-courses
    Created on : May 22, 2024, 11:29:40 PM
    Author     : LEGION
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
>>>>>>> origin/Authentication
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Manage Courses - ECOURSES</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
<<<<<<< HEAD

    <style>
        #example3 th,
        #example3 td {
            width: 12.5%;
            text-align: center;
        }

        .table-responsive {
            overflow-x: auto;
        }

        .table-responsive table {
            width: 100%;
            table-layout: fixed;
        }

        .btn {
            border: none;
            background: none;
            cursor: pointer;
        }

        .btn-edit {
            color: #4CAF50;
        }

        .btn-delete {
            color: #f44336;
        }

        .btn i {
            font-size: 18px;
        }

        #example3 td,
        #example3 th {
            padding: 10px;
        }

        .btn-primary {
            background-color: #FF6600 !important;
            border-color: #FF6600 !important;
        }

        .sidebar {
            position: fixed;
            right: -75%;
            top: 0;
            width: 75%;
            height: 100%;
            background-color: #ffffff;
            box-shadow: -2px 0 5px rgba(0, 0, 0, 0.5);
            transition: right 0.3s ease, background-color 0.3s ease;
            z-index: 1000;
            overflow-y: auto;
        }

        .sidebar-header {
            padding: 20px;
            background-color: #FF6600;
            color: white;
            display: flex;
            justify-content: space-between;
            align-items: center;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        .sidebar-content {
            padding: 20px;
        }

        .big-lesson {
            margin-bottom: 20px;
        }

        .big-lesson-title {
            cursor: pointer;
            background-color: #1a1612a8;
            color: white;
            padding: 10px;
            border-radius: 5px;
            transition: background-color 0.3s ease;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .big-lesson-title:hover {
            background-color: #e65c00;
        }

        .sublesson-list {
            display: none;
            margin-top: 10px;
        }

        .sublesson {
            padding: 5px 10px;
            background-color: #f0f0f0;
            border: 1px solid #ddd;
            border-radius: 5px;
            margin-bottom: 5px;
            transition: background-color 0.3s ease;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .sublesson:hover {
            background-color: #e0e0e0;
        }

        .btn-primary {
            background-color: #FF6600 !important;
            border-color: #FF6600 !important;
        }

        .btn-primary:hover {
            background-color: #e65c00 !important;
            border-color: #e65c00 !important;
        }

        #filterOptions {
            width: 100%;
            padding: 15px;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.2);
            background-color: #fff;
            position: absolute;
            z-index: 1000;
        }

        .form-check-input {
            margin-right: 10px;
        }

        .form-check-label {
            cursor: pointer;
        }

        .form-check-label:hover {
            text-decoration: underline;
        }

        /* CSS cho thanh kÃ©o giÃ¡ tiá»n */
        .price-slider {
            width: 200px;
            margin-bottom: 20px;
        }

        /* CSS cho lá»c sáº£n pháº©m theo sá» sao */
        .star-filter {
            margin-top: 20px;
        }

        .fa-star {
            color: #ccc;
            /* MÃ u máº·c Äá»nh cá»§a biá»u tÆ°á»£ng */
            cursor: pointer;
        }

        .fa-star:hover {
            color: #ff6600;
            /* MÃ u khi hover */
        }
        .stars .star {
    font-size: 30px; /* Äiá»u chá»nh kÃ­ch thÆ°á»c cá»§a biá»u tÆ°á»£ng sao */
}

    /* Additional styles for the col-6 and col-xl-3 sections */
.bg-light {
    background-color: #f8f9fa !important;
}

.ps-3 {
    padding-left: 1rem !important;
}

.py-3 {
    padding-top: 1rem !important;
    padding-bottom: 1rem !important;
}

.rounded {
    border-radius: .25rem !important;
}

.d-flex {
    display: flex !important;
}

.justify-content-between {
    justify-content: space-between !important;
}

.mb-4 {
    margin-bottom: 1.5rem !important;
}

.form-select-sm {
    height: calc(1.5em + .5rem + 2px) !important;
    padding-top: .25rem !important;
    padding-bottom: .25rem !important;
    padding-left: .5rem !important;
    font-size: .875rem !important;
    line-height: 1.5 !important;
    border-radius: .2rem !important;
}
    </style>
</head>

<body>
    <!-- Topbar Start -->
    <div class="container-fluid d-none d-lg-block">
=======
</head>
<body>
     <!-- Topbar Start -->
     <div class="container-fluid d-none d-lg-block">
>>>>>>> origin/Authentication
        <div class="row align-items-center py-4 px-xl-5">
            <div class="col-lg-3">
                <a href="" class="text-decoration-none">
                    <h1 class="m-0"><span class="text-primary">E</span>COURSES</h1>
                </a>
            </div>
            <div class="col-lg-3 text-right">
                <div class="d-inline-flex align-items-center">
                    <i class="fa fa-2x fa-map-marker-alt text-primary mr-3"></i>
                    <div class="text-left">
                        <h6 class="font-weight-semi-bold mb-1">Our Office</h6>
                        <small>123 Street, New York, USA</small>
                    </div>
                </div>
            </div>
            <div class="col-lg-3 text-right">
                <div class="d-inline-flex align-items-center">
                    <i class="fa fa-2x fa-envelope text-primary mr-3"></i>
                    <div class="text-left">
                        <h6 class="font-weight-semi-bold mb-1">Email Us</h6>
                        <small>info@example.com</small>
                    </div>
                </div>
            </div>
            <div class="col-lg-3 text-right">
                <div class="d-inline-flex align-items-center">
                    <i class="fa fa-2x fa-phone text-primary mr-3"></i>
                    <div class="text-left">
                        <h6 class="font-weight-semi-bold mb-1">Call Us</h6>
                        <small>+012 345 6789</small>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Topbar End -->


    <!-- Navbar Start -->
    <div class="container-fluid">
        <div class="row border-top px-xl-5">
            <div class="col-lg-3 d-none d-lg-block">
<<<<<<< HEAD
                <a class="d-flex align-items-center justify-content-between bg-secondary w-100 text-decoration-none"
                    data-toggle="collapse" href="#navbar-vertical" style="height: 67px; padding: 0 30px;">
                    <h5 class="text-primary m-0"><i class="fa fa-book-open mr-2"></i>Subjects</h5>
                    <i class="fa fa-angle-down text-primary"></i>
                </a>
                <nav class="collapse position-absolute navbar navbar-vertical navbar-light align-items-start p-0 border border-top-0 border-bottom-0 bg-light"
                    id="navbar-vertical" style="width: calc(100% - 30px); z-index: 9;">
                    <div class="navbar-nav w-100">
                        <div class="nav-item dropdown">
                            <a href="#" class="nav-link" data-toggle="dropdown">Web Design <i
                                    class="fa fa-angle-down float-right mt-1"></i></a>
=======
                <a class="d-flex align-items-center justify-content-between bg-secondary w-100 text-decoration-none" data-toggle="collapse" href="#navbar-vertical" style="height: 67px; padding: 0 30px;">
                    <h5 class="text-primary m-0"><i class="fa fa-book-open mr-2"></i>Subjects</h5>
                    <i class="fa fa-angle-down text-primary"></i>
                </a>
                <nav class="collapse position-absolute navbar navbar-vertical navbar-light align-items-start p-0 border border-top-0 border-bottom-0 bg-light" id="navbar-vertical" style="width: calc(100% - 30px); z-index: 9;">
                    <div class="navbar-nav w-100">
                        <div class="nav-item dropdown">
                            <a href="#" class="nav-link" data-toggle="dropdown">Web Design <i class="fa fa-angle-down float-right mt-1"></i></a>
>>>>>>> origin/Authentication
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
                        <a class="btn btn-primary py-2 px-4 ml-auto d-none d-lg-block" href="">Join Now</a>
                    </div>
                </nav>
            </div>
        </div>
    </div>
    <!-- Navbar End -->

    <!--**********************************
    Content body start
***********************************-->
<<<<<<< HEAD
    <div class="content-body">
        <div class="container-fluid">

            <!-- Search Bar Start -->
    <div class="container mb-5">
        <div class="row justify-content-center">
            <div class="col-md-8">
                <div class="input-group">
                    <input type="text" class="form-control" placeholder="Search for courses">
                    <div class="input-group-append">
                        <button id="filterButton" class="btn btn-primary" type="button" >
                            <i style="color: white;" id="filterIcon" class="fas fa-filter"></i>
                        </button>
                        <button class="btn btn-primary" type="button">Search</button>
                    </div>
                </div>
                <!-- Filter Options -->
                <div id="filterOptions" class="dropdown-menu dropdown-menu-right mt-2" style="display: none;">
                    <div class="container">
                        <div class="row">
                            <div class="col-md-4">
                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox" id="webDesignCheckbox"
                                        value="webDesign">
                                    <label class="form-check-label" for="webDesignCheckbox">Web Design</label>
                                </div>
                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox" id="developmentCheckbox1"
                                        value="development">
                                    <label class="form-check-label" for="developmentCheckbox1">Development 1</label>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox" id="developmentCheckbox2"
                                        value="development">
                                    <label class="form-check-label" for="developmentCheckbox2">Development 2</label>
                                </div>
                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox" id="developmentCheckbox3"
                                        value="development">
                                    <label class="form-check-label" for="developmentCheckbox3">Development 3</label>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox" id="developmentCheckbox5"
                                        value="development">
                                    <label class="form-check-label" for="developmentCheckbox5">Development 5</label>
                                </div>
                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox" id="developmentCheckbox6"
                                        value="development">
                                    <label class="form-check-label" for="developmentCheckbox6">Development 6</label>
                                </div>
                            </div>
                            <!-- Thanh kÃ©o giÃ¡ tiá»n -->
                            <div class="container">
                                <div id="priceValue">$0</div>
                                <input type="range" min="0" max="100" value="0" class="custom-range" id="priceRange" style="width: 290px;">                                
                            </div>

                            <!-- Bá» lá»c theo sá» sao -->
                            <div class="container">
                                <div class="stars">
                                    <span class="star" data-rating="1">&#9733;</span>
                                    <span class="star" data-rating="2">&#9733;</span>
                                    <span class="star" data-rating="3">&#9733;</span>
                                    <span class="star" data-rating="4">&#9733;</span>
                                    <span class="star" data-rating="5">&#9733;</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- End Filter Options -->
            </div>
        </div>
    </div>
    <!-- Search Bar End -->

    <script>
        // Thanh kÃ©o giÃ¡ tiá»n
        var priceRange = document.getElementById("priceRange");
        var priceValue = document.getElementById("priceValue");

        priceRange.oninput = function () {
            priceValue.innerHTML = "$" + this.value;
        }

        // Bá» lá»c theo sá» sao
        var stars = document.querySelectorAll('.star');
        stars.forEach(function (star) {
            star.addEventListener('click', function () {
                var rating = parseInt(this.getAttribute('data-rating'));
                highlightStars(rating);
            });
        });

        function highlightStars(rating) {
            for (var i = 0; i < stars.length; i++) {
                if (i < rating) {
                    stars[i].style.color = "#ff6600";
                } else {
                    stars[i].style.color = "";
                }
            }
        }


    </script>


    <script>
        document.addEventListener("DOMContentLoaded", function () {
            var filterButton = document.getElementById("filterButton");
            var filterOptions = document.getElementById("filterOptions");

            filterButton.addEventListener("click", function () {
                if (filterOptions.style.display === "none") {
                    filterOptions.style.display = "block";
                } else {
                    filterOptions.style.display = "none";
                }
            });
        });

    </script>

            <!-- Asset List -->
            <div class="row justify-content-center">
                <div class="col-lg-12 col-md-12 col-sm-12">
                    <div class="card">
                        <div class="card-header">
                            <h4 class="card-title">Course List</h4>
                            <a href="#" class="btn btn-primary">+ Add new</a>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table id="example3" class="display" style="min-width: 845px">
                                    <thead>
                                        <tr>
                                            <th>#</th>
                                            <th>Course Name</th>
                                            <th>Course Details</th>
                                            <th>Start Date</th>
                                            <th>Course Price</th>
                                            <th>Instructor Name</th>
                                            <th>Action</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td>1</td>
                                            <td>Java</td>
                                            <td>Java very easy</td>
                                            <td>7 August, 2020</td>
                                            <td>$100</td>
                                            <td>John</td>
                                            <td>
                                                <button class="btn btn-edit"><i class="fas fa-edit"></i></button>
                                                <button class="btn btn-delete"><i class="fas fa-trash"></i></button>
                                                <button class="btn btn-show"><i class="far fa-eye"></i></button>
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- End Asset List -->

            <!-- Add Font Awesome CDN -->
            <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">

            <!-- Sidebar Start -->
            <div id="sidebar" class="sidebar">
                <div class="sidebar-header">
                    <h1>Lessons list</h1>                    
                    <button id="close-sidebar" class="btn btn-primary">Close</button>
                </div>
                <div class="sidebar-content">  
                    <div class="side-bar-header" style="margin-bottom: 15px;">                        
                        <a href="#" class="btn btn-primary">+ Add new</a>
                    </div>                  
                    <div class="big-lesson">
                        <h5 class="big-lesson-title">Big Lesson 1</h5>
                        <div class="sublesson-list">
                            <div class="sublesson">
                                <span>Sublesson 1.1</span>
                                <div>
                                    <button class="btn btn-edit"><i class="fas fa-edit"></i></button>
                                    <button class="btn btn-delete"><i class="fas fa-trash"></i></button>
                                </div>
                            </div>
                            <div class="sublesson">
                                <span>Sublesson 1.2</span>
                                <div>
                                    <button class="btn btn-edit"><i class="fas fa-edit"></i></button>
                                    <button class="btn btn-delete"><i class="fas fa-trash"></i></button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="big-lesson">
                        <h5 class="big-lesson-title">Big Lesson 2</h5>
                        <div class="sublesson-list">
                            <div class="sublesson">
                                <span>Sublesson 2.1</span>
                                <div>
                                    <button class="btn btn-edit"><i class="fas fa-edit"></i></button>
                                    <button class="btn btn-delete"><i class="fas fa-trash"></i></button>
                                </div>
                            </div>
                            <div class="sublesson">
                                <span>Sublesson 2.2</span>
                                <div>
                                    <button class="btn btn-edit"><i class="fas fa-edit"></i></button>
                                    <button class="btn btn-delete"><i class="fas fa-trash"></i></button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="big-lesson">
                        <h5 class="big-lesson-title">Big Lesson 3</h5>
                        <div class="sublesson-list">
                            <div class="sublesson">
                                <span>Sublesson 3.1</span>
                                <div>
                                    <button class="btn btn-edit"><i class="fas fa-edit"></i></button>
                                    <button class="btn btn-delete"><i class="fas fa-trash"></i></button>
                                </div>
                            </div>
                            <div class="sublesson">
                                <span>Sublesson 3.2</span>
                                <div>
                                    <button class="btn btn-edit"><i class="fas fa-edit"></i></button>
                                    <button class="btn btn-delete"><i class="fas fa-trash"></i></button>
                                </div>
                            </div>
=======
<div class="content-body">
    <div class="container-fluid">

        <!-- Page Title and Breadcrumbs -->
        <div class="row page-titles mx-0">
            <div class="col-sm-6 p-md-0">
                <div class="welcome-text">
                    <h4>CRUD Course</h4>
                </div>
            </div>
            <div class="col-sm-6 p-md-0 justify-content-sm-end mt-2 mt-sm-0 d-flex">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="index.html">Home</a></li>
                    <li class="breadcrumb-item active"><a href="#">Courses</a></li>
                    <li class="breadcrumb-item active"><a href="#">Add Courses</a></li>
                    <li class="breadcrumb-item active"><a href="#">Edit Courses</a></li>
                </ol>
            </div>
        </div>
        <!-- End Page Title and Breadcrumbs -->

        <!-- Asset List -->
        <div class="row justify-content-center">
            <div class="col-lg-12 col-md-12 col-sm-12">
                <div class="card">
                    <div class="card-header">
                        <h4 class="card-title">Course List</h4>
                        <a href="#" class="btn btn-primary">+ Add new</a>
                    </div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table id="example3" class="display" style="min-width: 845px">
                                <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>Course Name</th>
                                        <th>Course Details</th>
                                        <th>Start Form</th>
                                        <th>Duration</th>
                                        <th>Course Price</th>
                                        <th>Instructor name</th>
                                        <th>Action</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <td>1</td>
                                    <td>java</td>
                                    <td>java very easy</td>
                                    <td>7 August, 2020</td>
                                    <td>100h</td>
                                    <td>$100</td>
                                    <td>John</td>
                                    <td><i class="fa-solid fa-pen-to-square"></i></td>
                                </tbody>
                            </table>
>>>>>>> origin/Authentication
                        </div>
                    </div>
                </div>
            </div>
<<<<<<< HEAD
            <!-- Sidebar End -->

            
            


            <script>
                //side-bar
                document.addEventListener('DOMContentLoaded', function() {
                    var sidebar = document.getElementById('sidebar');
                    var closeSidebar = document.getElementById('close-sidebar');
                    var showButtons = document.querySelectorAll('.btn-show');
                    var bigLessonTitles = document.querySelectorAll('.big-lesson-title');

                    showButtons.forEach(function(button) {
                        button.addEventListener('click', function() {
                            sidebar.style.right = '0';
                        });
                    });

                    closeSidebar.addEventListener('click', function() {
                        sidebar.style.right = '-75%';
                    });

                    bigLessonTitles.forEach(function(title) {
                        title.addEventListener('click', function() {
                            var sublessonList = this.nextElementSibling;
                            if (sublessonList.style.display === 'none' || sublessonList.style.display === '') {
                                sublessonList.style.display = 'block';
                            } else {
                                sublessonList.style.display = 'none';
                            }
                        });
                    });
                });
                
            </script>
        </div>
    </div>
    <!--**********************************
    Content body end
***********************************-->

    <!-- Footer Start -->
    <div class="container-fluid bg-dark text-white py-5 px-sm-3 px-lg-5" style="margin-top: 90px;">
=======
        </div>
        <!-- End Asset List -->

    </div>
</div>
<!--**********************************
    Content body end
***********************************-->

<style>
    /* Add margin between table cells */
    #example3 td,
    #example3 th {
        padding: 10px; /* Adjust the padding as needed */
    }
</style>

     <!-- Footer Start -->
     <div class="container-fluid bg-dark text-white py-5 px-sm-3 px-lg-5" style="margin-top: 90px;">
>>>>>>> origin/Authentication
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
<<<<<<< HEAD
    <div class="container-fluid bg-dark text-white border-top py-4 px-sm-3 px-md-5"
        style="border-color: rgba(256, 256, 256, .1) !important;">
        <div class="row">
            <div class="col-lg-6 text-center text-md-left mb-3 mb-md-0">
                <p class="m-0 text-white">&copy; <a href="#">Domain Name</a>. All Rights Reserved. Designed by <a
                        href="https://htmlcodex.com">HTML Codex</a>
=======
    <div class="container-fluid bg-dark text-white border-top py-4 px-sm-3 px-md-5" style="border-color: rgba(256, 256, 256, .1) !important;">
        <div class="row">
            <div class="col-lg-6 text-center text-md-left mb-3 mb-md-0">
                <p class="m-0 text-white">&copy; <a href="#">Domain Name</a>. All Rights Reserved. Designed by <a href="https://htmlcodex.com">HTML Codex</a>
>>>>>>> origin/Authentication
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
<<<<<<< HEAD

=======
    
>>>>>>> origin/Authentication
    <!-- JavaScript Libraries -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
</body>
<<<<<<< HEAD

=======
>>>>>>> origin/Authentication
</html>
