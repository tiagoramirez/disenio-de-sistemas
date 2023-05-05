package com.example.exportacion.datos;

import java.util.List;
import java.util.Map;

import com.example.exportacion.Exportable;

public class Documento implements Exportable {

  private Map<String, List<String>> datos;

  @Override
  public Map<String, List<String>> datos() {
    return datos;
  }
}
