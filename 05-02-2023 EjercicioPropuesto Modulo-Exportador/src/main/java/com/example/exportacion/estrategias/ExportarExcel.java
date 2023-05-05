package com.example.exportacion.estrategias;

import com.example.exportacion.Exportable;
import com.example.exportacion.Exportador;

public class ExportarExcel implements Exportador {

  @Override
  public String exportar(Exportable exportable) {
    return "Exportado datos a Excel...";
  }
}