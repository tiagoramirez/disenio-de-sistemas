package domain.personas;

import java.util.List;

import domain.lugares.Ciudad;
import domain.lugares.Pais;
import domain.viajes.Vuelo;

public class Pasajero extends Persona {
    private List<Vuelo> vuelos;
    private Integer nroPasaporte;
    private Pais nacionalidad;

    public Integer cantVuelosTotales() {
        return this.vuelos.size();
    }

    public Integer cantVecesQueVisitaste(Ciudad ciudad) {
        return (int) this.vuelos
                .stream()
                .filter(v -> v.tuDestinoEs(ciudad))
                .count();
    }
}
