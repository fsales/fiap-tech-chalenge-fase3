### AWS ECR
resource "aws_ecr_repository" "repositorio_ecr" {
  name = var.nome_repositorio

  tags = {
    Terraform     = "true"
    Environment   = "${var.ambiente}"
    nomeResource  = "${var.nomeResource}"
    containerName = "${var.containerName}"
  }
}