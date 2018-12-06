package com.example.uesb_usr.cestabasicaapp;

import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class NovaPesquisaActivity extends AppCompatActivity {

    private SQLiteDatabase conexao;                // banco sqlite
    boolean promo;
    EditText nomeProduto;
    EditText valorProduto;
    EditText data;
    EditText observacao;
    EditText ocorrencia;
    private Button btnEnviarPesquisa;
    private Switch promocao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nova_pesquisa);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //seta para voltar à MainActivity

        btnEnviarPesquisa = findViewById(R.id.btn_enviar_pesquisa);     //botão de envio das informações ao banco
        nomeProduto = findViewById(R.id.nome_produto);                  //texto do NOME do produto
        valorProduto = findViewById(R.id.valor_produto);                //texto do VALOR do produto
        data = findViewById(R.id.data);                                 //texto da DATA do produto
        observacao = findViewById(R.id.observacao);                     //texto da OBSERVAÇÃO do produto
        ocorrencia = findViewById(R.id.ocorrencia);                     //texto da OCORRÊNCIA do produto
        promocao = findViewById(R.id.promocao);

        promocao.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (promocao.isChecked()) {
                    Toast.makeText(getApplicationContext(), "Produto em Promoção", Toast.LENGTH_SHORT).show();
                    promo = true;
                } else {
                    Toast.makeText(getApplicationContext(), "Sem Promoção", Toast.LENGTH_SHORT).show();
                    promo = false;
                }
            }
        });

      /*  if (promocao.isChecked()) {
            Toast.makeText(getApplicationContext(), "Produto em Promoção", Toast.LENGTH_SHORT).show();
            promo = true;
        }*/

        btnEnviarPesquisa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isEmpty(valorProduto) || isEmpty(data))     // valida os campos
                    Toast.makeText(getApplicationContext(), "Preencha todas as informações", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(), "foi.", Toast.LENGTH_SHORT).show();
                //envia();
            }
        });
    }

    public boolean isEmpty(EditText campo) {
        if (campo.getText().toString().equals("") || campo.getText().toString().matches(" "))
            return true;
        else
            return false;
    }


}
