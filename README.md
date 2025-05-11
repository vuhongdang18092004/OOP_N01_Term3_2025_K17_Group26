# OOP_N01_Term3_2025_K17_Group6

## **Phần mềm quản lý lịch khám tại bệnh viện**

**Group 6 members:**
1. Vũ Hồng Đăng  
   *Github: vuhongdang18092004*  
2. Đỗ Thị Mỹ Hạnh  
   *Github: MyHanh23*  
3. Nguyễn Lệ Thu  
   *Github: nglthu*

---

## **Câu 1: Tiêu đề bài tập lớn**
Phần mềm quản lý lịch khám tại bệnh viện.

---

## **Câu 2: Phân tích cơ sở**

### a. Lớp Person (abstract class)
**Mục đích:** Lưu thông tin chung cho mọi người trong hệ thống.  
**Thuộc tính:**
- id: String
- name: String
- gender: String
- dateOfBirth: LocalDate
- phone: String
- address: String  
**Phương thức:**
- getAge(): Trả về tuổi dựa trên ngày sinh
- displayInfo(): Hiển thị thông tin cơ bản
- updateContactInfo(phone, address): Cập nhật thông tin liên lạc

### b. Lớp Doctor (kế thừa Person)
**Mục đích:** Đại diện cho bác sĩ.  
**Thuộc tính:**
- specialty: String
- workSchedule: List<WorkSchedule>
- roomId: String
- email: String (tùy chọn)  
**Phương thức:**
- addWorkSchedule(WorkSchedule ws)
- removeWorkScheduleByDate(LocalDate date)
- getNextAvailableSlot(): LocalDateTime
- displaySchedule()

### c. Lớp Patient (kế thừa Person)
**Mục đích:** Đại diện cho bệnh nhân.  
**Thuộc tính:**
- medicalHistory: String
- appointments: List<Appointment>
- healthInsuranceId: String
- emergencyContact: String  
**Phương thức:**
- addAppointment(Appointment appt)
- cancelAppointment(Appointment appt)
- viewAppointmentHistory()

### d. Lớp Admin
**Mục đích:** Đại diện tài khoản người quản trị hệ thống.  
**Thuộc tính:**
- username: String
- password: String  
**Phương thức:**
- login(username, password): boolean
- changePassword(String newPassword)
- manageDoctor()
- managePatient()
- createAppointment()
- manageWorkSchedule()

---

## **Câu 3: Cấu trúc folder của Project**

---

## **Câu 4: Các class đã thực hiện**

1. **Admin.java:** Lớp quản lý tài khoản người quản trị hệ thống.
2. **Doctor.java:** Lớp đại diện cho bác sĩ.
3. **Patient.java:** Lớp đại diện cho bệnh nhân.

---

## **Câu 5: Kiểm định các class**

1. **testAdmin.java:** Kiểm tra các chức năng của lớp Admin.
2. **testDoctor.java:** Kiểm tra các chức năng của lớp Doctor.
3. **testPatient.java:** Kiểm tra các chức năng của lớp Patient.
4. **testWorkSchedule.java:** Kiểm tra các chức năng của lịch làm việc.

---