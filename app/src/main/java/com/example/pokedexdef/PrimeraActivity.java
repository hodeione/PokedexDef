package com.example.pokedexdef;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class PrimeraActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primera);

        Button btnIrAMain = findViewById(R.id.btnIrAMain);

        btnIrAMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent para ir a MainActivity
                Intent intent = new Intent(PrimeraActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}