package utn.frba.ejercicios_propuestos.tendencias_musicales.domain.tendencias;

import utn.frba.ejercicios_propuestos.tendencias_musicales.domain.catalogo.Cancion;
import utn.frba.ejercicios_propuestos.tendencias_musicales.domain.helpers.Icono;

public class Normal extends Popularidad {
	public static Integer maxReproduccionesEnPopularidad = 1000;

	private Integer cantReproduccionesIniciales;

	public Normal(Integer cantReproducciones) {
		cantReproduccionesIniciales = cantReproducciones;
	}

	private Integer cantReproduccionesEnPopularidad(Cancion cancion) {
		return cancion.getCantReproducciones() - cantReproduccionesIniciales;
	}

	private boolean superaMaxReproducciones(Cancion cancion) {
		return cantReproduccionesEnPopularidad(cancion) > maxReproduccionesEnPopularidad;
	}

	@Override
	public void reproducir(Cancion cancion) {
		if (superaMaxReproducciones(cancion)) {
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
		return String.format("%s - %s - %s", nombreArtista, nombreAlbum, tituloCancion);
	}
}