package com.example.domain.tendencias;

import com.example.domain.catalogo.Cancion;
import com.example.domain.helpers.Icono;

public class Normal extends Popularidad {

  private Integer cantReproduccionesIniciales;

  public Normal(Integer cantReproducciones) {
    cantReproduccionesIniciales = cantReproducciones;
  }

  private Integer cantReproduccionesEnPopularidad(Cancion cancion) {
    return cancion.getCantReproducciones() - cantReproduccionesIniciales;
  }

  @Override
  public void reproducir(Cancion cancion) {
    if (cantReproduccionesEnPopularidad(cancion) > 1000) {
      cancion.setPopularidad(new EnAuge(cancion.getCantReproducciones()));
    }
  }

  @Override
  protected String getIcono() {
    return Icono.MUSICAL_NOTE.texto();
  }

  @Override
  protected String getLeyenda(Cancion cancion) {
    String nombreArtista = cancion.getAlbum().getArtista().getNombre();
    String nombreAlbum = cancion.getAlbum().getNombre();
    String tituloCancion = cancion.getTitulo();
    return String.format("%s - %s - %s)", nombreArtista, nombreAlbum, tituloCancion);
  }
}