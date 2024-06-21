<%-- 
    Document   : header
    Created on : May 23, 2024, 2:27:23 PM
    Author     : LEGION
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<!-- Topbar End -->


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
                <div class="collapse navbar-collapse justify-content-between" id="navbarCollapse">
                    <div class="navbar-nav py-0">
                        <a href="${pageContext.request.contextPath}/index.jsp" class="nav-item nav-link">Home</a>
                        <a href="about.html" class="nav-item nav-link">About</a>
                        <a href="${pageContext.request.contextPath}/course" class="nav-item nav-link  ${sessionScope.courseActive != null ? "active":""}">Courses</a>
                        <a href="teacher.html" class="nav-item nav-link">Teachers</a>
                        <div class="nav-item dropdown">
                            <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">Blog</a>
                            <div class="dropdown-menu rounded-0 m-0">
                                <a href="blog.html" class="dropdown-item">Blog List</a>
                                <a href="single.html" class="dropdown-item">Blog Detail</a>
                            </div>
                        </div>
                        <a href="contact.html" class="nav-item nav-link">Contact</a>
                        <c:if test="${user.role.id == 3}"><a href="list_accounts" class="nav-item nav-link">Admin Manager</a></c:if>

                        </div>
                    <c:choose>
                        <c:when test="${sessionScope.user != null}">
                            <div class="avatar-container">
                                <div class="dropdown">
                                    <img src="${pageContext.request.contextPath}/${user.avatar}" alt="Avatar" class="avatar" id="avatar">
                                    <span>${user.firstName} ${user.lastName}</span>
                                    <div class="dropdown-content" id="dropdown-content">
                                        <a href="editProfile.jsp">Profile</a>
                                        <c:if test="${user.username != null}"> 
                                            <a href="change-password.jsp">Change Password</a>
                                        </c:if>
                                        <c:if test="${user.role.getId() eq 2}"> 
                                            <a href="CourseContentManagement">Course Content Management</a>
                                        </c:if>
                                        <c:if test="${user.role.getId() eq 4}">
                                            <a href="create-course1.jsp">Create Course</a>
                                            <a href="manage-courses">List Courses</a>
                                        </c:if>

                                        <a href="logout">Logout</a>
                                    </div>
                                </div>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <a class="btn btn-primary py-2 px-4 ml-auto d-none d-lg-block" href="${pageContext.request.contextPath}/login.jsp">Login</a>
                        </c:otherwise>
                    </c:choose>

                </div>
            </nav>
        </div>
    </div>
</div>
