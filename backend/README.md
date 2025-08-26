# Sistema Rocha - Spring Boot + MySQL

## Requisitos
- Java 17
- MySQL em execução (localhost:3306)
- Maven

## Configurar MySQL
Crie um banco (ou deixe o Spring criar automaticamente):
- Database: `rochadb`

Edite `src/main/resources/application.properties` conforme seu usuário/senha do MySQL.

## Rodar
```bash
mvn spring-boot:run
```
Abra:
- http://localhost:8082/Login.html

Login inicial:
- usuário: `admin`
- senha: `123`
