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

```

PUT /doctor/id -- updateDoctor: Dados no corpo da requisição - Ex:
```

```

DELETE /doctor/id -- deleteDoctor


### PATIENT:

GET /patient -- findAllPatients

GET /patient/id -- findPatientById

POST /patient -- createPatient: Dados no corpo da requisição - Ex: 
```

```

PUT /patient/id -- updatePatient: Dados no corpo da requisição - Ex:
```

```

DELETE /patient/id -- deletePatient


