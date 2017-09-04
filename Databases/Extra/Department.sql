DROP TABLE StudentCourses
DROP TABLE Courses
DROP TABLE Students,Teachers

CREATE TABLE Students(
	studentid int   NOT NULL,
	studentname varchar(20) NOT NULL,
	PRIMARY KEY(studentid)
);

CREATE TABLE Teachers(
	teacherid int   NOT NULL,
	teachername varchar(20) NOT NULL,
	PRIMARY KEY(teacherid)
);

CREATE TABLE Courses(
	courseid int   NOT NULL,
	coursename varchar(20) NOT NULL,
	teacherid int  FOREIGN KEY REFERENCES Teachers(teacherid),
	PRIMARY KEY(courseid)
);

CREATE TABLE StudentCourses(
	courseid int  FOREIGN KEY REFERENCES Courses(courseid),
	studentid int FOREIGN KEY REFERENCES Students(studentid),
);

Insert into Students(studentid,studentname) values (1,'Khushal') , (2,'Sneha') , (3,'Kedar') , (4,'Vinayak') , (5,'Aarti') , (6,'Sheetal')
Insert into Teachers(teacherid,teachername) values  (1,'Prasann') , (2,'Rahul') , (3,'Tanaji') , (4,'Shabi') , (5,'Shashank') , (6,'Aaditya'),(7,'Ashutosh')
Insert into Courses(courseid,coursename,teacherid) values (1,'OS',1) , (2,'Database',2) , (3,'System Design',3) , (4,'Softskills',4) , (5,'Agile',5) , (6,'MIS',6),(7,'Game',1) , (8,'Math',2) , (9,'OOPD',3)
Insert into StudentCourses(courseid,studentid) values (1,2) , (2,1) , (3,4) , (4,3),(1,1) , (2,2) , (3,3) , (4,4),(5,5) , (6,6),(7,2) , (8,1) , (9,4)


select * from Students
select * from Teachers
select * from Courses
select * from StudentCourses

/*
 *Implement a query to get a list of all students and how many courses each student is enrolled in.
 */

select Students.studentid,Students.studentname, CourseCount
from
	(select Students.studentid,count(StudentCourses.courseid)as CourseCount
	from Students left join  StudentCourses
	on StudentCourses.studentid = Students.studentid
	group by Students.studentid
) as T inner join Students on T.studentid = Students.studentid


Select Students.studentid,studentname,COUNT(StudentCourses.courseid) as CourseCount
from Students inner join StudentCourses
on Students.studentid = StudentCourses.studentid
group by Students.studentid,studentname

/*
 * Implement a query to get a list of all teachers and how many students they each teach. If a teacher teaches
 * the same student in two courses, you should double count the student. Sort the list in descending order of
 * the number of students a teacher teaches.
 */

 select Teachers.teacherid,Teachers.teachername,isnull([StudentCount],0) as StudentsCount
 from (
	 select Courses.teacherid,count(StudentCourses.studentid) as [StudentCount]
	 from Courses inner join StudentCourses
	 on Courses.courseid = StudentCourses.courseid
	 group by  Courses.teacherid
) as StudentSize right join Teachers
  on Teachers.teacherid = StudentSize.teacherid
  order by StudentSize.StudentCount desc
