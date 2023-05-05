package com.example.exportacion.estrategias;

import com.example.exportacion.Exportable;

public class AdaptadorApachePdfBox implements AdaptadorExportarPdf {

  @Override
  public String exportar(Exportable exportable) {
    return "Exportado con Apache PDFBox...";
  }
}
