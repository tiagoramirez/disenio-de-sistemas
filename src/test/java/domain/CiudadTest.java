package domain;

import org.junit.Assert;
import org.junit.Test;

import domain.lugares.Aeropuerto;
import domain.lugares.Ciudad;

public class CiudadTest {

    @Test
    public void ciudadTieneDosAeropuertos() {
        Ciudad unaCiudad = new Ciudad("Aeropuerto");
        Aeropuerto unAeropuerto = new Aeropuerto();
        unaCiudad.setAeropuertos(unAeropuerto);

        Assert.assertEquals(1, unaCiudad.cantDeAeropuertos().intValue());
    }
}
