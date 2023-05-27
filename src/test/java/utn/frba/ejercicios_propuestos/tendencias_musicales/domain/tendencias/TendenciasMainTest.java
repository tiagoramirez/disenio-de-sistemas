package utn.frba.ejercicios_propuestos.tendencias_musicales.domain.tendencias;

import utn.frba.ejercicios_propuestos.tendencias_musicales.domain.catalogo.Album;
import utn.frba.ejercicios_propuestos.tendencias_musicales.domain.catalogo.Artista;
import utn.frba.ejercicios_propuestos.tendencias_musicales.domain.catalogo.Cancion;

public class TendenciasMainTest {
	public static void main(String[] args) {
		// VALORES DE PRUEBA
		Normal.maxReproduccionesEnPopularidad = 2;
		EnAuge.maxLikesEnPopularidad = 3;
		EnAuge.maxReproduccionesEnPopularidad = 3;

		Artista coldplay = new Artista();
		coldplay.setNombre("Coldplay");

		Album aRushOfBloodToTheHead = new Album();
		aRushOfBloodToTheHead.setNombre("A Rush of Blood to the head");
		aRushOfBloodToTheHead.setAnio(2002);
		aRushOfBloodToTheHead.setArtista(coldplay);

		Cancion theScientist = new Cancion();
		theScientist.setTitulo("The Scientist");
		theScientist.setAlbum(aRushOfBloodToTheHead);

		reproducirYMostrarDetalle(theScientist);
		reproducirYMostrarDetalle(theScientist);
		reproducirYMostrarDetalle(theScientist);

		theScientist.recibirLike();
		theScientist.recibirLike();
		theScientist.recibirLike();
		theScientist.recibirLike();

		reproducirYMostrarDetalle(theScientist);
		reproducirYMostrarDetalle(theScientist);
		reproducirYMostrarDetalle(theScientist);
		reproducirYMostrarDetalle(theScientist);
	}

	private static void reproducirYMostrarDetalle(Cancion cancion) {
		cancion.reproducir();
		System.out.println(cancion.detalle());
	}
}