package exportacion.estrategias.pdf;

import exportacion.datos.Exportable;

public class AdaptadorApachePdfBox implements AdaptadorExportarPdf {

  @Override
  public String exportar(Exportable exportable) {
    return "Exportado con Apache PDFBox...";
  }
}
