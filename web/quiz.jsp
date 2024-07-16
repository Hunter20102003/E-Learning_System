<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

        <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
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

            .reply-input {
                display: flex;
                flex-direction: column;
                margin-top: 10px;
            }

            .reply-input textarea {
                padding: 10px;
                border: 1px solid #ccc;
                border-radius: 5px;
                font-size: 1em;
            }

            .reply-buttons {
                display: flex;
                margin-top: 10px;
            }

            .reply-buttons button {
                padding: 8px 16px; /* Smaller size */
                background-color: #FF6600;
                color: #fff;
                border: none;
                border-radius: 5px;
                cursor: pointer;
                margin-left: 10px;
            }

            .reply-buttons button:hover {
                background-color: #e65c00;
            }
            .timer {
                font-size: 24px;
                font-weight: bold;
                margin-bottom: 20px;
                text-align: center;
                line-height: 1.5;
            }

            .timer span {
                background-color: #ff6600;
                color: white;
                padding: 5px;
                border-radius: 3px;
                margin: 0 2px;
            }

            .question {
                margin-bottom: 30px;
                border: 1px solid #ccc;
                padding: 15px;
                border-radius: 5px;
                background-color: #fff;
            }

            .question h3 {
                margin: 0 0 10px;
                font-size: 1.2em;
            }

            .options {
                list-style-type: none;
                padding: 0;
            }

            .options li {
                margin-bottom: 10px;
            }

            input[type="radio"],
            input[type="checkbox"] {
                display: none;
            }

            input[type="radio"]+label,
            input[type="checkbox"]+label {
                position: relative;
                padding-left: 30px;
                cursor: pointer;
                display: inline-block;
                line-height: 20px;
            }

            input[type="radio"]+label:before,
            input[type="checkbox"]+label:before {
                content: '';
                position: absolute;
                left: 0;
                top: 0;
                width: 20px;
                height: 20px;
                border: 2px solid #000;
                border-radius: 50%;
                background: #fff;
            }

            input[type="checkbox"]+label:before {
                border-radius: 3px;
            }

            input[type="radio"]:checked+label:before,
            input[type="checkbox"]:checked+label:before {
                background: #000;
                border-color: #000;
            }

            input[type="radio"]+label:hover:before,
            input[type="checkbox"]+label:hover:before {
                border-color: #555;
            }

            footer {
                text-align: center;
                margin-top: 20px;
                padding-top: 10px;
                border-top: 1px solid #ccc;
            }
            ul.options {
                list-style-type: none;
                padding: 0;
                margin: 0;
            }
            ul.options li {
                margin-bottom: 10px; /* Add spacing between options if needed */
            }

            /* Align input and label nicely */
            ul.options li input[type="radio"],
            ul.options li input[type="checkbox"] {
                margin-right: 10px; /* Space between input and label */
            }

            /* Style for the question container */
            .question {
                margin-bottom: 20px; /* Add spacing between questions if needed */
            }

            /* Style the question text */
            .question h3 {
                margin-bottom: 10px;
            }
            .submit-button {
                text-align: center;
                margin-top: 20px;
            }

            .submit-button button {
                background-color: #FF6600;
                color: white;
                padding: 10px 20px;
                border: none;
                border-radius: 5px;
                cursor: pointer;
            }

            .submit-button button:hover {
                background-color: #FF6600;
            }
            .percentage {
                color: blue;
            }

        </style>
    </head>

    <body>
        <!-- Navbar Start -->
        <jsp:include page="header.jsp"></jsp:include>
            <!-- Navbar End -->

            <div class="container">
                <div class="video-container">
                    <div class="timer" id="timer">
                    <c:choose>
                        <c:when test="${quiz.quizMinutes > 0}">
                            <span id="hours">00</span>:<span id="minutes">${quiz.quizMinutes}</span>:<span id="seconds">00</span>
                        </c:when>
                    </c:choose>                 </div>

                <form id="quizForm" action="${pageContext.request.contextPath}/course/learning/quiz?quiz_id=${quiz_id}&course_id=${courseId}" method="post">
                    <c:forEach var="l" items="${listQuestions}">
                        <c:if test="${l.typeId == 1}">
                            <div class="question">
                                <h3>${l.questionText}</h3>
                                <ul class="options">
                                    <c:forEach var="a" items="${l.answers_list}">
                                        <li>
                                            <input type="radio" id="q${l.questionId}${a.answerId}" name="q${l.questionId}" value="${a.answerId}">
                                            <label for="q${l.questionId}${a.answerId}">${a.answerText}</label>
                                        </li>
                                    </c:forEach>
                                </ul>
                            </div>
                        </c:if>
                        <c:if test="${l.typeId != 1}">
                            <div class="question">
                                <h3>${l.questionText}</h3>
                                <ul class="options">
                                    <c:forEach var="a" items="${l.answers_list}">
                                        <li>
                                            <input type="checkbox" id="q${l.questionId}${a.answerId}" name="q${l.questionId}" value="${a.answerId}">
                                            <label for="q${l.questionId}${a.answerId}">${a.answerText}</label>
                                        </li>
                                    </c:forEach>
                                </ul>
                            </div>
                        </c:if>
                    </c:forEach>

                    <div class="submit-button">
                        <button type="submit">Submit Quiz</button>
                    </div>
                </form>

            </div>


            <div class="sidebar">
                <div class="section video-list">
                    <h3>Video List</h3>
                    <ul>
                        <c:forEach var="l" items="${listLesson}">
                            <li>
                                <div class="video-item">
                                    <label class="video-item-title" onclick="toggleContent(this)">${l.title}</label>
                                    <div class="video-item-content">
                                        <ul>
                                            <c:forEach var="sl" items="${l.sub_lesson_list}">
                                                <span>${youtobeDuration.convertToMinutesAndSeconds(sl.video_duration)}</span>
                                                <li>
                                                    <a href="/E-Learning_System/course/learning?a=sub&course_id=${courseId}&sub_lesson_id=${sl.id}">${sl.title}</a>
                                                </li>
                                            </c:forEach>
                                            <c:forEach var="q" items="${l.quiz_lesson_list}"> 
                                                <li>
                                                    <a href="/E-Learning_System/course/learning?a=quiz&course_id=${courseId}&quiz_id=${q.quizId}">${q.quizName}</a> 
                                                </li> 
                                            </c:forEach>
                                        </ul>

                                    </div>
                                </div>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
                <div class="section video-list">
                    <h3>Progress</h3>
                    <div class="progress-content">
                        <c:choose>
                            <c:when test="${userProgress != null}">
                                <c:set var="progress" value="${userProgress.progress}" />
                            </c:when>
                            <c:otherwise>
                                <c:set var="progress" value="0" />
                            </c:otherwise>
                        </c:choose>
                        <ul>
                            <li><span>${course.name}</span>
                                <span class="percentage">${progress}%</span>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>  

        <script>
            // Function to save selected answers into session storage
            function saveSelections() {
                // Select all input elements of type radio or checkbox within the form
                document.querySelectorAll('input[type=radio], input[type=checkbox]').forEach((input) => {
                    if (input.type === 'radio') {
                        if (input.checked) {
                            sessionStorage.setItem(input.name, input.value);
                        }
                    } else if (input.type === 'checkbox') {
                        // For checkboxes, store an array of selected values
                        let selectedValues = JSON.parse(sessionStorage.getItem(input.name)) || [];
                        if (input.checked) {
                            selectedValues.push(input.value);
                        } else {
                            selectedValues = selectedValues.filter(value => value !== input.value);
                        }
                        sessionStorage.setItem(input.name, JSON.stringify(selectedValues));
                    }
                });
            }

            // Function to load saved selections from session storage
            function loadSelections() {
                // Select all input elements of type radio or checkbox within the form
                document.querySelectorAll('input[type=radio], input[type=checkbox]').forEach((input) => {
                    if (input.type === 'radio') {
                        const savedValue = sessionStorage.getItem(input.name);
                        if (savedValue !== null && savedValue === input.value) {
                            input.checked = true;
                        }
                    } else if (input.type === 'checkbox') {
                        const savedValues = JSON.parse(sessionStorage.getItem(input.name)) || [];
                        if (savedValues.includes(input.value)) {
                            input.checked = true;
                        }
                    }
                });
            }

            // Timer-related code
            let hoursSpan = document.getElementById('hours');
            let minutesSpan = document.getElementById('minutes');
            let secondsSpan = document.getElementById('seconds');

            // Retrieve the stored time left or initialize with the quiz duration
            let quizMinutes = ${quiz.quizMinutes};
            let timeLeft = sessionStorage.getItem('timeLeft') ? parseInt(sessionStorage.getItem('timeLeft')) : quizMinutes * 60;

            function updateTimer() {
                let hours = Math.floor(timeLeft / 3600);
                let minutes = Math.floor((timeLeft % 3600) / 60);
                let seconds = timeLeft % 60;

                hoursSpan.textContent = hours < 10 ? '0' + hours : hours;
                minutesSpan.textContent = minutes < 10 ? '0' + minutes : minutes;
                secondsSpan.textContent = seconds < 10 ? '0' + seconds : seconds;

                if (timeLeft > 0) {
                    timeLeft--;
                    sessionStorage.setItem('timeLeft', timeLeft);  // Save the time left to session storage
                    setTimeout(updateTimer, 1000);
                } else {
                    sessionStorage.removeItem('timeLeft');  // Remove the item when time is up
                    document.getElementById('quizForm').submit();
                }
            }

            document.addEventListener('DOMContentLoaded', () => {
                loadSelections(); // Load saved selections when the page loads
                updateTimer();

                // Save selections when any radio or checkbox changes
                document.querySelectorAll('input[type=radio], input[type=checkbox]').forEach((input) => {
                    input.addEventListener('change', saveSelections);
                });

                // Optionally, you might want to clear session storage when the form is reset
                document.getElementById('quizForm').addEventListener('reset', () => {
                    sessionStorage.clear();
                });

                // Warn the user before leaving the page if the timer is still running
                window.addEventListener('beforeunload', (event) => {
                    if (timeLeft > 0) {
                        event.preventDefault();
                        event.returnValue = 'You have an ongoing quiz. Are you sure you want to leave?';
                    }
                });

                // Handle link clicks
                document.querySelectorAll('a').forEach((link) => {
                    link.addEventListener('click', (event) => {
                        if (timeLeft > 0) {
                            event.preventDefault(); // Prevent default link navigation
                            if (confirm('You have an ongoing quiz. Do you want to submit the quiz before leaving?')) {
                                document.getElementById('quizForm').submit(); // Submit the quiz form
                            }
                        }
                    });
                });
            });
        </script>


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