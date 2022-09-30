package com.trybe.trybespring.application;

import org.springframework.stereotype.Controller;
import com.trybe.trybespring.domain.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
// import javax.ws.rs.DELETE;
// import javax.ws.rs.GET;
// import javax.ws.rs.POST;
// import javax.ws.rs.PUT;
// import javax.ws.rs.Path;
// import javax.ws.rs.Consumes;
// import javax.ws.rs.Produces;
// import javax.ws.rs.QueryParam;
import javax.websocket.server.PathParam;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Controller
@Path("/api/books")
public class BookController {
  private List<Book> books = new ArrayList<>();

  @POST
  @Consumes("application/json") // tipo de dado que é consumido
  @Produces("application/json") // tipo de dado enviado como resposta
  public Response add(Book book) {
    books.add(book);
    return Response.ok(book).build();
  }

  @GET
  @Consumes("application/json")
  @Produces("application/json")
  public Response findAll() {
    return Response.ok(books).build();
  }

  @GET
  @Path("/{id}")
  @Consumes("application/json")
  @Produces("application/json")
  public Response findById(@PathParam("id") UUID id) {
    try {
      Book book = books.stream().filter(b -> b.getId().equals(id)).findAny().orElseThrow();
      return Response.ok(book).build();
    } catch (NoSuchElementException e) {
      return Response.status(404).build();
    }
  }

  @PUT
  @Path("/{id}")
  @Consumes("application/json")
  @Produces("application/json")
  public Response update(@PathParam("id") UUID id, String name, String author) {
    try {
      Book book = books.stream().filter(b -> b.getId().equals(id)).findAny().orElseThrow();

      book.setName(name);
      book.setAuthor(author);

      return Response.ok(book).build();

    } catch (NoSuchElementException e) {
      return Response.status(404).build();
    }
  }

  @DELETE
  @Path("/{id}")
  @Consumes("application/json")
  @Produces("application/json")
  public Response remove(@PathParam("id") UUID id) {
    try {
      Book book = books.stream().filter(b -> b.getId().equals(id)).findAny().orElseThrow();

      books.remove(book);

      return Response.ok(book).build();

    } catch (NoSuchElementException e) {
      return Response.status(404).build();
    }
  }
}
