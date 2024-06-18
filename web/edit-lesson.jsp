<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Edit Lesson - ECOURSES</title>
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">
    </head>
    <body>

        <!-- Topbar Start -->
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
                                    <h4 class="card-title">Edit Lesson</h4>
                                </div>
                                <div class="card-body">
                                    <form action="lessonManagement" method="get">
                                        <div class="row">
                                            <div class="col-lg-12 col-md-12 col-sm-12">
                                                <div class="form-group">
                                                    <label class="form-label">Course Name</label>
                                                    <input type="text" class="form-control" value="${course.name}" readonly >
                                            </div>
                                        </div>
                                        <div class="col-lg-12 col-md-12 col-sm-12">
                                            <div class="form-group">
                                                <label class="form-label">Lesson Name</label>
                                                <input type="text" class="form-control" name="lessonName"value="${lessonName}">
                                            </div>
                                        </div>
                                        <div class="col-lg-12 col-md-12 col-sm-12">
                                            
                                            <table >
                                                <tbody>
                                                    <tr>
                                                        <td>  <label class="form-label">Active Lesson</label></td>
                                                        <td> <input type="radio" name="active" value="0" ${active eq 0?"checked":""}/></td>
                                                    </tr>
                                                    <tr>
                                                        <td> <label class="form-label">Inactive Lesson</label></td>
                                                        <td>  <input type="radio" name="active" value="1"  ${active eq 1?"checked":""}/></td>
                                                    </tr>
                                                </tbody>
                                            </table>                        
                                            <input type="hidden" name="lessonId" value="${lessonId}"/>
                                            <input type="hidden" name="action" value="${action}"/>
                                        </div>
                                        <div class="col-lg-12 col-md-12 col-sm-12">
                                            <button type="submit" class="btn btn-primary">Submit</button>
                                            <button type="submit" class="btn btn-light" style="background-color: gainsboro;">Cancel</button>
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
