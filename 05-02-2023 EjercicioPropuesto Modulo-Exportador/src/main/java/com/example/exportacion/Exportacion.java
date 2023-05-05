package com.example.exportacion;

public class Exportacion {
  private Exportador exportador;
  private Exportable datos;

  public Exportacion(Exportador exportador) {
    this.exportador = exportador;
  }

  public void exportar() {
    exportador.exportar(datos);
  }

  public void cambiarExportador(Exportador exportador) {
    this.exportador = exportador;
  }

  public void setDatos(Exportable datos) {
    this.datos = datos;
  }
}
