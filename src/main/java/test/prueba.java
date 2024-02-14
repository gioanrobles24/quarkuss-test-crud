package test;

import jakarta.ws.rs.*;

@Path("/saludar")
public class prueba {

  @GET
  public String saludar(
      @QueryParam("mensaje") String mensaje) {
    if (mensaje == null) {
      return "sin mensaje";
    } else {
      return ">" + mensaje;
    }
  }

  @GET
  @Path("/{nombre}")
  public String saludo(
      @PathParam("nombre") String nombre) {
    return "hola " + nombre;
  }

  @GET
  @Path("/{nombre}/mayusculas")
  public String mayusculas(
      @PathParam("nombre") String nombre) {
    return "HOlA " + nombre.toUpperCase();
  }

}
