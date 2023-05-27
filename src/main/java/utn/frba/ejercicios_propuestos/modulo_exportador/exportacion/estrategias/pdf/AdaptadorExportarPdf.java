package utn.frba.ejercicios_propuestos.modulo_exportador.exportacion.estrategias.pdf;

import utn.frba.ejercicios_propuestos.modulo_exportador.exportacion.datos.Exportable;

public interface AdaptadorExportarPdf {
	public String exportar(Exportable exportable);
}