![GitHub](https://img.shields.io/github/license/fsales/fiap-tech-chalenge-fase3)
![GitHub code size in bytes](https://img.shields.io/github/languages/code-size/fsales/fiap-tech-chalenge-fase3)
![GitHub language count](https://img.shields.io/github/languages/count/fsales/fiap-tech-chalenge-fase3)
![GitHub top language](https://img.shields.io/github/languages/top/fsales/fiap-tech-chalenge-fase3)
![GitHub issues](https://img.shields.io/github/issues/fsales/fiap-tech-chalenge-fase3)
[![Create release](https://github.com/fsales/fiap-tech-chalenge-fase3/actions/workflows/create-release.yml/badge.svg)](https://github.com/fsales/fiap-tech-chalenge-fase3/actions/workflows/create-release.yml)
[![Publish Image Registry - Branch Develop](https://github.com/fsales/fiap-tech-chalenge-fase3/actions/workflows/git-flow-publish-image-develop.yml/badge.svg)](https://github.com/fsales/fiap-tech-chalenge-fase3/actions/workflows/git-flow-publish-image-develop.yml)

<p align="center">
 <img src="https://img.shields.io/static/v1?label=GitHub&message=@fsales&color=8257E5&labelColor=000000" alt="@fsales" />
 <img src="https://img.shields.io/static/v1?label=Tipo&message=Tech%20Chalenge&color=8257E5&labelColor=000000" alt="Tech Chalenge" />
</p>

# :bookmark_tabs: Tech Chalenge

> Tech Challenge para avaliação da Fase III da Pós Graduação em Arquitetura e Desenvolvimento Java.

- [:bookmark\_tabs: Tech Chalenge](#bookmark_tabs-tech-chalenge)
  - [🛠️ Linguagem e ferramentas](#️-linguagem-e-ferramentas)
  - [🏫 Dados Acadêmicos](#-dados-acadêmicos)
    - [🏬 Instituição](#-instituição)
    - [🧑🏻‍🎓Curso](#curso)
    - [Aluno](#aluno)
  - [Pré-requisitos](#pré-requisitos)
  - [Como Executar](#como-executar)
  - [Arquitetura Hexagonal](#arquitetura-hexagonal)
    - [Adapters](#adapters)
    - [Domain](#domain)
    - [Consideração](#consideração)
  - [CI/CD](#cicd)
    - [Github Action](#github-action)
      - [Pipeline CI/CD](#pipeline-cicd)
      - [Secrets](#secrets)
  - [Referência](#referência)

## 🛠️ Linguagem e ferramentas

[![logo java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=kofi&logoColor=white)](#)

[![logo mongodb](https://img.shields.io/badge/MongoDB-4EA94B?style=for-the-badge&logo=mongodb&logoColor=white)](https://www.mongodb.com/)

[![logo spring](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white)](https://spring.io/)
[![logo spring-boot](https://img.shields.io/badge/Spring_Boot-F2F4F9?style=for-the-badge&logo=spring-boot)](https://spring.io/projects/spring-boot)

[![logo git](https://img.shields.io/badge/GIT-E44C30?style=for-the-badge&logo=git&logoColor=white)](https://git-scm.com/)
[![logo github](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com)

[![logo AWS](https://img.shields.io/badge/AWS-%23FF9900.svg?style=for-the-badge&logo=amazon-aws&logoColor=white)](https://aws.amazon.com/)
[![logo docker](https://img.shields.io/badge/Docker-2CA5E0?style=for-the-badge&logo=docker&logoColor=white)](https://docker.com)

[![logo eclipse](https://img.shields.io/badge/Eclipse-2C2255?style=for-the-badge&logo=eclipse&logoColor=white)](https://www.eclipse.org/)
[![logo intellij](https://img.shields.io/badge/IntelliJ_IDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)](https://www.jetbrains.com/pt-br/idea/)

[![logo curl](https://img.shields.io/badge/curl-093754.svg?style=for-the-badge&logo=curl-idea&logoColor=white)](https://curl.se/)
[![logo Google-chrome](https://img.shields.io/badge/Google_chrome-4285F4?style=for-the-badge&logo=Google-chrome&logoColor=white)](https://www.google.pt/intl/pt-PT/chrome/?brand=FHFK&gclid=CjwKCAjwnOipBhBQEiwACyGLuu4mCvDZcz9NfyfYpBcLdbDQXuIG2WbyC85RYuP3SLSiNGUcNE9hyRoCXxkQAvD_BwE&gclsrc=aw.ds)
[![logo postman](https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=Postman&logoColor=white)](https://www.postman.com/)
[![logo swagger](https://img.shields.io/badge/Swagger-85EA2D?style=for-the-badge&logo=Swagger&logoColor=white)](https://swagger.io/)

## 🏫 Dados Acadêmicos

### 🏬 Instituição

Faculdade FIAP

### 🧑🏻‍🎓Curso

Pós-Graduação em Arquitetura e Desenvolvimento Java

### Aluno

| [<img src="https://avatars.githubusercontent.com/u/816101?v=4" width=115><br><sub>Fábio de Oliveira Sales</sub>](https://github.com/fsales) |
| :---: |

[![Linkedin Badge](https://img.shields.io/badge/-Fábio%20Sales-blue?style=flat-square&logo=Linkedin&logoColor=white&link=https://www.linkedin.com/in/fabio-oliveira-sales/)](https://www.linkedin.com/in/fabio-oliveira-sales/)
[![Gmail Badge](https://img.shields.io/badge/-fabio.oliveira.sales@gmail.com-c14438?style=flat-square&logo=Gmail&logoColor=white&link=mailto:fabio.oliveira.sales@gmail.com)](mailto:fabio.oliveira.sales@gmail.com)

## Pré-requisitos

Antes de começar, você precisará ter as seguintes ferramentas instaladas em sua máquina:

- Java 17
- Git
- Docker
- IDE de desenvolvimento:
  - Eclipse
  - IntelliJ IDEA
  - VSCode
  - Outras
- Navegador:
  - Google Chrome
  - Outro
- Postman, CURL ou utilize o Swagger

## Como Executar

- Abrir o terminal
  - Git Bash
  - CMD
  - Bash
  - Outros

- **Clonar repositório.**
  git [https://github.com/fsales/fiap-tech-chalenge-fase3.git](https://github.com/fsales/fiap-tech-chalenge-fase3.git).

```sh
$ git clone  https://github.com/fsales/fiap-tech-chalenge-fase3.git  fiap-tech-chalenge-fase3
```

- **Acessar o diretório** `fiap-tech-chalenge-fase3/park-tech`.

```sh
$ cd  /fiap-tech-chalenge-fase3/park-tech
```

- **Construir o projeto utilizando o maven.**

```sh
./mvnw clean package
```

- **Inicie o serviço do Docker.**

- **Acesse o diretório `/fiap-tech-challenge-fase3/docker-parktech-dev`. Nesse diretório, você encontrará o
  arquivo `docker-compose.yaml` com as definições do `MongoDB` e do cliente `Mongo Express`.**

```sh
$ cd  /fiap-tech-chalenge-fase3/docker-parktech-dev
```

- **Inicie o container utilizando o Docker Compose.**

```sh
$ docker-compose -f docker-compose.yml up
```

> Caso a variável de ambiente `PARK_TECH_PROFILE_ENVIRONMENT` esteja definida com o valor `dev`, o plugin
> do [Spring Boot Docker Compose](https://spring.io/blog/2023/06/21/docker-compose-support-in-spring-boot-3-1) iniciará
> automaticamente os `contêineres` que estão definidos no arquivo `docker-compose.yaml` localizado no
> diretório `/fiap-tech-challenge-fase3/docker-parktech-dev`.

- **Importar o projeto `fiap-tech-chalenge-fase3/park-tech` na sua IDE de desenvolvimento.**
- **Configure as variáveis de ambiente na IDE de desenvolvimento.**
  - Variáveis:
    - PARK_TECH_MONGODB_DATABASE:

      Nome do Banco de Dados utilizado pela aplicação.

    - PARK_TECH_MONGODB_URI:

      URI de conexão ao seu banco de dados MongoDB.

    - PARK_TECH_PROFILE_ENVIRONMENT:

      Perfis de aplicativos usando a propriedade spring.profiles.active no arquivo application.yml. Isso permite que
      você defina diferentes configurações e comportamentos para diferentes ambientes (por exemplo, desenvolvimento,
      produção, teste).

      - Valores possíveis para a variável `PARK_TECH_PROFILE_ENVIRONMENT`:
        - dev
        - cloud-atlas

> O usuário e senha do `MongoDB` foram definidos no `docker-compose.yaml` e podem ser consultados no
> arquivo `fiap-tech-challenge-fase3/docker-parktech-dev/mongo-config/.env-mongodb`.

## Arquitetura Hexagonal

A arquitetura hexagonal, proposta por Alistair Cockburn em seu artigo [Hexagonal Architecture](http://wiki.c2.com/?HexagonalArchitecture=)[^1], inicialmente chamada de Ports And Adapters, é uma proposta arquitetural em camadas que visa proteger a lógica de negócios do sistema. A inovação dessa abordagem está na compreensão de Cockburn de que não há uma grande diferença entre como a interface do usuário e o banco de dados interagem com o aplicativo; ambos são elementos externos que podem ser substituídos a qualquer momento.

Para mitigar a dependência direta desses fatores externos (como interface de usuário, bancos de dados, integrações e filas), Cockburn introduz o conceito de "portas", que são interfaces aplicando o princípio de inversão de dependência. Estas são interfaces que a lógica de negócio conhece. Além disso, ele propõe os "adaptadores", que são as implementações dessas portas, lidando com as dependências externas.

Essencialmente, a arquitetura hexagonal é um padrão que separa a lógica de negócios do sistema das preocupações técnicas, como a interação com o usuário ou o acesso ao banco de dados. Ela se baseia na ideia de que uma aplicação é composta por "portas" de entrada e saída, que possibilitam a comunicação com o mundo exterior, e "adaptadores", que convertem essas informações em um formato compreensível para a aplicação e vice-versa.

<details>
  <summary>Organização do Projeto</summary>

```
├── src
  └── main
    └── java
      └── br
        └── com
          └── fsales
            └── parktech
              ├── adapters
              │  ├── in
              │  │  └── controller
              │  │    ├── condutor
              │  │    │  ├── CondutorController.java
              │  │    │  ├── mapper
              │  │    │  │  └── CondutorMapper.java
              │  │    │  ├── request
              │  │    │  │  ├── CondutorRequest.java
              │  │    │  │  ├── DadosAtualizarCondutorRequest.java
              │  │    │  │  └── ListarCondutorRequest.java
              │  │    │  └── response
              │  │    │    └── CondutorResponse.java
              │  │    ├── exception
              │  │    │  ├── ParkTechControlerExceptionHandler.java
              │  │    │  └── response
              │  │    │    ├── ValidationErrorResponse.java
              │  │    │    └── ViolationResponse.java
              │  │    ├── ParktechResource.java
              │  │    └── veiculo
              │  │      ├── mapper
              │  │      │  └── VeiculoMapper.java
              │  │      ├── request
              │  │      │  ├── DadosAtualizarVeiculoRequest.java
              │  │      │  ├── VeiculoFiltroConsultaPaginadaRequest.java
              │  │      │  └── VeiculoRequest.java
              │  │      ├── response
              │  │      │  └── VeiculoResponse.java
              │  │      └── VeiculoController.java
              │  └── out
              │    ├── client
              │    │  ├── ConsultarEnderecoPorCepClient.java
              │    │  └── response
              │    │    └── EnderecoResponse.java
              │    ├── condutor
              │    │  ├── DeleteCondutorAdapter.java
              │    │  ├── FindCondutorAdapter.java
              │    │  ├── FindCondutorByIdAdapter.java
              │    │  ├── InsertCondutorAdapter.java
              │    │  └── UpdateCondutorAdapter.java
              │    ├── endereco
              │    │  └── ConsultarEnderecoPorCepAdapter.java
              │    ├── repository
              │    │  ├── CondutorRepository.java
              │    │  ├── CondutorRepositoryCustom.java
              │    │  ├── entity
              │    │  │  ├── CondutorEntity.java
              │    │  │  ├── ContatoEntity.java
              │    │  │  ├── EnderecoEntity.java
              │    │  │  ├── PessoaEntity.java
              │    │  │  ├── PessoaFisicaEntity.java
              │    │  │  └── VeiculoEntity.java
              │    │  ├── impl
              │    │  │  ├── CondutorRepositoryCustomImpl.java
              │    │  │  └── VeiculoRepositoryCustomImpl.java
              │    │  ├── mapper
              │    │  │  ├── CondutorEntityMapper.java
              │    │  │  ├── EnderecoResponseMapper.java
              │    │  │  └── VeiculoEntityMapper.java
              │    │  ├── PageRepositoryCustom.java
              │    │  ├── VeiculoRepository.java
              │    │  └── VeiculoRepositoryCustom.java
              │    └── veiculo
              │      ├── DeleteVeiculoAdapter.java
              │      ├── FindVeiculoAdapter.java
              │      ├── FindVeiculoByIdAdapter.java
              │      ├── InsertVeiculoAdapter.java
              │      └── UpdateVeiculoAdapter.java
              ├── application
              │  ├── core
              │  │  ├── domain
              │  │  │  ├── Condutor.java
              │  │  │  ├── Contato.java
              │  │  │  ├── Endereco.java
              │  │  │  ├── enumeration
              │  │  │  │  └── EstadoEnum.java
              │  │  │  ├── funcionalinterface
              │  │  │  │  └── Mapper.java
              │  │  │  ├── paginacao
              │  │  │  │  └── Page.java
              │  │  │  ├── Pessoa.java
              │  │  │  ├── PessoaFisica.java
              │  │  │  ├── Veiculo.java
              │  │  │  └── VeiculoFiltroConsultaPaginada.java
              │  │  └── usecase
              │  │    ├── condutor
              │  │    │  ├── DeleteCondutorUseCase.java
              │  │    │  ├── FindCondutorByIdUseCase.java
              │  │    │  ├── FindCondutorUseCase.java
              │  │    │  ├── InsertCondutorUseCase.java
              │  │    │  └── UpdateCondutorUseCase.java
              │  │    └── veiculo
              │  │      ├── DeleteVeiculoUseCase.java
              │  │      ├── FindVeiculoByIdUseCase.java
              │  │      ├── FindVeiculoUseCase.java
              │  │      ├── InsertVeiculoUseCase.java
              │  │      └── UpdateVeiculoUseCase.java
              │  └── ports
              │    ├── in
              │    │  ├── condutor
              │    │  │  ├── DeleteCondutorInputPort.java
              │    │  │  ├── FindCondutorByIdInputPort.java
              │    │  │  ├── FindCondutorInputPort.java
              │    │  │  ├── InsertCondutorInputPort.java
              │    │  │  └── UpdateCondutorInputPort.java
              │    │  └── veiculo
              │    │    ├── DeleteVeiculoInputPort.java
              │    │    ├── FindVeiculoByIdInputPort.java
              │    │    ├── FindVeiculoInputPort.java
              │    │    ├── InsertVeiculoInputPort.java
              │    │    └── UpdateVeiculoInputPort.java
              │    └── out
              │      ├── condutor
              │      │  ├── ConsultarEnderecoPorCepOutputPort.java
              │      │  ├── DeleteCondutorOutputPort.java
              │      │  ├── FindCondutorByIdOutputPort.java
              │      │  ├── FindCondutorOutputPort.java
              │      │  ├── InsertCondutorOutputPort.java
              │      │  └── UpdateCondutorOutputPort.java
              │      └── veiculo
              │        ├── DeleteVeiculoOutputPort.java
              │        ├── FindVeiculoByIdOutputPort.java
              │        ├── FindVeiculoOutputPort.java
              │        ├── InsertVeiculoOutputPort.java
              │        └── UpdateVeiculoOutputPort.java
              ├── config
              │  ├── condutor
              │  │  ├── DeleteCondutorConfig.java
              │  │  ├── FindCondutorByIdConfig.java
              │  │  ├── FindCondutorConfig.java
              │  │  ├── InsertCondutorConfig.java
              │  │  └── UpdateCondutorConfig.java
              │  ├── feign
              │  │  └── FeignConfiguration.java
              │  ├── GroupedOpenApiConfig.java
              │  └── veiculo
              │    ├── DeleteVeiculoConfig.java
              │    ├── FindVeiculoByIdConfig.java
              │    ├── FindVeiculoConfig.java
              │    ├── InsertVeiculoConfig.java
              │    └── UpdateVeiculoConfig.java
              ├── infrastructure
              │  ├── configuration
              │  │  ├── OpenAPIConfiguration.java
              │  │  └── SwaggerConfigProperties.java
              │  └── properties
              │    └── ParktechProperties.java
              └── ParkTechApplication.java
```

</details>

#### Adapters

Adaptadores na arquitetura hexagonal são componentes que traduzem dados e chamadas entre a aplicação e sistemas externos. Por exemplo, um adaptador pode converter dados do formato interno da aplicação para um formato compreendido por um banco de dados externo, permitindo que a lógica de negócios permaneça independente da implementação específica do banco de dados.

Esses adaptadores são a implementação das dependências externas, como a interface do usuário/entrada e a infraestrutura/saída.

- **adapter/inbound:** Nesta parte, encontram-se todos os controladores responsáveis pela entrada de dados na aplicação.

- **adapter/outbound:** Aqui estão todas as integrações externas, como repositórios e integrações de API, que cuidam da
  saída de dados da aplicação.

#### Domain

O "domain" (domínio) na arquitetura hexagonal representa a parte central da aplicação, onde são implementadas as regras de negócios fundamentais. Nesta camada, a lógica específica da aplicação é encapsulada de forma independente de qualquer tecnologia ou detalhes de implementação externos, como interfaces de usuário ou bancos de dados.

Neste contexto, as classes no domínio não possuem dependências externas, incluindo dependências de estrutura. A estrutura do domínio pode ser organizada da seguinte forma:

- **domain/domain:** Aqui estão todas as entidades e objetos do domínio, sem nenhuma dependência externa.

- **domain/ports/inbound:** Nesta parte, são definidas as interfaces que representam os casos de uso da aplicação.

- **domain/ports/outbound:** Esta seção contém as interfaces que representam os serviços externos utilizados pela
  aplicação. Importante notar que aqui não há nenhuma nomenclatura ligada a tecnologias específicas.

- domain/usecase: Nesta área, ocorre a implementação concreta dos casos de uso da aplicação.

### Consideração

> O desenvolvimento deste projeto está fundamentado na Arquitetura Hexagonal[^3], onde a principal preocupação reside em aplicar corretamente os conceitos de portas e adaptadores, estando integralmente alinhado com o princípio de inversão de dependências.
> É crucial observar que os casos de uso, interfaces (portas) e domínios não devem apresentar dependências externas, incluindo aquelas relacionadas ao framework utilizado.
> A proposta é assegurar que a lógica de negócios esteja completamente isolada desses fatores externos, garantindo assim sua integridade e independência.

## CI/CD

CI/CD é a abreviação de Continuous Integration/Continuous Delivery, traduzindo para o português: integração e entrega contínuas. Trata-se de uma prática de desenvolvimento de software que visa tornar a integração de código mais eficiente por meio de builds e testes automatizados. [^2]

### Github Action

GitHub Actions é uma plataforma de integração contínua e entrega contínua (CI/CD) que permite automatizar sua compilação, testes e pipeline de implantação. É possível criar fluxos de trabalho que compilarão e testarão cada solicitação de pull em seu repositório ou implantarão solicitações de pull mescladas em produção. [^3]

#### Pipeline CI/CD

1. **Publicação da Imagem no Docker Hub - Branch Develop [^4].**

  - No início do desenvolvimento, é criada uma branch `feature/w.x.y.z` a partir da branch `develop`.
  - Ao finalizar o desenvolvimento, é aberto um `Pull Request` da branch `feature/w.x.y.z` para `develop`.
  - Quando esse `PR` for `mesclado`, o fluxo de trabalho `git-flow-publish-image-develop.yaml` do GitHub Actions será
    acionado, gerando a imagem `Docker` e publicando-a no `Docker Hub`.

2. **Criação da Release - Branch Main [^4].**

  - Quando a validação das funcionalidades for realizada, é criada uma branch `release/w.x.y.z` a partir da
    branch `develop`.
  - Após mesclar esse `PR`, o fluxo de trabalho `create-release.yaml` do GitHub Actions será acionado, gerando a
    imagem `Docker` e publicando-a no `Docker Hub`, além de criar automaticamente uma `tag` de versão `w.x.y.z`.

3. **Endereço do Docker Hub:**
  - [https://hub.docker.com/repository/docker/fosales/park-tech/general](https://hub.docker.com/repository/docker/fosales/park-tech/general)

#### Secrets

Secrets são variáveis que você cria em uma organização, repositório ou ambiente de repositório. Os Secrets que você cria estão disponíveis para utilização nos fluxos de trabalho em GitHub Actions. GitHub Actions só poderá ler um Secret se você incluí-lo explicitamente em um fluxo de trabalho.

1. **Lista dos secrets que devem ser configurados no repositório:**
  - **Repositório Github:**
      - GIT_TOKEN
      - GIT_EMAIL
  - **DockerHub:***
     - DOCKERHUB_USERNAME
     - DOCKERHUB_TOKEN
  - **Park-Tech:**
     - PARK_TECH_PROFILE_ENVIRONMENT
     - PARK_TECH_MONGODB_URI
     - PARK_TECH_MONGODB_DATABASE

## Referência

[^1]: [Alistair in the "Hexagone" 1/3](https://www.youtube.com/watch?v=th4AgBcrEHA).
[^2]: [CI/CD](<https://www.redhat.com/pt-br/topics/devops/what-is-ci-cd#:~:text=CI%2FCD%20%C3%A9%20a%20abrevia%C3%A7%C3%A3o,de%20builds%20e%20testes%20automatizados.>).
[^3]: [GitHub Actions](<https://docs.github.com/pt/actions/learn-github-actions/understanding-github-actions>).
[^4]: [Git Flow - Alura](https://www.alura.com.br/artigos/git-flow-o-que-e-como-quando-utilizar)
