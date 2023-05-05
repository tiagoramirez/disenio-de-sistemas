package com.example.exportacion.datos;

import java.util.List;
import java.util.Map;

import com.example.exportacion.Exportable;

public class Documento implements Exportable {

  private Map<String, List<String>> datos;

  public Documento(Map<String, List<String>> datos) {
    this.datos = datos;
  }

  @Override
  public Map<String, List<String>> datos() {
    return datos;
  }
}
