CREATE DATABASE DKDT_CNPM;

USE DKDT_CNPM;

-- Giảng viên
CREATE TABLE Teachers(
	teacherId VARCHAR(20),
    teacherName NVARCHAR(32) NOT NULL,
    gender BIT NOT NULL,
    birth DATE NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    phone VARCHAR(11) NOT NULL,
    lead BIT NOT NULL,
    degree NVARCHAR(32) NOT NULL,
    CONSTRAINT TeacherKey
        PRIMARY KEY (teacherId)
);
GO

CREATE TABLE Students(
    studentId VARCHAR(20),
    studentName NVARCHAR(100) NOT NULL,
    gender BIT NOT NULL,
    birth DATE NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    phone VARCHAR(11) NOT NULL,
    address NVARCHAR(510) NOT NULL,
    lead BIT NOT NULL,
    CONSTRAINT StudentKey
        PRIMARY KEY ( studentId)
);
GO

CREATE TABLE Administrators(
    adminId VARCHAR(20),
    adminName NVARCHAR(32) NOT NULL,
    gender BIT NOT NULL,
    birth DATE NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    phone VARCHAR(11) NOT NULL,
    degree NVARCHAR(32) NOT NULL,
    CONSTRAINT AdminKey
        PRIMARY KEY (adminId)
);
GO

-- Nhóm
CREATE TABLE Groups(
    groupId VARCHAR(20),
    groupName NVARCHAR(100) NOT NULL
    CONSTRAINT GroupKey
        PRIMARY KEY(groupId)
);
GO

-- Chuyên ngành
CREATE TABLE Majors(
    majorId VARCHAR(20),
    majorName NVARCHAR(32) NOT NULL UNIQUE,
    CONSTRAINT MajorKey
        PRIMARY KEY(majorId)
);
GO

-- Đề tài
CREATE TABLE Topics(
    topicId VARCHAR(20),
    topicName NVARCHAR(50) NOT NULL UNIQUE,
    detail NVARCHAR(500),
    CONSTRAINT TopicKey
        PRIMARY KEY(topicId)
);
GO

-- Hội đồng coi thi
CREATE TABLE ExaminationBoards(
    examinationBoardId VARCHAR(20),
    examinationBoardName NVARCHAR(50) NOT NULL,
    CONSTRAINT ExaminationBoardKey
        PRIMARY KEY(examinationBoardId)
);
GO

--Report
CREATE TABLE Report(
    reportId VARCHAR(20),
    review NVARCHAR(500),
    result FLOAT NOT NULL,
    CONSTRAINT ReportKey
        PRIMARY KEY(reportId)
);
GO

CREATE TABLE SignUp(
    signUpId VARCHAR(20),
    startTime DATETIME NOT NULL,
    endTime DATETIME NOT NULL,
    subject NVARCHAR(50) NOT NULL,
    CONSTRAINT SignUpKey
        PRIMARY KEY(signUpId)
);
GO

-- Admin Tạo đợt đăng ký
ALTER TABLE Administrators ADD signUpId VARCHAR(20);
GO
ALTER TABLE Administrators ADD CONSTRAINT [Admin_signUp_FK] FOREIGN KEY (signUpId) REFERENCES SignUp(signUpId);
GO
-- Đợt đăng ký - Đề tài
ALTER TABLE Topics ADD signUpId VARCHAR(20) NOT NULL UNIQUE;
GO
ALTER TABLE Topics ADD CONSTRAINT [Topic_signUp_FK] FOREIGN KEY (signUpId) REFERENCES SignUp(signUpId);
GO
-- Đề tài thuộc chuyên ngành
ALTER TABLE Topics ADD majorId VARCHAR(20) NOT NULL;
GO
ALTER TABLE Topics ADD CONSTRAINT [Topic_Major_FK] FOREIGN KEY (majorId) REFERENCES Majors(majorId);
GO
--  Admin Tạo hội đồng coi thi
ALTER TABLE Administrators ADD examinationBoardId VARCHAR(20);
GO
ALTER TABLE Administrators ADD CONSTRAINT [Admin_ExaminationBoard_FK] FOREIGN KEY (examinationBoardId) REFERENCES ExaminationBoards(examinationBoardId);
GO
-- Giảng viên tạo đề tài
ALTER TABLE Teachers ADD topicId VARCHAR(20) NOT NULL;
GO
ALTER TABLE Teachers ADD CONSTRAINT [Teacher_Topic_FK] FOREIGN KEY (topicId) REFERENCES Topics(topicId);
GO
-- Giảng viên thuộc hội đồng coi thi
CREATE TABLE Teacher_ExaminationBoard(
    _id INT IDENTITY(1, 1),
    teacherId VARCHAR(20),
    examinationBoardId VARCHAR(20),
    CONSTRAINT Teacher_ExaminationBoardKey
        PRIMARY KEY(_id, teacherId, examinationBoardId),
    CONSTRAINT [Teacher_ExaminationBoard_FK] FOREIGN KEY (teacherId) REFERENCES Teachers(teacherId),
    CONSTRAINT [ExaminationBoard_Teacher_FK] FOREIGN KEY (examinationBoardId) REFERENCES ExaminationBoards(examinationBoardId)
);
GO
-- Giảng viên thuộc chuyên ngành
ALTER TABLE Teachers ADD majorId VARCHAR(20) NOT NULL;
GO
ALTER TABLE Teachers ADD CONSTRAINT [Teacher_Major_FK] FOREIGN KEY (majorId) REFERENCES Majors(majorId);
GO
-- Sinh viên thuộc nhóm
ALTER TABLE Students ADD groupId VARCHAR(20) NOT NULL;
GO
ALTER TABLE Students ADD CONSTRAINT [Student_Group_FK] FOREIGN KEY (groupId) REFERENCES Groups(groupId);
GO
-- Nhóm nộp báo cáo
ALTER TABLE Report ADD groupId VARCHAR(20) NOT NULL UNIQUE;
GO
ALTER TABLE Report ADD CONSTRAINT [Report_Group_FK] FOREIGN KEY (groupId) REFERENCES Groups(groupId);
GO
-- Hội đồng thi nhận báo cáo
ALTER TABLE Report ADD examinationBoardId VARCHAR(20) NOT NULL;
GO
ALTER TABLE Report ADD  CONSTRAINT [Report_ExaminationBoard_FK] FOREIGN KEY (examinationBoardId) REFERENCES ExaminationBoards(examinationBoardId);
GO
-- Sinh viên thuộc chuyên ngành
ALTER TABLE Students ADD majorId VARCHAR(20) NOT NULL UNIQUE;
GO
ALTER TABLE Students ADD CONSTRAINT [Student_Major_FK] FOREIGN KEY (majorId) REFERENCES Majors(majorId);
GO