<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Dal.CourseDAO" %>
<%@ page import="Model.UserDBO" %>
<%@ page import="Dal.UserDAO" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Create Course - ECOURSES</title>
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
        <script>
            function previewImage(fileInput) {
                var file = fileInput.files[0];
                var reader = new FileReader();
                reader.onload = function (e) {
                    $('#imagePreview').attr('src', e.target.result);
                };
                reader.readAsDataURL(file);
            }

            //        function validateForm() {
            //            var courseName = document.forms["courseForm"]["name"].value.trim(); // Lấy giá trị và loại bỏ khoảng trắng thừa
            //            if (courseName === "") {
            //                alert("Please enter Course Name");
            //                return false; // Ngăn form submit nếu trường "Course Name" trống
            //            }
            //            return true; // Cho phép submit form nếu dữ liệu hợp lệ
            //        }
        </script>
                <script>
            // Hàm để tự động submit biểu mẫu
            function autoSubmit() {
                var selectedSort = document.getElementById("fruits").value; // Get the selected sort value
                document.getElementById("sortInput").value = selectedSort; // Update the value of the hidden input
                document.getElementById("myForm").submit(); // Submit the form
            }
        </script>
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

            <!-- Content body start -->
            <div class="content-body">
                <div class="container-fluid">
                    <div class="row page-titles mx-0">
                        <div class="col-sm-6 p-md-0"></div>
                        <div class="col-sm-6 p-md-0 justify-content-sm-end mt-2 mt-sm-0 d-flex">
                            <ol class="breadcrumb">
                                <li class="breadcrumb-item"><a href="index.jsp">Home</a></li>
                                <li class="breadcrumb-item active"><a href="course">Courses</a></li>
                                <li class="breadcrumb-item active"><a href="#">Create Courses</a></li>
                            </ol>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-lg-12">
                            <div class="card">
                                <div class="card-header">
                                    <h4 class="card-title">Add Course</h4>
                                </div>
                                <div class="card-body">
                                    <!-- Display message from session -->
                                <%
                                    String message = (String) session.getAttribute("message");
                                    if (message != null) {
                                        out.println("<div class='alert alert-success'>" + message + "</div>");//alert alert-danger màu đỏ//alert alert-warning màu vàng
                                        session.removeAttribute("message"); // Xóa thông báo sau khi hiển thị
                                    }
                                %>
                                <form id="courseForm" action="createCourse" method="post" enctype="multipart/form-data" onsubmit="return validateForm()">
                                    <div class="row">
                                        <div class="col-lg-6 col-md-6 col-sm-12">
                                            <div class="form-group">
                                                <label class="form-label">Course Name</label>
                                                <input type="text" class="form-control" name="name">
                                            </div>
                                        </div>
                                        <div class="col-lg-6 col-md-6 col-sm-12">
                                            <div class="form-group">
                                                <label class="form-label">Course Title</label>
                                                <input type="text" class="form-control" name="title">
                                            </div>
                                        </div>
                                        <div class="col-lg-12 col-md-12 col-sm-12">
                                            <div class="form-group">
                                                <label class="form-label">Course Description</label>
                                                <textarea class="form-control" rows="5" name="description"></textarea>
                                            </div>
                                        </div>
                                        <div class="col-lg-6 col-md-6 col-sm-12">
                                            <div class="form-group">
                                                <label class="form-label">Course Price</label>
                                                <input type="text" class="form-control" name="price" value="0" required>
                                            </div>
                                        </div>
                                        <div class="col-lg-6 col-md-6 col-sm-12">
                                            <div class="form-group">
                                                <label class="form-label">Course Image</label>
                                                <input type="file" class="form-control-file" name="avatar" accept="image/*" onchange="previewImage(this);">
                                                <img id="imagePreview" src="path/to/default/image.jpg" alt="Image Preview" style="max-width: 200px; max-height: 200px; margin-top: 10px;">
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
                                                <select class="form-control" name="courseTypeName" required>
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
                                            <button type="submit" class="btn btn-primary">Submit</button>
                                            <button type="reset" class="btn btn-light">Reset</button>
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

        <script>
            function previewImage(input) {
                var file = input.files[0];
                var reader = new FileReader();
                reader.onload = function (e) {
                    document.getElementById('imagePreview').src = e.target.result;
                    document.getElementById('imagePreview').style.display = 'block';
                };
                reader.readAsDataURL(file);
            }
        </script>

        <!-- Footer Start -->
        <jsp:include page="footer.jsp"></jsp:include>

        <!-- Footer End -->

        <!-- JavaScript Libraries -->
        <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
    </body>
</html>