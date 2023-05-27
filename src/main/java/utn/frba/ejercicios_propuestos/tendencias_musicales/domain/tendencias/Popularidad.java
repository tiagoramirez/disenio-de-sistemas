package utn.frba.ejercicios_propuestos.tendencias_musicales.domain.tendencias;

import utn.frba.ejercicios_propuestos.tendencias_musicales.domain.catalogo.Cancion;

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