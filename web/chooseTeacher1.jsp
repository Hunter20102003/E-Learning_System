<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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


    </head>
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

        .btn-danger {
            background-color: #f44336 !important;
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
    <body>
        <!-- Topbar Start -->
        <jsp:include page="header.jsp"></jsp:include>
            <!-- Topbar End -->

            <!-- Content body start -->
            <div class="content-body">
                <div class="container-fluid">
                    <!-- Search Bar Start -->
                    <form id="myForm" action="updateTeacher1" method="get">
                        <div class="container mb-5">
                            <div class="row justify-content-center">
                                <div class="col-md-8">
                                    <div class="input-group">
                                        <input type="text" class="form-control" name="txtSearch" value="${searchQuery}" placeholder="Search for teachers">
                                    <div class="input-group-append">
                                        <input class="btn btn-primary" type="submit" value="Search"/>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <input type="hidden" name="courseId" value="${courseId}">
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
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Email</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="teacher" items="${teachers}" varStatus="status">
                        <tr>
                            <td>${status.index + 1}</td>
                            <td>${teacher.firstName}</td>
                            <td>${teacher.lastName}</td>
                            <td>${teacher.email}</td>
                            <td>
                                <form action="updateTeacher1" method="POST">
                                    <input type="hidden" name="courseId" value="${courseId}">
                                    <input type="hidden" name="teacherId" value="${teacher.id}">
                                    <button type="submit" class="btn btn-primary" name="action" value="update">Save</button>
                                    <c:if test="${teacher.id == currentTeacherId}">
                                        <button type="submit" class="btn btn-danger" name="action" value="delete">Delete</button>
                                    </c:if>
                                </form>
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
                <nav aria-label="Page navigation example">
                    <ul class="pagination justify-content-center">
                        <c:forEach var="i" begin="1" end="${totalPages}">
                            <li class="page-item ${i == currentPage ? 'active' : ''}">
                                <a class="page-link" href="updateTeacher1?page=${i}&txtSearch=${searchQuery}&courseId=${courseId}">${i}</a>
                            </li>
                        </c:forEach>
                    </ul>
                </nav>
                <!-- Pagination End -->
            </div>
        </div>



        <script>
            // Optional: Example of handling select change event
            $('#teacherSelect').change(function () {
                var teacherId = $(this).val();
                console.log('Selected Teacher ID:', teacherId);
                // You can perform additional actions based on the selected teacher ID if needed
            });
        </script>





        <!-- Add Font Awesome CDN -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">

        <!--**********************************
        Content body end
        ***********************************-->

        <!-- Footer Start -->
        <jsp:include page="footer.jsp"></jsp:include>
        <!-- Footer End -->

        <!-- JavaScript Libraries -->
        <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
        <script>


        </script>
    </body>

</html>
