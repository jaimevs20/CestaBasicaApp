package com.example.uesb_usr.cestabasicaapp.servicos;

import com.example.uesb_usr.cestabasicaapp.modelos.Pesquisa;
import com.example.uesb_usr.cestabasicaapp.modelos.Produto;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ProdutoService {
    String url = "http://172.29.34.33:8080/"; //Caminho do WebService

    @GET("WSCesta/webresources/pesquisa.produtos/buscar/{id}/")
    Call<Produto> buscar(@Path("id") int id);   //  pelo id

    @GET("WSCesta/webresources/pesquisa.produtos")     //todos
    Call<List<Produto>>listar();

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
