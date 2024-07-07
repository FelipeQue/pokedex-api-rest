package br.com.fmt.Pokedex.dto;

import br.com.fmt.Pokedex.enums.TypeEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CapturedPokemonRequest {

    @NotNull private Integer number;
    @NotBlank private String name;
    @NotBlank private String description;
    @NotBlank private String imageUrl;
    @NotNull private TypeEnum type;
    @NotBlank private String category;
    @NotBlank private String habitat;
    @NotNull private Double height;
    @NotNull private Double weight;

    @NotNull
    public Integer getNumber() {
        return number;
    }

    public void setNumber(@NotNull Integer number) {
        this.number = number;
    }

    public @NotBlank String getName() {
        return name;
    }

    public void setName(@NotBlank String name) {
        this.name = name;
    }

    public @NotBlank String getDescription() {
        return description;
    }

    public void setDescription(@NotBlank String description) {
        this.description = description;
    }

    public @NotBlank String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(@NotBlank String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public @NotNull TypeEnum getType() {
        return type;
    }

    public void setType(@NotNull TypeEnum type) {
        this.type = type;
    }

    public @NotBlank String getCategory() {
        return category;
    }

    public void setCategory(@NotBlank String category) {
        this.category = category;
    }

    public @NotBlank String getHabitat() {
        return habitat;
    }

    public void setHabitat(@NotBlank String habitat) {
        this.habitat = habitat;
    }

    public @NotNull Double getHeight() {
        return height;
    }

    public void setHeight(@NotNull Double height) {
        this.height = height;
    }

    public @NotNull Double getWeight() {
        return weight;
    }

    public void setWeight(@NotNull Double weight) {
        this.weight = weight;
    }
}
