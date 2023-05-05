import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exportacion.Exportacion;
import exportacion.datos.Documento;
import exportacion.estrategias.excel.ExportarExcel;
import exportacion.estrategias.pdf.AdaptadorApachePdfBox;
import exportacion.estrategias.pdf.ExportarPdf;

public class ExportacionTests {
  Exportacion exportacion = new Exportacion();

  @BeforeEach
  public void init() {
    Map<String, List<String>> datosIniciales = new HashMap<String, List<String>>();
    datosIniciales.put("nombres", List.of("Tiago", "Pepe", "Juan"));
    Documento datos = new Documento(datosIniciales);
    exportacion.setDatos(datos);
  }

  @Test
  public void exportaPorDefectoExcel() {
    String resultado = exportacion.exportar();
    assertEquals("Exportado datos a Excel...", resultado);
  }

  @Test
  public void exportaPdfConApachePdfBox() {
    AdaptadorApachePdfBox adaptadorPdf = new AdaptadorApachePdfBox();
    exportacion.cambiarExportador(new ExportarPdf(adaptadorPdf));
    String resultado = exportacion.exportar();
    assertEquals("Exportado con Apache PDFBox...", resultado);
  }

  @Test
  public void exportarCambiandoExcel() {
    AdaptadorApachePdfBox adaptadorPdf = new AdaptadorApachePdfBox();
    exportacion.cambiarExportador(new ExportarPdf(adaptadorPdf));
    // Aca cambiado a pdf con apache pdfbox
    ExportarExcel exportarExcel = new ExportarExcel();
    exportacion.cambiarExportador(exportarExcel);
    String resultado = exportacion.exportar();
    assertEquals("Exportado datos a Excel...", resultado);
  }
}
