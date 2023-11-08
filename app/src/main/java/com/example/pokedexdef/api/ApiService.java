package com.example.pokedexdef.api;


import com.example.pokedexdef.model.pokemon.Pokemon;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {

    @GET("pokemon/{id}")
    Call<Pokemon> getPokemon(@Path("id")String id);


}
