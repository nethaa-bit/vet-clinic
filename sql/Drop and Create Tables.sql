--Drop tables in case they already exist in database--
DROP TABLE SCHEDULE;
DROP TABLE PAYMENT;
DROP TABLE CREDITCARD;
DROP TABLE TRANSACTION_SERVICE;
DROP TABLE TRANSACTION1;
DROP TABLE PET;
DROP TABLE WORKSHIFT;
DROP TABLE STAFF;
DROP TABLE CUSTOMER;
DROP TABLE SERVICE;

--Create tables--
CREATE TABLE SERVICE (
serviceID VARCHAR(5) NOT NULL,
serviceTitle VARCHAR(50) NOT NULL,
unitPrice DECIMAL(6,2) NOT NULL CHECK (unitPrice >= 0.00),
serviceDesp VARCHAR(100) NOT NULL,
PRIMARY KEY (serviceID)
);

CREATE TABLE CUSTOMER (
custIC CHAR(12) NOT NULL,
custName VARCHAR(30) NOT NULL,
custGender CHAR(1) NOT NULL,
custAddress VARCHAR(255) NOT NULL,
custPhoneNum VARCHAR(12) NOT NULL,
PRIMARY KEY (custIC)
);

CREATE TABLE STAFF (
staffIC CHAR(12) NOT NULL,
staffName VARCHAR(30) NOT NULL,
staffAddress VARCHAR(255) NOT NULL,
staffPhone VARCHAR(12) NOT NULL,
staffPosition VARCHAR(30) NOT NULL,
staffQualification VARCHAR(20) NOT NULL,
password VARCHAR(103) NOT NULL,
securityAns VARCHAR(50) NOT NULL,
PRIMARY KEY (staffIC)
);

CREATE TABLE WORKSHIFT (
timeSlotNum INTEGER NOT NULL,
startTime TIME NOT NULL,
endTime TIME NOT NULL,
PRIMARY KEY (timeSlotNum)
);

CREATE TABLE PET (
petID VARCHAR(10) NOT NULL,
petName VARCHAR(30) NOT NULL,
petHeight DECIMAL(5,2),
petWeight DECIMAL(4,1) NOT NULL,
petLength DECIMAL(5,2) NOT NULL,
animalType VARCHAR(20) NOT NULL,
breed VARCHAR(20), 
petBirthDate DATE NOT NULL,
petGender CHAR(1) NOT NULL,
custIC CHAR(12) references CUSTOMER(custIC),
PRIMARY KEY (petID)
);

CREATE TABLE TRANSACTION1 (
transID VARCHAR(15) NOT NULL,
transDate DATE NOT NULL,
transTime VARCHAR(10) NOT NULL,
petID VARCHAR(10) references PET(petID),
PRIMARY KEY (transID)
);

CREATE TABLE TRANSACTION_SERVICE (
transID VARCHAR(15) references TRANSACTION1(transID),
serviceID VARCHAR(5) references SERVICE(serviceID),
staffIC CHAR(12) references STAFF(staffIC),
remarks VARCHAR(250),
PRIMARY KEY (transID, serviceID)
);

CREATE TABLE CreditCard (
CCNum CHAR(16) NOT NULL,
CCExpiryDate DATE NOT NULL,
issuingAgent VARCHAR(20) NOT NULL,
CVC CHAR(3) NOT NULL,
cardHolderName VARCHAR(30) NOT NULL,
cardName VARCHAR(30),
custIC CHAR(12) references CUSTOMER(custIC),
PRIMARY KEY (CCNum)
);

CREATE TABLE Payment (
paymentID VARCHAR(15) NOT NULL,
amountPaid DECIMAL(6,2) NOT NULL CHECK (amountPaid>= 0.00),
methodOfPayment VARCHAR(12) NOT NULL,
paymentDate DATE NOT NULL,
transID VARCHAR(15) references TRANSACTION1(transID),
staffIC CHAR(12) references STAFF(staffIC),
CCNum CHAR(16) references CREDITCARD(CCNum),
PRIMARY KEY (paymentID)
);

CREATE TABLE Schedule(
appID VARCHAR(10) NOT NULL,
appTime TIME NOT NULL,
appDate DATE NOT NULL,
custName VARCHAR(30) NOT NULL,
custPhoneNum VARCHAR(12) NOT NULL,
status VARCHAR(15) NOT NULL,
transID VARCHAR(15) references TRANSACTION1(transID) UNIQUE,
PRIMARY KEY (appID)
);