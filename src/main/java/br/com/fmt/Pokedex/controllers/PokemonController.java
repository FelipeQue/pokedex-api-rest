package br.com.fmt.Pokedex.controllers;

import br.com.fmt.Pokedex.dto.CapturedPokemonRequest;
import br.com.fmt.Pokedex.dto.SeenPokemonRequest;
import br.com.fmt.Pokedex.services.PokemonService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/pokemon")
public class PokemonController {

    private final PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService){
        this.pokemonService = pokemonService;
    }

    @PostMapping("/seen")
    @ResponseStatus(HttpStatus.CREATED)
    public void addSeen(@Valid @RequestBody SeenPokemonRequest seenPokemonRequest) {
        pokemonService.addSeen(seenPokemonRequest);
    }

    @PostMapping("/captured")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCaptured(@Valid @RequestBody CapturedPokemonRequest capturedPokemonRequest){
        pokemonService.addCaptured(capturedPokemonRequest);
    }


}
