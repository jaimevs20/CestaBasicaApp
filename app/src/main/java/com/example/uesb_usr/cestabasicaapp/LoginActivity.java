package com.example.uesb_usr.cestabasicaapp;

import android.content.Intent;
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

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        Button btn_entrar = findViewById(R.id.btn_entrar);

        btn_entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent it = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(it);
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
