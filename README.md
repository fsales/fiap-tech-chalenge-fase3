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

- [:bookmark\_tabs: Tech Chalenge](#bookmark_tabs-tech-chalenge)
  - [🛠️ Linguagem e ferramentas](#️-linguagem-e-ferramentas)
  - [🏫 Dados Acadêmicos](#-dados-acadêmicos)
    - [🏬 Instituição](#-instituição)
    - [🧑🏻‍🎓Curso](#curso)
    - [Aluno](#aluno)
  - [Ferramentas](#ferramentas)
  - [CI/CD](#cicd)
    - [Github Action](#github-action)
      - [Secrets](#secrets)
  - [Referência](#referência)
# :bookmark_tabs: Tech Chalenge

> Tech Challenge para avaliação da Fase III da Pós Graduação em Arquitetura e Desenvolvimento Java.

## 🛠️ Linguagem e ferramentas

[![logo java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=kofi&logoColor=white)](#)

[![logo spring](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white)](#)

 [![logo git](https://img.shields.io/badge/GIT-E44C30?style=for-the-badge&logo=git&logoColor=white)](#) [![logo github](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)](#)

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

## Ferramentas

- [IntelliJ IDEA](https://www.jetbrains.com/pt-br/idea/)
- [Postman](https://www.postman.com/)
- [Chrome](https://www.google.pt/intl/pt-PT/chrome/?brand=FKPE&gclid=EAIaIQobChMI8cT_xsr1_wIVA2GRCh0hxwthEAAYASAAEgK0h_D_BwE&gclsrc=aw.ds)
- [Git](https://git-scm.com/)
- [Github](https://github.com)
- [Docker](https://docker.com)

## CI/CD


  CI/CD é a abreviação de Continuous Integration/Continuous Delivery, traduzindo para o português: integração e entrega contínuas. 
Trata-se de uma prática de desenvolvimento de software que visa tornar a integração de código mais eficiente por meio de builds e testes automatizados. [^1]
    

### Github Action


  GitHub Actions é uma plataforma de integração contínua e entrega contínua (CI/CD) que permite automatizar a sua compilação, testar e pipeline de implantação.
É possível criar fluxos de trabalho que criam e testam cada pull request no seu repositório, ou implantar pull requests mesclados em produção.[^2]
    

#### Secrets


 Secrets são variáveis que você cria em uma organização, repositório ou ambiente de repositório. Os Secrets que você cria estão disponíveis 
para utilização nos fluxos de trabalho em GitHub Actions. GitHub Actions só poderá ler um Secrets se você incluí-lo explicitamente em um fluxo de trabalho.

    1. relação dos secrets que devem ser configurados no repositório:

       1. Repositório Github:
          1. GIT_TOKEN 
          2. GIT_EMAIL

       2. DockerHub
          1. DOCKERHUB_USERNAME
          2. DOCKERHUB_TOKEN

## Referência

[^1]: [CI/CD](<https://www.redhat.com/pt-br/topics/devops/what-is-ci-cd#:~:text=CI%2FCD%20%C3%A9%20a%20abrevia%C3%A7%C3%A3o,de%20builds%20e%20testes%20automatizados.>).
[^2]: [GitHub Actions](<https://docs.github.com/pt/actions/learn-github-actions/understanding-github-actions>).
