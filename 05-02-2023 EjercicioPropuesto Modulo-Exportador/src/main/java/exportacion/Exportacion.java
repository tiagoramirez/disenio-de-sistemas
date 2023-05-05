package exportacion;

import exportacion.datos.Exportable;
import exportacion.estrategias.Exportador;
import exportacion.estrategias.excel.ExportarExcel;

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
