<%-- 
    Document   : videoLearn
    Created on : May 17, 2024, 11:46:44 PM
    Author     : LEGION
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Learning Page</title>
    
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
            margin: 0;
            padding: 0;
            background-color: #f8f9fa;
        }

        .container {
            display: grid;
            grid-template-columns: 2fr 1fr;
            gap: 20px;
            padding: 20px;
        }

        .video-container {
            display: flex;
            flex-direction: column;
        }

        .video {
            width: 100%;
            height: 400px;
            background-color: #000;
            border-radius: 10px;
            overflow: hidden;
        }

        .comments {
            margin-top: 20px;
            background-color: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 2px 5px rgba(0,0,0,0.1);
        }

        .comments h2 {
            font-size: 1.5em;
            margin-bottom: 10px;
        }

        .comments textarea {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 1em;
        }

        .comments button {
            margin-top: 10px;
            padding: 10px 20px;
            background-color: #FF6600;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        .comments button:hover {
            background-color: #FF6600;
        }

        .comments div {
            margin-top: 20px;
        }

        .comments p {
            margin: 10px 0;
            padding: 10px;
            background-color: #f1f1f1;
            border-radius: 5px;
        }

        .sidebar {
            display: flex;
            flex-direction: column;
            gap: 20px;
        }

        .section {
            background-color: #fff;
            padding: 25px;
            border-radius: 10px;
            box-shadow: 0 2px 5px rgba(0,0,0,0.1);
        }

        .section h3 {
            margin: 0 0 10px;
            font-size: 1.5em;
            color: #333;
        }

        .video-list ul,
        .progress ul {
            list-style: none;
            padding: 0;
        }

        .video-list li,
        .progress li {
            padding: 10px;
            border-bottom: 1px solid #ddd;
            cursor: pointer;
        }

        .video-list li:hover,
        .progress li:hover {
            background-color: #f1f1f1;
        }

        .progress li {
            display: flex;
            justify-content: space-between;
        }

        .progress-content {
            max-height: 200px; /* Điều chỉnh độ cao tối đa của phần progress */
            overflow-y: auto; /* Tạo thanh cuộn theo chiều dọc khi cần */
        }

        .progress-content ul {
            padding: 0;
            margin: 0;
            list-style: none;
        }

        .progress-content ul li {
            display: flex;
            justify-content: space-between;
            padding: 10px;
            border-bottom: 1px solid #ddd;
        }

        .progress-content ul li:last-child {
            border-bottom: none; /* Loại bỏ đường viền dưới cùng */
        }

        /* .... Click function */
        .video-item {
            display: flex;
            flex-direction: column;
        }

        .video-item .video-item-title {
            font-weight: 500;
        }

    </style>
</head>
<body>
     <!-- Navbar Start -->
     <div class="container-fluid px-0">
        <div class="row border-top px-xl-5">
            <div class="col-lg-3 d-none d-lg-block">
                <a class="d-flex align-items-center justify-content-between bg-secondary w-100 text-decoration-none" data-toggle="collapse" href="#navbar-vertical" style="height: 67px; padding: 0 30px;">
                    <h5 class="text-primary m-0"><i class="fa fa-book-open mr-2"></i>Subjects</h5>
                    <i class="fa fa-angle-down text-primary"></i>
                </a>
                <nav class="collapse position-absolute navbar navbar-vertical navbar-light align-items-start p-0 border border-top-0 border-bottom-0 bg-light" id="navbar-vertical" style="width: calc(100% - 30px); z-index: 9;">
                    <div class="navbar-nav w-100">
                        <div class="nav-item dropdown">
                            <a href="#" class="nav-link" data-toggle="dropdown">Web Design <i class="fa fa-angle-down float-right mt-1"></i></a>
                            <div class="dropdown-menu position-absolute bg-secondary border-0 rounded-0 w-100 m-0">
                                <a href="" class="dropdown-item">HTML</a>
                                <a href="" class="dropdown-item">CSS</a>
                                <a href="" class="dropdown-item">jQuery</a>
                            </div>
                        </div>
                        <a href="" class="nav-item nav-link">Apps Design</a>
                        <a href="" class="nav-item nav-link">Marketing</a>
                        <a href="" class="nav-item nav-link">Research</a>
                        <a href="" class="nav-item nav-link">SEO</a>
                    </div>
                </nav>
            </div>
            <div class="col-lg-9">
                <nav class="navbar navbar-expand-lg bg-light navbar-light py-3 py-lg-0 px-0">
                    <a href="" class="text-decoration-none d-block d-lg-none">
                        <h1 class="m-0"><span class="text-primary">E</span>COURSES</h1>
                    </a>
                    <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse justify-content-between" id="navbarCollapse">
                        <div class="navbar-nav py-0">
                            <a href="index.html" class="nav-item nav-link active">Home</a>
                            <a href="about.html" class="nav-item nav-link">About</a>
                            <a href="course.html" class="nav-item nav-link">Courses</a>
                            <a href="teacher.html" class="nav-item nav-link">Teachers</a>
                            <div class="nav-item dropdown">
                                <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">Blog</a>
                                <div class="dropdown-menu rounded-0 m-0">
                                    <a href="blog.html" class="dropdown-item">Blog List</a>
                                    <a href="single.html" class="dropdown-item">Blog Detail</a>
                                </div>
                            </div>
                            <a href="contact.html" class="nav-item nav-link">Contact</a>
                        </div>
                        <a class="btn btn-primary py-2 px-4 ml-auto d-none d-lg-block" href="">Join Now</a>
                    </div>
                </nav>
            </div>
        </div>
    </div>
    <!-- Navbar End -->
    
    <div class="container">
        <div class="video-container">
            <div class="video">
                <!-- Video Embed Here -->
                <video controls width="100%" height="100%">
                    <source src="video.mp4" type="video/mp4">
                    Your browser does not support the video tag.
                </video>
            </div>
            <div class="comments">
                <h2>Comments</h2>
                <textarea rows="5" placeholder="Add your comment..."></textarea>
                <button>Submit</button>
                <!-- List of comments -->
                <div>
                    <p><strong>User1:</strong> This is a comment.</p>
                    <p><strong>User2:</strong> This is another comment.</p>
                </div>
            </div>
        </div>
        <div class="sidebar">
            <div class="section video-list">
                <h3>Video List</h3>
                <ul>
                    <li>
                        <div class="video-item">
                            <span id="toggleBtnV1" onclick="toggleBtn('vic1')" class="video-item-title">Video 1</span>
                            <span id="vic1" style="display: none;" class="video-item-content">Nội dung</span>
                        </div>
                    </li>
                    <li>
                        <div class="video-item">
                            <span id="toggleBtnV2" onclick="toggleBtn('vic2')" class="video-item-title">Video 2</span>
                            <span id="vic2" style="display: none;" class="video-item-content">Nội dung</span>
                        </div>
                    </li>
                    <li>
                        <div class="video-item">
                            <span id="toggleBtnV3" onclick="toggleBtn('vic3')" class="video-item-title">Video 3</span>
                            <span id="vic3" style="display: none;" class="video-item-content">Nội dung</span>
                        </div>
                    </li>
                    <!-- Add more videos as needed -->
                </ul>
            </div>
            <div class="section video-list">
                <h3>Progress</h3>
                <div class="progress-content">
                    <ul>
                        <li><span>Part 1:</span> <span>50%</span></li>
                        <li><span>Part 2:</span> <span>20%</span></li>
                        <li><span>Part 3:</span> <span>Not started</span></li>
                        <!-- Add more parts as needed -->
                    </ul>
                </div>
            </div>            
        </div>
    </div>

    <!-- Bootstrap and necessary libraries -->
    


    <Script src="./js/videoLearn.js"></Script>
