package com.example.domain.catalogo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Album {
  private Integer anio;
  private String nombre;
  private Artista artista;
}
