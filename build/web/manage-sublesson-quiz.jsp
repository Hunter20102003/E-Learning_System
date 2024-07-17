<%-- 
    Document   : manage-sublesson-quiz
    Created on : Jul 12, 2024, 11:03:01 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Manage lesson</title>
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
        
    <link rel="stylesheet" href="styles.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <style>
        /* Basic Reset */
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: 'Arial', sans-serif;
        }

        body {
            background-color: #f2f2f2;
        }

        /* Header Styling */
        header {
            width: 100%;
            background-color: #FF6600;
            color: white;
            padding: 10px 0;
            text-align: center;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        header h1 {
            margin: 0;
            font-size: 1.5em;
        }

        /* Footer Styling */
        footer {
            width: 100%;
            background-color: #333;
            color: white;
            padding: 10px 0;
            text-align: center;
        }

        footer p {
            margin: 0;
            font-size: 0.9em;
        }

        /* Sidebar Styling */
        .sidebar {
            width: 80%;
            max-width: 1200px;
            background-color: #fff;
            border: 1px solid #dee2e6;
            margin: 20px auto;
            padding: 20px;
            overflow-y: auto;
            box-shadow: 2px 2px 10px rgba(0, 0, 0, 0.1);
        }

        .sidebar-header {
            display: flex;
            justify-content: center;
            align-items: center;
            margin-bottom: 20px;
        }

        .sidebar-header h1 {
            font-size: 1.5em;
            color: #333;
        }

        .sidebar-content .side-bar-header {
            margin-bottom: 20px;
            text-align: left;
        }

        .sidebar-content .side-bar-header a {
            text-decoration: none;
            color: white;
            background-color: #FF6600;
            padding: 10px 20px;
            border-radius: 5px;
            display: inline-block;
        }

        .big-lesson {
            margin-bottom: 20px;
            background-color: #f8f9fa;
            border: 1px solid #dee2e6;
            border-radius: 5px;
            padding: 15px;
        }

        .big-lesson-title {
            font-size: 1.2em;
            color: #FF6600;
            margin-bottom: 15px;
            cursor: pointer;
        }

        .sublesson-list {
            display: none;
            margin-top: 10px;
        }

        .sublesson-list .sublesson {
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 10px 0;
            border-bottom: 1px solid #dee2e6;
        }

        .sublesson-list .sublesson:last-child {
            border-bottom: none;
        }

        .sublesson-list .sublesson span {
            font-size: 1em;
            color: #333;
        }

        .btn {
            border: none;
            cursor: pointer;
        }

        .btn-primary {
            background-color: #FF6600;
            color: white;
            padding: 5px 10px;
            border-radius: 5px;
        }

        .btn-edit,
        .btn-delete {
            background: none;
            color: #FF6600;
            margin-left: 5px;
        }

        .btn-edit:hover,
        .btn-delete:hover {
            color: #cc5200;
        }

        .btn-add {
            background: #FF6600;
            color: white;
            padding: 5px 10px;
            border-radius: 5px;
            margin-top: 10px;
        }

        /* Quiz Styling */
        .sublesson.quiz {
            background-color: #ffebcc;
            border-left: 5px solid #FF6600;
        }

        .sublesson.quiz span {
            color: #FF6600;
            font-weight: bold;
        }

        /* Center the sidebar content */
        .content-wrapper {
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            min-height: calc(100vh - 120px);
            /* Adjusted height to consider header and footer height */
            padding: 20px 0;
        }
    </style>
</head>

<body>

    <!-- Topbar Start -->
        <jsp:include page="header.jsp"></jsp:include>
            <!-- Navbar End -->

    <div class="content-wrapper">
        <div class="sidebar">
            <div class="sidebar-header">
                <h1>Big Lessons</h1>
            </div>
            <div class="btnAdd" style="margin-bottom: 15px;">
                <button class="btn btn-primary btn-add-new"><i class="fas fa-plus"></i> Add New</button>
            </div>
            <div class="sidebar-content">
                <div class="big-lesson">
                    <div class="big-lesson-title">Big Lesson 1</div>
                    <div class="sublesson-list">
                        <div class="sublesson">
                            <span>Sublesson 1.1</span>
                            <div>
                                <button class="btn btn-primary btn-edit">Edit</button>
                                <button class="btn btn-primary btn-delete">Delete</button>
                            </div>
                        </div>
                        <div class="sublesson">
                            <span>Sublesson 1.2</span>
                            <div>
                                <button class="btn btn-primary btn-edit">Edit</button>
                                <button class="btn btn-primary btn-delete">Delete</button>
                            </div>
                        </div>
                        <button class="btn btn-add">Add Sublesson</button>
                        <button class="btn btn-add">Add Quiz</button>
                    </div>
                </div>
                <div class="big-lesson">
                    <div class="big-lesson-title">Big Lesson 2</div>
                    <div class="sublesson-list">
                        <div class="sublesson">
                            <span>Sublesson 2.1</span>
                            <div>
                                <button class="btn btn-primary btn-edit">Edit</button>
                                <button class="btn btn-primary btn-delete">Delete</button>
                            </div>
                        </div>
                        <div class="sublesson">
                            <span>Sublesson 2.2</span>
                            <div>
                                <button class="btn btn-primary btn-edit">Edit</button>
                                <button class="btn btn-primary btn-delete">Delete</button>
                            </div>
                        </div>
                        <button class="btn btn-add">Add Sublesson</button>
                        <button class="btn btn-add">Add Quiz</button>
                    </div>
                </div>
                <div class="big-lesson">
                    <div class="big-lesson-title">Big Lesson 3</div>
                    <div class="sublesson-list">
                        <div class="sublesson">
                            <span>Sublesson 3.1</span>
                            <div>
                                <button class="btn btn-primary btn-edit">Edit</button>
                                <button class="btn btn-primary btn-delete">Delete</button>
                            </div>
                        </div>
                        <div class="sublesson quiz">
                            <span>Quiz 3.1</span>
                            <div>
                                <button class="btn btn-primary btn-edit">Edit</button>
                                <button class="btn btn-primary btn-delete">Delete</button>
                            </div>
                        </div>
                        <button class="btn btn-add">Add Sublesson</button>
                        <button class="btn btn-add">Add Quiz</button>
                    </div>
                </div>
            </div>
        </div>
    </div>

    
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

    <script>
        document.querySelectorAll('.big-lesson-title').forEach(title => {
            title.addEventListener('click', () => {
                const sublessonList = title.nextElementSibling;
                sublessonList.style.display = sublessonList.style.display === 'block' ? 'none' : 'block';
            });
        });
    </script>

</body>

</html>
