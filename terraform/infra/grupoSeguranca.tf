################ Criando grupo de segurança rede publica###############################
resource "aws_security_group" "sg_alb_ecs" {
  name   = "alb-ecs"
  vpc_id = module.vpc.vpc_id
  tags   = {
    Terraform     = "true"
    Environment   = "${var.ambiente}"
    nomeResource  = "${var.nomeResource}"
    containerName = "${var.containerName}"
  }
}

## Criando regras
resource "aws_security_group_rule" "entrada_alb" {
  type              = "ingress"
  from_port         = var.albPort
  to_port           = var.albPort
  protocol          = "tcp"
  cidr_blocks       = ["0.0.0.0/0"]
  security_group_id = aws_security_group.sg_alb_ecs.id
}


resource "aws_security_group_rule" "saida_alb" {
  type              = "egress"
  from_port         = 0
  to_port           = 0
  protocol          = "-1"
  cidr_blocks       = ["0.0.0.0/0"]
  security_group_id = aws_security_group.sg_alb_ecs.id
}


################ Criando grupo de segurança rede privada###############################
resource "aws_security_group" "privado" {
  name   = "privado_ecs"
  vpc_id = module.vpc.vpc_id
  tags   = {
    Terraform     = "true"
    Environment   = "${var.ambiente}"
    nomeResource  = "${var.nomeResource}"
    containerName = "${var.containerName}"
  }
}

## Criando regras
resource "aws_security_group_rule" "entrada_alb_ecs" {
  type                     = "ingress"
  from_port                = 0
  to_port                  = 0
  protocol                 = "-1"
  source_security_group_id = aws_security_group.sg_alb_ecs.id
  security_group_id        = aws_security_group.privado.id
}

resource "aws_security_group_rule" "saida_alb_ecs" {
  type              = "egress"
  from_port         = 0
  to_port           = 0
  protocol          = "-1"
  cidr_blocks       = ["0.0.0.0/0"]
  security_group_id = aws_security_group.privado.id
}
