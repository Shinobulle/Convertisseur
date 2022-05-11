package com.example.convertiseur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.convertiseur.metier.Convert;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chargerSpinner(R.id.spinner);
        chargerSpinner(R.id.spinner2);


    }

    public void convertir_Somme(View v){
        EditText convert = (EditText) findViewById(R.id.editTextNumber) ;
        String chiffre = convert.getText().toString();
        Spinner deviseDep = (Spinner) findViewById(R.id.spinner);
        String deviseDep2 = deviseDep.getSelectedItem().toString();
        Spinner deviseAr = (Spinner) findViewById(R.id.spinner2);
        String deviseAr2 = deviseAr.getSelectedItem().toString();
        if (chiffre.equals("")){
            Log.d("MainActivity", "Pas de nombre !");
            Toast.makeText(getBaseContext(), "C'est pas bon pour le chiffre!",
                    Toast.LENGTH_LONG).show();
        }else if(chiffre.equals(".")){
            Log.d("MainActivity", "Ce n'est pas un chiffre !");
            Toast.makeText(getBaseContext(), "Ce n'est pas un chiffre!",
                    Toast.LENGTH_LONG).show();
        } else if (deviseDep2.equals("")){
            Log.d("MainActivity", "Pas de devise de départ !");
            Toast.makeText(getBaseContext(), "C'est pas bon pour la devise de départ !",
                    Toast.LENGTH_LONG).show();
        }else if (deviseAr2.equals("")){
            Log.d("MainActivity", "Pas de devise d'arrivée !");
            Toast.makeText(getBaseContext(), "C'est pas bon pour la devise d'arrivée !",
                    Toast.LENGTH_LONG).show();
        }else if (deviseDep2.equals(deviseAr2)){
            Log.d("MainActivity", "C'est la même devise");
            Toast.makeText(getBaseContext(), "C'est la même devise",
                    Toast.LENGTH_LONG).show();
        }
        else{
            Double chiffre2 = Double.parseDouble(chiffre);
             Convert test = new Convert();
             Double test2 = test.convertir(deviseDep2, deviseAr2, chiffre2);
             String resultat = String.valueOf(test2);
            Log.d("MainActivity", "Le résultat est arrivé !");
            Toast.makeText(getBaseContext(), resultat,
                    Toast.LENGTH_LONG).show();
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