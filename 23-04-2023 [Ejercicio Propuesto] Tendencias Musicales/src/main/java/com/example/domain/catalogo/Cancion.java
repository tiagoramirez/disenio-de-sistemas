package com.example.domain.catalogo;

import java.time.LocalDateTime;

import com.example.domain.tendencias.Popularidad;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cancion {
  private String titulo;
  private Album album;
  private Popularidad popularidad;
  private Integer cantReproducciones;
  private Integer cantLikes;
  private Integer cantDislikes;
  private LocalDateTime ultVezEscuchada;

  public void reproducir() {
    cantReproducciones++;
    ultVezEscuchada = LocalDateTime.now();
    popularidad.reproducir(this);
  }

  public String detalle() {
    return popularidad.mostrarDetalle(this);
  }

  public void recibirLike() {
    cantLikes++;
    popularidad.recibirDislike();
  }

  public void recibirDislike() {
    cantDislikes++;
  }
}
