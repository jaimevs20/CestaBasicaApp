package com.example.uesb_usr.cestabasicaapp.dominioapp.entidades;

public class Item {
    int id;
    String tipo, unidade_medida,status;

    public Item(int id, String tipo, String unidade_medida, String status) {
        this.id = id;
        this.tipo = tipo;
        this.unidade_medida = unidade_medida;
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

    public String getUnidade_medida() {
        return unidade_medida;
    }

    public void setUnidade_medida(String unidade_medida) {
        this.unidade_medida = unidade_medida;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
