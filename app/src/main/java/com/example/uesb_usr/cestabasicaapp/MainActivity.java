package com.example.uesb_usr.cestabasicaapp;

import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.uesb_usr.cestabasicaapp.bancosqlite.CestaOpenHelper;

public class MainActivity extends AppCompatActivity {

    private SQLiteDatabase conexao;                // banco sqlite
    private CestaOpenHelper cestaOpenHelper;        // dados do banco sqlite

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);     // associa a activity a um layout

        Button btnTelaAdicionar = findViewById(R.id.btn_tela_adicionar);    //botão de redirecionamento de create
        Button btnTelaListarPesquisas = findViewById(R.id.btn_listar_pesquisas); //botão de redirecionamento de list

        criarConexao();     //inicia a conexão com o banco sqlite

        btnTelaAdicionar.setOnClickListener(new View.OnClickListener() {    // classe para eventos no botão
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, NovaPesquisaActivity.class);

                startActivity(it);
            }
        });

        btnTelaListarPesquisas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Em Construção ", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void criarConexao() {
        try {
            cestaOpenHelper = new CestaOpenHelper(this);
            conexao = cestaOpenHelper.getWritableDatabase();    // utilizado para persistência dentro do banco - incluindo leitura

            Toast.makeText(getApplicationContext(), "Conexão bem sucedida ", Toast.LENGTH_SHORT).show();

        } catch (SQLException ex) {
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setTitle("Erro de conexão");
            dlg.setMessage(ex.getMessage());
            dlg.setNeutralButton("OK", null);
            dlg.show();
        }
    }
}
