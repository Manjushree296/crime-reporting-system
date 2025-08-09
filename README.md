# crime-reporting-system
⚙️ Setup Instructions
✅ Prerequisites
Java 17+  
Maven
MySQL 8+
IntelliJ IDEA / VS Code / any IDE

🔧 Step-by-Step Setup
Clone the Repository
git clone https://github.com/Manjushree296/crime-reporting-system.git
cd crime-reporting-system
Create MySQL Database

sql
CREATE DATABASE crime_reporting_db;
Configure Database in application.properties

properties
spring.datasource.url=jdbc:mysql://localhost:3306/crime_reporting_db
spring.datasource.username=root
spring.datasource.password=your_mysql_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
Build the Project

mvn clean install
Run the App

mvn spring-boot:run
The backend will be live at: http://localhost:8080

🔐 API Authentication
Login/Signup returns a JWT Token.

All protected routes require:

Authorization: Bearer <your_token>
🧪 API Endpoints
👤 Auth Routes
Method	Endpoint	Description
POST	/api/auth/login	Login user
POST	/api/auth/register	Register new user

🕵️ Citizen Routes
Method	Endpoint	Description
POST	/api/reports	Submit a new report
GET	/api/reports/user	View own reports

👮 Officer Routes
Method	Endpoint	Description
GET	/api/reports	View all reports
POST	/api/reports/{id}/accept	Accept a report
POST	/api/reports/{id}/reject	Reject with reason




