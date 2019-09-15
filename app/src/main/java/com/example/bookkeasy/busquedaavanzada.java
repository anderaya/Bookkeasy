package com.example.bookkeasy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class busquedaavanzada extends AppCompatActivity {
    ImageView regresar;
    Button buscarlibro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busquedaavanzada);

        regresar=(ImageView) findViewById(R.id.imageView14);
        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),buscarlibro.class);
                startActivity(intent);
            }
        });

        buscarlibro=(Button) findViewById(R.id.bin_iniciar44);
        buscarlibro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),resultadosdelabusquedad.class);
                startActivity(intent);
            }
        });
    }
}
