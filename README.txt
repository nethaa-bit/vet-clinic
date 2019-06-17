			Veterinary Clinic System

Introduction
-------------------

	The Veterinary Clinic System is an information system designed to serve the needs of a veterinary clinic. It is designed to manage the information of the clinic's staff, customers and their pets, the services provided by the clinic as well the details of transactions between the clinic's staff and its customers. The Veterinary Clinic System shall thereafter be referred to as the "application" or "system".

Prerequisites
-------------------

	The database needed to deploy this application can be found at the \.netbeans-derby directory. The name of the database is vetdb. 

Username for Database	: nbuser
Password for Database	: nbuser

If needed, the sql statements required to manually create tables and populate the database with data can be found at the \SQL directory. 

Installation
-----------------

	The application may be installed on to a Windows Operating System by running Veterinary Clinic System-1.0.exe installer file. Additionally, the application may be deployed through its source code (See Sources Section).

User access
------------------

	The intended users of the system are the veterinary clinic system's staff different staff position. Only users with Manager position can access Report module of the system. Initial access into the system may be gained by using the one of the following user credentials :

Username	: 840613258956
Password		: Ab12345!
Position		: Manager

Username	: 841212011212
Password		: Bc12345!
Position		: Veterinerian 

Modules and Submodules
----------------------------------------
	The system has several modules. Major modules of the system are as follows:

Staff		: Search, Add, Modify or Delete staff information
Schedule		: Search, Add, Modify or Delete appointments
Pet		: Search, Add, Modify or Delete pet information
Customer		: Search, Add, Modify or Delete customer information
Service		: Search, Add, Modify or Delete service information
Transaction	: Search, Add, Modify or Delete transactions
Payment		: Search or  Add payments
Report		: Generate Detail, Summary and Exception Reports
Security		: Authentication, Authorization, Change Password and Password Recovery

Sources
------------

	The Java source code for the system can be found \VeterinaryClinicSystem\src directory. The source code can be compiled and run by using Netbeans IDE. The \VeterinaryClinicSystem directory can be opened as a Netbeans IDE Project.

Additionally, the sources for this project are also available online at https://github.com/krishnapriyar/vet-clinic as a private repository. Please contact the authors for access.

The native installer is available at \VeterinaryClinicSystem\dist\bundles\Veterinary Clinic System-1.0.exe as well at the root directory. The executable jat file \VeterinaryClinicSystem\dist\VeterinaryClinicSystem.jar. Dependent libraries can be found at the \VeterinaryClinicSystem\dist\lib directory.

The database needed to deploy this application can be found at the \.netbeans-derby directory. The sql statements required to manually create tables and populate the database with data can be found at the \SQL directory or at the \VeterinaryClinicSystem\sql directory.


Dependencies
----------------------

	As the application is built using Java, Java Runtime Enviroment is required to run the system unless it is run as a native package executable. 

Major dependencies includes: 

JasperReports at http://community.jaspersoft.com/project/jasperreports-library
JCalendar at http://toedter.com/jcalendar/
NetBeans Derby Client 

Full list of dependent libraries can be found at \VeterinaryClinicSystem\dist\lib directory.

Authors
-------------

Krishnapriya A/P Ranga Nathan 
Chen Li San			
