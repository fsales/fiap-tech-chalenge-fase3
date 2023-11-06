module "ecs" {
  source = "terraform-aws-modules/ecs/aws"

  cluster_name = var.ambiente

  cluster_configuration = {
    execute_command_configuration = {
      logging           = "OVERRIDE"
      log_configuration = {
        cloud_watch_log_group_name = "/aws/ecs/aws-ec2"
      }
    }
  }

  fargate_capacity_providers = {
    FARGATE = {
      default_capacity_provider_strategy = {
        weight = 50
      }
    }
    #    FARGATE_SPOT = {
    #      default_capacity_provider_strategy = {
    #        weight = 50
    #      }
    #    }
  }
  tags = {
    Terraform     = "true"
    Environment   = "${var.ambiente}"
    nomeResource  = "${var.nomeResource}"
    containerName = "${var.containerName}"
  }
}

# task definition
resource "aws_ecs_task_definition" "app_api_tks" {
  family                   = "tks-api-${var.nomeResource}"
  requires_compatibilities = ["FARGATE"]
  network_mode             = "awsvpc"
  cpu                      = 512
  memory                   = 1024
  execution_role_arn       = aws_iam_role.cargo.arn
  container_definitions    = jsonencode([
    {
      "name"      = var.containerName
      "image"     = "${var.image}:${var.tag}"
      "cpu"       = 512
      "memory"    = 1024
      "essential" = true
      "portMappings" : [
        {
          "containerPort" = var.containerPort
          "hostPort"      = var.hostPort
        }
      ],
      "environment" = [
        for env in var.environment : {
          name  = env.name
          value = env.value
        }
      ]
    }
  ])
  tags = {
    Terraform     = "true"
    Environment   = "${var.ambiente}"
    nomeResource  = "${var.nomeResource}"
    containerName = "${var.containerName}"
  }
}

# service
resource "aws_ecs_service" "app_api_ecs_svc" {
  name            = "svc-ecs-api-${var.nomeResource}"
  cluster         = module.ecs.cluster_id
  task_definition = aws_ecs_task_definition.app_api_tks.arn
  desired_count   = 1

  load_balancer {
    target_group_arn = aws_lb_target_group.tg_ecs_app.arn
    container_name   = var.containerName
    container_port   = var.containerPort
  }

  ## Criar network (obrigatório quando trabalha com VPC)
  network_configuration {
    subnets         = module.vpc.private_subnets
    security_groups = [aws_security_group.privado.id]
  }

  ## 
  capacity_provider_strategy {
    capacity_provider = "FARGATE"
    weight            = 1 #100/100
  }

  #  capacity_provider_strategy {
  #    capacity_provider = "FARGATE_SPOT"
  #    weight            = 1 #100/100
  #  }

  tags = {
    Terraform     = "true"
    Environment   = "${var.ambiente}"
    nomeResource  = "${var.nomeResource}"
    containerName = "${var.containerName}"
  }
}

