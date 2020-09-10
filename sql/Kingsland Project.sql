DROP DATABASE kingsland;
CREATE DATABASE kingsland;
USE kingsland;

CREATE TABLE student(
	stId VARCHAR(10) NOT NULL,
    stName VARCHAR(45) NOT NULL,
    stAddress VARCHAR(45) NOT NULL,
    stContact VARCHAR(45) NOT NULL,
    stDob DATE NOT NULL,
    stGender VARCHAR(45) NOT NULL,
    CONSTRAINT PRIMARY KEY(stId)
);

CREATE TABLE course(
	courseCode VARCHAR(20) NOT NULL,
    courseName VARCHAR(45) NOT NULL,
    courseIntake VARCHAR(45) NOT NULL,
    courseFee DOUBLE(10,2),
    courseDuration VARCHAR(20) NOT NULL,
    CONSTRAINT PRIMARY KEY(courseCode)
);

CREATE TABLE registration(
	regNo INT NOT NULL,
    regDate DATE,
    regFee DOUBLE(10,2),
    stID VARCHAR(45),
    courseCode VARCHAR(20),
	CONSTRAINT PRIMARY KEY(regNo,stId,courseCode),
    CONSTRAINT FOREIGN KEY(stId) REFERENCES student(stId) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT FOREIGN KEY(courseCode) REFERENCES course(courseCode) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO student(stId,stName,stAddress,stContact,stDob,stGender)
		VALUES ('S001','Mindula','Matara','0764184020','2000-10-23','Male'),
			   ('S002','Shashini','Galle','0702498385','2000-01-17','Female'),
			   ('S003','Shan','Colombo','0752915762','2000-04-01','Male');

INSERT INTO course(courseCode,courseName,courseIntake,courseFee,courseDuration)
		VALUES ('C001','ABCD','Spring',60000.00,'1 Year'),
			   ('C002','BCSC','Fall',80000.00,'2 Year'),
			   ('C003','DFHS','Summer',50000.00,'2 Year');

INSERT INTO registration(regNo,stID,courseCode,regDate,regFee)
		VALUES (1,'S001','C001','2020-09-09',5000.00),
			   (2,'S002','C002','2020-09-10',7000.00),
			   (3,'S003','C003','2020-09-11',6000.00);
               
SELECT * FROM student;
SELECT * FROM course;
SELECT * FROM registration;

DESC student;
DESC course;
DESC registration;
