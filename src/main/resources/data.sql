-- Seed data for Ambulance Management project
-- Roles
INSERT INTO roles (id_role, name, description) VALUES
  (1, 'ADMIN', 'System administrator'),
  (2, 'STAFF', 'Management staff'),
  (3, 'DRIVER', 'Driver account'),
  (4, 'MEDICAL', 'Medical staff account');

-- Provinces
INSERT INTO province (id_province, name_province, zip_code, img_province, create_date, update_date) VALUES
  (1, 'Hà Nội', 100000, 'hanoi.png', NOW(), NOW()),
  (2, 'TP. Hồ Chí Minh', 700000, 'hcm.png', NOW(), NOW()),
  (3, 'Đà Nẵng', 550000, 'danang.png', NOW(), NOW()),
  (4, 'Hải Phòng', 180000, 'haiphong.png', NOW(), NOW()),
  (5, 'Cần Thơ', 900000, 'cantho.png', NOW(), NOW());


-- Districts
-- Hà Nội
INSERT INTO district (id_district, name_district, create_date, update_date, id_province) VALUES
  (1, 'Quận Ba Đình', NOW(), NOW(), 1),
  (2, 'Quận Hoàn Kiếm', NOW(), NOW(), 1),
  (3, 'Quận Đống Đa', NOW(), NOW(), 1);

-- TP. Hồ Chí Minh
INSERT INTO district (id_district, name_district, create_date, update_date, id_province) VALUES
  (4, 'Quận 1', NOW(), NOW(), 2),
  (5, 'Quận Bình Thạnh', NOW(), NOW(), 2),
  (6, 'Quận Gò Vấp', NOW(), NOW(), 2);

-- Đà Nẵng
INSERT INTO district (id_district, name_district, create_date, update_date, id_province) VALUES
  (7, 'Quận Hải Châu', NOW(), NOW(), 3),
  (8, 'Quận Thanh Khê', NOW(), NOW(), 3);

-- Hải Phòng
INSERT INTO district (id_district, name_district, create_date, update_date, id_province) VALUES
  (9, 'Quận Hồng Bàng', NOW(), NOW(), 4),
  (10, 'Quận Lê Chân', NOW(), NOW(), 4);

-- Cần Thơ
INSERT INTO district (id_district, name_district, create_date, update_date, id_province) VALUES
  (11, 'Quận Ninh Kiều', NOW(), NOW(), 5),
  (12, 'Quận Bình Thủy', NOW(), NOW(), 5);


-- Wards
-- Quận Ba Đình (Hà Nội)
INSERT INTO ward (id_ward, name_ward, create_date, update_date, id_district) VALUES
  (1, 'Phường Điện Biên', NOW(), NOW(), 1),
  (2, 'Phường Kim Mã', NOW(), NOW(), 1);

-- Quận Hoàn Kiếm (Hà Nội)
INSERT INTO ward (id_ward, name_ward, create_date, update_date, id_district) VALUES
  (3, 'Phường Hàng Bài', NOW(), NOW(), 2),
  (4, 'Phường Tràng Tiền', NOW(), NOW(), 2);

-- Quận 1 (TP. Hồ Chí Minh)
INSERT INTO ward (id_ward, name_ward, create_date, update_date, id_district) VALUES
  (5, 'Phường Bến Nghé', NOW(), NOW(), 4),
  (6, 'Phường Bến Thành', NOW(), NOW(), 4);

-- Quận Bình Thạnh (TP. Hồ Chí Minh)
INSERT INTO ward (id_ward, name_ward, create_date, update_date, id_district) VALUES
  (7, 'Phường 1', NOW(), NOW(), 5),
  (8, 'Phường 2', NOW(), NOW(), 5);

-- Quận Hải Châu (Đà Nẵng)
INSERT INTO ward (id_ward, name_ward, create_date, update_date, id_district) VALUES
  (9, 'Phường Thạch Thang', NOW(), NOW(), 7),
  (10, 'Phường Hải Châu I', NOW(), NOW(), 7);

-- Quận Hồng Bàng (Hải Phòng)
INSERT INTO ward (id_ward, name_ward, create_date, update_date, id_district) VALUES
  (11, 'Phường Minh Khai', NOW(), NOW(), 9),
  (12, 'Phường Sở Dầu', NOW(), NOW(), 9);

-- Quận Ninh Kiều (Cần Thơ)
INSERT INTO ward (id_ward, name_ward, create_date, update_date, id_district) VALUES
  (13, 'Phường Tân An', NOW(), NOW(), 11),
  (14, 'Phường An Cư', NOW(), NOW(), 11);


-- Brand of ambulances
INSERT INTO brand_ambulance (id_brand, name_brand, create_date, update_date) VALUES
  (1, 'Ford', NOW(), NOW()),
  (2, 'Toyota', NOW(), NOW()),
  (3, 'Hyundai', NOW(), NOW()),
  (4, 'Mercedes-Benz', NOW(), NOW()),
  (5, 'Isuzu', NOW(), NOW()),
  (6, 'Mitsubishi', NOW(), NOW()),
  (7, 'Kia', NOW(), NOW()),
  (8, 'Chevrolet', NOW(), NOW()),
  (9, 'Volkswagen', NOW(), NOW()),
  (10, 'Peugeot', NOW(), NOW()),
  (11, 'Nissan', NOW(), NOW()),
  (12, 'Fiat', NOW(), NOW()),
  (13, 'Renault', NOW(), NOW()),
  (14, 'GMC', NOW(), NOW()),
  (15, 'IVECO', NOW(), NOW());


-- Hospitals
INSERT INTO hospitals (id_hospital, name, address_detail, phone, email, director_name, create_date, update_date, province_id, district_id, ward_id)
VALUES
  (1, 'Bệnh viện Bạch Mai', '78 Giải Phóng, Đống Đa', '02438693731', 'bachmai@hospital.vn', 'PGS.TS. Đào Xuân Cơ', NOW(), NOW(), 1, 3, 1),

  (2, 'Bệnh viện Việt Đức', '40 Tràng Thi, Hoàn Kiếm', '02438253531', 'vietduc@hospital.vn', 'GS.TS. Trần Bình Giang', NOW(), NOW(), 1, 2, 4),

  (3, 'Bệnh viện K', '43 Quán Sứ, Hoàn Kiếm', '02438252143', 'khospital@hospital.vn', 'PGS.TS. Lê Văn Quảng', NOW(), NOW(), 1, 2, 4),

  (4, 'Bệnh viện Chợ Rẫy', '201B Nguyễn Chí Thanh, Quận 5', '02838554137', 'choray@hospital.vn', 'TS.BS. Nguyễn Tri Thức', NOW(), NOW(), 2, 6, 8),

  (5, 'Bệnh viện Nhân dân 115', '527 Sư Vạn Hạnh, Quận 10', '02838659115', 'bv115@hospital.vn', 'PGS.TS. Phan Văn Báu', NOW(), NOW(), 2, 5, 7),

  (6, 'Bệnh viện Đại học Y Dược TPHCM', '215 Hồng Bàng, Quận 5', '02838554269', 'umyduoc@hospital.vn', 'PGS.TS. Trần Diệp Tuấn', NOW(), NOW(), 2, 6, 8),

  (7, 'Bệnh viện Trung ương Huế', '16 Lê Lợi, TP Huế', '02343823389', 'bvtwhue@hospital.vn', 'GS.TS. Phạm Như Hiệp', NOW(), NOW(), 6, 13, 15),

  (8, 'Bệnh viện Đà Nẵng', '124 Hải Phòng, Hải Châu', '02363820964', 'dananghospital@hospital.vn', 'BS. Ngô Thị Kim Yến', NOW(), NOW(), 3, 7, 9),

  (9, 'Bệnh viện Phụ sản Trung ương', '43 Tràng Thi, Hoàn Kiếm', '02438252163', 'pstw@hospital.vn', 'PGS.TS. Trần Danh Cường', NOW(), NOW(), 1, 2, 4),

  (10, 'Bệnh viện Hữu nghị Việt Tiệp', '225 Lạch Tray, Ngô Quyền', '02253825991', 'bvvt@hospital.vn', 'TS. Nguyễn Văn Khải', NOW(), NOW(), 4, 10, 12);


-- Drivers
INSERT INTO drivers (id_driver, name, phone, email, date_of_birth, sex, license_number, avatar, status, create_date, update_date, hospital_id)
VALUES
  (1, 'Nguyễn Văn A', '0912345678', 'nva@example.com', '1975-05-10', TRUE, 'GPLX001A', NULL, 1, NOW(), NOW(), 1),

  (2, 'Trần Thị B', '0923456789', 'ttb@example.com', '1982-08-21', FALSE, 'GPLX002B', NULL, 1, NOW(), NOW(), 2),

  (3, 'Phạm Văn C', '0934567890', 'pvc@example.com', '1978-12-15', TRUE, 'GPLX003C', NULL, 1, NOW(), NOW(), 3),

  (4, 'Lê Thị D', '0945678901', 'ltd@example.com', '1985-03-05', FALSE, 'GPLX004D', NULL, 0, NOW(), NOW(), 4),

  (5, 'Hoàng Văn E', '0956789012', 'hve@example.com', '1990-11-25', TRUE, 'GPLX005E', NULL, 1, NOW(), NOW(), 5),

  (6, 'Đỗ Thị F', '0967890123', 'dtf@example.com', '1988-07-30', FALSE, 'GPLX006F', NULL, 1, NOW(), NOW(), 6),

  (7, 'Vũ Văn G', '0978901234', 'vvg@example.com', '1972-02-14', TRUE, 'GPLX007G', NULL, 1, NOW(), NOW(), 7),

  (8, 'Bùi Thị H', '0989012345', 'bth@example.com', '1981-06-19', FALSE, 'GPLX008H', NULL, 0, NOW(), NOW(), 8),

  (9, 'Ngô Văn I', '0990123456', 'nvi@example.com', '1983-09-01', TRUE, 'GPLX009I', NULL, 1, NOW(), NOW(), 9),

  (10, 'Lý Thị K', '0901234561', 'ltk@example.com', '1992-10-10', FALSE, 'GPLX010K', NULL, 1, NOW(), NOW(), 10);


-- Ambulances
INSERT INTO ambulances (
  id_ambulance, name, license_plate, description, model_year, status, fuel_type,
  fuel_consumption_per100km, number_of_seats, medical_equipment, oxygen_tank, defibrillator,
  patient_monitor, stretcher, infusion_support, incubator_support,
  gps_locator, camera360, reverse_camera, dash_camera, tpms, impact_sensor,
  speed_warning, air_conditioning, manual_transmission, image, current_location,
  create_date, update_date, brand_ambulance_id, hospital_id, driver_id)
VALUES
  (1, 'Ambulance 1', 'XYZ-001', 'Primary ambulance', 2018, 0, TRUE,
   10.0, 4, TRUE, TRUE, TRUE,
   TRUE, TRUE, FALSE, FALSE,
   TRUE, TRUE, TRUE, TRUE, TRUE, FALSE,
   TRUE, TRUE, TRUE, 'amb1.png', 'Garage',
    NOW(), NOW(), 1, 1, 1),

  (2, 'Ambulance 2', '30A-56789', 'Hà Nội - Cấp cứu lưu động', 2020, 1, TRUE,
   9.5, 5, TRUE, TRUE, TRUE,
   TRUE, TRUE, TRUE, FALSE,
   TRUE, TRUE, TRUE, TRUE, TRUE, TRUE,
   TRUE, TRUE, FALSE, 'amb2.png', 'Bệnh viện Bạch Mai',
    NOW(), NOW(), 2, 1, 2),

  (3, 'Ambulance 3', '51B-12345', 'TP.HCM - Xe cấp cứu ngoại viện', 2021, 1, TRUE,
   11.0, 6, TRUE, TRUE, TRUE,
   TRUE, TRUE, TRUE, TRUE,
   TRUE, TRUE, TRUE, TRUE, TRUE, TRUE,
   TRUE, TRUE, TRUE, 'amb3.png', 'Bệnh viện Chợ Rẫy',
    NOW(), NOW(), 3, 4, 4),

  (4, 'Ambulance 4', '43C-88888', 'Đà Nẵng - Xe cấp cứu nội viện', 2019, 1, FALSE,
   8.5, 4, TRUE, TRUE, FALSE,
   TRUE, TRUE, TRUE, FALSE,
   TRUE, TRUE, TRUE, TRUE, FALSE, FALSE,
   TRUE, TRUE, TRUE, 'amb4.png', 'Bệnh viện Đà Nẵng',
    NOW(), NOW(), 4, 8, 6),

  (5, 'Ambulance 5', '18D-00001', 'Xe cứu thương phục vụ cấp tỉnh', 2017, 0, TRUE,
   10.2, 4, TRUE, TRUE, FALSE,
   TRUE, TRUE, FALSE, FALSE,
   FALSE, TRUE, TRUE, FALSE, TRUE, FALSE,
   TRUE, TRUE, TRUE, 'amb5.png', 'Kho xe Hải Phòng',
    NOW(), NOW(), 5, 10, 10),

  (6, 'Ambulance 6', '30F-11111', 'Hà Nội - nội viện', 2022, 1, TRUE,
   9.0, 5, TRUE, TRUE, TRUE,
   TRUE, TRUE, TRUE, TRUE,
   TRUE, TRUE, TRUE, TRUE, TRUE, TRUE,
   TRUE, TRUE, FALSE, 'amb6.png', 'Bệnh viện Việt Đức',
   NOW(), NOW(), 2, 2, 3),

  (7, 'Ambulance 7', '51G-23456', 'TP.HCM - cứu thương ngoại viện', 2021, 1, TRUE,
   10.5, 4, TRUE, TRUE, TRUE,
   TRUE, TRUE, FALSE, FALSE,
   TRUE, TRUE, TRUE, TRUE, FALSE, FALSE,
   TRUE, TRUE, TRUE, 'amb7.png', 'BV Nhân dân 115',
   NOW(), NOW(), 4, 5, 5),

  (8, 'Ambulance 8', '43A-45678', 'Đà Nẵng - lưu động', 2020, 0, FALSE,
   9.3, 6, TRUE, TRUE, TRUE,
   TRUE, TRUE, FALSE, FALSE,
   TRUE, TRUE, TRUE, TRUE, FALSE, FALSE,
   TRUE, TRUE, TRUE, 'amb8.png', 'Bệnh viện Đà Nẵng',
   NOW(), NOW(), 3, 8, 6),

  (9, 'Ambulance 9', '18B-98765', 'Hải Phòng - cứu thương nhanh', 2022, 1, TRUE,
   8.7, 4, TRUE, TRUE, TRUE,
   TRUE, TRUE, TRUE, TRUE,
   TRUE, TRUE, TRUE, TRUE, TRUE, TRUE,
   TRUE, TRUE, TRUE, 'amb9.png', 'Việt Tiệp - Cấp cứu A1',
   NOW(), NOW(), 1, 10, 9),

  (10, 'Ambulance 10', '90D-00010', 'Xe tiêu chuẩn sơ sinh', 2023, 1, TRUE,
   9.8, 5, TRUE, TRUE, TRUE,
   TRUE, TRUE, TRUE, TRUE,
   TRUE, TRUE, TRUE, TRUE, TRUE, TRUE,
   TRUE, TRUE, FALSE, 'amb10.png', 'Bệnh viện Phụ sản TW',
   NOW(), NOW(), 5, 9, 8),

  (11, 'Ambulance 11', '92C-11223', 'Quảng Nam - BV vệ tinh', 2019, 0, FALSE,
   10.2, 4, TRUE, TRUE, FALSE,
   TRUE, TRUE, FALSE, FALSE,
   TRUE, TRUE, TRUE, TRUE, FALSE, FALSE,
   TRUE, TRUE, TRUE, 'amb11.png', 'Bệnh viện Đà Nẵng',
   NOW(), NOW(), 6, 8, 6),

  (12, 'Ambulance 12', '66B-90909', 'Cần Thơ - trực cấp cứu', 2020, 1, TRUE,
   9.5, 6, TRUE, TRUE, TRUE,
   TRUE, TRUE, FALSE, FALSE,
   TRUE, TRUE, TRUE, TRUE, TRUE, FALSE,
   TRUE, TRUE, TRUE, 'amb12.png', 'Bệnh viện Cần Thơ',
   NOW(), NOW(), 7, 5, 10),

  (13, 'Ambulance 13', '36A-55555', 'Thanh Hóa - cấp huyện', 2017, 0, TRUE,
   10.0, 4, TRUE, FALSE, FALSE,
   TRUE, TRUE, FALSE, FALSE,
   FALSE, TRUE, TRUE, TRUE, FALSE, FALSE,
   TRUE, TRUE, TRUE, 'amb13.png', 'Chốt sơ cấp Thanh Hóa',
   NOW(), NOW(), 8, 1, 1),

  (14, 'Ambulance 14', '62C-34567', 'Long An - cấp cứu lưu động', 2021, 1, FALSE,
   9.1, 5, TRUE, TRUE, TRUE,
   TRUE, TRUE, TRUE, TRUE,
   TRUE, TRUE, TRUE, TRUE, TRUE, TRUE,
   TRUE, TRUE, FALSE, 'amb14.png', 'BV tỉnh Long An',
   NOW(), NOW(), 9, 2, 2),

  (15, 'Ambulance 15', '72D-11235', 'Bà Rịa - nội viện', 2018, 0, TRUE,
   10.7, 4, TRUE, TRUE, TRUE,
   TRUE, TRUE, FALSE, FALSE,
   TRUE, TRUE, TRUE, FALSE, TRUE, FALSE,
   TRUE, TRUE, TRUE, 'amb15.png', 'Kho xe BVBR',
   NOW(), NOW(), 10, 3, 4);


-- Medical staff
INSERT INTO medical_staff (
  id_medical_staff, name, phone, email, date_of_birth, sex, license_number,
  specialization, avatar, status, create_date, update_date, hospital_id)
VALUES
  (1, 'Jane Smith', '0909876543', 'nurse@example.com', '1985-05-05', FALSE, 'MS123', 'Nurse', NULL, 0, NOW(), NOW(), 1),

  (2, 'Nguyễn Văn Dũng', '0912345671', 'dungnv@bachmai.vn', '1979-07-21', TRUE, 'BS001', 'Emergency Doctor', NULL, 1, NOW(), NOW(), 1),

  (3, 'Trần Thị Mai', '0923456782', 'maitt@vietduc.vn', '1983-10-10', FALSE, 'BS002', 'Surgery Nurse', NULL, 1, NOW(), NOW(), 2),

  (4, 'Phạm Quang Huy', '0934567893', 'huyph@choeray.vn', '1980-03-15', TRUE, 'BS003', 'Paramedic', NULL, 1, NOW(), NOW(), 4),

  (5, 'Lê Thị Bích', '0945678904', 'bichlt@ydhcm.vn', '1986-11-30', FALSE, 'BS004', 'Midwife', NULL, 1, NOW(), NOW(), 6),

  (6, 'Vũ Minh Tuấn', '0956789015', 'tuanvm@dananghospital.vn', '1975-01-25', TRUE, 'BS005', 'Emergency Doctor', NULL, 0, NOW(), NOW(), 8),

  (7, 'Hoàng Thị Hạnh', '0967890126', 'hanhht@pstw.vn', '1989-06-05', FALSE, 'BS006', 'Neonatal Nurse', NULL, 1, NOW(), NOW(), 9),

  (8, 'Đặng Quốc Toản', '0978901237', 'toandq@viettiep.vn', '1978-12-12', TRUE, 'BS007', 'ICU Doctor', NULL, 1, NOW(), NOW(), 10),

  (9, 'Bùi Thanh Lan', '0989012348', 'lanbt@115hcm.vn', '1990-09-18', FALSE, 'BS008', 'Anesthetist', NULL, 1, NOW(), NOW(), 5),

  (10, 'Đỗ Đức Mạnh', '0990123459', 'manhdd@twhue.vn', '1982-08-08', TRUE, 'BS009', 'Ambulance Technician', NULL, 1, NOW(), NOW(), 7);


-- Users
INSERT INTO users (id_user, username, password, name_display, email, phone, address, date_of_birth, sex, image, create_date, update_date, id_role)
VALUES
  (1, 'admin', 'password', 'Admin', 'admin@example.com', '0911111111', 'Head Office', '1990-01-01', TRUE, NULL, NOW(), NOW(), 1),
  (2, 'staff', 'password', 'Staff User', 'staff@example.com', '0922222222', 'Office', '1992-02-02', TRUE, NULL, NOW(), NOW(), 2),
  (3, 'driver', 'password', 'Driver User', 'driver@example.com', '0933333333', 'Garage', '1980-03-03', TRUE, NULL, NOW(), NOW(), 3),
  (4, 'medical', 'password', 'Medical User', 'medical@example.com', '0944444444', 'Clinic', '1985-04-04', FALSE, NULL, NOW(), NOW(), 4);
