# API de Condutores

A API de Condutores tem como objetivo permitir o registro no sistema de informações, incluindo dados pessoais como nome,
endereço e informações de contato.

> Ao realizar o cadastro ou atualização dos dados de endereço, será feita uma requisição na API
> do  [ViaCEP](https://viacep.com.br/) para recuperar a UF e o nome do Estado. Caso o CEP não seja encontrado, não será
> permitido fazer o cadastro ou a atualização.

![](/doc/img/api-condutores-swagger.PNG)

## Criar Condutor

### [POST] /condutores
