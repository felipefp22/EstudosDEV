package com.meuBanco.meuBanco.controller.Form;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.meuBanco.meuBanco.dominio.ContaCorrente;
import com.meuBanco.meuBanco.dominio.MovimentacaoDeConta;
import com.meuBanco.meuBanco.dominio.Operacao;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public class MovimentacaoDeContaForm {

    @JsonProperty
    @NotNull(message = "Precisa inserir número da Conta")
    private ContaCorrente conta;
    @JsonProperty
    @NotNull(message = "Precisa inserir Valor da Operação")
    private BigDecimal valor;
    @JsonProperty
    @NotNull(message = "Precisa escolher a operação, Deposito ou Saque")
    private Operacao operacao;

    public MovimentacaoDeConta toMovimentacaoDeConta(){
        return new MovimentacaoDeConta(conta, valor, operacao);
    }
}
