module "hmg" {
  source = "../../infra"

  nomeResource = "park-tech"

  nome_repositorio = "homologacao"
  cargoIAM         = "homologacao"
  ambiente         = "homologacao"

  hostPort = 8080
  albPort  = 8080

  containerName = "park-tech"
  image         = "docker.io/fosales/park-tech"
  tag           = "0.0.1.6"
  containerPort = 8080
  environment   = {
    "PROFILE_ENVIRONMENT" = {
      name  = "PARK_TECH_PROFILE_ENVIRONMENT",
      value = "cloud-atlas"
    },
    "DATABASE" = {
      name  = "PARK_TECH_MONGODB_DATABASE",
      value = "parktech"
    },
    "DATABASE_URI" = {
      name  = "PARK_TECH_MONGODB_URI",
      value = var.uriDatabase
    }
  }

}

output "ip_abl" {
  value = module.hmg.ip
}
