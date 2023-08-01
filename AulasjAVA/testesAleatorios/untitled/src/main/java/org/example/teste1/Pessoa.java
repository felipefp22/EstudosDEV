package org.example.teste1;

public class Pessoa {

    private final String name;

    private final int age;

    public Pessoa setName(String name) {
        this.name = name;
        return this;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

