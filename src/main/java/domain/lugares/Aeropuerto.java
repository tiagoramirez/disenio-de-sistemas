package domain.lugares;

import java.time.LocalDate;
import java.util.List;

import domain.viajes.Vuelo;

public class Aeropuerto {
    private String nombre;
    private String codigoInternaciona;
    private Ciudad ciudad;
    private List<Vuelo> vuelos;

    public List<Vuelo> vuelosQueLlegaronElDia(LocalDate dia) {
        //TODO
        return null;
    }

    public Integer cantVuelosQueLlegaronElDia(LocalDate dia) {
        // TODO
        return 0;
    }

    public Integer cantVuelosQuePartieronElDia(LocalDate dia) {
        // TODO
        return 0;
    }
}
