module "hmg" {
  source = "../../infra"

  nome_repositorio = "park-tech"
  nomeResource     = "park-tech"
  containerName    = "park-tech"
  ambiente         = "homologacao"
}

