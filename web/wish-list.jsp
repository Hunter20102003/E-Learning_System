<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Wish List Courses</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="css/style.css" rel="stylesheet">
    <style>
        /* Your custom styles */
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

        .pagination {
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
    <jsp:include page="header.jsp"></jsp:include>
    
    <div class="container">
        <h1 class="text-center">Wish List Courses</h1>
        <div class="search-bar text-center">
            <input type="text" class="form-control" placeholder="Search courses..." id="searchInput">
        </div>
        <div id="courseList">
            <!-- Course Cards -->
            <c:forEach var="course" items="${wishlistCourses}">
                <div class="course-card" data-course="${course.name}">
                    <img src="${course.courseImg}" alt="${course.name} Course">
                    <div class="course-details">
                        <h5>${course.name}</h5>
                        <p>${course.description}</p>
                        <p class="price">${course.price}</p>
                    </div>
                    <button class="remove-btn" onclick="removeFromWishlist(${course.id})">Remove</button>
                </div>
            </c:forEach>
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

    <jsp:include page="footer.jsp"></jsp:include>

    <!-- jQuery, Bootstrap JS, and other scripts -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
    <script>
        $(document).ready(function () {
            // Search functionality
            $('#searchInput').on('keyup', function () {
                var value = $(this).val().toLowerCase();
                $('#courseList .course-card').filter(function () {
                    $(this).toggle($(this).attr('data-course').toLowerCase().indexOf(value) > -1);
                });
            });
        });

        function removeFromWishlist(courseId) {
            $.ajax({
                url: '${pageContext.request.contextPath}/wishlist/remove',
                type: 'POST',
                data: { courseId: courseId },
                success: function(response) {
                    if (response === 'success') {
                        location.reload();
                    } else {
                        alert('Failed to remove course from wishlist');
                    }
                }
            });
        }
    </script>
</body>
</html>
