package com.example.bookkeasy;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;

public class resultadosdelabusquedad extends AppCompatActivity {

    ImageView regresar,mapa;
    Button buscarlibro;
    TextView detalles;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultadosdelabusquedad);

    //verificar si es usuario o administrador

        regresar=(ImageView) findViewById(R.id.imageView19);
        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),buscarlibro.class);
                startActivity(intent);
            }
        });
        mapa=(ImageView) findViewById(R.id.imageView28);
        mapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MapsActivity2.class);
                startActivity(intent);
            }
        });

        buscarlibro=(Button) findViewById(R.id.bin_iniciar9);
        buscarlibro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),resultadosdelabusquedad.class);
                startActivity(intent);
            }
        });

        detalles=(TextView) findViewById(R.id.bin_libro);
        detalles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),verdetalles.class);
                startActivity(intent);
            }
        });
    }
}
