# API de Estacionamento

- [API de Estacionamento](#api-de-estacionamento)
  - [Inicia período estacionado](#inicia-período-estacionado)
    - [\[POST\] /estacionamentos](#post-estacionamentos)
  - [Finalizar o período estacionado](#finalizar-o-período-estacionado)
    - [\[PUT\] /estacionamentos](#put-estacionamentos)
  - [Detalhar o período estacionado](#detalhar-o-período-estacionado)
    - [\[GET\] /estacionamentos](#get-estacionamentos)

A API de Condutores tem como objetivo  permite iniciar o período de estacionamento, oferecendo opções de tempo fixo ou por hora.

Json de Exemplo:

<details>

<summary>Json Request </summary>

**Tipo Variável**

```json
{
  "condutor": {
    "id": "6536d7609826445f718f38eb"
  },
  "veiculo": {
    "id": "653876ea4bb3a15f1239046c"
  },
  "entrada": "31/10/2023 23:59",
  "tipoTempo": "VARIAVEL"
}
```

**Tipo Fixo**

```json
{
  "condutor": {
    "id": "6536d7609826445f718f38eb"
  },
  "veiculo": {
    "id": "653876ea4bb3a15f1239046c"
  },
  "entrada": "01/11/2023 11:59",
  "duracao":"50",
  "tipoTempo": "FIXO"
}
```

</details>

<details>

<summary>Json Response </summary>

**Tipo Variável**

```json
{
    "codigoIdentificador": "65424e85c18b6721d785bde5",
    "condutor": {
        "id": "6536d7609826445f718f38eb",
        "nome": "Teste Altas Docker",
        "cpf": "34973496073"
    },
    "veiculo": {
        "id": "653876ea4bb3a15f1239046c",
        "modelo": "Virtus Highline",
        "marca": "Volkswagen",
        "placa": "SST4T88"
    },
    "entrada": "01/11/2023 10:11",
    "tipoTempo": "VARIAVEL"
}
```

**Tipo Fixo**

```json
{
    "codigoIdentificador": "65424dd8c18b6721d785bde4",
    "condutor": {
        "id": "6536d7609826445f718f38eb",
        "nome": "Teste Altas Docker",
        "cpf": "34973496073"
    },
    "veiculo": {
        "id": "653876ea4bb3a15f1239046c",
        "modelo": "Virtus Highline",
        "marca": "Volkswagen",
        "placa": "SST4T88"
    },
    "entrada": "01/11/2023 10:08",
    "tipoTempo": "FIXO",
    "duracao": 50
}
```

</details>

![](/doc/img/api-estacionamentos-swagger.PNG)

## Inicia período estacionado

### [POST] /estacionamentos

1. Swagger

```shell
http://127.0.0.1:8080/swagger-ui/index.html?urls.primaryName=Estacionamentos#/API%20de%20Estacionamentos/iniciarEstacionamento
```

2. CURL

- **Tipo Variável**

```shell
curl -X 'POST' \
  'http://127.0.0.1:8080/estacionamentos' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
  "condutor": {
    "id": "6536d7609826445f718f38eb"
  },
  "veiculo": {
    "id": "653876ea4bb3a15f1239046c"
  },
  "entrada": "02/11/2023 12:59",
  "tipoTempo": "VARIAVEL"
}'
```

<details>

<summary>Resposta</summary>

```json
{
  "codigoIdentificador": "6543112384a5d13e768d7973",
  "condutor": {
    "id": "6536d7609826445f718f38eb",
    "nome": "Teste Altas Docker",
    "cpf": "34973496073"
  },
  "veiculo": {
    "id": "653876ea4bb3a15f1239046c",
    "modelo": "Virtus Highline",
    "marca": "Volkswagen",
    "placa": "SST4T88"
  },
  "entrada": "02/11/2023 00:01",
  "tipoTempo": "VARIAVEL"
}
```

</details>

- **Tipo Fixo**

```shell
curl -X 'POST' \
  'http://127.0.0.1:8080/estacionamentos' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
  "condutor": {
    "id": "6536d7609826445f718f38eb"
  },
  "veiculo": {
    "id": "653876ea4bb3a15f1239046c"
  },
  "entrada": "02/11/2023 12:59",
  "duracao": 90,
  "tipoTempo": "FIXO"
}'
```

<details>

<summary>Resposta</summary>

```json
{
  "codigoIdentificador": "654310d884a5d13e768d7972",
  "condutor": {
    "id": "6536d7609826445f718f38eb",
    "nome": "Teste Altas Docker",
    "cpf": "34973496073"
  },
  "veiculo": {
    "id": "653876ea4bb3a15f1239046c",
    "modelo": "Virtus Highline",
    "marca": "Volkswagen",
    "placa": "SST4T88"
  },
  "entrada": "02/11/2023 00:00",
  "tipoTempo": "FIXO",
  "duracao": 90
}
```

</details>

## Finalizar o período estacionado

### [PUT] /estacionamentos

1. Swagger

```shell
http://127.0.0.1:8080/swagger-ui/index.html?urls.primaryName=Estacionamentos#/API%20de%20Estacionamentos/finalizarEstacionamento
```

2. CURL

```shell
curl -X 'PUT' \
  'http://127.0.0.1:8080/estacionamentos/654310d884a5d13e768d7972' \
  -H 'accept: */*'
```

<details>

<summary>Resposta</summary>

```json
{
  "codigoIdentificador": "654310d884a5d13e768d7972",
  "condutor": {
    "id": "6536d7609826445f718f38eb",
    "nome": "Teste Altas Docker",
    "cpf": "34973496073"
  },
  "veiculo": {
    "id": "653876ea4bb3a15f1239046c",
    "modelo": "Virtus Highline",
    "marca": "Volkswagen",
    "placa": "SST4T88"
  },
  "entrada": "02/11/2023 00:00",
  "saida": "02/11/2023 00:05",
  "tipoTempo": "FIXO",
  "duracao": 90,
  "tempoTotalEstacionado": 5
}
```

```json
{
  "codigoIdentificador": "6543112384a5d13e768d7973",
  "condutor": {
    "id": "6536d7609826445f718f38eb",
    "nome": "Teste Altas Docker",
    "cpf": "34973496073"
  },
  "veiculo": {
    "id": "653876ea4bb3a15f1239046c",
    "modelo": "Virtus Highline",
    "marca": "Volkswagen",
    "placa": "SST4T88"
  },
  "entrada": "02/11/2023 00:01",
  "saida": "02/11/2023 00:07",
  "tipoTempo": "VARIAVEL",
  "tempoTotalEstacionado": 6
}
```

</details>

## Detalhar o período estacionado

### [GET] /estacionamentos

1. Swagger

```shell
http://127.0.0.1:8080/swagger-ui/index.html?urls.primaryName=Estacionamentos#/API%20de%20Estacionamentos/detalhar
```

2. CURL

```shell
curl -X 'GET' \
  'http://127.0.0.1:8080/estacionamentos/6543112384a5d13e768d7973' \
  -H 'accept: application/json'
```

<details>

<summary>Resposta</summary>

```json
{
  "codigoIdentificador": "654310d884a5d13e768d7972",
  "condutor": {
    "id": "6536d7609826445f718f38eb",
    "nome": "Teste Altas Docker",
    "cpf": "34973496073"
  },
  "veiculo": {
    "id": "653876ea4bb3a15f1239046c",
    "modelo": "Virtus Highline",
    "marca": "Volkswagen",
    "placa": "SST4T88"
  },
  "entrada": "02/11/2023 00:00",
  "saida": "02/11/2023 00:05",
  "tipoTempo": "FIXO",
  "duracao": 90,
  "tempoTotalEstacionado": 5
}
```

```json
{
  "codigoIdentificador": "6543112384a5d13e768d7973",
  "condutor": {
    "id": "6536d7609826445f718f38eb",
    "nome": "Teste Altas Docker",
    "cpf": "34973496073"
  },
  "veiculo": {
    "id": "653876ea4bb3a15f1239046c",
    "modelo": "Virtus Highline",
    "marca": "Volkswagen",
    "placa": "SST4T88"
  },
  "entrada": "02/11/2023 00:01",
  "saida": "02/11/2023 00:07",
  "tipoTempo": "VARIAVEL",
  "tempoTotalEstacionado": 6
}
```

</details>