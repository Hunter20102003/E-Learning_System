<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Model.CourseDBO" %>
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
