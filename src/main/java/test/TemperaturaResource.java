package test;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("temperaturas")
public class TemperaturaResource {

  private TemperaturasService temperaturas;

  @Inject
  public TemperaturaResource(TemperaturasService temperaturas) {
    this.temperaturas = temperaturas;
  }

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  public Temperatura nueva(Temperatura temp) {
    temperaturas.addTemperatura(temp);
    return temp;
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public java.util.List<Temperatura> list() {
    return temperaturas.obtenerTemperaturas();
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/maxima")
  public Response maxima() {
    if (temperaturas.isEmpty()) {
      return Response.status(404).entity("no hay temperaturas").build();
    } else {
      int temperaturaMaxima = temperaturas.maxima();
      return Response.ok(Integer.toString(temperaturaMaxima)).build();
    }
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("{ciudad}")
  public Temperatura sacar(@PathParam("ciudad") String ciudad) {
   return temperaturas.sacarTemperatura(ciudad).get();
  }
}
