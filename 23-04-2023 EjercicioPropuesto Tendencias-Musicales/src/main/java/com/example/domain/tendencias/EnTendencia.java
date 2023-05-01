package com.example.domain.tendencias;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import com.example.domain.catalogo.Cancion;
import com.example.domain.helpers.Icono;

import lombok.Setter;

public class EnTendencia extends Popularidad {

  public static Integer maxHorasSinEscucharEnPopularidad = 24;

  @Setter
  private LocalDateTime fechaActualParaSimular = LocalDateTime.now();

  private boolean superaMaxHorasSinEscuchar(Cancion cancion) {
    Long horasDesdeUltVezEscuchada = ChronoUnit.HOURS.between(cancion.getUltVezEscuchada(), fechaActualParaSimular);
    return horasDesdeUltVezEscuchada > maxHorasSinEscucharEnPopularidad;
  }

  @Override
  public void reproducir(Cancion cancion) {
    if (superaMaxHorasSinEscuchar(cancion)) {
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
    return String.format("%s - %s (%s - %d)", tituloCancion, nombreArtista, nombreAlbum, anioAlbum);
  }
}