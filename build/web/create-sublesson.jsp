<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Create Sublesson - ECOURSES</title>
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">
    </head>
    <body>

        <jsp:include page="header.jsp"></jsp:include>
            <!-- Navbar End -->

            <!--**********************************
                   Content body start
               ***********************************-->
            <div class="content-body" style="margin-top: 20px;">
                <!-- row -->
                <div class="container-fluid">

                    <div class="row">
                        <div class="col-lg-12">
                            <div class="card">
                                <div class="card-header">
                                    <h4 class="card-title">Create Sublesson</h4>
                                </div>
                                <div class="card-body">
<<<<<<< HEAD
<<<<<<< HEAD
                                    <form action="sublessonManagement" method="get">
=======
                                    <form action="sublessonManagement" method="post">
>>>>>>> origin/create-course1
=======
                                    <form action="sublessonManagement" method="post">
>>>>>>> origin/front-end
                                    <c:if test="${not empty errorMess}">
                                        <div class="alert alert-danger">${errorMess}</div>
                                    </c:if>
                                    <c:if test="${not empty successMess}">
                                        <div class="alert alert-success">${successMess}</div>
                                    </c:if>
                                    <div class="row">
                                        <div class="col-lg-12 col-md-12 col-sm-12">
                                            <div class="form-group">
                                                <label class="form-label">Lesson Name</label>
                                                <input type="text" class="form-control" value="${lesson.title}" readonly >
                                            </div>
                                        </div>
                                        <div class="col-lg-12 col-md-12 col-sm-12">
                                            <div class="form-group">
                                                <label class="form-label">SubLesson Title</label>
                                                <input type="text" class="form-control" name="title" value="${title}">
                                            </div>
                                        </div>
                                        <div class="col-lg-12 col-md-12 col-sm-12">
                                            <div class="form-group">
                                                <label class="form-label">SubLesson Content</label>
                                                <input type="text" class="form-control" name="content" value="${content}">
                                            </div>
                                        </div>
                                        <div class="col-lg-12 col-md-12 col-sm-12">
                                            <div class="form-group">
                                                <label class="form-label">Sublesson Description</label>
                                                <textarea class="form-control" name="description" " rows="5">${description}</textarea>
                                            </div>
                                        </div>
                                        <div class="col-lg-12 col-md-12 col-sm-12">
                                            <div class="form-group">
                                                <label class="form-label">Video Link</label>
                                                <input type="text" name="videoLink" value="${videoLink}" class="form-control">
                                            </div>
                                            <table >
                                                <tbody>
                                                    <tr>
                                                        <td>  <label class="form-label">Active Sublesson</label></td>
                                                        <td> <input type="radio" name="active" value="0" ${active eq 0 ?"checked":""}></td>
                                                    </tr>
                                                    <tr>
                                                        <td> <label class="form-label">Inactive Sublesson</label></td>
                                                        <td>  <input type="radio" name="active" value="1" ${active eq 1 ?"checked":""}></td>
                                                    </tr>
                                                </tbody>
                                            </table>                        
<<<<<<< HEAD
<<<<<<< HEAD
                                            <input type="hidden" name="lessonId" value="${lessonId}"/>
=======
                                            <input type="hidden" name="lessonId" value="${lesson.id}"/>
>>>>>>> origin/create-course1
=======
                                            <input type="hidden" name="lessonId" value="${lesson.id}"/>
>>>>>>> origin/front-end
                                            <input type="hidden" name="action" value="${action}"/>
                                        </div>

                                        <div class="col-lg-12 col-md-12 col-sm-12">
                                            <button type="submit" class="btn btn-primary">Submit</button>
                                            <a href="CourseContentManagement" class="btn btn-light" style="background-color: gainsboro;">Cancel</a>
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

        <!-- Footer Start -->
        <jsp:include page="footer.jsp"></jsp:include>
        <!-- Footer End -->

        <!-- JavaScript Libraries -->
        <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
