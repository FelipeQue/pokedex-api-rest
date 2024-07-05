package br.com.fmt.Pokedex.services;

import br.com.fmt.Pokedex.dto.CapturedPokemonRequest;
import br.com.fmt.Pokedex.dto.SeenPokemonRequest;
import br.com.fmt.Pokedex.mappers.PokemonMapper;
import br.com.fmt.Pokedex.repositories.PokemonRepository;
import org.springframework.stereotype.Service;

import static br.com.fmt.Pokedex.mappers.PokemonMapper.map;

@Service
public class PokemonService {

    private final PokemonRepository repository;

    public PokemonService(PokemonRepository pokemonRepository){
        this.repository = pokemonRepository;
    }


    public void addSeen(SeenPokemonRequest seenPokemonRequest) {
        repository.save(map(seenPokemonRequest));
    }

    public void addCaptured(CapturedPokemonRequest capturedPokemonRequest){
        repository.save(map(capturedPokemonRequest));

    }


}
