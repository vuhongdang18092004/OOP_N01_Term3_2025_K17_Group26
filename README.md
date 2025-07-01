# OOP_N01_Term3_2025_K17_Group6

## **Phần mềm quản lý bệnh viện**

**Group 6 members:**
1. Vũ Hồng Đăng  
   *Github: vuhongdang18092004*  
2. Đỗ Thị Mỹ Hạnh  
   *Github: MyHanh23*  
3. Nguyễn Văn Hiếu  
   *Github: NguyenHieu-class* 
4. Nguyễn Lệ Thu  
   *Github: nglthu*

---

## **Câu 1: Tiêu đề bài tập lớn**
Phần mềm quản lý bệnh viện.

---

##UML Dự án

---
1.1 Class diagram
![UC1](https://github.com/user-attachments/assets/b9451a66-c583-4e60-8d0e-75a9ac1e1650)
![UC2](https://github.com/user-attachments/assets/aece981a-6bc5-4615-b18d-f7ee2d7ba13c)
![UC3](https://github.com/user-attachments/assets/3760a851-51bf-4bff-bc67-6305d589bfa0)
![UC4](https://github.com/user-attachments/assets/3d393dd7-f76a-4edb-8554-64a6a12ae6ce)
![UC5](https://github.com/user-attachments/assets/b51b8dfe-b0ed-4720-9fab-2436f811bdf8)
![UC6](https://github.com/user-attachments/assets/e07a53db-7b4b-436b-87d6-65a432d6503d)
![UC7](https://github.com/user-attachments/assets/d0ae8deb-4c1e-4fcd-976b-5a8f296f9802)
![UC8](https://github.com/user-attachments/assets/bf59c48d-0c49-4b50-b59b-7ba63b1250ff)
![UC9](https://github.com/user-attachments/assets/4d200ff9-1e79-4e44-9293-ac57060271c0)
![UC10](https://github.com/user-attachments/assets/95db15e4-57fd-44e8-8889-1862f4eee49a)
![UC11](https://github.com/user-attachments/assets/42423477-4bf7-4eb6-b35e-f5fcfc6fd952)

---
1.2 Quản lý bệnh viện
![TT sửa TT bệnh nhân](https://github.com/user-attachments/assets/10c7cd72-999c-463e-bf8e-2f1e3f214427)
![TT bệnh nhân](https://github.com/user-attachments/assets/82de3ace-cc98-41e3-beb1-327079bd653e)
![đặt lịch khám](https://github.com/user-attachments/assets/739b6f5b-26e3-43cb-b12e-8a93506c4387)
![LS khám](https://github.com/user-attachments/assets/d57b0d26-5256-4fd3-83da-cf09a1b49820)
![xem lịch khám](https://github.com/user-attachments/assets/f286c9e7-93a3-4ee8-96b3-66f818ce3344)
![hủy lịch](https://github.com/user-attachments/assets/7bf33692-e06f-4810-96f3-fe4e7d3bb3e7)
![trạng thái lịch khám](https://github.com/user-attachments/assets/d4eefecf-fc0b-4315-9061-c1f96f1dd360)


![hiển thị TT BS](https://github.com/user-attachments/assets/7b342832-9879-4cc0-af75-d36dd8cdf830)
![cập nhật thông tin cá nhân BS](https://github.com/user-attachments/assets/61f39cf4-2bdc-4550-9545-17d98948655d)
![thêm BS](https://github.com/user-attachments/assets/f7686c86-4505-41d5-94c7-bc75a9b5c427)
![CẬP NHẬT BS](https://github.com/user-attachments/assets/414448bc-7cbf-4d7f-a120-7fc72065e110)
![XÓA BS](https://github.com/user-attachments/assets/36d6502d-a5f3-40d1-b2cd-100eb2fb1d4f)
![DS BS](https://github.com/user-attachments/assets/0360b745-c6b7-4ece-8555-ceea3f5281ed)


![thêm phòng](https://github.com/user-attachments/assets/90b6fb77-1f57-4661-954f-fac06437583d)
![cập nhật phòng](https://github.com/user-attachments/assets/89b0410f-9ba9-4e6f-b1a9-41ec2feef57f)
![hiển thị danh sách phòng](https://github.com/user-attachments/assets/490c7cdf-7597-4d2c-8e6d-d90d67a164a3)
![xóa phòng](https://github.com/user-attachments/assets/50f80a54-547a-4c36-98a5-643cb148f052)


![thêm khoa](https://github.com/user-attachments/assets/75b3047c-2ac7-42d6-b58e-39f249a58216)
![cập nhật TT khoa'](https://github.com/user-attachments/assets/6b96694d-b03c-4ac2-8845-35e173bd41c3)
![hiển thị ds khoa](https://github.com/user-attachments/assets/d84cfe88-5133-4ecb-b45c-b5dc9fc2a5a9)
![xóa khoa](https://github.com/user-attachments/assets/d74501a8-5642-439d-8b0d-e80baf665686)

![Class Diagram](Group6_QuanLyBenhVien/img/dautien.png)
---
1.3 Quản lý lịch khám

![Class Diagram](Group6_QuanLyBenhVien/img/thuhai.png)
---
1.3 Quản lý xe cấp cứu

![Class Diagram](Group6_QuanLyBenhVien/img/thuba.png)


---
### Miêu tả phương thức: kiemTraLichKhamHomNay
- **Tên phương thức:** `hienThiDanhSachLichKham`

- **Mục đích:**
  Hiển thị danh sách các lịch khám hiện có cho người dùng.  
  Nếu danh sách trống, hiển thị thông báo `"Hiện không có lịch khám nào."`

- **Tham số đầu vào:**
  `danhSachLichKham (List<Appointment>)`: Danh sách các lịch khám cần hiển thị.

- **Giá trị trả về:**
  Không có giá trị trả về (`void`), phương thức chỉ thực hiện in ra màn hình.

- **Mô tả chi tiết:**
  Phương thức sẽ kiểm tra xem danh sách lịch khám có rỗng hay không bằng cách gọi `isEmpty()` trên `danhSachLichKham`.  
    Nếu danh sách rỗng, in ra thông báo `"Hiện không có lịch khám nào."`
    Ngược lại, duyệt qua danh sách và in thông tin chi tiết của từng lịch khám bằng vòng lặp `for`.

- **Ý nghĩa:**
Phương thức này giúp nhân viên y tế dễ dàng xem được các lịch khám hiện tại mà không cần tìm thủ công trong dữ liệu. Nếu không có lịch nào, hệ thống phản hồi rõ ràng để người dùng biết. Điều này giúp cải thiện trải nghiệm sử dụng phần mềm và tiết kiệm thời gian tra cứu thông tin.

