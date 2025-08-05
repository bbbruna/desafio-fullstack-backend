
# Backend - Sistema de Gerenciamento de Empresas e Fornecedores

Este é o backend da aplicação de gerenciamento de empresas e fornecedores, desenvolvido em Java com Spring Boot.

## Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Spring Data JPA
- MySQL
- Maven

## Requisitos

- Java 17 ou superior
- MySQL
- Maven

## Configuração do Banco de Dados

No arquivo `application.properties`, configure os dados de acesso ao banco de dados:

```
spring.datasource.url=jdbc:mysql://localhost:3306/desafio-fullstack
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
```

## Executando o Projeto

```bash
./mvnw spring-boot:run
```

## Endpoints

- `GET /enterprises` - Listar empresas
- `POST /enterprises` - Criar empresa
- `PUT /enterprises/{id}` - Atualizar empresa
- `DELETE /enterprises/{id}` - Deletar empresa

- `GET /suppliers` - Listar fornecedores
- `POST /suppliers` - Criar fornecedor
- `PUT /suppliers/{id}` - Atualizar fornecedor
- `DELETE /suppliers/{id}` - Deletar fornecedor

- `POST /enterprises/{enterpriseId}/supplier/{supplierId}` - Vincular fornecedor à empresa
- `DELETE /enterprises/{enterpriseId}/supplier/{supplierId}` - Desvincular fornecedor da empresa
