package test.genres;

import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class GenderMapperImpl implements GenreMapper {

  @Override
  public Genre fromCreate(CreateGenreDTO dto) {
    var g = new Genre();
    g.setName(dto.name());
    return g;
  }

  @Override
  public void update(CreateGenreDTO dto, Genre genre) {
    genre.setName(dto.name());
  }
}
