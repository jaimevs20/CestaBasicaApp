package com.example.uesb_usr.cestabasicaapp.modelos;

public class Pesquisa {
    public int id;
    public int fk_produto;
    public double valor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFk_produto() {
        return fk_produto;
    }

    public void setFk_produto(int fk_produto) {
        this.fk_produto = fk_produto;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String nomeProduto(Produto produto){
        return produto.getNome();
     }
}
