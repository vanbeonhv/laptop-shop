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
                                <h1 class="mt-4">Manage user</h1>
                                <!-- <ol class="breadcrumb mb-4">
                                    <li class="breadcrumb-item active">Dashboard</li>
                                </ol> -->

                                <!-- Main content -->
                                <div class="container mt-3">
                                    <a href="/admin/user" class="btn btn-primary">Back to User List</a>
                                    <hr>

                                    <div class="row">
                                        <div class="col-12 col-md-6 mx-auto">
                                            <h2 class="display-4">Update user</h2>
                                            <form:form method="POST" action="/admin/user/${user.id}"
                                                modelAttribute="user">
                                                <div class="mb-3 d-none">
                                                    <form:label path="id" class="form-label">Id</form:label>
                                                    <form:input type="id" class="form-control" path="id" />
                                                </div>
                                                <div class="mb-3">
                                                    <form:label path="email" class="form-label">Email address
                                                    </form:label>
                                                    <form:input type="email" class="form-control" path="email"
                                                        aria-describedby="emailHelp" disabled="true" />
                                                </div>

                                                <div class="mb-3">
                                                    <form:label path="fullName" class="form-label">Fullname</form:label>
                                                    <form:input class="form-control" path="fullName" />
                                                </div>
                                                <div class="mb-3">
                                                    <form:label path="address" class="form-label">Address</form:label>
                                                    <form:input type="text" class="form-control" path="address" />
                                                </div>
                                                <div class="mb-3">
                                                    <form:label path="phone" class="form-label">Phone</form:label>
                                                    <form:input class="form-control" path="phone" />
                                                </div>

                                                <button type="submit" class="btn btn-primary">Submit</button>
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