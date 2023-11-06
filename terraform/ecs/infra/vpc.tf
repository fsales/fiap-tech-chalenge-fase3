module "vpc" {
  source = "terraform-aws-modules/vpc/aws"

  name = "VPC-ECS"
  cidr = "198.19.0.0/16" #10.0.1.1 - 10.0.255.255


  azs             = ["us-west-2a", "us-west-2b", "us-west-2c"]

  private_subnets = ["198.19.1.0/24", "198.19.2.0/24", "198.19.3.0/24"]
  public_subnets  = ["198.19.101.0/24", "198.19.102.0/24", "198.19.103.0/24"]

  enable_nat_gateway = true

  tags = {
    Terraform     = "true"
    Environment   = "${var.ambiente}"
    nomeResource  = "${var.nomeResource}"
    containerName = "${var.containerName}"
  }
}

# Obtenha detalhes da conexão de peering de VPC
data "aws_vpc_peering_connection" "peering_mongodb_atlas" {
  id = var.idConexaoPeeringMongoDB  # ID da sua conexão de peering de VPC existente
}

resource "aws_vpc_peering_connection" "vpc_peering_to_mongodb" {
  peer_vpc_id = data.aws_vpc_peering_connection.peering_mongodb_atlas.peer_vpc_id
  vpc_id      = module.vpc.vpc_id
  auto_accept = true

  tags = {
    Name          = "vpc_peering_ecs_mongodb"
    Terraform     = "true"
    Environment   = "${var.ambiente}"
    nomeResource  = "${var.nomeResource}"
    containerName = "${var.containerName}"
  }
}

resource "aws_route" "peer_route" {
  for_each       = {for idx, route_table_id in module.vpc.private_route_table_ids : idx => route_table_id}
  route_table_id = each.value

  destination_cidr_block    = data.aws_vpc_peering_connection.peering_mongodb_atlas.cidr_block
  vpc_peering_connection_id = aws_vpc_peering_connection.vpc_peering_to_mongodb.id
}










