package com.example.bookkeasy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class registrar extends AppCompatActivity {
    Button registrar;
    ImageView regresar;



    //instancia de firebase
    private FirebaseAuth mAuth;
    private EditText Usuario, Contraseña,Correo,Direccion;
    private MediaPlayer sonido;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrar);
        sonido = MediaPlayer.create(getApplicationContext(), R.raw.sonido);

        regresar=(ImageView) findViewById(R.id.imageView2);
        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Intent intent = new Intent(getApplicationContext(), MapsActivity2.class);
                startActivity(intent);
            }
        });




        registrar=(Button)findViewById(R.id.bt_registrar);
        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               sonido.start();
                if(registrarUsuario()==true) {
                    finish();
                    Intent intent = new Intent(getApplicationContext(), Menu.class);
                    startActivity(intent);
                }


            }
        });

        //inicializar instancia de firebase
        mAuth = FirebaseAuth.getInstance();

        Usuario =(EditText)findViewById(R.id.editText4);
        Contraseña =(EditText)findViewById(R.id.editText24);
        Correo =(EditText)findViewById(R.id.editText6);
        Direccion =(EditText)findViewById(R.id.editText7);


    }


    private boolean registrarUsuario(){
        String usuario= Usuario.getText().toString().trim();
    String contraseña= Contraseña.getText().toString().trim();
    String correo= Correo.getText().toString().trim();
    String direccion= Direccion.getText().toString().trim();

    if(TextUtils.isEmpty(correo)){
        Toast.makeText(this,"Se debe ingresar un correo",Toast.LENGTH_LONG).show();
        return false;
    }
    if(TextUtils.isEmpty(contraseña)){
        Toast.makeText(this,"Falta ingresar la contraseña",Toast.LENGTH_LONG).show();

        return false;
    }

    //crear un usuario
        //creating a new user
        final boolean[] estado = {false};

        mAuth.createUserWithEmailAndPassword(correo, contraseña)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //checking if success
                        if(task.isSuccessful()){

                            Toast.makeText(registrar.this,"Se ha registrado el usuario con el email: "+ Correo.getText(),Toast.LENGTH_LONG).show();
                            estado[0] =true;


                        }else{

                            Toast.makeText(registrar.this,"No se pudo registrar el usuario ",Toast.LENGTH_LONG).show();

                            estado[0] =false;
                            task.getException();
                        }

                    }
                });
        return estado[0];


    }



}
