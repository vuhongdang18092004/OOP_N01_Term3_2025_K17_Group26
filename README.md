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

[👉 Xem video demo tại đây](https://www.youtube.com/watch?v=MN2OORaIH-c)

---

## 🖼️ Giao diện hệ thống

### Trang đăng nhập
![2afd9902d3a564fb3db4](https://github.com/user-attachments/assets/0dd30d6c-be29-4866-874b-4e10b6aad123)


### Giao diện Admin
![fe0650e31a44ad1af455](https://github.com/user-attachments/assets/c61fa1a9-902f-4359-911f-53df2b748e95)


### Giao diện Bác sĩ
![b687648c2f2b9875c13a](https://github.com/user-attachments/assets/dc0e192e-8031-4dda-96f7-723804509091)


### Giao diện Bệnh nhân
![0bf471f33a548d0ad445](https://github.com/user-attachments/assets/cd18914c-64a3-4b45-b159-ca5f0d4d5d61)


---

## 🛠️ Tính năng chính

### ✅ Admin
- Đăng nhập hệ thống
- Quản lý khoa (thêm, sửa, xóa)
- Quản lý phòng (thêm, sửa, xóa)
- Quản lý bác sĩ (thêm, sửa, xóa)
- Quản lý bệnh nhân (hiện thông tin, tìm kiếm)
- Quản lý lịch khám (hiện thông tin, tìm kiếm)
- Tìm kiếm bệnh nhân, bác sĩ, lịch khám

### ✅ Bác sĩ
- Đăng nhập hệ thống
- Xem lịch khám cá nhân
- Cập nhật lịch sử khám bệnh

### ✅ Bệnh nhân
- Đăng nhập hệ thống
- Đặt lịch khám
- Kiểm tra lịch khám sắp tới
- Hủy lịch khám
- Tìm kiếm lịch khám

---

## 🗂️ Mô hình hệ thống
- UML Use Case Diagram
- UML Class Diagram tổng quát
- UML Sequence Diagram cho từng chức năng
- UML Activity Diagram tổng quan và chi tiết
- Entity Relationship Diagram (ERD)

## 📊 Các sơ đồ chi tiết
**1. [Use Case Diagram]**
  
  (https://github.com/user-attachments/assets/1d7a1d82-94a9-42da-82eb-fd606ce69721)

  
**2. [Class Diagram]**
  (https://github.com/user-attachments/assets/b07a8136-f615-49d1-afee-76d731194d39)


**3. [Activity Diagram]**
  (https://github.com/user-attachments/assets/93c9f5b8-fd58-4290-a3c9-d2003ef97283)


**4. [Sequence Diagram]**
  (https://github.com/user-attachments/assets/367e9b1d-74e9-465e-bbdf-5e76d117f12b)


**5. [ERD (Sơ đồ quan hệ cơ sở dữ liệu)]**
  (https://github.com/user-attachments/assets/5fa9edff-75bf-4169-a11b-d38fe4eda27a)


---

## 💾 Công nghệ sử dụng
- Ngôn ngữ: Java
- Framework: Spring Boot
- Database: MySQL / SQL Server
- ORM: Spring Data JPA
- Template Engine: Thymeleaf 
- Công cụ thiết kế UML: PlantUML, StarUML
- IDE: Vscode

---

## 📌 Yêu cầu hệ thống
- Java JDK 8 trở lên
- MySQL / SQL Server
- PlantUML để đọc sơ đồ

---

## 🧑‍💻 Hướng dẫn cài đặt
```bash
git clone https://github.com/vuhongdang18092004/OOP_N01_Term3_2025_K17_Group26.git
cd OOP_N01_Term3_2025_K17_Group26
Mở project bằng IntelliJ IDEA hoặc Eclipse
Cấu hình kết nối cơ sở dữ liệu trong file config
Chạy ứng dụng
 ./mvnw spring-boot:run
Chạy lệnh để chạy phần test
./mvnw test           
---

## 📝 Hướng dẫn sử dụng

### Đăng nhập
- Tài khoản Admin: `admin` / `1234567`
- Tài khoản Bác sĩ: `minhnhat` / `1234567`
- Tài khoản Bệnh nhân: `dang` / `1234567`

---

### Admin
- Quản lý khoa: Thêm, sửa, xóa
- Quản lý phòng: Thêm, sửa, xóa
- Quản lý bác sĩ: Thêm, sửa, xóa
- Quản lý bệnh nhân: Thêm, sửa, xóa
- Quản lý lịch khám: Xem, tìm kiếm
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




