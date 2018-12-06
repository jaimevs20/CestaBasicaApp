package com.example.uesb_usr.cestabasicaapp.resources;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.uesb_usr.cestabasicaapp.modelos.User;
import com.example.uesb_usr.cestabasicaapp.servicos.UserService;
import com.example.uesb_usr.cestabasicaapp.util.UserDes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BuscarUsersAsync extends AsyncTask<Void, Void, Void> {

    private Context contexto;
    private static final String FLAG = "RETROFIT";


    public BuscarUsersAsync(Context contexto) {
        this.contexto = contexto;
    }

    @Override
    protected void onPreExecute() {

    }

    @Override
    protected Void doInBackground(Void... voids) {
        //TODO Consumir WebService
        String url = "http://172.29.34.33:8080/WSCesta/webresources/cestanet.users/"; //Caminho do WebService

        //objeto desserializável da classe User
        Gson conversor = new GsonBuilder().registerTypeAdapter(User.class, new UserDes()).create();

        Retrofit retrofit = new Retrofit.Builder().baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create(conversor)).build();

        UserService userService =  retrofit.create(UserService.class);     //Disponibilizando o método
        Call<List<User>> listaUser = userService.buscarTodos();         // Usando o método de listar todos os Usuários

        listaUser.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                List<User> user = response.body();

                for(User u : user){
                    Log.i(FLAG, u.getEmail());      // MOSTRAR REGISTRO NO LOGCAT
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
            }
        });

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
    }

}
