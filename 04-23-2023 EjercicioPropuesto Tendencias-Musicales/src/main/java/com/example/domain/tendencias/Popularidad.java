package com.example.domain.tendencias;

import com.example.domain.catalogo.Cancion;

public abstract class Popularidad {
  public abstract void reproducir(Cancion cancion);

  protected abstract String getIcono();

  protected abstract String getLeyenda(Cancion cancion);

  public String mostrarDetalle(Cancion cancion) {
    return getIcono() + " " + getLeyenda(cancion);
  }

  public void recibirDislike() {
  }
}