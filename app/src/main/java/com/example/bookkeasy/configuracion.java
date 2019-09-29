package com.example.bookkeasy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseUser;

import java.util.Random;

public class configuracion extends AppCompatActivity {
    ImageView regresar;
    Button buscarlibro,correo,cuenta,colorr;
    Switch sonido;
    TextView barra;


    public void estado(boolean obtenido){

        sonido.setChecked(obtenido);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);
        regresar=(ImageView) findViewById(R.id.bin_regresarr);
        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        buscarlibro=(Button) findViewById(R.id.button5);
        buscarlibro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Cambiarcontrasena.class);
                startActivity(intent);
            }
        });

        correo=(Button) findViewById(R.id.button6);
        correo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),cambiarcorreo.class);
                startActivity(intent);
            }
        });

        cuenta=(Button) findViewById(R.id.button8);
        cuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Eliminarcuenta.class);
                startActivity(intent);
            }
        });


        colorr=(Button) findViewById(R.id.button);
        colorr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random=new Random();
                int color= Color.argb(255,random.nextInt(256),random.nextInt(256),random.nextInt(256));
                cambiarFondo(color);

            }
        });
        sonido=(Switch) findViewById(R.id.switch1);




        sonido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //// acceder al sonidooooooooooooo
                cambios();

            }
        });
        myPreferences = PreferenceManager.getDefaultSharedPreferences(configuracion.this);
        re=myPreferences.getString("sonido","off");
        if(re.equals("off")){
            estado(false);
        }else{
            estado(true);
        }
        barra=findViewById(R.id.id_conf);
        int dfecto=Color.argb(255,94,53,177);
        toll=myPreferences.getString("color",dfecto+"");

        barra.setBackgroundColor(Integer.parseInt(toll));
        colorr.setBackgroundColor(Integer.parseInt(toll));


    }

    static SharedPreferences myPreferences;
    String re,toll;

    public void cambios(){
        SharedPreferences.Editor myEditor = myPreferences.edit();
        myEditor.commit();
        String resultado=myPreferences.getString("sonido","off");
        if (resultado.equals("off")) {
                //debido a que por defecto este esta desactivado
            myEditor.remove("sonido");
            myEditor.putString("sonido","on");
            Toast.makeText(configuracion.this,"volumen activado ",Toast.LENGTH_LONG).show();
            myEditor.commit();
            estado(true);

        }if(resultado.equals("on")){
            myEditor.remove("sonido");
            myEditor.putString("sonido","off");
            Toast.makeText(configuracion.this,"volumen desactivado ",Toast.LENGTH_LONG).show();
            myEditor.commit();
            estado(false);

        }
    }

    public void cambiarFondo(int color){
        SharedPreferences.Editor myEditor = myPreferences.edit();

        myEditor.remove("color");
        myEditor.putString("color",color+"");
        myEditor.commit();
        colorr.setBackgroundColor(color);
        barra.setBackgroundColor(color);

    }

}
