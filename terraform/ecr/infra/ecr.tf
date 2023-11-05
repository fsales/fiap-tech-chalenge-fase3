### AWS ECR
resource "aws_ecr_repository" "repositorio_ecr" {
  name = var.nome_repositorio
  force_delete = true  # forçar a exclusão, mesmo que o repositório não esteja vazio
  tags = {
    Terraform     = "true"
    Environment   = "${var.ambiente}"
    nomeResource  = "${var.nomeResource}"
    containerName = "${var.containerName}"
  }
}