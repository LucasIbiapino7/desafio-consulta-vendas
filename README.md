# Consulta de Vendas

# Sobre o projeto

Tem como objetivo implementar algumas consultas personalizadas e um pouco mais complexas.

## Modelo conceitual
![Modelo Conceitual](https://github.com/LucasIbiapino7/assets/blob/main/imgs/CONSULTA-VENDAS.png)

# Tecnologias utilizadas
## Back end
- Java
- Spring Boot
- JPA / Hibernate
- Maven
- Postman
# Competências
- Desenvolvimento em Camadas
- SQL e JPQL
# Features
- usuário informa, opcionalmente, data inicial, data final e um trecho do nome do vendedor e o sistema retorna listagem paginada contendo id, data, quantia vendida e nome do
vendedor, das vendas que se enquadrem nos dados informados. Caso os dados não sejam informados, fazemos uma busca da Data atual até um ano a menos. Exemplo de resposta:
```json
{
    "content": [
        {
            "id": 125,
            "date": "2022-05-22",
            "amount": 19476.0,
            "sellerName": "Loki Odinson"
        },
        {
            "id": 126,
            "date": "2022-05-18",
            "amount": 20530.0,
            "sellerName": "Thor Odinson"
        },
        {
            "id": 128,
            "date": "2022-05-06",
            "amount": 21753.0,
            "sellerName": "Loki Odinson"
        }
    ],
    "pageable": {
        "sort": {
            "empty": true,
            "sorted": false,
            "unsorted": true
        },
        "offset": 0,
        "pageSize": 20,
        "pageNumber": 0,
        "unpaged": false,
        "paged": true
    },
    "totalPages": 1,
    "totalElements": 3,
    "last": true,
    "size": 20,
    "number": 0,
    "sort": {
        "empty": true,
        "sorted": false,
        "unsorted": true
    },
    "numberOfElements": 3,
    "first": true,
    "empty": false
}
```
- O usuário informa, opcionalmente, data inicial, data final e o sistema informa uma listagem contendo nome do vendedor e soma de vendas deste vendedor
no período informado. Exemplo de Rseposta:
```json
[
    {
        "name": "Anakin",
        "sumAmount": 110571.0
    },
    {
        "name": "Logan",
        "sumAmount": 83587.0
    },
    {
        "name": "Loki Odinson",
        "sumAmount": 135276.0
    },
    {
        "name": "Padme",
        "sumAmount": 114785.0
    },
    {
        "name": "Thor Odinson",
        "sumAmount": 123736.0
    }
]
```

# Como executar o projeto

## Back end
Pré-requisitos: Java 11

```bash
# clonar repositório
git@github.com:LucasIbiapino7/desafio-consulta-vendas.git
```
# Autor

Lucas Ibiapino Do Nascimento Duarte


