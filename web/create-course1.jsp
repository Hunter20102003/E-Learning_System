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
                                    out.println("<div class='alert alert-info'>" + message + "</div>");//alert alert-danger màu đỏ//alert alert-warning màu vàng
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
                                            <input type="file" class="form-control" name="avatar" accept="image/*" onchange="previewImage(this);">
                                            <img id="imagePreview" src="#" alt="Image Preview" style="max-width: 200px; max-height: 200px; margin-top: 10px;">
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
                                    <button type="reset" class="btn btn-light">Cancel</button>
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

<!-- JavaScript Libraries -->
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
</body>
</html>