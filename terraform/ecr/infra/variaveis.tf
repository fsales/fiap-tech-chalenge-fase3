## variaveis

variable "nome_repositorio" {
  type        = string
  description = "Nome do repositório"
}

variable "ambiente" {
  type = string
}

/** container **/

variable "nomeResource" {
  type        = string
  description = "Nome dos Recursos"
}

variable "containerName" {
  type        = string
  description = "Nome do container"
}