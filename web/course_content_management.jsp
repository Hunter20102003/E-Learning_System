<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Manage Courses - ECOURSES</title>
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">

        <style>
            #example3 th,
            #example3 td {
                width: 12.5%;
                text-align: center;
            }

            .table-responsive {
                overflow-x: auto;
            }

            .table-responsive table {
                width: 100%;
                table-layout: fixed;
            }

            .btn {
                border: none;
                background: none;
                cursor: pointer;
            }

            .btn-edit {
                color: #4CAF50;
            }

            .btn-delete {
                color: #f44336;
            }

            .btn i {
                font-size: 18px;
            }

            #example3 td,
            #example3 th {
                padding: 10px;
            }

            .btn-primary {
                background-color: #FF6600 !important;
                border-color: #FF6600 !important;
            }

            .sidebar {
                position: fixed;
                right: -75%;
                top: 0;
                width: 75%;
                height: 100%;
                background-color: #ffffff;
                box-shadow: -2px 0 5px rgba(0, 0, 0, 0.5);
                transition: right 0.3s ease, background-color 0.3s ease;
                z-index: 1000;
                overflow-y: auto;
            }

            .sidebar-header {
                padding: 20px;
                background-color: #FF6600;
                color: white;
                display: flex;
                justify-content: space-between;
                align-items: center;
                box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            }

            .sidebar-content {
                padding: 20px;
            }

            .big-lesson {
                margin-bottom: 20px;
            }

            .big-lesson-title {
                cursor: pointer;
                background-color: #1a1612a8;
                color: white;
                padding: 10px;
                border-radius: 5px;
                transition: background-color 0.3s ease;
                display: flex;
                justify-content: space-between;
                align-items: center;
            }

            .big-lesson-title:hover {
                background-color: #e65c00;
            }

            .sublesson-list {
                display: none;
                margin-top: 10px;
            }

            .sublesson {
                padding: 5px 10px;
                background-color: #f0f0f0;
                border: 1px solid #ddd;
                border-radius: 5px;
                margin-bottom: 5px;
                transition: background-color 0.3s ease;
                display: flex;
                justify-content: space-between;
                align-items: center;
            }

            .sublesson:hover {
                background-color: #e0e0e0;
            }

            .btn-primary {
                background-color: #FF6600 !important;
                border-color: #FF6600 !important;
            }

            .btn-primary:hover {
                background-color: #e65c00 !important;
                border-color: #e65c00 !important;
            }

            #filterOptions {
                width: 100%;
                padding: 15px;
                border-radius: 5px;
                box-shadow: 0 2px 5px rgba(0, 0, 0, 0.2);
                background-color: #fff;
                position: absolute;
                z-index: 1000;
            }

            .form-check-input {
                margin-right: 10px;
            }

            .form-check-label {
                cursor: pointer;
            }

            .form-check-label:hover {
                text-decoration: underline;
            }

            /* CSS cho thanh kéo giá tiền */
            .price-slider {
                width: 200px;
                margin-bottom: 20px;
            }

            /* CSS cho lọc sản phẩm theo số sao */
            .star-filter {
                margin-top: 20px;
            }

            .fa-star {
                color: #ccc;
                /* Màu mặc định của biểu tượng */
                cursor: pointer;
            }

            .fa-star:hover {
                color: #ff6600;
                /* Màu khi hover */
            }
            .stars .star {
                font-size: 30px; /* Điều chỉnh kích thước của biểu tượng sao */
            }

            /* Additional styles for the col-6 and col-xl-3 sections */
            .bg-light {
                background-color: #f8f9fa !important;
            }

            .ps-3 {
                padding-left: 1rem !important;
            }

            .py-3 {
                padding-top: 1rem !important;
                padding-bottom: 1rem !important;
            }

            .rounded {
                border-radius: .25rem !important;
            }

            .d-flex {
                display: flex !important;
            }

            .justify-content-between {
                justify-content: space-between !important;
            }

            .mb-4 {
                margin-bottom: 1.5rem !important;
            }

            .form-select-sm {
                height: calc(1.5em + .5rem + 2px) !important;
                padding-top: .25rem !important;
                padding-bottom: .25rem !important;
                padding-left: .5rem !important;
                font-size: .875rem !important;
                line-height: 1.5 !important;
                border-radius: .2rem !important;
            }
            
        </style>
    </head>

    <body>
        <!-- Topbar Start -->
        <jsp:include page="header.jsp"></jsp:include>
            <!-- Navbar End -->

            <!--**********************************
            Content body start
        ***********************************-->
        <c:if test="${mess != null}">
            <script>
                alert("${mess}");
        
            </script>
        </c:if>
        <div class="content-body">
            <div class="container-fluid">

                <!-- Search Bar Start -->
                <div class="container mb-5">
                    <div class="row justify-content-center">
                        <div class="col-md-8">
                            <form id="courseSearchForm" method="get" action="CourseContentManagement">
                                <div class="input-group">
                                    <input type="text" class="form-control" name="search" value="${search}" placeholder="Search for courses">
                                    <div class="input-group-append">
                                        <button class="btn btn-primary" type="button" onclick="submitForm()">Search</button>
                                    </div>
                                </div>
                            </form>
                            <script>
                                function submitForm() {
                                    document.getElementById('courseSearchForm').submit();
                                }
                            </script>
                        </div>
                    </div>

                </div>
                <!-- Search Bar End -->

                <!-- Asset List -->
                <div class="row justify-content-center">
                    <div class="col-lg-12 col-md-12 col-sm-12">
                        <div class="card">
                            <div class="card-header">
                                <h4 class="card-title">Course List</h4>

                            </div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table id="example3" class="display" style="min-width: 845px">
                                        <thead>
                                            <tr>
                                                <th>ID</th>
                                                <th>Course Name</th>
                                                <th>Course Details</th>
                                                <th>Course Type</th>
                                                <th>Action</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="i" items="${listCourse}">
                                                <tr>
                                                    <td>${i.id}</td>
                                                    <td><a href="course/learning?course_id=${i.id}">${i.name}</a></td>
                                                    <td>${i.title}</td>
                                                    <td>${i.course_type.name}</td>
                                                    <td>
                                                        <!-- toi lam -->
                                                        <a href="CourseContentEdit?course_id=${i.id}" class="btn btn-show" ><i class="far fa-eye"></i></a>
                                                    </td>
                                                </tr>
                                                <!-- Sidebar cho từng course -->
                                      
                                        </c:forEach>
                                        </tbody>

                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- End Asset List -->



            <!-- Add Font Awesome CDN -->
            <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">

            <!-- Sidebar Start -->

            <!-- Sidebar End -->

            <script>
                  function confirmDeleteLesson(lessonId){
                    var x= confirm('Confirm remove lesson');
                    if (x){
                         window.location.href='lessonManagement?lessonId='+lessonId + '&action=removeLesson';
                    }
                }
                 function confirmDeleteSubLesson(subLessonId){
                    var x= confirm('Confirm remove lesson');
                    if (x){
                         window.location.href='sublessonManagement?subLessonId='+subLessonId+'&action=removeSublesson';
                    }
                }
                
                //side-bar
                document.addEventListener('DOMContentLoaded', function () {
                    var showButtons = document.querySelectorAll('.btn-show');
                    var closeButtons = document.querySelectorAll('.close-sidebar');

                    showButtons.forEach(function (button) {
                        button.addEventListener('click', function () {
                            var courseId = this.getAttribute('data-id');
                            var sidebar = document.getElementById('sidebar-' + courseId);
                            if (sidebar) {
                                sidebar.style.right = '0';
                            }
                        });
                    });

                    closeButtons.forEach(function (button) {
                        button.addEventListener('click', function () {
                            var sidebar = this.closest('.sidebar');
                            if (sidebar) {
                                sidebar.style.right = '-75%';
                            }
                        });
                    });

                    var bigLessonTitles = document.querySelectorAll('.big-lesson-title');
                    bigLessonTitles.forEach(function (title) {
                        title.addEventListener('click', function () {
                            var sublessonList = this.nextElementSibling;
                            if (sublessonList.style.display === 'none' || sublessonList.style.display === '') {
                                sublessonList.style.display = 'block';
                            } else {
                                sublessonList.style.display = 'none';
                            }
                        });
                    });

                    var showHideSublessonCheckboxes = document.querySelectorAll('.show-hide-sublesson');
                    showHideSublessonCheckboxes.forEach(function (checkbox) {
                        checkbox.addEventListener('change', function () {
                            var bigLesson = this.closest('.big-lesson');
                            var sublessonList = bigLesson.querySelector('.sublesson-list');
                            if (this.checked) {
                                sublessonList.style.display = 'block';
                            } else {
                                sublessonList.style.display = 'none';
                            }
                        });
                    });
                });
            </script>
        </div>
    </div>
    <!--**********************************
    Content body end
***********************************-->
    <div class="col-12">
        <div class="pagination d-flex justify-content-center mt-5">
            <c:if test="${page >1}">
                <c:url var="url1" value="CourseContentManagement">
                    <c:set var="backwardPage" value="${page}" />
                    <c:if test="${page > 1}">
                        <c:set var="backwardPage" value="${page - 1}" />
                    </c:if>
                    <c:param name="page" value="${backwardPage}" />
                    <c:param name="search" value="${search}" />

                </c:url>

                <a href="${url1}" class="rounded prev">&laquo;</a>
            </c:if>
            <c:forEach var="i" begin="1" end="${pageCounting}" step="1">
                <c:url var="url" value="CourseContentManagement">
                    <c:param name="page" value="${i}" />
                    <c:param name="search" value="${search}" />

                </c:url>
                <a href="${url}" class="${page eq i ? 'active rounded' : ''}">${i}</a>
            </c:forEach>
            <c:if test="${page < pageCounting}">
                <c:url var="url2" value="CourseContentManagement">
                    <c:set var="forwardPage" value="${page}" />
                    <c:if test="${page < pageCounting}">
                        <c:set var="forwardPage" value="${page + 1}" />

                    </c:if>
                    <c:param name="page" value="${forwardPage}" />
                    <c:param name="search" value="${search}" />

                </c:url>

                <a href="${url2}" class="rounded next">&raquo;</a>
            </c:if>
        </div>

    </div>
    <!-- Footer Start -->
    <jsp:include page="footer.jsp"></jsp:include>
        <!-- Footer End -->
        <script>
            document.addEventListener("DOMContentLoaded", function () {
                var pageCounting = ${pageCounting}; // Số lượng trang
                var currentPage = ${currentPage}; // Trang hiện tại
                var prevBtn = document.querySelector('.pagination .prev');
                var nextBtn = document.querySelector('.pagination .next');

                // Hàm kiểm tra và áp dụng lớp disabled cho mũi tên trước
                function checkPrevButton() {
                    if (currentPage === 1) {
                        prevBtn.classList.add('disabled');
                    } else {
                        prevBtn.classList.remove('disabled');
                    }
                }

                // Hàm kiểm tra và áp dụng lớp disabled cho mũi tên kế tiếp
                function checkNextButton() {
                    if (currentPage === pageCounting) {
                        nextBtn.classList.add('disabled');
                    } else {
                        nextBtn.classList.remove('disabled');
                    }
                }

                // Kiểm tra lần đầu tiên khi tải trang
                checkPrevButton();
                checkNextButton();

                // Sự kiện click cho nút trước
                prevBtn.addEventListener('click', function (e) {
                    e.preventDefault(); // Ngăn chặn mặc định hành vi click
                    if (currentPage > 1) {
                        currentPage--;
                        checkPrevButton();
                        checkNextButton();
                        updatePageLink(currentPage); // Cập nhật liên kết đến trang mới
                    }
                });

                // Sự kiện click cho nút kế tiếp
                nextBtn.addEventListener('click', function (e) {
                    e.preventDefault(); // Ngăn chặn mặc định hành vi click
                    if (currentPage < pageCounting) {
                        currentPage++;
                        checkPrevButton();
                        checkNextButton();
                        updatePageLink(currentPage); // Cập nhật liên kết đến trang mới
                    }
                });

                // Hàm cập nhật liên kết đến trang mới
                function updatePageLink(page) {
                    var currentPageLinks = document.querySelectorAll('.pagination a');
                    currentPageLinks.forEach(function (link) {
                        var href = link.getAttribute('href');
                        href = href.replace(/page=\d+/, 'page=' + page);
                        link.setAttribute('href', href);
                    });
                }
            });
    </script>

    <!-- JavaScript Libraries -->
    <script>
        function deleteQuizConfirm(quizId) {
            var confirmed = confirm("Confirm deleting this quiz");
            if (confirmed) {
                window.location.href = 'QuizzesManagement?quizId=' + quizId + '&action=quizRemove';
            } else {

            }
        }
        function handleDeleteLessonButtonClick() {
            // Hiển thị thông báo confirm
            var confirmed = confirm("Confirm deleting this lesson");

            // Nếu người dùng nhấn OK trong confirm box
            if (confirmed) {
                // Thực hiện chuyển hướng tới servlet (ví dụ đường dẫn '/servlet')
                window.location.href = '/servlet';
            } else {
                // Người dùng nhấn Cancel, không làm gì cả
            }
        }

// Đoạn mã xử lý sau khi quay lại từ servlet và có giá trị thỏa mãn true
// Giả sử servlet trả về một biến isSuccess khi quay lại
//        var isSuccess = true; // Thay đổi giá trị này tùy theo logic của servlet
//
//        if (isSuccess) {
//            alert("Chào mừng bạn quay lại!"); // Alert ra thông điệp
//        }

    </script>
    <script src="js/main.js"></script>
    <script src="./js/scripts.js"></script>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
</body>

</html>
