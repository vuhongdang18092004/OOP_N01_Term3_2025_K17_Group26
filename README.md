# OOP_N01_Term3_2025_K17_Group6

## **PHẦN MỀM QUẢN LÝ LỊCH KHÁM VÀ XE CỨU THƯƠNG**

**Group 6 members:**
1. Vũ Hồng Đăng  
   *Github: vuhongdang18092004*  
2. Đỗ Thị Mỹ Hạnh  
   *Github: MyHanh23*  
3. Nguyễn Văn Hiếu  
   *Github: NguyenHieu-class* 
4. Nguyễn Lệ Thu  
   *Github: nglthu*

# 📋 Hospital Management System

## 🚀 Giới thiệu
Dự án **Hệ thống Quản lý Bệnh viện** hỗ trợ các nghiệp vụ quản lý khoa, phòng, bác sĩ, bệnh nhân, lịch khám, lịch sử khám.  
Hệ thống phân quyền người dùng: **Admin**, **Bác sĩ**, **Bệnh nhân** với các chức năng quản lý và thao tác linh hoạt.

---

## 🎥 Demo
![Demo Giao diện](link-ảnh-demo)

[👉 Xem video demo tại đây](link-video-demo)

---

## 🖼️ Giao diện hệ thống

### Trang đăng nhập
![Login Page](link-ảnh)

### Giao diện Admin
![Admin Page](link-ảnh)

### Giao diện Bác sĩ
![Doctor Page](link-ảnh)

### Giao diện Bệnh nhân
![Patient Page](link-ảnh)

---

## 🛠️ Tính năng chính

### ✅ Admin
- Đăng nhập hệ thống
- Quản lý khoa (thêm, sửa, xóa)
- Quản lý phòng (thêm, sửa, xóa)
- Quản lý bác sĩ (thêm, sửa, xóa)
- Quản lý bệnh nhân (thêm, sửa, xóa)
- Quản lý lịch khám (thêm, hủy, cập nhật)
- Tìm kiếm bệnh nhân, bác sĩ

### ✅ Bác sĩ
- Đăng nhập hệ thống
- Xem lịch khám cá nhân
- Cập nhật lịch sử khám bệnh
- Tìm kiếm bệnh nhân

### ✅ Bệnh nhân
- Đăng nhập hệ thống
- Đặt lịch khám
- Kiểm tra lịch khám sắp tới
- Hủy lịch khám
- Tìm kiếm bác sĩ

---

## 🗂️ Mô hình hệ thống
- UML Use Case Diagram
- UML Class Diagram tổng quát
- UML Sequence Diagram cho từng chức năng
- UML Activity Diagram tổng quan và chi tiết
- Entity Relationship Diagram (ERD)

## 📊 Các sơ đồ chi tiết
- [Use Case Diagram]
  ![Editor _ Mermaid Chart-2025-07-01-041722](https://github.com/user-attachments/assets/1d7a1d82-94a9-42da-82eb-fd606ce69721)

- [Class Diagram]
  ![SĐL TQ](https://github.com/user-attachments/assets/b07a8136-f615-49d1-afee-76d731194d39)

- [Activity Diagram]
  ![AD TQ](https://github.com/user-attachments/assets/93c9f5b8-fd58-4290-a3c9-d2003ef97283)

- [Sequence Diagram]
  ![biểu đồ tuần tự tổng quát](https://github.com/user-attachments/assets/367e9b1d-74e9-465e-bbdf-5e76d117f12b)

- [ERD (Sơ đồ quan hệ cơ sở dữ liệu)]
  ![Editor _ Mermaid Chart-2025-07-01-033912](https://github.com/user-attachments/assets/5fa9edff-75bf-4169-a11b-d38fe4eda27a)


---

## 💾 Công nghệ sử dụng
- Ngôn ngữ: Java
- Framework: Spring Boot
- Database: MySQL / SQL Server
- ORM: Spring Data JPA
- Template Engine: Thymeleaf 
- Công cụ thiết kế UML: PlantUML, StarUML
- IDE: IntelliJ IDEA / Eclipse

---

## 📌 Yêu cầu hệ thống
- Java JDK 8 trở lên
- MySQL / SQL Server
- PlantUML để đọc sơ đồ

---

## 🧑‍💻 Hướng dẫn cài đặt
```bash
git clone https://github.com/ten_cua_cau/hospital-management.git
cd hospital-management
Mở project bằng IntelliJ IDEA hoặc Eclipse
Cấu hình kết nối cơ sở dữ liệu trong file config
Chạy ứng dụng

---

## 📝 Hướng dẫn sử dụng

### Đăng nhập
- Tài khoản Admin: `admin` / `123456`
- Tài khoản Bác sĩ: `bacsi` / `123456`
- Tài khoản Bệnh nhân: `benhnhan` / `123456`

---

### Admin
- Quản lý khoa: Thêm, sửa, xóa
- Quản lý phòng: Thêm, sửa, xóa
- Quản lý bác sĩ: Thêm, sửa, xóa
- Quản lý bệnh nhân: Thêm, sửa, xóa
- Quản lý lịch khám: Thêm, hủy, cập nhật
- Tìm kiếm thông tin: Bệnh nhân, bác sĩ, lịch khám

---

### Bác sĩ
- Xem lịch khám cá nhân
- Cập nhật lịch sử khám bệnh
- Tìm kiếm thông tin bệnh nhân

---

### Bệnh nhân
- Đặt lịch khám
- Xem lịch khám cá nhân
- Hủy lịch khám
- Tìm kiếm bác sĩ

---

## 🎯 Phân quyền người dùng

| Chức năng                 | Admin | Bác sĩ | Bệnh nhân |
|---------------------------|-------|--------|-----------|
| Đăng nhập                 | ✅    | ✅    | ✅        |
| Quản lý khoa              | ✅    | ❌    | ❌        |
| Quản lý phòng             | ✅    | ❌    | ❌        |
| Quản lý bác sĩ            | ✅    | ❌    | ❌        |
| Quản lý bệnh nhân         | ✅    | ❌    | ❌        |
| Quản lý lịch khám         | ✅    | ❌    | ❌        |
| Xem lịch khám             | ❌    | ✅    | ✅        |
| Đặt lịch khám             | ❌    | ❌    | ✅        |
| Hủy lịch khám             | ❌    | ❌    | ✅        |
| Cập nhật lịch sử khám     | ❌    | ✅    | ❌        |
| Tìm kiếm                  | ✅    | ✅    | ✅        |

---




