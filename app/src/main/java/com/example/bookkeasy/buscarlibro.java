package com.example.bookkeasy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class buscarlibro extends AppCompatActivity {
    Button buscarlibro;
    TextView avanzada;
    ImageView regresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscarlibro);

        buscarlibro=(Button) findViewById(R.id.id_buscarlibro);
        buscarlibro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),resultadosdelabusquedad.class);
                startActivity(intent);
            }
        });

        avanzada=(TextView)findViewById(R.id.bin_busquedaavanzada);
        avanzada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),busquedaavanzada.class);
                startActivity(intent);
            }
        });

        regresar=(ImageView) findViewById(R.id.imageView2);
        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Menu.class);
                startActivity(intent);
            }
        });
    }
}
