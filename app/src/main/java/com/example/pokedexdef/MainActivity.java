package com.example.pokedexdef;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.pokedexdef.api.ApiClient;
import com.example.pokedexdef.api.ApiService;
import com.example.pokedexdef.model.pokemon.Pokemon;
import com.example.pokedexdef.model.pokemon.PokemonAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private Switch switchDarkMode;
    private EditText editTextCategory;
    private boolean mostrarSpriteDelantero = true;
    private ImageView spriteImageView;
    private RecyclerView recyclerView;
    private List<Pokemon> pokemonList;

    private PokemonAdapter pokemonAdapter;
    private int currentPokemonId = 1;  // ID inicial

    private Button btnVerFavoritos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spriteImageView = findViewById(R.id.sprite_pokemon);
        recyclerView = findViewById(R.id.lista_pokemons);

        pokemonList = new ArrayList<>();
        pokemonAdapter = new PokemonAdapter(pokemonList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(pokemonAdapter);



        btnVerFavoritos = findViewById(R.id.botonFav);
        btnVerFavoritos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Abre la actividad de favoritos
                Intent intent = new Intent(MainActivity.this, FavouritesActivity.class);
                startActivity(intent);
            }
        });






        // Llama a la API inicialmente con el ID actual
        getPokemonData(String.valueOf(currentPokemonId));

        // Configura los OnClickListener para los botones
        Button cambioActividadButton = findViewById(R.id.cambio_actividad);
        cambioActividadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NuevaActividad.class);
                startActivity(intent);
            }

        });
        cambioActividadButton.setBackgroundColor(getResources().getColor(R.color.colorPokemon));
        Button idMenosButton = findViewById(R.id.id_menos);
        Button idMasButton = findViewById(R.id.id_mas);
        Button btnCambiarSprite = findViewById(R.id.btnCambiarSprite);
        btnCambiarSprite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrarSpriteDelantero = !mostrarSpriteDelantero;  // Invierte el valor de la variable
                getPokemonData(String.valueOf(currentPokemonId)); // Llama a getPokemonData para actualizar la imagen
                updateButtonText();
            }
            private void updateButtonText() {
                if (mostrarSpriteDelantero) {
                    btnCambiarSprite.setText("Mostrar Parte de Atrás");
                } else {
                    btnCambiarSprite.setText("Mostrar Parte de Adelante");
                }
            }

        });


        idMenosButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentPokemonId > 1) {
                    currentPokemonId--;
                    getPokemonData(String.valueOf(currentPokemonId));
                }
            }
        });

        idMasButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Puedes establecer un límite superior si es necesario
                currentPokemonId++;
                getPokemonData(String.valueOf(currentPokemonId));
            }
        });
    }

    // Método para obtener datos del Pokémon desde la API
    private void getPokemonData(String id) {
        ApiService apiService = ApiClient.getRetrofit().create(ApiService.class);
        Call<Pokemon> call = apiService.getPokemon(id);

        call.enqueue(new Callback<Pokemon>() {
            @Override
            public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Pokemon pokemon = response.body();
                    updateUI(pokemon);
                }else {
                    // Manejar errores
                    Toast.makeText(MainActivity.this, "Error al obtener datos del Pokémon", Toast.LENGTH_SHORT).show();
                }
            }


            @Override
            public void onFailure(Call<Pokemon> call, Throwable t) {
                // Manejar errores de la llamada
                Toast.makeText(MainActivity.this, "Error de conexión", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Método para actualizar la interfaz de usuario con los datos del Pokémon
    private void updateUI(Pokemon pokemon) {

        // Actualiza la imagen del Pokémon con Glide
        Glide.with(this)
                .load(pokemon.getSpriteUrl(mostrarSpriteDelantero))
                .into(spriteImageView);

        // Actualiza la lista de Pokémon
        pokemonList.clear();
        pokemonList.add(pokemon);
        pokemonAdapter.notifyDataSetChanged();
    }
}
