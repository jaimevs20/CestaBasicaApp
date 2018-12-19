package com.example.uesb_usr.cestabasicaapp.servicos;

import com.example.uesb_usr.cestabasicaapp.modelos.Pesquisa;
import com.example.uesb_usr.cestabasicaapp.modelos.Produto;
import com.example.uesb_usr.cestabasicaapp.modelos.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface PesquisaService {
    String url = "http://172.29.34.33:8080/"; //Caminho do WebService

    @POST("WSCesta/webresources/pesquisa.pesquisaprodutos/inserir")
    Call<Void>inserePesquisa(@Body Produto produto);

    @GET("WSCesta/webresources/pesquisa.pesquisaprodutos/buscar/{id}/")
    Call<Pesquisa> buscar(@Path("id") int id);   //  pelo id

    @GET("WSCesta/webresources/pesquisa.pesquisaprodutos")     //todos
    Call<List<Pesquisa>>listar();

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
