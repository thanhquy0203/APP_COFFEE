create database QLCP
go
------------------
use QLCP
go
create table TAIKHOAN 
	(tenTK nvarchar(50) not null primary key,
	matKhau nvarchar(50) not null)

----------------
create table NHANVIEN
	(maNhanVien nvarchar(50) not null primary key,
	tenNhanVien nvarchar(50) not null,
	diaChi nvarchar(50),
	soDienThoai nvarchar(50),
	luong float not null,
	chucVu nvarchar(50) not null,
	tenTK nvarchar(50) not null
	foreign key (tenTK) references TAIKHOAN(tenTK)
	)
-------------------------------
create table KHACHHANG
	(maKhachHang nvarchar(50) not null primary key,
	tenKhachHang nvarchar(50),
	diaChi nvarchar(50),
	soDienThoai nvarchar(50),
	diemTichLuy float,
	
	)
	--Chi tieu thanh diem tich luy
-----------
create table NGUYENLIEU
	(maNguyenLieu nvarchar(50) Not Null primary key,
	tenNguyenLieu nvarchar(50) Not Null,
	soLuong int not null,
	donVi nvarchar(50) not null constraint CK_DonVi check (donVi IN('kg', 'chai', 'thùng', 'túi' ))

	)
------------
create table THE
	(soThe int not null primary key,
	tinhTrang nvarchar(50))
--------------
create table HOADON
	(maHoaDon nvarchar(50) not null primary key,
	tongTien float not null,
	ngayBan Date,
	maNhanVien nvarchar(50) not null,
	maKhachHang nvarchar(50),
	soThe int not null,
	foreign key (maNhanVien) references NHANVIEN(maNhanVien),
	foreign key (soThe) references THE(soThe),
	foreign key (maKhachHang) references KHACHHANG (maKhachHang)
	)


-------------------
create table DOUONG
	(maDoUong nvarchar(50) not null primary key,
	tenDoUong nvarchar(50) not null,
	giaTien float not null,
	loaiDoUong nvarchar(50) not null,	
	)
-------------------
create table CHITIETDOUONG
	(soLuong int,
	maDoUong nvarchar(50) not null,
	maNguyenLieu nvarchar(50) not null,
	primary key (maDoUong,maNguyenLieu),
	foreign key (maDoUong) references DOUONG(maDoUong),
	foreign key (maNguyenLieu) references NGUYENLIEU(maNguyenLieu)
	)
		
----------------------

create table CHITIETHOADON 
	(maHoaDon nvarchar(50) not null,
	maDoUong nvarchar(50) not null,
	soLuong int check (soluong>0),
	donGia float,
	primary key(maDoUong,maHoaDon),
	foreign key (maHoaDon) references HOADON (maHoaDon),
	foreign key (maDoUong) references DOUONG (maDoUong),
	)
-------------

-- Tạo dữ liệu cho bảng TAIKHOAN
INSERT INTO TAIKHOAN (tenTK, matKhau)
VALUES 
    ('user1', 'password1'),
    ('user2', 'password2'),
    ('admin', 'adminpassword');

-- Tạo dữ liệu cho bảng NHANVIEN
INSERT INTO NHANVIEN (maNhanVien, tenNhanVien, diaChi, soDienThoai, luong, chucVu, tenTK)
VALUES 
    ('NV001', 'Nguyen Van An', '123 Nguyen Van Bao', '0123456789', 10000, 'Nhan vien', 'user1'),
    ('NV002', 'Tran Thi Hanh', '456 Nguyen Van Nghi', '0987654321', 12000, 'Nhan vien', 'user2'),
    ('NV003', 'Le Van Nam', '789 Le Loi', '0123456789', 15000, 'Quan ly', 'admin');

-- Tạo dữ liệu cho bảng KHACHHANG
INSERT INTO KHACHHANG (maKhachHang, tenKhachHang, diaChi, soDienThoai, diemTichLuy)
VALUES 
    ('KH001', 'Huynh Anh Hung', '123 Go Vap', '0123456789', 20),
    ('KH002', 'Huynh Thanh Quy', '456 Binh Tan', '0987654321', 50),
    ('KH003', 'Nguyen Huynh Dan Khach', '789 Quang Trung', '0123456788', 120),
	('KH004', 'Nguyen Huynh Anh', '789 Phan Van Tri', '0123456787', 350),
	('KH005', 'Tran Thi Thu Hien', '12 Truong Chinh', '0123456780', 850);
-- Tạo dữ liệu cho bảng NGUYENLIEU

INSERT INTO NGUYENLIEU (maNguyenLieu, tenNguyenLieu, soLuong, donVi) VALUES 
	('NL001', N'Đường', 10, 'kg'),
    ('NL002', N'Sữa Tươi', 20, 'chai'),
    ('NL003', N'Cream', 12, 'chai'),
    ('NL004', N'Nước Ngọt', 3, 'thùng'),
	('NL005', N'Hạt cà phê', 30, 'kg'),
    ('NL006', N'Bột kem', 8, 'chai'),
    ('NL007', N'Sữa đặc', 5, 'chai'),
    ('NL008', N'Đá', 5, 'thùng'),
    ('NL009', N'Bột sữa', 4, 'túi'),
    ('NL010', N'Cacao', 5, 'túi'),
    ('NL011', N'Cà chua', 3, 'kg'),
    ('NL012', N'Cà rốt', 5 , 'kg'),
    ('NL013', N'Socola', 2, 'kg'),
    ('NL014', N'Sữa chua', 1, 'thùng'),
    ('NL015', N'Siro', 9, 'chai'),
    ('NL016', N'Trà sen', 20, 'túi');
  


-- Tạo dữ liệu cho bảng THE
INSERT INTO THE (soThe, tinhTrang)
VALUES 
    (1, 'Trong'),
    (2, 'Trong'),
    (3, 'Da co khach'),
	(4, 'Trong'),
	(5, 'Da co khach');

-- Tạo dữ liệu cho bảng DOUONG
INSERT INTO DOUONG (maDoUong, tenDoUong, giaTien, loaiDoUong)
VALUES 
    ('DU001', 'Cappuccino', 30000, 'Coffee'),
    ('DU002', 'Latte', 35000, 'Coffee'),
    ('DU003', 'Smoothie', 40000, 'Coffee'),
	('DU004', 'Espresso', 25000, 'Coffee'),
    ('DU005', 'Americano', 28000, 'Coffee'),
    ('DU006', 'Flat White', 32000, 'Coffee'),
    ('DU007', 'Macchiato', 34000, 'Coffee'),
    ('DU008', 'Hot Chocolate', 38000, 'Coffee'),
    ('DU009', 'Chai Tea Latte', 36000, 'Tea'),
    ('DU010', 'Green Tea Latte', 37000, 'Tea'),
    ('DU011', 'Black Tea', 29000, 'Tea'),
    ('DU012', 'Matcha Green Tea', 41000, 'Tea'),
    ('DU013', 'Iced Coffee', 32000, 'Coffee'),
    ('DU014', 'Iced Tea', 34000, 'Tea'),
    ('DU016', 'Strawberry Banana ', 45000, 'Smoothie'),
    ('DU017', 'Mango Pineapple ', 48000, 'Smoothie'),
    ('DU018', 'Berry Burst ', 46000, 'Smoothie'),
    ('DU019', 'Green', 49000, 'Smoothie'),
    ('DU020', 'Peach Passion Fruit', 47000, 'Smoothie');

	INSERT INTO CHITIETDOUONG (soLuong, maDoUong, maNguyenLieu)
VALUES 
    (1, 'DU001', 'NL001'),
    (2, 'DU001', 'NL002'),
    (1, 'DU001', 'NL005'),
    (1, 'DU002', 'NL001'),
    (1, 'DU002', 'NL002'),
    (1, 'DU002', 'NL003'),
    (1, 'DU003', 'NL002'),
    (2, 'DU003', 'NL003'),
    (1, 'DU003', 'NL005'),
    (1, 'DU004', 'NL001'),
    (1, 'DU004', 'NL002');

-- Tạo dữ liệu cho bảng HOADON
INSERT INTO HOADON (maHoaDon, tongTien, ngayBan, maNhanVien, maKhachHang, soThe)
VALUES 
    ('HD001', 100000, '2024-04-01', 'NV001', 'KH001', 1),
    ('HD002', 150000, '2024-04-02', 'NV002', 'KH002', 2),
    ('HD003', 200000, '2024-04-03', 'NV003', 'KH003', 3),
    ('HD004', 120000, '2024-04-04', 'NV001', 'KH002', 1),
    ('HD005', 175000, '2024-04-05', 'NV003', 'KH004', 2);

-- Tạo dữ liệu cho bảng CHITIETHOADON
INSERT INTO CHITIETHOADON (maHoaDon, maDoUong, soLuong, donGia)
VALUES 
    ('HD001', 'DU001', 2, 60000),
    ('HD001', 'DU002', 1, 35000),
    ('HD002', 'DU001', 1, 30000),
    ('HD002', 'DU002', 1, 35000),
    ('HD002', 'DU003', 1, 40000),
    ('HD003', 'DU002', 2, 70000),
    ('HD003', 'DU003', 1, 40000),
    ('HD004', 'DU001', 2, 60000),
    ('HD004', 'DU003', 1, 40000),
    ('HD005', 'DU001', 1, 30000),
    ('HD005', 'DU002', 1, 35000),
    ('HD005', 'DU003', 2, 80000);

create trigger updateDiem
on HOADON
for insert as
	update KHACHHANG set diemTichLuy=diemTichLuy + (select FLOOR(tongTien/10000) from inserted) where maKhachHang = (select maKhachHang from inserted)