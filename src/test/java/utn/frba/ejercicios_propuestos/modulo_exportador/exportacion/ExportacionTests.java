package utn.frba.ejercicios_propuestos.modulo_exportador.exportacion;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import utn.frba.ejercicios_propuestos.modulo_exportador.exportacion.datos.Documento;
import utn.frba.ejercicios_propuestos.modulo_exportador.exportacion.estrategias.excel.ExportarExcel;
import utn.frba.ejercicios_propuestos.modulo_exportador.exportacion.estrategias.pdf.AdaptadorApachePdfBox;
import utn.frba.ejercicios_propuestos.modulo_exportador.exportacion.estrategias.pdf.ExportarPdf;

public class ExportacionTests {
	private Exportacion exportacion = new Exportacion();
	private Documento datos;

	@BeforeEach
	public void init() {
		datos = new Documento();
		datos.agregarDatos("0", "Nombre", "Apellido", "Usuario");
		datos.agregarDatos("1", "Tiago", "Ramirez", "tiagoramirez");
		datos.agregarDatos("2", "Samuel", "De Luque", "vegetta777");
	}

	@Test
	public void exportaPorDefectoExcel() {
		datos.agregarDatos("3", "Juan", "Perez", "juanperez");
		exportacion.setDatos(datos);
		String resultado = exportacion.exportar();
		assertEquals("(4) Exportado datos a Excel...", resultado);
	}

	@Test
	public void exportaPdfConApachePdfBox() {
		exportacion.setDatos(datos);
		AdaptadorApachePdfBox adaptadorPdf = new AdaptadorApachePdfBox();
		exportacion.cambiarExportador(new ExportarPdf(adaptadorPdf));
		String resultado = exportacion.exportar();
		assertEquals("(3) Exportado con Apache PDFBox...", resultado);
	}

	@Test
	public void exportarCambiandoExcel() {
		datos.agregarDatos("3", "Juan", "Perez", "juanperez");
		datos.agregarDatos("4", "Pedro", "Gomez", "pedrogomez");
		exportacion.setDatos(datos);
		AdaptadorApachePdfBox adaptadorPdf = new AdaptadorApachePdfBox();
		exportacion.cambiarExportador(new ExportarPdf(adaptadorPdf));
		// Aca cambiado a pdf con apache pdfbox
		ExportarExcel exportarExcel = new ExportarExcel();
		exportacion.cambiarExportador(exportarExcel);
		String resultado = exportacion.exportar();
		assertEquals("(5) Exportado datos a Excel...", resultado);
	}
}