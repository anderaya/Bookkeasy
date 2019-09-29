package com.example.bookkeasy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class verestadisticas extends AppCompatActivity {
    ImageView regresar;
    private MainActivity confi;
    private TextView barra;
    private String toll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verestadisticas);

        barra=findViewById(R.id.textView56);
        int dfecto= Color.argb(255,94,53,177);
        toll=confi.myPreferences.getString("color",dfecto+"");
        barra.setBackgroundColor(Integer.parseInt(toll));

        regresar=(ImageView) findViewById(R.id.imageView);
        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
