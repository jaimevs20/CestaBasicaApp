package com.example.uesb_usr.cestabasicaapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.uesb_usr.cestabasicaapp.modelos.Pesquisa;
import com.example.uesb_usr.cestabasicaapp.modelos.Produto;
import com.example.uesb_usr.cestabasicaapp.servicos.PesquisaService;
import com.example.uesb_usr.cestabasicaapp.servicos.ProdutoService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProdutoListActivity extends AppCompatActivity {

    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produto_list);
    }

    @Override
    protected void onStart() {
        super.onStart();
        final ListView lista = (ListView) findViewById(R.id.list_produtos);
        ProdutoService produtoService = PesquisaService.retrofit.create(ProdutoService.class);

        dialog = new ProgressDialog(ProdutoListActivity.this);
        dialog.setMessage("Carregando...");
        dialog.setCancelable(false);
        dialog.show();

        Call<List<Produto>> call = produtoService.listar();

        call.enqueue(new Callback<List<Produto>>() {
            @Override
            public void onResponse(Call<List<Produto>> call, Response<List<Produto>> response) {
                if(dialog.isShowing())
                    dialog.dismiss();
                final List<Produto> listaProdutos = response.body();

                if(listaProdutos!=null){
                    ProdutoAdapter adapter = new ProdutoAdapter(getBaseContext(),listaProdutos);
                    lista.setAdapter(adapter);


                }
            }

            @Override
            public void onFailure(Call<List<Produto>> call, Throwable t) {

            }
        });
    }
}
