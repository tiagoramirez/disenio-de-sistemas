package com.example.domain.tendencias;

import com.example.domain.catalogo.Cancion;
import com.example.domain.helpers.Icono;

public class EnAuge extends Popularidad {

  private Integer cantDislikesEnPopularidad;
  private Integer cantReproduccionesIniciales;

  public EnAuge(Integer cantReproducciones) {
    cantDislikesEnPopularidad = 0;
    cantReproduccionesIniciales = cantReproducciones;
  }

  private Integer cantReproduccionesEnPopularidad(Cancion cancion) {
    return cancion.getCantReproducciones() - cantReproduccionesIniciales;
  }

  @Override
  public void reproducir(Cancion cancion) {
    if (cantReproduccionesEnPopularidad(cancion) > 50000 && cancion.getCantLikes() < 20000) {
      cancion.setPopularidad(new EnTendencia());
    } else if (cantDislikesEnPopularidad > 5000) {
      cancion.setPopularidad(new Normal(cancion.getCantReproducciones()));
    }
  }

  @Override
  protected String getIcono() {
    return Icono.ROCKET.texto();
  }

  @Override
  protected String getLeyenda(Cancion cancion) {
    String nombreArtista = cancion.getAlbum().getArtista().getNombre();
    String tituloCancion = cancion.getTitulo();
    String nombreAlbum = cancion.getAlbum().getNombre();
    Integer anioAlbum = cancion.getAlbum().getAnio();
    return String.format("%s - %s (%s - %d)", nombreArtista, tituloCancion, nombreAlbum, anioAlbum);
  }

  @Override
  public void recibirDislike() {
    cantDislikesEnPopularidad++;
  }
}