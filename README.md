# Simple RESTful service "Vaccinations" base on Spring MVC + Data Jpa

Основная цель которого стандартные операции: создание, чтение, обновление и удаление записей. Формат принимаемых данных JSON.

**DBMS**: I used PostgreSQL 9 and you have to [postgresql-9.4-1206-jdbc42.jar](https://jdbc.postgresql.org/download/postgresql-9.4-1206-jdbc42.jar) file put to lib/ folder for Tomcat app server.

## Entity

* Patient {firstName, lastName, patronymic, birthDate, iian, gender}

* Vaccination {iian, dateExecute, medicineName}

## WEB-service
### Patient

* Получение списка всех пациентов: **GET** http://localhost:8080/vaccinations/patient/
* Получение пациента по СНИЛС: **GET** http://localhost:8080/vaccinations/patient/12345678912
* Создание пациента: **POST** http://localhost:8080/vaccinations/patient/ JSON{...}
* Редактирование пациента: **PUT** http://localhost:8080/vaccinations/patient/ JSON{...}
* Удаление пациента: **DELETE** http://localhost:8080/vaccinations/patient/12345678912

### Vaccination

* Получение списка всех прививок пациента по СНИЛС: **GET** http://localhost:8080/vaccinations/patient/12345678912/vaccination/
* Добавление прививки для пациента по СНИЛС: **POST** http://localhost:8080/vaccinations/patient/12345678912/vaccination/ JSON {...}
* Удаление прививки: **DELETE** http://localhost:8080/vaccinations/patient/12345678912/vaccination/1

### Examples
#### Add new Patient

**POST** http://localhost:8080/vaccinations/patient/

`{
	"iian" : "54341234911",
	"firstName" : "Arthur",
	"lastName" : "Aukhatov",
	"birthDate" : "1990-08-20",
	"gender" : "MALE"
}`

#### Get Patient

**GET** http://localhost:8080/vaccinations/patient/54341234911

#### Get Patient list

**GET** http://localhost:8080/vaccinations/patient/

#### Edit Patient

**PUT** http://localhost:8080/vaccinations/patient/

`{
	"iian" : "54341234911",
	"firstName" : "Arthur",
	"lastName" : "Aukhatov",
	"birthDate" : "2017-01-31",
	"gender" : "MALE"
}`

#### Delete Patient

**DELETE** http://localhost:8080/vaccinations/patient/54341234911