# OOP_N01_Term3_2025_K17_Group6

**Group 6 members:**
1. Vũ Hồng Đăng  
   *Github: vuhongdang18092004*  
2. Đỗ Thị Mỹ Hạnh  
   *Github: MyHanh23*  
3. Nguyễn Lệ Thu  
   *Github: nglthu*
4. Nguyễn Văn Hiếu  
   *Github: nguyenhieu-class*
---

# 🏥 Ứng Dụng Quản Lý Lịch Khám Bệnh Viện

Ứng dụng được xây dựng bằng **Java Spring Boot**, hỗ trợ quản lý các chức năng liên quan đến hoạt động khám chữa bệnh tại bệnh viện, bao gồm:

- **Quản lý lịch khám bệnh**
- **Quản lý phòng khám**
- **Quản lý phương tiện cứu thương**

---

## 🚀 Tính Năng Chính

### 🔹 Quản lý phương tiện cứu thương
- Thêm, sửa, xóa thông tin phương tiện (biển số, loại xe, sức chứa, trạng thái...)
- Liệt kê danh sách các phương tiện đang hoạt động hoặc khả dụng
- Tạo chuyến đi (gán tài xế, bác sĩ, bệnh nhân)
- Kết thúc chuyến đi, cập nhật trạng thái xe

### 🔹 Quản lý lịch khám
- Tạo và cập nhật lịch khám cho bệnh nhân
- Gán bác sĩ, phòng khám tương ứng
- Tra cứu lịch khám theo bệnh nhân hoặc bác sĩ

### 🔹 Quản lý phòng khám
- Thêm, sửa, xóa thông tin phòng khám
- Gán phòng cho các ca khám

---

## 🗂️ Kiến Trúc Hệ Thống

Ứng dụng tuân theo kiến trúc **MVC (Model - View - Controller)**, sử dụng:

- Spring Boot (REST API)
- JPA/Hibernate kết nối với CSDL (MySQL, PostgreSQL hoặc H2)
- Thymeleaf hoặc REST API cho giao diện frontend

---

## 💾 Cơ Sở Dữ Liệu

Hệ thống sử dụng cơ sở dữ liệu để lưu trữ toàn bộ thông tin:

- `ambulance` – bảng phương tiện cứu thương
- `ambulance_trip` – bảng chuyến đi
- `appointment` – bảng lịch khám
- `clinic_room` – bảng phòng khám
- `user`, `doctor`, `patient` – các bảng người dùng liên quan

---

## 🖼️ Sơ Đồ (Minh Họa)

---

### **SƠ ĐỒ CLASS DIAGRAM**
![Class Diagram](https://github.com/vuhongdang18092004/OOP_N01_Term3_2025_K17_Group6/blob/119dc09bc74e71b76db693e6fdc378fff650d011/class_diagram.png)

---

### **SƠ ĐỒ ACTIVITY DIAGRAM**
![them_phuong_tien_cuu_thuong](https://github.com/vuhongdang18092004/OOP_N01_Term3_2025_K17_Group6/blob/119dc09bc74e71b76db693e6fdc378fff650d011/them_phuong_tien_cuu_thuong.png)
![tao_chuyen_di](https://github.com/vuhongdang18092004/OOP_N01_Term3_2025_K17_Group6/blob/119dc09bc74e71b76db693e6fdc378fff650d011/tao_chuyen_di.png)
![ket_thuc_chuyen_di](https://github.com/vuhongdang18092004/OOP_N01_Term3_2025_K17_Group6/blob/119dc09bc74e71b76db693e6fdc378fff650d011/ket_thuc_chuyen_di.png)
---

