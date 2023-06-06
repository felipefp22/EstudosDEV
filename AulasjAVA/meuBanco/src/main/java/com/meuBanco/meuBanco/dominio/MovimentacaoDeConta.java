package com.meuBanco.meuBanco.dominio;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;
@AllArgsConstructor
public class MovimentacaoDeConta {
    private ContaCorrente conta;
    private BigDecimal valor;
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
