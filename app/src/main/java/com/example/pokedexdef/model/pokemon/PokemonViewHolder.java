package com.example.pokedexdef.model.pokemon;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pokedexdef.R;

public class PokemonViewHolder extends RecyclerView.ViewHolder {


    TextView tv_baseEsxperience, tv_pokemonName, tv_type, tv_height, tv_weight;

    public PokemonViewHolder(@NonNull View itemView){
super(itemView);

tv_pokemonName = itemView.findViewById(R.id.name);
tv_type = itemView.findViewById(R.id.type);
tv_height = itemView.findViewById(R.id.height);
tv_weight = itemView.findViewById(R.id.weight);
tv_baseEsxperience = itemView.findViewById(R.id.base_experience);



    }
}
