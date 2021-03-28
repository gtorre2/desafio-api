# Cliente - API

API responsável pelo gerenciamento de clientes de uma empresa

Autor: Gustavo Rodrigues Torre

# Objetivo

O objetivo principal deste sistema e demonstrar as funcionalidades de consulta e cadastro de uma novo cliente
utilizando Spring Boot

# Requisitos
* Java 12 ou superior
* Maven 3 ou superior

# Arquitetura utilizada
* Spring boot 2.2.2.RELEASE
* Mysql

# Implementações
Cadastro e busca de clientes

# Configuração

Baixar o projeto 

Importar para um IDE Intellij

Aguardar a IDE baixar todas as depêndencias do Maven

Depois clicar em 

file -> Projetct Structure -> Project JDK -> Selecionar a opção ADD JDK e depois em Download JDK
Na tela que aparecer 

Vendor: Oracle OpenJDK
Version: 15 ou 16 
Location: utilizar uma localização de pasta do sistema que desejar que a JDK seja baixada

Project language Level -> SDK default

Alterar o nome de usuário e senha do banco de dados  nas seguintes linhas do arquivo application.properties:
spring.datasource.username=root
spring.datasource.password=root

Com o projeto configurado deve-se abrir a classe: ClienteApiApplication.java
e clicar em executar para que o projeto rode

Com o projeto startado digitar o seguinte endereço no navegdor Chrome ou outro

http://localhost:8080/swagger-ui.html

Neste endereço ira aparecer toda a documentação da API 

Depois de verificar a doumentação abrir o PostMan para fazer os testes da API 
 
Para visualizar os clientes cadastrados

Com o postman aberto acessar o seguinte endereço:

Selecionar a opção Get -> localhost:8080/v1/clientes

E clicar na opção send
 
Para cadastrar um novo cliente

Selecionar a opção Post -> localhost:8080/v1/clientes
Selecionar as seguintes opções: body -> row -> application/json
E no payload colocar :

{
  "cep": "71939-000",
  "email": "gtorre243@gmail.com",
  "nome": "Gustavo",
  "cpf": "124-000-000-12"
}

E clicar em send 

Para buscar um cliente por um endereço de email cadastrado 

Selecionar a opção Post -> localhost:8080/v1/clientes/gtorre23@gmail.com

E clicar em send
