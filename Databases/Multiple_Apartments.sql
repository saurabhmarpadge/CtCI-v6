
DROP TABLE AptTenants ;
DROP TABLE Requests ;
DROP TABLE Apartments;
DROP TABLE Buildings ;
DROP TABLE Tenants, Complexes;

CREATE TABLE Complexes(
	complexid int   NOT NULL,
	complexname varchar(100) NOT NULL,
	PRIMARY KEY(complexid)
);
CREATE TABLE Tenants(
	tenantid int   NOT NULL,
	tenantname varchar(100) NOT NULL,
	PRIMARY KEY(tenantid)
);
CREATE TABLE Buildings(
	buildingid int   NOT NULL,
	complexid int FOREIGN KEY REFERENCES Complexes(complexid),
	buildingname varchar(100) NOT NULL,
	address varchar(500) NOT NULL,
	PRIMARY KEY(buildingid)
);
CREATE TABLE Apartments(
	aptid int   NOT NULL,
	unitnumber varchar(20) NOT NULL,
	buildingid int FOREIGN KEY REFERENCES Buildings(buildingid),
	PRIMARY KEY(aptid)
);
CREATE TABLE AptTenants(
	tenantid int FOREIGN KEY REFERENCES Tenants(tenantid),
	aptid int FOREIGN KEY REFERENCES Apartments(aptid)
);
CREATE TABLE Requests(
	requestid int NOT NULL,
	status varchar(100) NOT NULL,
	aptid int FOREIGN KEY REFERENCES Apartments(aptid),
	description varchar(500) NOT NULL,
	PRIMARY KEY(requestid)
);

Insert into Complexes(complexid,complexname) values (1,'H&M') , (2,'Kolte Patil') , (3,'Kubera') , (4,'Salunke Vihar') , (5,'Aarti') , (6,'Sheetal')
Insert into Tenants(tenantid,tenantname) values (1,'Khushal') , (2,'Sneha') , (3,'Kedar') , (4,'Vinayak') , (5,'Aarti') , (6,'Sheetal')
Insert into Buildings(buildingid,complexid,buildingname,address) values (1,1,'A','abc'),(2,1,'B','def'),(3,2,'C','ghi'),(4,2,'D','jkl'),(5,3,'E','mno'),(6,3,'F','pqr')
Insert into Apartments(aptid,unitnumber,buildingid) values (1,2,1) , (2,1,1) , (3,4,3) , (4,3,3),(5,5,1) , (6,6,3),(7,2,6) , (8,1,3) , (9,4,2)
Insert into AptTenants(tenantid,aptid) values (1,2) , (2,1) , (3,4) , (4,3),(1,7) , (2,8) , (3,9) , (4,4),(5,5) , (6,6)
Insert into Requests(requestid,status,aptid,description) values (1,'Open',1,'Good'), (2,'Close',2,'Nice'), (3,'Open',6,'Excellent'),(4,'Close',4,'Cool'),(5,'Open',2,'Awesome')


select * from Complexes
select * from Tenants
select * from Buildings
select * from Apartments
select * from AptTenants
select * from Requests

select Tenants.tenantname from (
	select tenantid
	from Apttenants
	group by tenantid
	having count(aptid)>1
) as AptCount left join Tenants on Tenants.tenantid = AptCount.tenantid

