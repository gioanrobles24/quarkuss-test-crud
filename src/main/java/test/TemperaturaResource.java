package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("temperaturas")
public class TemperaturaResource {

  private List<Temperatura> valores = new ArrayList<>();

  @POST
  public Temperatura nueva(Temperatura temp) {
    valores.add(temp);
    return temp;
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public java.util.List<Temperatura> list() {
    return Collections.unmodifiableList(valores);
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/una")
  public Temperatura medicion() {
    return new Temperatura("malaga", 18, 28);
  }
}
