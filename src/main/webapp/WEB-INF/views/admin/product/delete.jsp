<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="utf-8" />
                <meta http-equiv="X-UA-Compatible" content="IE=edge" />
                <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
                <meta name="description" content="Dự án laptopshop" />
                <meta name="author" content="Marc Nguyen" />
                <title>Dashboard - Marc Nguyen</title>
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
                                    <div class="container mt-3">
                                        <a href="/admin/product" class="btn btn-primary">Back to product List</a>
                                        <hr>
                                        <div class="alert alert-danger" role="alert">
                                            Are you sure you want to delete this product?
                                            <form:form action="/admin/product/delete" method="post" modelAttribute="product">
                                                <input type="hidden" name="id" value="${product.id}">
                                                <button type="submit" class="btn btn-danger">Delete</button>
                                            </form:form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </main>
                        <jsp:include page="../layout/footer.jsp" />
                    </div>
                </div>
                 
                <script src="/js/scripts.js"></script>

            </body>

            </html>