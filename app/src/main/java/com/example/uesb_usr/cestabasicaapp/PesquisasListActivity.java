package com.example.uesb_usr.cestabasicaapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.uesb_usr.cestabasicaapp.modelos.Pesquisa;
import com.example.uesb_usr.cestabasicaapp.servicos.PesquisaService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PesquisasListActivity extends AppCompatActivity {

    ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesquisas_list);
    }

    @Override
    protected void onStart() {
        super.onStart();
        final ListView lista = (ListView) findViewById(R.id.list_pesquisas);
        PesquisaService pesquisaService = PesquisaService.retrofit.create(PesquisaService.class);

        dialog = new ProgressDialog(PesquisasListActivity.this);
        dialog.setMessage("Carregando...");
        dialog.setCancelable(true);
        dialog.show();

        Call<List<Pesquisa>> call = pesquisaService.listar();

        call.enqueue(new Callback<List<Pesquisa>>() {
            @Override
            public void onResponse(Call<List<Pesquisa>> call, Response<List<Pesquisa>> response) {
                if(dialog.isShowing())
                    dialog.dismiss();
                final List<Pesquisa> listaPesquisas = response.body();

                if(listaPesquisas!=null){
                    PesquisaAdapter adapter = new PesquisaAdapter(getBaseContext(),listaPesquisas);
                    lista.setAdapter(adapter);
                    //lista.setOnItemClickListener();
                }
            }

            @Override
            public void onFailure(Call<List<Pesquisa>> call, Throwable t) {

            }
        });

    }
}
