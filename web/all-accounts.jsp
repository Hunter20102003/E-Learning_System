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
        <link rel="stylesheet" href="vendor/jqvmap/css/jqvmap.min.css">
        <link rel="stylesheet" href="vendor/chartist/css/chartist.min.css">
        <link rel="stylesheet" href="vendor/bootstrap-select/dist/css/bootstrap-select.min.css">
        <link rel="stylesheet" href="css2/style.css">
        <link rel="stylesheet" href="css2/skin-2.css">


        <link rel="stylesheet" href="vendor/bootstrap-select/dist/css/bootstrap-select.min.css">
        <!-- Datatable -->
        <link href="vendor/datatables/css/jquery.dataTables.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/line-awesome/1.3.0/line-awesome/css/line-awesome.min.css">



        <style>
            .custom-radio {
                appearance: none;
                -webkit-appearance: none;
                -moz-appearance: none;
                width: 20px;
                height: 20px;
                border-radius: 50%;
                border: 2px solid #6a0dad; /* Purple border color */
                background-color: #fff;
                outline: none;
                cursor: not-allowed; /* Shows not-allowed cursor */
            }

            .custom-radio:checked {
                background-color: #6a0dad; /* Purple background color */
            }

            .custom-radio:disabled {
                cursor: not-allowed; /* Shows not-allowed cursor */
            }
        </style>
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
               <c:if test="${check != null}">
        <%
            String alertMessage = (String)  request.getAttribute("check") ;
        %>
        <script type="text/javascript">
            alert("<%= alertMessage %>");
        </script>
    </c:if>
                <!-- row -->
                <div class="container-fluid">

                    <div class="row page-titles mx-0">
                        <div class="col-sm-6 p-md-0">
                            <div class="welcome-text">
                                <h4>All ACCOUNTS</h4>
                            </div>
                        </div>
                        <div class="col-sm-6 p-md-0 justify-content-sm-end mt-2 mt-sm-0 d-flex">

                        </div>
                    </div>

                    <div class="row">
                        <div class="col-lg-12">
                            <ul class="nav nav-pills mb-3">
                                <li class="nav-item"><a href="#list-view" data-toggle="tab" class="nav-link btn-primary mr-1 show active">List View</a></li>
                                <li class="nav-item"><a href="#grid-view" data-toggle="tab" class="nav-link btn-primary">Grid View</a></li>
                            </ul>
                        </div>
                        <div class="col-lg-12">
                            <div class="row tab-content">
                                <div id="list-view" class="tab-pane fade active show col-lg-12">
                                    <div class="card">
                                        <div class="card-header">


                                        </div>
                                        <div class="card-body">
                                            <div class="table-responsive">
                                                <table id="example3" class="display" style="min-width: 845px">
                                                    <thead>
                                                        <tr>
                                                            <th>Avatar</th>
                                                            <th>UserID</th>
                                                            <th>Name</th>
                                                            <th>Role</th>
                                                            <th>Email</th>
                                                            <th>Admission Date</th>
                                                            <th>Status</th>
                                                            <th>Action</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>

                                                        <c:forEach var="l"  items="${list_accounts}">
                                                            <tr>
                                                                <td><img class="rounded-circle" width="35" src="${l.avatar}" alt=""></td>
                                                                <td><strong>${l.id}</strong></td>
                                                                <td>${l.username}</td>
                                                                <td>${l.role.name}</td>

                                                                <td><strong>${l.email}</strong></td>
                                                                <td>${l.created_at}</td>
                                                                <td>
                                                                    <input type="radio" class="custom-radio" ${l.is_looked == 0 ? "checked" : ""} disabled/>


                                                                </td>
                                                                <td>
                                                                    <c:if test="${l.is_looked == 0 and (l.role.id == 2 or l.role.id == 3 or l.role.id ==4)}"> <a href="#"  class="btn btn-sm btn-primary" onclick="Islock(${l.id})" title="Lock"><i class="fas fa-lock"></i></a></c:if>
                                                                    <c:if test="${l.is_looked == 1}"> <a href="#" class="btn btn-sm btn-primary" onclick="Unlock(${l.id})" title="Unlock"><i class="fas fa-unlock"></i></a></c:if>

                                                                        <a href="display_edit?id=${l.id}" class="btn btn-sm btn-primary" title="Edit"><i class="la la-pencil" ></i></a>
                                                                    <c:if test="${l.is_looked == 1}">  <a href="#" class="btn btn-sm btn-danger" onclick="Delete(${l.id})" title="Delete"><i class="la la-trash-o"></i></a></c:if>
                                                                    </td>												
                                                                </tr>


                                                        </c:forEach>

                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div id="grid-view" class="tab-pane fade col-lg-12">
                                    <div class="row">
                                        <c:forEach var="l"  items="${list_accounts}">
                                            <div class="col-lg-4 col-md-6 col-sm-6 col-12">
                                                <div class="card card-profile">
                                                    <div class="card-header justify-content-end pb-0">
                                                        <div class="dropdown">
                                                            <button class="btn btn-link" type="button" data-toggle="dropdown">
                                                                <span class="dropdown-dots fs--1"></span>
                                                            </button>
                                                            <div class="dropdown-menu dropdown-menu-right border py-0">
                                                                <div class="py-2">
                                                                    <a class="dropdown-item" href="display_edit?id=${l.id}">Edit</a>
                                                                    <c:if test="${l.is_looked == 0}">  <a class="dropdown-item text-danger"  href="is_locked?userid=${l.id}&is=1">Lock</a></c:if>
                                                                    <c:if test="${l.is_looked == 1}">  <a class="dropdown-item text-danger" href="is_locked?userid=${l.id}&is=0" >Unlock</a></c:if>
                                                                    <c:if test="${l.is_looked == 1}">  <a class="dropdown-item text-danger" href="is_deleted?userid=${l.id}&is=1">Delete</a></c:if>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="card-body pt-2">
                                                            <div class="text-center">
                                                                <div class="profile-photo">
                                                                    <img src="${l.avatar}" width="100" class="img-fluid rounded-circle" alt="">
                                                                </div>
                                                                <h3 class="mt-4 mb-1">${l.username}</h3>
                                                                <p class="text-muted">${l.firstName}  ${l.lastName}</p>
                                                                <ul class="list-group mb-3 list-group-flush">
                                                                    <li class="list-group-item px-0 d-flex justify-content-between">
                                                                        <span>ID: </span><strong>${l.id}</strong></li>
                                                                    <li class="list-group-item px-0 d-flex justify-content-between">
                                                                        <span class="mb-0">Role : </span><strong>${l.role.name}</strong></li>
                                                                    <li class="list-group-item px-0 d-flex justify-content-between">
                                                                        <span class="mb-0">Admission Date. :</span><strong>${l.created_at}</strong></li>
                                                                    <li class="list-group-item px-0 d-flex justify-content-between">
                                                                        <span class="mb-0">Email:</span><strong>${l.email}</strong></li>
                                                                </ul>
                                                                <a class="btn btn-outline-primary btn-rounded mt-3 px-4" href="detail-account.jsp">Read More</a>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                        </c:forEach>


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



        <!-- Datatable -->
        <script src="vendor/datatables/js/jquery.dataTables.min.js"></script>
        <script src="js2/plugins-init/datatables.init.js"></script>

        <!-- Svganimation scripts -->
        <script src="vendor/svganimation/vivus.min.js"></script>
        <script src="vendor/svganimation/svg.animation.js"></script>
        <script src="js2/styleSwitcher.js"></script>





        <script src="js2/custom.min.js"></script>
        <script src="js2/dlabnav-init.js"></script>

        <!-- Chart ChartJS plugin files -->
        <script src="vendor/chart.js/Chart.bundle.min.js"></script>

        <!-- Chart piety plugin files -->
        <script src="vendor/peity/jquery.peity.min.js"></script>

        <!-- Chart sparkline plugin files -->
        <script src="vendor/jquery-sparkline/jquery.sparkline.min.js"></script>

        <!-- Demo scripts -->
        <script src="js2/dashboard/dashboard-3.js"></script>

        <!-- Svganimation scripts -->

        <script>
            document.addEventListener('DOMContentLoaded', (event) => {
                const radio = document.querySelector('.custom-radio');
                radio.disabled = true; // Ensuring it's disabled
            });
        </script>
                <script>
            // Hàm xác nh?n xóa dòng
            function Islock(id) {
                // Hi?n th? h?p tho?i xác nh?n
                var confirmation = confirm("Are you sure you want to Lock this account");

                // N?u ng??i dùng ch?n "Yes"
                if (confirmation) {
                    // Chuy?n h??ng ??n trang x? lý xóa v?i ID c?a danh m?c
                    window.location.href = "is_locked?userid="+ id +"&is="+ "1";
                }
            }
                function Unlock(id) {
                // Hi?n th? h?p tho?i xác nh?n
                var confirmation = confirm("Are you sure you want to UNLock this account");

                // N?u ng??i dùng ch?n "Yes"
                if (confirmation) {
                    // Chuy?n h??ng ??n trang x? lý xóa v?i ID c?a danh m?c
                    window.location.href = "is_locked?userid="+ id +"&is="+ "0";
                }
            }
               function Delete(id) {
                // Hi?n th? h?p tho?i xác nh?n
                var confirmation = confirm("Are you sure you want to Delete this account");

                // N?u ng??i dùng ch?n "Yes"
                if (confirmation) {
                    // Chuy?n h??ng ??n trang x? lý xóa v?i ID c?a danh m?c
                    window.location.href = "is_deleted?userid="+ id +"&is="+ "1";
                }
            }
        </script>

    </body>
</html>