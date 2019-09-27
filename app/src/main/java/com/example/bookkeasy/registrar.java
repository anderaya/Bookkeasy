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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class registrar extends AppCompatActivity {
    Button registrar;
    ImageView regresar;



    //instancia de firebase
    private FirebaseAuth mAuth;
    private EditText Usuario, Contraseña,Correo,Direccion;

    private MediaPlayer sonido;
    private String TAG;
    private DatabaseReference databaseReference;

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrar);
        sonido = MediaPlayer.create(getApplicationContext(), R.raw.sonido);


        databaseReference=FirebaseDatabase.getInstance().getReference();



        regresar=(ImageView) findViewById(R.id.imageView2);
        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });




        registrar=(Button)findViewById(R.id.bt_registrar);
        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               sonido.start();
                registrarUsuario();


            }
        });

        //inicializar instancia de firebase
        mAuth = FirebaseAuth.getInstance();

        Usuario =(EditText)findViewById(R.id.editText4);
        Contraseña =(EditText)findViewById(R.id.editText24);
        Correo =(EditText)findViewById(R.id.editText6);
        Direccion =(EditText)findViewById(R.id.editText7);


    }

    public String usuario;
    public String contraseña;
    public String correo;
    public String direccion;

    private void registrarUsuario(){

        usuario= Usuario.getText().toString().trim();
        contraseña= Contraseña.getText().toString().trim();
        correo= Correo.getText().toString().trim();
        direccion= Direccion.getText().toString().trim();
    if(TextUtils.isEmpty(correo)){
        Toast.makeText(this,"Se debe ingresar un correo",Toast.LENGTH_LONG).show();
        return;
    }
    if(TextUtils.isEmpty(contraseña)){
        Toast.makeText(this,"Falta ingresar la contraseña",Toast.LENGTH_LONG).show();
        return;
    }else if(contraseña.length()<8){
        Toast.makeText(this,"La contraseña debe tener por lo menos 8 caracteres",Toast.LENGTH_LONG).show();
        return;
    }
    if(TextUtils.isEmpty(usuario)){
            Toast.makeText(this,"Falta ingresar el nombre de usuario",Toast.LENGTH_LONG).show();

            return;
        }
    if(TextUtils.isEmpty(direccion)){
            Toast.makeText(this,"Falta ingresar la dirección",Toast.LENGTH_LONG).show();

            return;
        }

    //crear un usuario
        //creating a new user


        mAuth.createUserWithEmailAndPassword(correo, contraseña)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //checking if success
                        if (task.isSuccessful()) {



                            finish();
                            FirebaseUser user = mAuth.getCurrentUser();
                            Intent intent = new Intent(getApplicationContext(), Menu.class);
                            startActivity(intent);
                            setRegistrarUsuario(usuario,correo,direccion);


                        }else{
                            Toast.makeText(registrar.this,"Datos incorrectos ",Toast.LENGTH_LONG).show();

                            // Log.d(TAG, "onComplete: Failed=" + task.getException().getMessage());

                        }

                    }
                });



    }


    public void setRegistrarUsuario(String nombre, String correo, String direccion){
        String tipo="normal";
        String id=databaseReference.push().getKey();
        Usuario user=new Usuario(nombre,correo,direccion,tipo);
        databaseReference.child("usuario").child(id).setValue(user);
        Toast.makeText(registrar.this,"Se ha registrado el usuario ",Toast.LENGTH_LONG).show();

    }
}
