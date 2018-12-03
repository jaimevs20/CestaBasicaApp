package com.example.uesb_usr.cestabasicaapp.dominioapp.entidades;

public class Classe {
    int id;
    String tipo, status;

    public Classe(int id, String tipo, String status) {
        this.id = id;
        this.tipo = tipo;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
