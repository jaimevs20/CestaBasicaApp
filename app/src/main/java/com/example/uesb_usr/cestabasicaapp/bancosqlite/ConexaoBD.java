package com.example.uesb_usr.cestabasicaapp.bancosqlite;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

public class ConexaoBD {
    public SQLiteDatabase conexao;                // banco sqlite
    public CestaOpenHelper cestaOpenHelper;        // dados do banco sqlite
    Context contexto;

    public ConexaoBD(Context contexto) {
        this.contexto = contexto;
    }

    private void criarConexao() {
        try {
            cestaOpenHelper = new CestaOpenHelper(this.contexto);
            conexao = cestaOpenHelper.getWritableDatabase();    // utilizado para persistência dentro do banco - incluindo leitura

            Toast.makeText(this.contexto.getApplicationContext(), "Conexão bem sucedida ", Toast.LENGTH_SHORT).show();

        } catch (SQLException ex) {
            AlertDialog.Builder dlg = new AlertDialog.Builder(this.contexto);
            dlg.setTitle("Erro de conexão");
            dlg.setMessage(ex.getMessage());
            dlg.setNeutralButton("OK", null);
            dlg.show();
        }
    }
}
