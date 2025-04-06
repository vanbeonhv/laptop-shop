# Laptop Shop

## Tổng quan
Laptop Shop là một ứng dụng web dựa trên Spring Boot được thiết kế để quản lý cửa hàng laptop. Ứng dụng cung cấp các tính năng quản lý sản phẩm, người dùng và giỏ hàng, bao gồm tạo mới, cập nhật, xóa sản phẩm và xác thực người dùng.

## Homepage Screenshots
![Homepage Screenshot 1](readme-assets/homepage-1.png "Homepage Screenshot 1")
![Homepage Screenshot 2](readme-assets/homepage-2.png "Homepage Screenshot 2")

## Tính năng
- Quản lý sản phẩm (CRUD operations)
- Quản lý người dùng với vai trò và xác thực
- Xử lý file cho hình ảnh sản phẩm và avatar người dùng
- Quản lý giỏ hàng cho các giao dịch mua của người dùng

## Cấu trúc dự án
```
laptop-shop/
├── src/
│   ├── main/
│   │   ├── java/com/techstore/laptop_shop/
│   │   │   ├── controller/       # Controllers để xử lý các yêu cầu HTTP
│   │   │   ├── domain/           # Entity classes cho các mô hình cơ sở dữ liệu
│   │   │   ├── repository/       # Repositories để tương tác với cơ sở dữ liệu
│   │   │   ├── service/          # Business logic và service classes
│   │   └── resources/
│   │       ├── static/           # Static assets (CSS, JS, hình ảnh)
│   │       ├── templates/        # Thymeleaf templates cho giao diện
│   │       └── application.properties # Cấu hình ứng dụng
├── pom.xml                        # Maven dependencies và cấu hình build
└── .gitignore                     # Các file và thư mục bị bỏ qua
```

## Công nghệ sử dụng
- ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?style=flat&logo=spring-boot&logoColor=white) Spring Boot (Web, Security, Data JPA, Validation)
- ![PostgreSQL](https://img.shields.io/badge/PostgreSQL-336791?style=flat&logo=postgresql&logoColor=white) PostgreSQL (Cơ sở dữ liệu)
- ![Supabase](https://img.shields.io/badge/Supabase-3ECF8E?style=flat&logo=supabase&logoColor=white) Supabase (Deploy cơ sở dữ liệu)
- ![Thymeleaf](https://img.shields.io/badge/Thymeleaf-005F0F?style=flat&logo=thymeleaf&logoColor=white) Thymeleaf (Template engine)
- ![Maven](https://img.shields.io/badge/Maven-C71A36?style=flat&logo=apache-maven&logoColor=white) Maven (Công cụ build)


## Database Schema
![Database Schema](readme-assets/db.png "Database Schema")

## Admin Screenshots
![Admin Screenshot 1](readme-assets/admin-1.png "Admin Screenshot 1")
![Admin Screenshot 2](readme-assets/admin-2.png "Admin Screenshot 2")

## Order Screenshots
![Order Screenshot 1](readme-assets/order-1.png "Order Screenshot 1")
![Order Screenshot 2](readme-assets/order-2.png "Order Screenshot 2")
![Order Screenshot 3](readme-assets/order-3.png "Order Screenshot 3")