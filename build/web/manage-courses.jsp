<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Dal.CourseDAO" %>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Manage Courses - ECOURSES</title>
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
        <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
        <link href="css/style.css" rel="stylesheet">
        <!--        <script>
                    // Hàm để tự động submit biểu mẫu
                    function autoSubmit() {
                        var selectedSort = document.getElementById("fruits").value; // Get the selected sort value
                        document.getElementById("sortInput").value = selectedSort; // Update the value of the hidden input
                        document.getElementById("myForm").submit(); // Submit the form
                    }
                </script>-->
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
                font-size: 30px;
                /* Điều chỉnh kích thước của biểu tượng sao */
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

            <!-- Sidebar Start -->
            <div id="sidebar" class="sidebar">
                <div class="sidebar-header">
                    <h1>Lessons list</h1>                    
                    <button id="close-sidebar" class="btn btn-primary">Close</button>
                </div>
                <div class="sidebar-content">  
                    <div class="side-bar-header" style="margin-bottom: 15px;">                        
                    </div>                  
                    <div id="lessons-container">
                    <c:forEach var="course" items="${listCourse}">
                        <!-- Kiểm tra xem course có lesson không -->
                        <c:if test="${not empty courseLessonsMap[course.id]}">
                            <div id="lessons-${course.id}" class="lessons" style="display:none;">
                                <!-- nút đến trang xem danh sách người trong course -->
                                  <a href="student-in-course?courseId=${course.id}" class="btn btn-primary" style="margin-bottom: 15px;">View Students</a>
                               
                                <c:forEach var="lesson" items="${courseLessonsMap[course.id]}">
                                    <div class="big-lesson">
                                        <h5 class="big-lesson-title">${lesson.title}</h5>
                                        <div class="sublesson-list">
                                            <!-- Kiểm tra xem lesson có sublesson không -->
                                            <c:if test="${not empty lessonSubLessonsMap[lesson.id]}">
                                                <c:forEach var="subLesson" items="${lessonSubLessonsMap[lesson.id]}">
                                                    <div class="sublesson">
                                                        <span>${subLesson.title}</span>

                                                    </div>
                                                </c:forEach>
                                            </c:if>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                        </c:if>
                    </c:forEach>
                </div>
            </div>
        </div>
        <!-- Sidebar End -->

        <!-- Content body start -->
        <div class="content-body">
            <div class="container-fluid">
                <!-- Search Bar Start -->
                <form id="myForm" action="manage-courses" method="get">
                    <div class="container mb-5">
                        <div class="row justify-content-center">
                            <div class="col-md-8">
                                <div class="input-group">
                                    <input type="text" class="form-control" name="txtSearch" value="${txtSearch}" placeholder="Search for courses">      
                                    <div class="input-group-append">
                                        <input class="btn btn-primary" type="submit" value="Search"/>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
                <!-- Search Bar End -->

                <!-- Table Start -->
                <div class="row">
                    <div class="col-12">
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
                                        <th>Edit Instructor</th>
                                        <th>Action</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="i" items="${listCourse}" varStatus="status">
                                        <tr>
                                            <td>${status.index + 1}</td>
                                            <td><a href="course/learning?course_id=${i.id}">${i.name}</a></td>
                                            <td>${i.description}</td>
                                            <td>${i.created_at}</td>
                                            <td>
                                                <c:choose>
                                                    <c:when test="${i.price == 0}">
                                                        <span style="color: green;">Free</span>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <fmt:formatNumber var="format" pattern="#,###" value="${i.price}" />
                                                        ${format}đ
                                                    </c:otherwise>
                                                </c:choose>
                                            </td>
                                            <td>
                                                <!-- Display instructor name -->
                                                <c:out value="${teacherMap[i.teacher_id]}" />
                                                <!-- Link to updateTeacher1 with courseId and teacherId -->
                                            <td> <a class="btn btn-edit" href="updateTeacher1?courseId=${i.id}&teacherId=${i.teacher_id}">
                                                    <i class="fas fa-edit"></i>
                                                </a></td>
                                            </td>
                                            <td>
                                                <button class="btn btn-edit" onclick="window.location.href = 'edit-course?courseId=${i.id}'">
                                                    <i class="fas fa-edit"></i> 
                                                </button>
<!--                                                <button class="btn btn-delete" onclick="deleteCourse(${i.id})">
                                                    <i class="fas fa-trash"></i> 
                                                </button>-->
                                                <button class="btn btn-show" onclick="showLessons(${i.id})">
                                                    <i class="far fa-eye"></i>
                                                </button>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <!-- Table End -->

                <!-- Pagination Start -->
                <div class="row">
                    <div class="col-12">
                        <nav aria-label="Page navigation">
                            <ul class="pagination justify-content-center">
                                <c:forEach var="i" begin="1" end="${pageCounting}">
                                    <li class="page-item ${page == i ? 'active' : ''}">
                                        <a class="page-link" href="manage-courses?page=${i}&txtSearch=${txtSearch}&sortOrder=${sortOrder}">${i}</a>
                                    </li>
                                </c:forEach>
                            </ul>
                        </nav>
                    </div>
                </div>
                <!-- Pagination End -->
            </div>
        </div>
        <script>
            function showLessons(courseId) {
                // Ẩn tất cả các lesson containers
                document.querySelectorAll('.lessons').forEach(function (el) {
                    el.style.display = 'none';
                });
                // Hiển thị lesson container của khóa học đã chọn
                document.getElementById('lessons-' + courseId).style.display = 'block';
            }
        </script>
        <script>
            function deleteCourse(courseId) {
                var confirmDelete = confirm("Are you sure you want to delete this course?");
                if (confirmDelete) {
                    // AJAX request to delete-course servlet
                    var xhr = new XMLHttpRequest();
                    xhr.open("POST", "delete-course?id=" + courseId, true);
                    xhr.onreadystatechange = function () {
                        if (xhr.readyState === XMLHttpRequest.DONE) {
                            if (xhr.status === 200) {
                                alert("Course deleted successfully");
                                // Optional: Reload the page or update UI as needed
                                window.location.reload();
                            } else {
                                alert("Failed to delete course");
                            }
                        }
                    };
                    xhr.send();
                } else {
                    // Do nothing or handle cancellation
                }
            }
        </script>
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

        <!--**********************************
        Content body end
        ***********************************-->

        <!-- Footer Start -->
        <jsp:include page="footer.jsp"></jsp:include>
        <!-- Footer End -->
        <!-- JavaScript Libraries -->
        <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
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
