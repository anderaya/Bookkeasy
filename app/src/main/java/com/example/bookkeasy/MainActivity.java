package com.example.bookkeasy;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import static com.example.bookkeasy.R.raw.sonido;

public class MainActivity extends AppCompatActivity {
    Button iniciar;
    TextView registrar,recuperar;
    private MediaPlayer sonido;


    private FirebaseAuth mAuth;
    private EditText Contraseña,Correo;
    ///public SharedPreferences myPreferences = PreferenceManager.getDefaultSharedPreferences(this);
    //public SharedPreferences.Editor myEditor = myPreferences.edit();

    @Override
    public void onStart() {


        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sonido = MediaPlayer.create(getApplicationContext(),R.raw.sonido);


        iniciar= (Button) findViewById(R.id.bin_iniciarss);
        iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sonido.start();
                Intent intent = new Intent(getApplicationContext(),Menu.class);
                startActivity(intent);

            }
        });

        //myEditor.putInt("Sonido",0);

        //definir sonido



        //ir a menu

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


        //inicializar instancia de firebase
        mAuth = FirebaseAuth.getInstance();


        Contraseña = (EditText)findViewById(R.id.editText);
        Correo =(EditText)findViewById(R.id.editText2);

    }

    private boolean iniciarss(){

        String contraseña= Contraseña.getText().toString().trim();
        String correo= Correo.getText().toString().trim();


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

        mAuth.signInWithEmailAndPassword(correo,contraseña).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            private String TAG;

            @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "createUserWithEmail:onComplete:" + task.isSuccessful());

                        if (task.isSuccessful()) {
                            Toast.makeText(MainActivity.this,"Inicio exitosooooooooooooooo: "+ Correo.getText(),Toast.LENGTH_LONG).show();
                            estado[0] =true;
                            FirebaseUser user = mAuth.getCurrentUser();

                        } else {
                            Toast.makeText(MainActivity.this,"error: "+ Correo.getText(),Toast.LENGTH_LONG).show();
                            estado[0] =true;
                            Log.d(TAG, "onComplete: Failed=" + task.getException().getMessage());
                        }

                        // ...
                    }
                });


        return estado[0];


    }


}
