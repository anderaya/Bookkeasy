package com.example.bookkeasy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class bloquearcuenta extends AppCompatActivity {

    //  bloquar cuenta
    ImageView regresar;
    Button confirmar;
    private MainActivity confi;
    private TextView barra;
    private String toll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bloquearcuenta);
        barra=findViewById(R.id.textView66);
        int dfecto= Color.argb(255,94,53,177);
        toll=confi.myPreferences.getString("color",dfecto+"");
        barra.setBackgroundColor(Integer.parseInt(toll));


        regresar=(ImageView) findViewById(R.id.bin_regresar);
        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        confirmar=(Button) findViewById(R.id.bin_iniciar8);
        confirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Intent intent = new Intent(getApplicationContext(),bloquearcuenta.class);
                startActivity(intent);
            }
        });
    }
}
