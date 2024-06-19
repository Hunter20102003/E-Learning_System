<%-- 
    Document   : detailCourse
    Created on : May 22, 2024, 11:25:56 PM
    Author     : LEGION
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <title>Course Detail - ECOURSES</title>
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="Free HTML Templates" name="keywords">
        <meta content="Free HTML Templates" name="description">
<<<<<<< HEAD
=======
        <script src="./js/scripts.js"></script>
>>>>>>> origin/front-end

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

        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
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
            <div class="container-fluid py-5">
                <div class="container py-5">
                    <div class="row">
                        <div class="col-lg-8">
                            <div class="mb-5">
                                <img class="img-fluid w-100" src="img/course-detail.jpg" alt="">
                                <h2 class="mt-4">${course.title}</h2>
                            <p>${course.description}</p>
                            <h4 class="mt-4">Course Details</h4>
                            <ul>
<<<<<<< HEAD
                                <li><i class="fa fa-check text-primary mr-2"></i>Duration: 4 Weeks</li>
                                <li><i class="fa fa-check text-primary mr-2"></i>Classes: 3 per week</li>
                                <li><i class="fa fa-check text-primary mr-2"></i>Class Duration: 2 hours</li>
                                <li><i class="fa fa-check text-primary mr-2"></i>Price: $99</li>
                            </ul>
                            <h4 class="mt-4">What You'll Learn</h4>
                            <ul>
                                <li><i class="fa fa-check text-primary mr-2"></i>Introduction to Web Design</li>
                                <li><i class="fa fa-check text-primary mr-2"></i>HTML & CSS Basics</li>
                                <li><i class="fa fa-check text-primary mr-2"></i>Responsive Design Principles</li>
                                <li><i class="fa fa-check text-primary mr-2"></i>JavaScript Fundamentals</li>
=======
                                <li><i class="fa fa-check text-primary mr-2"></i>Duration: ${durationCourse}</li>
                                    <c:choose>
                                        <c:when test="${course.price > 0}">
                                        <li><i class="fa fa-check text-primary mr-2"></i>Price: ${course.price}</li>                        
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

>>>>>>> origin/front-end
                            </ul>
                        </div>
                    </div>

                    <div class="col-lg-4 mt-5 mt-lg-0">
                        <div class="bg-light p-4">
                            <h4 class="mb-4">Course Instructor</h4>
                            <div class="d-flex align-items-center mb-4">
                                <img class="img-fluid rounded-circle" src="img/instructor.jpg" alt="" style="width: 80px;">
                                <div class="pl-3">
                                    <h5>${teacher.firstName} ${teacher.lastName}</h5>

<<<<<<< HEAD
                                    <p class="m-0">Senior Web Developer</p>
                                </div>
                            </div>
                            <h4 class="mb-4">Related Courses</h4>
                            <a href="#" class="d-block mb-3"><i class="fa fa-angle-right mr-2"></i>Advanced CSS Techniques</a>
                            <a href="#" class="d-block mb-3"><i class="fa fa-angle-right mr-2"></i>JavaScript for Beginners</a>
                            <a href="#" class="d-block mb-3"><i class="fa fa-angle-right mr-2"></i>Full-Stack Development</a>
                            <a href="#" class="d-block mb-3"><i class="fa fa-angle-right mr-2"></i>React & Redux</a>
                        </div>
                        <div class="mt-4">
                            <c:choose>
                                <c:when test="${sessionScope.user != null}">
                                    <a href="${pageContext.request.contextPath}/course/learning" class="btn btn-primary btn-block py-3">Register for this Course</a>

                                </c:when>
                                <c:otherwise>
                                    <a href="${pageContext.request.contextPath}/login.jsp?action=learningCourse" class="btn btn-primary btn-block py-3">Register for this Course</a>
=======
                                    <!--                                    <p class="m-0">Senior Web Developer</p>-->
                                </div>
                            </div>
                            <h4 class="mb-4">Related Courses</h4>
                            <c:forEach var="i" items="${listRelatedCourse}">
                                <a href="${pageContext.request.contextPath}/course/detail?course_id=${i.id}" class="d-block mb-3"><i class="fa fa-angle-right mr-2"></i>${i.name}</a>

                            </c:forEach>

                        </div>
                        <div class="mt-4">
                            <c:choose>

                                <c:when test="${sessionScope.user != null}">
                                    <c:choose>
                                        <c:when test="${sessionScope.course.price > 0}">
                                            <c:choose> 

                                                <c:when test="${check > 0}">
                                                    <a href="${pageContext.request.contextPath}/course/learning" class="btn btn-primary btn-block py-3">Register for this Course</a>

                                                </c:when>
                                                <c:otherwise>
                                                    <c:set var="s" value="${sessionScope.course}"/>
                                                    <a href="${pageContext.request.contextPath}/payqrcourse?id=${s.id}" class="btn btn-primary btn-block py-3">Register for this Course</a>
                                                </c:otherwise>

                                            </c:choose> 
                                        </c:when>

                                        <c:otherwise>
                                            <a href="${pageContext.request.contextPath}/course/learning" class="btn btn-primary btn-block py-3">Register for this Course</a>
                                        </c:otherwise>


                                    </c:choose>


                                </c:when>
                                <c:otherwise>
                                    <a href="${pageContext.request.contextPath}/login.jsp?course_id=${course.id}" class="btn btn-primary btn-block py-3">Register for this Course</a>
>>>>>>> origin/front-end

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

        <!-- Back to Top -->
        <a href="#" class="btn btn-primary back-to-top"><i class="fa fa-angle-double-up"></i></a>

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
<<<<<<< HEAD
=======
        
        <script src="./js/scripts.js"></script> 
>>>>>>> origin/front-end
    </body>

</html>
