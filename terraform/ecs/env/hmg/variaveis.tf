## variaveis


variable "uriDatabase" {
  description = "URI do banco com usuario e senha"
  type        = string
  sensitive   = true
}

variable "imagemTag" {
  description = "Tag da imagem gerada"
  type        = string
}


variable "parktechNasicAuthName" {
  description = "Usuário para autenticação no sistema"
  type        = string
}

variable "parktechNasicAuthPassword" {
  description = "Senha para autenticação no sistema"
  type        = string
  sensitive   = true
}
