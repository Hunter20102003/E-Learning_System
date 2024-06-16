<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Header</title>
        <style>
            .avatar-container {
                position: relative;
                display: inline-block;
                left: -80px; /* Adjust avatar position as needed */
            }
            .avatar {
                width: 50px; /* Adjust avatar size as needed */
                height: 50px;
                border-radius: 50%;
                cursor: pointer;
            }
            .dropdown-content {
                display: none;
                position: absolute;
                background-color: #f9f9f9;
                min-width: 160px;
                box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
                z-index: 1;
            }
            .dropdown-content a {
                color: black;
                padding: 12px 16px;
                text-decoration: none;
                display: block;
            }
            .dropdown-content a:hover {
                background-color: #f1f1f1;
            }
            .avatar-container:hover .dropdown-content {
                display: block;
            }
        </style>
    </head>
    <body>
        <div class="container-fluid d-none d-lg-block">
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
                        <div style="height: 65px" class="collapse navbar-collapse justify-content-between" id="navbarCollapse">
                            <div class="navbar-nav py-0">
                                <a href="${pageContext.request.contextPath}/home" class="nav-item nav-link active">Home</a>
                                <a href="about.jsp" class="nav-item nav-link">About</a>
                                <a href="${pageContext.request.contextPath}/course" class="nav-item nav-link">Courses</a>
                                <a href="${pageContext.request.contextPath}/teacher" class="nav-item nav-link">Teachers</a>
                                <div class="nav-item dropdown">
                                    <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">Blog</a>
                                    <div class="dropdown-menu rounded-0 m-0">
                                        <a href="blog.html" class="dropdown-item">Blog List</a>
                                        <a href="single.html" class="dropdown-item">Blog Detail</a>
                                    </div>
                                </div>
                                <a href="contact.html" class="nav-item nav-link">Contact</a>
                            </div>
                            <div class="container-fluid">
                                <div class="row align-items-center py-4 px-xl-5">
                                    <c:choose>
                                        <c:when test="${user ne null and user.role ne null}">


                                            <div class="avatar-container">
                                                <div class="dropdown">
                                                    <img src="${pageContext.request.contextPath}/${user.avatar}" alt="Avatar" class="avatar" id="avatar">
                                                    <span>${user.firstName} ${user.lastName}</span>
                                                    <div class="dropdown-content" id="dropdown-content">
                                                        <a href="profile.jsp">Profile</a>

                                                        <!-- Check user's role -->
                                                        <c:if test="${user.role.name eq 4}">
                                                            <a href="create-course1.jsp">Create Course</a>
                                                            <a href="manage-courses">List Courses</a>
                                                        </c:if>

                                                        <!-- Always show Change Password -->
                                                        <a href="change-password.jsp">Change Password</a>

                                                        <!-- Logout link -->
                                                        <a href="logout">Logout</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </c:when>
                                        <c:otherwise>
                                            <a class="btn btn-primary py-2 px-4 ml-auto d-none d-lg-block" href="login.jsp">Login</a>
                                        </c:otherwise>
                                    </c:choose>



                                </div>
                            </div>
                        </div>
                    </nav>
                </div>
            </div>
        </div>

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
