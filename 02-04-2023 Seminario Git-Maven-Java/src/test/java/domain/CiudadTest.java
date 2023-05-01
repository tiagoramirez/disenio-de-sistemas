package domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import domain.lugares.Aeropuerto;
import domain.lugares.Ciudad;

public class CiudadTest {

  @Test
  public void ciudadTieneDosAeropuertos() {
    Ciudad unaCiudad = new Ciudad("Aeropuerto");
    Aeropuerto unAeropuerto = new Aeropuerto();
    unaCiudad.setAeropuertos(unAeropuerto);

    assertEquals(1, unaCiudad.cantDeAeropuertos().intValue());
  }
}
