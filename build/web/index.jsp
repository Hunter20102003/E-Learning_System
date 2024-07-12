<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <title>ECOURSES - Online Courses HTML Template</title>
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="Free HTML Templates" name="keywords">
        <meta content="Free HTML Templates" name="description">

        <!-- Favicon -->
        <link href="img/favicon.ico" rel="icon">

        <!-- Google Web Fonts -->
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700&display=swap" rel="stylesheet"> 

        <!-- Font Awesome -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">

        <!-- Libraries Stylesheet -->
        <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

        <!-- Customized Bootstrap Stylesheet -->
        <link href="css/style.css" rel="stylesheet">
    </head>

    <body>
        <!-- Topbar Start -->
        <jsp:include page="header.jsp"></jsp:include>
            <!-- Navbar End -->


            <!-- Carousel Start -->
            <div class="container-fluid p-0 pb-5 mb-5">
                <div id="header-carousel" class="carousel slide carousel-fade" data-ride="carousel">
                    <ol class="carousel-indicators">
                        <li data-target="#header-carousel" data-slide-to="0" class="active"></li>
                        <li data-target="#header-carousel" data-slide-to="1"></li>
                        <li data-target="#header-carousel" data-slide-to="2"></li>
                    </ol>
                    <div class="carousel-inner">
                        <div class="carousel-item active" style="min-height: 300px;">
                            <img class="position-relative w-100" src="img/carousel-1.jpg" style="min-height: 300px; object-fit: cover;">
                            <div class="carousel-caption d-flex align-items-center justify-content-center">
                                <div class="p-5" style="width: 100%; max-width: 900px;">
                                    <h5 class="text-white text-uppercase mb-md-3">Best Online Courses</h5>
                                    <h1 class="display-3 text-white mb-md-4">Best Education From Your Home</h1>
                                </div>
                            </div>
                        </div>
                        <div class="carousel-item" style="min-height: 300px;">
                            <img class="position-relative w-100" src="img/carousel-2.jpg" style="min-height: 300px; object-fit: cover;">
                            <div class="carousel-caption d-flex align-items-center justify-content-center">
                                <div class="p-5" style="width: 100%; max-width: 900px;">
                                    <h5 class="text-white text-uppercase mb-md-3">Best Online Courses</h5>
                                    <h1 class="display-3 text-white mb-md-4">Best Online Learning Platform</h1>
                                </div>
                            </div>
                        </div>
                        <div class="carousel-item" style="min-height: 300px;">
                            <img class="position-relative w-100" src="img/carousel-3.jpg" style="min-height: 300px; object-fit: cover;">
                            <div class="carousel-caption d-flex align-items-center justify-content-center">
                                <div class="p-5" style="width: 100%; max-width: 900px;">
                                    <h5 class="text-white text-uppercase mb-md-3">Best Online Courses</h5>
                                    <h1 class="display-3 text-white mb-md-4">New Way To Learn From Home</h1>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Carousel End -->


            <!-- About Start -->
            <div class="container-fluid py-5">
                <div class="container py-5">
                    <div class="row align-items-center">
                        <div class="col-lg-5">
                            <img class="img-fluid rounded mb-4 mb-lg-0" src="img/about.jpg" alt="">
                        </div>
                        <div class="col-lg-7">
                            <div class="text-left mb-4">
                                <h5 class="text-primary text-uppercase mb-3" style="letter-spacing: 5px;">About Us</h5>
                                <h1>Group 1 of the SWP project</h1>
                            </div>
                            <p>Our SWP project includes members Duong Quang Phuc(Leader), Nguyen Dinh Quyen, Bui Quang Thai, Dang Vu Viet Anh, Dinh Hai Dang. This is our first product, we will try to update regularly to ensure the product can run in the most stable way.</p>
                        </div>
                    </div>
                </div>
            </div>
            <!-- About End -->


            <!-- Category Start -->
            <div class="container-fluid py-5">
                <div class="container pt-5 pb-3">
                    <div class="text-center mb-5">
                        <h5 class="text-primary text-uppercase mb-3" style="letter-spacing: 5px;">Subjects</h5>
                        <h1>Explore Top Subjects</h1>
                    </div>
                    <div class="row">
                        <c:forEach var ="i" items="${listTypeOfCourse}">
                        <div class="col-lg-4 col-md-6 mb-4">
                            <div class="cat-item position-relative overflow-hidden rounded mb-2">    
                            
                                <img class="img-fluid" src="${courseDAO.getCourseTypeImgByIDType(i.id)}" alt="category">
                        <a class="cat-overlay text-white text-decoration-none" href="course?cbxTypesOfCourse=${i.id}">
                            <h4 class="text-white font-weight-medium" style="text-align: center; width: 100%; height: auto">${i.name}</h4>
                        </a>
                        </div>
                    </div>
                        </c:forEach>
                </div>
            </div>
        </div>
        <!-- Category Start -->


        <!-- Courses Start -->
        <div class="container-fluid py-5">
            <div class="container py-5">
                <div class="text-center mb-5">
                    <h5 class="text-primary text-uppercase mb-3" style="letter-spacing: 5px;">Courses</h5>
                    <h1>The course good Rating</h1>
                </div>
                <div class="row">
                    <c:forEach var="i" items="${listCourse}">
                        <c:if test="${i.is_locked == false}">
                            <div class="col-lg-4 col-md-6 mb-4">
                                <div class="rounded overflow-hidden mb-2">
                                    <img class="img-fluid" src="${i.img}" alt="">
                                    <div class="bg-secondary p-4">
                                        <div class="d-flex justify-content-between mb-3">

                                            <small class="m-0"><i class="fa fa-users text-primary mr-2"></i>${courseDao.getAllEnrollmentByCourseID(i.id).size()} Students</small>

<<<<<<< HEAD
    <!-- Courses Start -->
    <div class="container-fluid py-5">
        <div class="container py-5">
            <div class="text-center mb-5">
                <h5 class="text-primary text-uppercase mb-3" style="letter-spacing: 5px;">Courses</h5>
                <h1>Our Popular Courses</h1>
            </div>
            <div class="row">
                <div class="col-lg-4 col-md-6 mb-4">
                    <div class="rounded overflow-hidden mb-2">
                        <img class="img-fluid" src="img/course-1.jpg" alt="">
                        <div class="bg-secondary p-4">
                            <div class="d-flex justify-content-between mb-3">
                                <small class="m-0"><i class="fa fa-users text-primary mr-2"></i>25 Students</small>
                                <small class="m-0"><i class="far fa-clock text-primary mr-2"></i>01h 30m</small>
                            </div>
                            <a class="h5" href="">Web design & development courses for beginner</a>
                            <div class="border-top mt-4 pt-4">
                                <div class="d-flex justify-content-between">
                                    <h6 class="m-0"><i class="fa fa-star text-primary mr-2"></i>4.5 <small>(250)</small></h6>
                                    <h5 class="m-0">$99</h5>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6 mb-4">
                    <div class="rounded overflow-hidden mb-2">
                        <img class="img-fluid" src="img/course-2.jpg" alt="">
                        <div class="bg-secondary p-4">
                            <div class="d-flex justify-content-between mb-3">
                                <small class="m-0"><i class="fa fa-users text-primary mr-2"></i>25 Students</small>
                                <small class="m-0"><i class="far fa-clock text-primary mr-2"></i>01h 30m</small>
                            </div>
                            <a class="h5" href="">Web design & development courses for beginner</a>
                            <div class="border-top mt-4 pt-4">
                                <div class="d-flex justify-content-between">
                                    <h6 class="m-0"><i class="fa fa-star text-primary mr-2"></i>4.5 <small>(250)</small></h6>
                                    <h5 class="m-0">$99</h5>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6 mb-4">
                    <div class="rounded overflow-hidden mb-2">
                        <img class="img-fluid" src="img/course-3.jpg" alt="">
                        <div class="bg-secondary p-4">
                            <div class="d-flex justify-content-between mb-3">
                                <small class="m-0"><i class="fa fa-users text-primary mr-2"></i>25 Students</small>
                                <small class="m-0"><i class="far fa-clock text-primary mr-2"></i>01h 30m</small>
                            </div>
                            <a class="h5" href="">Web design & development courses for beginner</a>
                            <div class="border-top mt-4 pt-4">
                                <div class="d-flex justify-content-between">
                                    <h6 class="m-0"><i class="fa fa-star text-primary mr-2"></i>4.5 <small>(250)</small></h6>
                                    <h5 class="m-0">$99</h5>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6 mb-4">
                    <div class="rounded overflow-hidden mb-2">
                        <img class="img-fluid" src="img/course-4.jpg" alt="">
                        <div class="bg-secondary p-4">
                            <div class="d-flex justify-content-between mb-3">
                                <small class="m-0"><i class="fa fa-users text-primary mr-2"></i>25 Students</small>
                                <small class="m-0"><i class="far fa-clock text-primary mr-2"></i>01h 30m</small>
                            </div>
                            <a class="h5" href="">Web design & development courses for beginner</a>
                            <div class="border-top mt-4 pt-4">
                                <div class="d-flex justify-content-between">
                                    <h6 class="m-0"><i class="fa fa-star text-primary mr-2"></i>4.5 <small>(250)</small></h6>
                                    <h5 class="m-0">$99</h5>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6 mb-4">
                    <div class="rounded overflow-hidden mb-2">
                        <img class="img-fluid" src="img/course-5.jpg" alt="">
                        <div class="bg-secondary p-4">
                            <div class="d-flex justify-content-between mb-3">
                                <small class="m-0"><i class="fa fa-users text-primary mr-2"></i>25 Students</small>
                                <small class="m-0"><i class="far fa-clock text-primary mr-2"></i>01h 30m</small>
                            </div>
                            <a class="h5" href="">Web design & development courses for beginner</a>
                            <div class="border-top mt-4 pt-4">
                                <div class="d-flex justify-content-between">
                                    <h6 class="m-0"><i class="fa fa-star text-primary mr-2"></i>4.5 <small>(250)</small></h6>
                                    <h5 class="m-0">$99</h5>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6 mb-4">
                    <div class="rounded overflow-hidden mb-2">
                        <img class="img-fluid" src="img/course-6.jpg" alt="">
                        <div class="bg-secondary p-4">
                            <div class="d-flex justify-content-between mb-3">
                                <small class="m-0"><i class="fa fa-users text-primary mr-2"></i>25 Students</small>
                                <small class="m-0"><i class="far fa-clock text-primary mr-2"></i>01h 30m</small>
                            </div>
                            <a class="h5" href="">Web design & development courses for beginner</a>
                            <div class="border-top mt-4 pt-4">
                                <div class="d-flex justify-content-between">
                                    <h6 class="m-0"><i class="fa fa-star text-primary mr-2"></i>4.5 <small>(250)</small></h6>
                                    <h5 class="m-0">$99</h5>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Courses End -->


    <!-- Registration Start -->
    <div class="container-fluid bg-registration py-5" style="margin: 90px 0;">
        <div class="container py-5">
            <div class="row align-items-center">
                <div class="col-lg-7 mb-5 mb-lg-0">
                    <div class="mb-4">
                        <h5 class="text-primary text-uppercase mb-3" style="letter-spacing: 5px;">Need Any Courses</h5>
                        <h1 class="text-white">30% Off For New Students</h1>
                    </div>
                    <p class="text-white">Invidunt lorem justo sanctus clita. Erat lorem labore ea, justo dolor lorem ipsum ut sed eos,
                        ipsum et dolor kasd sit ea justo. Erat justo sed sed diam. Ea et erat ut sed diam sea ipsum est
                        dolor</p>
                    <ul class="list-inline text-white m-0">
                        <li class="py-2"><i class="fa fa-check text-primary mr-3"></i>Labore eos amet dolor amet diam</li>
                        <li class="py-2"><i class="fa fa-check text-primary mr-3"></i>Etsea et sit dolor amet ipsum</li>
                        <li class="py-2"><i class="fa fa-check text-primary mr-3"></i>Diam dolor diam elitripsum vero.</li>
                    </ul>
                </div>
                <div class="col-lg-5">
                    <div class="card border-0">
                        <div class="card-header bg-light text-center p-4">
                            <h1 class="m-0">Sign Up Now</h1>
                        </div>
                        <div class="card-body rounded-bottom bg-primary p-5">
                            <form>
                                <div class="form-group">
                                    <input type="text" class="form-control border-0 p-4" placeholder="Your name" required="required" />
                                </div>
                                <div class="form-group">
                                    <input type="email" class="form-control border-0 p-4" placeholder="Your email" required="required" />
                                </div>
                                <div class="form-group">
                                    <select class="custom-select border-0 px-4" style="height: 47px;">
                                        <option selected>Select a course</option>
                                        <option value="1">Course 1</option>
                                        <option value="2">Course 1</option>
                                        <option value="3">Course 1</option>
                                    </select>
                                </div>
                                <div>
                                    <button class="btn btn-dark btn-block border-0 py-3" type="submit">Sign Up Now</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Registration End -->


    <!-- Team Start -->
    <div class="container-fluid py-5">
        <div class="container pt-5 pb-3">
            <div class="text-center mb-5">
                <h5 class="text-primary text-uppercase mb-3" style="letter-spacing: 5px;">Teachers</h5>
                <h1>Meet Our Teachers</h1>
            </div>
            <div class="row">
                <div class="col-md-6 col-lg-3 text-center team mb-4">
                    <div class="team-item rounded overflow-hidden mb-2">
                        <div class="team-img position-relative">
                            <img class="img-fluid" src="img/team-1.jpg" alt="">
                            <div class="team-social">
                                <a class="btn btn-outline-light btn-square mx-1" href="#"><i class="fab fa-twitter"></i></a>
                                <a class="btn btn-outline-light btn-square mx-1" href="#"><i class="fab fa-facebook-f"></i></a>
                                <a class="btn btn-outline-light btn-square mx-1" href="#"><i class="fab fa-linkedin-in"></i></a>
=======
                                            <small class="m-0"><i class="far fa-clock text-primary mr-2"></i>${youTubeDuration.convertToHoursAndMinutes(courseDao.getDurationOfCourse(i.id))}</small>
                                        </div>

                                        <a class="h5" href="course/detail?course_id=${i.id}">${i.name}</a>
                                        <div class="border-top mt-4 pt-4">
                                            <div class="d-flex justify-content-between">
                                                <c:set var="sumRating" value="0" />
                                                <c:set var="sumReview" value="0" />

                                                <c:forEach var="j" items="${courseDao.getAllReviewByCourseID(i.id)}">
                                                    <c:if test="${j.review_text != null}">
                                                        <c:set var="sumReview" value="${sumReview + 1}" />
                                                    </c:if>
                                                    <c:set var="sumRating" value="${sumRating + j.rating}" />
                                                </c:forEach>
                                                <c:set var="averageRating" value="0" />

                                                <c:if test="${fn:length(courseDao.getAllReviewByCourseID(i.id)) ne 0}">
                                                    <c:set var="averageRating" value="${sumRating / fn:length(courseDao.getAllReviewByCourseID(i.id))}" />
                                                </c:if>

                                                <fmt:formatNumber var="rattingFormat" pattern="0.0" value="${averageRating}" />

                                                <h6 class="m-0"><i class="fa fa-star text-primary mr-2"></i>${rattingFormat} <small>(${sumReview})</small></h6>
                                                <c:choose>

                                                    <c:when test="${i.price eq 0}"> <h5 class="m-0" style="color:green">Free</h5></c:when>
                                                    <c:otherwise> 
                                                        <fmt:formatNumber var="format" pattern="#,###" value="${i.price}" />

                                                        <h5 class="m-0">${format}đ</h5>
                                                    </c:otherwise>
                                                </c:choose>

                                            </div>
                                        </div>
                                    </div>
                                </div>
>>>>>>> origin/create-course1
                            </div>
                        </c:if>      
                    </c:forEach>
                </div>
            </div>
        </div>
        <!-- Courses End -->

        <!-- Footer Start -->
        <jsp:include page="footer.jsp"></jsp:include>
        <!-- Footer End -->


        <!-- Back to Top -->
        <a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top"><i class="fa fa-angle-double-up"></i></a>


        <!-- JavaScript Libraries -->
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