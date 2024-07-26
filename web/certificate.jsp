<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="Model.UserDBO" %>
<%@ page import="Model.CourseDBO" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Certificate of Completion</title>
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

        <!-- Custom CSS -->
        <style>
            .certificate-body {
                font-family: 'Poppins', sans-serif;
                margin: 0;
                padding: 0;
                display: flex;
                flex-direction: column;
                justify-content: center;
                align-items: center;
                height: 100vh;
                background-color: #f3efef;
            }

            .certificate-header, .certificate-footer {
                width: 100%;
                padding: 20px 0;
                background-color: #f8f8f8;
                text-align: center;
                box-shadow: 0 2px 5px rgba(0,0,0,0.1);
            }

            .certificate-header h1, .certificate-footer p {
                margin: 0;
                color: #333;
            }

            .certificate-container {
                width: 80%;
                max-width: 800px;
                padding: 40px;
                border-radius: 10px;
                box-shadow: 0 2px 5px rgba(0,0,0,0.1);
                text-align: center;
                background-color: rgba(255, 255, 255, 0.9);
                background: url('./img/Certificate.png') no-repeat center center/cover;
            }

            .certificate-container h1 {
                font-size: 2.5em;
                margin-bottom: 20px;
                color: #333;
            }

            .certificate-container p {
                font-size: 1.2em;
                margin: 10px 0;
                color: #555;
            }

            .certificate-container .certificate-details {
                margin-top: 30px;
            }

            .certificate-container .certificate-details p {
                font-size: 1.1em;
            }

            .certificate-container .signature {
                margin-top: 40px;
                display: flex;
                justify-content: space-between;
                align-items: center;
            }

            .certificate-container .signature .signature-name {
                text-align: left;
            }

            .certificate-container .signature .signature-name p {
                margin: 5px 0;
            }

            .certificate-container .signature img {
                max-width: 150px;
            }

            .actions {
                margin-top: 20px;
            }

            .actions a {
                margin: 0 10px;
                text-decoration: none;
                color: #007BFF;
                font-weight: 600;
            }

        </style>
    </head>
    <body>


        <div class="certificate-body">
            <!-- Certificate Container Start -->
            <div class="certificate-container" id="certificate">
                <h1 style="margin-top: 80px;">Certificate of Completion</h1>
                <p>This is to certify that</p>
                <p><strong><%= ((UserDBO) request.getAttribute("user")).getFirstName() %> <%= ((UserDBO) request.getAttribute("user")).getLastName() %></strong></p>
                <p>has successfully completed the course</p>
                <p><strong><%= ((CourseDBO) request.getAttribute("course")).getTitle() %></strong></p>
                <div class="certificate-name">
                    <p>Course name: <%= ((CourseDBO) request.getAttribute("course")).getName() %></p>
                </div>
                <div class="certificate-details">
                    <p>Date: <%= ((CourseDBO) request.getAttribute("course")).getCreated_at() %></p>
                </div>
                <div class="signature" style=" display: flex; justify-content: flex-end; padding-bottom: 50px;">
                    <div class="CertificateofParticipation-image">
                        <img src="./img/CertificateofParticipation.png" alt="Certificate of Participation">
                    </div>
                </div>
            </div>
            <!-- Certificate Container End -->

            <!-- Actions Start -->
            <div class="actions">
                <a href="#" onclick="exportPDF()">Export as PDF</a>
            </div>
            <!-- Actions End -->

        </div>


        <!-- html2pdf.js Library -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/html2pdf.js/0.9.2/html2pdf.bundle.min.js"></script>
        <script>

            function exportPDF() {
                const element = document.getElementById('certificate');
                html2pdf(element, {
                    margin: 1,
                    filename: 'certificate.pdf',
                    image: {type: 'jpeg', quality: 0.98},
                    html2canvas: {scale: 2},
                    jsPDF: {unit: 'in', format: 'letter', orientation: 'portrait'}
                });
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
        <script src="./js/scripts.js"></script>
    </body>
</html>
