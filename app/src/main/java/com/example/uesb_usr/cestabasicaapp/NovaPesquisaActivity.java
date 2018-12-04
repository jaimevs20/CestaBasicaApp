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

import com.example.uesb_usr.cestabasicaapp.bancosqlite.CestaOpenHelper;
import com.example.uesb_usr.cestabasicaapp.bancosqlite.ConexaoBD;
import com.example.uesb_usr.cestabasicaapp.dominioapp.entidades.Pesquisa;
import com.example.uesb_usr.cestabasicaapp.dominioapp.repositorio.RepositorioPesquisa;

public class NovaPesquisaActivity extends AppCompatActivity {

    private SQLiteDatabase conexao;                // banco sqlite
    private CestaOpenHelper cestaOpenHelper;        // dados do banco sqlite
    private Pesquisa pesquisa;
    boolean promo;
    EditText nomeProduto;
    EditText valorProduto;
    EditText data;
    EditText observacao;
    EditText ocorrencia;
    private Button btnEnviarPesquisa;
    private Switch promocao;

    private RepositorioPesquisa pesquisaR;

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

        criarConexao();     // inicia conexão com o banco interno

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
                if (validacao() == false)        // valida os campos
                    Toast.makeText(getApplicationContext(), "Preencha todas as informações", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(), "foi.", Toast.LENGTH_SHORT).show();
                    //envia();
            }
        });
    }

    private void criarConexao() {
        try {
            cestaOpenHelper = new CestaOpenHelper(this);
            conexao = cestaOpenHelper.getWritableDatabase();    // utilizado para persistência dentro do banco - incluindo leitura

            Toast.makeText(getApplicationContext(), "Conexão bem sucedida - Nova Pesquisa ", Toast.LENGTH_SHORT).show();

            pesquisaR = new RepositorioPesquisa(conexao);

        } catch (SQLException ex) {
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setTitle("Erro de conexão");
            dlg.setMessage(ex.getMessage());
            dlg.setNeutralButton("OK", null);
            dlg.show();
        }
    }

    public boolean isEmpty(EditText campo) {
        if (campo.getText().toString().equals("") || campo.getText().toString().matches(" "))
            return true;
        else
            return false;
    }

    public boolean validacao() {

        String nome_produto = nomeProduto.getText().toString();
        pesquisa.setNome_produto(nome_produto);

        Double valor = Double.parseDouble(valorProduto.getText().toString());
        pesquisa.setValor(valor);

        String date = data.getText().toString();
        pesquisa.setData(date);

        String ocor = ocorrencia.getText().toString();
        pesquisa.setOcorrencia(ocor);

        pesquisa.setPromocao(promo);

        String obs = observacao.getText().toString();
        pesquisa.setObservacoes(obs);

        if (isEmpty(valorProduto) || isEmpty(data))
            return false;
        else
            return true;
    }

    public void envia() {
        pesquisa = new Pesquisa();
        try {
            pesquisaR.inserir(pesquisa);
            finish();
            /*Intent it = new Intent(NovaPesquisaActivity.this, MainActivity.class);  // Fecha
            startActivity(it);                                                                    //    a página de cadastro

            Toast.makeText(getApplicationContext(), "Informações enviadas com sucesso! ", Toast.LENGTH_SHORT).show();*/
        } catch (SQLException ex) {
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setTitle("Erro de conexão");
            dlg.setMessage(ex.getMessage());
            dlg.setNeutralButton("OK", null);
            dlg.show();
        }
    }
}
