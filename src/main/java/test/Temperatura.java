package test;

import java.util.Objects;

public class Temperatura {
  private String ciudad;
  private int minima;
  private int maxima;

  public Temperatura() {

  }

  public Temperatura(String ciudad, int mininma, int maxima) {
    this.ciudad = ciudad;
    this.maxima = maxima;
    this.minima = mininma;
  }

  public String getCiudad() {
    return ciudad;
  }

  public void setCiudad(String ciudad) {
    this.ciudad = ciudad;
  }

  public int getMinima() {
    return minima;
  }

  public void setMinima(int minima) {
    this.minima = minima;
  }

  public int getMaxima() {
    return maxima;
  }

  public void setMaxima(int maxima) {
    this.maxima = maxima;
  }

  @Override
  public int hashCode() {
    return Objects.hash(ciudad, maxima, minima);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Temperatura other = (Temperatura) obj;
    return Objects.equals(ciudad, other.ciudad) && maxima == other.maxima && minima == other.minima;
  }

  @Override
  public String toString() {
    return "temperatura [ciudad = " + ciudad + ", minima= " + minima + ", maxima= " + minima + "]";
  }
}
