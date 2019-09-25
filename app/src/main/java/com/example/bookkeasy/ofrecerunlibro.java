package com.example.bookkeasy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ofrecerunlibro extends AppCompatActivity {

    ImageView regresar;
    Button buscarlibro,mapa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ofrecerunlibro);

        regresar=(ImageView) findViewById(R.id.imageView28);
        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        mapa=(Button) findViewById(R.id.button);
        mapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //añadir una imagen del libro
            }
        });

        buscarlibro=(Button) findViewById(R.id.bin_iniciar122);
        buscarlibro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Intent intent = new Intent(getApplicationContext(),ofrecerunlibro.class);
                startActivity(intent);
            }
        });
    }
}
