module "hmg" {
  source = "../../infra"

  nomeResource = "park-tech"

  nome_repositorio = "homologacao"
  cargoIAM         = "homologacao"
  ambiente         = "homologacao"

  hostPort = 80
  albPort  = 80

  containerName = "park-tech"
  image         = "docker.io/fosales/park-tech"
  tag           = var.imagemTag
  containerPort = 80
  environment   = {
    "PROFILE_ENVIRONMENT" = {
      name  = "PARK_TECH_PROFILE_ENVIRONMENT",
      value = "cloud"
    },
    "DATABASE" = {
      name  = "PARK_TECH_MONGODB_DATABASE",
      value = "parktech"
    },
    "DATABASE_URI" = {
      name  = "PARK_TECH_MONGODB_URI",
      value = var.uriDatabase
    }
    "PORT_APP_CONTAINER" = {
      name  = "EXPOSE_PORT",
      value = 80
    }
  }

}

output "ip_abl" {
  value = module.hmg.ip
}