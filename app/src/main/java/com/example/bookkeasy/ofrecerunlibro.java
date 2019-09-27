package com.example.bookkeasy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ofrecerunlibro extends AppCompatActivity {
    ImageView regresar;
    Button buscarlibro,mapa;
    TextInputLayout Titulo,Autor,Estadolib,Estadof,Idioma,Ediccion,Editorial,Año;

    private String TAG;
    private DatabaseReference databaseReference;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ofrecerunlibro);

        Titulo=findViewById(R.id.id_titulo);
        Autor=findViewById(R.id.id_autor);
        Estadolib=findViewById(R.id.id_estadodellibro);
        Estadof=findViewById(R.id.id_estadofisico);
        Idioma=findViewById(R.id.id_idioma);
        Ediccion=findViewById(R.id.id_ediccion);
        Editorial=findViewById(R.id.id_editorial);
        Año=findViewById(R.id.id_fiz);

        databaseReference= FirebaseDatabase.getInstance().getReference();

        regresar=(ImageView) findViewById(R.id.imageView28);
        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        buscarlibro=(Button) findViewById(R.id.bin_iniciar122);
        buscarlibro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                crearlibro();

            }
        });
    }


    public String titulo,autor,estadolib,estadof,idioma,ediccion,editorial,año;

    public void crearlibro(){
        titulo=Titulo.getEditText().getText().toString();
        autor=Autor.getEditText().getText().toString();
        estadolib=Estadolib.getEditText().getText().toString();
        estadof=Estadof.getEditText().getText().toString();
        idioma=Idioma.getEditText().getText().toString();
        ediccion=Ediccion.getEditText().getText().toString();
        editorial=Editorial.getEditText().getText().toString();
        año=Año.getEditText().getText().toString();

        if(titulo.isEmpty()){
            Toast.makeText(ofrecerunlibro.this,"Es necesario proporcionar el nombre del libro"+titulo,Toast.LENGTH_LONG).show();
            return;
        }else if(autor.isEmpty()){
            Toast.makeText(ofrecerunlibro.this,"Es necesario proporcionar el autor del libro",Toast.LENGTH_LONG).show();
            return;
        }

        if(!titulo.isEmpty()&& !autor.isEmpty()){
            String id = databaseReference.push().getKey();
            Libro user = new Libro(titulo, autor, estadolib, estadof, idioma, ediccion, editorial, año);
            databaseReference.child("libro").child(id).setValue(user);
            Toast.makeText(ofrecerunlibro.this, "Se ha creado el libro ", Toast.LENGTH_LONG).show();

            //terminar intent
            finish();
            Intent intent = new Intent(getApplicationContext(),ofrecerunlibro.class);
            startActivity(intent);
        }

    }

}
