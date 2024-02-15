package test.genres;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import test.PaginatedResponse;

import io.quarkus.panache.common.Page;
import io.quarkus.panache.common.Sort;

@Path("/genres")
@Transactional
public class GenreResource {

  @Inject
  private GenreRepository genresRepo;

  @Inject
  private GenreMapper mapper;

  @Inject
  private GenreValidator validator;

  @GET
  public PaginatedResponse<Genre> genreList(
      @QueryParam("page") @DefaultValue("1") int page) {
    Page p = new Page(page - 1, 5);

    return new PaginatedResponse<>(genresRepo.findAll(Sort.descending("createdAt")).page(p));
  }

  @POST
  public Response create(CreateGenreDTO genre) {
    var error = this.validator.validateGenre(genre);
    if(error.isPresent()) {
      var msg = error.get();
      return Response.status(400).entity(msg).build();
    }
   
    var entity = mapper.fromCreate(genre);
    genresRepo.persist(entity);
    return Response.ok(entity).build();
  }

  @GET
  @Path("{id}")
  public Genre getGenreById(@PathParam("id") Long id) {
    var genre = genresRepo.findById(id);
    if (genre != null) {
      return genre;
    }
    throw new Error("no existe ese registro");
  }

  @DELETE
  @Path("{id}")
  public String deleteGenreById(@PathParam("id") Long id) {
    if (genresRepo.deleteById(id)) {
      return "se ha borrado con existo";
    } else {
      return "no se ha borrado";
    }

  }

  @PUT
  @Path("{id}")
  public Genre updateGenreById(@PathParam("id") Long id, CreateGenreDTO genre) {
    var updateGenre = genresRepo.findById(id);
    if (updateGenre != null) {
      updateGenre.setName(updateGenre.getName());
      return updateGenre;
    } else {
      throw new Error("no existe ese registro");
    }
  }

}
