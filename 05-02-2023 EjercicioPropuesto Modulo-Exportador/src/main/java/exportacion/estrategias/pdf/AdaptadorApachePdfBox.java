package exportacion.estrategias.pdf;

import java.util.List;
import java.util.Map;

import exportacion.datos.Exportable;

public class AdaptadorApachePdfBox implements AdaptadorExportarPdf {

  @Override
  public String exportar(Exportable exportable) {
    Map<String, List<String>> datos = exportable.datos();
    for (Map.Entry<String, List<String>> entry : datos.entrySet()) {
      System.out.println(entry.getKey() + " - " + entry.getValue());
    }
    return "(" + datos.size() + ") Exportado con Apache PDFBox...";
  }
}
