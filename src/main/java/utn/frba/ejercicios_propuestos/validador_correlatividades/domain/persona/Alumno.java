package utn.frba.ejercicios_propuestos.validador_correlatividades.domain.persona;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import utn.frba.ejercicios_propuestos.validador_correlatividades.domain.universidad.Materia;

public class Alumno {
	private List<Materia> materiasAprobadas;

	public Alumno() {
		this.materiasAprobadas = new ArrayList<Materia>();
	}

	public void setMateriasAprobadas(Materia... materias) {
		Collections.addAll(materiasAprobadas, materias);
	}

	public boolean cumpleCorrelativas(Materia materia) {
		List<Materia> correlativas = materia.getCorrelativas();
		return correlativas
				.stream()
				.allMatch(correlativa -> materiasAprobadas
						.stream()
						.anyMatch(aprobada -> aprobada == correlativa));
	}
}
