package com.example.uesb_usr.cestabasicaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnTelaAdicionar = findViewById(R.id.btn_tela_adicionar);    //botão de redirecionamento de create
        Button btnTelaListarPesquisas = findViewById(R.id.btn_listar_pesquisas); //botão de redirecionamento de list


        btnTelaAdicionar.setOnClickListener(new View.OnClickListener() {
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
}
