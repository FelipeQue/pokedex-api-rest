package br.com.fmt.Pokedex.services;

import br.com.fmt.Pokedex.dto.CapturedPokemonRequest;
import br.com.fmt.Pokedex.dto.PokemonResponse;
import br.com.fmt.Pokedex.dto.PokemonSummaryResponse;
import br.com.fmt.Pokedex.dto.SeenPokemonRequest;
import br.com.fmt.Pokedex.entities.Pokemon;
import br.com.fmt.Pokedex.repositories.PokemonRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

import static br.com.fmt.Pokedex.mappers.PokemonMapper.map;
import static br.com.fmt.Pokedex.mappers.PokemonMapper.mapToSummary;

@Service
public class PokemonService {

    private final PokemonRepository repository;

    public PokemonService(PokemonRepository pokemonRepository){
        this.repository = pokemonRepository;
    }


    public void addSeen(SeenPokemonRequest seenPokemonRequest) {
        if (repository.existsById(seenPokemonRequest.getNumber())) {
            throw new DuplicateKeyException("There's already a Pokémon with this number.");
        }
        repository.save(map(seenPokemonRequest));
    }

    public void updateSeen(SeenPokemonRequest seenPokemonRequest) {
        Pokemon pokemon = repository
                .findById(seenPokemonRequest.getNumber())
                .orElseThrow(EntityNotFoundException::new);

        pokemon.setName(seenPokemonRequest.getName());
        pokemon.setImageUrl(seenPokemonRequest.getImageUrl());
        pokemon.setHabitat(seenPokemonRequest.getHabitat());

        repository.save(pokemon);
    }

    public void updateCaptured(CapturedPokemonRequest capturedPokemonRequest){
        if (!repository.existsById(capturedPokemonRequest.getNumber())) {
            throw new EntityNotFoundException("This Pokémon isn't in our records.");
        }
        repository.save(map(capturedPokemonRequest));
    }

    public void delete(Integer number) {
        if (!repository.existsById(number)) {
            throw new EntityNotFoundException("This Pokémon isn't in our records.");
        }
        repository.deleteById(number);
    }


    public PokemonResponse search(Integer number) {
        Pokemon pokemon = repository
                .findById(number)
                .orElseThrow(EntityNotFoundException::new);

        return map(pokemon);
    }

    public List<PokemonSummaryResponse> list() {
        return mapToSummary(repository.findAll());
    }

}
