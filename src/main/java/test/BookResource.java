package test;

import java.util.List;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.Path;

@Path("/books")
@Transactional
public class BookResource {

  @GET
  public List<Book> index() {
    return Book.listAll();
  }

  @POST
  public Book insert(Book insertedBook) {
    insertedBook.persist();
    return insertedBook;
  }

}
