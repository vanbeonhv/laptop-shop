<%@page contentType="text/html" pageEncoding="UTF-8" %>

    <html lang="en">

    <head>
        <meta charset="utf-8">
        <title> Giỏ hàng - Laptopshop</title>
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="" name="keywords">
        <meta content="" name="description">

        <!-- Google Web Fonts -->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link
            href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600&family=Raleway:wght@600;800&display=swap"
            rel="stylesheet">

        <!-- Icon Font Stylesheet -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

        <!-- Libraries Stylesheet -->
        <link href="/client/lib/lightbox/css/lightbox.min.css" rel="stylesheet">
        <link href="/client/lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">


        <!-- Customized Bootstrap Stylesheet -->
        <link href="/client/css/bootstrap.min.css" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous" />

        <!-- Template Stylesheet -->
        <link href="/client/css/style.css" rel="stylesheet">
    </head>

    <body>
        <jsp:include page="../layout/header.jsp" />

        <div class="container mt-5">
            <div class="row">
                <div class="col-12 mt-5 ">

                    <div class="alert alert-success" role="alert">
                        Cảm ơn bạn đã đặt hàng. Đơn hàng đã xác nhận thành công
                    </div>
                </div>
            </div>
        </div>

        <jsp:include page="../layout/feature.jsp" />
        <jsp:include page="../layout/footer.jsp" />
    </body>

    </html>