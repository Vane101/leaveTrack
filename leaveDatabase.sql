CREATE DATABASE leaveDatabase character set utf8;

USE leaveDatabase;

CREATE TABLE LeaveDays (
  id                 BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (id),
  yearEmployed       DATE            NOT NULL,
  sickDaysLeft       INT UNSIGNED    NOT NULL DEFAULT 0,
  sickDaysTotal      INT UNSIGNED    NOT NULL DEFAULT 0,
  familyDaysLeft     INT UNSIGNED    NOT NULL DEFAULT 0,
  familyDaysTotal    INT UNSIGNED    NOT NULL DEFAULT 0,
  maternityDaysLeft  INT UNSIGNED    NOT NULL DEFAULT 0,
  maternityDaysTotal INT UNSIGNED    NOT NULL DEFAULT 0,
  annualDaysLeft     INT UNSIGNED    NOT NULL DEFAULT 0,
  annualDaysTotal    INT UNSIGNED    NOT NULL DEFAULT 0);

CREATE TABLE Employee (id           BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (id),
                       leaveId      BIGINT UNSIGNED NOT NULL,
  FOREIGN KEY (leaveId) REFERENCES leavedays (id),
                       username     VARCHAR(20)     NOT NULL,
                       employeeName VARCHAR(255)    NOT NULL,
                       phoneNumber  VARCHAR(255)    NOT NULL,
                       email        VARCHAR(255)    NOT NULL,
                       jobTitle     VARCHAR(255),
                       supervisorId BIGINT UNSIGNED,
  FOREIGN KEY (supervisorId) REFERENCES Employee (id),
                       active       BOOLEAN         NOT NULL DEFAULT TRUE,
                       password     VARCHAR(255)    NOT NULL,
                       role         VARCHAR(255)    NOT NULL DEFAULT 'employee',
                       version      INT UNSIGNED DEFAULT 0);

CREATE TABLE Request (
  id         BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (id),
  employeeid BIGINT UNSIGNED NOT NULL,
  FOREIGN KEY (employeeid) REFERENCES Employee (id),
  timestamp  TIMESTAMP       NOT NULL,
  leaveType  VARCHAR(255)    NOT NULL,
  reason     TEXT            NOT NULL,
  startDate  DATE            NOT NULL,
  endDate    DATE            NOT NULL,
  state      VARCHAR(255),
  comment    TEXT);


INSERT INTO leavedays (yearEmployed) VALUE ('2006-01-01');
INSERT INTO Employee (leaveId, username, employeeName, phoneNumber, email, jobTitle, password) VALUES
  (1, 'VZULU', 'VANE ZULU', '27718903620', 'vane@ubiquitech.co.za', 'TRAINEE',
   '$2a$10$HTwDZJ1tLQobcObmlQH28.DC3fe1coMj.9H1dXj.Ul7A0q9Ktk9P.');



