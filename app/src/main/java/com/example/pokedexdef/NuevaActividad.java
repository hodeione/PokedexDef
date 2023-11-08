package com.example.pokedexdef;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class NuevaActividad extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_actividad);

        int imagenFondo = getIntent().getIntExtra("imagen_fondo", R.drawable.pokdex3);

        // Configura la imagen de fondo en tu diseño
        getWindow().setBackgroundDrawableResource(imagenFondo);
    }
}