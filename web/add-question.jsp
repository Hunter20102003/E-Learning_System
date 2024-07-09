<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add/Edit Question</title>
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
        .btn-success {
            color: #fff;
            background-color: #ff6600;
            border-color: #ff6600;
        }
        .btn-success:hover {
            background-color: #ff8800;
            border-color: #ff6600;
        }
        .btn-primary {
            color: #fff;
            background-color: #ff6600;
            border-color: #ff6600;
        }
        .btn-primary:hover {
            background-color: #ff8800;
            border-color: #ff6600;
        }
        .btn-danger {
            color: #fff;
            background-color: #dc3545;
            border-color: #dc3545;
        }
        .btn-danger:hover {
            background-color: #c82333;
            border-color: #bd2130;
        }
    </style>
</head>
<body>

     <!-- Topbar Start -->
     <div class="container-fluid d-none d-lg-block">
        <div class="row align-items-center py-4 px-xl-5">
            <div class="col-lg-3">
                <a href="" class="text-decoration-none">
                    <h1 class="m-0"><span class="text-primary">E</span>COURSES</h1>
                </a>
            </div>
            <div class="col-lg-3 text-right">
                <div class="d-inline-flex align-items-center">
                    <i class="fa fa-2x fa-map-marker-alt text-primary mr-3"></i>
                    <div class="text-left">
                        <h6 class="font-weight-semi-bold mb-1">Our Office</h6>
                        <small>123 Street, New York, USA</small>
                    </div>
                </div>
            </div>
            <div class="col-lg-3 text-right">
                <div class="d-inline-flex align-items-center">
                    <i class="fa fa-2x fa-envelope text-primary mr-3"></i>
                    <div class="text-left">
                        <h6 class="font-weight-semi-bold mb-1">Email Us</h6>
                        <small>info@example.com</small>
                    </div>
                </div>
            </div>
            <div class="col-lg-3 text-right">
                <div class="d-inline-flex align-items-center">
                    <i class="fa fa-2x fa-phone text-primary mr-3"></i>
                    <div class="text-left">
                        <h6 class="font-weight-semi-bold mb-1">Call Us</h6>
                        <small>+012 345 6789</small>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Topbar End -->


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
                        <a class="btn btn-primary py-2 px-4 ml-auto d-none d-lg-block" href="">Join Now</a>
                    </div>
                </nav>
            </div>
        </div>
    </div>
    <!-- Navbar End -->

    <div class="container">
        <div class="card mt-5">
            <div class="card-header bg-primary" style="background-color: #ff6600;">
                <h5 class="card-title">Add/Edit Question</h5>
            </div>
            <div class="card-body">
                <form action="#">
                    <div class="form-group row">
                        <label for="question-title" class="col-form-label col-md-3">Title:</label>
                        <div class="col-md-9">
                            <input type="text" class="form-control" id="question-title" >
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="question-type" class="col-form-label col-md-3">Type:</label>
                        <div class="col-md-4">
                            <select class="custom-control custom-select form-control" id="question-type">
                                <option value="1">Input</option>
                                <option value="2">Textarea</option>
                                <option value="3">Checkbox</option>
                                <option value="4">Radio</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-form-label col-md-3">Answers:</label>
                        <div class="col-md-9">
                            <a href="#" class="btn btn-default" id="add-answer-btn"><i class="material-icons">add</i> Add Answer</a>
                        </div>
                    </div>
                    <div id="answers-container" class="form-group row"></div>
                    <div class="form-group row">
                        <label for="" class="col-form-label col-md-3">Question Score:</label>
                        <div class="col-md-4">
                            <input id="touch-spin-2" data-toggle="touch-spin" data-min="0" data-max="100"
                                data-step="5" type="text" value="50" name="demo2" class="form-control" />
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="col-md-3 text-center">
                            <button type="button" class="btn btn-primary" id="save-question-btn">Save Question</button>
                            <button type="button" class="btn btn-default" id="cancel-btn">Cancel</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <!-- jQuery and Bootstrap scripts -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>

    <!-- Template Javascript -->
    <script src="js/main.js"></script>

    <script>
        document.addEventListener('DOMContentLoaded', function () {
            const addAnswerBtn = document.getElementById('add-answer-btn');
            const answersContainer = document.getElementById('answers-container');
            const questionTypeSelect = document.getElementById('question-type');
            let currentQuestionType = questionTypeSelect.value;
            
            questionTypeSelect.addEventListener('change', function () {
                const selectedType = this.value;
                const answers = answersContainer.querySelectorAll('.answer-input');
                
                if (selectedType == '4' && answers.length > 0 && currentQuestionType == '3') {
                    alert('Cannot change to Radio type because answers already exist for Checkbox type.');
                    this.value = currentQuestionType;
                    return;
                }
                
                if (selectedType == '4') {
                    addAnswerBtn.style.display = 'none';
                } else {
                    addAnswerBtn.style.display = 'inline-block';
                }
                
                currentQuestionType = selectedType;
            });
            
            addAnswerBtn.addEventListener('click', function (e) {
                e.preventDefault();

                let answerHTML = '';

                if (currentQuestionType === '3') {
                    answerHTML = `
                    <div class="col-md-12 input-group mb-3">
                        <div class="input-group-prepend">
                            <div class="input-group-text">
                                <input type="checkbox">
                            </div>
                        </div>
                        <input type="text" class="form-control answer-input">
                        <div class="input-group-append">
                            <a style="color: white; background-color: #FF6600;" class="btn btn-danger delete-answer-btn"><i class="fas fa-trash"></i></a>
                        </div>
                    </div>`;
                } else {
                    answerHTML = `
                    <div class="col-md-12 input-group mb-3">
                        <div class="input-group-prepend">
                                <div class="input-group-text">
                                    <input type="checkbox" aria-label="Checkbox for following text input">
                                </div>
                            </div>
                        <input type="text" class="form-control answer-input">
                        <div class="input-group-append">
                            <a style="color: white; background-color: #FF6600;" class="btn btn-danger delete-answer-btn"><i class="fas fa-trash"></i></a>
                        </div>
                    </div>`;
                }

                answersContainer.insertAdjacentHTML('beforeend', answerHTML);
                
                // Attach delete event listener to the new delete button
                const deleteBtns = answersContainer.getElementsByClassName('delete-answer-btn');
                const latestDeleteBtn = deleteBtns[deleteBtns.length - 1];
                latestDeleteBtn.addEventListener('click', function () {
                    this.closest('.input-group').remove();
                });
            });
        });
    </script>
</body>
</html>
