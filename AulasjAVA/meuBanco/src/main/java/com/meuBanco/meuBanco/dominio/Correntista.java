package com.meuBanco.meuBanco.dominio;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
public class Correntista {
    private String cpf;

    private String nome;

    private String dataDeCriacao = String.valueOf(LocalDate.now());
    public Correntista(String cpf, String nome){
        this.cpf = cpf;
        this.nome = nome;
    }
}
