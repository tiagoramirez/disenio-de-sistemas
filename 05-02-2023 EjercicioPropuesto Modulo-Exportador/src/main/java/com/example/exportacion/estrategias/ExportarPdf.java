package com.example.exportacion.estrategias;

import com.example.exportacion.Exportable;
import com.example.exportacion.Exportador;

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
