package com.example.pokedexdef.model.pokemon;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pokedexdef.R;

import java.util.List;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonViewHolder> {

    private List<Pokemon> pokemonList;

    public PokemonAdapter(List<Pokemon> pokemonList) {
        this.pokemonList = pokemonList;
    }

    @NonNull
    @Override
    public PokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pokemon_item, parent, false);
        return new PokemonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonViewHolder holder, int position) {
        Pokemon pokemon = pokemonList.get(position);
        holder.tv_pokemonName.setText("Name: " + pokemon.getName());
        holder.tv_type.setText("Type: " + pokemon.getType());
        holder.tv_height.setText("Height: " + pokemon.getHeight()+"m");
        holder.tv_weight.setText("Weight: " + pokemon.getWeight()+"Kg");
        // Puedes agregar más campos según sea necesario

        holder.tv_baseEsxperience.setText("Base Experience: " + pokemon.getBaseExperience());

    }

    @Override
    public int getItemCount() {
        return pokemonList.size();
    }
}
