package com.example.uesb_usr.cestabasicaapp.dominioapp.repositorio;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.example.uesb_usr.cestabasicaapp.dominioapp.entidades.User;

import java.util.List;

public class RepositorioUser {

    public SQLiteDatabase conexao;

    public RepositorioUser(SQLiteDatabase conexao) {
        this.conexao = conexao;
    }

    public void inserir(User user){
        ContentValues content = new ContentValues();
        content.put("NOME", user.getNome());
        content.put("EMAIL",user.getEmail());
        content.put("SENHA",user.getSenha());
        content.put("ESTADO",user.getEstado());
        content.put("CIDADE",user.getCidade());
    }

    public void editar(User user){

    }

    public List<User> listar(){         //pegar do WebService

        return null;
    }

    public User buscarUser(int id){
        return null;
    }
}
