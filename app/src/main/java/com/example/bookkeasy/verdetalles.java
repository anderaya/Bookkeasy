package com.example.bookkeasy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class verdetalles extends AppCompatActivity {
    TextView titulo,autor,usuario,cliente,estadodellibro,estadofisico,idioma,ediccion,editorial,fecha;

    resultadosdelabusquedad rb=new resultadosdelabusquedad();
    int contador=rb.seleccionado;
    private DatabaseReference databaseReference;

    ImageView regresar;
    int count;
    public usuarioActivo us=new usuarioActivo();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verdetalles);

        titulo=findViewById(R.id.textView18);
        autor=findViewById(R.id.textView19);
        usuario=findViewById(R.id.textView21);
        cliente=findViewById(R.id.textView22);
        estadodellibro=findViewById(R.id.textView23);
        estadofisico=findViewById(R.id.textView24);
        idioma=findViewById(R.id.textView25);
        ediccion=findViewById(R.id.textView27);
        editorial=findViewById(R.id.textView28);
        fecha=findViewById(R.id.textView29);

        count=0;


        databaseReference= FirebaseDatabase.getInstance().getReference();

        databaseReference.child("libro").addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String nombre=null;

                if(dataSnapshot.exists()){

                    dataSnapshot.getChildren();


                    for(DataSnapshot ds:dataSnapshot.getChildren()){

                        if(count==contador) {
                            nombre=ds.child("titulo").getValue().toString();
                            titulo.setText("Titulo: "+nombre);

                            nombre=ds.child("autor").getValue().toString();
                            autor.setText("Autor: "+nombre);

                            nombre=ds.child("usuario").getValue().toString();
                            usuario.setText("Usuario: "+nombre);


                            cliente.setText("Cliente: ");

                            nombre=ds.child("estadodellibro").getValue().toString();
                            estadodellibro.setText("Estado del libro: "+nombre);

                            nombre=ds.child("estadofisico").getValue().toString();
                            estadofisico.setText("Estado fisico: "+nombre);

                            nombre=ds.child("idioma").getValue().toString();
                            idioma.setText("Idioma: "+nombre);

                            nombre=ds.child("ediccion").getValue().toString();
                            ediccion.setText("Edicción: "+nombre);

                            nombre=ds.child("editorial").getValue().toString();
                            editorial.setText("Editorial: "+nombre);

                            nombre=ds.child("año").getValue().toString();
                            fecha.setText("Año: "+nombre);

                            return;
                        }
                        count++;
                    }
                    //String nombre=dataSnapshot.child("titulo").getValue().toString();


                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });





        regresar=(ImageView) findViewById(R.id.imageView3);
        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });







    }

    public void actualizar(){


      // titulo.setText(re.guardado.child("titulo").toString());


    }
}
