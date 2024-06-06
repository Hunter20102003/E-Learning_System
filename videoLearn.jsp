<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Learning Page</title>
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

        .lesson-info {
            margin-top: 20px;
            background-color: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }

        .lesson-info h1 {
            font-size: 2em;
            margin-bottom: 10px;
        }

        .lesson-info p {
            font-size: 1em;
            color: #555;
        }

        .comments {
            background-color: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }

        .comments h2 {
            font-size: 1.5em;
            margin-bottom: 10px;
        }

        .comment-input {
            display: flex;
            align-items: flex-start;
            margin-bottom: 20px;
        }

        .comment-input img.avatar {
            width: 40px;
            height: 40px;
            border-radius: 50%;
            margin-right: 10px;
        }

        .comment-input textarea {
            flex-grow: 1;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 1em;
        }

        .comment-input button {
            margin-left: 10px;
            padding: 10px 20px;
            background-color: #FF6600;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        .comment-input button:hover {
            background-color: #e65c00;
        }

        .comment-list {
            margin-top: 20px;
        }

        .comment {
            display: flex;
            align-items: flex-start;
            margin-bottom: 20px;
            position: relative;
        }

        .comment img.avatar {
            width: 40px;
            height: 40px;
            border-radius: 50%;
            margin-right: 10px;
        }

        .comment-content {
            background-color: #f1f1f1;
            padding: 10px;
            border-radius: 5px;
            flex-grow: 1;
        }

        .comment-content p {
            margin: 5px 0;
        }

        .comment-actions {
            display: flex;
            gap: 10px;
            font-size: 0.9em;
            color: #555;
        }

        .comment-actions span {
            cursor: pointer;
        }

        .comment-actions span:hover {
            text-decoration: underline;
        }

        .timestamp {
            font-size: 0.8em;
            color: #888;
        }

        .comment-menu {
            position: absolute;
            right: 0;
            top: 10px;
        }

        .comment-menu-button {
            cursor: pointer;
            font-size: 1.5em;
            padding: 5px;
        }

        .comment-menu-content {
            display: none;
            position: absolute;
            right: 0;
            top: 20px;
            background-color: #fff;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            z-index: 10;
        }

        .comment-dropdown {
            padding: 5px;
            border: none;
            background: transparent;
            cursor: pointer;
            font-size: 1em;
        }

        .comment-menu-button:hover+.comment-menu-content,
        .comment-menu-content:hover {
            display: block;
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
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
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
            max-height: 200px;
            overflow-y: auto;
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
            border-bottom: none;
        }

        .video-item {
            display: flex;
            flex-direction: column;
        }

        .video-item .video-item-title {
            font-weight: 500;
            cursor: pointer;
        }

        .video-item-content {
            display: none;
        }

        .video-item-content.active {
            display: block;
        }

        .fa-check-circle {
            color: green;
        }
    </style>
</head>

<body>
    <!-- Navbar Start -->
    <div class="container-fluid">
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
                        <div class="dropdown ml-auto d-none d-lg-block">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <img src="img/avatar.png" alt="User Avatar" class="rounded-circle" style="width: 40px; height: 40px;">
                            </a>
                            <div class="dropdown-menu dropdown-menu-right">
                                <a href="#" class="dropdown-item"><i style="margin-right: 5px;" class="fas fa-user-alt"></i>Profile </a>
                                <a href="#" class="dropdown-item"><i style="margin-right: 5px;" class="fas fa-sign-out-alt"></i>Logout</a>
                            </div>
                        </div>
                    </div>
                </nav>
            </div>
        </div>
    </div>
    <!-- Navbar End -->

    <div class="container">
        <div class="video-container">
            <div class="video">
                <video controls width="100%" height="100%">
                    <source src="video.mp4" type="video/mp4">
                    Your browser does not support the video tag.
                </video>
            </div>
            <div class="lesson-navigation-button" style="display: flex; justify-content: center; margin-top: 20px;">
                <button class="previous-button"
                    style="border-style: solid; border-color: #FF6600; border-width: 1px; margin: 0 10px; background-color: #FF6600; color: white;">
                    <i class="fas fa-chevron-left"></i> Previous lesson
                </button>
                <button class="next-button"
                    style="border-style: solid; border-color: #FF6600; border-width: 1px; margin: 0 10px; background-color: #FF6600; color: white;">
                    Next lesson <i class="fas fa-chevron-right"></i>
                </button>
            </div>
            <div class="lesson-info">
                <h1>Lesson Title</h1>
                <p>This is a description of the lesson. It provides an overview of what will be covered in the lesson.</p>
            </div>
            <div class="comments">
                <h2>Comments</h2>
                <div class="comment-input">
                    <img src="img/user-avatar.png" alt="User Avatar" class="avatar">
                    <textarea rows="1" placeholder="Add a comment..."></textarea>
                    <button>Submit</button>
                </div>
                <div class="comment-list">
                    <div class="comment">
                        <img src="img/user1-avatar.png" alt="User1 Avatar" class="avatar">
                        <div class="comment-content">
                            <p><strong>User1</strong> <span class="timestamp">2 hours ago</span></p>
                            <p>This is a comment.</p>
                            <div class="comment-actions">
                                <span>Like</span>
                                <span>Reply</span>
                            </div>
                        </div>
                        <div class="comment-menu">
                            <span class="comment-menu-button" onclick="toggleMenu(this)">...</span>
                            <div class="comment-menu-content">
                                <select class="comment-dropdown">
                                    <option value="delete">Delete</option>
                                    <option value="report">Report</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="comment">
                        <img src="img/user2-avatar.png" alt="User2 Avatar" class="avatar">
                        <div class="comment-content">
                            <p><strong>User2</strong> <span class="timestamp">1 hour ago</span></p>
                            <p>This is another comment.</p>
                            <div class="comment-actions">
                                <span>Like</span>
                                <span>Reply</span>
                            </div>
                        </div>
                        <div class="comment-menu">
                            <span class="comment-menu-button" onclick="toggleMenu(this)">...</span>
                            <div class="comment-menu-content">
                                <select class="comment-dropdown">
                                    <option value="delete">Delete</option>
                                    <option value="report">Report</option>
                                </select>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <script>
                function toggleMenu(button) {
                    const menuContent = button.nextElementSibling;
                    if (menuContent.style.display === "block") {
                        menuContent.style.display = "none";
                    } else {
                        menuContent.style.display = "block";
                    }
                }

                window.onclick = function (event) {
                    if (!event.target.matches('.comment-menu-button')) {
                        const dropdowns = document.getElementsByClassName("comment-menu-content");
                        for (let i = 0; i < dropdowns.length; i++) {
                            const openDropdown = dropdowns[i];
                            if (openDropdown.style.display === "block") {
                                openDropdown.style.display = "none";
                            }
                        }
                    }
                }
            </script>
        </div>
        <div class="sidebar">
            <div class="section video-list">
                <h3>Video List</h3>
                <ul>
                    <li>
                        <div class="video-item">
                            <label class="video-item-title" onclick="toggleContent(this)">Giới Thiệu</label>
                            <div class="video-item-content">
                                <ul>
                                    <li>Bài học 1: Ứng dụng của javaservlet <i class="far fa-check-circle"></i></li>
                                    <li>Bài học 2: kết nối sql vào javaservlet <i class="far fa-check-circle"></i></li>
                                    <li>Bài học 3: sử dụng sql server để thực hành <i class="fas fa-lock"></i></li>
                                </ul>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="video-item">
                            <label class="video-item-title" onclick="toggleContent(this)">Java servlet</label>
                            <div class="video-item-content">
                                <ul>
                                    <li>Bài học 4: Ứng dụng của javaservlet <i class="far fa-check-circle"></i></li>
                                    <li>Bài học 5: kết nối sql vào javaservlet <i class="far fa-check-circle"></i></li>
                                    <li>Bài học 6: sử dụng sql server để thực hành <i class="fas fa-lock"></i></li>
                                </ul>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="video-item">
                            <label class="video-item-title" onclick="toggleContent(this)">Java jsp</label>
                            <div class="video-item-content">
                                <ul>
                                    <li>Bài học 7: Ứng dụng của javaservlet <i class="far fa-check-circle"></i></li>
                                    <li>Bài học 8: kết nối sql vào javaservlet <i class="far fa-check-circle"></i></li>
                                    <li>Bài học 9: sử dụng sql server để thực hành <i class="fas fa-lock"></i></li>
                                    <li>Bài học 10: sử dụng sql server để thực hành <i class="fas fa-lock"></i></li>
                                </ul>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="video-item">
                            <label class="video-item-title" onclick="toggleContent(this)">Java script</label>
                            <div class="video-item-content">
                                <ul>
                                    <li>Bài học 11: Ứng dụng của javaservlet <i class="far fa-check-circle"></i></li>
                                    <li>Bài học 12: kết nối sql vào javaservlet <i class="far fa-check-circle"></i></li>
                                    <li>Bài học 13: sử dụng sql server để thực hành <i class="fas fa-lock"></i></li>
                                </ul>
                            </div>
                        </div>
                    </li>
                </ul>
            </div>
            <div class="section video-list">
                <h3>Progress</h3>
                <div class="progress-content">
                    <ul>
                        <li><span>Part 1:</span> <span>50%</span></li>
                        <li><span>Part 2:</span> <span>20%</span></li>
                        <li><span>Part 3:</span> <span>Not started</span></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>

    <script>
        function toggleContent(label) {
            const content = label.nextElementSibling;
            if (content.classList.contains('active')) {
                content.classList.remove('active');
            } else {
                content.classList.add('active');
            }
        }
    </script>

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
</body>

</html>
