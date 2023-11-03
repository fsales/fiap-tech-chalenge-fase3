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
