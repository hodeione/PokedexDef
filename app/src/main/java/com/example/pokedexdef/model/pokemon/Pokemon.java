package com.example.pokedexdef.model.pokemon;

import android.widget.ImageView;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import java.util.List;
import java.util.Map;

public class Pokemon {
    private int id;
    private String name;
    private String type;
    private String height;
    private String weight;
    private List<Object> abilities;
    private String image;
    private String ubication;
    private String backSpriteUrl;
    private double base_experience;
    private Map<String, Object> additionalProperties;

    public double getBaseExperience() {
        return base_experience;
    }

    public void setBaseExperience(double baseExperience) {
        this.base_experience = baseExperience;
    }

    public Pokemon(int id, String name, String type, String height
            , String weight, List<Object> abilities, String image
            , String ubication, String backSpriteUrl, double base_experience, Map<String, Object> additionalProperties) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.height = height;
        this.weight = weight;
        this.abilities = abilities;
        this.image = image;
        this.ubication = ubication;
        this.backSpriteUrl = backSpriteUrl;
        this.base_experience = base_experience;
        this.additionalProperties = additionalProperties;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getHeight() {
        return height;
    }

    public String getWeight() {
        return weight;
    }

    public List<Object> getAbilities() {
        return abilities;
    }

    public String getImage() {
        return image;
    }

    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }


    public String getSpriteUrl(boolean isFront) {
        if(isFront){
            return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/" + id + ".png";
        } else {
            return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/" + id + ".png";
        }
    }
    // Puedes agregar más métodos según sea necesario.
}
