# ProMonstraoREST

Implementação de uma api REST para o projeto ProMonstrão.

## Instruções para execução

1. Executar o script `db/MySQL/create.sql`, para inicializar a base de dados MySQL.

2. Executar o comando `mvnw spring-boot:run`. O sistema poderá ser acessado em http://localhost:8080.

## Exemplos de Credenciais
- Administrador: admin@email.com:admin
- Site: website1@email.com:senha
- Teatro: theater1@email.com:senha

## Checklist

### CRUD: Sites de vendas de ingresso

- [ ] POST http://localhost:8080/sites
- [ ] GET http://localhost:8080/sites
- [ ] GET http://localhost:8080/sites/{id}
- [ ] PUT http://localhost:8080/sites/{id}
- [ ] DELETE http://localhost:8080/sites/{id}

### CRUD: Teatros
- [ ] POST http://localhost:8080/teatros
- [ ] GET http://localhost:8080/teatros
- [ ] GET http://localhost:8080/teatros/{id}
- [ ] GET http://localhost:8080/teatros/cidades/{nome}
- [ ] PUT http://localhost:8080/teatros/{id}
- [ ] DELETE http://localhost:8080/teatros/{id}
### CRUD: promoções
- [ ] GET http://localhost:8080/promocoes
- [ ] GET http://localhost:8080/promocoes/{id}
- [ ] GET http://localhost:8080/promocoes/sites/{id}
- [ ] GET http://localhost:8080/promocoes/teatros/{id}