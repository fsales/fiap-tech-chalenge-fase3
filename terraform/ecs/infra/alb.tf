## Criando load balancer
resource "aws_lb" "alb_ecs" {
  name               = "alb-ecs-${var.nomeResource}"
  load_balancer_type = "application"
  security_groups    = [aws_security_group.sg_alb_ecs.id]
  subnets            = module.vpc.public_subnets
  tags               = {
    Terraform     = "true"
    Environment   = "${var.ambiente}"
    nomeResource  = "${var.nomeResource}"
    containerName = "${var.containerName}"
  }
}


## Criar Listener Load Balancer - entrada
resource "aws_lb_listener" "http" {
  load_balancer_arn = aws_lb.alb_ecs.arn
  port              = "${var.albPort}"
  protocol          = "HTTP"

  default_action {
    type             = "forward"
    target_group_arn = aws_lb_target_group.tg_ecs_app.arn
  }

  tags = {
    Terraform     = "true"
    Environment   = "${var.ambiente}"
    nomeResource  = "${var.nomeResource}"
    containerName = "${var.containerName}"
  }
}

## Criando Target Group
resource "aws_lb_target_group" "tg_ecs_app" {
  name        = "tg-ecs-${var.nomeResource}"
  port        = var.albPort
  protocol    = "HTTP"
  target_type = "ip"
  vpc_id      = module.vpc.vpc_id
  lifecycle {
    create_before_destroy = true
    ignore_changes        = [name]
  }

  tags = {
    Terraform     = "true"
    Environment   = "${var.ambiente}"
    nomeResource  = "${var.nomeResource}"
    containerName = "${var.containerName}"
  }
}


## exibir o DNS do Load Balancer
output "ip" {
  value = aws_lb.alb_ecs.dns_name
}