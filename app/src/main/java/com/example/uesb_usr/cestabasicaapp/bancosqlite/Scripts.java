package com.example.uesb_usr.cestabasicaapp.bancosqlite;

public class Scripts {
    public static String getCreateGrupoProduto() {
        StringBuilder sql = new StringBuilder();    // concatena o script sql

        sql.append("CREATE TABLE grupos (\n" +
                "    id     INTEGER       PRIMARY KEY,\n" +
                "    tipo   VARCHAR (255),\n" +
                "    status VARCHAR (255) \n" +
                ");\n");

        return sql.toString();
    }

    public static String getCreateClasseProduto() {
        StringBuilder sql = new StringBuilder();    // concatena o script sql

        sql.append("CREATE TABLE classes (\n" +
                "    id     INTEGER       PRIMARY KEY AUTOINCREMENT,\n" +
                "    tipo   VARCHAR (255),\n" +
                "    status VARCHAR (255) \n" +
                ");");

        return sql.toString();
    }

    public static String getCreateItemProduto() {
        StringBuilder sql = new StringBuilder();    // concatena o script sql

        sql.append("CREATE TABLE itens (\n" +
                "    id             INTEGER       PRIMARY KEY AUTOINCREMENT,\n" +
                "    tipo           VARCHAR (255),\n" +
                "    unidade_medida VARCHAR (255),\n" +
                "    status         VARCHAR (255) \n" +
                ");");

        return sql.toString();
    }

    public static String getCreateProduto() {
        StringBuilder sql = new StringBuilder();    // concatena o script sql

        sql.append("CREATE TABLE produtos (\n" +
                "    id                INTEGER       PRIMARY KEY AUTOINCREMENT,\n" +
                "    fk_grupo          INTEGER       REFERENCES grupos (id) \n" +
                "                                    NOT NULL,\n" +
                "    fk_classe_produto INTEGER       REFERENCES classes (id) \n" +
                "                                    NOT NULL,\n" +
                "    fk_item           INTEGER       REFERENCES itens (id) \n" +
                "                                    NOT NULL,\n" +
                "    nome              VARCHAR (255),\n" +
                "    sazonal           BOOLEAN,\n" +
                "    descricao         TEXT,\n" +
                "    marca             VARCHAR (255) \n" +
                ");\n");

        return sql.toString();
    }

    public static String getCreatePesquisaProduto() {
        StringBuilder sql = new StringBuilder();    // concatena o script sql

        sql.append("CREATE TABLE pesquisa_produtos (\n" +
                "    id          INTEGER       PRIMARY KEY AUTOINCREMENT,\n" +
                "    nome_produto  STRING,\n" +
                "    valor       DOUBLE,\n" +
                "    data        STRING,\n" +
                "    ocorrencia  VARCHAR (255),\n" +
                "    promocao    BOOLEAN,\n" +
                "    observacoes TEXT\n" +
                ");");

        return sql.toString();
    }

    public static String getCreateUser() {
        StringBuilder sql = new StringBuilder();    // concatena o script sql

        sql.append("CREATE TABLE user (\n" +
                "    id          INTEGER       PRIMARY KEY AUTOINCREMENT,\n" +
                "    nome  VARCHAR (255),\n" +
                "    email  VARCHAR (255),\n" +
                "    senha  VARCHAR (255),\n" +
                "    estado  VARCHAR (255),\n" +
                "    cidade  VARCHAR (255),\n" +
                ");");

        return sql.toString();
    }
}
