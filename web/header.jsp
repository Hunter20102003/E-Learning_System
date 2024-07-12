<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    <%-- 
=======
<%-- 
>>>>>>> origin/AdminManager
=======
<%-- 
>>>>>>> origin/create-course1
=======
<%-- 
>>>>>>> origin/crud_quiz
    Document   : header
    Created on : May 23, 2024, 2:27:23 PM
    Author     : LEGION
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container-fluid d-none d-lg-block">
    <div class="row align-items-center py-4 px-xl-5">
        <div class="col-lg-3">
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
            <a href="" class="text-decoration-none">
=======
            <a href="home" class="text-decoration-none">
>>>>>>> origin/create-course1
=======
            <a href="home" class="text-decoration-none">
>>>>>>> origin/crud_quiz
=======
            <a href="home" class="text-decoration-none">
>>>>>>> origin/front-end
                <h1 class="m-0"><span class="text-primary">E</span>COURSES</h1>
            </a>
        </div>
        <div class="col-lg-3 text-right">
            <div class="d-inline-flex align-items-center">
                <i class="fa fa-2x fa-map-marker-alt text-primary mr-3"></i>
                <div class="text-left">
                    <h6 class="font-weight-semi-bold mb-1">Our Office</h6>
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
                    <small>123 Street, New York, USA</small>
=======
                    <small>Thạch Thất, Hà Nội, Việt Nam</small>
>>>>>>> origin/create-course1
=======
                    <small>Thạch Thất, Hà Nội, Việt Nam</small>
>>>>>>> origin/crud_quiz
=======
                    <small>Thạch Thất, Hà Nội, Việt Nam</small>
>>>>>>> origin/front-end
                </div>
            </div>
        </div>
        <div class="col-lg-3 text-right">
            <div class="d-inline-flex align-items-center">
                <i class="fa fa-2x fa-envelope text-primary mr-3"></i>
                <div class="text-left">
                    <h6 class="font-weight-semi-bold mb-1">Email Us</h6>
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
                    <small>info@example.com</small>
=======
                    <small>phucdq2003@gmail.com</small>
>>>>>>> origin/create-course1
=======
                    <small>phucdq2003@gmail.com</small>
>>>>>>> origin/crud_quiz
=======
                    <small>phucdq2003@gmail.com</small>
>>>>>>> origin/front-end
                </div>
            </div>
        </div>
        <div class="col-lg-3 text-right">
            <div class="d-inline-flex align-items-center">
                <i class="fa fa-2x fa-phone text-primary mr-3"></i>
                <div class="text-left">
                    <h6 class="font-weight-semi-bold mb-1">Call Us</h6>
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
                    <small>+012 345 6789</small>
=======
                    <small>0393454486</small>
>>>>>>> origin/create-course1
=======
                    <small>0393454486</small>
>>>>>>> origin/crud_quiz
=======
                    <small>0393454486</small>
>>>>>>> origin/front-end
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
<<<<<<< HEAD
<<<<<<< HEAD
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
=======
                    <c:forEach var="i" items="${listTypeOfCourse}">
                        <a href="course?cbxTypesOfCourse=${i.id}" class="nav-item nav-link">${i.name}</a>
                    </c:forEach>
>>>>>>> origin/create-course1
=======
                    <c:forEach var="i" items="${listTypeOfCourse}">
                        <a href="course?cbxTypesOfCourse=${i.id}" class="nav-item nav-link">${i.name}</a>
                    </c:forEach>
>>>>>>> origin/crud_quiz
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
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
                        <a href="${pageContext.request.contextPath}/index.jsp" class="nav-item nav-link">Home</a>
                        <a href="about.html" class="nav-item nav-link">About</a>
                        <a href="${pageContext.request.contextPath}/course" class="nav-item nav-link  ${sessionScope.courseActive != null ? "active":""}">Courses</a>
                        <a href="teacher.html" class="nav-item nav-link">Teachers</a>
=======
=======
>>>>>>> origin/front-end
                        <a href="${pageContext.request.contextPath}/home" class="nav-item nav-link">Home</a>
                        <a href="about.jsp" class="nav-item nav-link">About</a>
                        <a href="${pageContext.request.contextPath}/course" class="nav-item nav-link  ${sessionScope.courseActive != null ? "active":""}">Courses</a>
                        <a href="${pageContext.request.contextPath}/teacher" class="nav-item nav-link">Teachers</a>
>>>>>>> origin/create-course1
=======
                        <a href="${pageContext.request.contextPath}/home" class="nav-item nav-link">Home</a>
                        <a href="about.jsp" class="nav-item nav-link">About</a>
                        <a href="${pageContext.request.contextPath}/course" class="nav-item nav-link  ${sessionScope.courseActive != null ? "active":""}">Courses</a>
                        <a href="${pageContext.request.contextPath}/teacher" class="nav-item nav-link">Teachers</a>
>>>>>>> origin/crud_quiz
                        <div class="nav-item dropdown">
                            <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">Blog</a>
                            <div class="dropdown-menu rounded-0 m-0">
                                <a href="blog.html" class="dropdown-item">Blog List</a>
                                <a href="single.html" class="dropdown-item">Blog Detail</a>
                            </div>
                        </div>
<<<<<<< HEAD
<<<<<<< HEAD
                        <a href="contact.html" class="nav-item nav-link">Contact</a>
=======
                        <a href="contact.jsp" class="nav-item nav-link">Contact</a>
<<<<<<< HEAD
>>>>>>> origin/create-course1
=======
                        <a href="contact.jsp" class="nav-item nav-link">Contact</a>
>>>>>>> origin/crud_quiz
=======
>>>>>>> origin/front-end
                        <c:if test="${user.role.id == 3}"><a href="list_accounts" class="nav-item nav-link">Admin Manager</a></c:if>

                        </div>
                    <c:choose>
                        <c:when test="${sessionScope.user != null}">
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
                            <div class="avatar-container">
=======
                            <div class="avatar-container" style="padding-right: 32px; margin: 0">
>>>>>>> origin/create-course1
=======
                            <div class="avatar-container" style="padding-right: 32px; margin: 0">
>>>>>>> origin/crud_quiz
=======
                            <div class="avatar-container" style="padding-right: 32px; margin: 0">
>>>>>>> origin/front-end
                                <div class="dropdown">
                                    <img src="${pageContext.request.contextPath}/${user.avatar}" alt="Avatar" class="avatar" id="avatar">
                                    <span>${user.firstName} ${user.lastName}</span>
                                    <div class="dropdown-content" id="dropdown-content">
                                        <a href="editProfile.jsp">Profile</a>
                                        <c:if test="${user.username != null}"> 
                                            <a href="change-password.jsp">Change Password</a>
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
=======
>>>>>>> origin/crud_quiz
=======
>>>>>>> origin/front-end
                                            <a href="myLearning">My Learning</a>
                                            <a href="wish-list">Wish-list</a> 
                                            <a href="coursePurchase">Purchased Course</a>

<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> origin/create-course1
=======
>>>>>>> origin/crud_quiz
=======
>>>>>>> origin/front-end
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
