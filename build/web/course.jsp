<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

    <head>
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
        </style>

    </head>

    <body>
        <!-- Topbar Start -->
        <jsp:include page="header.jsp"></jsp:include>
            <!-- Navbar End -->


            <!-- Header Start -->
            <div class="container-fluid page-header" style="margin-bottom: 90px;">
                <div class="container">
                    <div class="d-flex flex-column justify-content-center" style="min-height: 300px">
                        <h3 class="display-4 text-white text-uppercase">Courses</h3>
                        <div class="d-inline-flex text-white">
                            <p class="m-0 text-uppercase"><a class="text-white" href="">Home</a></p>
                            <i class="fa fa-angle-double-right pt-1 px-3"></i>
                            <p class="m-0 text-uppercase">Courses</p>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Header End -->

            <!-- Search Bar Start -->
            <div class="container mb-5">
                <div class="row justify-content-center">
                    <div class="col-md-8">
                        <div class="input-group">
                            <input type="text" class="form-control" placeholder="Search for courses">
                            <div class="input-group-append">
                                <button style="background-color: white;" id="filterButton" class="btn btn-primary"
                                        type="button">
                                    <i style="color: #f60;" id="filterIcon" class="fas fa-filter"></i>
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
                                        <div><label >Price</label></div>
                                        <input type="range" min="0" max="100" value="0" class="custom-range" id="priceRange" style="width: 290px;">  
                                        <div id="priceValue">$0</div>
                                    </div>

                                    <!-- Bộ lọc theo số sao -->

                                    <div class="container">
                                        <div>Rate</div>
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


            <!-- Category Start -->
            <div class="container-fluid py-5">
                <div class="container pt-5 pb-3">
                    <div class="text-center mb-5">
                        <h5 class="text-primary text-uppercase mb-3" style="letter-spacing: 5px;">Subjects</h5>
                        <h1>Explore Top Subjects</h1>
                    </div>
                    <div class="row">
                        <div class="col-lg-3 col-md-6 mb-4">
                            <div class="cat-item position-relative overflow-hidden rounded mb-2">
                                <img class="img-fluid" src="img/cat-1.jpg" alt="">
                                <a class="cat-overlay text-white text-decoration-none" href="">
                                    <h4 class="text-white font-weight-medium">Web Design</h4>
                                    <span>100 Courses</span>
                                </a>
                            </div>
                        </div>
                        <div class="col-lg-3 col-md-6 mb-4">
                            <div class="cat-item position-relative overflow-hidden rounded mb-2">
                                <img class="img-fluid" src="img/cat-2.jpg" alt="">
                                <a class="cat-overlay text-white text-decoration-none" href="">
                                    <h4 class="text-white font-weight-medium">Development</h4>
                                    <span>100 Courses</span>
                                </a>
                            </div>
                        </div>
                        <div class="col-lg-3 col-md-6 mb-4">
                            <div class="cat-item position-relative overflow-hidden rounded mb-2">
                                <img class="img-fluid" src="img/cat-3.jpg" alt="">
                                <a class="cat-overlay text-white text-decoration-none" href="">
                                    <h4 class="text-white font-weight-medium">Game Design</h4>
                                    <span>100 Courses</span>
                                </a>
                            </div>
                        </div>
                        <div class="col-lg-3 col-md-6 mb-4">
                            <div class="cat-item position-relative overflow-hidden rounded mb-2">
                                <img class="img-fluid" src="img/cat-4.jpg" alt="">
                                <a class="cat-overlay text-white text-decoration-none" href="">
                                    <h4 class="text-white font-weight-medium">Apps Design</h4>
                                    <span>100 Courses</span>
                                </a>
                            </div>
                        </div>
                        <div class="col-lg-3 col-md-6 mb-4">
                            <div class="cat-item position-relative overflow-hidden rounded mb-2">
                                <img class="img-fluid" src="img/cat-5.jpg" alt="">
                                <a class="cat-overlay text-white text-decoration-none" href="">
                                    <h4 class="text-white font-weight-medium">Marketing</h4>
                                    <span>100 Courses</span>
                                </a>
                            </div>
                        </div>
                        <div class="col-lg-3 col-md-6 mb-4">
                            <div class="cat-item position-relative overflow-hidden rounded mb-2">
                                <img class="img-fluid" src="img/cat-6.jpg" alt="">
                                <a class="cat-overlay text-white text-decoration-none" href="">
                                    <h4 class="text-white font-weight-medium">Research</h4>
                                    <span>100 Courses</span>
                                </a>
                            </div>
                        </div>
                        <div class="col-lg-3 col-md-6 mb-4">
                            <div class="cat-item position-relative overflow-hidden rounded mb-2">
                                <img class="img-fluid" src="img/cat-7.jpg" alt="">
                                <a class="cat-overlay text-white text-decoration-none" href="">
                                    <h4 class="text-white font-weight-medium">Content Writing</h4>
                                    <span>100 Courses</span>
                                </a>
                            </div>
                        </div>
                        <div class="col-lg-3 col-md-6 mb-4">
                            <div class="cat-item position-relative overflow-hidden rounded mb-2">
                                <img class="img-fluid" src="img/cat-8.jpg" alt="">
                                <a class="cat-overlay text-white text-decoration-none" href="">
                                    <h4 class="text-white font-weight-medium">SEO</h4>
                                    <span>100 Courses</span>
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Category Start -->


            <!-- Courses Start -->
            <div class="container-fluid py-5">
                <div class="container py-5">
                    <div class="text-center mb-5">
                        <h5 class="text-primary text-uppercase mb-3" style="letter-spacing: 5px;">Courses</h5>
                        <h1>Our Popular Courses</h1>
                    </div>
                    <div class="row">
                    <c:forEach var="i" items="${listCourse}">
                        <c:if test="${i.is_locked == false}">
                            <div class="col-lg-4 col-md-6 mb-4">
                                <div class="rounded overflow-hidden mb-2">
                                    <img class="img-fluid" src="${i.img}" alt="">
                                    <div class="bg-secondary p-4">
                                        <div class="d-flex justify-content-between mb-3">
                                            <small class="m-0"><i class="fa fa-users text-primary mr-2"></i>25 Students</small>
                                            <small class="m-0"><i class="far fa-clock text-primary mr-2"></i>01h 30m</small>
                                        </div>
                                        <a class="h5" href="course/detail?course_id=${i.id}">${i.name}</a>
                                        <div class="border-top mt-4 pt-4">
                                            <div class="d-flex justify-content-between">
                                                <h6 class="m-0"><i class="fa fa-star text-primary mr-2"></i>4.5 <small>(250)</small>
                                                </h6>
                                                <c:choose>
                                                    <c:when test="${i.price eq 0}"> <h5 class="m-0" style="color:green">Free</h5></c:when>
                                                    <c:otherwise> <h5 class="m-0">${i.price}</h5></c:otherwise>
                                                </c:choose>

                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:if>      
                    </c:forEach>
                    <div class="col-lg-4 col-md-6 mb-4">
                        <div class="rounded overflow-hidden mb-2">
                            <img class="img-fluid" src="https://static.tildacdn.com/tild3134-3265-4538-b332-316238363631/YouTube-Icon-Full-Co.svg" alt="">
                            <div class="bg-secondary p-4">
                                <div class="d-flex justify-content-between mb-3">
                                    <small class="m-0"><i class="fa fa-users text-primary mr-2"></i>25 Students</small>
                                    <small class="m-0"><i class="far fa-clock text-primary mr-2"></i>01h 30m</small>
                                </div>
                                <a class="h5" href="">Web design & development courses for beginner</a>
                                <div class="border-top mt-4 pt-4">
                                    <div class="d-flex justify-content-between">
                                        <h6 class="m-0"><i class="fa fa-star text-primary mr-2"></i>4.5 <small>(250)</small>
                                        </h6>
                                        <h5 class="m-0">$99</h5>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6 mb-4">
                        <div class="rounded overflow-hidden mb-2">
                            <img class="img-fluid" src="img/course-2.jpg" alt="">
                            <div class="bg-secondary p-4">
                                <div class="d-flex justify-content-between mb-3">
                                    <small class="m-0"><i class="fa fa-users text-primary mr-2"></i>25 Students</small>
                                    <small class="m-0"><i class="far fa-clock text-primary mr-2"></i>01h 30m</small>
                                </div>
                                <a class="h5" href="">Web design & development courses for beginner</a>
                                <div class="border-top mt-4 pt-4">
                                    <div class="d-flex justify-content-between">
                                        <h6 class="m-0"><i class="fa fa-star text-primary mr-2"></i>4.5 <small>(250)</small>
                                        </h6>
                                        <h5 class="m-0">$99</h5>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6 mb-4">
                        <div class="rounded overflow-hidden mb-2">
                            <img class="img-fluid" src="img/course-3.jpg" alt="">
                            <div class="bg-secondary p-4">
                                <div class="d-flex justify-content-between mb-3">
                                    <small class="m-0"><i class="fa fa-users text-primary mr-2"></i>25 Students</small>
                                    <small class="m-0"><i class="far fa-clock text-primary mr-2"></i>01h 30m</small>
                                </div>
                                <a class="h5" href="">Web design & development courses for beginner</a>
                                <div class="border-top mt-4 pt-4">
                                    <div class="d-flex justify-content-between">
                                        <h6 class="m-0"><i class="fa fa-star text-primary mr-2"></i>4.5 <small>(250)</small>
                                        </h6>
                                        <h5 class="m-0">$99</h5>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6 mb-4">
                        <div class="rounded overflow-hidden mb-2">
                            <img class="img-fluid" src="img/course-4.jpg" alt="">
                            <div class="bg-secondary p-4">
                                <div class="d-flex justify-content-between mb-3">
                                    <small class="m-0"><i class="fa fa-users text-primary mr-2"></i>25 Students</small>
                                    <small class="m-0"><i class="far fa-clock text-primary mr-2"></i>01h 30m</small>
                                </div>
                                <a class="h5" href="">Web design & development courses for beginner</a>
                                <div class="border-top mt-4 pt-4">
                                    <div class="d-flex justify-content-between">
                                        <h6 class="m-0"><i class="fa fa-star text-primary mr-2"></i>4.5 <small>(250)</small>
                                        </h6>
                                        <h5 class="m-0">$99</h5>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6 mb-4">
                        <div class="rounded overflow-hidden mb-2">
                            <img class="img-fluid" src="img/course-5.jpg" alt="">
                            <div class="bg-secondary p-4">
                                <div class="d-flex justify-content-between mb-3">
                                    <small class="m-0"><i class="fa fa-users text-primary mr-2"></i>25 Students</small>
                                    <small class="m-0"><i class="far fa-clock text-primary mr-2"></i>01h 30m</small>
                                </div>
                                <a class="h5" href="">Web design & development courses for beginner</a>
                                <div class="border-top mt-4 pt-4">
                                    <div class="d-flex justify-content-between">
                                        <h6 class="m-0"><i class="fa fa-star text-primary mr-2"></i>4.5 <small>(250)</small>
                                        </h6>
                                        <h5 class="m-0">$99</h5>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6 mb-4">
                        <div class="rounded overflow-hidden mb-2">
                            <img class="img-fluid" src="img/course-6.jpg" alt="">
                            <div class="bg-secondary p-4">
                                <div class="d-flex justify-content-between mb-3">
                                    <small class="m-0"><i class="fa fa-users text-primary mr-2"></i>25 Students</small>
                                    <small class="m-0"><i class="far fa-clock text-primary mr-2"></i>01h 30m</small>
                                </div>
                                <a class="h5" href="">Web design & development courses for beginner</a>
                                <div class="border-top mt-4 pt-4">
                                    <div class="d-flex justify-content-between">
                                        <h6 class="m-0"><i class="fa fa-star text-primary mr-2"></i>4.5 <small>(250)</small>
                                        </h6>
                                        <h5 class="m-0">$99</h5>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Courses End -->


        <!-- Footer Start -->
        <jsp:include page="footer.jsp"></jsp:include>

        <!-- Footer End -->


        <!-- Back to Top -->
        <a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top"><i class="fa fa-angle-double-up"></i></a>

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