<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Wish List Courses</title>
    <!-- Google Web Fonts -->
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700&display=swap" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom CSS -->

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
    <style>
        body {
            font-family: 'Poppins', sans-serif;
            background-color: #f8f9fa;
        }

        .container {
            margin-top: 50px;
        }

        .search-bar {
            margin-bottom: 20px;
        }

        .course-card {
            border: 1px solid #ddd;
            border-radius: 10px;
            padding: 15px;
            margin-bottom: 20px;
            background-color: #fff;
            display: flex;
            align-items: center;
        }

        .course-card img {
            width: 120px;
            height: 120px;
            border-radius: 10px;
        }

        .course-details {
            margin-left: 15px;
            flex-grow: 1;
        }

        .course-details h5 {
            margin: 0;
        }

        .course-details p {
            margin: 5px 0;
        }

        .course-details .price {
            font-weight: bold;
        }

        .pagination{
            justify-content: flex-end;
        }

        .remove-btn {
            background-color: #ff6600;
            color: white;
            border: none;
            border-radius: 5px;
            padding: 5px 10px;
            cursor: pointer;
        }

        .remove-btn:hover {
            background-color: #ff4d4d;
        }
    </style>
</head>

<body>
      <!-- Navbar Start -->
        <jsp:include page="header.jsp"></jsp:include>
            <!-- Navbar End -->

    <div class="container">
        <h1 class="text-center">Wish List Courses</h1>
        <div class="search-bar text-center">
            <input type="text" class="form-control" placeholder="Search courses..." id="searchInput">
        </div>
        <div id="courseList">
            <!-- Course Cards -->
            <div class="course-card" data-course="Math">
                <img src="./img/course-1.jpg" alt="Math Course">
                <div class="course-details">
                    <h5>Math</h5>
                    <p>Learn the fundamentals of mathematics.</p>
                    <p class="price">$100</p>
                </div>
                <button class="remove-btn">Remove</button>
            </div>
            <div class="course-card" data-course="Physics">
                <img src="./img/course-1.jpg" alt="Physics Course">
                <div class="course-details">
                    <h5>Physics</h5>
                    <p>Understand the principles of physics.</p>
                    <p class="price">$120</p>
                </div>
                <button class="remove-btn">Remove</button>
            </div>
            <div class="course-card" data-course="Chemistry">
                <img src="./img/course-1.jpg" alt="Chemistry Course">
                <div class="course-details">
                    <h5>Chemistry</h5>
                    <p>Explore the world of chemistry.</p>
                    <p class="price">$110</p>
                </div>
                <button class="remove-btn">Remove</button>
            </div>
            <div class="course-card" data-course="Biology">
                <img src="./img/course-1.jpg" alt="Biology Course">
                <div class="course-details">
                    <h5>Biology</h5>
                    <p>Study the science of life.</p>
                    <p class="price">$115</p>
                </div>
                <button class="remove-btn">Remove</button>
            </div>
            <!-- Add more courses as needed -->
        </div>
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <li class="page-item"><a class="page-link" href="#">Previous</a></li>
                <li class="page-item"><a class="page-link" href="#">1</a></li>
                <li class="page-item"><a class="page-link" href="#">2</a></li>
                <li class="page-item"><a class="page-link" href="#">3</a></li>
                <li class="page-item"><a class="page-link" href="#">Next</a></li>
            </ul>
        </nav>
    </div>

        <!-- Footer Start -->
        <jsp:include page="footer.jsp"></jsp:include>
        <!-- Footer End -->

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

    <!-- JavaScript Libraries -->
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script>
        $(document).ready(function () {
            // Search functionality
            $('#searchInput').on('keyup', function () {
                var value = $(this).val().toLowerCase();
                $('#courseList .course-card').filter(function () {
                    $(this).toggle($(this).attr('data-course').toLowerCase().indexOf(value) > -1);
                });
            });

            // Remove functionality
            $('.remove-btn').on('click', function () {
                $(this).closest('.course-card').remove();
            });
        });
    </script>
</body>

</html>
