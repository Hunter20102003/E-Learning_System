<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Manage Courses - ECOURSES</title>
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

        <link href="css/style.css" rel="stylesheet">

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

            /* CSS cho thanh kéo giá tiền */
            .price-slider {
                width: 200px;
                margin-bottom: 20px;
            }

            /* CSS cho lọc sản phẩm theo số sao */
            .star-filter {
                margin-top: 20px;
            }

            .fa-star {
                color: #ccc;
                /* Màu mặc định của biểu tượng */
                cursor: pointer;
            }

            .fa-star:hover {
                color: #ff6600;
                /* Màu khi hover */
            }
            .stars .star {
                font-size: 30px; /* Điều chỉnh kích thước của biểu tượng sao */
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
        <jsp:include page="header.jsp"></jsp:include>
            <!-- Topbar End -->




            <!--**********************************
            Content body start
        ***********************************-->
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
                                            <!-- Thanh kéo giá tiền -->
                                            <div class="container">
                                                <div id="priceValue">$0</div>
                                                <input type="range" min="0" max="100" value="0" class="custom-range" id="priceRange" style="width: 290px;">                                
                                            </div>

                                            <!-- Bộ lọc theo số sao -->
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
                        // Thanh kéo giá tiền
                        var priceRange = document.getElementById("priceRange");
                        var priceValue = document.getElementById("priceValue");

                        priceRange.oninput = function () {
                            priceValue.innerHTML = "$" + this.value;
                        }

                        // Bộ lọc theo số sao
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


                    <div class="container">
                        <div class="row justify-content-center">
                            <div class="col-lg-12 col-md-12 col-sm-12">
                                <div class="card">
                                    <div class="card-header">
                                        <h4 class="card-title">Course List</h4>
                                        <a href="manage-courses.jsp" class="btn btn-primary">+ Add new</a>
                                    </div>
                                    <div class="card-body">
                                        <div class="table-responsive">
                                            <table id="example3" class="display table" style="min-width: 900px">
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

                                                <c:forEach var="i" items="${course}">
                                                    <tr>
                                                        <td>${i.id}</td>
                                                        <td>${i.name}</td>
                                                        <td>${i.description}</td>
                                                        <td>123123</td>
                                                        <td>123</td>
                                                        <td>123</td>
                                                        <td>
                                                            <button class="btn btn-edit" onclick="Edit('${i.id}')"><i class="fas fa-edit"></i></button>
                                                            <button class="btn btn-delete" onclick="Delete('${i.id}')"><i class="fas fa-trash"></i></button>
                                                            <button class="btn btn-show"onclick="Show('${i.id}')"><i class="far fa-eye"></i></button>
                                                        </td>
                                                    </tr>
                                                </c:forEach>

                                            </tbody>
                                        </table>
                                    </div>
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

                        </div>                  
                        <div class="big-lesson">
                            <h5 class="big-lesson-title">Big Lesson 1</h5>
                            <div class="sublesson-list">
                                <div class="sublesson">
                                    <span>Sublesson 1.1</span>
                                    <div>

                                    </div>
                                </div>
                                <div class="sublesson">
                                    <span>Sublesson 1.2</span>
                                    <div>

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

                                    </div>
                                </div>
                                <div class="sublesson">
                                    <span>Sublesson 2.2</span>
                                    <div>

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

                                    </div>
                                </div>
                                <div class="sublesson">
                                    <span>Sublesson 3.2</span>
                                    <div>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Sidebar End -->





                <script>
                    //side-bar
                    document.addEventListener('DOMContentLoaded', function () {
                        var sidebar = document.getElementById('sidebar');
                        var closeSidebar = document.getElementById('close-sidebar');
                        var showButtons = document.querySelectorAll('.btn-show');
                        var bigLessonTitles = document.querySelectorAll('.big-lesson-title');

                        showButtons.forEach(function (button) {
                            button.addEventListener('click', function () {
                                sidebar.style.right = '0';
                            });
                        });

                        closeSidebar.addEventListener('click', function () {
                            sidebar.style.right = '-75%';
                        });

                        bigLessonTitles.forEach(function (title) {
                            title.addEventListener('click', function () {
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
        <div class="container-fluid bg-dark text-white border-top py-4 px-sm-3 px-md-5"
             style="border-color: rgba(256, 256, 256, .1) !important;">
            <div class="row">
                <div class="col-lg-6 text-center text-md-left mb-3 mb-md-0">
                    <p class="m-0 text-white">&copy; <a href="#">Domain Name</a>. All Rights Reserved. Designed by <a
                            href="https://htmlcodex.com">HTML Codex</a>
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
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>

        <script>

                    function Edit(id) {
                        alert(id)
                    }

                    function Delete(id) {
                        alert(id)
                    }
                    function Show(id) {
                        alert(id)
                    }

        </script>
    </body>

</html>
