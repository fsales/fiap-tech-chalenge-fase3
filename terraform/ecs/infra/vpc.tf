module "vpc" {
  source = "terraform-aws-modules/vpc/aws"

  name = "VPC-ECS"
  cidr = "10.0.0.0/16" #10.0.1.1 - 10.0.255.255

  azs             = ["us-west-2a", "us-west-2b", "us-west-2c"]
  private_subnets = ["10.0.1.0/24", "10.0.2.0/24", "10.0.3.0/24"]
  public_subnets  = ["10.0.101.0/24", "10.0.102.0/24", "10.0.103.0/24"]

  enable_nat_gateway = true

  tags = {
    Terraform     = "true"
    Environment   = "${var.ambiente}"
    nomeResource  = "${var.nomeResource}"
    containerName = "${var.containerName}"
  }
}

## Obter o intervalo de IP da VPC
#output "vpc_cidr_block" {
#  value = module.vpc.vpc_cidr_block
#}
#
#
## Obter os intervalos de IP das sub-redes privadas
#output "subnet_cidr_blocks" {
#  value = module.vpc.private_subnets_cidr_blocks
#}
#
#resource "aws_vpc_peering_connection" "mongodb_atlas" { # peering mongodb atlas: https://www.youtube.com/watch?v=8NITVf0L5X0
#  peer_vpc_id = "vpc-xxx"  # ID da VPC do MongoDB Atlas
#  vpc_id      = module.vpc.vpc_id  # ID da sua VPC na AWS
#  auto_accept = true
#  tags        = {
#    Terraform     = "true"
#    Environment   = "${var.ambiente}"
#    nomeResource  = "${var.nomeResource}"
#    containerName = "${var.containerName}"
#  }
#}
#
#resource "aws_route" "route_to_mongodb" {
#  route_table_id            = module.vpc.private_route_table_ids[0]  # ou o ID da sua tabela de roteamento privada
#  destination_cidr_block    = "000.000.000.0/21"  # CIDR da VPC do MongoDB Atlas
#  vpc_peering_connection_id = aws_vpc_peering_connection.mongodb_atlas.id
#}








