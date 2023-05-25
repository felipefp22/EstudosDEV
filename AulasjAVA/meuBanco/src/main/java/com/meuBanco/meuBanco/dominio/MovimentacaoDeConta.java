package com.meuBanco.meuBanco.dominio;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class MovimentacaoDeConta {
    @JsonProperty
    private ContaCorrente conta;
    @JsonProperty
    private BigDecimal valor;
    @JsonProperty
    private Operacao operacao;

    public void executarEm(ContaCorrente conta){
        Operacao operacao = Operacao.values()[this.operacao.ordinal()];
        conta.executar(operacao, valor);
        }

    public String getBanco() {
        return conta.getBanco();
    }

    public String getAgencia() {
        return conta.getAgencia();
    }

    public String getNuemro() {
        return conta.getNumero();
    }
}
