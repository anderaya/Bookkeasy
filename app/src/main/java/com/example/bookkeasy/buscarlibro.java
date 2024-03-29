package com.example.bookkeasy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;


public class buscarlibro extends AppCompatActivity {
    Button buscarlibro;
    TextView avanzada;
    ImageView regresar;
    private DatabaseReference databaseReference;
    private FirebaseAuth mAuth;
    public usuarioActivo us=new usuarioActivo();
    private MainActivity confi;

    public String getTituloBuscado() {
        return tituloBuscado;
    }


    static String tituloBuscado,autorBuscado;
    private EditText Titulo,Autor;
    private TextView barra;
    private String toll;
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscarlibro);
        mAuth = FirebaseAuth.getInstance();
        Titulo=findViewById(R.id.editText8);
        Autor=findViewById(R.id.editText9);

        barra=findViewById(R.id.textView13);
        int dfecto= Color.argb(255,94,53,177);
        toll=confi.myPreferences.getString("color",dfecto+"");
        barra.setBackgroundColor(Integer.parseInt(toll));



        buscarlibro=(Button) findViewById(R.id.id_buscarlibro);
        buscarlibro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                funcionBuscarLibro();

            }
        });

        avanzada=(TextView)findViewById(R.id.bin_busquedaavanzada);
        avanzada.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),busquedaavanzada.class);
                startActivity(intent);

            }
        });

        regresar=(ImageView) findViewById(R.id.imageView2);
        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void funcionBuscarLibro(){

        tituloBuscado= Titulo.getText().toString().trim();
        autorBuscado= Autor.getText().toString().trim();
        if(!tituloBuscado.isEmpty()|!autorBuscado.isEmpty()){
            Intent intent = new Intent(getApplicationContext(),resultadosdelabusquedad.class);
            startActivity(intent);

        }else{
            Toast.makeText(buscarlibro.this,"Es necesario proporcionar alguno de los dos parametros ",Toast.LENGTH_LONG).show();
        }



    }


}
