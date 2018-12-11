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

public class PesquisaAdapter extends ArrayAdapter<Pesquisa> {
    private final Context context;
    private final List<Pesquisa> pesquisas;
    Produto produto;

    public PesquisaAdapter(Context context, int resource, Context context1, List<Pesquisa> pesquisas) {
        super(context, resource);
        this.context = context1;
        this.pesquisas = pesquisas;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.linha, parent, false);
        TextView id = rowView.findViewById(R.id.txtId);
        TextView produtoNome = rowView.findViewById(R.id.txt_prod_nome);

        id.setText(pesquisas.get(position).getId());
        produtoNome.setText(pesquisas.get(position).nomeProduto(produto));

        return rowView;
    }
}
