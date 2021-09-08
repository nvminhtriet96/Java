CREATE DATABASE BAITHI3;
GO
USE BAITHI3;
GO
create table Person (
   [Type] varchar(100),
   ID varchar(50) PRIMARY KEY,
   HoTen varchar(100),
   NgaySinh date,
   NgayBatDauCachLy date,
   MaPhongCachLy varchar(100),
   [TinhThanh/QuocGia] varchar(100),
   [MaChuyenBay/PhuongTien] varchar(100),
   SoNgayCachLy int,
   TinhTrang int,
)
go
drop table Person









  delete from House2 where month(getdate()) - month(CreateDate) = 2
  select * from House2 where month(CreateDate) = 5
  DATEDIFF
 delete from House2 where DATEDIFF(DAY,CreateDate,getdate()) > 90
 select DATEDIFF(DAY,'2021-07-01',getdate())
create table House2 (
   [Type] varchar(100),
   HouseID varchar(50) PRIMARY KEY,
   [Address] varchar(100),
   Area varchar(100),
   RetalPrice varchar(100),
   Phone varchar(100),
   [CreateDate] date,
   PrincipalFace varchar(100),
   NumberOfFloor varchar(100),
   OfficeCapacity varchar(100),
   Bedroom varchar(100),
   Badroom varchar(100),
)
go
drop table House2

CREATE TABLE Store (
   [Type] char PRIMARY KEY,
   HouseID varchar(50),
   [Address] char,
   Area int,
   RetalPrice money,
   Phone char,
   [CreateDate] char,
   PrincipalFace int,
   NumberOfFloor int,
   OfficeCapacity int,
   Bedroom int,
   Badroom int,
)
go
CREATE TABLE Office (
   [Type] char PRIMARY KEY,
   HouseID varchar(50),
   [Address] char,
   Area int,
   RetalPrice money,
   Phone char,
   [CreateDate] char,
   OfficeCapacity int,
)
go
CREATE TABLE Apartment (
   [Type] char PRIMARY KEY,
   HouseID varchar(50),
   [Address] char,
   Area int,
   RetalPrice money,
   Phone char,
   [CreateDate] char,
   Bedroom int,
   Badroom int,
)
go