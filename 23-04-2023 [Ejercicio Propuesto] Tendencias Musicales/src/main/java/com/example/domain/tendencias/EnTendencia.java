package com.example.domain.tendencias;

import com.example.domain.catalogo.Cancion;
import com.example.domain.helpers.Icono;

public class EnTendencia extends Popularidad {
  @Override
  public void reproducir(Cancion cancion) {
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