terraform {
  backend "s3" {
    bucket = "terraform-state-park-tech-ecr"
    key    = "hmg/terraform.tfstate"
    region = "us-west-2"
  }
}
