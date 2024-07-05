package br.com.fmt.Pokedex.mappers;

import br.com.fmt.Pokedex.dto.CapturedPokemonRequest;
import br.com.fmt.Pokedex.dto.PokemonResponse;
import br.com.fmt.Pokedex.dto.SeenPokemonRequest;
import br.com.fmt.Pokedex.entities.Pokemon;

public class PokemonMapper {

    private PokemonMapper(){}

    public static Pokemon map(SeenPokemonRequest source){
        if (source == null) return null;

        Pokemon target = new Pokemon();
        target.setNumber(source.getNumber());
        target.setName(source.getName());
        target.setImageUrl(source.getImageUrl());
        target.setHabitat(source.getHabitat());

        return target;
    }

    public static Pokemon map(CapturedPokemonRequest source){
        if (source == null) return null;

        Pokemon target = new Pokemon();
        target.setNumber(source.getNumber());
        target.setName(source.getName());
        target.setDescription(source.getDescription());
        target.setImageUrl(source.getImageUrl());
        target.setType(source.getType());
        target.setCategory(source.getCategory());
        target.setHabitat(source.getHabitat());
        target.setHeight(source.getHeight());
        target.setWeight(source.getWeight());
        target.setCaptured(true);

        return target;
    }

    public static PokemonResponse map(Pokemon source){
        if (source == null) return null;

        PokemonResponse target = new PokemonResponse();

        target.setNumber(source.getNumber());
        target.setName(source.getName());
        target.setDescription(source.getDescription());
        target.setImageUrl(source.getImageUrl());
        target.setType(source.getType());
        target.setCategory(source.getCategory());
        target.setHabitat(source.getHabitat());
        target.setHeight(source.getHeight());
        target.setWeight(source.getWeight());
        target.setCaptured(source.isCaptured());

        return target;
    }

}
