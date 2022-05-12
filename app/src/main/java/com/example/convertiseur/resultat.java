package com.example.convertiseur;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.convertiseur.metier.Convert;

public class resultat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultat);

        Intent thisIntent = getIntent();
        String devisedep = thisIntent.getExtras().getString("devisedep");
        String devisear = thisIntent.getExtras().getString("devisear");
        Double montant = thisIntent.getExtras().getDouble("montant");
        retoursomme(R.id.textView4, devisedep, devisear, montant);
    }

    public void retoursomme(int idViewText, String devisedep, String devisear, Double montant){
        TextView resultat = (TextView) findViewById(idViewText);
        Double convertion = Convert.convertir(devisedep, devisear, montant);
        String msg= "Le montant de "+ montant +" au départ en "+ devisedep +" vaut en "+devisear+" "+convertion;
        resultat.setText(msg);
    }

    public void fini(View v){
        finish();
    }
}
