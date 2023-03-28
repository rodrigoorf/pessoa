# pessoa

Aplicação criada utilizando Java Spring Boot, JPA, Hibernate e banco H2, servindo como CRUD de pessoas.

### Rodando localmente

Para rodar essa aplicação localmente, é necessário:
- JDK 17

Clone esse repositório:
````shell
git clone https://github.com/rodrigoorf/pessoa
cd pessoa
````

Execute o seguinte comando:
````shell
./gradlew bootRun
````

A aplicação estará rodando em http://localhost:8080/. Você pode acessar a documentação OpenAPI [aqui](http://localhost:8080/swagger-ui/index.html).

### Rodando em um container Docker

Para rodar essa aplicação em um container, é necessário:
- Docker engine (Docker, colima, etc.)
- JDK 17

Faça o build da aplicação (isso irá gerar um arquivo .jar, necessário para gerar a imagem):

````shell
./gradlew build
````

Crie uma imagem da aplicação:
````shell
docker build -t pessoa .
````

Execute o seguinte comando para rodar a aplicação em um container:
````shell
docker run -p 8080:8080 pessoa
````

A aplicação estará rodando em http://localhost:8080/. Você pode acessar a documentação OpenAPI [aqui](http://localhost:8080/swagger-ui/index.html).