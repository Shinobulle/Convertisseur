package com.example.convertiseur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.convertiseur.metier.Convert;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chargerSpinner(R.id.spinner);
        chargerSpinner(R.id.spinner2);


    }



    public void convertir_Somme(View v){
        String convert = ((EditText) findViewById(R.id.editTextNumber)).getText().toString() ;
        String deviseDep = ((Spinner) findViewById(R.id.spinner)).getSelectedItem().toString();
        String deviseAr = ((Spinner) findViewById(R.id.spinner2)).getSelectedItem().toString();
        if (convert.equals("")){
            Log.d("MainActivity", "Pas de nombre !");
            Toast.makeText(getBaseContext(), "C'est pas bon pour le chiffre!",
                    Toast.LENGTH_LONG).show();
        }else if(convert.equals(".")){
            Log.d("MainActivity", "Ce n'est pas un chiffre !");
            Toast.makeText(getBaseContext(), "Ce n'est pas un chiffre!",
                    Toast.LENGTH_LONG).show();
        } else if (deviseDep.equals("")){
            Log.d("MainActivity", "Pas de devise de départ !");
            Toast.makeText(getBaseContext(), "C'est pas bon pour la devise de départ !",
                    Toast.LENGTH_LONG).show();
        }else if (deviseAr.equals("")){
            Log.d("MainActivity", "Pas de devise d'arrivée !");
            Toast.makeText(getBaseContext(), "C'est pas bon pour la devise d'arrivée !",
                    Toast.LENGTH_LONG).show();
        }else if (deviseDep.equals(deviseAr)){
            Log.d("MainActivity", "C'est la même devise");
            Toast.makeText(getBaseContext(), "C'est la même devise",
                    Toast.LENGTH_LONG).show();
        }
        else{
            Double chiffre = Double.parseDouble(convert);
             Intent resultat = new Intent(this, resultat.class);
             resultat.putExtra("devisedep", deviseDep);
             resultat.putExtra("devisear",deviseAr);
             resultat.putExtra("montant",chiffre);
             startActivity(resultat);

        }
    }

    public void quitter(View v){
        Log.d("MainActivity", "quitter");
        Toast.makeText(getBaseContext(), "Je te quitte !",
                Toast.LENGTH_LONG).show();
        finishAffinity();
        System.exit(0);
    }

    public ArrayList <String> chargeDevises(){
        ArrayList <String> liste_de_string = new ArrayList <String> (Convert.getConversionTable().keySet());
        liste_de_string.add("");
        Collections.sort(liste_de_string);
        return liste_de_string;
    }

    public Spinner chargerSpinner(int idView){
        final Spinner spinner = (Spinner) findViewById(idView);
        final ArrayList <String> liste_de_string = chargeDevises();
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_checked, liste_de_string);
        spinner.setAdapter(adapter);
        return spinner;
    }
}