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
                        <strong id="totalIncome">TOTAL All INCOME ${total}VND  WITH NUMBER PAYMENTS IS : ${size}</strong>
                    <div class="row">
                        <div class="col-xl-6 col-xxl-6 col-sm-6">
                            <div class="widget-stat card bg-primary overflow-hidden">
                                <div class="card-header">
                                    <h3 class="card-title text-white">Total ACOUNTS</h3>
                                    <h5 class="text-white mb-0"><i class="fa fa-caret-up"></i> ${number_all}</h5>
                                </div>
                                <div class="card-body text-center mt-3">
                                    <div class="ico-sparkline">
                                        <div id="sparkline12"></div>
                                    </div>
                                </div>
                                <div class="chart-legend text-white mt-3">
                                    <span class="legend-item"><span class="legend-color" style="background-color: #8d95ff;"></span> Mentee</span>
                                    <span class="legend-item"><span class="legend-color" style="background-color: #fac2c2;"></span> Mentor</span>
                                    <span class="legend-item"><span class="legend-color" style="background-color: rgba(255, 0, 0, 0.8);"></span> Admin</span>
                                    <span class="legend-item"><span class="legend-color" style="background-color: #00FF00;"></span> Manager</span>
                                </div>
                            </div>
                        </div>

                        <div class="col-xl-6 col-xxl-6 col-sm-6">
                            <div class="widget-stat card bg-primary">
                                <div class="card-body">
                                    <div class="media">
                                        <span class="mr-3">
                                            <i class="la la-users"></i>
                                        </span>
                                        <div class="media-body text-white">
                                            <p class="mb-1" style="font-size: 24px; font-weight: bold;">Total ACOUNTS NOW</p>
                                            <h3 class="text-white" style="font-size: 36px; font-weight: bold;">${number_all}</h3>
                                            <div class="progress mb-2 bg-white">
                                                <div class="progress-bar progress-animated bg-light" style="width: ${persen}%"></div>
                                            </div>
                                            <small style="font-size: 14px;">${persen}% Increase in 10 Days</small>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>



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
                                    <strong style="color: royalblue" id="totalIncome"></strong>


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




            <script src="js2/plugins-init/widgets-script-init.js"></script>





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
                                    sliceColors: ["#8d95ff", "#fac2c2", "rgba(255, 0, 0, 0.8)", "#00FF00"]
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