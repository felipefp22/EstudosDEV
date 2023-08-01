package org.example.teste1;


public class Main {
    public static void main(String[] args) {
        Pessoa p = new Pessoa("jorge", 15);

        System.out.println(p);

        p = new Pessoa("maria", 27);

        System.out.println(p.name());
    }
}