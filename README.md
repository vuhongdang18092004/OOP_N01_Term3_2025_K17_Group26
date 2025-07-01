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

## **TÊN ĐỀ TÀI: PHẦN MỀM QUẢN LÝ LỊCH KHÁM VÀ XE CỨU THƯƠNG**

---
1.1 Use case tổng quát
![Editor _ Mermaid Chart-2025-07-01-041722](https://github.com/user-attachments/assets/b0fdf869-1da3-4252-bc45-04b20fa5e70a)

---
1.2 Sơ đồ quan hệ database
![Editor _ Mermaid Chart-2025-07-01-033912](https://github.com/user-attachments/assets/29efd512-eaec-422a-96bf-5e7cbebb174a)

---
1.3 Active Diagram
![AD TQ](https://github.com/user-attachments/assets/bd7fff2f-063e-4c4b-9021-efe99c5cf83b)

----
1.4 Biểu đồ tuần tự tổng quan toàn hệ thống
![biểu đồ tuần tự tổng quát](https://github.com/user-attachments/assets/9186aa94-c560-4fcd-bee7-ea20689c70d1)

---
1.5 Sơ đồ lớp tổng quát
![SĐL TQ](https://github.com/user-attachments/assets/a7dbf5e4-def0-4136-adfe-cd8a28c96c63)

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

