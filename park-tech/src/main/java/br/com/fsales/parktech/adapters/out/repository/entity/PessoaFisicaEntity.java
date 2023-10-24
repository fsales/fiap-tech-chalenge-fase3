package br.com.fsales.parktech.adapters.out.repository.entity;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.mongodb.core.index.Indexed;

import java.time.LocalDate;

public abstract sealed class PessoaFisicaEntity extends PessoaEntity permits CondutorEntity {

    @Indexed(unique = true)
    @NotBlank
    protected String cpf;

    @NotBlank
    protected LocalDate dataNascimento;

    public PessoaFisicaEntity() {
        super();
    }

    public PessoaFisicaEntity(String nome, LocalDate dataNascimento, ContatoEntity contatoEntity,
                              EnderecoEntity enderecoEntity, String cpf) {
        super(nome, contatoEntity, enderecoEntity);
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    public abstract String cpf();

    public abstract PessoaFisicaEntity setCpf(String cpf);

    public abstract LocalDate getDataNascimento();

    public abstract PessoaFisicaEntity setDataNascimento(LocalDate dataNascimento);

}
