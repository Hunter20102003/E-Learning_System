<%-- 
    Document   : header
    Created on : May 23, 2024, 2:27:23 PM
    Author     : LEGION
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
    .avatar-container {
    position: relative;
    left: -80px; /* Dịch chuyển avatar sang bên trái 80px */
}
</style>

<div class="container-fluid d-none d-lg-block">
    <div class="row align-items-center py-4 px-xl-5">
        <div class="col-lg-3">
            <a href="${pageContext.request.contextPath}/home" class="text-decoration-none">
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

<!--course?cbxTypesOfCourse=1-->

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
                    <c:forEach var="i" items="${listTypeOfCourse}">
                     <a href="course?cbxTypesOfCourse=${i.id}" class="nav-item nav-link">${i.name}</a>
                    </c:forEach>
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
                        <a href="contact.jsp" class="nav-item nav-link">Contact</a>
                    </div>
                    <c:choose>
                        <c:when test="${user != null}">
                            <div class="avatar-container">
                                <div class="dropdown">
                                    <img src="${pageContext.request.contextPath}/${user.avatar}" alt="Avatar" class="avatar" id="avatar">
                                    <span>${user.firstName} ${user.lastName}</span>
                                    <div class="dropdown-content" id="dropdown-content">
                                        <a href="profile.jsp">Profile</a>
                                        <c:if test="${user.username != null}"> 
                                            <a href="change-password.jsp">Change Password</a>
                                        </c:if>
                                            
                                        <a href="logout">Logout</a>
                                    </div>
                                </div>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <a class="btn btn-primary py-2 px-4 ml-auto d-none d-lg-block" href="${pageContext.request.contextPath}/login">Login</a>
                        </c:otherwise>
                    </c:choose>
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