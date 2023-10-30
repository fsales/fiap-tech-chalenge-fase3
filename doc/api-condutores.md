# API de Condutores

A API de Condutores tem como objetivo permitir o registro no sistema de informações, incluindo dados pessoais como nome,
endereço e informações de contato.

> Ao realizar o cadastro ou atualização dos dados de endereço, será feita uma requisição na API
> do  [ViaCEP](https://viacep.com.br/) para recuperar a UF e o nome do Estado. Caso o CEP não seja encontrado, não será
> permitido fazer o cadastro ou a atualização.

Json de exemplo:
<details>

<summary>Json Request </summary>

```json
{
  "nome": "Marcos Andre",
  "cpf": "50297831054",
  "dataNascimento": "17/02/1995",
  "numeroHabilitacao": "02888820071",
  "contato": {
    "email": "email@email.com",
    "telefone": "(99)9999-9999"
  },
  "endereco": {
    "rua": "villa nova",
    "logradouro": "Praça da Sé",
    "numero": 1024,
    "complemento": "lado ímpar",
    "bairro": "Sé",
    "cidade": "São Paulo",
    "cep": "01001000",
    "siglaEstado": "SP"
  }
}
```

</details>

<details>

<summary>Json Response </summary>

```json
{
  "id": "653fae059451cb68c8572974",
  "nome": "Marcos Andre",
  "cpf": "50297831054",
  "dataNascimento": "17/02/1995",
  "numeroHabilitacao": "02888820071",
  "contato": {
    "email": "email@email.com",
    "telefone": "(99)9999-9999"
  },
  "endereco": {
    "rua": "villa nova",
    "logradouro": "Praça da Sé",
    "numero": 1024,
    "complemento": "lado ímpar",
    "bairro": "Sé",
    "cidade": "São Paulo",
    "cep": "01001000",
    "uf": "SP"
  }
}
```

</details>

<hr>


![](/doc/img/api-condutores-swagger.PNG)

## Criar Condutor

### [POST] /condutores

1. Swagger

```shell
http://127.0.0.1:8080/swagger-ui/index.html?urls.primaryName=Condutores#/API%20de%20Condutores/cadastrar
```

2. CURL

```shell
curl -X 'POST' \
  'http://127.0.0.1:8080/condutores' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
  "nome": "Marcos Andre",
  "cpf": "50297831054",
  "dataNascimento": "17/02/1995",
  "numeroHabilitacao": "02888820071",
  "contato": {
    "email": "email@email.com",
    "telefone": "(99)9999-9999"
  },
  "endereco": {
    "rua": "villa nova",
    "logradouro": "Praça da Sé",
    "numero": 1024,
    "complemento": "lado ímpar",
    "bairro": "Sé",
    "cidade": "São Paulo",
    "cep": "01001000",
    "siglaEstado": "SP"
  }
}'
```

<details>

<summary>Resposta</summary>

```json
{
  "id": "653fae059451cb68c8572974",
  "nome": "Marcos Andre",
  "cpf": "50297831054",
  "dataNascimento": "17/02/1995",
  "numeroHabilitacao": "02888820071",
  "contato": {
    "email": "email@email.com",
    "telefone": "(99)9999-9999"
  },
  "endereco": {
    "rua": "villa nova",
    "logradouro": "Praça da Sé",
    "numero": 1024,
    "complemento": "lado ímpar",
    "bairro": "Sé",
    "cidade": "São Paulo",
    "cep": "01001000",
    "uf": "SP"
  }
}
```

</details>

## Atualizar Condutor

### [PUT] /condutores

1. Swagger

```shell
http://127.0.0.1:8080/swagger-ui/index.html?urls.primaryName=Condutores#/API%20de%20Condutores/atualizar
```

2. CURL

```shell
curl -X 'PUT' \
  'http://127.0.0.1:8080/condutores' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
  "id": "653fae059451cb68c8572974",
  "nome": "Marcos Andre da Silva",
  "cpf": "50297831054",
  "dataNascimento": "17/02/1995",
  "numeroHabilitacao": "02888820071",
  "contato": {
    "email": "marcos.andre@email.com",
    "telefone": "(61)9999-9999"
  },
  "endereco": {
    "rua": "QC 03",
    "logradouro": "Condominio Villa Nova",
    "numero": 1104,
    "complemento": "Bloco K",
    "bairro": "Cidade Jardins",
    "cidade": "Valparaiso",
    "cep": "72878442",
    "siglaEstado": "GO"
  }
}'
```

<details>

<summary>Resposta</summary>

```json
{
  "id": "653fae059451cb68c8572974",
  "nome": "Marcos Andre da Silva",
  "cpf": "50297831054",
  "dataNascimento": "17/02/1995",
  "numeroHabilitacao": "02888820071",
  "contato": {
    "email": "marcos.andre@email.com",
    "telefone": "(61)9999-9999"
  },
  "endereco": {
    "rua": "QC 03",
    "logradouro": "Condominio Villa Nova",
    "numero": 1104,
    "complemento": "Bloco K",
    "bairro": "Cidade Jardins",
    "cidade": "Valparaíso de Goiás",
    "cep": "72878442",
    "uf": "GO"
  }
}
```

</details>

## Excluir Condutor

### [DELETE] /condutores/{id}

1. Swagger

```shell
http://127.0.0.1:8080/swagger-ui/index.html?urls.primaryName=Condutores#/API%20de%20Condutores/delete
```

2. CURL

```shell
curl -X 'DELETE' \
  'http://127.0.0.1:8080/condutores/653fae059451cb68c8572974' \
  -H 'accept: */*'
```

## Detalhar Condutor

### [GET] /condutores/{id}

1. Swagger

```shell
http://127.0.0.1:8080/swagger-ui/index.html?urls.primaryName=Condutores#/API%20de%20Condutores/detalhar
```

2. CURL

```shell
curl -X 'GET' \
  'http://127.0.0.1:8080/condutores/653fb516dceffd31d676aecb' \
  -H 'accept: application/json'
```

<details>
    <summary>Resposta</summary>

  ```json
{
  "id": "653fae059451cb68c8572974",
  "nome": "Marcos Andre",
  "cpf": "50297831054",
  "dataNascimento": "17/02/1995",
  "numeroHabilitacao": "02888820071",
  "contato": {
    "email": "email@email.com",
    "telefone": "(99)9999-9999"
  },
  "endereco": {
    "rua": "villa nova",
    "logradouro": "Praça da Sé",
    "numero": 1024,
    "complemento": "lado ímpar",
    "bairro": "Sé",
    "cidade": "São Paulo",
    "cep": "01001000",
    "uf": "SP"
  }
}
  ```

</details>

## Listar Condutor

### [GET] /condutores

```shell
http://127.0.0.1:8080/swagger-ui/index.html?urls.primaryName=Condutores#/API%20de%20Condutores/listarTodos
```

2. CURL

```shell
curl -X 'GET' \
  'http://127.0.0.1:8080/condutores?nome=Marcos%20Andre&cpf=50297831054&numeroHabilitacao=02888820071&page=0&size=20' \
  -H 'accept: application/json'
 ```

<details>
    <summary>Resposta</summary>

  ```json
{
  "content": [
    {
      "id": "653fb516dceffd31d676aecb",
      "nome": "Marcos Andre",
      "cpf": "50297831054",
      "dataNascimento": "17/02/1995",
      "numeroHabilitacao": "02888820071",
      "contato": {
        "email": "email@email.com",
        "telefone": "(99)9999-9999"
      },
      "endereco": {
        "rua": "villa nova",
        "logradouro": "Praça da Sé",
        "numero": 1024,
        "complemento": "lado ímpar",
        "bairro": "Sé",
        "cidade": "São Paulo",
        "cep": "01001000",
        "uf": "SP"
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
  "totalElements": 1,
  "totalPages": 1,
  "size": 20,
  "number": 0,
  "sort": [],
  "first": true,
  "numberOfElements": 1,
  "empty": false
}
  ```

</details>