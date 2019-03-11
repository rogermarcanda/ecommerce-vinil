# Ecommerce Vinil- Backend

Projeto de backend do projeto do ecommerce de vinis

## Pré-Requisitos


```
Java 8
Maven
Docker
```

## Cameçando

clone o projeto:

```
# git clone https://gitlab.com/zs-imasters/ecb-catalogo-admin-backend.git
```


### Construindo o build

Para construção realize os seguintes passos:

Linux:

```bash
 # mvn clean install
```

Windows:

```cmd
 # mvn.cmd clean install
```

### Utilizar com Docker
Para construir uma imagem docker utilize o seguinte comando:
```
 docker build -t ecb-catalogo:admin . --no-cache
```

Para executar o container sem utilizar docker.env (Utiliza os valores padrões):
```
 docker run --name ecb-catalogo-admin -p 8080:8080 --network ecb-catalogo -d ecb-catalogo:admin
```

Para executar o container com utilizar docker.env (Altera as variaveis de ambiente):
```
 docker run --env-file ./docker.env --name ecb-catalogo-admin -p 8080:8080 --network ecb-catalogo -d ecb-catalogo:admin
```

### Utilizar sem docker

O projeto pode ser executado com o seguinte comando:
```bash
  # cp target/ECBCatalogoAdmin-0.1.0.jar ./ECBCatalogoAdmin.jar
  # java -jar ECBCatalogoAdmin-0.1.0.jar
```
adicione os lacations abaixo no NGINX
```
{
  location /session/ { 
    proxy_pass http://localhost:8080/session/;
    proxy_set_header Host $host;
  }
  
  location /api/ { 
    proxy_pass http://localhost:8080/api/;
    proxy_set_header Host $host; 
  }
  
  location /uploads/ecb-catalogo { 
    root /usr/share/nginx; 
  }
}
```
### Variaveis de ambiente
Caso queira mudar os valores padrões, criar as variaveis de ambiente abaixo:
```
ZS_ECB_MONGO_HOST
ZS_ECB_MONGO_PORT
ZS_ECB_MONGO_BASE
ZS_ECB_MONGO_USUARIO
ZS_ECB_MONGO_PASSWORD
ZS_ECB_PATH_UPLOAD
ZS_ECB_PATH_DOWNLOAD
ZS_ECB_HTTP_URL
ZS_ECB_TO_CADASTRO_FORNECEDOR
ZS_ECB_TO_CADASTRO_LOJA
ZS_ECB_TO_COM_COPIA
ZS_ECB_TO_COM_COPIA_OCULTA
ZS_ECB_EMAILS_LOG
ZS_ECB_NIVEL_LOG_APP
ZS_ECB_NIVEL_LOG_MONGO
ZS_ECB_PRINTSCREEN_TIMEOUT
ZS_ECB_CONTROLE_MIDIA
ZS_ECB_AWS_ACCESS_KEY_ID
ZS_ECB_AWS_SECRET_ACCESS_KEY
ZS_ECB_AWS_REGIAO
ZS_ECB_AWS_S3_BUCKET
ZS_ECB_AWS_S3_DIRETORIO
```
### Dados importantes
Para o ambiente de produção utilzar as configurações abaixo
```
ZS_ECB_TO_CADASTRO_FORNECEDOR=catalogo@ecommercebrasil.com.br
ZS_ECB_TO_CADASTRO_LOJA=redacao@ecommercebrasil.com.br
ZS_ECB_TO_COM_COPIA_OCULTA=carlos.santos@zarpsystem.com.br,tiago@imasters.com.br
ZS_ECB_EMAILS_LOG=carlos.santos@zarpsystem.com.br,luiz.marcandalli@zarpsystem.com.br
```

### Build homologação
1. Gerar pacote com
	* mvn clean install
2. Enviar pacote gerado para o servidor na pasta /home/zarp
	* scp target/ECBCatalogoAdmin.jar <user>@<ip>:/home/zarp
3. Acessar servidor
	* ssh <user>@<ip>
4. Buscar e matar processo
	* ps aux | grep ECB
	* kill -9 <ID>
5. Mover JAR antigo para backup
	* mv /home/zarp/ecb-catalogo-back/ECBCatalogoAdmin-0.0.1-SNAPSHOT.jar /home/zarp/bkp/ECBCatalogoAdmin-0.0.1-SNAPSHOT.jar.20180511
6. Mover o novo jar para a pasta
	* mv /home/zarp/ECBCatalogoAdmin-0.0.1-SNAPSHOT.jar /home/zarp/ecb-catalogo-back/
7. Iniciar processo do back
	* java -jar ECBCatalogoAdmin-0.0.1-SNAPSHOT.jar >> ECBCatalogoAdmin-0.0.1-SNAPSHOT.jar.log &
8. Verificar se o serviço subiu corretamente pelo arquivo de log
	* tail -100f ECBCatalogoAdmin-0.0.1-SNAPSHOT.jar.log

### Build produção
1. Gerar pacote com
	* mvn clean install
2. Buildar a imagem
	* docker build -t ecb-catalogo:admin . 
3. Gerar um docker login
    * aws ecr get-login --no-include-email --region us-east-1
4. Copiar, colar executar o retorno no terminal
5. Atualizar a tag do docker:
    * docker tag ecb-catalogo:admin 255869724753.dkr.ecr.us-east-1.amazonaws.com/ecb-catalogo:admin
6. Realizar o push da imagem para a aws
    * docker push 255869724753.dkr.ecr.us-east-1.amazonaws.com/ecb-catalogo:admin
7. Acessar o console da aws e realizar o restart da task    

## Autores
* **Carlos Eduardo Santos**    - *PO* - [carlos.santos@zarpsystem.com.br ](https://gitlab.com/carlao.br)
* **Luiz Rogerio Marcandalli** - *Dev* - [luiz.marcandalli@zarpsystem.com.br ](https://gitlab.com/rogerio.marcandalli)
* **Leandro Ponte** - *Dev*    - [leandro.ponte@zarpsystem.com.br ](https://gitlab.com/leandro.ponte)
* **Renato Oliveira Santos**   - *Dev* - [renato.santos@zarpsystem.com.br ](https://gitlab.com/nato_santos)
* **Felipe Luiz Alves Das Neves** - *Dev* - [felipe.neves@zarpsystem.com.br ](https://gitlab.com/felipeneves578)
* **Gabriel Stahlberg Oliveira** - *Dev* - [gabriel.oliveira@zarpsystem.com.br ](https://gitlab.com/Gabriel_Stahlberg)