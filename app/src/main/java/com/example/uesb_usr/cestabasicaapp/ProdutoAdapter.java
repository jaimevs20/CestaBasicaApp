package com.example.uesb_usr.cestabasicaapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.uesb_usr.cestabasicaapp.modelos.Pesquisa;
import com.example.uesb_usr.cestabasicaapp.modelos.Produto;

import java.util.List;

public class ProdutoAdapter extends ArrayAdapter<Produto> {
    private final Context context;
    private final List<Produto> produtos;

    public ProdutoAdapter(Context context, List<Produto> produtos) {
        super(context,R.layout.linha_produto,produtos);
        this.context = context;
        this.produtos = produtos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.linha, parent, false);
        TextView produtoId = rowView.findViewById(R.id.txtId);
        TextView produtoNome = rowView.findViewById(R.id.txt_prod_nome);
        TextView produtoClasse = rowView.findViewById(R.id.txt_prod_nome);
        TextView produtoItem = rowView.findViewById(R.id.txt_prod_nome);
        TextView produtoGrupo = rowView.findViewById(R.id.txt_prod_nome);

        produtoId.setText(produtos.get(position).getId());
        produtoNome.setText(produtos.get(position).getNome());
        produtoClasse.setText(produtos.get(position).getClasse());
        produtoItem.setText(produtos.get(position).getClasse());
        produtoGrupo.setText(produtos.get(position).getClasse());

        return rowView;
    }
}
