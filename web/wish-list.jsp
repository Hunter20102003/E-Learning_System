<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="en">
<<<<<<< Updated upstream
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Wish List Courses</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
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
        .pagination {
            justify-content: center;
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
        .search-bar {
            margin-bottom: 20px;
        }
    </style>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>

<div class="container">
    <h1 class="text-center">Wish List Courses</h1>
    <div class="search-bar text-center">
        <form method="post" action="${pageContext.request.contextPath}/wish-list">
            <input type="hidden" name="action" value="search">
            <div class="input-group">
                <input type="text" name="search" class="form-control" placeholder="Search courses..." value="${search}">
                <div class="input-group-append">
                    <button type="submit" class="btn btn-primary">Search</button>
                </div>
            </div>
        </form>
    </div>
    <div id="courseList">
        <c:forEach var="course" items="${wishlistCourses}">
            <div class="course-card" data-course="${course.name}">
                <img src="${course.img}" alt="${course.name} Course">
                <div class="course-details">
                    <h5>${course.name}</h5>
                    <p>${course.description}</p>
                    <p class="price">
                        <c:choose>
                            <c:when test="${course.price == 0}">
                                <span style="color: green;">Free</span>
                            </c:when>
                            <c:otherwise>
                                <fmt:formatNumber value="${course.price}" type="number" pattern="#,###" />
                                đ
                            </c:otherwise>
                        </c:choose>
                    </p>
                </div>
                <button class="remove-btn" onclick="removeFromWishlist(${course.id})">Remove</button>
            </div>
        </c:forEach>
    </div>

    <!-- Pagination -->
    <nav>
        <ul class="pagination">
            <c:forEach begin="1" end="${pageCounting}" var="i">
                <li class="page-item ${i == page ? 'active' : ''}">
                    <a class="page-link" href="${pageContext.request.contextPath}/wish-list?page=${i}&search=${search}">${i}</a>
                </li>
            </c:forEach>
        </ul>
    </nav>

</div>

<jsp:include page="footer.jsp"></jsp:include>

<script>
    function removeFromWishlist(courseId) {
        $.ajax({
            url: '${pageContext.request.contextPath}/wish-list',
            type: 'POST',
            data: { courseId: courseId, action: 'remove' },
            success: function(response) {
                if (response.trim() === 'success') {
                    location.reload();
                } else {
                    alert('Failed to remove course from wishlist');
                }
            },
            error: function(xhr, status, error) {
                console.error('Error:', error);
                alert('Failed to remove course from wishlist');
            }
        });
    }
</script>

</body>
=======
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Wish List Courses</title>
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
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
            .pagination {
                justify-content: center;
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
            .search-bar {
                margin-bottom: 20px;
            }
        </style>
    </head>
    <body>

        <jsp:include page="header.jsp"></jsp:include>

            <div class="container">
                <h1 class="text-center">Wish List Courses</h1>
                <div class="search-bar text-center">
                    <form method="post" action="${pageContext.request.contextPath}/wish-list">
                    <input type="hidden" name="action" value="search">
                    <div class="input-group">
                        <input type="text" name="search" class="form-control" placeholder="Search courses..." value="${search}">
                        <div class="input-group-append">
                            <button type="submit" class="btn btn-primary">Search</button>
                        </div>
                    </div>
                </form>
            </div>
            <div id="courseList">
                <c:forEach var="course" items="${wishlistCourses}">
                    <div class="course-card" data-course="${course.name}">
                        <img src="${course.img}" alt="${course.name} Course">
                        <div class="course-details">
                            <h5>
                                <a href="#" onclick="showCourseDetails(${course.id}); return false;">${course.name}</a>

                            </h5>
                            <p>${course.description}</p>
                            <p class="price">
                                <c:choose>
                                    <c:when test="${course.price == 0}">
                                        <span style="color: green;">Free</span>
                                    </c:when>
                                    <c:otherwise>
                                        <fmt:formatNumber value="${course.price}" type="number" pattern="#,###" />
                                        đ
                                    </c:otherwise>
                                </c:choose>
                            </p>
                        </div>
                        <form method="post" action="${pageContext.request.contextPath}/wish-list">
                            <input type="hidden" name="action" value="remove">
                            <input type="hidden" name="courseId" value="${course.id}">
                            <button type="submit" class="remove-btn">Remove</button>
                        </form>

                    </div>
                </c:forEach>
            </div>

            <!-- Pagination -->
            <nav>
                <ul class="pagination">
                    <c:forEach begin="1" end="${pageCounting}" var="i">
                        <li class="page-item ${i == page ? 'active' : ''}">
                            <a class="page-link" href="${pageContext.request.contextPath}/wish-list?page=${i}&search=${search}">${i}</a>
                        </li>
                    </c:forEach>
                </ul>
            </nav>
        </div>

        <jsp:include page="footer.jsp"></jsp:include>

            <script>
                function showCourseDetails(courseId) {
                    var url = '${pageContext.request.contextPath}/course/detail?course_id=' + courseId;
                    window.location.href = url;
                }

        </script>



    </body>
>>>>>>> Stashed changes
</html>
