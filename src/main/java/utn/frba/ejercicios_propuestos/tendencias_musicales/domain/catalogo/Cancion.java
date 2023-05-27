package utn.frba.ejercicios_propuestos.tendencias_musicales.domain.catalogo;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import utn.frba.ejercicios_propuestos.tendencias_musicales.domain.tendencias.Normal;
import utn.frba.ejercicios_propuestos.tendencias_musicales.domain.tendencias.Popularidad;

@Getter
@Setter
public class Cancion {
	private String titulo;
	private Album album;
	private Popularidad popularidad;
	private Integer cantReproducciones;
	private Integer cantLikes;
	@Getter
	private Integer cantDislikes;
	private LocalDateTime ultVezEscuchada;

	public Cancion() {
		this.popularidad = new Normal(0);
		this.cantReproducciones = 0;
		this.cantLikes = 0;
		this.cantDislikes = 0;
		this.ultVezEscuchada = LocalDateTime.now();
	}

	public void reproducir() {
		cantReproducciones++;
		ultVezEscuchada = LocalDateTime.now();
		popularidad.reproducir(this);
	}

	public String detalle() {
		return popularidad.mostrarDetalle(this);
	}

	public void recibirLike() {
		cantLikes++;
	}

	public void recibirDislike() {
		cantDislikes++;
		popularidad.recibirDislike();
	}
}
