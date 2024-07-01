<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
?<!DOCTYPE html>
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
                                <h4>EDIT ACCOUNT</h4>
                            </div>
                            <div class="welcome-text">
                                <a href="list_accounts" class="btn btn-primary">BACK</a>

                            </div>
                        </div>

                    </div>

                    <div class="row">
                        <div class="col-xl-12 col-xxl-12 col-sm-12">
                            <div class="card">
                                <c:set var="u" value="${user}"/>
                                <div class="card-header">
                                    <h5 class="card-title">Basic Info</h5>
                                    <img src="${u.avatar}" width="100" class="img-fluid rounded-circle" alt="">
                                </div>

                                <div class="card-body">
                                    <form action="edit_account" method="post" id="emailForm">
                                        <div class="row">
                                            <div class="col-lg-6 col-md-6 col-sm-12">
                                                <div class="form-group">
                                                    <label class="form-label"><strong>USER_ID</strong></label>
                                                    <input name="id" type="text" class="form-control" value="${u.id}" readonly>
                                                </div>
                                            </div>
                                            <div class="col-lg-6 col-md-6 col-sm-12">
                                                <div class="form-group">
                                                    <label class="form-label"><strong>Name</strong></label>
                                                    <input name="name" type="text" class="form-control" value="${u.username}" readonly>

                                                </div>
                                            </div>
                                            <div class="col-lg-6 col-md-6 col-sm-12">
                                                <div class="form-group">
                                                    <label class="form-label"><strong>Password</strong></label>
                                                    <input id="passwordField" name="pas" type="text" class="form-control masked-password" data-password="${u.password}" disabled>
                                                </div>
                                            </div>
                                            <div class="col-lg-6 col-md-6 col-sm-12">
                                                <div class="form-group">
                                                    <label for="email">Email:</label>
                                                    <input name="email" id="email" type="text" class="form-control" value="${u.email}" readonly>

                                                </div>
                                            </div>
                                            <div class="col-lg-6 col-md-6 col-sm-12">
                                                <div class="form-group">
                                                    <label class="form-label"><strong>First Name</strong></label>
                                                    <input name="fname" type="text" class="form-control" value="${u.firstName}" readonly>
                                                </div>
                                            </div>
                                            <div class="col-lg-6 col-md-6 col-sm-12">
                                                <div class="form-group">
                                                    <label class="form-label"><strong>Last Name</strong></label>
                                                    <input name="lname" type="text" class="form-control" value="${u.lastName}" readonly>
                                                </div>
                                            </div>
                                            <div class="col-lg-6 col-md-6 col-sm-12">
                                                <div class="form-group">
                                                    <label class="form-label"><strong>Role</strong></label>
                                                    <select name="role" class="form-control">
                                                        <option value="1" ${u.role.id  == 1?"selected":""}>Mentee</option>
                                                        <option value="2" ${u.role.id  == 2?"selected":""}>Mentor</option>
                                                        <option value="4" ${u.role.id  == 4?"selected":""}>Manager</option>
                                                        <option value="3" ${u.role.id  == 3?"selected":""}>Admin</option>

                                                    </select>
                                                </div>
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
        <script>
            document.getElementById('emailForm').addEventListener('submit', function (event) {
                const emailInput = document.getElementById('email');
                const emailError = document.getElementById('emailError');
                const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

                if (!emailPattern.test(emailInput.value)) {
                    emailError.style.display = 'block';
                    event.preventDefault();
                } else {
                    emailError.style.display = 'none';
                }
            });
        </script>

    </body>
</html>