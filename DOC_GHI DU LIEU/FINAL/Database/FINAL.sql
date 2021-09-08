CREATE DATABASE FINAL
GO
USE FINAL;
GO

CREATE TABLE GoodStudent (
   student_id int identity(1,1) PRIMARY KEY,
   fullName varchar(50),
   doB Date,
   sex varchar(10),
   phoneNumber char(10),
   universityName varchar(50),
   gradeLevel varchar(20),
   gpa money,
   bestRewardName varchar(50)
)
go
CREATE TABLE NormalStudent (
   student_id int identity(1,1) PRIMARY KEY,
   fullName varchar(50),
   doB Date,
   sex varchar(10),
   phoneNumber char(10),
   universityName varchar(50),
   gradeLevel varchar(20),
   englishScore int,
   entryTestScore money
)
go
drop table if exists GoodStudent
go
drop table if exists NormalStudent
go
delete from GoodStudent where student_id in (1,100)