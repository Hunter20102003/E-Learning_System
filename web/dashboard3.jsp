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

                    <div class="row">

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
                                    <div class="px-4"><span class="bar1" data-peity='{ "fill": ["rgb(0, 0, 128)", "rgb(7, 135, 234)"]}'>6,2,8,4,-3,8,1,-3,6,-5,9,2,-8,1,4,8,9,8,2,1</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-xl-3 col-xxl-3 col-sm-6">
                            <div class="widget-stat card bg-danger overflow-hidden">
                                <div class="card-header pb-3">
                                    <h3 class="card-title text-white">Fees Collection</h3>
                                    <h5 class="text-white mb-0"><i class="fa fa-caret-up"></i> 3280$</h5>
                                </div>
                                <div class="card-body p-0 mt-1">
                                    <span class="peity-line-2" data-width="100%">7,6,8,7,3,8,3,3,6,5,9,2,8</span>
                                </div>
                            </div>
                        </div>
                        <div class="col-xl-6 col-xxl-6 col-sm-6">
                            <div class="card">
                                <div class="card-header">
                                    <h3 class="card-title">Income/Expense Report - Bar Chart</h3>
                                </div>
                                <div class="card-body">
                                    <canvas id="barChart_2"></canvas>
                                    <div class="form-group mt-3">
                                        <label for="maxBar">Max Value:</label>
                                        <input type="number" id="maxBar" class="form-control" value="100">
                                    </div>
                                    <div class="form-group">
                                        <label for="stepSizeBar">Step Size:</label>
                                        <input type="number" id="stepSizeBar" class="form-control" value="20">
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
                                    <div class="form-group mt-3">
                                        <label for="maxArea">Max Value:</label>
                                        <input type="number" id="maxArea" class="form-control" value="100">
                                    </div>
                                    <div class="form-group">
                                        <label for="stepSizeArea">Step Size:</label>
                                        <input type="number" id="stepSizeArea" class="form-control" value="20">
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
                        <p>Copyright Â© Designed &amp; Developed by <a href="../index.htm" target="_blank">DexignLab</a> 2020</p>
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
                        var maxBar = 100; // Giá tr? m?c ??nh c?a max cho Bar Chart
                        var stepSizeBar = 20; // Giá tr? m?c ??nh c?a stepSize cho Bar Chart
                        var maxArea = 100; // Giá tr? m?c ??nh c?a max cho Area Chart
                        var stepSizeArea = 20; // Giá tr? m?c ??nh c?a stepSize cho Area Chart

                        // Hàm ?? l?y d? li?u t? Servlet
                        var fetchData = function (callback) {
                            $.ajax({
                                url: 'dataservlet', // URL t?i Servlet c?a b?n
                                method: 'GET',
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
                                const barChart_2 = document.getElementById("barChart_2").getContext('2d');
                                const barChart_2gradientStroke = barChart_2.createLinearGradient(0, 0, 0, 250);
                                barChart_2gradientStroke.addColorStop(0, "rgba(141, 149, 255, 1)");
                                barChart_2gradientStroke.addColorStop(1, "rgba(102, 115, 253, 1)");

                                barChart_2.height = 100;

                                new Chart(barChart_2, {
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
                                                    ticks: {
                                                        beginAtZero: true,
                                                        max: maxBar, // S? d?ng max t? input
                                                      
                                                        stepSize: stepSizeBar // S? d?ng stepSize t? input
                                                    },
                                                    gridLines: {
                                                        display: true,
                                                        drawBorder: true
                                                    }
                                                }],
                                            xAxes: [{
                                                    gridLines: {
                                                        display: false,
                                                        tickMarkLength: 15
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
                                const areaChart_1 = document.getElementById("areaChart_1").getContext('2d');

                                areaChart_1.height = 100;

                                new Chart(areaChart_1, {
                                    type: 'line',
                                    data: {
                                        defaultFontFamily: 'Poppins',
                                        labels: ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "July", "Aug", "Sep", "Oct", "Nov", "Dec"],
                                        datasets: [{
                                                label: "Expenses",
                                                data: chartData.areaChart,
                                                borderColor: 'rgba(102, 115, 253, 1)',
                                                borderWidth: "3",
                                                backgroundColor: 'rgba(102, 115, 253, .2)',
                                                pointBackgroundColor: 'rgba(102, 115, 253, 1)'
                                            }]
                                    },
                                    options: {
                                        legend: false,
                                        scales: {
                                            yAxes: [{
                                                    ticks: {
                                                        beginAtZero: true,
                                                        max: maxArea, // S? d?ng max t? input
                                                        min: 0,
                                                        stepSize: stepSizeArea // S? d?ng stepSize t? input
                                                    },
                                                    gridLines: {
                                                        display: true,
                                                        drawBorder: true
                                                    }
                                                }],
                                            xAxes: [{
                                                    gridLines: {
                                                        display: false,
                                                        tickMarkLength: 15
                                                    }
                                                }]
                                        }
                                    }
                                });
                            }
                        };

                        // Function ?? c?p nh?t bi?u ?? khi input thay ??i
                        var updateCharts = function () {
                            // L?y giá tr? t? input
                            maxBar = parseInt($('#maxBar').val());
                            stepSizeBar = parseInt($('#stepSizeBar').val());
                            maxArea = parseInt($('#maxArea').val());
                            stepSizeArea = parseInt($('#stepSizeArea').val());

                            // V? l?i bi?u ?? Bar và Area
                            barChart();
                            areaChart();
                        };


                        /* Function ============ */
                        return {
                            init: function () {},
                            load: function () {
                                fetchData(function () {
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
                        dzChartlist.load();
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