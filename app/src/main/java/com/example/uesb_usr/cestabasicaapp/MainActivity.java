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

import com.example.uesb_usr.cestabasicaapp.modelos.User;
import com.example.uesb_usr.cestabasicaapp.servicos.UserService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    private Button btnTelaAdicionar;
    private Button btnTelaListarPesquisas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);     // associa a activity a um layout

        btnTelaAdicionar = findViewById(R.id.btn_tela_adicionar);    //botão de redirecionamento de create
        btnTelaListarPesquisas = findViewById(R.id.btn_listar_pesquisas); //botão de redirecionamento de list

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
                UserService userService = UserService.retrofit.create(UserService.class);
                final Call<User> call = userService.buscar(1);
                call.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        int cod = response.code();
                        if (cod == 200) {
                            User user = response.body();
                            Toast.makeText(getBaseContext(), "Nome: " + user.name, Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(getBaseContext(), "Erro: " + String.valueOf(cod), Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {

                    }
                });
            }
        });
    }

}
