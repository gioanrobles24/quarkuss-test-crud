package test.genres;

import java.util.Optional;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.validation.Validator;

@ApplicationScoped
public class GenreValidator {
  Validator validator;

  @Inject
  public GenreValidator(Validator validator) {
    this.validator = validator;
  }

  public Optional<Object> validateGenre(CreateGenreDTO genre) {
    var errors = validator.validate(genre);
    if (errors.isEmpty()) {
      return Optional.empty();
    }
    return Optional.of(errors.stream().findFirst().get().getMessage());
  }
}
