package com.example.uesb_usr.cestabasicaapp.servicos;

import com.example.uesb_usr.cestabasicaapp.modelos.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface UserService {
    @GET("findAll")
    public Call<List<User>> buscarTodos();

    @GET("find/{id}")
    public Call<User> buscar(@Path("id") int id);
}
