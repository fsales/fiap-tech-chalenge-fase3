package br.com.fsales.parktech.adapters.out.client.response;

public record EnderecoResponse(String cep, String logradouro, String complemento, String bairro, String localidade,
                               String uf) {

}
