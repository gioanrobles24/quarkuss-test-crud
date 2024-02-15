package test;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.Path;

@Path("/books")
@Transactional
public class BookResource {

  @Inject
  private BookRepository bookRepository;

  @GET
  public List<Book> index() {
    return bookRepository.listAll();
  }

  @POST
  public Book insert(Book book) {
    bookRepository.persist(book);
    return book;
  }

  @GET
  @Path("{id}")
  public Book getBookById(@PathParam("id") Long id) {
    var book = bookRepository.findById(id);
    if (book != null) {
      return book;
    }
    throw new Error("no existe ese registro");
  }

  @DELETE
  @Path("{id}")
  public String deleteBookById(@PathParam("id") Long id) {
    if (bookRepository.deleteById(id)) {
      return "se ha borrado con existo";
    } else {
      return "no se ha borrado";
    }

  }

}
