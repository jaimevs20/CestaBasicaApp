package com.example.uesb_usr.cestabasicaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class NovaPesquisaActivity extends AppCompatActivity {

    boolean promo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nova_pesquisa);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //seta para voltar à MainActivity

        Button btnEnviarPesquisa = findViewById(R.id.btn_enviar_pesquisa);     //botão de envio das informações ao banco

        final EditText nomeProduto = findViewById(R.id.nome_produto);         //texto do NOME do produto
        final EditText valorProduto = findViewById(R.id.valor_produto);       //texto do VALOR do produto
        final EditText data = findViewById(R.id.data);                        //texto da DATA do produto
        EditText observacao = findViewById(R.id.observacao);            //texto da OBSERVAÇÃO do produto
        EditText ocorrencia = findViewById(R.id.ocorrencia);            //texto da OCORRÊNCIA do produto

        final Switch promocao = findViewById(R.id.promocao);

        promocao.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(promocao.isChecked()){
                    Toast.makeText(getApplicationContext(), "Produto em Promoção", Toast.LENGTH_SHORT).show();
                    promo = true;
                }
                else {
                    Toast.makeText(getApplicationContext(), "Sem Promoção", Toast.LENGTH_SHORT).show();
                    promo = false;
                }
            }
        });

        /*
        if(promocao.isChecked()){
            Toast.makeText(getApplicationContext(), "Produto em Promoção", Toast.LENGTH_SHORT).show();
            promo = true;
        }*/

        btnEnviarPesquisa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isEmpty(nomeProduto) || isEmpty(valorProduto) || isEmpty(data))
                    Toast.makeText(getApplicationContext(), "Preencha todas as informações", Toast.LENGTH_SHORT).show();

                else{

                    Intent it = new Intent(NovaPesquisaActivity.this, MainActivity.class);  // Fecha
                    startActivity(it);                                                                    //    a página de cadastro

                    Toast.makeText(getApplicationContext(), "Informações enviadas com sucesso! ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public boolean isEmpty(EditText campo){
        if(campo.getText().toString().equals("") || campo.getText().toString().matches(" "))
            return true;
        else
            return false;
    }

    //Insert
    public void Create()
    {

    }
}
