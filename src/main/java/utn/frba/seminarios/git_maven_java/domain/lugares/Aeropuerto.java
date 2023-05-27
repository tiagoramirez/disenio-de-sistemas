package utn.frba.seminarios.git_maven_java.domain.lugares;

import java.time.LocalDate;
import java.util.List;

import lombok.Getter;
import utn.frba.seminarios.git_maven_java.domain.viajes.Vuelo;

public class Aeropuerto {
	@Getter
	private String nombre;
	@Getter
	private String codigoInternaciona;
	@Getter
	private Ciudad ciudad;
	@Getter
	private List<Vuelo> vuelos;

	public List<Vuelo> vuelosQueLlegaronElDia(LocalDate dia) {
		// TODO
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
