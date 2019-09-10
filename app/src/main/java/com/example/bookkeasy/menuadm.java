package com.example.bookkeasy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class menuadm extends AppCompatActivity {
        TextView bloquear,consultar,estadisticas,cerrarsesion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuadm);

        bloquear=(TextView)findViewById(R.id.bin_bloquearcuenta);
        bloquear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),bloquearcuenta.class);
                startActivity(intent);
            }
        });

        consultar=(TextView)findViewById(R.id.bin_consultar);
        consultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),consultar.class);
                startActivity(intent);
            }
        });

        estadisticas=(TextView)findViewById(R.id.bin_verestadisticas);
        estadisticas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),verestadisticas.class);
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
