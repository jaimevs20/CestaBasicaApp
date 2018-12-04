package com.example.uesb_usr.cestabasicaapp.dominioapp.repositorio;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.uesb_usr.cestabasicaapp.bancosqlite.Scripts;
import com.example.uesb_usr.cestabasicaapp.dominioapp.entidades.Pesquisa;
import com.example.uesb_usr.cestabasicaapp.dominioapp.entidades.User;

import java.util.ArrayList;
import java.util.List;

public class RepositorioPesquisa {

    public SQLiteDatabase conexao;

    public RepositorioPesquisa(SQLiteDatabase conexao) {
        this.conexao = conexao;
    }

    public void inserir(Pesquisa pesquisa){
        ContentValues content = new ContentValues();
        content.put("NOME_PRODUTO", pesquisa.getNome_produto() );
        content.put("VALOR",pesquisa.getValor());
        content.put("DATA",pesquisa.getData());
        content.put("OCORRENCIA",pesquisa.getOcorrencia());
        content.put("PROMOCAO",pesquisa.isPromocao());
        content.put("OBSERVACOES",pesquisa.getObservacoes());

        conexao.insertOrThrow("PESQUISA_PRODUTOS", null, content);     // insere e gera exceção
    }

    public void editar(Pesquisa pesquisa){
        ContentValues content = new ContentValues();
        content.put("VALOR",pesquisa.getValor());
        content.put("OCORRENCIA",pesquisa.getOcorrencia());
        content.put("PROMOCAO",pesquisa.isPromocao());
        content.put("OBSERVACOES",pesquisa.getObservacoes());

        String [] par = new String[1];
        par[0] = String.valueOf(pesquisa.getId());

        conexao.update("PESQUISA_PRODUTOS", content, "ID = ?", par);
    }

    public void excluir(int id){
        String [] par = new String[1];
        par[0] = String.valueOf(id);

        conexao.delete("PESQUISA_PRODUTOS","ID = ?", par);
    }

    public List<Pesquisa> listar(){
        List<Pesquisa> pesquisas = new ArrayList<Pesquisa>();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ID, VALOR, DATA, OCORRENCIA, OBSERVACOES FROM PESQUISA_PRODUTOS");

        Cursor resultado = conexao.rawQuery(sql.toString(),null);  // retorna os registros

        if (resultado.getCount()>0){

            resultado.moveToFirst();    // pega todos os registros do início

            do{                 // percorre os registros
                Pesquisa pesq = new Pesquisa();

                pesq.setId(resultado.getInt(resultado.getColumnIndexOrThrow("ID"))) ;
                //pesq.setFk_produto(resultado.getInt(resultado.getColumnIndexOrThrow("FK_PRODUTO"))); ;
                pesq.setValor(resultado.getDouble(resultado.getColumnIndexOrThrow("ID"))); ;
                pesq.setData(resultado.getString(resultado.getColumnIndexOrThrow("ID"))); ;
                pesq.setOcorrencia(resultado.getString(resultado.getColumnIndexOrThrow("ID"))); ;
                pesq.setObservacoes(resultado.getString(resultado.getColumnIndexOrThrow("ID"))); ;

                pesquisas.add(pesq);

            }while (resultado.moveToNext());       //  enquanto houver
        }

        return pesquisas;
    }

    public Pesquisa buscarPesquisa(int id){
        Pesquisa pesquisa = new Pesquisa();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ID, VALOR, DATA, OCORRENCIA, OBSERVACOES FROM PESQUISA_PRODUTOS" +
                "WHERE ID = ?");

        String [] par = new String[1];
        par[0] = String.valueOf(pesquisa.getId());

        Cursor resultado = conexao.rawQuery(sql.toString(),par);  // retorna os registros

        if (resultado.getCount()>0) {

            resultado.moveToFirst();    // pega todos os registros do início

            pesquisa.setId(resultado.getInt(resultado.getColumnIndexOrThrow("ID"))) ;
            //pesq.setFk_produto(resultado.getInt(resultado.getColumnIndexOrThrow("FK_PRODUTO"))); ;
            pesquisa.setValor(resultado.getDouble(resultado.getColumnIndexOrThrow("VALOR"))); ;
            pesquisa.setData(resultado.getString(resultado.getColumnIndexOrThrow("DATA"))); ;
            pesquisa.setOcorrencia(resultado.getString(resultado.getColumnIndexOrThrow("OCORRENCIA"))); ;
            pesquisa.setObservacoes(resultado.getString(resultado.getColumnIndexOrThrow("OBSERVACOES"))); ;

            return pesquisa;
        }
        else
            return null;
    }
}
