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
<<<<<<< HEAD
<<<<<<< HEAD
=======
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
>>>>>>> origin/DashBoard
=======
>>>>>>> origin/develop

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
<<<<<<< HEAD
<<<<<<< HEAD
                <a href="index.html" class="brand-logo">
=======
                <a href="list_accounts" class="brand-logo">
>>>>>>> origin/DashBoard
=======
                <a href="index.html" class="brand-logo">
>>>>>>> origin/develop
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
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> origin/develop
            <div class="header">
                <div class="header-content">
                    <nav class="navbar navbar-expand">
                        <div class="collapse navbar-collapse justify-content-between">
                            <div class="header-left">
                                <div class="search_bar dropdown">
                                    <span class="search_icon p-3 c-pointer" data-toggle="dropdown">
                                        <i class="mdi mdi-magnify"></i>
                                    </span>
                                    <div class="dropdown-menu p-0 m-0">
                                        <form>
                                            <input class="form-control" type="search" placeholder="Search" aria-label="Search">
                                        </form>
                                    </div>
                                </div>
                            </div>

                            <ul class="navbar-nav header-right">

                                <li class="nav-item dropdown header-profile">
                                    <a class="nav-link" href="#" role="button" data-toggle="dropdown">
                                        <img src="images/profile/education/pic1.jpg" width="20" alt="">
                                    </a>
                                    <div class="dropdown-menu dropdown-menu-right">
                                        <a href="app-profile.html" class="dropdown-item ai-icon">
                                            <svg id="icon-user1" xmlns="http://www.w3.org/2000/svg" width="18" height="18" viewbox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-user"><path d="M20 21v-2a4 4 0 0 0-4-4H8a4 4 0 0 0-4 4v2"></path><circle cx="12" cy="7" r="4"></circle></svg>
                                            <span class="ml-2">Profile </span>
                                        </a>
                                        <a href="email-inbox.html" class="dropdown-item ai-icon">
                                            <svg id="icon-inbox" xmlns="http://www.w3.org/2000/svg" width="18" height="18" viewbox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-mail"><path d="M4 4h16c1.1 0 2 .9 2 2v12c0 1.1-.9 2-2 2H4c-1.1 0-2-.9-2-2V6c0-1.1.9-2 2-2z"></path><polyline points="22,6 12,13 2,6"></polyline></svg>
                                            <span class="ml-2">Inbox </span>
                                        </a>
                                        <a href="page-login.html" class="dropdown-item ai-icon">
                                            <svg id="icon-logout" xmlns="http://www.w3.org/2000/svg" width="18" height="18" viewbox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-log-out"><path d="M9 21H5a2 2 0 0 1-2-2V5a2 2 0 0 1 2-2h4"></path><polyline points="16 17 21 12 16 7"></polyline><line x1="21" y1="12" x2="9" y2="12"></line></svg>
                                            <span class="ml-2">Logout </span>
                                        </a>
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </nav>
                </div>
            </div>
            <!--**********************************
                Header end ti-comment-alt
            ***********************************-->

            <!--**********************************
                Sidebar start
            ***********************************-->
            <div class="dlabnav">
                <div class="dlabnav-scroll">
                    <ul class="metismenu" id="menu">
                        <li class="nav-label first">Main Menu</li>
                        <li><a class="has-arrow" href="javascript:void()" aria-expanded="false">
                                <i class="la la-home"></i>
                                <span class="nav-text">Dashboard</span>
                            </a>
                            <ul aria-expanded="false">
                                <li><a href="dashboard3.jsp">Dashboard</a></li>

                            </ul>
                        </li>


                        <li><a class="has-arrow" href="javascript:void()" aria-expanded="false">
                                <i class="la la-users"></i>
                                <span class="nav-text">Account</span>
                            </a>
                            <ul aria-expanded="false">
                                <li><a href="list_accounts">All Account</a></li>
                                <li><a href="add-account.jsp">Add Account</a></li>                       
                              
                            </ul>
                        </li>
                        <li><a class="has-arrow" href="javascript:void()" aria-expanded="false">
                                <i class="la la-graduation-cap"></i>
                                <span class="nav-text">Courses</span>
                            </a>
                            <ul aria-expanded="false">
                                <li><a href="">All Courses</a></li>


                            </ul>
                        </li>






                    </ul>
                </div>
            </div>
<<<<<<< HEAD
=======
           <jsp:include page="admin_header.jsp"></jsp:include>
>>>>>>> origin/DashBoard
=======
>>>>>>> origin/develop
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
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> origin/develop
                               <div class="welcome-text">
                                            <a href="list_accounts" class="btn btn-primary">BACK</a>

                                        </div>
<<<<<<< HEAD
=======
                            <div class="welcome-text">
                                <a href="list_accounts" class="btn btn-primary">BACK</a>

                            </div>
>>>>>>> origin/DashBoard
=======
>>>>>>> origin/develop
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
<<<<<<< HEAD
<<<<<<< HEAD
                                                    
=======

>>>>>>> origin/DashBoard
=======
                                                    
>>>>>>> origin/develop
                                                </div>
                                            </div>
                                            <div class="col-lg-6 col-md-6 col-sm-12">
                                                <div class="form-group">
                                                    <label class="form-label"><strong>Password</strong></label>
<<<<<<< HEAD
<<<<<<< HEAD
                                                    <input name="pas" type="text" class="form-control" value="${u.password}" disabled>
=======
                                                    <input id="passwordField" name="pas" type="text" class="form-control masked-password" data-password="${u.password}" disabled>
>>>>>>> origin/DashBoard
=======
                                                    <input name="pas" type="text" class="form-control" value="${u.password}" disabled>
>>>>>>> origin/develop
                                                </div>
                                            </div>
                                            <div class="col-lg-6 col-md-6 col-sm-12">
                                                <div class="form-group">
                                                    <label for="email">Email:</label>
                                                    <input name="email" id="email" type="text" class="form-control" value="${u.email}" readonly>
<<<<<<< HEAD
<<<<<<< HEAD
                                                   
=======

>>>>>>> origin/DashBoard
=======
                                                   
>>>>>>> origin/develop
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
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> origin/develop
                                   
                                     

                              
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
                <p>Copyright © Designed &amp; Developed by <a href="../index.htm" target="_blank">DexignLab</a> 2020</p>
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
<<<<<<< HEAD
=======




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
>>>>>>> origin/DashBoard
=======
>>>>>>> origin/develop
</html>