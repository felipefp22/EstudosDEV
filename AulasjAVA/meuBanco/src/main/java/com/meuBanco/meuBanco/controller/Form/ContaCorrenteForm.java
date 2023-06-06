package com.meuBanco.meuBanco.controller.Form;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.meuBanco.meuBanco.dominio.ContaCorrente;
import com.meuBanco.meuBanco.dominio.Correntista;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class ContaCorrenteForm{
    @JsonProperty
    @Getter

    @NotBlank(message = "Precisa inserir numero do Banco")
    private String banco;
    @JsonProperty
    @Getter

    @NotBlank(message = "Precisa inserir número da Agencia")
    private String agencia;
    @JsonProperty
    @Getter

    @NotBlank(message = "Precisa inserir número da Conta")
    private String numero;

    @JsonProperty @Getter private Correntista correntista;


    public ContaCorrente toContaCorrente() {
        return new ContaCorrente(banco, agencia, numero, correntista);
    }
}
