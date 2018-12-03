package com.example.uesb_usr.cestabasicaapp.dominioapp.entidades;

public class User {
    int id;
    String email;
    String senha;
    String confirm_senha;
    String estado;
    String cidade;
    String nome;


    public User(int id, String email, String senha, String confirm_senha, String estado, String cidade, String nome) {
        this.id = id;
        this.email = email;
        this.senha = senha;
        this.confirm_senha = confirm_senha;
        this.estado = estado;
        this.cidade = cidade;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getConfirm_senha() {
        return confirm_senha;
    }

    public void setConfirm_senha(String confirm_senha) {
        this.confirm_senha = confirm_senha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
