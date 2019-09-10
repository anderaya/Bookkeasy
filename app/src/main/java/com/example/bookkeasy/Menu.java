package com.example.bookkeasy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;



public class Menu extends AppCompatActivity {
   TextView buscarlibro,ofrecer,misofertas,mislibros,configruacion,cerrarsesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        buscarlibro=(TextView)findViewById(R.id.bin_registrarr);
        buscarlibro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),buscarlibro.class);
                startActivity(intent);
            }
        });

        ofrecer=(TextView)findViewById(R.id.bin_ofrecerlibro);
        ofrecer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ofrecerunlibro.class);
                startActivity(intent);
            }
        });

        misofertas=(TextView)findViewById(R.id.bin_misofertas);
        misofertas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),misofertas.class);
                startActivity(intent);
            }
        });

        mislibros=(TextView)findViewById(R.id.bin_mislibrosguardados);
        mislibros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),mislibrosguardados.class);
                startActivity(intent);
            }
        });

        configruacion=(TextView)findViewById(R.id.bin_configuracion);
        configruacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),configuracion.class);
                startActivity(intent);
            }
        });

        cerrarsesion=(TextView)findViewById(R.id.bin_cerrarsesion);
        cerrarsesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
