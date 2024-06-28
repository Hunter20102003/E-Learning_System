<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<<<<<<< HEAD
<%@taglib  uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
=======
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
>>>>>>> origin/quiznew
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Purchase History</title>
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
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 0;
            }
            header {
                display: flex;
                justify-content: space-between;
                align-items: center;
                padding: 10px 20px;
                background-color: #f8f8f8;
                border-bottom: 1px solid #ddd;
            }
            header img {
                height: 50px;
            }
            nav a {
                margin: 0 10px;
                text-decoration: none;
                color: #333;
            }
            .container {
                width: 80%;
                margin: 20px auto;
            }
            .purchase-history {
                margin-top: 20px;
            }
            .course {
                display: flex;
                justify-content: space-between;
                align-items: center;
                padding: 10px;
                border: 1px solid #ddd;
                border-radius: 5px;
                margin-bottom: 10px;
            }
            .course img {
                height: 150px;
                width: 150px;
                border-radius: 5px;
            }
            .course-details {
                flex-grow: 1;
                margin-left: 20px;
            }
            .course-details h3 {
                margin: 0;
            }
            .course-details p {
                margin: 5px 0;
            }
            .pagination {
                display: flex;
                justify-content: center;
                margin-top: 20px;
            }
            .pagination a {
                margin: 0 5px;
                padding: 5px 10px;
                text-decoration: none;
                color: #333;
                border: 1px solid #ddd;
                border-radius: 3px;
            }
            .pagination a.active {
                background-color: #ff6600;
                color: #fff;
                border-color: #ff6600;
            }

            .btn-view {
                display: inline-block;
                padding: 5px 10px;
                font-size: 16px;
                cursor: pointer;
                text-align: center;
                text-decoration: none;
                outline: none;
                color: white;
                background-color: #ff6600;
                border: 2px solid #ff6600;
                border-radius: 5px;
                box-shadow: 0 4px #999;
                transition: background-color 0.3s, box-shadow 0.3s, transform 0.3s;
            }

            .btn-view:hover {
                background-color: #ff4800;
                border-color: #ff6600;
                text-decoration: none;
            }

            .btn-view:active {
                background-color: #ff4800;
                box-shadow: 0 2px #666;
                transform: translateY(4px);
            }

        </style>
    </head>
    <body>
        <!-- Topbar Start -->
        <jsp:include page="header.jsp"></jsp:include>
            <!-- Topbar End -->
            <div class="container">
                <h2>Purchase History</h2>
<<<<<<< HEAD
                <!-- Display purchased courses -->
            <c:forEach var="l" items="${pageCourses}">
                <div class="purchase-history">
                    <div class="course">
                        <img src="${l.img}" alt="${l.name}">
                        <div class="course-details">
                            <h4>${l.name}</h4>
                            <p>Purchased on: ${l.enroll.enrollment_date}</p>
                            <p>Price: 
                                <c:choose>
                                    <c:when test="${l.price eq 0}">
                                        <span style="color: green;">Free</span>
                                    </c:when>
                                    <c:otherwise>
                                        <fmt:formatNumber var="formattedPrice" pattern="#,###" value="${l.price}" />
                                        <span>${formattedPrice}</span>
                                    </c:otherwise>
                                </c:choose>
                            </p>
                            <a class="btn-view" href="course/detail?course_id=${l.id}">View Course</a>
                        </div>

                    </div>
                </div>
            </c:forEach> 
            <div class="pagination">
                <!-- Previous page link -->
                <c:if test="${currentPage > 1}">
                    <a href="${pageContext.request.contextPath}/coursePurchase?page=${currentPage - 1}">&laquo;</a>
                </c:if>

                <!-- Page numbers -->
                <c:forEach var="i" begin="1" end="${totalPages}">
                    <c:choose>
                        <c:when test="${i == currentPage}">
                            <a class="active" href="#">${i}</a>
                        </c:when>
                        <c:otherwise>
                            <a href="${pageContext.request.contextPath}/coursePurchase?page=${i}">${i}</a>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>

                <!-- Next page link -->
                <c:if test="${currentPage < totalPages}">
                    <a href="${pageContext.request.contextPath}/coursePurchase?page=${currentPage + 1}">&raquo;</a>
                </c:if>
            </div>

=======
            <c:forEach var="l" items="${listCoursePurchase}">
                <div class="purchase-history">
                    <div class="course">
                        <img src="${l.img}" alt="Web Development Basics">
                        <div class="course-details">
                            <h4>${l.name}</h4>
                            <c:set var="e" value="${l.enroll}" />
                            <p>Purchased on: ${e.enrollment_date}</p>
                            <p>Price: ${l.price}</p>
                            <a class="btn-view" href="course/detail?course_id=${l.id}">View Course</a>

                        </div>
                    </div>
                </div>
            </c:forEach>
                
            <div class="pagination">
                <a href="#">&laquo;</a>
                <a href="#" class="active">1</a>
                <a href="#">2</a>
                <a href="#">3</a>
                <a href="#">4</a>
                <a href="#">5</a>
                <a href="#">6</a>
                <a href="#">&raquo;</a>
            </div>
>>>>>>> origin/quiznew
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
                                <a class="btn btn-outline-light btn-square mr-2" href="#"><i
                                        class="fab fa-facebook-f"></i></a>
                                <a class="btn btn-outline-light btn-square mr-2" href="#"><i
                                        class="fab fa-linkedin-in"></i></a>
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
                    <p>Rebum labore lorem dolores kasd est, et ipsum amet et at kasd, ipsum sea tempor magna tempor. Accu
                        kasd sed ea duo ipsum. Dolor duo eirmod sea justo no lorem est diam</p>
                    <div class="w-100">
                        <div class="input-group">
                            <input type="text" class="form-control border-light" style="padding: 30px;"
                                   placeholder="Your Email Address">
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
    </body>
</html>
