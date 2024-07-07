<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">


    <!-- Mirrored from learnplus.frontendmatter.com/fixed-instructor-quiz-edit.html by HTTrack Website Copier/3.x [XR&CO'2014], Sat, 09 Jun 2018 08:43:05 GMT -->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Instructor - Edit quiz - Fixed layout</title>

        <!-- Prevent the demo from appearing in search engines (REMOVE THIS) -->
        <!--<meta name="robots" content="noindex">-->

        <!-- Simplebar -->
        <!--<link type="text/css" href="assets/vendor/simplebar.css" rel="stylesheet">-->

        <!-- Material Design Icons  -->
        <!--<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">-->

        <!-- Roboto Web Font -->
        <!--<link href="https://fonts.googleapis.com/css?family=Roboto:regular,bold,italic,thin,light,bolditalic,black,medium&amp;lang=en" rel="stylesheet">-->

        <!-- MDK -->
        <!--<link type="text/css" href="assets/vendor/material-design-kit.css" rel="stylesheet">-->

        <!-- Sidebar Collapse -->
        <!--<link type="text/css" href="assets/vendor/sidebar-collapse.min.css" rel="stylesheet">-->

        <!-- App CSS -->
        <link type="text/css" href="assets/css/style.css" rel="stylesheet">


        <!-- Touchspin -->
        <link rel="stylesheet" href="assets/css/bootstrap-touchspin.css">

        <!-- Vendor CSS -->
        <link rel="stylesheet" href="assets/css/nestable.css">


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

        <style>
            .btn-success {
                color: #fff;
                background-color: #ff6600;
                border-color: var(--primary);
            }

            .btn-success:hover {
                color: #fff;
                background-color: #d25d0e;
                border-color: #d25d0e;
            }
        </style>

    </head>

    <body >


        <jsp:include page="header.jsp"></jsp:include>


            <div class="container">

                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="fixed-instructor-dashboard.html">Home</a></li>
                    <li class="breadcrumb-item active">Edit Quiz</li>
                </ol>
                <div class="card">
                    <div class="card-header">
                        <h4 class="card-title">Basic</h4>
                    </div>
                    <div class="card-body">
                        <form action="QuizzesManagement" method="post">
                            <input type="text" name="lessonId" value="${lesson.id}" hidden/>
                        <input type="text" name="action" value="${action}" hidden/>

                        <c:if test="${not empty errorMess}">
                            <div class="alert alert-danger">${errorMess}</div>
                        </c:if>
                        <c:if test="${not empty successMess}">
                            <div class="alert alert-success">${successMess}</div>
                        </c:if>
                        <div class="form-group row">
                            <label for="course_title" class="col-sm-3 col-form-label">Lesson:</label>
                            <div class="col-sm-9 col-md-4">
                                <div class="input-group">

                                    <input type="text" class="form-control"readonly aria-describedby="sizing-addon2" value="${lesson.title}">
                                </div>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="course_title" class="col-sm-3 col-form-label">Quiz Title</label>
                            <div class="col-sm-9 col-md-4">
                                <div class="input-group">

                                    <input type="text" class="form-control" name="quizTitle" placeholder="Enter Quiz Title" aria-describedby="sizing-addon2" value="${quizTitle}">
                                </div>
                            </div>
                        </div>


                        <div class="form-group row">
                            <label for="time_toggle" class="col-sm-3 col-form-label">Timeframe</label>
                            <div class="col-sm-9">
                                <div class="switch">
                                    <input id="cmn-toggle" class="switch-toggle switch-toggle-round" name="time" type="checkbox" ${time != null ? 'checked':''}>
                                    <label for="cmn-toggle"></label>
                                </div>
                                <div class="form-inline">
                                    <div class="form-group">
                                        <input type="text" class="form-control text-center" name="timeSet" value="${timeSet}" style="width:50px;">
                                    </div>
                                    <div class="form-group">
                                        <select class="custom-select" name="typeOfTime">
                                            <option value="hour" ${typeOfTime eq 'hour' ?'selected':''}>Hours</option>
                                            <option value="minutes" ${typeOfTime eq 'minutes' ?'selected':''}>Minutes</option>
                                        </select>
                                    </div>
                                </div>

                            </div>
                            <label for="time_toggle" class="col-sm-3 col-form-label">Active</label>
                            <div class="col-sm-9">
                                <div class="switch">
                                    <input id="cmn-toggles" class="switch-toggle switch-toggle-round" name="active" type="checkbox" ${active != null?'checked':''}>
                                    <label for="cmn-toggles"></label>
                                </div>


                            </div>

                        </div>
                        <div class="card-header bg-white">
                            <button type="submit" class="btn btn-success">Submit</button>
                        </div>
                    </form>
                </div>
            </div>



        </div>







        <!-- jQuery -->
        <script src="assets/vendor/jquery.min.js"></script>

        <!-- Bootstrap -->
        <script src="assets/vendor/popper.min.js"></script>
        <script src="assets/vendor/bootstrap.min.js"></script>

        <!-- Simplebar -->
        <!-- Used for adding a custom scrollbar to the drawer -->
        <script src="assets/vendor/simplebar.js"></script>

        <!-- MDK -->
        <script src="assets/vendor/dom-factory.js"></script>
        <script src="assets/vendor/material-design-kit.js"></script>

        <!-- Sidebar Collapse -->
        <script src="assets/vendor/sidebar-collapse.js"></script>

        <!-- App JS -->
        <script src="assets/js/main.js"></script>


        <!-- Vendor JS -->
        <script src="assets/vendor/jquery.nestable.js"></script>
        <script src="assets/vendor/jquery.bootstrap-touchspin.js"></script>



        <!-- Initialize -->
        <script src="assets/js/nestable.js"></script>
        <script src="assets/js/touchspin.js"></script>




    </body>


    <!-- Mirrored from learnplus.frontendmatter.com/fixed-instructor-quiz-edit.html by HTTrack Website Copier/3.x [XR&CO'2014], Sat, 09 Jun 2018 08:43:05 GMT -->
</html>