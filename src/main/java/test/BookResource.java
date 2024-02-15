package test;

import java.util.List;

import io.quarkus.panache.common.Sort;
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
  public List<Book> index(@QueryParam("numPages") Integer numPages) {
    if (numPages == null) {
      return bookRepository.listAll(Sort.by("pubDate", Sort.Direction.Descending));
    } else {
      return bookRepository.list("numPages >= ?1", numPages);
    }

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

  @PUT
  @Path("{id}")
  public Book updateBookById(@PathParam("id") Long id, Book book) {
    var updateBook = bookRepository.findById(id);
    if (updateBook != null) {
      updateBook.setTitle(book.getTitle());
      updateBook.setDescription(book.getDescription());
      updateBook.setNumPages(book.getNumPages());
      updateBook.setPubDate(book.getPubDate());
      bookRepository.persist(updateBook);
      return updateBook;
    } else {
      throw new Error("no existe ese registro");
    }
  }

}
