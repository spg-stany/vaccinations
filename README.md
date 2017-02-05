# Simple RESTful service "Vaccinations"

Основная цель которого стандартные операции: создание, чтение, обновление и удаление записей. Формат принимаемых данных JSON.

## Entity

* Patient {firstName, lastName, patronymic, birthDate, iian, gender}

* Vaccination {iian, dateExecute, medicineName}

## WEB-service

### Patient

* Получение списка всех пациентов: GET http://localhost:8080/vaccinations/patient/
* Получение пациента по СНИЛС: GET http://localhost:8080/vaccinations/patient/12345678912
* Создание пациента: POST http://localhost:8080/vaccinations/patient/ JSON{...}
* Редактирование пациента: PUT http://localhost:8080/vaccinations/patient/ JSON{...}
* Удаление пациента: DELETE http://localhost:8080/vaccinations/patient/12345678912

### Vaccination

* Получение списка всех прививок пациента по СНИЛС: GET http://localhost:8080/vaccinations/patient/12345678912/vaccination/
* Добавление прививки для пациента по СНИЛС: POST http://localhost:8080/vaccinations/patient/12345678912/vaccination/ JSON {...}
* Удаление прививки: DELETE http://localhost:8080/vaccinations/patient/12345678912/vaccination/1
