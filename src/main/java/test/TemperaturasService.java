package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TemperaturasService implements ITemperaturaService {

  private List<Temperatura> valores = new ArrayList<>();

  public void addTemperatura(Temperatura t) {
    valores.add(t);
  }

  public List<Temperatura> obtenerTemperaturas() {
    return Collections.unmodifiableList(valores);
  }

  public int maxima() {
    return valores.stream().mapToInt(Temperatura::getMaxima).max().getAsInt();
  }

  @Override
  public boolean isEmpty() {
    return valores.isEmpty();
  }
}
