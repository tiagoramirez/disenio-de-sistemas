package com.example.domain.tendencias;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import com.example.domain.catalogo.Cancion;
import com.example.domain.helpers.Icono;

public class EnTendencia extends Popularidad {
  @Override
  public void reproducir(Cancion cancion) {
    Long horasDesdeUltVezEscuchada = ChronoUnit.HOURS.between(cancion.getUltVezEscuchada(), LocalDateTime.now());
    if (horasDesdeUltVezEscuchada > 24) {
      cancion.setPopularidad(new Normal(cancion.getCantReproducciones()));
    }
  }

  @Override
  protected String getIcono() {
    return Icono.FIRE.texto();
  }

  @Override
  protected String getLeyenda(Cancion cancion) {
    String tituloCancion = cancion.getTitulo();
    String nombreArtista = cancion.getAlbum().getArtista().getNombre();
    String nombreAlbum = cancion.getAlbum().getNombre();
    Integer anioAlbum = cancion.getAlbum().getAnio();
    return String.format("%s - %s (%s - %d))", tituloCancion, nombreArtista, nombreAlbum, anioAlbum);
  }
}