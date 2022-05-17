package com.example.convertiseur.outils;

import android.content.Context;
import android.widget.Toast;

public class Outils{

    public static void toastShort(Context context, String message){
        Toast.makeText(context, message,
                    Toast.LENGTH_SHORT).show();
    }
    public static void toastLong(Context context, String message){
        Toast.makeText(context, message,
                Toast.LENGTH_LONG).show();
    }

}
