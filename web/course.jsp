<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page import="Dal.CourseDAO" %>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <title>ECOURSES - Online Courses HTML Template</title>
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="Free HTML Templates" name="keywords">
        <meta content="Free HTML Templates" name="description">

        <!-- Favicon -->
        <link href="img/favicon.ico" rel="icon">

        <!-- Google Web Fonts -->
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700&display=swap" rel="stylesheet">

        <!-- Font Awesome -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">

        <!-- Libraries Stylesheet -->
        <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

        <!-- Customized Bootstrap Stylesheet -->
        <link href="css/style.css" rel="stylesheet">
        <script>
            // Hàm để tự động submit biểu mẫu
            function autoSubmit() {
                var selectedSort = document.getElementById("fruits").value; // Get the selected sort value
                document.getElementById("sortInput").value = selectedSort; // Update the value of the hidden input
                document.getElementById("myForm").submit(); // Submit the form
            }
        </script>
        <style>
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

            /* Pagination styles */
            .pagination {
                display: flex;
                padding-left: 0;
                list-style: none;
                border-radius: .25rem;
            }

            .pagination a {
                color: #ff6600;
                text-decoration: none;
                background-color: #fff;
                border: 1px solid #dee2e6;
                padding: 0.5rem 0.75rem;
                margin-left: -1px;
            }

            .pagination a:hover {
                background-color: #e9ecef;
                border-color: #dee2e6;
            }

            .pagination a.active {
                z-index: 1;
                color: #fff;
                background-color: #ff6600;
                border-color: #ff6600;
            }

            .pagination a.rounded {
                border-radius: 0.25rem;
            }

            .form-select-sm {
                color: #ff6600 !important;
            }
            .form-select-sm option {
                color: #ff6600;
            }

        </style>

    </head>

    <body>
        <!-- Topbar Start -->
        <jsp:include page="header.jsp"></jsp:include>
            <!-- Navbar End -->


            <!-- Header Start -->
            <div class="container-fluid page-header" style="margin-bottom: 90px;">
                <div class="container">
                    <div class="d-flex flex-column justify-content-center" style="min-height: 300px">
                        <h3 class="display-4 text-white text-uppercase">Courses</h3>
                        <div class="d-inline-flex text-white">
                            <p class="m-0 text-uppercase"><a class="text-white" href="">Home</a></p>
                            <i class="fa fa-angle-double-right pt-1 px-3"></i>
                            <p class="m-0 text-uppercase">Courses</p>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Header End -->

            <!-- Search Bar Start -->
            <form  id="myForm" action="course" method="get">
                <div class="container mb-5">
                    <div class="row justify-content-center">
                        <div class="col-md-8">

                            <div class="input-group">

                                <input type="text" class="form-control" name="txtSearch" value="${txtSearch}" placeholder="Search for courses">
                            <div class="input-group-append">
                                <button style="background-color: white;" id="filterButton" class="btn btn-primary"
                                        type="button">
                                    <i style="color: #f60;" id="filterIcon" class="fas fa-filter"></i>
                                </button>
                                <input class="btn btn-primary" type="submit" value="Search"/>
                            </div>

                        </div>

                        <!-- Filter Options -->
                        <div id="filterOptions" class="dropdown-menu dropdown-menu-right mt-2" style="display: none;">
                            <div class="container">
                                <div class="row">
                                    <div class="col-md-4">
                                        <div>Type Of Course</div>
                                        <c:forEach var="i" items="${listTypeOfCourse}">
                                            <div class="form-check">
                                                <input class="form-check-input" type="checkbox" name="cbxTypesOfCourse" ${fn:contains(cbxTypesOfCourse,i.id)?"checked":""} value="${i.id}" id="${i.name}" onclick="autoSubmit()">
                                                <label class="form-check-label" for="${i.name}">${i.name}</label>
                                            </div>
                                        </c:forEach>
                                    </div>
                                    <div class="col-md-4">
                                        <div>Price</div>
                                        <div class="form-check">
                                            <input class="form-check-input" type="checkbox" name="cbxPrices" ${fn:contains(cbxPrices,"free")?"checked":""} value="free" id="priceFree" onclick="autoSubmit()">
                                            <label class="form-check-label" for="priceFree">Free</label>
                                        </div>
                                        <div class="form-check">
                                            <input class="form-check-input" type="checkbox" name="cbxPrices" ${fn:contains(cbxPrices,"paid")?"checked":""} value="paid" id="pricePaid" onclick="autoSubmit()">
                                            <label class="form-check-label" for="pricePaid">Paid</label>
                                        </div>
                                    </div>
                                    <div class="col-md-4">
                                        <div>Course Duration</div>
                                        <div class="form-check">
                                            <input class="form-check-input" type="checkbox" name="cbxDurations" id="duration1" ${fn:contains(cbxDurations,"1")?"checked":""} value="1" onclick="autoSubmit()">
                                            <label class="form-check-label" for="duration1">0-1 Hour</label>
                                        </div>
                                        <div class="form-check">
                                            <input class="form-check-input" type="checkbox" name="cbxDurations" id="duration2"  ${fn:contains(cbxDurations,"2")?"checked":""} value="2" onclick="autoSubmit()">
                                            <label class="form-check-label" for="duration2">1-3 Hours</label>
                                        </div>
                                        <div class="form-check">
                                            <input class="form-check-input" type="checkbox" name="cbxDurations" id="duration3" ${fn:contains(cbxDurations,"3")?"checked":""} value="3" onclick="autoSubmit()">
                                            <label class="form-check-label" for="duration3">3-6 Hours</label>
                                        </div>
                                        <div class="form-check">
                                            <input class="form-check-input" type="checkbox" name="cbxDurations" id="duration4" ${fn:contains(cbxDurations,"4")?"checked":""} value="4" onclick="autoSubmit()">
                                            <label class="form-check-label" for="duration4">6-17 Hours</label>
                                        </div>
                                        <div class="form-check">
                                            <input class="form-check-input" type="checkbox" name="cbxDurations" id="duration5" ${fn:contains(cbxDurations,"5")?"checked":""} value="5" onclick="autoSubmit()">
                                            <label class="form-check-label" for="duration5">17+ Hours</label>
                                        </div>
                                    </div>
                                </div>
                                <div class="row mt-3">
                                    <div class="col-12">
                                        <div>Rating</div>
                                        <div class="stars">
                                            <span class="star" data-rating="1">&#9733;</span>
                                            <span class="star" data-rating="2">&#9733;</span>
                                            <span class="star" data-rating="3">&#9733;</span>
                                            <span class="star" data-rating="4">&#9733;</span>
                                            <span class="star" data-rating="5">&#9733;</span>
                                        </div>
                                        <input type="hidden" id="ratingInput" name="rating" value="">
                                        <div style="text-align:right; margin-top: 10px;">
                                            <a href="#" id="clearLink" onclick="clearAllCheckboxes()">clear</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <script>
                                //clear filter
                                function clearAllCheckboxes() {
                                    // Get all checkbox elements
                                    var checkboxes = document.querySelectorAll('input[type="checkbox"]');

                                    // Uncheck each checkbox
                                    checkboxes.forEach(function (checkbox) {
                                        checkbox.checked = false;
                                    });

                                    // Optionally, call the autoSubmit function if needed
                                    autoSubmit();
                                }
                            </script>


                        </div>
                        <!-- End Filter Options -->
                    </div>
                </div>
            </div>
        </form>

            <!-- Search Bar End -->

            <script>
                // Lấy input hidden và các sao
                var ratingInput = document.getElementById('ratingInput');
                var stars = document.querySelectorAll('.star');

                // Xử lý sự kiện khi người dùng nhấp vào sao
                stars.forEach(function (star) {
                    star.addEventListener('click', function () {
                        // Lấy giá trị số sao từ thuộc tính data-rating
                        var rating = this.getAttribute('data-rating');
                        // Cập nhật giá trị của input hidden
                        ratingInput.value = rating;
                        // Tự động gửi form
                        document.getElementById('myForm').submit();
                    });
                });
            </script>
            <script>


                // Bộ lọc theo số sao
                var stars = document.querySelectorAll('.star');
                stars.forEach(function (star) {
                    star.addEventListener('click', function () {
                        var rating = parseInt(this.getAttribute('data-rating'));
                        highlightStars(rating);
                    });
                });

                function highlightStars(rating) {
                    for (var i = 0; i < stars.length; i++) {
                        if (i < rating) {
                            stars[i].style.color = "#ff6600";
                        } else {
                            stars[i].style.color = "";
                        }
                    }
                }


            </script>

            <script>
                document.addEventListener("DOMContentLoaded", function () {
                    var rating = ${rating}; // Lấy giá trị rating từ request attribute
                    var stars = document.querySelectorAll('.star');

                    // Hàm tô màu các sao tương ứng với số sao được chọn
                    function highlightStars(rating) {
                        stars.forEach(function (star) {
                            var starRating = parseInt(star.getAttribute('data-rating'));
                            if (starRating <= rating) {
                                star.style.color = "#ff6600"; // Màu cam cho các sao đã chọn
                            } else {
                                star.style.color = ""; // Xóa màu của các sao chưa chọn
                            }
                        });
                    }

                    // Nếu có giá trị rating, tô màu các sao
                    if (rating) {
                        highlightStars(rating);
                    }

                    // Xử lý sự kiện khi người dùng nhấp vào sao
                    stars.forEach(function (star) {
                        star.addEventListener('click', function () {
                            var rating = parseInt(this.getAttribute('data-rating'));

                            // Cập nhật giá trị của input hidden
                            ratingInput.value = rating;

                            // Tô màu các sao tương ứng với số sao đã chọn
                            highlightStars(rating);

                            // Tự động gửi form
                            document.getElementById('myForm').submit();
                        });
                    });
                });
            </script>

            <script>
                document.addEventListener("DOMContentLoaded", function () {
                    var filterButton = document.getElementById("filterButton");
                    var filterOptions = document.getElementById("filterOptions");

                    filterButton.addEventListener("click", function () {
                        if (filterOptions.style.display === "none") {
                            filterOptions.style.display = "block";
                        } else {
                            filterOptions.style.display = "none";
                        }
                    });
                });

            </script>



            <!-- Category Start -->


            <!-- Courses Start -->
            <div class="container-fluid py-5">
                <div class="container py-5">
                    <div class="text-center mb-5">
                        <!--                <h1 class="text-primary text-uppercase mb-3" style="letter-spacing: 5px;">Courses</h1>-->
                        <!--                <h1>Our Popular Courses</h1>-->
                    </div>
                    <div class="container">
                        <label >Result: ${results}</label>
                        <div class="row">

                            <div class="col-6"></div>       
                            <div class="col-xl-6 d-flex justify-content-end">

                                <div class="bg-light ps-3 py-3 rounded d-flex justify-content-between mb-4">

                                    <label for="fruits" class="me-3">Sort by:</label>
                                    <input type="hidden" name="sort" id="sortInput" value="mostRelevant">

                                    <select id="fruits" name="sort" class="border-0 form-select-sm bg-light me-3" onchange="autoSubmit()">
                                        <option value="mostRelevant" ${"mostRelevant" eq sort ? 'selected' : ''}>Most Relevant</option>
                                        <option value="newest" ${"newest" eq sort ? 'selected' : ''}>Newest</option>
                                        <option value="highestRate" ${"highestRate" eq sort ? 'selected' : ''}>Highest Rated</option>
                                        <option value="highestPrice" ${"highestPrice" eq sort ? 'selected' : ''}>Highest Price</option>
                                        <option value="cheapestPrice" ${"cheapestPrice" eq sort ? 'selected' : ''}>Cheapest Price</option>
                                    </select>

                                </div>
                            </div>
                        </div>
                    </div>
                    </form>
                    <div>${emptyCourse}</div>
                    <div class="row">
                        <c:forEach var="i" items="${listCourse}">
                            <c:if test="${i.is_locked == false}">
                                <div class="col-lg-4 col-md-6 mb-4">
                                    <div class="rounded overflow-hidden mb-2">
                                        <img class="img-fluid" src="${i.img}" alt="">
                                        <div class="bg-secondary p-4">
                                            <div class="d-flex justify-content-between mb-3">

                                                <small class="m-0"><i class="fa fa-users text-primary mr-2"></i>${courseDao.getAllEnrollmentByCourseID(i.id).size()} Students</small>

                                                <small class="m-0"><i class="far fa-clock text-primary mr-2"></i>${youTubeDuration.convertToHoursAndMinutes(courseDao.getDurationOfCourse(i.id))}</small>
                                            </div>

                                            <a class="h5" href="course/detail?course_id=${i.id}">${i.name}</a>
                                            <div class="border-top mt-4 pt-4">
                                                <div class="d-flex justify-content-between">
                                                    <c:set var="sumRating" value="0" />
                                                    <c:set var="sumReview" value="0" />

                                                    <c:forEach var="j" items="${courseDao.getAllReviewByCourseID(i.id)}">
                                                        <c:if test="${j.review_text != null}">
                                                            <c:set var="sumReview" value="${sumReview + 1}" />
                                                        </c:if>
                                                        <c:set var="sumRating" value="${sumRating + j.rating}" />
                                                    </c:forEach>
                                                    <c:set var="averageRating" value="0" />

                                                    <c:if test="${fn:length(courseDao.getAllReviewByCourseID(i.id)) ne 0}">
                                                        <c:set var="averageRating" value="${sumRating / fn:length(courseDao.getAllReviewByCourseID(i.id))}" />
                                                    </c:if>

                                                    <fmt:formatNumber var="rattingFormat" pattern="0.0" value="${averageRating}" />

                                                    <h6 class="m-0"><i class="fa fa-star text-primary mr-2"></i>${rattingFormat} <small>(${sumReview})</small></h6>
                                                    <c:choose>

                                                        <c:when test="${i.price eq 0}"> <h5 class="m-0" style="color:green">Free</h5></c:when>
                                                        <c:otherwise> 
                                                            <fmt:formatNumber var="format" pattern="#,###" value="${i.price}" />

                                                            <h5 class="m-0">${format}đ</h5>
                                                        </c:otherwise>
                                                    </c:choose>

                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:if>      
                        </c:forEach>
                        <!--phan trang-->
                        <div class="col-12">
                            <div class="pagination d-flex justify-content-center mt-5">
                                <c:if test="${page >1}">
                                    <c:url var="url1" value="course">
                                        <c:set var="backwardPage" value="${page}" />
                                        <c:if test="${page > 1}">
                                            <c:set var="backwardPage" value="${page - 1}" />
                                        </c:if>
                                        <c:param name="page" value="${backwardPage}" />
                                        <c:param name="txtSearch" value="${txtSearch}" />
                                        <c:forEach var="type" items="${cbxTypesOfCourse}">
                                            <c:param name="cbxTypesOfCourse" value="${type}" />
                                        </c:forEach>
                                        <c:forEach var="type" items="${cbxPrices}">
                                            <c:param name="cbxPrices" value="${type}" />
                                        </c:forEach>
                                        <c:forEach var="type" items="${cbxDurations}">
                                            <c:param name="cbxDurations" value="${type}" />
                                        </c:forEach>
                                        <c:param name="rating" value="${rating}" />

                                        <c:param name="sort" value="${sort}" />
                                    </c:url>

                                    <a href="${url1}" class="rounded prev">&laquo;</a>
                                </c:if>
                                <c:forEach var="i" begin="1" end="${pageCounting}" step="1">
                                    <c:url var="url" value="course">
                                        <c:param name="page" value="${i}" />
                                        <c:param name="txtSearch" value="${txtSearch}" />
                                        <c:forEach var="type" items="${cbxTypesOfCourse}">
                                            <c:param name="cbxTypesOfCourse" value="${type}" />
                                        </c:forEach>
                                        <c:forEach var="type" items="${cbxPrices}">
                                            <c:param name="cbxPrices" value="${type}" />
                                        </c:forEach>
                                        <c:forEach var="type" items="${cbxDurations}">
                                            <c:param name="cbxDurations" value="${type}" />
                                        </c:forEach>
                                        <c:param name="rating" value="${rating}" />
                                        <c:param name="sort" value="${sort}" />
                                    </c:url>
                                    <a href="${url}" class="${page eq i ? 'active rounded' : ''}">${i}</a>
                                </c:forEach>
                                <c:if test="${page < pageCounting}">
                                    <c:url var="url2" value="course">
                                        <c:set var="forwardPage" value="${page}" />
                                        <c:if test="${page < pageCounting}">
                                            <c:set var="forwardPage" value="${page + 1}" />

                                        </c:if>
                                        <c:param name="page" value="${forwardPage}" />
                                        <c:param name="txtSearch" value="${txtSearch}" />
                                        <c:forEach var="type" items="${cbxTypesOfCourse}">
                                            <c:param name="cbxTypesOfCourse" value="${type}" />
                                        </c:forEach>
                                        <c:forEach var="type" items="${cbxPrices}">
                                            <c:param name="cbxPrices" value="${type}" />
                                        </c:forEach>
                                        <c:forEach var="type" items="${cbxDurations}">
                                            <c:param name="cbxDurations" value="${type}" />
                                        </c:forEach>
                                        <c:param name="rating" value="${rating}" />
                                        <c:param name="sort" value="${sort}" />
                                    </c:url>

                                    <a href="${url2}" class="rounded next">&raquo;</a>
                                </c:if>
                            </div>

                        </div>
                    </div>
                </div>
            </div>

            <!-- Courses End -->



            <!-- Footer Start -->
            <jsp:include page="footer.jsp"></jsp:include>
                <!-- Footer End -->


                <!-- Back to Top -->
                <a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top"><i class="fa fa-angle-double-up"></i></a>

                <!-- JavaScript Libraries -->
                <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
                <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
                <script src="lib/easing/easing.min.js"></script>
                <script src="lib/owlcarousel/owl.carousel.min.js"></script>

                <!-- Contact Javascript File -->
                <script src="mail/jqBootstrapValidation.min.js"></script>
                <script src="mail/contact.js"></script>

                <!-- Template Javascript -->
                <script src="js/main.js"></script>
                <script src="./js/scripts.js"></script>

                <script>document.addEventListener("DOMContentLoaded", function () {
                                            var clearLink = document.getElementById("clearLink");

                                            clearLink.addEventListener("click", function (event) {
                                                event.preventDefault(); // Ngăn chặn hành động mặc định của thẻ link

                                                // Lặp qua tất cả các checkbox và hủy chọn
                                                var checkboxes = document.querySelectorAll('input[type="checkbox"]');
                                                checkboxes.forEach(function (checkbox) {
                                                    checkbox.checked = false;
                                                });

                                                // Chuyển hướng đến trang khác
                                                window.location.href = "course"; // Thay đổi URL này thành URL của trang khác
                                            });
                                        });
                </script>
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


    </body>

</html>
