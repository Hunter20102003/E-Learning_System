<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Course Reviews</title>
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
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700&display=swap" rel="stylesheet">
        <style>
        body {
            font-family: 'Poppins', sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        .container {
            width: 80%;
            max-width: 800px;
            margin: 20px;
            padding: 20px;
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        .course-header {
            text-align: center;
            margin-bottom: 20px;
        }

        .course-header h1 {
            margin: 0;
            font-size: 2em;
            color: #333;
        }

        .review-list {
            margin-bottom: 20px;
        }

        .review-item {
            padding: 15px;
            border-bottom: 1px solid #ddd;
        }

        .review-item:last-child {
            border-bottom: none;
        }

        .review-item h3 {
            margin: 0 0 5px;
            font-size: 1.2em;
            color: #ff6600;
        }

        .review-item p {
            margin: 5px 0;
            font-size: 0.9em;
            color: #555;
        }

        .review-item .review-rating {
            color: #ff6600;
            font-weight: bold;
        }

        .add-review-form {
            display: flex;
            flex-direction: column;
        }

        .add-review-form input,
        .add-review-form textarea {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ddd;
            border-radius: 5px;
        }

        .rating-stars {
            display: flex;
            justify-content: center;
            margin-bottom: 10px;
        }

        .rating-stars input {
            display: none;
        }

        .rating-stars label {
            font-size: 2em;
            color: #ddd;
            cursor: pointer;
        }

        .rating-stars input:checked ~ label,
        .rating-stars input:checked ~ label ~ label {
            color: #ff6600;
        }

        .rating-stars input:checked + label:hover,
        .rating-stars input:checked + label:hover ~ label {
            color: #e65c00;
        }

        .add-review-form button {
            padding: 10px;
            background-color: #ff6600;
            border: none;
            border-radius: 5px;
            color: #fff;
            font-size: 1em;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .add-review-form button:hover {
            background-color: #e65c00;
        }
    </style>
    </head>

    <body>
        <!-- Topbar Start -->
        <jsp:include page="header.jsp"></jsp:include>
            <!-- Navbar End -->

            <div class="container">

            <c:set var="c" value="${course}"/>

            <div class="course-header">
                <h1>${c.name}</h1>
            </div>

            <form action="review?course_id=${c.id}" method="post">            
                <div class="add-review-form">
                    <h3>Add Your Review</h3>
                    <textarea id="review-text" name="review-text" rows="4" placeholder="Write your review here..."></textarea>
                    <div class="rating-stars">
                        <input type="radio" id="star1" name="rating" value="1">
                        <label for="star1">★</label>
                        <input type="radio" id="star2" name="rating" value="2">
                        <label for="star2">★</label>
                        <input type="radio" id="star3" name="rating" value="3">
                        <label for="star3">★</label>
                        <input type="radio" id="star4" name="rating" value="4">
                        <label for="star4">★</label>
                        <input type="radio" id="star5" name="rating" value="5">
                        <label for="star5">★</label>
                    </div>         
                    <button type="submit">Submit Review</button>
                </div>
            </form>
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
        <script src="./js/scripts.js"></script>
    </body>

</html>
