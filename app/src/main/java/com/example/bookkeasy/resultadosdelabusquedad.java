package com.example.bookkeasy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

public class resultadosdelabusquedad extends AppCompatActivity  {

    static int seleccionado;
    ImageView regresar,mapa;
    Button buscarlibro;
    TextView detalles;
    private DatabaseReference databaseReference;
    buscarlibro bl=new buscarlibro();
    private MainActivity confi;
    private TextView barra;
    private String toll;

    int contador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultadosdelabusquedad);
        barra=findViewById(R.id.textView74);
        int dfecto= Color.argb(255,94,53,177);
        toll=confi.myPreferences.getString("color",dfecto+"");
        barra.setBackgroundColor(Integer.parseInt(toll));
        CheckPermission();

//pedir permiso ubicación



        detalles=(TextView) findViewById(R.id.bin_data);

        databaseReference= FirebaseDatabase.getInstance().getReference();

        databaseReference.child("libro").addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            String nombre=null;

                if(dataSnapshot.exists()){

                    dataSnapshot.getChildren();


                    for(DataSnapshot ds:dataSnapshot.getChildren()){

                        //mejorar para obtener multiples resultados
                        if(ds.child("titulo").getValue().toString().equals(bl.tituloBuscado)) {
                            nombre=ds.child("titulo").getValue().toString();
                            detalles.setText(nombre);


                            return;
                        }
                        contador++;
                    }
                    //String nombre=dataSnapshot.child("titulo").getValue().toString();


                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


                //verificar si es usuario o administrador

        regresar = (ImageView) findViewById(R.id.imageView19);
        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        mapa=(ImageView) findViewById(R.id.imageView28);
        mapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(getApplicationContext(),MapsActivity2.class);
                startActivity(intent);
            }
        });

        buscarlibro=(Button) findViewById(R.id.bin_iniciar9);
        buscarlibro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Intent intent = new Intent(getApplicationContext(),resultadosdelabusquedad.class);
                startActivity(intent);
            }
        });

        // listener detalles
        detalles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),verdetalles.class);
                startActivity(intent);
                seleccionado=contador;



            }
        });
    }

    public void CheckPermission() {
        if (ContextCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION, android.Manifest.permission.ACCESS_COARSE_LOCATION}, 101);
        }
    }

}
