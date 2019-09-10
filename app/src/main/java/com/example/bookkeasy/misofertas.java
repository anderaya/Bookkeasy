package com.example.bookkeasy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class misofertas extends AppCompatActivity {
    ImageView regresar,mapa;
    Button buscarlibro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_misofertas);

        regresar=(ImageView) findViewById(R.id.imageView33);
        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Menu.class);
                startActivity(intent);
            }
        });
        mapa=(ImageView) findViewById(R.id.imageView34);
        mapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MapsActivity2.class);
                startActivity(intent);
            }
        });

        buscarlibro=(Button) findViewById(R.id.bin_iniciar11);
        buscarlibro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),misofertas.class);
                startActivity(intent);
            }
        });
    }
}
