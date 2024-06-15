<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Dal.CourseDAO" %>
<%@ page import="Model.UserDBO" %>
<%@ page import="Dal.UserDAO" %>
<%@ page import="java.util.List" %>
<%
    // Ensure the user is logged in and retrieve user information from session
    UserDBO loggedInUser = (UserDBO) session.getAttribute("user");
    
    // Redirect to login if user is not logged in
    if (loggedInUser == null) {
        response.sendRedirect("login.jsp");
        return;
    }
    
    // Fetch user ID using DAO
    UserDAO userDao = new UserDAO();
    int userId = userDao.getUserIdByLoginAndRoleID(loggedInUser.getUsername(), loggedInUser.getPassword());
    
    // If user ID is -1, handle accordingly (possibly redirect or display error)
    if (userId == -1) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<script>
    function validateForm() {
        var name = document.forms["courseForm"]["name"].value.trim();
        if (name == "") {
            document.getElementById("nameError").innerText = "Course Name is required";
            return false;
        } else {
            document.getElementById("nameError").innerText = "";
        }

        // AJAX call to check if course name already exists
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function () {
            if (this.readyState == 4 && this.status == 200) {
                var response = JSON.parse(this.responseText);
                if (response.exists) {
                    document.getElementById("nameError").innerText = "Course Name already exists. Please choose a different name.";
                } else {
                    document.getElementById("nameError").innerText = "";
                    document.getElementById("courseForm").submit(); // Submit the form if no error
                }
            }
        };
        xhttp.open("GET", "createCourse?name=" + encodeURIComponent(name), true);
        xhttp.send();

        return false; // Prevent form submission here
    }
</script>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create Course - ECOURSES</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
</head>
<body>
    <!-- Topbar Start -->
    <jsp:include page="header.jsp"></jsp:include>
    <!-- Topbar End -->

    <!-- Content body start -->
    <div class="content-body">
        <div class="container-fluid">
            <div class="row page-titles mx-0">
                <div class="col-sm-6 p-md-0">
                </div>
                <div class="col-sm-6 p-md-0 justify-content-sm-end mt-2 mt-sm-0 d-flex">
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="index.html">Home</a></li>
                        <li class="breadcrumb-item active"><a href="#">Courses</a></li>
                        <li class="breadcrumb-item active"><a href="#">List Courses</a></li>
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
                            <form id="courseForm" action="createCourse" method="post" onsubmit="return validateForm()">
                                <div class="row">
                                    <div class="col-lg-6 col-md-6 col-sm-12">
                                        <div class="form-group">
                                            <label class="form-label">Course Name</label>
                                            <input type="text" class="form-control" name="name" value="">
                                            <small id="nameError" class="error-message"></small>
                                            <%-- Display server-side error message --%>
                                            <% String duplicateNameError = (String) request.getAttribute("duplicateNameError"); %>
                                            <% if (duplicateNameError != null && !duplicateNameError.isEmpty()) { %>
                                                <div class="alert alert-danger mt-2" role="alert">
                                                    <%= duplicateNameError %>
                                                </div>
                                            <% } %>
                                        </div>
                                    </div>

                                    <div class="col-lg-6 col-md-6 col-sm-12">
                                        <div class="form-group">
                                            <label class="form-label">Course Title</label>
                                            <input type="text" class="form-control" name="title" value="">
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
                                            <input type="text" class="form-control" name="price" value="0">
                                        </div>
                                    </div>
                                    <div class="col-lg-6 col-md-6 col-sm-12">
                                        <div class="form-group">
                                            <label class="form-label">Course Image Link</label>
                                            <input type="text" class="form-control" name="courseImageLink" placeholder="Enter image URL">
                                        </div>
                                    </div>
                                    <div class="col-lg-12 col-md-12 col-sm-12">
                                        <div class="form-group">
                                            <label class="form-label d-block">Is Locked?</label>
                                            <div class="custom-control custom-checkbox">
                                                <input type="checkbox" class="custom-control-input" id="isLocked" name="isLocked">
                                                <label class="custom-control-label" for="isLocked">Check to lock the course</label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-lg-12 col-md-12 col-sm-12">
                                        <div class="form-group">
                                            <label class="form-label">Course Type</label>
                                            <select class="form-control" name="courseTypeName">
                                                <%
                                                    CourseDAO daoCourse = new CourseDAO(); // Create the DAO object
                                                    List<String> courseTypeNameList = daoCourse.getAllCourseTypeNames(); // Get the list of course type names
                                                    for (String typeName : courseTypeNameList) { // Iterate through the list and create options
                                                %>
                                                <option value="<%= typeName %>"><%= typeName %></option>
                                                <% } %>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="col-lg-12 col-md-12 col-sm-12">
                                        <button type="submit" class="btn btn-primary">Submit</button>
                                        <button type="reset" class="btn btn-light">Cancel</button>
                                    </div>
                                </div>
                            </form>

                            <%-- Display success message if any --%>
                            <% String successMessage = (String) request.getAttribute("successMessage"); %>
                            <% if (successMessage != null && !successMessage.isEmpty()) { %>
                                <div class="alert alert-success mt-3" role="alert">
                                    <%= successMessage %>
                                </div>
                            <% } %>
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

    <!-- JavaScript Dependencies -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
</body>
</html>
