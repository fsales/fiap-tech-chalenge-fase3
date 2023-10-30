# API de Veículo

- [API de Veículo](#api-de-veículo)
    - [Criar Veículo](#criar-veículo)
        - [\[POST\] /veiculos](#post-veiculos)
    - [Atualizar Veículo](#atualizar-veículo)
        - [\[PUT\] /veiculos](#put-veiculos)
    - [Excluir Veículo](#excluir-veículo)
        - [\[DELETE\] /veiculos/{id}](#delete-veiculosid)
    - [Detalhar Veículo](#detalhar-veículo)
        - [\[GET\] /veiculos/{id}](#get-veiculosid)
    - [Listar Veículo](#listar-veículo)
        - [\[GET\] /veiculos](#get-veiculos)

A API de Condutores tem como objetivo permitir o gerenciamento de múltiplos veículos no sistema, incluindo dados como
placa, marca e modelo.

Json de Exemplo:

<details>

<summary>Json Request </summary>

```json
{
  "modelo": "Virtus Higline",
  "marca": "Volkswagen",
  "placa": "VAP8V99",
  "renavam": "1132266690",
  "condutor": {
    "id": "653fd1b1879ef60fb796b094"
  }
}
```

</details>

<details>

<summary>Json Response </summary>

```json
{
  "id": "653fd234879ef60fb796b096",
  "modelo": "Virtus Higline",
  "marca": "Volkswagen",
  "placa": "VAP8V99",
  "renavam": "1132266690",
  "condutor": {
    "id": "653fd1b1879ef60fb796b094"
  }
}
```

</details>

![](/doc/img/api-veiculos-swagger.PNG)

## Criar Veículo

### [POST] /veiculos

1. Swagger

```shell
http://127.0.0.1:8080/swagger-ui/index.html?urls.primaryName=Veiculos#/API%20de%20Veiculos/cadastrar
```

2. CURL

```shell
curl -X 'POST' \
  'http://127.0.0.1:8080/veiculos' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
  "modelo": "Virtus Higline",
  "marca": "Volkswagen",
  "placa": "VAP8V99",
  "renavam": "1132266690",
  "condutor": {
    "id": "653fd1b1879ef60fb796b094"
  }
}'
```

<details>

<summary>Resposta</summary>

```json
{
  "id": "653fd234879ef60fb796b096",
  "modelo": "Virtus Higline",
  "marca": "Volkswagen",
  "placa": "VAP8V99",
  "renavam": "1132266690",
  "condutor": {
    "id": "653fd1b1879ef60fb796b094"
  }
}
```

</details>

## Atualizar Veículo

### [PUT] /veiculos

1. Swagger

```shell
http://127.0.0.1:8080/swagger-ui/index.html?urls.primaryName=Veiculos#/API%20de%20Veiculos/atualizar
```

2. CURL

```shell
curl -X 'PUT' \
  'http://127.0.0.1:8080/veiculos' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
  "id": "653fd234879ef60fb796b096",
  "modelo": "Virtus Confortiline",
  "marca": "Volkswagen do Brasil",
  "placa": "AAP8V99",
  "renavam": "2232266690",
  "condutor": {
    "id": "653fae059451cb68c8572974"
  }
}'
```

<details>

<summary>Resposta</summary>

```json
{
  "id": "653fd234879ef60fb796b096",
  "modelo": "Virtus Confortiline",
  "marca": "Volkswagen do Brasil",
  "placa": "AAP8V99",
  "renavam": "2232266690",
  "condutor": {
    "id": "653fae059451cb68c8572974"
  }
}
```

</details>

## Excluir Veículo

### [DELETE] /veiculos/{id}

1. Swagger

```shell
http://127.0.0.1:8080/swagger-ui/index.html?urls.primaryName=Veiculos#/API%20de%20Veiculos/delete
```

2. CURL

```shell
curl -X 'DELETE' \
  'http://127.0.0.1:8080/veiculos/653fd234879ef60fb796b096' \
  -H 'accept: */*'
```

## Detalhar Veículo

### [GET] /veiculos/{id}

1. Swagger

```shell
http://127.0.0.1:8080/swagger-ui/index.html?urls.primaryName=Veiculos#/API%20de%20Veiculos/detalhar
```

2. CURL

```shell
curl -X 'GET' \
  'http://127.0.0.1:8080/veiculos/653fd234879ef60fb796b096' \
  -H 'accept: application/json'
```

<details>
    <summary>Resposta</summary>

  ```json
{
  "id": "653fd234879ef60fb796b096",
  "modelo": "Virtus Confortiline",
  "marca": "Volkswagen do Brasil",
  "placa": "AAP8V99",
  "renavam": "2232266690",
  "condutor": null
}
  ```

</details>

## Listar Veículo

### [GET] /veiculos

```shell
http://127.0.0.1:8080/swagger-ui/index.html?urls.primaryName=Veiculos#/API%20de%20Veiculos/listarTodos
```

2. CURL

```shell
curl -X 'GET' \
  'http://127.0.0.1:8080/veiculos?placa=AAP8V99&renavam=2232266690&modelo=Virtus%20Confortiline&idCondutor=653fae059451cb68c8572974&page=0&size=20&sort=string' \
  -H 'accept: application/json'
 ```

 <details>
    <summary>Resposta</summary>

  ```json
{
  "content": [
    {
      "id": "653fd234879ef60fb796b096",
      "modelo": "Virtus Confortiline",
      "marca": "Volkswagen do Brasil",
      "placa": "AAP8V99",
      "renavam": "2232266690",
      "condutor": {
        "id": "653fd1b1879ef60fb796b094",
        "nome": "Marcos Andre",
        "cpf": "50297831054"
      }
    }
  ],
  "pageable": {
    "pageNumber": 0,
    "pageSize": 20,
    "sort": [],
    "offset": 0,
    "paged": true,
    "unpaged": false
  },
  "last": true,
  "totalPages": 1,
  "totalElements": 1,
  "size": 20,
  "number": 0,
  "sort": [],
  "first": true,
  "numberOfElements": 1,
  "empty": false
}
  ```

</details>
