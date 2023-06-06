package com.meuBanco.meuBanco.dominio;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.Objects;

public class ContaCorrente {

    @Getter private String banco;
    @Getter private String agencia;
    @Getter private String numero;
    private BigDecimal saldo;
    @Getter private Correntista correntista;

    public ContaCorrente(String banco, String agencia, String numero, Correntista correntista) {
        this();
        this.banco = banco;
        this.agencia = agencia;
        this.numero = numero;
        this.correntista = correntista;
    }
    public ContaCorrente() {
        this.saldo = BigDecimal.ZERO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContaCorrente that = (ContaCorrente) o;
        return banco.equals(that.banco) && agencia.equals(that.agencia) && numero.equals(that.numero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(banco, agencia, numero);
    }

    public boolean indentificadaPor(String banco, String agencia, String numero){
        return this.banco.equals(banco)
                && this.agencia.equals(agencia)
                &&this.numero.equals(numero);
    }

    public BigDecimal lerSaldo() {
        return saldo;
    }

    public void executar(Operacao operacao, BigDecimal valor){
        saldo = operacao.executar(saldo, valor);
    }
}
