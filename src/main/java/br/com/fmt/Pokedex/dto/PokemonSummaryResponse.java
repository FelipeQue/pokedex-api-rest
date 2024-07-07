package br.com.fmt.Pokedex.dto;

public class PokemonSummaryResponse {

    private Integer number;
    private String name;
    private boolean captured;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCaptured() {
        return captured;
    }

    public void setCaptured(boolean captured) {
        this.captured = captured;
    }
}
