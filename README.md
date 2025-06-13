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

![Class Diagram](Group6_QuanLyBenhVien/img/class.jpg)
---
1.2 Quản lý bệnh viện

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

