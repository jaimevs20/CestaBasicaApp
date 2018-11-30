package com.example.uesb_usr.cestabasicaapp.bancosqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CestaOpenHelper extends SQLiteOpenHelper {

    public CestaOpenHelper(Context context) {
        super(context, "cesta", null, 1);
    }

    @Override   // cria as tabelas no Banco interno
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Scripts.getCreateGrupoProduto());
        db.execSQL(Scripts.getCreateClasseProduto());
        db.execSQL(Scripts.getCreateItemProduto());
        db.execSQL(Scripts.getCreateProduto());
        db.execSQL(Scripts.getCreatePesquisaProduto());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        switch (oldVersion) {
            case 1:
                //lógica de atualização da v1 para v2
            case 2:
                //lógica de atualização da v2 para v3
            case 3:
                //lógica de atualização da v3 para v4
                break;
            default:
                throw new IllegalStateException(
                        "onUpgrade() em oldVersion desconhecida " + oldVersion);
        }
    }
}
