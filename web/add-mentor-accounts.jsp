<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width,initial-scale=1">
        <title>Edumin - Bootstrap Admin Dashboard </title>
        <!-- Favicon icon -->
        <link rel="icon" type="image/png" sizes="16x16" href="images2/favicon.png">
        <link rel="stylesheet" href="vendor/bootstrap-select/dist/css/bootstrap-select.min.css">
        <link rel="stylesheet" href="css2/style.css">

        <!-- Pick date -->
        <link rel="stylesheet" href="vendor/pickadate/themes/default.css">
        <link rel="stylesheet" href="vendor/pickadate/themes/default.date.css">

        <link rel="stylesheet" href="vendor/jqvmap/css/jqvmap.min.css">
        <link rel="stylesheet" href="vendor/chartist/css/chartist.min.css">


        <link rel="stylesheet" href="css2/skin-2.css">
        <style>
            .error {
                color: red;
                display: none;
            }
        </style>
        <style>
            .masked-password {
                letter-spacing: 0.3em; /* Adjust letter spacing to make it look more like a real password */
            }
        </style>
        <script>
            document.addEventListener('DOMContentLoaded', (event) => {
                const passwordField = document.getElementById('passwordField');
                const actualPassword = passwordField.getAttribute('data-password');
                passwordField.value = '*'.repeat(actualPassword.length);
            });
        </script>

    </head>

    <body>
        <!--*******************
             Preloader start
         ********************-->
        <div id="preloader">
            <div class="sk-three-bounce">
                <div class="sk-child sk-bounce1"></div>
                <div class="sk-child sk-bounce2"></div>
                <div class="sk-child sk-bounce3"></div>
            </div>
        </div>
        <!--*******************
            Preloader end
        ********************-->

        <!--**********************************
            Main wrapper start
        ***********************************-->
        <div id="main-wrapper">

            <!--**********************************
                Nav header start
            ***********************************-->
            <div class="nav-header">
                <a href="list_accounts" class="brand-logo">
                    <img class="logo-abbr" src="images2/logo-white.png" alt="">
                    <img class="logo-compact" src="images2/logo-text-white.png" alt="">
                    <img class="brand-title" src="images2/logo-text-white.png" alt="">
                </a>

                <div class="nav-control">
                    <div class="hamburger">
                        <span class="line"></span><span class="line"></span><span class="line"></span>
                    </div>
                </div>
            </div>
            <!--**********************************
                Nav header end
            ***********************************-->

            <!--**********************************
                Header start
            ***********************************-->
            <jsp:include page="admin_header.jsp"></jsp:include>
            <!--**********************************
                Sidebar end
            ***********************************-->

            <!--**********************************
                Content body start
            ***********************************-->
            <div class="content-body">
                <!-- row -->
                <div class="container-fluid">

                    <div class="row page-titles mx-0">
                        <div class="col-sm-6 p-md-0">
                            <div class="welcome-text">
                                <h4>ADD MENTOR ACCOUNTS</h4>
                            </div>
                            <div class="welcome-text">
                                <a href="all_mentor_accounts" class="btn btn-primary">BACK</a>

                            </div>
                        </div>

                    </div>

                    <div class="row">
                        <div class="col-xl-12 col-xxl-12 col-sm-12">
                            <div class="card">
                                <c:set var="u" value="${account}"/>
                                <div class="card-header">
                                    <h5 class="card-title">Basic Info</h5>

                                </div>
                                <c:if test="${not empty errorMessage}">
                                    <div style="color: red;">
                                        ${errorMessage}
                                    </div>
                                </c:if>




                                <div class="card-body">
                                    <form action="all_mentor_accounts" method="post" id="emailForm">
                                        <div class="row">

                                            <div class="col-lg-6 col-md-6 col-sm-12">
                                                <div class="form-group">
                                                    <label class="form-label"><strong>ID_EXCEL</strong></label>
                                                    <input name="idCheck" type="text" class="form-control" value="${u.idcheck}" readonly>

                                                </div>

                                            </div>

                                            <div class="col-lg-6 col-md-6 col-sm-12">
                                                <div class="form-group">
                                                    <label class="form-label"><strong>USER Name</strong></label>

                                                    <input name="name" type="text" class="form-control" value="${u.name}" >

                                                </div>
                                                <c:if test="${not empty errorUserName}">
                                                    <div style="color: red;">
                                                        ${errorUserName}
                                                    </div>
                                                </c:if>
                                            </div>
                                            <div class="col-lg-6 col-md-6 col-sm-12">
                                                <div class="form-group">
                                                    <label class="form-label"><strong>Password</strong></label>
                                                    <input id="passwordField" name="pas" type="text" class="form-control " value="${u.password}" >
                                                </div>
                                                <c:if test="${not empty errorPassword}">
                                                    <div style="color: red;">
                                                        ${errorPassword}
                                                    </div>
                                                </c:if>
                                            </div>
                                            <div class="col-lg-6 col-md-6 col-sm-12">
                                                <div class="form-group">
                                                    <label for="email">Email:</label>
                                                    <input name="email" id="email" type="text" class="form-control" value="${u.email}" >

                                                </div>
                                                <c:if test="${not empty errorEmail}">
                                                    <div style="color: red;">
                                                        ${errorEmail}
                                                    </div>
                                                </c:if>
                                            </div>

                                            <div class="col-lg-6 col-md-6 col-sm-12">
                                                <div class="form-group">
                                                    <label class="form-label"><strong>First Name</strong></label>
                                                    <input name="fname" type="text" class="form-control" value="${u.first_name}" >
                                                </div>
                                                <c:if test="${not empty errorFirstName}">
                                                    <div style="color: red;">
                                                        ${errorFirstName}
                                                    </div>
                                                </c:if>
                                            </div>
                                            <div class="col-lg-6 col-md-6 col-sm-12">
                                                <div class="form-group">
                                                    <label class="form-label"><strong>Last Name</strong></label>
                                                    <input name="lname" type="text" class="form-control" value="${u.last_name}" >
                                                </div>
                                                <c:if test="${not empty errorLastName}">
                                                    <div style="color: red;">
                                                        ${errorLastName}
                                                    </div>
                                                </c:if>
                                            </div>
                                                 <div class="col-lg-6 col-md-6 col-sm-12">
                                                <div class="form-group">
                                                    <label class="form-label"><strong>Email Manager</strong></label>
                                                    <input name="gmail_manager" type="text" class="form-control" value="${u.gmail_Manager}" >
                                                </div>
                                                <c:if test="${not empty errorGmail_Manager}">
                                                    <div style="color: red;">
                                                        ${errorGmail_Manager}
                                                    </div>
                                                </c:if>
                                            </div>



                                            <div class="col-lg-12 col-md-12 col-sm-12">
                                                <button type="submit" class="btn btn-primary">Submit</button>
                                                <button type="reset" class="btn btn-light">Reset</button>



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


            <!--**********************************
                Footer start
            ***********************************-->
            <div class="footer">
                <div class="copyright">

                </div>
            </div>
            <!--**********************************
                Footer end
            ***********************************-->

            <!--**********************************
       Support ticket button start
    ***********************************-->

            <!--**********************************
               Support ticket button end
            ***********************************-->


        </div>
        <!--**********************************
            Main wrapper end
        ***********************************-->

        <!--**********************************
            Scripts
        ***********************************-->

        <!-- Required vendors -->
        <script src="vendor/global/global.min.js"></script>
        <script src="vendor/bootstrap-select/dist/js/bootstrap-select.min.js"></script>
        <script src="js2/custom.min.js"></script>
        <script src="js2/dlabnav-init.js"></script>

        <!-- Svganimation scripts -->
        <script src="vendor/svganimation/vivus.min.js"></script>
        <script src="vendor/svganimation/svg.animation.js"></script>
        <script src="js2/styleSwitcher.js"></script>

        <!-- pickdate -->
        <script src="vendor/pickadate/picker.js"></script>
        <script src="vendor/pickadate/picker.time.js"></script>
        <script src="vendor/pickadate/picker.date.js"></script>

        <!-- Pickdate -->
        <script src="js2/plugins-init/pickadate-init.js"></script>


    </body>
</html>