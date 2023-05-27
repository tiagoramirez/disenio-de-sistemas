package utn.frba.seminarios.git_maven_java.domain.personas;

import java.util.List;

import lombok.Getter;
import utn.frba.seminarios.git_maven_java.domain.lugares.Ciudad;
import utn.frba.seminarios.git_maven_java.domain.lugares.Pais;
import utn.frba.seminarios.git_maven_java.domain.viajes.Vuelo;

public class Pasajero extends Persona {
	private List<Vuelo> vuelos;
	@Getter
	private Integer nroPasaporte;
	@Getter
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
