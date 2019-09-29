package com.example.bookkeasy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class consultar extends AppCompatActivity {
    ImageView regresar;
    Button buscarlibro;

    private MainActivity confi;
    private TextView barra;
    private String toll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar);

        barra=findViewById(R.id.textView77);
        int dfecto= Color.argb(255,94,53,177);
        toll=confi.myPreferences.getString("color",dfecto+"");
        barra.setBackgroundColor(Integer.parseInt(toll));

        regresar=(ImageView) findViewById(R.id.imageView20);
        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
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
    }
}
