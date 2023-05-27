package utn.frba.ejercicios_propuestos.modulo_exportador.exportacion.estrategias.pdf;

import utn.frba.ejercicios_propuestos.modulo_exportador.exportacion.datos.Exportable;
import utn.frba.ejercicios_propuestos.modulo_exportador.exportacion.estrategias.Exportador;

public class ExportarPdf implements Exportador {
	private AdaptadorExportarPdf adaptador;

	public ExportarPdf(AdaptadorExportarPdf adaptador) {
		this.adaptador = adaptador;
	}

	@Override
	public String exportar(Exportable exportable) {
		return adaptador.exportar(exportable);
	}
}