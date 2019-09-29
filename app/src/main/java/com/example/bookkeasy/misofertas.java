package com.example.bookkeasy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class misofertas extends AppCompatActivity {
    ImageView regresar,mapa;
    Button buscarlibro;
    private MainActivity confi;
    private TextView barra;
    private String toll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_misofertas);

        barra=findViewById(R.id.textView105);
        int dfecto= Color.argb(255,94,53,177);
        toll=confi.myPreferences.getString("color",dfecto+"");
        barra.setBackgroundColor(Integer.parseInt(toll));

        regresar=(ImageView) findViewById(R.id.imageView33);
        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        mapa=(ImageView) findViewById(R.id.imageView34);
        mapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(getApplicationContext(),MapsActivity2.class);
                //startActivity(intent);
            }
        });

        buscarlibro=(Button) findViewById(R.id.bin_iniciar11);
        buscarlibro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Intent intent = new Intent(getApplicationContext(),misofertas.class);
                startActivity(intent);
            }
        });
    }
}
