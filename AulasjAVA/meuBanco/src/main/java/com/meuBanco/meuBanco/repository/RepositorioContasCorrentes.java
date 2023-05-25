package com.meuBanco.meuBanco.repository;

import com.meuBanco.meuBanco.dominio.ContaCorrente;
import com.meuBanco.meuBanco.dominio.Operacao;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Repository
public class RepositorioContasCorrentes {

    private Set<ContaCorrente> contas;

    public RepositorioContasCorrentes(){
        contas = new HashSet<>();
    }
    public void salvar(ContaCorrente conta){
        contas.add(conta);
    }

    public Optional<ContaCorrente> buscar (String banco, String agencia, String numero){
        return contas.stream().filter(contaCorrente -> contaCorrente.indentificadaPor(banco, agencia, numero)).findFirst();
    }

    public void fechar(ContaCorrente conta) {
        contas.remove(conta);
    }
}
