package br.com.fmt.Pokedex.controllers;

import br.com.fmt.Pokedex.dto.CapturedPokemonRequest;
import br.com.fmt.Pokedex.dto.PokemonResponse;
import br.com.fmt.Pokedex.dto.PokemonSummaryResponse;
import br.com.fmt.Pokedex.dto.SeenPokemonRequest;
import br.com.fmt.Pokedex.entities.Pokemon;
import br.com.fmt.Pokedex.services.PokemonService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PutMapping("/seen")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateSeen(@Valid @RequestBody SeenPokemonRequest seenPokemonRequest){
        pokemonService.updateSeen(seenPokemonRequest);
    }

    @PutMapping("/captured")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateCaptured(@Valid @RequestBody CapturedPokemonRequest capturedPokemonRequest){
        pokemonService.updateCaptured(capturedPokemonRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(name = "id") Integer number){
        pokemonService.delete(number);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PokemonResponse search(@PathVariable(name = "id") Integer number){
        return pokemonService.search(number);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PokemonSummaryResponse> list(){
        return pokemonService.list();
    }


}
