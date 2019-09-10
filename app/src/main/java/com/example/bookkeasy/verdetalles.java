package com.example.bookkeasy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class verdetalles extends AppCompatActivity {
    ImageView regresar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verdetalles);

        regresar=(ImageView) findViewById(R.id.imageView3);
        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),resultadosdelabusquedad.class);
                startActivity(intent);
            }
        });
    }
}
