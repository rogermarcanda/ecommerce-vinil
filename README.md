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
# git clone https://github.com/rogermarcanda/ecommerce-vinil.git
```

### Subindo e gerando o banco de dados

```bash
 docker-compose build
 docker-compose up
 
```

### Executando a API
```
 mvn clean install
 java -jar target/ecommerce-vinil-api-0.0.1-SNAPSHOT.jar
```
ou
```
 mvn spring-boot:run
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
 devido a problemas a acessar o serviço do Spotify não foi possivel utilzar docker para rodar a aplicação
 faltou adicionar um docker para geracao do jar com maven... por este motivo é necessario ter o maven e o java instalados.
 
 