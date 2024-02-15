package test.genres;

import jakarta.validation.constraints.*;

public record CreateGenreDTO(
    @NotBlank String name) {

}
