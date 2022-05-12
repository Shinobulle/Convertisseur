package com.example.convertiseur;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.convertiseur.metier.Convert;

import java.text.DecimalFormat;

public class resultat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_resultat);

        Intent thisIntent = getIntent();
        String devisedep = thisIntent.getExtras().getString("devisedep");
        String devisear = thisIntent.getExtras().getString("devisear");
        Double montant = thisIntent.getExtras().getDouble("montant");
        String resultat = retoursomme(devisedep, devisear, montant);
        Intent rep = new Intent();
        rep.putExtra("repResult", resultat);
        setResult(1, rep);
        finish();
    }

    public String retoursomme(String devisedep, String devisear, Double montant){
        Double convertion = Convert.convertir(devisedep, devisear, montant);
        DecimalFormat df = new DecimalFormat("0.00");
        String strmontant = df.format(convertion);
        String msg= "Le montant de "+ montant +" au départ en "+ devisedep +" vaut en "+devisear+" "+strmontant;
        return msg;
    }


}
