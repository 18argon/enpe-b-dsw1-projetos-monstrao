# ProMonstraoREST

Implementação de uma api REST para o projeto ProMonstrão.

## Instruções para execução

1. Executar o script `db/MySQL/create.sql`, para inicializar a base de dados MySQL.

2. Executar o comando `mvnw spring-boot:run`. O sistema poderá ser acessado em http://localhost:8080.

## Checklist

### CRUD: Sites de vendas de ingresso

- [X] POST http://localhost:8080/sites
- [X] GET http://localhost:8080/sites
- [X] GET http://localhost:8080/sites/{id}
- [X] PUT http://localhost:8080/sites/{id}
- [X] DELETE http://localhost:8080/sites/{id}

### CRUD: Teatros

- [X] POST http://localhost:8080/teatros
- [X] GET http://localhost:8080/teatros
- [X] GET http://localhost:8080/teatros/{id}
- [X] GET http://localhost:8080/teatros/cidades/{nome}
- [X] PUT http://localhost:8080/teatros/{id}
- [X] DELETE http://localhost:8080/teatros/{id}

### CRUD: promoções

- [X] GET http://localhost:8080/promocoes
- [X] GET http://localhost:8080/promocoes/{id}
- [X] GET http://localhost:8080/promocoes/sites/{id}
- [X] GET http://localhost:8080/promocoes/teatros/{id}

## Exemplo de body para POST e PUT

- POST http://localhost:8080/sites
  ``` json
  {
    "email": "website4@email.com",
    "name": "Website 4",
    "password": "senha",
    "url": "https://website4.com",
    "phoneNumber": "(15) 98766-5434"
  }
  ```
- PUT http://localhost:8080/sites/4
  ``` json
  {
    "email": "website3@email.com",
    "name": "Website 33",
    "url": "https://website3.com",
    "phoneNumber": "(15) 98766-5433"
  }
  ```
- POST http://localhost:8080/teatros
  ``` json
  {
    "email": "theater4@email.com",
    "password": "senha",
    "name": "Theater 4",
    "cnpj": "123456789/344",
    "city": "São Carlos"
  }
  ```
- PUT http://localhost:8080/teatros/5
  ``` json
  {
    "email": "theater1@email.com",
    "name": "Theater 11",
    "cnpj": "123456789/341",
    "city": "São Carlos"
  }
  ```
