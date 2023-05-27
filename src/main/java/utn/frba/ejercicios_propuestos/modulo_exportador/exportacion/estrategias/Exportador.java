package utn.frba.ejercicios_propuestos.modulo_exportador.exportacion.estrategias;

import utn.frba.ejercicios_propuestos.modulo_exportador.exportacion.datos.Exportable;

public interface Exportador {
	public String exportar(Exportable exportable);
}