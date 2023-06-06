package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int valor;
        Dolar dolar = new Dolar();
        Conversao conversao = new Conversao();
        conversao = dolar.puxarCotacaoDolar();

        double cotacao = Double.parseDouble(conversao.getHigh());

        System.out.println("Qual valor deseja converter em dolares?");
        valor = sc.nextInt();

        System.out.printf("Para R$: " + valor + " Na cotação de U$: " + cotacao + "/R$ || São U$: %.2f", (cotacao * (double) valor));
    }
}