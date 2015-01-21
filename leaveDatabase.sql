CREATE DATABASE leaveDatabase;

USE leaveDatabase;

Create table LeaveDays(
id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
PRIMARY KEY (id),
yearEmployed DATE NOT NULL,
sickDaysLeft INT UNSIGNED NOT NULL DEFAULT 0,
sickDaysTotal INT UNSIGNED NOT NULL DEFAULT 0,
familyDaysLeft INT UNSIGNED NOT NULL DEFAULT 0,
familyDaysTotal INT UNSIGNED NOT NULL DEFAULT 0,
maternityDaysLeft INT UNSIGNED NOT NULL DEFAULT 0,
maternityDaysTotal INT UNSIGNED NOT NULL DEFAULT 0,
annualDaysLeft INT UNSIGNED NOT NULL DEFAULT 0,
annualDaysTotal INT UNSIGNED NOT NULL DEFAULT 0 );

Create table Employee(id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
PRIMARY KEY (id),
leaveId BIGINT UNSIGNED NOT NULL,
FOREIGN KEY (leaveId) REFERENCES leavedays (id),
username varchar (20) NOT NULL,
firstName varchar (255) NOT NULL,
lastName varchar (255) NOT NULL ,
phoneNumber varchar (255) NOT NULL,
email varchar (255) NOT NULL,
jobTitle varchar (255),
supervisorId BIGINT unsigned,
FOREIGN KEY (supervisorId) REFERENCES Employee (id),
active Boolean NOT NULL DEFAULT TRUE,
password varchar(255) NOT NULL,
role varchar(255) NOT NULL DEFAULT 'employee',
version INT UNSIGNED DEFAULT 0);

Create table Request(
id  BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
PRIMARY KEY (id),
employeeid BIGINT UNSIGNED NOT NULL,
FOREIGN KEY (employeeid) REFERENCES Employee (id),
timestamp timestamp NOT NULL ,
leaveType varchar (255) NOT NULL ,
reason TEXT NOT NULL ,
startDate Date NOT NULL ,
endDate Date NOT NULL ,
state varchar (255),
comment  TEXT);


INSERT INTO leavedays(yearEmployed) VALUE ('2006-01-01');
INSERT INTO Employee (leaveId,username,firstName,lastName,phoneNumber,email,jobTitle,password)VALUES (1,'Vzulu','Vane','Zulu','27718903620','vane@ubiquitech.co.za','Trainee','$2a$10$HTwDZJ1tLQobcObmlQH28.DC3fe1coMj.9H1dXj.Ul7A0q9Ktk9P.');



