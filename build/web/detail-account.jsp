﻿<!DOCTYPE html>
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
                <a href="index.html" class="brand-logo">
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
                                <h4>Detail Account </h4>
                            </div>
                        </div>

                    </div>

                    <div class="row">
                        <div class="col-xl-3 col-xxl-4 col-lg-4">
                            <div class="row">
                                <div class="col-lg-12">
                                    <div class="card">
                                        <div class="text-center p-3 overlay-box" style="background-image: url(images/big/img1.jpg);">
                                            <div class="profile-photo">
                                                <img src="images2/profile/profile.png" width="100" class="img-fluid rounded-circle" alt="">
                                            </div>
                                            <h3 class="mt-3 mb-1 text-white">Deangelo Sena</h3>
                                        </div>
                                        <ul class="list-group list-group-flush">
                                            <li class="list-group-item d-flex justify-content-between"><span class="mb-0">number of courses</span> <strong class="text-muted">1204	</strong></li>
                                      <li class="list-group-item d-flex justify-content-between"><span class="mb-0">Number of courses completed</span> <strong class="text-muted">1204	</strong></li>
                                        </ul>
                                      
                                    </div>
                                </div>
                                <div class="col-lg-12">
                                    <div class="card">
                                        <div class="card-header">
                                            <h2 class="card-title">about me</h2>
                                        </div>
                                        <div class="card-body pb-0">
                                            <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry.</p>
                                            <ul class="list-group list-group-flush">
                                                <li class="list-group-item d-flex px-0 justify-content-between">
                                                    <strong>Gender</strong>
                                                    <span class="mb-0">Male</span>
                                                </li>
                                                <li class="list-group-item d-flex px-0 justify-content-between">
                                                    <strong>Education</strong>
                                                    <span class="mb-0">PHD</span>
                                                </li>
                                                <li class="list-group-item d-flex px-0 justify-content-between">
                                                    <strong>Email</strong>
                                                    <span class="mb-0">info@example.com</span>
                                                </li>
                                                <li class="list-group-item d-flex px-0 justify-content-between">
                                                    <strong>Phone</strong>
                                                    <span class="mb-0">+01 123 456 7890</span>
                                                </li>
                                            </ul>
                                        </div>
                                        <div class="card-footer pt-0 pb-0 text-center">
                                            <div class="row">
                                                <div class="col-4 pt-3 pb-3 border-right">
                                                    <h3 class="mb-1 text-primary">150</h3>
                                                    <span>Projects</span>
                                                </div>
                                                <div class="col-4 pt-3 pb-3 border-right">
                                                    <h3 class="mb-1 text-primary">140</h3>
                                                    <span>Uploads</span>
                                                </div>
                                                <div class="col-4 pt-3 pb-3">
                                                    <h3 class="mb-1 text-primary">45</h3>
                                                    <span>Tasks</span>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-12">
                                    <div class="card">
                                        <div class="card-header d-block">
                                            <h4 class="card-title">Address </h4>
                                        </div>
                                        <div class="card-body">
                                            <p class="mb-0">Demo Address #8901 Marmora Road Chi Minh City, Vietnam</p>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-12">
                                    <div class="card">
                                        <div class="card-header d-block">
                                            <h4 class="card-title">Interest </h4>
                                        </div>
                                        <div class="card-body">
                                            <h6>Photoshop
                                                <span class="pull-right">85%</span>
                                            </h6>
                                            <div class="progress ">
                                                <div class="progress-bar bg-danger progress-animated" style="width: 85%; height:6px;" role="progressbar">
                                                    <span class="sr-only">60% Complete</span>
                                                </div>
                                            </div>
                                            <h6 class="mt-4">Code editor
                                                <span class="pull-right">90%</span>
                                            </h6>
                                            <div class="progress">
                                                <div class="progress-bar bg-info progress-animated" style="width: 90%; height:6px;" role="progressbar">
                                                    <span class="sr-only">60% Complete</span>
                                                </div>
                                            </div>
                                            <h6 class="mt-4">Illustrator
                                                <span class="pull-right">65%</span>
                                            </h6>
                                            <div class="progress">
                                                <div class="progress-bar bg-success progress-animated" style="width: 65%; height:6px;" role="progressbar">
                                                    <span class="sr-only">60% Complete</span>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-xl-9 col-xxl-8 col-lg-8">
                            <div class="card">
                                <div class="card-body">
                                    <div class="profile-tab">
                                        <div class="custom-tab-1">
                                            <ul class="nav nav-tabs">
                                                <li class="nav-item"><a href="#about-me" data-toggle="tab" class="nav-link active show">About Me</a></li>
                                                <li class="nav-item"><a href="#my-posts" data-toggle="tab" class="nav-link">Posts</a></li>
                                            </ul>
                                            <div class="tab-content">
                                                <div id="about-me" class="tab-pane fade active show">
                                                    <div class="profile-personal-info pt-4">
                                                        <h4 class="text-primary mb-4">Personal Information</h4>
                                                        <div class="row mb-4">
                                                            <div class="col-lg-3 col-md-4 col-sm-6 col-6">
                                                                <h5 class="f-w-500">Name <span class="pull-right">:</span>
                                                                </h5>
                                                            </div>
                                                            <div class="col-lg-9 col-md-8 col-sm-6 col-6"><span>Mitchell C.Shay</span>
                                                            </div>
                                                        </div>
                                                        <div class="row mb-4">
                                                            <div class="col-lg-3 col-md-4 col-sm-6 col-6">
                                                                <h5 class="f-w-500">Email <span class="pull-right">:</span>
                                                                </h5>
                                                            </div>
                                                            <div class="col-lg-9 col-md-8 col-sm-6 col-6"><span>info@example.com</span>
                                                            </div>
                                                        </div>
                                                        <div class="row mb-4">
                                                            <div class="col-lg-3 col-md-4 col-sm-6 col-6">
                                                                <h5 class="f-w-500">Age <span class="pull-right">:</span>
                                                                </h5>
                                                            </div>
                                                            <div class="col-lg-9 col-md-8 col-sm-6 col-6"><span>18</span>
                                                            </div>
                                                        </div>
                                                        <div class="row mb-4">
                                                            <div class="col-lg-3 col-md-4 col-sm-6 col-6">
                                                                <h5 class="f-w-500">Location <span class="pull-right">:</span></h5>
                                                            </div>
                                                            <div class="col-lg-9 col-md-8 col-sm-6 col-6"><span>Rosemont Avenue Melbourne,
                                                                    Florida</span>
                                                            </div>
                                                        </div>
                                                    </div>

                                                </div>
                                                <div id="my-posts" class="tab-pane fade">
                                                    <div class="my-post-content pt-3">
                                                        <div class="post-input">
                                                            <textarea name="textarea" id="textarea" cols="30" rows="5" class="form-control bg-transparent" placeholder="Please type what you want...."></textarea> <a href="javascript:void()"><i class="ti-clip"></i> </a>
                                                            <a href="javascript:void()"><i class="ti-camera"></i> </a><a href="javascript:void()" class="btn btn-primary">Post</a>
                                                        </div>
                                                        <div class="profile-uoloaded-post border-bottom-1 pb-5">
                                                            <img src="images2/profile/8.jpg" alt="" class="img-fluid">
                                                            <a class="post-title" href="javascript:void()">
                                                                <h4>Collection of textile samples lay spread</h4>
                                                            </a>
                                                            <p>A wonderful serenity has take possession of my entire soul like these sweet morning of spare which enjoy whole heart.A wonderful serenity has take possession of my entire soul like these sweet morning
                                                                of spare which enjoy whole heart.</p>
                                                            <button class="btn btn-primary mr-3"><span class="mr-3"><i class="fa fa-heart"></i></span>Like</button>
                                                            <button class="btn btn-secondary"><span class="mr-3"><i class="fa fa-reply"></i></span>Reply</button>
                                                        </div>
                                                        <div class="profile-uoloaded-post border-bottom-1 pb-5">
                                                            <img src="images2/profile/9.jpg" alt="" class="img-fluid">
                                                            <a class="post-title" href="javascript:void()">
                                                                <h4>Collection of textile samples lay spread</h4>
                                                            </a>
                                                            <p>A wonderful serenity has take possession of my entire soul like these sweet morning of spare which enjoy whole heart.A wonderful serenity has take possession of my entire soul like these sweet morning
                                                                of spare which enjoy whole heart.</p>
                                                            <button class="btn btn-primary mr-3"><span class="mr-3"><i class="fa fa-heart"></i></span>Like</button>
                                                            <button class="btn btn-secondary"><span class="mr-3"><i class="fa fa-reply"></i></span>Reply</button>
                                                        </div>
                                                        <div class="profile-uoloaded-post pb-5">
                                                            <img src="images2/profile/8.jpg" alt="" class="img-fluid">
                                                            <a class="post-title" href="javascript:void()">
                                                                <h4>Collection of textile samples lay spread</h4>
                                                            </a>
                                                            <p>A wonderful serenity has take possession of my entire soul like these sweet morning of spare which enjoy whole heart.A wonderful serenity has take possession of my entire soul like these sweet morning
                                                                of spare which enjoy whole heart.</p>
                                                            <button class="btn btn-primary mr-3"><span class="mr-3"><i class="fa fa-heart"></i></span>Like</button>
                                                            <button class="btn btn-secondary"><span class="mr-3"><i class="fa fa-reply"></i></span>Reply</button>
                                                        </div>
                                                        <div class="text-center mb-2"><a href="javascript:void()" class="btn btn-primary">Load More</a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
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

    </body>
</html>