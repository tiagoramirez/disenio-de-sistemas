package exportacion.estrategias.excel;

import exportacion.datos.Exportable;
import exportacion.estrategias.Exportador;

public class ExportarExcel implements Exportador {

  @Override
  public String exportar(Exportable exportable) {
    return "Exportado datos a Excel...";
  }
}