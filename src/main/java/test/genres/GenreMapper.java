package test.genres;

public interface GenreMapper {
  Genre fromCreate(CreateGenreDTO dto);

  void update(CreateGenreDTO dto, Genre genre);
}
