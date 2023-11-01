# API de Estacionamento

- [API de Estacionamento](#api-de-estacionamento)

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
