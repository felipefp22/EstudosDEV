package com.meuBanco.meuBanco.controller.Form;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.meuBanco.meuBanco.dominio.Correntista;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

@Data
public class CorrentistaForm {
    @JsonProperty
    @NotNull(message = "CPF não pode ser nulo.")
    @CPF
    private String cpf;
    @JsonProperty
    @NotNull(message = "Nome do Correntista não pode ser nulo.")
    @Size(min = 8, message = "Conferir Nome.")
    private String nome;

    public Correntista toCorrentista(){
        return new Correntista(cpf, nome);
    }
}
