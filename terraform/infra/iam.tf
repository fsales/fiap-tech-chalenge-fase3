## criango a role
resource "aws_iam_role" "cargo" {
  name = "${var.cargoIAM}_cargo"

  assume_role_policy = jsonencode({
    Version   = "2012-10-17"
    Statement = [
      {
        Action    = "sts:AssumeRole"
        Effect    = "Allow"
        Sid       = ""
        Principal = {
          Service = [
            "ec2.amazonaws.com",
            "ecs-tasks.amazonaws.com"
          ]
        }
      },
    ]
  })
  tags = {
    Terraform     = "true"
    Environment   = "${var.ambiente}"
    nomeResource  = "${var.nomeResource}"
    containerName = "${var.containerName}"
  }
}

## criando a policy
resource "aws_iam_role_policy" "ecs_ecr" {
  name = "ecs_ecr"
  role = aws_iam_role.cargo.id

  policy = jsonencode({
    Version   = "2012-10-17"
    Statement = [
      {
        Action = [
          "ecr:GetAuthorizationToken",
          "ecr:BatchCheckLayerAvailability",
          "ecr:GetDownloadUrlForLayer",
          "ecr:BatchGetImage",
          "logs:CreateLogStream",
          "logs:PutLogEvents"
        ]
        Effect   = "Allow"
        Resource = "*"
      },
    ]
  })
}

## criar perfil
resource "aws_iam_instance_profile" "perfil" {
  name = "${var.cargoIAM}_perfil"
  role = aws_iam_role.cargo.name
  tags = {
    Terraform     = "true"
    Environment   = "${var.ambiente}"
    nomeResource  = "${var.nomeResource}"
    containerName = "${var.containerName}"
  }
}