# Backend da Aplicação Unisenai - Matéria de sistemas distribuídos.

## Tecnologias Utilizadas
Projeto construido utilizando Java com framework SpringBoot e SpringData JPA para realizar a comunicação com o Banco de dados relacional, sendo o MySQL.

### Padrão do Projeto
Utilizando o padrão de projeto MVC(Model-View-Controller), com o foco na organização e separação de responsabilidades.

## Integrações
Projeto é integrado com o Banco de dados MySQL hospedado na nuvem.

## Configuração do projeto em sua máquina

Indicado utilização da IDE IntelliJ Community Edition

<a href="https://www.jetbrains.com/idea/download/?section=windows" target="_blank">Download IntelliJ</a>

* Clonar o projeto e rodar o Maven 
* Configurar a SDK File> Project Structure > Project Settings > Project
* Navegue até o arquivo BackEndUniSenaiApplication.java e na IDE pode ir no Ícone superior direito para rodar a aplicação

## End-Points - Em andamento

### DOCTOR:

GET /doctor -- findAllDoctors

GET /doctor/id -- findDoctorById

POST /doctor -- createDoctor: Dados no corpo da requisição - Ex: 
```
{
    "name": "Jose",
    "sex": "m",
    "crm_advice": "353476",
    "crm_number": "684371",
    "crm_province": "SC",
    "cpf": "159.684.572-69",
    "phone": "(47) 96587-4236",
    "email": "jose@email.com",
    "cbo": "1234554821",
    "password": "1234"
}
```

PUT /doctor/id -- updateDoctor: Dados no corpo da requisição - Ex:
```
{
    "id": 1,
    "name": "Jose",
    "sex": "m",
    "crm_advice": "353476",
    "crm_number": "684371",
    "crm_province": "SC",
    "cpf": "159.684.572-69",
    "phone": "(47) 96587-4236",
    "email": "jose@email.com",
    "cbo": "1234554821",
    "password": "1234"
}
```

DELETE /doctor/id -- deleteDoctor
_________________________________________________________________________________________________

### DOCTOR SCHEDULE:

GET /doctor-schedule -- findAllDoctorSchedules

GET /doctor-schedule/id -- findDoctorScheduleById

POST /doctor-schedule -- createDoctorSchedule: Dados no corpo da requisição - Ex: 
```
{
    "doctor_id": 1,
    "day_of_week": 3,
    "start_time_first_period": "08:00",
    "end_time_first_period": "12:00",
    "start_time_second_period": "13:30",
    "end_time_second_period": "18:30"
}
```

PUT /doctor-schedule/id -- updateDoctorSchedule: Dados no corpo da requisição - Ex:
```
{
    "id": 1,
    "doctor_id": 1,
    "day_of_week": 3,
    "start_time_first_period": "08:00",
    "end_time_first_period": "12:00",
    "start_time_second_period": "13:30",
    "end_time_second_period": "18:30"
}
```

DELETE /doctor-schedule/id -- deleteDoctorSchedule
_________________________________________________________________________________________________


### PATIENT:

GET /patient -- findAllPatients

GET /patient/id -- findPatientById

POST /patient -- createPatient: Dados no corpo da requisição - Ex: 
```
{
    "name": "Pedro Gabriel",
    "sex": "m",
    "birth_date": "2003-10-13",
    "cpf": "123.756.982-30",
    "rg": "8.368.158",
    "mother_name": "Rafaela",
    "social_name": "Pedro",
    "phone": "(47) 96354-5627",
    "email": "pedro@email.com",
    "cep": "89632-523",
    "address": "Rua número",
    "number": 0,
    "neighborhood": "Centro",
    "city": "Blumenau",
    "province": "SC",
    "password": "12345678"
}
```

PUT /patient/id -- updatePatient: Dados no corpo da requisição - Ex:
```
{
   "id": 1,
   "name": "Pedro Gabriel",
    "sex": "m",
    "birth_date": "2003-10-13",
    "cpf": "123.756.982-30",
    "rg": "8.368.158",
    "mother_name": "Rafaela",
    "social_name": "Pedro",
    "phone": "(47) 96354-5627",
    "email": "pedro@email.com",
    "cep": "89632-523",
    "address": "Rua número",
    "number": 0,
    "neighborhood": "Centro",
    "city": "Blumenau",
    "province": "SC",
    "password": "12345678"
}
```

DELETE /patient/id -- deletePatient
_________________________________________________________________________________________________


### Schedule:
<strong>OBS: As consultas tem duração padrão de 30 minutos, que deverão ser encaminhadas do Front-end neste intervalo de tempo.</strong>

GET /schedule -- findAllSchedules

GET /schedule/id -- findScheduleById

POST /schedule -- createSchedule: Dados no corpo da requisição - Ex: 
```
{
    "doctor_id": 1,
    "patient_id": 1,
    "schedule_date": "2024-05-07",
    "initial_time": "12:00",
    "final_time": "13:30",
    "service_type": "RETURN",
    "send_alert": true
}
```

PUT /schedule/id -- updatePatient: Dados no corpo da requisição - Ex:
```
{
    "id": 1,
    "doctor_id": 1,
    "patient_id": 1,
    "schedule_date": "2024-05-07",
    "initial_time": "12:00",
    "final_time": "12:30",
    "service_type": "RETURN",
    "send_alert": true
}
```

DELETE /schedule/id -- deletePatient


