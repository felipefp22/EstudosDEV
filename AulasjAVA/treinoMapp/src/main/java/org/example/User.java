package org.example;

import java.util.Objects;

public class User {
    private String nome;

    private String chave;

    public User(String nome, String chave){
        this.nome = nome;
        this.chave = chave;
    }

    public User(){

    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(nome, user.nome) && Objects.equals(chave, user.chave);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, chave);
    }
}
