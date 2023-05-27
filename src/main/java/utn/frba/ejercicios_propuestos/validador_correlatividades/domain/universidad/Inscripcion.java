package utn.frba.ejercicios_propuestos.validador_correlatividades.domain.universidad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import utn.frba.ejercicios_propuestos.validador_correlatividades.domain.persona.Alumno;

public class Inscripcion {
	private List<Materia> materias;
	private Alumno alumno;

	public Inscripcion(Alumno alumno) {
		this.alumno = alumno;
		materias = new ArrayList<Materia>();
	}

	public void setMaterias(Materia... materias) {
		Collections.addAll(this.materias, materias);
	}

	public boolean aprobada() {
		return materias
				.stream()
				.allMatch(m -> alumno.cumpleCorrelativas(m));
	}
}
