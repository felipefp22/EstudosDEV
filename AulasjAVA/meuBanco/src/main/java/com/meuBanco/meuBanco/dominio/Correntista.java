package com.meuBanco.meuBanco.dominio;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Correntista {
    @JsonProperty
    private String cpf;
    @JsonProperty
    private String nome;


}
