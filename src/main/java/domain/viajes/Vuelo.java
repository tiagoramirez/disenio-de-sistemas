package domain.viajes;

import java.time.LocalDateTime;
import java.util.List;

import domain.lugares.Aeropuerto;
import domain.lugares.Ciudad;
import domain.personas.Pasajero;
import domain.personas.Tripulacion;

public class Vuelo {
    private Aeropuerto origen;
    private Aeropuerto destino;
    private LocalDateTime fechaHora;
    private Double duracionEstimadaEnMins;
    private Avion avion;
    private List<Pasajero> pasajeros;
    private Tripulacion tripulacion;

    public Integer cantPasajeros() {
        return this.pasajeros.size();
    }

    public Double capacidadRealOcupadaPorPasajeros() {
        return (this.cantPasajeros() * 100.00) / this.avion.getCantidadAsientos();
    }

    public boolean tuDestinoEs(Ciudad ciudad) {
        //TODO
        return true;
    }
}
