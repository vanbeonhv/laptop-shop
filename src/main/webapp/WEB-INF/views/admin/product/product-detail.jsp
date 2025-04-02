<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="utf-8" />
            <meta http-equiv="X-UA-Compatible" content="IE=edge" />
            <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
            <meta name="description" content="Dự án laptopshop" />
            <meta name="author" content="Marc Nguyen" />
            <title>Detail - Marc Nguyen</title>
            <link href="/css/styles.css" rel="stylesheet" />
            <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
        </head>

        <body class="sb-nav-fixed">
            <jsp:include page="../layout/header.jsp" />
            <div id="layoutSidenav">
                <jsp:include page="../layout/sidebar.jsp" />
                <div id="layoutSidenav_content">
                    <main>
                        <div class="container-fluid px-4">
                            <h1 class="mt-4">Manage product</h1>
                            <!-- <ol class="breadcrumb mb-4">
                                <li class="breadcrumb-item active">Dashboard</li>
                            </ol> -->

                            <!-- Main content -->
                            <div class="container mt-3">
                                <a href="/admin/product" class="btn btn-primary">Back to Product List</a>
                                <hr>
                                <div class="card w-50">
                                    <img class="card-img-top" src="/img/product/${product.image}">

                                    <div class="card-header">
                                        Product information
                                    </div>
                                    <ul class="list-group list-group-flush">
                                        <li class="list-group-item">Id - ${product.id}</li>
                                        <li class="list-group-item">price - ${product.price}</li>
                                        <li class="list-group-item">detailDesc - ${product.detailDesc}</li>
                                        <li class="list-group-item">shortDesc - ${product.shortDesc}</li>
                                        <li class="list-group-item">quantity - ${product.quantity}</li>
                                        <li class="list-group-item">sold - ${product.sold}</li>
                                        <li class="list-group-item">factory - ${product.factory}</li>
                                        <li class="list-group-item">target - ${product.target}</li>
                                    </ul>
                                </div>

                            </div>
                        </div>
                    </main>
                    <jsp:include page="../layout/footer.jsp" />
                </div>
            </div>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
                crossorigin="anonymous"></script>
            <script src="/js/scripts.js"></script>

        </body>

        </html>