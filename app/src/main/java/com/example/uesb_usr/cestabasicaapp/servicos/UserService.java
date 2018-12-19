package com.example.uesb_usr.cestabasicaapp.servicos;

import com.example.uesb_usr.cestabasicaapp.modelos.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface UserService {

    String url = "http://172.29.34.33:8080/"; //Caminho do WebService
    //String url = "https://api.github.com/"; //Caminho do WebService
    @GET("WSCesta/webresources/pesquisa.users/buscar/{id}/")
    Call<User> buscar(@Path("id") int id);   // usuário pelo id

    @GET("WSCesta/webresources/pesquisa.users")     //todos usuários
    Call<List<User>>listar();

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
