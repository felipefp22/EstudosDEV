package com.meuBanco.meuBanco.controller;

import com.meuBanco.meuBanco.dominio.ContaCorrente;
import com.meuBanco.meuBanco.dominio.Correntista;
import com.meuBanco.meuBanco.dominio.MovimentacaoDeConta;
import com.meuBanco.meuBanco.repository.RepositorioContasCorrentes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Random;

@RestController
@RequestMapping("/contas")
public class ContaCorrenteController {
    @Autowired
    private RepositorioContasCorrentes repositorioContasCorrentes;

    @GetMapping
    public String consultarSaldo(@RequestParam(name= "banco") String banco,
                                 @RequestParam(name = "agencia") String agencia,
                                 @RequestParam(name = "numero") String numero) {
        ContaCorrente contaCorrente = repositorioContasCorrentes.buscar(banco, agencia, numero).orElse(new ContaCorrente());


        return  String.format("Banco: %s, Agencia: %s, Conta: %s. Saldo: %s.", banco, agencia, numero, contaCorrente.lerSaldo());

    }

    @PostMapping
    public ResponseEntity<ContaCorrente> criarNovaConta(@RequestBody Correntista correntista){
        String banco = "1";
        String agencia = "22";
        String numero = Integer.toString(new Random().nextInt(Integer.MAX_VALUE));
        ContaCorrente conta = new ContaCorrente( banco, agencia , numero, correntista);

        repositorioContasCorrentes.salvar(conta);

        return ResponseEntity.status(HttpStatus.CREATED).body(conta);
    }

    @DeleteMapping
    public ResponseEntity<String> fecharConta(@RequestBody ContaCorrente conta){
        Optional<ContaCorrente> opContaCorrente = repositorioContasCorrentes.buscar(conta.getBanco(), conta.getAgencia(), conta.getNumero());

        if (opContaCorrente.isEmpty()){
            return ResponseEntity.ofNullable("Impossivel apagar conta inexistente");
        }else {
            ContaCorrente contaCorrente = opContaCorrente.get();
            repositorioContasCorrentes.fechar(contaCorrente);
            return ResponseEntity.ok(conta + " - Conta Fechada!");
        }
    }

    @PutMapping
    public ResponseEntity<String> movimentarConta(@RequestBody MovimentacaoDeConta movimentacao){
        Optional<ContaCorrente> opContaCorrente = repositorioContasCorrentes.buscar(movimentacao.getBanco(), movimentacao.getAgencia(), movimentacao.getNuemro());

        if (opContaCorrente.isEmpty()){
            return ResponseEntity.badRequest().body("Conta corrente não existe");
        }else {
            ContaCorrente contaCorrente = opContaCorrente.get();
            movimentacao.executarEm(contaCorrente);
            repositorioContasCorrentes.salvar(contaCorrente);
            return ResponseEntity.ok("Movimentaço realizada com sucesso");
        }
            }
}

// curl -i -X POST http://localhost:8090/criarConta -H "Content-Type: application/json" -d '{"nome":"Rodrigo Vieira","cpf":"90365421526"}'
// http://localhost:8090/contas?banco=888&agencia=1111&numero=3333