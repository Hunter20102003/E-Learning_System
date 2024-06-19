<<<<<<< HEAD
<<<<<<< HEAD
<%-- 
    Document   : edit-course
    Created on : May 22, 2024, 11:26:23 PM
    Author     : LEGION
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
=======
>>>>>>> origin/front-end
=======
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Model.CourseDBO" %>
<%@ page import="Dal.CourseDAO" %>
<%@ page import="java.util.List" %>

>>>>>>> origin/create-course1
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Course - ECOURSES</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
<<<<<<< HEAD
<<<<<<< HEAD
=======
    <script src="./js/scripts.js"></script>
>>>>>>> origin/front-end
=======
    <!-- Include jQuery -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
>>>>>>> origin/create-course1
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
<<<<<<< HEAD
    <!-- Navbar End -->

     <!--**********************************
            Content body start
        ***********************************-->
<<<<<<< HEAD
        <div class="content-body">
            <!-- row -->
            <div class="container-fluid">
				    
                <div class="row page-titles mx-0">
                    <div class="col-sm-6 p-md-0">
                        <div class="welcome-text">
                            <h4>Edit Course</h4>
                        </div>
                    </div>
                    <div class="col-sm-6 p-md-0 justify-content-sm-end mt-2 mt-sm-0 d-flex">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="index.html">Home</a></li>
                            <li class="breadcrumb-item active"><a href="#">Courses</a></li>
                            <li class="breadcrumb-item active"><a href="#">Add Courses</a></li>
                            <li class="breadcrumb-item active"><a href="#">List Courses</a></li>
                        </ol>
                    </div>
                </div>
=======
        <div class="content-body" style="margin-top: 20px;">
            <!-- row -->
            <div class="container-fluid">
>>>>>>> origin/front-end
				
				<div class="row">
					<div class="col-lg-12">
						<div class="card">
							<div class="card-header">
<<<<<<< HEAD
								<h4 class="card-title">Courses Details</h4>
=======
								<h4 class="card-title">Edit Courses</h4>
>>>>>>> origin/front-end
							</div>
							<div class="card-body">
								<form action="#" method="post">
									<div class="row">
										<div class="col-lg-12 col-md-12 col-sm-12">
											<div class="form-group">
												<label class="form-label">Course Name</label>
												<input type="text" class="form-control" value="Programming">
											</div>
										</div>
										<div class="col-lg-12 col-md-12 col-sm-12">
											<div class="form-group">
												<label class="form-label">Course Details</label>
												<textarea class="form-control" rows="5">Why is Early Education Essential</textarea>
											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12">
											<div class="form-group">
												<label class="form-label">Start Form</label>
												<input name="datepicker" class="datepicker-default form-control" id="datepicker" value="7 August, 2020">
											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12">
											<div class="form-group">
<<<<<<< HEAD
												<label class="form-label">Course Duration</label>
												<input type="text" class="form-control" value="3 Year">
											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12">
											<div class="form-group">
=======
>>>>>>> origin/front-end
												<label class="form-label">Course Price</label>
												<input type="text" class="form-control" value="$1500">
											</div>
										</div>
<<<<<<< HEAD
										<div class="col-lg-6 col-md-6 col-sm-12">
											<div class="form-group">
												<label class="form-label">Instructor Name</label>
												<input type="text" class="form-control" value="Jimmy Morris">
											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12">
											<div class="form-group">
												<label class="form-label">Maximum Students</label>
												<input type="text" class="form-control" value="200">
											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12">
											<div class="form-group">
												<label class="form-label">Contact Number</label>
												<input type="text" class="form-control" value="+01 123 456 7890">
=======
										<div class="col-lg-12 col-md-12 col-sm-12">
											<div class="form-group">
												<label class="form-label">Instructor Name</label>
												<input type="text" class="form-control" value="Jimmy Morris" readonly>
>>>>>>> origin/front-end
											</div>
										</div>
										<div class="col-lg-12 col-md-12 col-sm-12">
											<div class="form-group fallback w-100">
												<label class="form-label d-block">Course Photo</label>
												<input type="file" class="dropify" data-default-file="">
											</div>
										</div>
										<div class="col-lg-12 col-md-12 col-sm-12">
											<button type="submit" class="btn btn-primary">Submit</button>
<<<<<<< HEAD
											<button type="submit" class="btn btn-light">Cencel</button>
=======
											<button type="submit" class="btn btn-light" style="background-color: gainsboro;">Cencel</button>
>>>>>>> origin/front-end
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
				
            </div>
        </div>
        <!--**********************************
            Content body end
        ***********************************-->
=======
    <!-- Content body end -->
>>>>>>> origin/create-course1

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
