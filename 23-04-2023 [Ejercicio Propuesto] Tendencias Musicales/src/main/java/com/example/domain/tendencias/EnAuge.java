package com.example.domain.tendencias;

import com.example.domain.catalogo.Cancion;
import com.example.domain.helpers.Icono;

public class EnAuge extends Popularidad {

  public static Integer maxReproduccionesEnPopularidad = 50000;
  public static Integer maxLikesEnPopularidad = 20000;
  public static Integer maxDislikesEnPopularidad = 5000;

  private Integer cantDislikesEnPopularidad;
  private Integer cantReproduccionesIniciales;

  public EnAuge(Integer cantReproducciones) {
    cantDislikesEnPopularidad = 0;
    cantReproduccionesIniciales = cantReproducciones;
  }

  private Integer cantReproduccionesEnPopularidad(Cancion cancion) {
    return cancion.getCantReproducciones() - cantReproduccionesIniciales;
  }

  private boolean superaMaxReproducciones(Cancion cancion) {
    return cantReproduccionesEnPopularidad(cancion) > maxReproduccionesEnPopularidad;
  }

  private boolean superaMaxLikes(Cancion cancion) {
    return cancion.getCantLikes() > maxLikesEnPopularidad;
  }

  private boolean superaMaxDislikes() {
    return cantDislikesEnPopularidad > maxDislikesEnPopularidad;
  }

  @Override
  public void reproducir(Cancion cancion) {
    if (superaMaxReproducciones(cancion) && superaMaxLikes(cancion)) {
      cancion.setPopularidad(new EnTendencia());
    } else if (superaMaxDislikes()) {
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