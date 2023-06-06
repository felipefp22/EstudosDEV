package com.meuBanco.meuBanco.controller;

import com.meuBanco.meuBanco.controller.Form.ContaCorrenteForm;
import com.meuBanco.meuBanco.controller.Form.CorrentistaForm;
import com.meuBanco.meuBanco.controller.Form.MovimentacaoDeContaForm;
import com.meuBanco.meuBanco.dominio.ContaCorrente;
import com.meuBanco.meuBanco.dominio.Correntista;
import com.meuBanco.meuBanco.dominio.MovimentacaoDeConta;
import com.meuBanco.meuBanco.repository.RepositorioContasCorrentes;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Path;
import jakarta.validation.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

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
    public ResponseEntity criarNovaConta(@RequestBody CorrentistaForm contaForm){
        Map<Path, String> violacoesToMap = getPathStringMap(contaForm);

        if(!violacoesToMap.isEmpty()) return ResponseEntity.badRequest().body(violacoesToMap);

        Correntista correntista = contaForm.toCorrentista();
        String banco = "1";
        String agencia = "22";

        String numero = Integer.toString(new Random().nextInt(Integer.MAX_VALUE));
        ContaCorrente conta = new ContaCorrente( banco, agencia , numero, correntista);

        repositorioContasCorrentes.salvar(conta);

        return ResponseEntity.status(HttpStatus.CREATED).body(conta);
    }


    @DeleteMapping
    public ResponseEntity fecharConta(@RequestBody ContaCorrenteForm contaForm){
        Map<Path, String> violacoesToMap = getPathStringMap(contaForm);

        if(!violacoesToMap.isEmpty()) return ResponseEntity.badRequest().body(violacoesToMap);

        ContaCorrente conta = contaForm.toContaCorrente();
        Optional<ContaCorrente> opContaCorrente = repositorioContasCorrentes.buscar(conta.getBanco(), conta.getAgencia(), conta.getNumero());

        if (opContaCorrente.isEmpty()){
            return ResponseEntity.ofNullable("Impossivel apagar conta inexistente");
        }else {
            ContaCorrente contaCorrente = opContaCorrente.get();
            repositorioContasCorrentes.fechar(contaCorrente);
            return ResponseEntity.ok(contaCorrente + " - Conta Fechada!");
        }
    }

    @PutMapping
    public ResponseEntity movimentarConta(@RequestBody MovimentacaoDeContaForm movimentacaoForm){
        Map<Path, String> violacoesToMap = getPathStringMap(movimentacaoForm);

        if(!violacoesToMap.isEmpty()) return ResponseEntity.badRequest().body(violacoesToMap);

        MovimentacaoDeConta movimentacao = movimentacaoForm.toMovimentacaoDeConta();
        Optional<ContaCorrente> opContaCorrente = repositorioContasCorrentes.buscar(movimentacao.getBanco(), movimentacao.getAgencia(), movimentacao.getNuemro());

        if (opContaCorrente.isEmpty()){
            return ResponseEntity.badRequest().body("Conta corrente não existe");
        }else {
            ContaCorrente contaCorrente = opContaCorrente.get();
            movimentacao.executarEm(contaCorrente);
            repositorioContasCorrentes.salvar(contaCorrente);
            return ResponseEntity.ok("Movimentaço realizada com sucesso. ContaCorrente: " + contaCorrente.getNumero() + " Saldo Atual: " + contaCorrente.lerSaldo());
        }
            }

    private static <Z>Map<Path, String> getPathStringMap(Z form) {
        Set<ConstraintViolation<Z>> violacoes =
                Validation.buildDefaultValidatorFactory().getValidator().validate(form);
        Map<Path,String> violacoesToMap = violacoes
                .stream()
                .collect(Collectors.toMap(violacao -> violacao.getPropertyPath(), violacao -> violacao.getMessage()));
        return violacoesToMap;
    }
}

// curl -i -X POST http://localhost:8090/criarConta -H "Content-Type: application/json" -d '{"nome":"Rodrigo Vieira","cpf":"90365421526"}'
// http://localhost:8090/contas?banco=888&agencia=1111&numero=3333