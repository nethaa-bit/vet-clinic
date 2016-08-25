INSERT INTO NBUSER.STAFF (STAFFIC, STAFFNAME, STAFFADDRESS, STAFFPHONE, STAFFPOSITION, STAFFQUALIFICATION, PASSWORD, SECURITYANS) 
	VALUES ('941207016566', 'Krishnapriya', '07 Jln Ros Merah_Taman Johor Jaya_81100_Johor Bahru_Johor', '07-3576157', 'Veterinerian', 'Bachelor''s Degree', '1000:03f273ebfa1c7b272b4530fb522bd6d0aa605db7b4b0c98c:91d043f2279d5ea492f012ec71376ed8e7e362fadddeb8d7', 'cblue');
INSERT INTO NBUSER.STAFF (STAFFIC, STAFFNAME, STAFFADDRESS, STAFFPHONE, STAFFPOSITION, STAFFQUALIFICATION, PASSWORD, SECURITYANS) 
	VALUES ('940928145232', 'Chen Li San', '57, Taman Sri Raub Sempalit__27600_Raub_Pahang', '013-9280313', 'Manager', 'Masters Degree', '1000:fc4bdfe0840b780e024c62cabdd886bd84d8df3025a39b77:15aa49c6ae79f6cdec1f5f68cfb8447eb3235cd8820c1e99', 'hraub');
INSERT INTO NBUSER.STAFF (STAFFIC, STAFFNAME, STAFFADDRESS, STAFFPHONE, STAFFPOSITION, STAFFQUALIFICATION, PASSWORD, SECURITYANS) 
	VALUES ('840613258956', 'Xiao Liow', '100, Jalan Mahsuri 10_Segamat Baru_85000_Segamat_Pahang', '018-8745252', 'Manager', 'Masters Degree', '1000:bafbfb0dd13bf4f25f86524c44a7dc6d7eb2706316a7b0b4:c89660cbec69db05397589988a42d767d8e6453cb0b779e6', 'hsegamat');
INSERT INTO NBUSER.CUSTOMER (CUSTIC, CUSTNAME, CUSTGENDER, CUSTADDRESS, CUSTPHONENUM) 
	VALUES ('940928010101', 'Li San', 'F', '03, Jalan Sempalit 3_Taman Tiga_53333_Raub_Pahang', '013-9283333');
INSERT INTO NBUSER.CUSTOMER (CUSTIC, CUSTNAME, CUSTGENDER, CUSTADDRESS, CUSTPHONENUM) 
	VALUES ('860419784695', 'Li Ann', 'F', '58, Jalan 123_Taman Sempalit_27600_Raub_Pahang', '012-3315669');


INSERT INTO NBUSER.PET (PETID, PETNAME, PETHEIGHT, PETWEIGHT, PETLENGTH, ANIMALTYPE, BREED, PETBIRTHDATE, PETGENDER, CUSTIC) 
	VALUES ('A1', 'Targup', 55.00, 17.5, 79.80, 'Canine', '', '2010-08-19', 'M', '940928010101');
INSERT INTO NBUSER.PET (PETID, PETNAME, PETHEIGHT, PETWEIGHT, PETLENGTH, ANIMALTYPE, BREED, PETBIRTHDATE, PETGENDER, CUSTIC) 
	VALUES ('A2', 'Angela', 60.00, 20.0, 82.30, 'Canine', 'Siberian Husky', '2014-08-08', 'F', '940928010101');
INSERT INTO NBUSER.PET (PETID, PETNAME, PETHEIGHT, PETWEIGHT, PETLENGTH, ANIMALTYPE, BREED, PETBIRTHDATE, PETGENDER, CUSTIC) 
	VALUES ('A3', 'Junior', 38.00, 8.0, 67.00, 'Feline', '', '2013-08-21', 'M', '940928010101');


INSERT INTO NBUSER.SERVICE (SERVICEID, SERVICETITLE, UNITPRICE, SERVICEDESP) 
	VALUES ('S0002', 'Veterinary Cardiology', 180.00, 'Heart and blood related services');
INSERT INTO NBUSER.SERVICE (SERVICEID, SERVICETITLE, UNITPRICE, SERVICEDESP) 
	VALUES ('S0003', 'Current natural bolistic', 145.00, 'Current natural bolistic');
INSERT INTO NBUSER.SERVICE (SERVICEID, SERVICETITLE, UNITPRICE, SERVICEDESP) 
	VALUES ('S0004', 'Medical therapies', 85.00, 'Medical therapies');
INSERT INTO NBUSER.SERVICE (SERVICEID, SERVICETITLE, UNITPRICE, SERVICEDESP) 
	VALUES ('S0005', 'Radiology', 80.00, 'X-ray, CT scan and MRI scan');
INSERT INTO NBUSER.SERVICE (SERVICEID, SERVICETITLE, UNITPRICE, SERVICEDESP) 
	VALUES ('S0006', 'Ultrasound', 98.00, 'Ultrasound');
INSERT INTO NBUSER.SERVICE (SERVICEID, SERVICETITLE, UNITPRICE, SERVICEDESP) 
	VALUES ('S0007', 'Blood haematology', 50.00, 'Blood-realted testing and diseases');
INSERT INTO NBUSER.SERVICE (SERVICEID, SERVICETITLE, UNITPRICE, SERVICEDESP) 
	VALUES ('S0008', 'Biochemistry', 50.00, 'Biochemistry tests');
INSERT INTO NBUSER.SERVICE (SERVICEID, SERVICETITLE, UNITPRICE, SERVICEDESP) 
	VALUES ('S0009', 'Urine', 133.00, 'Urine-related services');
INSERT INTO NBUSER.SERVICE (SERVICEID, SERVICETITLE, UNITPRICE, SERVICEDESP) 
	VALUES ('S0010', 'Faecal assay', 99.00, '');
INSERT INTO NBUSER.SERVICE (SERVICEID, SERVICETITLE, UNITPRICE, SERVICEDESP) 
	VALUES ('S0011', 'Skin analysis', 85.00, 'Analysis of skin');
INSERT INTO NBUSER.SERVICE (SERVICEID, SERVICETITLE, UNITPRICE, SERVICEDESP) 
	VALUES ('S0012', 'Cytology', 90.00, 'Study and testing of cell structure');
INSERT INTO NBUSER.SERVICE (SERVICEID, SERVICETITLE, UNITPRICE, SERVICEDESP) 
	VALUES ('S0013', 'Histology', 200.00, 'microscopic anatomy (microanatomy)');
INSERT INTO NBUSER.SERVICE (SERVICEID, SERVICETITLE, UNITPRICE, SERVICEDESP) 
	VALUES ('S0014', 'Hydrotherapy', 120.00, 'treatment for conditions such as arthritis or partial paralysis');
INSERT INTO NBUSER.SERVICE (SERVICEID, SERVICETITLE, UNITPRICE, SERVICEDESP) 
	VALUES ('S0015', 'Electrotherapy', 76.00, 'Electrotherapy for neorological diseases');
INSERT INTO NBUSER.SERVICE (SERVICEID, SERVICETITLE, UNITPRICE, SERVICEDESP) 
	VALUES ('S0016', 'Allergy management', 89.00, 'Allergy management & cultures');
INSERT INTO NBUSER.SERVICE (SERVICEID, SERVICETITLE, UNITPRICE, SERVICEDESP) 
	VALUES ('S0017', 'Cryo surgery', 155.00, 'Cryo surgery');
INSERT INTO NBUSER.SERVICE (SERVICEID, SERVICETITLE, UNITPRICE, SERVICEDESP) 
	VALUES ('S0018', 'Laser surgery', 67.00, '');
INSERT INTO NBUSER.SERVICE (SERVICEID, SERVICETITLE, UNITPRICE, SERVICEDESP) 
	VALUES ('S0019', 'Nutrition', 87.00, 'Nutritional Consulting');
INSERT INTO NBUSER.SERVICE (SERVICEID, SERVICETITLE, UNITPRICE, SERVICEDESP) 
	VALUES ('S0020', 'Skin disease', 56.00, 'Laser surgery');
INSERT INTO NBUSER.SERVICE (SERVICEID, SERVICETITLE, UNITPRICE, SERVICEDESP) 
	VALUES ('S0021', 'Allergies', 90.00, 'Allergies & intolerances');




