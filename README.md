# Projeto Encurtador de Links

Este projeto é uma API RESTful para encurtamento de URLs, desenvolvido em Java com Spring Boot. Ele utiliza a API do TinyURL para gerar links encurtados.

## Tecnologias Utilizadas

- Java 17
- Spring Boot
- Maven
- Docker
- TinyURL API

## Funcionalidades

- Encurtar URLs fornecidas pelo usuário.

## Pré-requisitos

- [Docker](https://www.docker.com/get-started)
- [Docker Compose](https://docs.docker.com/compose/install/)
- Conta no [Render](https://render.com) (para deploy, OPCIONAL)

## Como Rodar Localmente

### Usando Docker

1. Clone este repositório:
   ```bash
   git clone https://github.com/seu-usuario/projetoIntermediario.git
   cd projetoIntermediario
2. Construa a imagem e rode o container com Docker Compose:

    docker-compose build

    docker-compose up

3. A api estará rodando na porta 8080. Acesse-a através da URL:
   http://localhost:8080

### Rodando Manualmente (sem Docker)

1. Instale o Java 17 e o Maven.

2. Clone o repositório:

bash:
git clone https://github.com/seu-usuario/projetoIntermediario.git
cd projetoIntermediario

3. Compile e rode o projeto:

bash:
mvn clean install
mvn spring-boot:run

4. A API estará disponível na porta 8080:

http://localhost:8080


### Endpoints da API

Encurtar URL
Descrição: Encurta uma URL fornecida pelo usuário.

Método: POST

**URL: /api/links/encurtar**

Headers:
    Content-Type: application/json

Body:
    json
        {
            "url": "https://www1.satc.edu.br/portais/alunos/index.php/servicos"
        }

Exemplo de Requisição:

    curl -X POST http://localhost:8080/api/links/encurtar -H "Content-Type: application/json" -d '{"url": "https://www1.satc.edu.br/portais/alunos/index.php/servicos"}'

Exemplo de Resposta (Sucesso):

json
    {
        "urlEncurtada": "https://tinyurl.com/abc123"
    }
Exemplo de Resposta (Erro):

json
    {
        "error": "A URL fornecida está vazia ou não foi informada."
    }
Deploy no Render
    Faça login no Render.
    Crie um novo serviço Web e conecte-o ao seu repositório no GitHub.
    Configure a porta do servidor como 8080.
    Aguarde o deploy e use a URL fornecida pelo Render para testar a API.