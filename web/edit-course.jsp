<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Model.CourseDBO" %>
<<<<<<< HEAD
<%@ page import="java.util.List" %>
<%@ page import="Dal.CourseDAO" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@page import="Dal.CourseDAO" %>
<%@page import="java.util.ArrayList"%>
<jsp:useBean id="course" scope="request" class="Model.CourseDBO" />
<jsp:useBean id="courseTypeNames" scope="request" type="java.util.List" />

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Edit Course - ECOURSES</title>
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">
<<<<<<< HEAD


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
        <!-- Include header -->
        <jsp:include page="header.jsp"></jsp:include>

<!-- Content body -->
<div class="content-body">
    <div class="container-fluid">
        <div class="row page-titles mx-0">
            <div class="col-sm-6 p-md-0"></div>
            <div class="col-sm-6 p-md-0 justify-content-sm-end mt-2 mt-sm-0 d-flex">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="index.jsp">Home</a></li>
                    <li class="breadcrumb-item active"><a href="manager-courses">Courses</a></li>
                    <li class="breadcrumb-item active"><a href="#">Edit Course</a></li>
                </ol>
            </div>
        </div>

        <div class="row">
            <div class="col-lg-12">
                <div class="card">
                    <div class="card-header">
                        <h4 class="card-title">Edit Course</h4>
                    </div>
                    <div class="card-body">
                        <form id="courseForm" method="post" enctype="multipart/form-data" action="edit-course" onsubmit="return validateForm()">
                            <input type="hidden" name="courseId" value="${course.id}">
                            <div class="row">
                                <div class="col-lg-6 col-md-6 col-sm-12">
                                    <div class="form-group">
                                        <label class="form-label">Course Name</label>
                                        <input type="text" class="form-control" name="name" value="${course.name}">
                                        <span id="nameError" class="text-danger" style="display: none;">Course Name is required.</span>
                                    </div>
                                </div>
                                <div class="col-lg-6 col-md-6 col-sm-12">
                                    <div class="form-group">
                                        <label class="form-label">Course Title</label>
                                        <input type="text" class="form-control" name="title" value="${course.title}">
                                        <span id="titleError" class="text-danger" style="display: none;">Course Title is required.</span>
                                    </div>
                                </div>
                                <div class="col-lg-12 col-md-12 col-sm-12">
                                    <div class="form-group">
                                        <label class="form-label">Course Description</label>
                                        <textarea class="form-control" rows="5" name="description">${course.description}</textarea>
                                    </div>
                                </div>
                                <div class="col-lg-6 col-md-6 col-sm-12">
                                    <div class="form-group">
                                        <label class="form-label">Course Price</label>
                                        <input type="text" class="form-control" name="price" value="${course.price}" oninput="validatePriceInput(this)">
                                        <span id="priceError" class="text-danger" style="display: none;">Course Price must not exceed 9 characters.</span>
                                    </div>
                                </div>
                                <div class="col-lg-6 col-md-6 col-sm-12">
                                    <div class="form-group">
                                        <label class="form-label">Course Image</label>
                                        <input type="file" class="form-control-file" name="courseImage" onchange="previewImage(this)">
                                        <img id="courseImagePreview" src="${course.img}" alt="Course Image" style="width: 350px; height: 188px; margin-top: 10px;">
                                        <span id="imageError" class="text-danger" style="display: none;">Course Image must be in .jpg or .jpeg format.</span>
                                    </div>
                                </div>
                                <div class="col-lg-12 col-md-12 col-sm-12">
                                    <div class="form-group">
                                        <label class="form-label d-block">Hidden</label>
                                        <div class="custom-control custom-checkbox">
                                            <input type="checkbox" class="custom-control-input" id="isLocked" name="isLocked" ${course.isIs_locked() ? "checked" : ""}>
                                            <label class="custom-control-label" for="isLocked">Check to hide the course</label>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-12 col-md-12 col-sm-12">
                                    <div class="form-group">
                                        <label class="form-label">Course Type</label>
                                        <select class="form-control" name="courseTypeName">
                                            <% for (Object typeNameObj : courseTypeNames) { String typeName = (String) typeNameObj; %>
                                            <option value="<%= typeName %>" <%= course.getCourse_type().getName().equals(typeName) ? "selected" : "" %>><%= typeName %></option>
                                            <% } %>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-lg-12 col-md-12 col-sm-12">
                                    <!-- Display error message if exists -->
                                    <c:if test="${not empty errorMessage}">
                                        <div class="alert alert-danger">${errorMessage}</div>
                                    </c:if>
                                    <!-- Display success message if exists -->
                                    <c:if test="${not empty successMessage}">
                                        <div class="alert alert-success">${successMessage}</div>
                                    </c:if>
                                    <button type="submit" class="btn btn-primary">Save Changes</button>
                                    <button type="button" class="btn btn-light" onclick="window.location.href = 'manage-courses'">Cancel</button>
=======


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
        <!-- Include header -->
        <jsp:include page="header.jsp"></jsp:include>

            <!-- Content body -->
            <div class="content-body">
                <div class="container-fluid">
                    <div class="row page-titles mx-0">
                        <div class="col-sm-6 p-md-0">
                        </div>
                        <div class="col-sm-6 p-md-0 justify-content-sm-end mt-2 mt-sm-0 d-flex">
                            <ol class="breadcrumb">
                                <li class="breadcrumb-item"><a href="index.jsp">Home</a></li>
                                <li class="breadcrumb-item active"><a href="mangaer-courses">Courses</a></li>
                                <li class="breadcrumb-item active"><a href="#">Edit Course</a></li>
                            </ol>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-lg-12">
                            <div class="card">
                                <div class="card-header">
                                    <h4 class="card-title">Edit Course</h4>
>>>>>>> origin/front-end
                                </div>
                                <div class="card-body">

                                    <form id="courseForm" method="post" enctype="multipart/form-data" action="edit-course">
                                        <input type="hidden" name="courseId" value="${course.id}">
                                    <div class="row">
                                        <div class="col-lg-6 col-md-6 col-sm-12">
                                            <div class="form-group">
                                                <label class="form-label">Course Name</label>
                                                <input type="text" class="form-control" name="name" value="${course.name}">
                                            </div>
                                        </div>
                                        <div class="col-lg-6 col-md-6 col-sm-12">
                                            <div class="form-group">
                                                <label class="form-label">Course Title</label>
                                                <input type="text" class="form-control" name="title" value="${course.title}">
                                            </div>
                                        </div>
                                        <div class="col-lg-12 col-md-12 col-sm-12">
                                            <div class="form-group">
                                                <label class="form-label">Course Description</label>
                                                <textarea class="form-control" rows="5" name="description">${course.description}</textarea>
                                            </div>
                                        </div>
                                        <div class="col-lg-6 col-md-6 col-sm-12">
                                            <div class="form-group">
                                                <label class="form-label">Course Price</label>
                                                <input type="text" class="form-control" name="price" value="${course.price}">
                                            </div>
                                        </div>
                                        <div class="col-lg-6 col-md-6 col-sm-12">
                                            <div class="form-group">
                                                <label class="form-label">Course Image</label>
                                                <input type="file" class="form-control-file" name="courseImage" onchange="previewImage(event)">
                                                <img id="courseImagePreview" src="${course.img}" alt="Course Image"  style="width: 350px; height: 188px; margin-top: 10px;">
                                            </div>
                                        </div>
                                        <div class="col-lg-12 col-md-12 col-sm-12">
                                            <div class="form-group">
                                                <label class="form-label d-block">Hidden</label>
                                                <div class="custom-control custom-checkbox">
                                                    <input type="checkbox" class="custom-control-input" id="isLocked" name="isLocked" ${course.isIs_locked() ? "checked" : ""}>
                                                    <label class="custom-control-label" for="isLocked">Check to hide the course</label>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-lg-12 col-md-12 col-sm-12">
                                            <div class="form-group">
                                                <label class="form-label">Course Type</label>
                                                <select class="form-control" name="courseTypeName">
                                                    <%
                                                        for (Object typeNameObj : courseTypeNames) { // Iterate through the list and create options
                                                            String typeName = (String) typeNameObj;
                                                    %>
                                                    <option value="<%= typeName %>" <%= course.getCourse_type().getName().equals(typeName) ? "selected" : "" %>><%= typeName %></option>
                                                    <%
                                                        }
                                                    %>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="col-lg-12 col-md-12 col-sm-12">
                                            <!-- Display error message if exists -->
                                            <c:if test="${not empty errorMessage}">
                                                <div class="alert alert-danger">${errorMessage}</div>
                                            </c:if>
                                            <!-- Display success message if exists -->
                                            <c:if test="${not empty successMessage}">
                                                <div class="alert alert-success">${successMessage}</div>
                                            </c:if>
                                            <button type="submit" class="btn btn-primary">Save Changes</button>
                                            <button type="button" class="btn btn-light" onclick="window.location.href = 'manage-courses'">Cancel</button>
                                        </div>
                                    </div>
                                </form>
                            </div>
<<<<<<< HEAD
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
    function validateForm() {
        var name = document.forms["courseForm"]["name"].value;
        var title = document.forms["courseForm"]["title"].value;
        var price = document.forms["courseForm"]["price"].value;
        var image = document.forms["courseForm"]["courseImage"].value;

        var isValid = true;

        if (name == "") {
            document.getElementById('nameError').style.display = 'block';
            isValid = false;
        } else {
            document.getElementById('nameError').style.display = 'none';
        }

        if (title == "") {
            document.getElementById('titleError').style.display = 'block';
            isValid = false;
        } else {
            document.getElementById('titleError').style.display = 'none';
        }

        if (price.length > 9) {
            document.getElementById('priceError').style.display = 'block';
            isValid = false;
        } else {
            document.getElementById('priceError').style.display = 'none';
        }

        if (image != "") {
            var fileExtension = image.split('.').pop().toLowerCase();
            if (fileExtension !== "jpg" && fileExtension !== "jpeg") {
                document.getElementById('imageError').style.display = 'block';
                isValid = false;
            } else {
                document.getElementById('imageError').style.display = 'none';
            }
        }

        return isValid;
    }

    function validatePriceInput(input) {
        // Loại bỏ bất kỳ ký tự nào không phải là số
        input.value = input.value.replace(/[^0-9]/g, '');

        // Kiểm tra số lượng ký tự
        if (input.value.length > 9) {
            // Hiển thị thông báo lỗi nếu quá 9 ký tự
            document.getElementById('priceError').style.display = 'block';
        } else {
            // Ẩn thông báo lỗi nếu hợp lệ
            document.getElementById('priceError').style.display = 'none';
        }
    }

    function validateImage(input) {
        var fileExtension = input.value.split('.').pop().toLowerCase();
        if (fileExtension !== "jpg" && fileExtension !== "jpeg") {
            document.getElementById('imageError').style.display = 'block';
        } else {
            document.getElementById('imageError').style.display = 'none';
        }
    }

    function previewImage(input) {
        var file = input.files[0];
        var reader = new FileReader();
        reader.onload = function (e) {
            document.getElementById('courseImagePreview').src = e.target.result;
        };
        reader.readAsDataURL(file);
    }
</script>

=======
                        </div>
                    </div>
                </div>

            </div>
        </div>

        <script>
            function previewImage(event) {
                var reader = new FileReader();
                reader.onload = function () {
                    var output = document.getElementById('courseImagePreview');
                    output.src = reader.result;
                    output.style.display = 'block';
                };
                reader.readAsDataURL(event.target.files[0]);
            }
        </script>
        <!-- Content body end -->
>>>>>>> origin/front-end

        <!-- Footer Start -->
        <jsp:include page="footer.jsp"></jsp:include>
        <!-- Footer End -->
    </body>
</html>
=======
<%@ page import="Dal.CourseDAO" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Course - ECOURSES</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <!-- Include jQuery -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<body>
    <!-- Include header -->
    <jsp:include page="header.jsp"></jsp:include>

    <!-- Content body -->
    <div class="content-body">
        <div class="container-fluid">
            <div class="row page-titles mx-0">
                <div class="col-sm-6 p-md-0">
                </div>
                <div class="col-sm-6 p-md-0 justify-content-sm-end mt-2 mt-sm-0 d-flex">
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="index.html">Home</a></li>
                        <li class="breadcrumb-item active"><a href="#">Courses</a></li>
                        <li class="breadcrumb-item active"><a href="#">Edit Course</a></li>
                    </ol>
                </div>
            </div>
            
            <div class="row">
                <div class="col-lg-12">
                    <div class="card">
                        <div class="card-header">
                            <h4 class="card-title">Edit Course</h4>
                        </div>
                        <div class="card-body">
                            <form id="courseForm">
                                <input type="hidden" name="courseId" value="<%= session.getAttribute("courseId") %>">
                                <div class="row">
                                    <div class="col-lg-6 col-md-6 col-sm-12">
                                        <div class="form-group">
                                            <label class="form-label">Course Name</label>
                                            <input type="text" class="form-control" name="name" value="${course.name}">
                                        </div>
                                    </div>
                                    <div class="col-lg-6 col-md-6 col-sm-12">
                                        <div class="form-group">
                                            <label class="form-label">Course Title</label>
                                            <input type="text" class="form-control" name="title" value="${course.title}">
                                        </div>
                                    </div>
                                    <div class="col-lg-12 col-md-12 col-sm-12">
                                        <div class="form-group">
                                            <label class="form-label">Course Description</label>
                                            <textarea class="form-control" rows="5" name="description">${course.description}</textarea>
                                        </div>
                                    </div>
                                    <div class="col-lg-6 col-md-6 col-sm-12">
                                        <div class="form-group">
                                            <label class="form-label">Course Price</label>
                                            <input type="text" class="form-control" name="price" value="${course.price}">
                                        </div>
                                    </div>
                                    <div class="col-lg-6 col-md-6 col-sm-12">
                                        <div class="form-group">
                                            <label class="form-label">Course Image</label>
                                            <input type="file" class="form-control" name="courseImage">
                                        </div>
                                    </div>
                                    <div class="col-lg-12 col-md-12 col-sm-12">
                                        <div class="form-group">
                                            <label class="form-label d-block">Hidden</label>
                                            <div class="custom-control custom-checkbox">
                                                <input type="checkbox" class="custom-control-input" id="isLocked" name="isLocked">
                                                <label class="custom-control-label" for="isLocked">Check to hide the course</label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-lg-12 col-md-12 col-sm-12">
                                        <div class="form-group">
                                            <label class="form-label">Course Type</label>
                                            <select class="form-control" name="courseTypeName">
                                                <%
                                                    CourseDAO courseDAO = new CourseDAO(); // Create the DAO object
                                                    List<String> courseTypeNames = courseDAO.getAllCourseTypeNames(); // Get the list of course type names
                                                    for (String typeName : courseTypeNames) { // Iterate through the list and create options
                                                %>
                                                <option value="<%= typeName %>"><%= typeName %></option>
                                                <%
                                                    }
                                                %>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="col-lg-12 col-md-12 col-sm-12">
                                        <button type="button" class="btn btn-primary" onclick="saveChanges()">Save Changes</button>
                                       <button type="button" class="btn btn-light" onclick="window.location.href = 'manage-courses'">Cancel</button>

                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            
        </div>
    </div>
    <!-- Content body end -->

    <!-- Footer Start -->
    <jsp:include page="footer.jsp"></jsp:include>
    <!-- Footer End -->

    <!-- JavaScript Function to Save Changes -->
    <script>
        function saveChanges() {
            var formData = $('#courseForm').serialize();
            $.ajax({
                type: 'POST',
                url: 'edit-course',
                data: formData,
                success: function(response) {
                    // Handle success, e.g., show success message
                    alert('Course updated successfully');
                },
                error: function(xhr, status, error) {
                    // Handle error, e.g., show error message
                    alert('Failed to update course');
                }
            });
        }
    </script>
</body>
</html>
>>>>>>> origin/payment
