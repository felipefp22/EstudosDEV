package org.example;

import com.google.gson.Gson;
import lombok.Data;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

@Data
public class Dolar {
    private String code;
    private String codeIn;
    private String name;
    private String high;
    private String low;
    private String varbid;
    private String pctChange;
    private String bid;
    private String ask;
    private String timestamp;
    private String create_date;

    public Conversao puxarCotacaoDolar() throws IOException {
        Conversao dolar;
        URL urlDolar = null;
        try {
            urlDolar = new URL("https://economia.awesomeapi.com.br/last/USD-BRL");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        URLConnection conection = urlDolar.openConnection();
        InputStream is = conection.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

        String moedas = "";
        StringBuilder jsonMoedas = new StringBuilder();

        while ((moedas = br.readLine()) != null){
            jsonMoedas.append(moedas);
        }

        dolar = new Gson().fromJson(jsonMoedas.toString(), Conversao.class);
        return dolar;
    }
}
