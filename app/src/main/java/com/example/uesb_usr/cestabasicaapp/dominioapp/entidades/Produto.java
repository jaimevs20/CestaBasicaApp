package com.example.uesb_usr.cestabasicaapp.dominioapp.entidades;

public class Produto {
    Grupo grupo;
    Classe classe;
    Item item;
    int id, fk_grupo, fk_classe_produto, fk_item;
    String nome, descricao, marca;
    boolean sazonal;

    public Produto(Grupo grupo, Classe classe, Item item, int id, int fk_grupo, int fk_classe_produto, int fk_item, String nome,
                   String descricao, String marca, boolean sazonal) {

        this.grupo = grupo;
        this.classe = classe;
        this.item = item;
        this.id = id;
        this.fk_grupo = fk_grupo;
        this.fk_classe_produto = fk_classe_produto;
        this.fk_item = fk_item;
        this.nome = nome;
        this.descricao = descricao;
        this.marca = marca;
        this.sazonal = sazonal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFk_grupo() {
        return fk_grupo;
    }

    public void setFk_grupo(Grupo grupo) {
        this.fk_grupo = grupo.getId();
    }

    public int getFk_classe_produto() {
        return fk_classe_produto;
    }

    public void setFk_classe_produto(Classe classe) {
        this.fk_classe_produto = classe.getId();
    }

    public int getFk_item() {
        return fk_item;
    }

    public void setFk_item(Item item) {
        this.fk_item = item.getId();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public boolean isSazonal() {
        return sazonal;
    }

    public void setSazonal(boolean sazonal) {
        this.sazonal = sazonal;
    }
}
