<<<<<<< HEAD
<<<<<<<< HEAD:web/edit-account.jsp
========
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Model.CourseDBO" %>
<%@ page import="Dal.CourseDAO" %>
<%@ page import="java.util.List" %>

>>>>>>>> origin/comment:build/web/edit-course.jsp
=======
>>>>>>> origin/comment
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
<<<<<<< HEAD
<<<<<<< HEAD
    <title>Edit Account</title>
=======
<<<<<<<< HEAD:web/add-account.jsp
    <title>Add Account</title>
========
    <title>Edit Account</title>
>>>>>>>> origin/develop:web/edit-account.jsp
>>>>>>> origin/develop
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <!-- Include jQuery -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<body>
<<<<<<<< HEAD:web/edit-account.jsp
=======
    <title>Edit Account</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
</head>
<body>
>>>>>>> origin/comment
     <!-- Topbar Start -->
     <div class="container-fluid d-none d-lg-block">
        <div class="row align-items-center py-4 px-xl-5">
            <div class="col-lg-3">
                <a href="" class="text-decoration-none">
                    <h1 class="m-0"><span class="text-primary">E</span>COURSES</h1>
                </a>
            </div>
            <div class="col-lg-3 text-right">
                <div class="d-inline-flex align-items-center">
                    <i class="fa fa-2x fa-map-marker-alt text-primary mr-3"></i>
                    <div class="text-left">
                        <h6 class="font-weight-semi-bold mb-1">Our Office</h6>
                        <small>123 Street, New York, USA</small>
                    </div>
<<<<<<< HEAD
========
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
>>>>>>>> origin/comment:build/web/edit-course.jsp
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
<<<<<<<< HEAD:web/edit-account.jsp
=======
                </div>
            </div>
            <div class="col-lg-3 text-right">
                <div class="d-inline-flex align-items-center">
                    <i class="fa fa-2x fa-envelope text-primary mr-3"></i>
                    <div class="text-left">
                        <h6 class="font-weight-semi-bold mb-1">Email Us</h6>
                        <small>info@example.com</small>
                    </div>
                </div>
            </div>
            <div class="col-lg-3 text-right">
                <div class="d-inline-flex align-items-center">
                    <i class="fa fa-2x fa-phone text-primary mr-3"></i>
                    <div class="text-left">
                        <h6 class="font-weight-semi-bold mb-1">Call Us</h6>
                        <small>+012 345 6789</small>
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
                            <a href="index.html" class="nav-item nav-link">Home</a>
                            <a href="about.html" class="nav-item nav-link">About</a>
                            <a href="course.html" class="nav-item nav-link active">Courses</a>
                            <a href="teacher.html" class="nav-item nav-link">Teachers</a>
                            <div class="nav-item dropdown">
                                <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">Blog</a>
                                <div class="dropdown-menu rounded-0 m-0">
                                    <a href="blog.html" class="dropdown-item">Blog List</a>
                                    <a href="single.html" class="dropdown-item">Blog Detail</a>
                                </div>
                            </div>
                            <a href="contact.html" class="nav-item nav-link">Contact</a>
                        </div>
>>>>>>> origin/comment
                        <a class="btn btn-primary py-2 px-4 ml-auto d-none d-lg-block" href="">Join Now</a>
                    </div>
                </nav>
            </div>
        </div>
    </div>
    <!-- Navbar End -->
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<<< HEAD:web/edit-account.jsp
<<<<<<< HEAD:web/edit-account.jsp

=======
    
>>>>>>> origin/DashBoard:web/create-course.jsp
========
    
>>>>>>>> origin/develop:web/create-course.jsp
=======
<<<<<<<< HEAD:web/add-account.jsp
<<<<<<< HEAD:web/add-account.jsp

=======
    
>>>>>>> origin/DashBoard:build/web/create-course.jsp
========

>>>>>>>> origin/develop:web/edit-account.jsp
>>>>>>> origin/develop
=======

>>>>>>> origin/comment
    <!--**********************************
            Content body start
        ***********************************-->
        <div class="content-body" style="margin-top: 20px;">
            <!-- row -->
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD:web/edit-account.jsp
            <div class="container-fluid">			    
=======
<<<<<<<< HEAD:web/add-account.jsp
<<<<<<< HEAD:web/add-account.jsp
            <div class="container-fluid">				
>>>>>>> origin/develop
=======
            <div class="container-fluid">
				    
                <div style="margin-top: 10px;" class="row page-titles mx-0">
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
<<<<<<< HEAD
>>>>>>> origin/DashBoard:web/create-course.jsp
				
=======
========
            <div class="container-fluid">			    
>>>>>>>> origin/develop:web/edit-account.jsp
				
>>>>>>> origin/DashBoard:build/web/create-course.jsp
>>>>>>> origin/develop
=======
            <div class="container-fluid">			    
				
>>>>>>> origin/comment
				<div class="row">
					<div class="col-lg-12">
						<div class="card">
							<div class="card-header">
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<<< HEAD:web/edit-account.jsp
<<<<<<< HEAD:web/edit-account.jsp
								<h4 class="card-title">Edit Account</h4>
=======
								<h4 class="card-title">Add Course</h4>
>>>>>>> origin/DashBoard:web/create-course.jsp
========
								<h4 class="card-title">Add Course</h4>
>>>>>>>> origin/develop:web/create-course.jsp
=======
<<<<<<<< HEAD:web/add-account.jsp
<<<<<<< HEAD:web/add-account.jsp
								<h4 class="card-title">Add Account</h4>
=======
								<h4 class="card-title">Add Course</h4>
>>>>>>> origin/DashBoard:build/web/create-course.jsp
========
								<h4 class="card-title">Edit Account</h4>
>>>>>>>> origin/develop:web/edit-account.jsp
>>>>>>> origin/develop
=======
								<h4 class="card-title">Edit Account</h4>
>>>>>>> origin/comment
							</div>
							<div class="card-body">
								<form action="#" method="post">
									<div class="row">
										<div class="col-lg-12 col-md-12 col-sm-12">
											<div class="form-group">
												<label class="form-label">User Name</label>
												<input type="text" class="form-control">
											</div>
										</div>										
										<div class="col-lg-6 col-md-6 col-sm-12">
											<div class="form-group">
												<label class="form-label">First Name</label>
												<input name="datepicker" class="datepicker-default form-control" id="datepicker">
											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12">
											<div class="form-group">
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<<< HEAD:web/edit-account.jsp
<<<<<<< HEAD:web/edit-account.jsp
=======
<<<<<<<< HEAD:web/add-account.jsp
<<<<<<< HEAD:web/add-account.jsp
========
>>>>>>>> origin/develop:web/edit-account.jsp
>>>>>>> origin/develop
=======
>>>>>>> origin/comment
												<label class="form-label">Last Name</label>
												<input type="text" class="form-control">
											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12">
											<div class="form-group">
												<label class="form-label">Email</label>
<<<<<<< HEAD
<<<<<<< HEAD
=======
========
>>>>>>>> origin/develop:web/create-course.jsp
												<label class="form-label">Course Price</label>
>>>>>>> origin/DashBoard:web/create-course.jsp
=======
<<<<<<<< HEAD:web/add-account.jsp
=======
												<label class="form-label">Course Price</label>
>>>>>>> origin/DashBoard:build/web/create-course.jsp
========
>>>>>>>> origin/develop:web/edit-account.jsp
>>>>>>> origin/develop
												<input type="text" class="form-control">
											</div>
										</div>
										<div class="col-lg-12 col-md-12 col-sm-12">
											<div class="form-group">
<<<<<<< HEAD
<<<<<<< HEAD:web/edit-account.jsp
												<label class="form-label">Password</label>
=======
												<label class="form-label">Instructor Name</label>
<<<<<<<< HEAD:web/edit-account.jsp
>>>>>>> origin/DashBoard:web/create-course.jsp
========
>>>>>>>> origin/develop:web/create-course.jsp
=======
<<<<<<<< HEAD:web/add-account.jsp
<<<<<<< HEAD:web/add-account.jsp
												<label class="form-label">Password</label>
=======
												<label class="form-label">Instructor Name</label>
>>>>>>> origin/DashBoard:build/web/create-course.jsp
========
												<label class="form-label">Password</label>
>>>>>>>> origin/develop:web/edit-account.jsp
>>>>>>> origin/develop
=======
												<input type="text" class="form-control">
											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12">
											<div class="form-group">
												<label class="form-label">Password</label>
>>>>>>> origin/comment
												<input type="text" class="form-control">
											</div>
										</div>
										<div class="col-lg-12 col-md-12 col-sm-12">
											<div class="form-group fallback w-100">
												<label class="form-label d-block">User Photo</label>
												<input type="file" class="dropify" data-default-file="">
											</div>
										</div>
										<div class="col-lg-12 col-md-12 col-sm-12">
											<button type="submit" class="btn btn-primary">Submit</button>
											<button type="submit" class="btn btn-light" style="background-color: gainsboro;">Cencel</button>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
				
<<<<<<< HEAD
========
                    </div>
                </div>
>>>>>>>> origin/comment:build/web/edit-course.jsp
            </div>
            
        </div>
    </div>
    <!-- Content body end -->

<<<<<<<< HEAD:web/edit-account.jsp
=======
            </div>
        </div>
        <!--**********************************
            Content body end
        ***********************************-->

>>>>>>> origin/comment
        <!-- Footer Start -->
    <div class="container-fluid bg-dark text-white py-5 px-sm-3 px-lg-5" style="margin-top: 90px;">
        <div class="row pt-5">
            <div class="col-lg-7 col-md-12">
                <div class="row">
                    <div class="col-md-6 mb-5">
                        <h5 class="text-primary text-uppercase mb-4" style="letter-spacing: 5px;">Get In Touch</h5>
                        <p><i class="fa fa-map-marker-alt mr-2"></i>123 Street, New York, USA</p>
                        <p><i class="fa fa-phone-alt mr-2"></i>+012 345 67890</p>
                        <p><i class="fa fa-envelope mr-2"></i>info@example.com</p>
                        <div class="d-flex justify-content-start mt-4">
                            <a class="btn btn-outline-light btn-square mr-2" href="#"><i class="fab fa-twitter"></i></a>
                            <a class="btn btn-outline-light btn-square mr-2" href="#"><i class="fab fa-facebook-f"></i></a>
                            <a class="btn btn-outline-light btn-square mr-2" href="#"><i class="fab fa-linkedin-in"></i></a>
                            <a class="btn btn-outline-light btn-square" href="#"><i class="fab fa-instagram"></i></a>
                        </div>
                    </div>
                    <div class="col-md-6 mb-5">
                        <h5 class="text-primary text-uppercase mb-4" style="letter-spacing: 5px;">Our Courses</h5>
                        <div class="d-flex flex-column justify-content-start">
                            <a class="text-white mb-2" href="#"><i class="fa fa-angle-right mr-2"></i>Web Design</a>
                            <a class="text-white mb-2" href="#"><i class="fa fa-angle-right mr-2"></i>Apps Design</a>
                            <a class="text-white mb-2" href="#"><i class="fa fa-angle-right mr-2"></i>Marketing</a>
                            <a class="text-white mb-2" href="#"><i class="fa fa-angle-right mr-2"></i>Research</a>
                            <a class="text-white" href="#"><i class="fa fa-angle-right mr-2"></i>SEO</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-5 col-md-12 mb-5">
                <h5 class="text-primary text-uppercase mb-4" style="letter-spacing: 5px;">Newsletter</h5>
                <p>Rebum labore lorem dolores kasd est, et ipsum amet et at kasd, ipsum sea tempor magna tempor. Accu kasd sed ea duo ipsum. Dolor duo eirmod sea justo no lorem est diam</p>
                <div class="w-100">
                    <div class="input-group">
                        <input type="text" class="form-control border-light" style="padding: 30px;" placeholder="Your Email Address">
                        <div class="input-group-append">
                            <button class="btn btn-primary px-4">Sign Up</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="container-fluid bg-dark text-white border-top py-4 px-sm-3 px-md-5" style="border-color: rgba(256, 256, 256, .1) !important;">
        <div class="row">
            <div class="col-lg-6 text-center text-md-left mb-3 mb-md-0">
                <p class="m-0 text-white">&copy; <a href="#">Domain Name</a>. All Rights Reserved. Designed by <a href="https://htmlcodex.com">HTML Codex</a>
                </p>
            </div>
            <div class="col-lg-6 text-center text-md-right">
                <ul class="nav d-inline-flex">
                    <li class="nav-item">
                        <a class="nav-link text-white py-0" href="#">Privacy</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-white py-0" href="#">Terms</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-white py-0" href="#">FAQs</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-white py-0" href="#">Help</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
<<<<<<< HEAD
========
    <!-- Footer Start -->
    <jsp:include page="footer.jsp"></jsp:include>
>>>>>>>> origin/comment:build/web/edit-course.jsp
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
=======
    <!-- Footer End -->

    <!-- JavaScript Libraries -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
>>>>>>> origin/comment
</body>
</html>
