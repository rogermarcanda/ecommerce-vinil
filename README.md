# Ecommerce Vinil- Backend

Projeto de backend do projeto do ecommerce de vinis

## Pré-Requisitos


```
Java 8
Maven
Docker
Docker-compose
```

## Cameçando

clone o projeto:

```
# git clone https://gitlab.com/zs-imasters/ecb-catalogo-admin-backend.git
```

### gerando o JAR

```bash
 mvn clean install
```

### Executando a API
```
 docker-compose build
 docker-compose up
```

## Dados importantes

A base de dados, as tabelas, e as configurações de cashback são geradas no build do docker do postgres
Os discos são populados na inicialização da apĺicação, apenas quando registros não são encontrados;

###Tecnologias
``` 
 Java 8
 Spring Boot
 Spring Data
 Spring Rest
 API Spotify
 Postgres
 Docker
 Docker-compose
``` 
 
###Documentação e execução
É possivel ver e testar os endpoints acessando o swagger pelo link abaixo 
```
http://127.0.0.1:8080/swagger-ui.html
```

###Deficit Tecnico
 faltou adicionar um docker para geracao do jar com maven... por este motivo é necessario ter o maven e o java instalados.
 