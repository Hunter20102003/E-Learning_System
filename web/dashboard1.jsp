<!DOCTYPE html>
<html lang="en">

<<<<<<< HEAD
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
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> origin/create-course1
=======
>>>>>>> origin/crud_quiz
            #totalIncome {
                font-size: 24px; /* ?i?u ch?nh kích th??c phù h?p */
                color: royalblue;
                text-align: center; /* C?n gi?a n?i dung */
                display: block; /* ?? tránh c?n ch?nh không c?n thi?t */
                margin: 20px auto; /* ?? c?n gi?a theo chi?u ngang và ?? kho?ng cách v?i các ph?n khác */
            }
            .chart-legend {
                display: flex;
                justify-content: center;
                flex-wrap: wrap;
            }

            .legend-item {
                margin: 0 10px;
                display: flex;
                align-items: center;
            }

            .legend-color {
                width: 15px;
                height: 15px;
                display: inline-block;
                margin-right: 5px;
                border-radius: 50%;
            }

<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> origin/AdminManager
=======
>>>>>>> origin/create-course1
=======
>>>>>>> origin/crud_quiz
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
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> origin/create-course1
=======
>>>>>>> origin/crud_quiz
                <!--**********************************
                    Sidebar end
                ***********************************-->

                <!--**********************************
                    Content body start
                ***********************************-->
                <div class="content-body">
                    <!-- row -->
                    <div class="container-fluid">
                        <strong id="totalIncome">TOTAL All INCOME ${total}VND  WITH NUMBER PAYMENTS IS : ${size}</strong>
                    <div class="row">
                        <div class="col-xl-6 col-xxl-6 col-sm-6">
                            <div class="widget-stat card bg-primary overflow-hidden">
                                <div class="card-header">
                                    <h3 class="card-title text-white">Total ACOUNTS</h3>
                                    <h5 class="text-white mb-0"><i class="fa fa-caret-up"></i> ${number_all}</h5>
<<<<<<< HEAD
<<<<<<< HEAD
=======
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
                         <div class="col-xl-12 col-xxl-12 col-lg-6 col-md-12 col-sm-12">
                                <form  action="income_dashboard" method="post" id="yearForm">
                                    <label for="yearInput">Enter Year:</label>
                                    <input type="text" id="yearInput" name="year" />
                                    <button type="submit">Submit</button>
                                </form>
                            </div>


                            <div class="col-xl-6 col-xxl-6 col-sm-6">


                                <div class="card">
                                    <div class="card-header">
                                        <h3 class="card-title" style="color: royalblue">Income/Expense Report - Bar Chart X1000VND</h3>
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
                                        <h3 class="card-title" style="color: royalblue">Income/Expense Report - Area Chart X1000VND</h3>
                                    </div>
                                    <div class="card-body">
                                        <canvas id="areaChart_1"></canvas>
                                        <br>
                                        <br>
                                       <strong style="color: royalblue" id="totalIncome">TOTAL INCOME IN YEAR : VND</strong>


                                </div>
                            </div>
                        </div>
                       

                        <div class="col-xl-3 col-xxl-3 col-sm-6">
                            <div class="widget-stat card bg-primary overflow-hidden">
                                <div class="card-header">
                                    <h3 class="card-title text-white">Total Students</h3>
                                    <h5 class="text-white mb-0"><i class="fa fa-caret-up"></i> 422</h5>
>>>>>>> origin/AdminManager
=======
>>>>>>> origin/create-course1
=======
>>>>>>> origin/crud_quiz
                                </div>
                                <div class="card-body text-center mt-3">
                                    <div class="ico-sparkline">
                                        <div id="sparkline12"></div>
                                    </div>
                                </div>
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> origin/create-course1
=======
>>>>>>> origin/crud_quiz
                                <div class="chart-legend text-white mt-3">
                                    <span class="legend-item"><span class="legend-color" style="background-color: #8d95ff;"></span> Mentee</span>
                                    <span class="legend-item"><span class="legend-color" style="background-color: #fac2c2;"></span> Mentor</span>
                                    <span class="legend-item"><span class="legend-color" style="background-color: rgba(255, 0, 0, 0.8);"></span> Admin</span>
                                    <span class="legend-item"><span class="legend-color" style="background-color: #00FF00;"></span> Manager</span>
=======
<head>
	
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <title>Edumin - Bootstrap Admin Dashboard </title>
    <!-- Favicon icon -->
    <link rel="icon" type="image/png" sizes="16x16" href="images2/favicon.png">
    <link rel="stylesheet" href="vendor/jqvmap/css/jqvmap.min.css">
	<link rel="stylesheet" href="vendor/chartist/css/chartist.min.css">
	<!-- Summernote -->
    <link href="vendor/summernote/summernote.css" rel="stylesheet">
	<link rel="stylesheet" href="vendor/bootstrap-select/dist/css/bootstrap-select.min.css">
    <link rel="stylesheet" href="css2/style.css">
    <link rel="stylesheet" href="css2/skin-3.css">

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
                <img class="logo-abbr" src="images2/logo-white-3.png" alt="">
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
                                    <i class="fa-solid fa-magnifying-glass"></i>
                                </span>
                                <div class="dropdown-menu p-0 m-0">
                                    <form>
                                        <input class="form-control" type="search" placeholder="Search" aria-label="Search">
                                    </form>
>>>>>>> origin/payment
                                </div>
                            </div>
                        </div>

<<<<<<< HEAD
                        <div class="col-xl-6 col-xxl-6 col-sm-6">
<<<<<<< HEAD
<<<<<<< HEAD
=======
                            </div>
                        </div>
                      
                          <div class="col-xl-3 col-xxl-3 col-sm-6">
>>>>>>> origin/AdminManager
=======
>>>>>>> origin/create-course1
=======
>>>>>>> origin/crud_quiz
                            <div class="widget-stat card bg-primary">
                                <div class="card-body">
                                    <div class="media">
                                        <span class="mr-3">
                                            <i class="la la-users"></i>
                                        </span>
                                        <div class="media-body text-white">
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> origin/create-course1
=======
>>>>>>> origin/crud_quiz
                                            <p class="mb-1" style="font-size: 24px; font-weight: bold;">Total ACOUNTS NOW</p>
                                            <h3 class="text-white" style="font-size: 36px; font-weight: bold;">${number_all}</h3>
                                            <div class="progress mb-2 bg-white">
                                                <div class="progress-bar progress-animated bg-light" style="width: ${persen}%"></div>
                                            </div>
                                            <small style="font-size: 14px;">${persen}% Increase in 10 Days</small>
<<<<<<< HEAD
<<<<<<< HEAD
=======
                                            <p class="mb-1">Total Students</p>
                                            <h3 class="text-white">3280</h3>
                                            <div class="progress mb-2 bg-white">
                                                <div class="progress-bar progress-animated bg-light" style="width: 80%"></div>
                                            </div>
                                            <small>80% Increase in 20 Days</small>
>>>>>>> origin/AdminManager
=======
>>>>>>> origin/create-course1
=======
>>>>>>> origin/crud_quiz
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> origin/create-course1
=======
>>>>>>> origin/crud_quiz



                        <div class="col-xl-12 col-xxl-12 col-lg-6 col-md-12 col-sm-12">
                            <form  action="income_dashboard" method="post" id="yearForm">
                                <label for="yearInput">Enter Year:</label>
                                <input type="text" id="yearInput" name="year" />
                                <button type="submit">Submit</button>
                            </form>
                        </div>


                        <div class="col-xl-6 col-xxl-6 col-sm-6">


                            <div class="card">
                                <div class="card-header">
                                    <h3 class="card-title" style="color: royalblue">Income/Expense Report - Bar Chart X1000VND</h3>
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
<<<<<<< HEAD
<<<<<<< HEAD
=======
                        <div class="col-xl-3 col-xxl-3 col-sm-6">
                            <div class="widget-stat card bg-warning">
                                <div class="card-body">
                                    <div class="media">
                                        <span class="mr-3">
                                            <i class="la la-user"></i>
                                        </span>
                                        <div class="media-body text-white">
                                            <p class="mb-1">New Students</p>
                                            <h3 class="text-white">245</h3>
                                            <div class="progress mb-2 bg-white">
                                                <div class="progress-bar progress-animated bg-light" style="width: 50%"></div>
                                            </div>
                                            <small>50% Increase in 25 Days</small>
                                        </div>
>>>>>>> origin/AdminManager
=======
>>>>>>> origin/create-course1
=======
>>>>>>> origin/crud_quiz
                                    </div>
                                </div>
                            </div>
                        </div>
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> origin/create-course1
=======
>>>>>>> origin/crud_quiz

                        <div class="col-xl-6 col-xxl-6 col-sm-6">

                            <div class="card">
                                <div class="card-header">
                                    <h3 class="card-title" style="color: royalblue">Income/Expense Report - Area Chart X1000VND</h3>
                                </div>
                                <div class="card-body">
                                    <canvas id="areaChart_1"></canvas>
                                    <br>
                                    <br>
                                    <strong style="color: royalblue" id="totalIncome"></strong>


                                </div>
                            </div>
                        </div>








<<<<<<< HEAD
<<<<<<< HEAD
=======
                        <div class="col-xl-3 col-xxl-3 col-sm-6">
                            <div class="widget-stat card bg-secondary">
                                <div class="card-body">
                                    <div class="media">
                                        <span class="mr-3">
                                            <i class="la la-graduation-cap"></i>
                                        </span>
                                        <div class="media-body text-white">
                                            <p class="mb-1">Total Course</p>
                                            <h3 class="text-white">28</h3>
                                            <div class="progress mb-2 bg-white">
                                                <div class="progress-bar progress-animated bg-light" style="width: 76%"></div>
                                            </div>
                                            <small>76% Increase in 20 Days</small>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    
                     
                        
                        
                  
>>>>>>> origin/AdminManager
=======
>>>>>>> origin/create-course1
=======
>>>>>>> origin/crud_quiz


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

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> origin/create-course1
=======
>>>>>>> origin/crud_quiz



            <script src="js2/plugins-init/widgets-script-init.js"></script>




<<<<<<< HEAD
<<<<<<< HEAD
=======
    

       
        <script src="js2/plugins-init/widgets-script-init.js"></script>

       
        
        
>>>>>>> origin/AdminManager
=======
>>>>>>> origin/create-course1
=======
>>>>>>> origin/crud_quiz

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
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
                                    sliceColors: ["#8d95ff", "#fac2c2", "rgba(255, 0, 0, 0.8)", "#00FF00"]
=======
                                    sliceColors: ["#8d95ff", "#fac2c2", "rgba(255, 0, 0, 0.8)"]
>>>>>>> origin/AdminManager
=======
                                    sliceColors: ["#8d95ff", "#fac2c2", "rgba(255, 0, 0, 0.8)", "#00FF00"]
>>>>>>> origin/create-course1
=======
                                    sliceColors: ["#8d95ff", "#fac2c2", "rgba(255, 0, 0, 0.8)", "#00FF00"]
>>>>>>> origin/crud_quiz
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
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD

    </body>

=======
         
    </body>
    
>>>>>>> origin/AdminManager
=======

    </body>

>>>>>>> origin/create-course1
=======

    </body>

>>>>>>> origin/crud_quiz
=======
                        <ul class="navbar-nav header-right">
                            <li class="nav-item dropdown notification_dropdown">
                                <a class="nav-link bell ai-icon" href="#" role="button" data-toggle="dropdown">
                                    <svg id="icon-user" xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewbox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-bell">
										<path d="M18 8A6 6 0 0 0 6 8c0 7-3 9-3 9h18s-3-2-3-9"></path>
										<path d="M13.73 21a2 2 0 0 1-3.46 0"></path>
									</svg>
                                    <div class="pulse-css"></div>
                                </a>
                                <div class="dropdown-menu dropdown-menu-right">
                                    <ul class="list-unstyled">
                                        <li class="media dropdown-item">
                                            <span class="success"><i class="ti-user"></i></span>
                                            <div class="media-body">
                                                <a href="#">
                                                    <p><strong>Martin</strong> has added a <strong>customer</strong> Successfully
                                                    </p>
                                                </a>
                                            </div>
                                            <span class="notify-time">3:20 am</span>
                                        </li>
                                        <li class="media dropdown-item">
                                            <span class="primary"><i class="ti-shopping-cart"></i></span>
                                            <div class="media-body">
                                                <a href="#">
                                                    <p><strong>Jennifer</strong> purchased Light Dashboard 2.0.</p>
                                                </a>
                                            </div>
                                            <span class="notify-time">3:20 am</span>
                                        </li>
                                        <li class="media dropdown-item">
                                            <span class="danger"><i class="ti-bookmark"></i></span>
                                            <div class="media-body">
                                                <a href="#">
                                                    <p><strong>Robin</strong> marked a <strong>ticket</strong> as unsolved.
                                                    </p>
                                                </a>
                                            </div>
                                            <span class="notify-time">3:20 am</span>
                                        </li>
                                        <li class="media dropdown-item">
                                            <span class="primary"><i class="ti-heart"></i></span>
                                            <div class="media-body">
                                                <a href="#">
                                                    <p><strong>David</strong> purchased Light Dashboard 1.0.</p>
                                                </a>
                                            </div>
                                            <span class="notify-time">3:20 am</span>
                                        </li>
                                        <li class="media dropdown-item">
                                            <span class="success"><i class="ti-image"></i></span>
                                            <div class="media-body">
                                                <a href="#">
                                                    <p><strong> James.</strong> has added a<strong>customer</strong> Successfully
                                                    </p>
                                                </a>
                                            </div>
                                            <span class="notify-time">3:20 am</span>
                                        </li>
                                    </ul>
                                    <a class="all-notification" href="#">See all notifications <i class="ti-arrow-right"></i></a>
                                </div>
                            </li>
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
                            <li><a href="index.html">Dashboard 1</a></li>
                            <li><a href="index-2.html">Dashboard 2</a></li>
                            <li><a href="index-3.html">Dashboard 3</a></li>
                        </ul>
                    </li>
					<li><a class="ai-icon" href="event-management.html" aria-expanded="false">
							<i class="la la-calendar"></i>
							<span class="nav-text">Event Management</span>
						</a>
                    </li>
					<li><a class="has-arrow" href="javascript:void()" aria-expanded="false">
							<i class="la la-user"></i>
							<span class="nav-text">Professors</span>
						</a>
                        <ul aria-expanded="false">
                            <li><a href="all-professors.html">All Professor</a></li>
                            <li><a href="add-professor.html">Add Professor</a></li>
                            <li><a href="edit-professor.html">Edit Professor</a></li>
                            <li><a href="professor-profile.html">Professor Profile</a></li>
                        </ul>
                    </li>
					<li><a class="has-arrow" href="javascript:void()" aria-expanded="false">
							<i class="la la-users"></i>
							<span class="nav-text">Students</span>
						</a>
                        <ul aria-expanded="false">
                            <li><a href="all-students.html">All Students</a></li>
                            <li><a href="add-student.html">Add Students</a></li>
                            <li><a href="edit-student.html">Edit Students</a></li>
                            <li><a href="about-student.html">About Students</a></li>
                        </ul>
                    </li>
					<li><a class="has-arrow" href="javascript:void()" aria-expanded="false">
							<i class="la la-graduation-cap"></i>
							<span class="nav-text">Courses</span>
						</a>
                        <ul aria-expanded="false">
                            <li><a href="all-courses.html">All Courses</a></li>
                            <li><a href="add-courses.html">Add Courses</a></li>
                            <li><a href="edit-courses.html">Edit Courses</a></li>
                            <li><a href="about-courses.html">About Courses</a></li>
                        </ul>
                    </li>
					<li><a class="has-arrow" href="javascript:void()" aria-expanded="false">
							<i class="la la-book"></i>
							<span class="nav-text">Library</span>
						</a>
                        <ul aria-expanded="false">
                            <li><a href="all-library.html">All Library</a></li>
                            <li><a href="add-library.html">Add Library</a></li>
                            <li><a href="edit-library.html">Edit Library</a></li>
                        </ul>
                    </li>
					<li><a class="has-arrow" href="javascript:void()" aria-expanded="false">
							<i class="la la-building"></i>
							<span class="nav-text">Departments</span>
						</a>
                        <ul aria-expanded="false">
                            <li><a href="all-departments.html">All Departments</a></li>
                            <li><a href="add-departments.html">Add Departments</a></li>
                            <li><a href="edit-departments.html">Edit Departments</a></li>
                        </ul>
                    </li>
					<li><a class="has-arrow" href="javascript:void()" aria-expanded="false">
							<i class="la la-users"></i>
							<span class="nav-text">Staff</span>
						</a>
                        <ul aria-expanded="false">
                            <li><a href="all-staff.html">All Staff</a></li>
                            <li><a href="add-staff.html">Add Staff</a></li>
                            <li><a href="edit-staff.html">Edit Staff</a></li>
                            <li><a href="staff-profile.html">Staff Profile</a></li>
                        </ul>
                    </li>
					<li><a class="has-arrow" href="javascript:void()" aria-expanded="false">
							<i class="la la-gift"></i>
							<span class="nav-text">Holiday</span>
						</a>
                        <ul aria-expanded="false">
                            <li><a href="all-holiday.html">All Holiday</a></li>
                            <li><a href="add-holiday.html">Add Holiday</a></li>
                            <li><a href="edit-holiday.html">Edit Holiday</a></li>
                            <li><a href="holiday-calendar.html">Holiday Calendar</a></li>
                        </ul>
                    </li>
					<li><a class="has-arrow" href="javascript:void()" aria-expanded="false">
							<i class="la la-dollar"></i>
							<span class="nav-text">Fees</span>
						</a>
                        <ul aria-expanded="false">
                            <li><a href="fees-collection.html">Fees Collection</a></li>
                            <li><a href="add-fees.html">Add Fees</a></li>
                            <li><a href="fees-receipt.html">Fees Receipt</a></li>
                        </ul>
                    </li>					
                    <li class="nav-label">Apps</li>
                    <li><a class="has-arrow" href="javascript:void()" aria-expanded="false">
							<i class="la la-users"></i>
							<span class="nav-text">Apps</span>
						</a>
                        <ul aria-expanded="false">
                            <li><a href="app-profile.html">Profile</a></li>
                            <li><a class="has-arrow" href="javascript:void()" aria-expanded="false">Email</a>
                                <ul aria-expanded="false">
                                    <li><a href="email-compose.html">Compose</a></li>
                                    <li><a href="email-inbox.html">Inbox</a></li>
                                    <li><a href="email-read.html">Read</a></li>
                                </ul>
                            </li>
                            <li><a href="app-calender.html">Calendar</a></li>
							<li><a class="has-arrow" href="javascript:void()" aria-expanded="false">Shop</a>
                                <ul aria-expanded="false">
                                    <li><a href="ecom-product-grid.html">Product Grid</a></li>
									<li><a href="ecom-product-list.html">Product List</a></li>
									<li><a href="ecom-product-detail.html">Product Details</a></li>
									<li><a href="ecom-product-order.html">Order</a></li>
									<li><a href="ecom-checkout.html">Checkout</a></li>
									<li><a href="ecom-invoice.html">Invoice</a></li>
									<li><a href="ecom-customers.html">Customers</a></li>
                                </ul>
                            </li>
                        </ul>
                    </li>
                    <li><a class="has-arrow ai-icon" href="javascript:void()" aria-expanded="false">
							<i class="la la-signal"></i>
							<span class="nav-text">Charts</span>
						</a>
                        <ul aria-expanded="false">
                            <li><a href="chart-flot.html">Flot</a></li>
                            <li><a href="chart-morris.html">Morris</a></li>
                            <li><a href="chart-chartjs.html">Chartjs</a></li>
                            <li><a href="chart-chartist.html">Chartist</a></li>
                            <li><a href="chart-sparkline.html">Sparkline</a></li>
                            <li><a href="chart-peity.html">Peity</a></li>
                        </ul>
                    </li>
                    <li class="nav-label">Components</li>
                    <li class="mega-menu mega-menu-xl"><a class="has-arrow ai-icon" href="javascript:void()" aria-expanded="false">
							<i class="la la-globe"></i>
							<span class="nav-text">Bootstrap</span>
						</a>
                        <ul aria-expanded="false">
                            <li><a href="ui-accordion.html">Accordion</a></li>
                            <li><a href="ui-alert.html">Alert</a></li>
                            <li><a href="ui-badge.html">Badge</a></li>
                            <li><a href="ui-button.html">Button</a></li>
                            <li><a href="ui-modal.html">Modal</a></li>
                            <li><a href="ui-button-group.html">Button Group</a></li>
                            <li><a href="ui-list-group.html">List Group</a></li>
                            <li><a href="ui-media-object.html">Media Object</a></li>
                            <li><a href="ui-card.html">Cards</a></li>
                            <li><a href="ui-carousel.html">Carousel</a></li>
                            <li><a href="ui-dropdown.html">Dropdown</a></li>
                            <li><a href="ui-popover.html">Popover</a></li>
                            <li><a href="ui-progressbar.html">Progressbar</a></li>
                            <li><a href="ui-tab.html">Tab</a></li>
                            <li><a href="ui-typography.html">Typography</a></li>
                            <li><a href="ui-pagination.html">Pagination</a></li>
                            <li><a href="ui-grid.html">Grid</a></li>
                        </ul>
                    </li>
                    <li><a class="has-arrow" href="javascript:void()" aria-expanded="false">
							<i class="la la-plus-square-o"></i>
							<span class="nav-text">Plugins</span>
						</a>
                        <ul aria-expanded="false">
                            <li><a href="uc-select2.html">Select 2</a></li>
                            <li><a href="uc-nestable.html">Nestedable</a></li>
                            <li><a href="uc-noui-slider.html">Noui Slider</a></li>
                            <li><a href="uc-sweetalert.html">Sweet Alert</a></li>
                            <li><a href="uc-toastr.html">Toastr</a></li>
                            <li><a href="map-jqvmap.html">Jqv Map</a></li>
                        </ul>
                    </li>
                    <li><a href="widget-basic.html" aria-expanded="false">
							<i class="la la-desktop"></i>
							<span class="nav-text">Widget</span>
						</a></li>
                    <li class="nav-label">Forms</li>
                    <li><a class="has-arrow" href="javascript:void()" aria-expanded="false">
							<i class="la la-file-text"></i>
							<span class="nav-text">Forms</span>
						</a>
                        <ul aria-expanded="false">
                            <li><a href="form-element.html">Form Elements</a></li>
                            <li><a href="form-wizard.html">Wizard</a></li>
                            <li><a href="form-editor-summernote.html">Summernote</a></li>
                            <li><a href="form-pickers.html">Pickers</a></li>
                            <li><a href="form-validation-jquery.html">Jquery Validate</a></li>
                        </ul>
                    </li>
                    <li class="nav-label">Table</li>
                    <li><a class="has-arrow" href="javascript:void()" aria-expanded="false">
							<i class="la la-table"></i>
							<span class="nav-text">Table</span>
						</a>
                        <ul aria-expanded="false">
                            <li><a href="table-bootstrap-basic.html">Bootstrap</a></li>
                            <li><a href="table-datatable-basic.html">Datatable</a></li>
                        </ul>
                    </li>
                    <li class="nav-label">Extra</li>
                    <li><a class="has-arrow" href="javascript:void()" aria-expanded="false">
							<i class="la la-th-list"></i>
							<span class="nav-text">Pages</span>
						</a>
                        <ul aria-expanded="false">
                            <li><a href="page-register.html">Register</a></li>
                            <li><a href="page-login.html">Login</a></li>
                            <li><a class="has-arrow" href="javascript:void()" aria-expanded="false">Error</a>
                                <ul aria-expanded="false">
                                    <li><a href="page-error-400.html">Error 400</a></li>
                                    <li><a href="page-error-403.html">Error 403</a></li>
                                    <li><a href="page-error-404.html">Error 404</a></li>
                                    <li><a href="page-error-500.html">Error 500</a></li>
                                    <li><a href="page-error-503.html">Error 503</a></li>
                                </ul>
                            </li>
                            <li><a href="page-lock-screen.html">Lock Screen</a></li>
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
						<div class="widget-stat card bg-primary">
							<div class="card-body">
								<div class="media">
									<span class="mr-3">
										<i class="la la-users"></i>
									</span>
									<div class="media-body text-white">
										<p class="mb-1">Total Students</p>
										<h3 class="text-white">3280</h3>
										<div class="progress mb-2 bg-white">
                                            <div class="progress-bar progress-animated bg-light" style="width: 80%"></div>
                                        </div>
										<small>80% Increase in 20 Days</small>
									</div>
								</div>
							</div>
						</div>
                    </div>
					<div class="col-xl-3 col-xxl-3 col-sm-6">
						<div class="widget-stat card bg-warning">
							<div class="card-body">
								<div class="media">
									<span class="mr-3">
										<i class="la la-user"></i>
									</span>
									<div class="media-body text-white">
										<p class="mb-1">New Students</p>
										<h3 class="text-white">245</h3>
										<div class="progress mb-2 bg-white">
                                            <div class="progress-bar progress-animated bg-light" style="width: 50%"></div>
                                        </div>
										<small>50% Increase in 25 Days</small>
									</div>
								</div>
							</div>
						</div>
                    </div>
					<div class="col-xl-3 col-xxl-3 col-sm-6">
						<div class="widget-stat card bg-secondary">
							<div class="card-body">
								<div class="media">
									<span class="mr-3">
										<i class="la la-graduation-cap"></i>
									</span>
									<div class="media-body text-white">
										<p class="mb-1">Total Course</p>
										<h3 class="text-white">28</h3>
										<div class="progress mb-2 bg-white">
                                            <div class="progress-bar progress-animated bg-light" style="width: 76%"></div>
                                        </div>
										<small>76% Increase in 20 Days</small>
									</div>
								</div>
							</div>
						</div>
                    </div>
					<div class="col-xl-3 col-xxl-3 col-sm-6">
						<div class="widget-stat card bg-danger">
							<div class="card-body">
								<div class="media">
									<span class="mr-3">
										<i class="la la-dollar"></i>
									</span>
									<div class="media-body text-white">
										<p class="mb-1">Fees Collection</p>
										<h3 class="text-white">25160$</h3>
										<div class="progress mb-2 bg-white">
                                            <div class="progress-bar progress-animated bg-light" style="width: 30%"></div>
                                        </div>
										<small>30% Increase in 30 Days</small>
									</div>
								</div>
							</div>
						</div>
                    </div>
					<div class="col-xl-6 col-xxl-6 col-lg-12 col-sm-12">
						<div class="card">
							<div class="card-header">
								<h3 class="card-title">University Survey</h3>
							</div>
							<div class="card-body">
								<div id="morris_bar_stalked" class="morris_chart_height" style="height: 300px !important;"></div>
							</div>
						</div>
					</div>
					<div class="col-xl-3 col-xxl-3 col-sm-6">
						<div class="card">
							<div class="card-header">
								<h3 class="card-title">Donught Chart</h3>
							</div>
							<div class="card-body">
								<div id="morris_donught_2" class="morris_chart_height" style="height: 300px !important;"></div>
							</div>
						</div>
					</div>
					<div class="col-xl-3 col-xxl-3 col-sm-6">
						<div class="card">
							<div class="card-header">
								<h3 class="card-title">University Survey</h3>
							</div>
							<div class="card-body">
								<div id="morris_area" class="morris_chart_height" style="height: 300px !important;"></div>
							</div>
						</div>
					</div>
					<div class="col-xl-3 col-xxl-4 col-lg-6 col-md-6">
						<div class="card">
							<img class="img-fluid" src="images/courses/pic1.jpg" alt="">
							<div class="card-body">
								<h4><a href="about-courses.html">Why is Early Education Essential?</a></h4>
								<ul class="list-group mb-3 list-group-flush">
									<li class="list-group-item px-0 border-top-0 d-flex justify-content-between"><span class="mb-0 text-muted">April 23</span>
										<a href="javascript:void(0);"><i class="la la-heart-o mr-1"></i><strong>230</strong></a></li>
									<li class="list-group-item px-0 d-flex justify-content-between">
										<span class="mb-0">Duration :</span><strong>12 Months</strong></li>
									<li class="list-group-item px-0 d-flex justify-content-between">
										<span class="mb-0">Professor :</span><strong>Jack Ronan</strong></li>
									<li class="list-group-item px-0 d-flex justify-content-between">
										<span><i class="fa fa-graduation-cap text-primary mr-2"></i>Student</span><strong>+120</strong></li>
								</ul>
								<a href="about-courses.html" class="btn btn-primary">Read More</a>
							</div>
						</div>
					</div>
					<div class="col-xl-3 col-xxl-4 col-lg-6 col-md-6">
						<div class="card">
							<img class="img-fluid" src="images/courses/pic2.jpg" alt="">
							<div class="card-body">
								<h4><a href="about-courses.html">The Shocking Revelation of Education.</a></h4>
								<ul class="list-group mb-3 list-group-flush">
									<li class="list-group-item px-0 border-top-0 d-flex justify-content-between"><span class="mb-0 text-muted">April 23</span>
										<a href="javascript:void(0);"><i class="la la-heart-o mr-1"></i><strong>230</strong></a></li>
									<li class="list-group-item px-0 d-flex justify-content-between">
										<span class="mb-0">Duration :</span><strong>12 Months</strong></li>
									<li class="list-group-item px-0 d-flex justify-content-between">
										<span class="mb-0">Professor :</span><strong>Jimmy Morris</strong></li>
									<li class="list-group-item px-0 d-flex justify-content-between">
										<span><i class="fa fa-graduation-cap text-primary mr-2"></i>Student</span><strong>+120</strong></li>
								</ul>
								<a href="about-courses.html" class="btn btn-primary">Read More</a>
							</div>
						</div>
					</div>
					<div class="col-xl-3 col-xxl-4 col-lg-6 col-md-6">
						<div class="card">
							<img class="img-fluid" src="images/courses/pic3.jpg" alt="">
							<div class="card-body">
								<h4><a href="about-courses.html">Five Things Nobody Told You About</a></h4>
								<ul class="list-group mb-3 list-group-flush">
									<li class="list-group-item px-0 border-top-0 d-flex justify-content-between"><span class="mb-0 text-muted">April 23</span>
										<a href="javascript:void(0);"><i class="la la-heart-o mr-1"></i><strong>230</strong></a></li>
									<li class="list-group-item px-0 d-flex justify-content-between">
										<span class="mb-0">Duration :</span><strong>12 Months</strong></li>
									<li class="list-group-item px-0 d-flex justify-content-between">
										<span class="mb-0">Professor :</span><strong>Konne Backfield</strong></li>
									<li class="list-group-item px-0 d-flex justify-content-between">
										<span><i class="fa fa-graduation-cap text-primary mr-2"></i>Student</span><strong>+120</strong></li>
								</ul>
								<a href="about-courses.html" class="btn btn-primary">Read More</a>
							</div>
						</div>
					</div>
					<div class="col-xl-3 col-xxl-4 col-lg-6 col-md-6">
						<div class="card">
							<img class="img-fluid" src="images/courses/pic4.jpg" alt="">
							<div class="card-body">
								<h4><a href="about-courses.html">Learn Python â€“ Interactive Python Tutorial</a></h4>
								<ul class="list-group mb-3 list-group-flush">
									<li class="list-group-item px-0 border-top-0 d-flex justify-content-between"><span class="mb-0 text-muted">April 23</span>
										<a href="javascript:void(0);"><i class="la la-heart-o mr-1"></i><strong>230</strong></a></li>
									<li class="list-group-item px-0 d-flex justify-content-between">
										<span class="mb-0">Duration :</span><strong>12 Months</strong></li>
									<li class="list-group-item px-0 d-flex justify-content-between">
										<span class="mb-0">Professor :</span><strong>Nashid Martines</strong></li>
									<li class="list-group-item px-0 d-flex justify-content-between">
										<span><i class="fa fa-graduation-cap text-primary mr-2"></i>Student</span><strong>+120</strong></li>
								</ul>
								<a href="about-courses.html" class="btn btn-primary">Read More</a>
							</div>
						</div>
					</div>
					
					<div class="col-xl-6 col-xxl-6 col-lg-6 col-md-12 col-sm-12">
						<div class="card">
                            <div class="card-body">
								<form action="#" method="post">
									<div class="form-group">
										<div class="input-group">
											<div class="input-group-prepend">
												<span class="input-group-text">To</span>
											</div>
											<input type="text" class="form-control">
										</div>
									</div>
									<div class="form-group">
										<div class="input-group">
											<div class="input-group-prepend">
												<span class="input-group-text">Subject</span>
											</div>
											<input type="text" class="form-control">
										</div>
									</div>
									<div class="form-group">
										<div class="summernote"></div>
									</div>
									<div class="row align-items-center">
										<div class="col-lg-6">
											<div class="fallback w-100">
												<input type="file" class="dropify" data-default-file="">
											</div>
										</div>
										<div class="col-lg-6">
											<button type="button" class="btn btn-primary float-right">
												Send <i class="fa fa-paper-plane-o"></i>
											</button>									
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
					<div class="col-xl-6 col-xxl-6 col-lg-6 col-md-12 col-sm-12">
						<div class="card">
                            <div class="card-header">
                                <h4 class="card-title">Exam Toppers</h4>
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table verticle-middle">
                                        <thead>
                                            <tr>
                                                <th scope="col">Roll No.</th>
                                                <th scope="col">Name</th>
                                                <th scope="col">Status</th>
                                                <th scope="col">Edit</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>542</td>
												<td>Jack Ronan</td>
                                                <td><span id="widget_sparklinedash"><canvas></canvas></span></td>
                                                <td>
                                                    <a href="javascript:void(0);" class="btn btn-sm btn-primary"><i class="la la-pencil"></i></a>
                                                    <a href="javascript:void(0);" class="btn btn-sm btn-danger"><i class="la la-trash-o"></i></a>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>243 </td>
                                                <td>Jimmy Morris</td>
                                                <td><div class="ico-sparkline"><div id="widget_spark-bar"></div></div></td>
												<td>
                                                    <a href="javascript:void(0);" class="btn btn-sm btn-primary"><i class="la la-pencil"></i></a>
                                                    <a href="javascript:void(0);" class="btn btn-sm btn-danger"><i class="la la-trash-o"></i></a>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>452 </td>
                                                <td>Nashid Martines</td>
                                                <td><div class="ico-sparkline"><div id="widget_StackedBarChart"></div></div></td>
												<td>
                                                    <a href="javascript:void(0);" class="btn btn-sm btn-primary"><i class="la la-pencil"></i></a>
                                                    <a href="javascript:void(0);" class="btn btn-sm btn-danger"><i class="la la-trash-o"></i></a>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>124</td>
                                                <td>Roman Aurora</td>
                                                <td> <div class="ico-sparkline"> <div id="widget_tristate"></div></div></td>
												<td>
                                                    <a href="javascript:void(0);" class="btn btn-sm btn-primary"><i class="la la-pencil"></i></a>
                                                    <a href="javascript:void(0);" class="btn btn-sm btn-danger"><i class="la la-trash-o"></i></a>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>234</td>
                                                <td>Samantha</td>
                                                <td> <div class="ico-sparkline"> <div id="widget_composite-bar"></div> </div> </td>
												<td>
                                                    <a href="javascript:void(0);" class="btn btn-sm btn-primary"><i class="la la-pencil"></i></a>
                                                    <a href="javascript:void(0);" class="btn btn-sm btn-danger"><i class="la la-trash-o"></i></a>
                                                </td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
					</div>
					<div class="col-xl-12 col-xxl-12 col-lg-12 col-md-12 col-sm-12">
                        <div class="card">
                            <div class="card-header">
                                <h4 class="card-title">New Student List</h4>
                            </div>
                            <div class="card-body">
                                <div class="table-responsive recentOrderTable">
                                    <table class="table verticle-middle table-responsive-md">
                                        <thead>
                                            <tr>
                                                <th scope="col">No.</th>
                                                <th scope="col">Name</th>
                                                <th scope="col">Assigned Professor</th>
                                                <th scope="col">Date Of Admit</th>
                                                <th scope="col">Status</th>
                                                <th scope="col">Subject</th>
                                                <th scope="col">Fees</th>
                                                <th scope="col">Edit</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>01</td>
												<td>Jack Ronan</td>
                                                <td>Airi Satou</td>
                                                <td>01 August 2020</td>
                                                <td><span class="badge badge-rounded badge-primary">Checkin</span></td>
                                                <td>Commerce</td>
                                                <td>120$</td>
                                                <td>
                                                    <a href="edit-student.html" class="btn btn-sm btn-primary"><i class="la la-pencil"></i></a>
                                                    <a href="javascript:void(0);" class="btn btn-sm btn-danger"><i class="la la-trash-o"></i></a>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>02 </td>
                                                <td>Jimmy Morris</td>
                                                <td>Angelica Ramos</td>
												<td>31 July 2020</td>
                                                <td><span class="badge badge-rounded badge-warning">Panding</span></td>
                                                <td>Mechanical</td>
                                                <td>120$</td>
                                                <td>
                                                    <a href="edit-student.html" class="btn btn-sm btn-primary"><i class="la la-pencil"></i></a>
                                                    <a href="javascript:void(0);" class="btn btn-sm btn-danger"><i class="la la-trash-o"></i></a>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>03 </td>
                                                <td>Nashid Martines</td>
                                                <td>Ashton Cox</td>
												<td>30 July 2020</td>
                                                <td><span class="badge badge-rounded badge-danger">Canceled</span></td>
                                                <td>Science</td>
                                                <td>520$</td>
                                                <td>
                                                    <a href="edit-student.html" class="btn btn-sm btn-primary"><i class="la la-pencil"></i></a>
                                                    <a href="javascript:void(0);" class="btn btn-sm btn-danger"><i class="la la-trash-o"></i></a>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>04</td>
                                                <td>Roman Aurora</td>
                                                <td>Cara Stevens</td>
												<td>29 July 2020</td>
                                                <td><span class="badge badge-rounded badge-success">Checkin</span></td>
                                                <td>Arts</td>
                                                <td>220$</td>
                                                <td>
                                                    <a href="edit-student.html" class="btn btn-sm btn-primary"><i class="la la-pencil"></i></a>
                                                    <a href="javascript:void(0);" class="btn btn-sm btn-danger"><i class="la la-trash-o"></i></a>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>05</td>
                                                <td>Samantha</td>
                                                <td>Bruno Nash </td>
												<td>28 July 2020</td>
                                                <td><span class="badge badge-rounded badge-success">Checkin</span></td>
                                                <td>Maths</td>
                                                <td>130$</td>
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
        </div>
        <!--**********************************
            Content body end
        ***********************************-->


        <!--**********************************
            Footer start
        ***********************************-->
        <div class="footer">
            <div class="copyright">
                <p>Copyright Â© Designed &amp; Developed by <a href="../index.htm" target="_blank">Dexignlab</a> 2020</p>
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
	
	<!-- Chart sparkline plugin files -->
    <script src="vendor/jquery-sparkline/jquery.sparkline.min.js"></script>
	<script src="js2/plugins-init/sparkline-init.js"></script>
	
	<!-- Chart Morris plugin files -->
    <script src="vendor/raphael/raphael.min.js"></script>
    <script src="vendor/morris/morris.min.js"></script> 
	
    <!-- Init file -->
    <script src="js2/plugins-init/widgets-script-init.js"></script>
	
	<!-- Demo scripts -->
    <script src="js2/dashboard/dashboard.js"></script>
	
	<!-- Summernote -->
    <script src="vendor/summernote/js/summernote.min.js"></script>
    <!-- Summernote init -->
    <script src="js2/plugins-init/summernote-init.js"></script>
	
	<!-- Svganimation scripts -->
    <script src="vendor/svganimation/vivus.min.js"></script>
    <script src="vendor/svganimation/svg.animation.js"></script>
    <script src="js2/styleSwitcher.js"></script>
		
</body>
>>>>>>> origin/payment
</html>