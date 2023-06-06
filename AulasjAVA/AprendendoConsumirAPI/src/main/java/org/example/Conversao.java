package org.example;

import lombok.Data;

@Data
public class Conversao {
    private Dolar USDBRL;

    private Euro euro;

    public String getHigh(){
        return USDBRL.getHigh();
    }
}
