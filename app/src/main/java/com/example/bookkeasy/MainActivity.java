package com.example.bookkeasy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button iniciar;
    TextView registrar,recuperar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ir a menu
        iniciar=(Button)findViewById(R.id.bin_iniciarss);
        iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Menu.class);
                startActivity(intent);
            }
        });


        //crear registrar
        registrar=(TextView)findViewById(R.id.bin_registrarr);
        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),registrar.class);
                startActivity(intent);
            }
        });
        //crear recuperar cuenta
        recuperar=(TextView)findViewById(R.id.bin_recuperar);
        recuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),recuperarcuenta.class);
                startActivity(intent);
            }
        });
    }
}
