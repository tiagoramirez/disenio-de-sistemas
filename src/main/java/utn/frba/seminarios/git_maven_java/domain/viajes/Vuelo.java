package utn.frba.seminarios.git_maven_java.domain.viajes;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Getter;
import utn.frba.seminarios.git_maven_java.domain.lugares.Aeropuerto;
import utn.frba.seminarios.git_maven_java.domain.lugares.Ciudad;
import utn.frba.seminarios.git_maven_java.domain.personas.Pasajero;
import utn.frba.seminarios.git_maven_java.domain.personas.Tripulacion;

public class Vuelo {
	@Getter
	private Aeropuerto origen;
	@Getter
	private Aeropuerto destino;
	@Getter
	private LocalDateTime fechaHora;
	@Getter
	private Double duracionEstimadaEnMins;
	private Avion avion;
	private List<Pasajero> pasajeros;
	@Getter
	private Tripulacion tripulacion;

	public Integer cantPasajeros() {
		return this.pasajeros.size();
	}

	public Double capacidadRealOcupadaPorPasajeros() {
		return (this.cantPasajeros() * 100.00) / this.avion.getCantidadAsientos();
	}

	public boolean tuDestinoEs(Ciudad ciudad) {
		// TODO
		return true;
	}
}
