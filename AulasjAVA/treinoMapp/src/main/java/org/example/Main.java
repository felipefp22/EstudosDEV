package org.example;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("OI" , "Ola");
        map.put("Xau", "Tchau");

        System.out.println(map);
        System.out.println(map.values());

        System.out.println("_____________________");

        User Z = new User();
        User Y = new User();



        System.out.println(Z);
        System.out.println(Z.hashCode());
        System.out.println(Y);
        System.out.println(Y.hashCode());
        System.out.println(Z.equals(Y));

    }
}