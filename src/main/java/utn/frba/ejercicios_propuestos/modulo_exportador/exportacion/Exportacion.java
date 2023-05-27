package utn.frba.ejercicios_propuestos.modulo_exportador.exportacion;

import utn.frba.ejercicios_propuestos.modulo_exportador.exportacion.datos.Exportable;
import utn.frba.ejercicios_propuestos.modulo_exportador.exportacion.estrategias.Exportador;
import utn.frba.ejercicios_propuestos.modulo_exportador.exportacion.estrategias.excel.ExportarExcel;

public class Exportacion {
	private Exportador exportador;
	private Exportable datos;

	public Exportacion() {
		this.exportador = new ExportarExcel();
	}

	public String exportar() {
		return exportador.exportar(datos);
	}

	public void cambiarExportador(Exportador exportador) {
		this.exportador = exportador;
	}

	public void setDatos(Exportable datos) {
		this.datos = datos;
	}
}