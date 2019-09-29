package com.example.bookkeasy;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    Button iniciar;
    TextView registrar,recuperar;
    private MediaPlayer sonido;
    private configuracion confi;

    private FirebaseAuth mAuth;
    private EditText Contraseña,Correo;
    private TextView barra;

    String toll;
    static SharedPreferences myPreferences;

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

        myPreferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        SharedPreferences.Editor myEditor = myPreferences.edit();
        myEditor.commit();

        barra=findViewById(R.id.textView);
        int dfecto= Color.argb(255,94,53,177);
        toll=myPreferences.getString("color",dfecto+"");
        barra.setBackgroundColor(Integer.parseInt(toll));

        iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(myPreferences.getString("sonido","off").equals("on")) {
                    sonido.start();
                }

                //verifica e iniciar activity
                iniciarss();
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


        //inicializar instancia de firebase
        mAuth = FirebaseAuth.getInstance();

        //relacionar id del layout
        Contraseña = (EditText)findViewById(R.id.editText);
        Correo =(EditText)findViewById(R.id.editText2);

    }


    private usuarioActivo us=new usuarioActivo();
    private DatabaseReference databaseReference;

    private void iniciarss(){
        String contraseña= Contraseña.getText().toString().trim();
        String correo= Correo.getText().toString().trim();
        us.setCorreo(correo);

        if(TextUtils.isEmpty(correo)){
            Toast.makeText(this,"Falta ingresar un correo",Toast.LENGTH_LONG).show();
            return ;
        }
        if(TextUtils.isEmpty(contraseña)){
            Toast.makeText(this,"Falta ingresar la contraseña",Toast.LENGTH_LONG).show();

            return ;
        }

        mAuth.signInWithEmailAndPassword(correo,contraseña).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {


            @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(MainActivity.this,"Se ha iniciado sesión",Toast.LENGTH_LONG).show();
                            finish();
                            FirebaseUser user = mAuth.getCurrentUser();


                            databaseReference= FirebaseDatabase.getInstance().getReference();
                            databaseReference.child("usuario").addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    if(dataSnapshot.exists()){
                                        dataSnapshot.getChildren();
                                        for(DataSnapshot ds:dataSnapshot.getChildren()){
                                            //mejorar para obtener multiples resultados
                                            if(ds.child("correo").getValue().toString().equals(us.getCorreo())) {

                                                us.setUsuario(ds.child("usuario").getValue().toString());
                                                us.setLongitud(ds.child("longitud").getValue().toString());
                                                us.setLatitud(ds.child("latitud").getValue().toString());
                                                us.setTipouser(ds.child("tipouser").getValue().toString());
                                                return;
                                            }
                                        }
                                    }
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {

                                }
                            });
                            Intent intent = new Intent(getApplicationContext(), Menu.class);
                            startActivity(intent);


                        }else{
                            Toast.makeText(MainActivity.this,"Correo o contraseña incorrecta ",Toast.LENGTH_LONG).show();

                           // Log.d(TAG, "onComplete: Failed=" + task.getException().getMessage());

                        }
                    }
                });

    }







}


