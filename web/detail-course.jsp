<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix ="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>Course Detail - ECOURSES</title>
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
        <link href="lib/owlcarousel/assets/owl.theme.default.min.css" rel="stylesheet">


        <!-- Customized Bootstrap Stylesheet -->

        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">

        <!-- jQuery -->
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <!-- Owl Carousel JS -->
        <script src="lib/owlcarousel/owl.carousel.min.js"></script>

        <style>
            .reviews-container {
                background-color: #f8f9fa;
                padding: 30px;
                border-radius: 10px;
            }

            .review {
                border-bottom: 1px solid #ddd;
                padding: 15px 0;
            }

            .review:last-child {
                border-bottom: none;
            }

            .review h6 {
                font-size: 16px;
                font-weight: 600;
                color: #333;
            }

            .review p {
                font-size: 14px;
                color: #555;
            }

            .slideshow-container {
                max-width: 100%;
                overflow: hidden;
                /* Ẩn các phần ngoài khung để chỉ hiển thị 3 ảnh */
                position: relative;
                margin: auto;
            }

            .slides {
                display: flex;
                /* Sử dụng flexbox để xếp các slide ngang nhau */
                transition: transform 0.5s ease;
                /* Hiệu ứng chuyển động */
            }

            .slide {
                flex: 0 0 33.33%;
                /* Mỗi slide chiếm 1/3 chiều rộng của container */
                overflow: hidden;
                /* Ẩn phần ngoài khung của mỗi slide */
            }

            .slide img {
                width: 100%;
                display: block;
            }


            .fa-heart-filled {
                color: red;
            }
        </style>
    </head>
    <body>

        <!-- Topbar Start -->
        <jsp:include page ="header.jsp"></jsp:include>
            <!-- Navbar End -->

            <!-- Header Start -->
            <div class="container-fluid page-header" style="margin-bottom: 90px;">
                <div class="container">
                    <div class="d-flex flex-column justify-content-center" style="min-height: 300px">
                        <h3 class="display-4 text-white text-uppercase">Course Detail</h3>
                        <div class="d-inline-flex text-white">
                            <p class="m-0 text-uppercase"><a class="text-white" href="index.html">Home</a></p>
                            <i class="fa fa-angle-double-right pt-1 px-3"></i>
                            <p class="m-0 text-uppercase">Course Detail</p>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Header End -->

            <!-- Course Detail Start -->
            <div class="container mt-5">
                <div class="row">
                    <div class="col-lg-8">
                        <div class="mb-5">
                            <img class="img-fluid w-100" src="img/course-detail.jpg" alt="">
                            <h2 class="mt-4">${course.title}</h2>
                        <p>${course.description}</p>
                        <h4 class="mt-4">Course Details</h4>
                        <ul>
                            <li><i class="fa fa-check text-primary mr-2"></i>Duration: ${durationCourse}</li>
                                <c:choose>
                                    <c:when test="${course.price > 0}">
                                        <fmt:formatNumber var="i" value="${course.price}" pattern="#,###"  />
                                    <li><i class="fa fa-check text-primary mr-2"></i>Price: ${i}đ</li>                        
                                    </c:when>
                                    <c:otherwise>
                                    <li ><i class="fa fa-check text-primary mr-2" ></i>Price: <span style="color:green">Free</span></li>

                                </c:otherwise>
                            </c:choose>
                        </ul>
                        <h4 class="mt-4">What You'll Learn</h4>
                        <ul>
                            <c:forEach var="i" items="${listLesson}">
                                <li><i class="fa fa-check text-primary mr-2"></i>${i.title}</li>

                            </c:forEach>

                        </ul>
                    </div>

                    <h4 class="mt-4">Related courses</h4>
                    <c:forEach var="i" items="${listRelatedCourse}">
                        <a href="${pageContext.request.contextPath}/course/detail?course_id=${i.id}" class="d-block mb-3"><i class="fa fa-angle-right mr-2"></i>${i.name}</a>
                        </c:forEach>
                    <!-- Slider Start -->
                    <!--                    <div class="slideshow-container">
                                            <div class="slides">
                    <c:forEach var="i" items="${listRelatedCourse}">
                    <div class="slide">
                        <a href="#"><img src="${i.img}" alt="Slide 1"></a>
                    </div>
                    </c:forEach>
                </div>
            </div>-->
                    <!-- Slider End -->

                    <!--                    <script>
                                            document.addEventListener("DOMContentLoaded", function () {
                                                var currentSlideIndex = 0;
                                                var totalSlides = document.querySelectorAll('.slide').length;
                                                var slideWidth = document.querySelector('.slide').clientWidth;
                                                var slidesContainer = document.querySelector('.slides');
                    
                                                // Clone first slide and append to the end for seamless loop
                                                slidesContainer.appendChild(slidesContainer.firstElementChild.cloneNode(true));
                    
                                                var slideInterval = setInterval(nextSlide, 3000);
                    
                                                function nextSlide() {
                                                    currentSlideIndex++;
                                                    var offset = -currentSlideIndex * slideWidth;
                    
                                                    slidesContainer.style.transition = 'transform 0.5s ease';
                                                    slidesContainer.style.transform = `translateX(${offset}px)`;
                    
                                                    // When reach the cloned last slide, reset to the first slide
                                                    if (currentSlideIndex >= totalSlides) {
                                                        setTimeout(function () {
                                                            slidesContainer.style.transition = 'none';
                                                            slidesContainer.style.transform = 'translateX(0)';
                                                            currentSlideIndex = 0;
                                                        }, 500); // Wait for transition to complete before reset
                                                    }
                                                }
                    
                                                // Pause on hover
                                                slidesContainer.addEventListener('mouseenter', function () {
                                                    clearInterval(slideInterval);
                                                });
                    
                                                // Resume on mouse leave
                                                slidesContainer.addEventListener('mouseleave', function () {
                                                    slideInterval = setInterval(nextSlide, 3000);
                                                });
                                            });
                    
                                        </script>-->

                    <script>
                        document.addEventListener("DOMContentLoaded", function () {
                            var currentSlideIndex = 0;
                            var slidesContainer = document.querySelector('.slides');
                            var totalSlides = document.querySelectorAll('.slide').length;
                            var slideWidth = document.querySelector('.slide').clientWidth;

                            // Clone first slide and append to the end for seamless loop
                            slidesContainer.appendChild(slidesContainer.firstElementChild.cloneNode(true));

                            var slideInterval = setInterval(nextSlide, 3000);

                            function nextSlide() {
                                currentSlideIndex++;
                                var offset = -currentSlideIndex * slideWidth;

                                slidesContainer.style.transition = 'transform 0.5s ease';
                                slidesContainer.style.transform = `translateX(${offset}px)`;

                                // When reach the cloned last slide, reset to the first slide
                                if (currentSlideIndex >= totalSlides) {
                                    setTimeout(function () {
                                        slidesContainer.style.transition = 'none';
                                        slidesContainer.style.transform = 'translateX(0)';
                                        currentSlideIndex = 0;
                                    }, 500); // Wait for transition to complete before reset
                                }
                            }

                            // Pause on hover
                            slidesContainer.addEventListener('mouseenter', function () {
                                clearInterval(slideInterval);
                            });

                            // Resume on mouse leave
                            slidesContainer.addEventListener('mouseleave', function () {
                                slideInterval = setInterval(nextSlide, 3000);
                            });
                        });
                    </script>



                    <!-- Comments Section Start -->
                    <div class="reviews-container" style="margin-top: 30px; position: relative;">
                        <h3>Feedback</h3>
                        <button id="hide-feedback" class="btn btn-secondary" style="position: absolute; top: 0; right: 0; display: none;"><i class="fas fa-minus"></i></button>
                            <c:forEach var="f" items="${feedback}">
                            <div class="review" style="display: block;">
                                <div class="heder-comment">
                                    <h6>${f.firstName} ${f.lastName}</h6>
                                    <p>${f.review_date}</p>
                                    <div class="star" style="color: #ff6600;">
                                        <c:forEach var="i" begin="1" end="5">
                                            <c:choose>
                                                <c:when test="${i <= f.rating}">
                                                    <span class="fa fa-star checked"></span>
                                                </c:when>
                                            </c:choose>
                                        </c:forEach>
                                    </div>
                                </div>
                                <p>${f.review_text}</p>
                            </div>
                        </c:forEach>

                        <button id="show-feedback" class="btn btn-primary" style="margin-top: 20px;">Show all feedback</button>
                    </div>
                    <!-- Comments Section End -->

                    <script>
                        document.getElementById('show-feedback').addEventListener('click', function () {
                            var hiddenReviews = document.querySelectorAll('.review[style*="display: none"]');
                            hiddenReviews.forEach(function (review) {
                                review.style.display = 'block';
                            });
                            this.style.display = 'none';
                            document.getElementById('hide-feedback').style.display = 'block';
                        });

                        document.getElementById('hide-feedback').addEventListener('click', function () {
                            var allReviews = document.querySelectorAll('.review');
                            allReviews.forEach(function (review, index) {
                                if (index >= 2) { // Assuming the first 2 reviews should remain visible
                                    review.style.display = 'none';
                                }
                            });
                            this.style.display = 'none';
                            document.getElementById('show-feedback').style.display = 'block';
                        });
                    </script>

                </div>
                <div class="col-lg-4">
                    <div class="bg-secondary p-5 mb-5">
                        <h4 class="mb-4">Detail Information of Instructor</h4>
                        <ul class="list-unstyled mb-0">
                            <li class="d-flex mb-3">
                                <i class="fa fa-user text-primary mt-1 mr-3"></i>
                                <div>
                                    <h5 class="font-weight-bold mb-0">Name</h5>
                                    <small>${teacher.firstName} ${teacher.lastName}</small>
                                </div>
                            </li>
                            <li class="d-flex mb-3">
                                <i class="fa fa-briefcase text-primary mt-1 mr-3"></i>
                                <div>
                                    <h5 class="font-weight-bold mb-0">Experience</h5>
                                    <small>10 years in Web Development</small>
                                </div>
                            </li>
                            <li class="d-flex mb-3">
                                <i class="fa fa-graduation-cap text-primary mt-1 mr-3"></i>
                                <div>
                                    <h5 class="font-weight-bold mb-0">Education</h5>
                                    <small>PhD in Computer Science</small>
                                </div>
                            </li>
                            <li class="d-flex mb-3">
                                <i class="fa fa-envelope text-primary mt-1 mr-3"></i>
                                <div>
                                    <h5 class="font-weight-bold mb-0">Email</h5>
                                    <small>${teacher.email}</small>
                                </div>
                            </li>
                            <li class="d-flex mb-3">
                                <i class="fa fa-globe text-primary mt-1 mr-3"></i>
                                <div>
                                    <h5 class="font-weight-bold mb-0">Website</h5>
                                    <small>www.johndoe.com</small>
                                </div>
                            </li>
                        </ul>

                        <div class="btn-enroll" style="display: flex; flex-direction: column;">

                          
<!-- Wishlist Form -->
<form id="wishlistForm" action="${pageContext.request.contextPath}/wishlist/toggle" method="post" style="display: none;">
    <input type="hidden" name="courseId" id="wishlistCourseId" value="${course.id}">
</form>

<a href="#" class="btn btn-primary py-2 px-4 mt-4" onclick="toggleWishlist(${course.id});">
    Add to Wishlist <i id="wishlistIcon" class="far fa-heart${isInWishlist ? ' fa-heart' : '-o'}"></i>
</a>

<script>
    function toggleWishlist(courseId) {
        console.log("Course ID:", courseId); // Debug print
        var xhr = new XMLHttpRequest();
        xhr.open("POST", "${pageContext.request.contextPath}/wishlist/toggle", true);
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        xhr.onreadystatechange = function () {
            if (xhr.readyState === 4) {
                console.log("Response status:", xhr.status); // Debug print
                if (xhr.status === 200) {
                    var response = xhr.responseText;
                    var heartIcon = document.getElementById("wishlistIcon");
                    console.log("Response text:", response); // Debug print
                    if (response === "added") {
                        heartIcon.classList.remove('fa-heart-o');
                        heartIcon.classList.add('fa-heart');
                    } else if (response === "removed") {
                        heartIcon.classList.remove('fa-heart');
                        heartIcon.classList.add('fa-heart-o');
                    }
                } else {
                    console.error("Request failed. Status:", xhr.status); // Debug print
                }
            }
        };
        xhr.send("courseId=" + courseId);
    }
</script>




                            <c:choose>

                                <c:when test="${sessionScope.user != null}">
                                    <c:choose>
                                        <c:when test="${requestScope.enrolledCheck == true}">
                                            <a href="${pageContext.request.contextPath}/course/learning" class="btn btn-primary btn-block py-3" style="padding: 10px;">Continue studying </a>

                                        </c:when>
                                        <c:otherwise>
                                            <c:choose>
                                                <c:when test="${sessionScope.course.price > 0}">
                                                    <c:set var="s" value="${sessionScope.course}"/>
                                                    <a href="${pageContext.request.contextPath}/course_learing?id=${s.id}" class="btn btn-primary btn-block py-3" style="padding: 10px;">Register for this Course</a>

                                                </c:when>
                                                <c:otherwise>
<!--                                                    <a href="${pageContext.request.contextPath}/course/learning" class="btn btn-primary btn-block py-3">Register for free</a>-->
                                                    <a href="${pageContext.request.contextPath}/course/detail?enrollCourse=true" class="btn btn-primary btn-block py-3"style="padding: 10px;">Register for free</a>

                                                </c:otherwise>

                                            </c:choose> 
                                        </c:otherwise>

                                    </c:choose>

                                </c:when>

                                <c:otherwise>
                                    <a href="${pageContext.request.contextPath}/login?action=courseAccess" class="btn btn-primary btn-block py-3">Register for this Course</a>

                                </c:otherwise>
                            </c:choose>

                        </div> 

                    </div>
                </div>
            </div>
        </div>
        <!-- Course Detail End -->

        <!-- Footer Start -->
        <jsp:include page ="footer.jsp"></jsp:include>
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

        <script src="./js/scripts.js"></script>
    </body>
</html>
