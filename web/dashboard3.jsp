<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
        <link href="vendor/datatables/css/jquery.dataTables.min.css" rel="stylesheet">

        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-sparklines/2.1.3/jquery.sparkline.min.js"></script>



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
                            <strong id="totalIncome">TOTAL INCOME IN YEAR ${year} : ${total}VND</strong>



                        <div class="col-lg-12">



                            <div class="row tab-content">

                                <div id="list-view" class="tab-pane fade active show col-lg-12">
                                    <form  action="income_dashboard" method="post" id="yearForm">
                                        <label for="yearInput">Enter Year:</label>
                                        <input type="text" name="year" />
                                        <button type="submit" >Submit</button>
                                    </form>
                                    <div class="card">
                                        <div class="card-header">


                                        </div>
                                        <div class="card-body">
                                            <div class="table-responsive">
                                                <table id="example3" class="display" style="min-width: 845px">
                                                    <thead>
                                                        <tr>


                                                            <th>USER_ID</th>
                                                            <th>NAME</th>
                                                            <th>EMAIL</th>
                                                            <th>INCOME FOR EACH MONTHS</th>


                                                            <th>TOTAL INCOME IN YEAR</th>
                                                            <th>STATUS</th>

                                                        </tr>
                                                    </thead>
                                                    <tbody>

                                                        <c:forEach var="l" items="${manager_list}">
                                                            <tr>
                                                                <td>${l.user_id}</td>
                                                                <td>${l.name}</td>
                                                                <td>${l.mail}</td>
                                                                <td>
                                                                    <div class="ico-sparkline">
                                                                        <div id="widget_spark-bar-${l.user_id}"></div>
                                                                    </div>
                                                                </td>
                                                                <td>${l.total}VND</td>
                                                                <td>thai</td>
                                                            </tr>
                                                            <!-- JavaScript to initialize Sparkline for each user -->
                                                        <script>
                                                            $(document).ready(function () {
                                                                var incomeData = [<c:forEach var="value" items="${l.sparklineData}">${value},</c:forEach>];
                                                                // Check if the element exists before initializing Sparkline
                                                                if ($('#widget_spark-bar-${l.user_id}').length > 0) {
                                                                    $('#widget_spark-bar-${l.user_id}').sparkline(incomeData, {
                                                                        type: "bar",
                                                                        height: "40",
                                                                        barWidth: 3,
                                                                        barSpacing: 3,
                                                                        barColor: "rgb(7, 135, 234)"
                                                                    });
                                                                }
                                                            });
                                                        </script>
                                                    </c:forEach>





                                                    </tbody>
                                                </table>
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


                </div>
            </div>
            <!--**********************************
                Footer end
            <script src="vendor/global/global.min.js"></script>



            <!-- Datatable -->



            <!-- Svganimation scripts -->











            <!-- Chart piety plugin files -->


            <!-- Chart sparkline plugin files -->


            <!-- Demo scripts -->



            <!--**********************************
       Support ticket button start
    ***********************************-->
            <script src="vendor/global/global.min.js"></script>



            <!-- Datatable -->
            <script src="vendor/datatables/js/jquery.dataTables.min.js"></script>
            <script src="js2/plugins-init/datatables.init.js"></script>



            <!--**********************************
               Support ticket button end
            ***********************************-->



            <!--**********************************
                Main wrapper end
            ***********************************-->

            <!--**********************************
                Scripts
            ***********************************-->
            <!-- Required vendors -->

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


                                                            </body>
                                                                    </html>