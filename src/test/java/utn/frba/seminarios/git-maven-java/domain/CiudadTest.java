import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import utn.frba.seminarios.git_maven_java.domain.lugares.Aeropuerto;
import utn.frba.seminarios.git_maven_java.domain.lugares.Ciudad;

public class CiudadTest {

  @Test
  public void ciudadTieneDosAeropuertos() {
    Ciudad unaCiudad = new Ciudad("Aeropuerto");
    Aeropuerto unAeropuerto = new Aeropuerto();
    unaCiudad.setAeropuertos(unAeropuerto);

    assertEquals(1, unaCiudad.cantDeAeropuertos().intValue());
  }
}
