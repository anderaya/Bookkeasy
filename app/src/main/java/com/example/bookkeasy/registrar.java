package com.example.bookkeasy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class registrar extends AppCompatActivity implements  LocationListener{
    Button registrar,ingresarubicaciones;
    ImageView regresar;



    //instancia de firebase
    private FirebaseAuth mAuth;
    private EditText Usuario, Contraseña,Correo,Direccion;
    private MainActivity confi;

    private MediaPlayer sonido;


    LocationManager locationManager;


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
        selecionado=0;
        databaseReference=FirebaseDatabase.getInstance().getReference();

        regresar=(ImageView) findViewById(R.id.imageView2);
        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();

            }
        });


        registrar=(Button)findViewById(R.id.bt_registrar);
        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(confi.myPreferences.getString("sonido","off").equals("on")) {
                    sonido.start();
                }
               registrarUsuario();

            }
        });
        ingresarubicaciones=(Button)findViewById(R.id.button10);
        ingresarubicaciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


               ingresarubicaciones.setText("Ubicación agregada");
               selecionado=1;
            }
        });



        //inicializar instancia de firebase
        mAuth = FirebaseAuth.getInstance();

        Usuario =(EditText)findViewById(R.id.editText4);
        Contraseña =(EditText)findViewById(R.id.editText24);
        Correo =(EditText)findViewById(R.id.editText6);


        CheckPermission();


    }

    public String usuario;
    public String contraseña;
    public String correo;

    public static String tvLongi;
    public static String tvLati;
    public int selecionado;

    public usuarioActivo us=new usuarioActivo();
    private DatabaseReference databaseReference;



    private void registrarUsuario(){

        usuario= Usuario.getText().toString().trim();
        contraseña= Contraseña.getText().toString().trim();
        correo= Correo.getText().toString().trim();


        us.setCorreo(correo);

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

    if(selecionado!=1){
            Toast.makeText(this,"Falta agregar la ubicación",Toast.LENGTH_LONG).show();

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
                            setRegistrarUsuario(usuario,correo,tvLati,tvLongi);
                            Intent intent = new Intent(getApplicationContext(), Menu.class);
                            startActivity(intent);




                        }else{
                            Toast.makeText(registrar.this,"Datos incorrectos ",Toast.LENGTH_LONG).show();

                        }

                    }
                });



    }


    public void setRegistrarUsuario(String nombre, String correo, String latitud, String longitud){
        String tipo="normal";
        String id=databaseReference.push().getKey();
        Usuario user=new Usuario(nombre,correo,longitud,latitud,tipo);
        databaseReference.child("usuario").child(id).setValue(user);
        Toast.makeText(registrar.this,"Se ha registrado el usuario ",Toast.LENGTH_LONG).show();

        databaseReference= FirebaseDatabase.getInstance().getReference();

        databaseReference.child("usuario").addValueEventListener(new ValueEventListener(){

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


    }

    //obtener ubicacion

    public void onResume() {
        super.onResume();
        getLocation();
    }

    /* Remove the locationlistener updates when Activity is paused */
    @Override
    protected void onPause() {
        super.onPause();
        locationManager.removeUpdates(this);
    }

    public void getLocation() {
        try {
            locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 5000, 5, (LocationListener) this);
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }

    public void CheckPermission() {
        if (ContextCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION, android.Manifest.permission.ACCESS_COARSE_LOCATION}, 101);
        }
    }

    @Override
    public void onLocationChanged(Location location) {
        // Getting reference to TextView tv_longitude

        tvLongi = String.valueOf(location.getLongitude());
        tvLati = String.valueOf(location.getLatitude());

    }


    @Override
    public void onProviderDisabled(String provider) {
        Toast.makeText(registrar.this, "Please Enable GPS and Internet", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {
        Toast.makeText(this, "Enabled new provider!" + provider,
                Toast.LENGTH_SHORT).show();
    }

}
