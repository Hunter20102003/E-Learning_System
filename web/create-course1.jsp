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
        <style>
            body {
                font-family: 'Poppins', sans-serif;
                margin: 0;
                padding: 0;
                background-color: #f8f9fa;
            }

            .container {
                display: grid;
                grid-template-columns: 2fr 1fr;
                gap: 20px;
                padding: 20px;
            }

            .video-container {
                display: flex;
                flex-direction: column;
            }

            .video {
                width: 100%;
                height: 400px;
                background-color: #000;
                border-radius: 10px;
                overflow: hidden;
            }

            .lesson-info {
                margin-top: 20px;
                background-color: #fff;
                padding: 20px;
                border-radius: 10px;
                box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            }

            .lesson-info h1 {
                font-size: 2em;
                margin-bottom: 10px;
            }

            .lesson-info p {
                font-size: 1em;
                color: #555;
            }

            .comments {
                background-color: #fff;
                padding: 20px;
                border-radius: 10px;
                box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            }

            .comments h2 {
                font-size: 1.5em;
                margin-bottom: 10px;
            }

            .comment-input {
                display: flex;
                align-items: flex-start;
                margin-bottom: 20px;
            }

            .comment-input img.avatar {
                width: 40px;
                height: 40px;
                border-radius: 50%;
                margin-right: 10px;
            }

            .comment-input textarea {
                flex-grow: 1;
                padding: 10px;
                border: 1px solid #ccc;
                border-radius: 5px;
                font-size: 1em;
            }

            .comment-input button {
                margin-left: 10px;
                padding: 10px 20px;
                background-color: #FF6600;
                color: #fff;
                border: none;
                border-radius: 5px;
                cursor: pointer;
            }

            .comment-input button:hover {
                background-color: #e65c00;
            }

            .comment-list {
                margin-top: 20px;
            }

            .comment {
                display: flex;
                align-items: flex-start;
                margin-bottom: 20px;
                position: relative;
            }

            .comment img.avatar {
                width: 40px;
                height: 40px;
                border-radius: 50%;
                margin-right: 10px;
            }

            .comment-content {
                background-color: #f1f1f1;
                padding: 10px;
                border-radius: 5px;
                flex-grow: 1;
            }

            .comment-content p {
                margin: 5px 0;
            }

            .comment-actions {
                display: flex;
                gap: 10px;
                font-size: 0.9em;
                color: #555;
            }

            .comment-actions span {
                cursor: pointer;
            }

            .comment-actions span:hover {
                text-decoration: underline;
            }

            .timestamp {
                font-size: 0.8em;
                color: #888;
            }

            .comment-menu {
                position: absolute;
                right: 0;
                top: 10px;
            }

            .comment-menu-button {
                cursor: pointer;
                font-size: 1.5em;
                padding: 5px;
            }

            .comment-menu-content {
                display: none;
                position: absolute;
                right: 0;
                top: 20px;
                background-color: #fff;
                border: 1px solid #ccc;
                border-radius: 5px;
                box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
                z-index: 10;
            }

            .comment-dropdown {
                padding: 5px;
                border: none;
                background: transparent;
                cursor: pointer;
                font-size: 1em;
            }

            .comment-menu-button:hover+.comment-menu-content,
            .comment-menu-content:hover {
                display: block;
            }

            .sidebar {
                display: flex;
                flex-direction: column;
                gap: 20px;
            }

            .section {
                background-color: #fff;
                padding: 25px;
                border-radius: 10px;
                box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            }

            .section h3 {
                margin: 0 0 10px;
                font-size: 1.5em;
                color: #333;
            }

            .video-list ul,
            .progress ul {
                list-style: none;
                padding: 0;
            }

            .video-list li,
            .progress li {
                padding: 10px;
                border-bottom: 1px solid #ddd;
                cursor: pointer;
            }

            .video-list li:hover,
            .progress li:hover {
                background-color: #f1f1f1;
            }

            .progress li {
                display: flex;
                justify-content: space-between;
            }

            .progress-content {
                max-height: 200px;
                overflow-y: auto;
            }

            .progress-content ul {
                padding: 0;
                margin: 0;
                list-style: none;
            }

            .progress-content ul li {
                display: flex;
                justify-content: space-between;
                padding: 10px;
                border-bottom: 1px solid #ddd;
            }

            .progress-content ul li:last-child {
                border-bottom: none;
            }

            .video-item {
                display: flex;
                flex-direction: column;
            }

            .video-item .video-item-title {
                font-weight: 500;
                cursor: pointer;
            }

            .video-item-content {
                display: none;
            }

            .video-item-content.active {
                display: block;
            }

            .fa-check-circle {
                color: green;
            }

            .reply-input {
                display: flex;
                flex-direction: column;
                margin-top: 10px;
            }

            .reply-input textarea {
                padding: 10px;
                border: 1px solid #ccc;
                border-radius: 5px;
                font-size: 1em;
            }

            .reply-buttons {
                display: flex;
                margin-top: 10px;
            }

            .reply-buttons button {
                padding: 8px 16px; /* Smaller size */
                background-color: #FF6600;
                color: #fff;
                border: none;
                border-radius: 5px;
                cursor: pointer;
                margin-left: 10px;
            }

            .reply-buttons button:hover {
                background-color: #e65c00;
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
<<<<<<< HEAD
                                                <input type="text" class="form-control" name="price" value="0" required maxlength="9" oninput="validatePriceInput(this)">
                                                <small id="priceError" class="form-text text-danger" style="display: none;">Price can only be a maximum of 9 digits.</small>
=======
                                                <input type="text" class="form-control" name="price" value="0" required>
>>>>>>> origin/front-end
                                            </div>
                                        </div>
                                        <div class="col-lg-6 col-md-6 col-sm-12">
                                            <div class="form-group">
                                                <label class="form-label">Course Image</label>
<<<<<<< HEAD
                                                <input type="file" class="form-control-file" name="avatar" id="avatar" accept=".jpg, .jpeg" onchange="validateAndPreviewImage(this)">
                                                <img id="imagePreview" src="path/to/default/image.jpg" alt="Image Preview" style="width: 350px; height: 188px; margin-top: 10px;">
                                                <small id="imageError" class="form-text text-danger" style="display: none;">Only .jpg or .jpeg files are allowed.</small>
=======
                                                <input type="file" class="form-control-file" name="avatar" accept="image/*" onchange="previewImage(this);">
                                                <img id="imagePreview" src="path/to/default/image.jpg" alt="Image Preview" style="width: 350px; height: 188px; margin-top: 10px;">
>>>>>>> origin/front-end
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
                                            <button type="button" class="btn btn-light" onclick="window.location.href = 'index.jsp'">Cancel</button>
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
<<<<<<< HEAD
        <script>
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
        </script>
=======

>>>>>>> origin/front-end
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
<<<<<<< HEAD
        <script>
            function validateAndPreviewImage(input) {
                const file = input.files[0];
                const errorElement = document.getElementById('imageError');

                if (file) {
                    const fileName = file.name.toLowerCase();
                    const validExtensions = ['.jpg', '.jpeg'];
                    const fileExtension = fileName.substring(fileName.lastIndexOf('.'));

                    if (validExtensions.includes(fileExtension)) {
                        // Hide error message if file is valid
                        errorElement.style.display = 'none';

                        // Preview the image
                        const reader = new FileReader();
                        reader.onload = function (e) {
                            document.getElementById('imagePreview').src = e.target.result;
                        };
                        reader.readAsDataURL(file);
                    } else {
                        // Show error message if file is invalid
                        errorElement.style.display = 'block';
                        // Clear the input
                        input.value = '';
                        // Reset the image preview
                        document.getElementById('imagePreview').src = 'path/to/default/image.jpg';
                    }
                } else {
                    // Reset the image preview if no file is selected
                    document.getElementById('imagePreview').src = 'path/to/default/image.jpg';
                }
            }
        </script>
=======
>>>>>>> origin/front-end

        <!-- Footer Start -->
        <jsp:include page="footer.jsp"></jsp:include>

        <!-- Footer End -->

        <!-- JavaScript Libraries -->
        <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
    </body>
</html>