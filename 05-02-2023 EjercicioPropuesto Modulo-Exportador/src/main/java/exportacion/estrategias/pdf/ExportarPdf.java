package exportacion.estrategias.pdf;

import exportacion.datos.Exportable;
import exportacion.estrategias.Exportador;

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
