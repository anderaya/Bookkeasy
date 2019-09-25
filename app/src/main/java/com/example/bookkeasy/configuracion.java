package com.example.bookkeasy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;

import java.util.Random;

public class configuracion extends AppCompatActivity {
    ImageView regresar;
    Button buscarlibro,correo,cuenta,colorr;
    Switch sonido;

    public SharedPreferences myPreferences = PreferenceManager.getDefaultSharedPreferences(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);

        regresar=(ImageView) findViewById(R.id.bin_regresarr);
        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        buscarlibro=(Button) findViewById(R.id.button5);
        buscarlibro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Cambiarcontrasena.class);
                startActivity(intent);
            }
        });

        correo=(Button) findViewById(R.id.button6);
        correo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),cambiarcorreo.class);
                startActivity(intent);
            }
        });

        cuenta=(Button) findViewById(R.id.button8);
        cuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Eliminarcuenta.class);
                startActivity(intent);
            }
        });

        colorr=(Button) findViewById(R.id.button);
        colorr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random=new Random();
                int color= Color.argb(255,random.nextInt(256),random.nextInt(256),random.nextInt(256));
                 colorr.setBackgroundColor(color);
            }
        });
        sonido=(Switch) findViewById(R.id.switch1);
        sonido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //// acceder al sonidooooooooooooo

            if (Switch.AUTOFILL_TYPE_TOGGLE==0) {
                myPreferences.edit().remove("Sonido");
                myPreferences.edit().putInt("Sonido", 1);
            }

            }
        });
    }
}
