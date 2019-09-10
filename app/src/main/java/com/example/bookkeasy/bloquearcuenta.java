package com.example.bookkeasy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class bloquearcuenta extends AppCompatActivity {

    ImageView regresar;
    Button confirmar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bloquearcuenta);

        regresar=(ImageView) findViewById(R.id.bin_regresar);
        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),menuadm.class);
                startActivity(intent);
            }
        });

        confirmar=(Button) findViewById(R.id.bin_iniciar8);
        confirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),bloquearcuenta.class);
                startActivity(intent);
            }
        });
    }
}
