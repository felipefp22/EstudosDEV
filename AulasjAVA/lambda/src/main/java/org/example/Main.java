package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> valores = new ArrayList<Integer>();
        ArrayList<Integer> triplo = new ArrayList<Integer>();
        ArrayList<Integer> par = new ArrayList<Integer>();
        ArrayList<Integer> impar = new ArrayList<Integer>();

        valores.add(1);
        valores.add(2);
        valores.add(3);
        valores.add(4);
        valores.add(5);
        valores.add(6);
        valores.add(7);

        valores.forEach((vel) -> {
            triplo.add(vel*3);

            if (vel % 2 == 0) {
                par.add(vel);
            } else {
                impar.add(vel);
            }
        });

        System.out.println(valores);
        System.out.println(triplo);
        System.out.println(par);
        System.out.println(impar);

    }
}