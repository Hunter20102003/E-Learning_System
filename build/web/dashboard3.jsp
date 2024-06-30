<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width,initial-scale=1">
        <title>Edumin - Bootstrap Admin Dashboard </title>
        <!-- Favicon icon -->
        <link rel="icon" type="image/png" sizes="16x16" href="images2/favicon.png">
        <link rel="stylesheet" href="vendor/jqvmap/css/jqvmap.min.css">
        <link rel="stylesheet" href="vendor/chartist/css/chartist.min.css">
        <link rel="stylesheet" href="vendor/bootstrap-select/dist/css/bootstrap-select.min.css">
        <link rel="stylesheet" href="css2/style.css">
        <link rel="stylesheet" href="css2/skin-2.css">

    </head>

    <body>
        <style>
            /* Style for form container */
            #yearForm {
                display: flex;
                align-items: center;
                justify-content: center;
                flex-wrap: wrap;
                gap: 10px;
                margin-bottom: 20px;
            }

            /* Style for label */
            #yearForm label {
                font-weight: bold;
                color: #333;
                margin-right: 10px;
            }

            /* Style for input */
            #yearInput {
                padding: 8px;
                font-size: 16px;
                border: 1px solid #ccc;
                border-radius: 4px;
                flex: 1;
                max-width: 150px;
            }

            /* Style for submit button */
            #yearForm button {
                padding: 8px 16px;
                background-color: #007bff;
                color: white;
                border: none;
                border-radius: 4px;
                cursor: pointer;
                transition: background-color 0.3s ease;
            }

            /* Hover effect for submit button */
            #yearForm button:hover {
                background-color: #0056b3;
            }

            /* Focus effect for input */
            #yearInput:focus {
                outline: none;
                border-color: #0056b3;
                box-shadow: 0 0 0 3px rgba(0, 123, 255, 0.25);
            }
        </style>

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

                    <div class="row">
                           <div class="col-xl-12 col-xxl-12 col-sm-1"><form id="yearForm">
                            <label for="yearInput">Enter Year:</label>
                            <input type="text" id="yearInput" name="year" />
                            <button type="submit">Submit</button>
                        </form></div>
                        
                        <div class="col-xl-6 col-xxl-6 col-sm-6">


                            <div class="card">
                                <div class="card-header">
                                    <h3 class="card-title">Income/Expense Report - Bar Chart</h3>
                                </div>
                                <div class="card-body">
                                    <canvas id="barChart_2"></canvas>
                                    <div class="form-group mt-3">
                                        <label for="maxBar">Max Value:</label>
                                        <input type="number" id="maxBar" class="form-control" value="20">
                                    </div>
                                    <div class="form-group">
                                        <label for="stepSizeBar">Step Size:</label>
                                        <input type="number" id="stepSizeBar" class="form-control" value="2">
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="col-xl-6 col-xxl-6 col-sm-6">

                            <div class="card">
                                <div class="card-header">
                                    <h3 class="card-title">Income/Expense Report - Area Chart</h3>
                                </div>
                                <div class="card-body">
                                    <canvas id="areaChart_1"></canvas>

                                </div>
                            </div>
                        </div>

                        <div class="col-xl-3 col-xxl-3 col-sm-6">
                            <div class="widget-stat card bg-primary overflow-hidden">
                                <div class="card-header">
                                    <h3 class="card-title text-white">Total Students</h3>
                                    <h5 class="text-white mb-0"><i class="fa fa-caret-up"></i> 422</h5>
                                </div>
                                <div class="card-body text-center mt-3">
                                    <div class="ico-sparkline">
                                        <div id="sparkline12"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-xl-3 col-xxl-3 col-sm-6">
                            <div class="widget-stat card bg-success overflow-hidden">
                                <div class="card-header">
                                    <h3 class="card-title text-white">New Students</h3>
                                    <h5 class="text-white mb-0"><i class="fa fa-caret-up"></i> 357</h5>
                                </div>
                                <div class="card-body text-center mt-4 p-0">
                                    <div class="ico-sparkline">
                                        <div id="spark-bar-2"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-xl-3 col-xxl-3 col-sm-6">
                            <div class="widget-stat card bg-secondary overflow-hidden">
                                <div class="card-header pb-3">
                                    <h3 class="card-title text-white">Total Course</h3>
                                    <h5 class="text-white mb-0"><i class="fa fa-caret-up"></i> 547</h5>
                                </div>
                                <div class="card-body p-0 mt-2">
                                    <div class="px-4"><span class="bar1" data-peity='{ "fill": ["rgb(0, 0, 128)", "rgb(7, 135, 234)"]}'>6,2,8,4,-3,8,1,-3,6,-5,9,2,-8,1,4,8,9,8,2,10</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-xl-3 col-xxl-3 col-sm-6">
                            <div class="widget-stat card bg-danger overflow-hidden">
                              
                                <div class="card-body p-0 mt-1">
                                    <span class="peity-line-2" data-width="100%">7,6,8,7,3,8,3,3,6,5,9,2,9</span>
                                </div>
                            </div>
                        </div>
                     <div class="col-xl-8 col-xxl-8 col-lg-8 col-md-12 col-sm-12">
                        <div class="card">
                            <div class="card-header">
                                <h5 class="card-title">Assign Task</h5>
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table header-border table-hover verticle-middle">
                                        <thead>
                                            <tr>
                                                <th scope="col">#</th>
                                                <th scope="col">Task</th>
                                                <th scope="col">Assigned Professors</th>
                                                <th scope="col">Status</th>
                                                <th scope="col">Progress</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <th>1</th>
                                                <td>Working Design report</td>
                                                <td>Herman Beck</td>
                                                <td><span class="badge badge-rounded badge-primary">DONE</span></td>
                                                <td>
                            //s? ?ô ??
                                                </td>
                                            </tr>
                                    
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
					<div class="col-xl-4 col-xxl-4 col-lg-4 col-md-12 col-sm-12">
                        <div class="card">
                            <div class="card-header">
                                <h4 class="card-title">Notifications</h4>
                            </div>
                            <div class="card-body"> 
                                <div class="widget-todo dz-scroll" style="height:370px;" id="DZ_W_Notifications">
                                    <ul class="timeline">
                                        <li>
                                            <div class="timeline-badge primary"></div>
                                            <a class="timeline-panel text-muted mb-3 d-flex align-items-center" href="javascript:void(0);">
                                                <img class="rounded-circle" alt="image" width="50" src="images/profile/education/pic1.jpg">
												<div class="col">
													<h5 class="mb-1">Dr sultads Send you Photo</h5>
													<small class="d-block">29 July 2020 - 02:26 PM</small>
												</div>
											</a>
                                        </li>
                                        <li>
                                            <div class="timeline-badge warning"></div>
                                            <a class="timeline-panel text-muted mb-3 d-flex align-items-center" href="javascript:void(0);">
                                                <img class="rounded-circle" alt="image" width="50" src="images/profile/education/pic2.jpg">
												<div class="col">
													<h5 class="mb-1">Resport created successfully</h5>
													<small class="d-block">29 July 2020 - 02:26 PM</small>
												</div>
											</a>
                                        </li>
                                        <li>
                                            <div class="timeline-badge danger"></div>
                                            <a class="timeline-panel text-muted mb-3 d-flex align-items-center" href="javascript:void(0);">
                                                <img class="rounded-circle" alt="image" width="50" src="images/profile/education/pic3.jpg">
												<div class="col">
													<h5 class="mb-1">Reminder : Treatment Time!</h5>
													<small class="d-block">29 July 2020 - 02:26 PM</small>
												</div>
											</a>
                                        </li>
										<li>
                                            <div class="timeline-badge success"></div>
											<a class="timeline-panel text-muted mb-3 d-flex align-items-center" href="javascript:void(0);">
                                                <img class="rounded-circle" alt="image" width="50" src="images/profile/education/pic4.jpg">
												<div class="col">
													<h5 class="mb-1">Dr sultads Send you Photo</h5>
													<small class="d-block">29 July 2020 - 02:26 PM</small>
												</div>
											</a>
                                        </li>
                                        <li>
                                            <div class="timeline-badge warning"></div>
											<a class="timeline-panel text-muted mb-3 d-flex align-items-center" href="javascript:void(0);">
                                                <img class="rounded-circle" alt="image" width="50" src="images/profile/education/pic5.jpg">
												<div class="col">
													<h5 class="mb-1">Resport created successfully</h5>
													<small class="d-block">29 July 2020 - 02:26 PM</small>
												</div>
											</a>
                                        </li>
                                        <li>
                                            <div class="timeline-badge dark"></div>
                                            <a class="timeline-panel text-muted mb-3 d-flex align-items-center" href="javascript:void(0);">
                                                <img class="rounded-circle" alt="image" width="50" src="images/profile/education/pic6.jpg">
												<div class="col">
													<h5 class="mb-1">Reminder : Treatment Time!</h5>
													<small class="d-block">29 July 2020 - 02:26 PM</small>
												</div>
											</a>
                                        </li>
                                        <li>
                                            <div class="timeline-badge info"></div>
                                            <a class="timeline-panel text-muted mb-3 d-flex align-items-center" href="javascript:void(0);">
                                                <img class="rounded-circle" alt="image" width="50" src="images/profile/education/pic7.jpg">
												<div class="col">
													<h5 class="mb-1">Dr sultads Send you Photo</h5>
													<small class="d-block">29 July 2020 - 02:26 PM</small>
												</div>
											</a>
                                        </li>
										<li>
                                            <div class="timeline-badge danger"></div>
                                            <a class="timeline-panel text-muted mb-3 d-flex align-items-center" href="javascript:void(0);">
                                                <img class="rounded-circle" alt="image" width="50" src="images/profile/education/pic8.jpg">
												<div class="col">
													<h5 class="mb-1">Resport created successfully</h5>
													<small class="d-block">29 July 2020 - 02:26 PM</small>
												</div>
											</a>
                                        </li>
                                        <li>
                                            <div class="timeline-badge success"></div>
                                            <a class="timeline-panel text-muted mb-3 d-flex align-items-center" href="javascript:void(0);">
                                                <img class="rounded-circle" alt="image" width="50" src="images/profile/education/pic9.jpg">
												<div class="col">
													<h5 class="mb-1">Reminder : Treatment Time!</h5>
													<small class="d-block">29 July 2020 - 02:26 PM</small>
												</div>
											</a>
                                        </li>
										<li>
                                            <div class="timeline-badge warning"></div>
											<a class="timeline-panel text-muted d-flex align-items-center" href="javascript:void(0);">
                                                <img class="rounded-circle" alt="image" width="50" src="images/profile/education/pic10.jpg">
												<div class="col">
													<h5 class="mb-1">Dr sultads Send you Photo</h5>
													<small class="d-block">29 July 2020 - 02:26 PM</small>
												</div>
											</a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
						</div>
					</div>
					<div class="col-lg-12">
                        <div class="card">
							<div class="card-header">
                                <h4 class="card-title">New Student List </h4>
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-sm mb-0 table-striped">
                                        <thead>
                                            <tr>
												<th class="px-5 py-3">Name</th>
                                                <th class="py-3">Assigned Professor</th>
                                                <th class="py-3">Branch</th>
                                                <th class="py-3">Status</th>
                                                <th class="py-3">Date Of Admit</th>
                                                <th class="py-3">Edit</th>
                                            </tr>
                                        </thead>
                                        <tbody id="customers">
                                            <tr class="btn-reveal-trigger">
                                                <td class="p-3">
                                                    <a href="javascript:void(0);">
                                                        <div class="media d-flex align-items-center">
                                                            <div class="avatar avatar-xl mr-2">
                                                                <img class="rounded-circle img-fluid" src="images/avatar/5.png" width="30" alt="">
                                                            </div>
                                                            <div class="media-body">
                                                                <h5 class="mb-0 fs--1">Ricky Antony</h5>
                                                            </div>
                                                        </div>
                                                    </a>
                                                </td>
                                                <td class="py-2">Herman Beck</td>
                                                <td class="py-2">Mechanical</td>
                                                <td><span class="badge badge-rounded badge-primary">DONE</span></td>
                                                <td class="py-2">30/03/2018</td>
                                                <td>
                                                    <a href="edit-student.html" class="btn btn-sm btn-primary"><i class="la la-pencil"></i></a>
                                                    <a href="javascript:void(0);" class="btn btn-sm btn-danger"><i class="la la-trash-o"></i></a>
                                                </td>
                                            </tr>
                                            <tr class="btn-reveal-trigger">
                                                <td class="p-3">
                                                    <a href="javascript:void(0);">
                                                        <div class="media d-flex align-items-center">
                                                            <div class="avatar avatar-xl mr-2">
                                                                <img class="rounded-circle img-fluid" src="images/avatar/1.png" alt="" width="30">
                                                            </div>
                                                            <div class="media-body">
                                                                <h5 class="mb-0 fs--1">Emma Watson</h5>
                                                            </div>
                                                        </div>
                                                    </a>
                                                </td>
                                                <td class="py-2">Emma Watson</td>
                                                <td class="py-2">Computer</td>
                                                <td><span class="badge badge-rounded badge-warning">Panding</span></td>
                                                <td class="py-2">11/07/2017</td>
                                                <td>
                                                    <a href="edit-student.html" class="btn btn-sm btn-primary"><i class="la la-pencil"></i></a>
                                                    <a href="javascript:void(0);" class="btn btn-sm btn-danger"><i class="la la-trash-o"></i></a>
                                                </td>
                                            </tr>
                                            <tr class="btn-reveal-trigger">
                                                <td class="p-3">
                                                    <a href="javascript:void(0);">
                                                        <div class="media d-flex align-items-center">
                                                            <div class="avatar avatar-xl mr-2">
                                                                <img class="rounded-circle img-fluid" src="images/avatar/5.png" width="30" alt="">
                                                            </div>
                                                            <div class="media-body">
                                                                <h5 class="mb-0 fs--1">Rowen Atkinson</h5>
                                                            </div>
                                                        </div>
                                                    </a>
                                                </td>
                                                <td class="py-2">Mary Adams</td>
                                                <td class="py-2">Mechanical</td>
                                                <td><span class="badge badge-rounded badge-primary">DONE</span></td>
                                                <td class="py-2">05/04/2016</td>
                                                <td>
                                                    <a href="edit-student.html" class="btn btn-sm btn-primary"><i class="la la-pencil"></i></a>
                                                    <a href="javascript:void(0);" class="btn btn-sm btn-danger"><i class="la la-trash-o"></i></a>
                                                </td>
                                            </tr>
                                            <tr class="btn-reveal-trigger">
                                                <td class="p-3">
                                                    <a href="javascript:void(0);">
                                                        <div class="media d-flex align-items-center">
                                                            <div class="avatar avatar-xl mr-2">
                                                                <img class="rounded-circle img-fluid" src="images/avatar/1.png" alt="" width="30">
                                                            </div>
                                                            <div class="media-body">
                                                                <h5 class="mb-0 fs--1">Antony Hopkins</h5>
                                                            </div>
                                                        </div>
                                                    </a>
                                                </td>
                                                <td class="py-2">Caleb Richards </td>
                                                <td class="py-2">Computer </td>
                                                <td><span class="badge badge-rounded badge-danger">Suspended</span></td>
                                                <td class="py-2">05/04/2018</td>
                                                <td>
                                                    <a href="edit-student.html" class="btn btn-sm btn-primary"><i class="la la-pencil"></i></a>
                                                    <a href="javascript:void(0);" class="btn btn-sm btn-danger"><i class="la la-trash-o"></i></a>
                                                </td>
                                            </tr>
                                            <tr class="btn-reveal-trigger">
                                                <td class="p-3">
                                                    <a href="javascript:void(0);">
                                                        <div class="media d-flex align-items-center">
                                                            <div class="avatar avatar-xl mr-2">
                                                                <img class="rounded-circle img-fluid" src="images/avatar/1.png" alt="" width="30">
                                                            </div>
                                                            <div class="media-body">
                                                                <h5 class="mb-0 fs--1">Jennifer Schramm</h5>
                                                            </div>
                                                        </div>
                                                    </a>
                                                </td>
                                                <td class="py-2">June Lane</td>
                                                <td class="py-2">Fees Collection</td>
                                                <td><span class="badge badge-rounded badge-warning">Panding</span></td>
                                                <td class="py-2">17/03/2016</td>
                                                <td>
                                                    <a href="edit-student.html" class="btn btn-sm btn-primary"><i class="la la-pencil"></i></a>
                                                    <a href="javascript:void(0);" class="btn btn-sm btn-danger"><i class="la la-trash-o"></i></a>
                                                </td>
                                            </tr>
                                            <tr class="btn-reveal-trigger">
                                                <td class="p-3">
                                                    <a href="javascript:void(0);">
                                                        <div class="media d-flex align-items-center">
                                                            <div class="avatar avatar-xl mr-2">
                                                                <img class="rounded-circle img-fluid" src="images/avatar/5.png" width="30" alt="">
                                                            </div>
                                                            <div class="media-body">
                                                                <h5 class="mb-0 fs--1">Raymond Mims</h5>
                                                            </div>
                                                        </div>
                                                    </a>
                                                </td>
                                                <td class="py-2">Herman Beck</td>
                                                <td class="py-2">Computer</td>
                                                <td><span class="badge badge-rounded badge-danger">Suspended</span></td>
                                                <td class="py-2">12/07/2014</td>
                                                <td>
                                                    <a href="edit-student.html" class="btn btn-sm btn-primary"><i class="la la-pencil"></i></a>
                                                    <a href="javascript:void(0);" class="btn btn-sm btn-danger"><i class="la la-trash-o"></i></a>
                                                </td>
                                            </tr>
                                            <tr class="btn-reveal-trigger">
                                                <td class="p-3">
                                                    <a href="javascript:void(0);">
                                                        <div class="media d-flex align-items-center">
                                                            <div class="avatar avatar-xl mr-2">
                                                                <img class="rounded-circle img-fluid" src="images/avatar/1.png" alt="" width="30">
                                                            </div>
                                                            <div class="media-body">
                                                                <h5 class="mb-0 fs--1">Michael Jenkins</h5>
                                                            </div>
                                                        </div>
                                                    </a>
                                                </td>
                                                <td class="py-2">Jennifer Schramm</td>
                                                <td class="py-2">Mechanical</td>
                                                <td><span class="badge badge-rounded badge-warning">Panding</span></td>
                                                <td class="py-2">15/06/2014</td>
                                                <td>
                                                    <a href="edit-student.html" class="btn btn-sm btn-primary"><i class="la la-pencil"></i></a>
                                                    <a href="javascript:void(0);" class="btn btn-sm btn-danger"><i class="la la-trash-o"></i></a>
                                                </td>
                                            </tr>
                                        </tbody>
                                    </table>
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
             <script src="js2/plugins-init/summernote-init.js"></script>


            <!-- Chart ChartJS plugin files -->
            <script src="vendor/chart.js/Chart.bundle.min.js"></script>

            <!-- Chart piety plugin files -->
            <script src="vendor/peity/jquery.peity.min.js"></script>

            <!-- Chart sparkline plugin files -->
            <script src="vendor/jquery-sparkline/jquery.sparkline.min.js"></script>

            <!-- Demo scripts -->


            <!-- Svganimation scripts -->
            <script src="vendor/svganimation/vivus.min.js"></script>
            <script src="vendor/svganimation/svg.animation.js"></script>
            <script src="js2/styleSwitcher.js"></script>
            <script>
                // Function to handle data fetching and chart rendering
                (function ($) {
                    "use strict";

                    var dzChartlist = function () {
                        var chartData = {}; // Bi?n ?? l?u tr? d? li?u t? Servlet
                        var maxBar = 20; // Giá tr? m?c ??nh c?a max cho Bar Chart
                        var stepSizeBar = 2; // Giá tr? m?c ??nh c?a stepSize cho Bar Chart
                        var maxArea = 20; // Giá tr? m?c ??nh c?a max cho Area Chart
                        var stepSizeArea = 2; // Giá tr? m?c ??nh c?a stepSize cho Area Chart

                        // Hàm ?? l?y d? li?u t? Servlet
                        var fetchData = function (year, callback) {
                            $.ajax({
                                url: 'dashboard', // URL t?i Servlet c?a b?n
                                method: 'GET',
                                data: {year: year},
                                dataType: 'json',
                                success: function (data) {
                                    chartData = data; // L?u d? li?u ?ã l?y ???c
                                    callback(); // G?i l?i ?? v? bi?u ??
                                },
                                error: function (err) {
                                    console.error('L?i khi l?y d? li?u', err);
                                }
                            });
                        };

                        // Bi?n screenWidth dùng ?? l?y ?? r?ng c?a c?a s?
                        var screenWidth = $(window).width();

                        // Hàm sparkBar2 ?? v? bi?u ?? sparkline
                        var sparkBar2 = function () {
                            if ($('#spark-bar-2').length > 0 && chartData.sparkBarData) {
                                $("#spark-bar-2").sparkline(chartData.sparkBarData, {
                                    type: "bar",
                                    height: "140",
                                    width: 100,
                                    barWidth: 10,
                                    barSpacing: 10,
                                    barColor: "rgb(200, 255, 135)"
                                });
                            }
                        };

                        var sparkLineChart = function () {
                            if ($('#sparkline12').length > 0 && chartData.sparkLineChart) {
                                $("#sparkline12").sparkline(chartData.sparkLineChart, {
                                    type: "pie",
                                    height: "100",
                                    resize: true,
                                    sliceColors: ["#8d95ff", "#fac2c2", "rgba(255, 0, 0, 0.8)"]
                                });

                                $(".bar1").peity("bar", {
                                    fill: ["rgb(216, 196, 255)", "rgb(216, 196, 255)", "rgb(216, 196, 255)"],
                                    width: "100%",
                                    height: "140"
                                });

                                $(".peity-line-2").peity("line", {
                                    fill: "#ff3232",
                                    stroke: "#fac2c2",
                                    width: "100%",
                                    strokeWidth: "3",
                                    height: "150"
                                });
                            }
                        };


                        // Hàm ?? v? bi?u ?? Bar
                        var barChart = function () {
                            if ($('#barChart_2').length > 0 && chartData.barChart) {
                                // Destroy existing chart instance if it exists
                                if (window.barChartInstance) {
                                    window.barChartInstance.destroy();
                                }

                                const barChart_2 = document.getElementById("barChart_2").getContext('2d');
                                const barChart_2gradientStroke = barChart_2.createLinearGradient(0, 0, 0, 250);
                                barChart_2gradientStroke.addColorStop(0, "#fac2c2");
                                barChart_2gradientStroke.addColorStop(1, "#FF4A00");

                                barChart_2.height = 100;

                                window.barChartInstance = new Chart(barChart_2, {
                                    type: 'bar',
                                    data: {
                                        defaultFontFamily: 'Poppins',
                                        labels: ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "July", "Aug", "Sep", "Oct", "Nov", "Dec"],
                                        datasets: [{
                                                label: "Income",
                                                data: chartData.barChart,
                                                borderColor: barChart_2gradientStroke,
                                                borderWidth: "0",
                                                backgroundColor: barChart_2gradientStroke,
                                                hoverBackgroundColor: barChart_2gradientStroke
                                            }]
                                    },
                                    options: {
                                        legend: false,
                                        scales: {
                                            yAxes: [{
                                                    gridLines: {
                                                        display: true, // Ensure grid lines are displayed
                                                        drawBorder: true // Ensure border is drawn
                                                    },
                                                    ticks: {
                                                        beginAtZero: true, // Start y-axis at zero
                                                        max: maxBar, // Max value for y-axis
                                                        stepSize: stepSizeBar // Step size for y-axis
                                                    }
                                                }],
                                            xAxes: [{
                                                    gridLines: {
                                                        display: true, // Ensure grid lines are displayed
                                                        tickMarkLength: 15 // Length of the tick marks on the x-axis
                                                    }
                                                }]
                                        }

                                    }
                                });
                            }
                        };

                        // Hàm ?? v? bi?u ?? Area
                        var areaChart = function () {
                            if ($('#areaChart_1').length > 0 && chartData.areaChart) {
                                // Destroy existing chart instance if it exists
                                if (window.areaChartInstance) {
                                    window.areaChartInstance.destroy();
                                }

                                const areaChart_1 = document.getElementById("areaChart_1").getContext('2d');
                                areaChart_1.height = 100;

                                window.areaChartInstance = new Chart(areaChart_1, {
                                    type: 'line',
                                    data: {
                                        defaultFontFamily: 'Poppins',
                                        labels: ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "July", "Aug", "Sep", "Oct", "Nov", "Dec"],
                                        datasets: [{
                                                label: "Expenses",
                                                data: chartData.areaChart,
                                                borderColor: "#FF4A00",
                                                borderWidth: "3",
                                                backgroundColor: "#fac2c2",
                                                pointBackgroundColor: "#FF4A00"
                                            }]
                                    },
                                    options: {
                                        legend: false,
                                        scales: {
                                            yAxes: [{
                                                    gridLines: {
                                                        display: true, // Ensure grid lines are displayed
                                                        drawBorder: true // Ensure border is drawn
                                                    },
                                                    ticks: {
                                                        beginAtZero: true, // Start y-axis at zero
                                                        max: maxBar, // Max value for y-axis
                                                        stepSize: stepSizeBar // Step size for y-axis
                                                    }
                                                }],
                                            xAxes: [{
                                                    gridLines: {
                                                        display: true, // Ensure grid lines are displayed
                                                        tickMarkLength: 15 // Length of the tick marks on the x-axis
                                                    }
                                                }]
                                        }

                                    }
                                });
                            }
                        };

                        // Function ?? c?p nh?t bi?u ?? khi input thay ??i
                        var updateCharts = function () {
                            // L?y giá tr? t? input và c?p nh?t l?i các bi?n
                            maxBar = parseInt($('#maxBar').val());
                            stepSizeBar = parseInt($('#stepSizeBar').val());
                            maxArea = parseInt($('#maxArea').val());
                            stepSizeArea = parseInt($('#stepSizeArea').val());

                            // G?i l?i hàm v? bi?u ?? Bar và Area
                            barChart();
                            areaChart();
                        };


                        /* Function ============ */
                        return {
                            init: function () {},
                            load: function (year) {
                                fetchData(year, function () {
                                    sparkBar2();
                                    sparkLineChart();
                                    barChart();
                                    areaChart();
                                });
                            },
                            resize: function () {
                                sparkBar2();
                                sparkLineChart();
                                barChart();
                                areaChart();
                            },
                            updateCharts: updateCharts // Thêm hàm updateCharts vào ?ây ?? có th? g?i t? bên ngoài
                        };
                    }();
                    // Initialize the module when document is ready
                    $(document).ready(function () {
                        dzChartlist.load(new Date().getFullYear()); // Load bi?u ?? v?i n?m hi?n t?i

                        $('#yearForm').submit(function (e) {
                            e.preventDefault();
                            var year = $('#yearInput').val();
                            dzChartlist.load(year); // G?i hàm load v?i n?m nh?p vào
                        });
                    });

                    // Handle window resize event
                    $(window).on('resize', function () {
                        dzChartlist.resize();
                    });

                    $(document).on('change', '#maxBar, #stepSizeBar, #maxArea, #stepSizeArea', function () {
                        dzChartlist.updateCharts();
                    });

                })(jQuery);

            </script>
    </body>
</html>