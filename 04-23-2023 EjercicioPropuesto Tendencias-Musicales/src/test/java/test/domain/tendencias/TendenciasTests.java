package test.domain.tendencias;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.domain.catalogo.Album;
import com.example.domain.catalogo.Artista;
import com.example.domain.catalogo.Cancion;
import com.example.domain.tendencias.EnAuge;
import com.example.domain.tendencias.EnTendencia;
import com.example.domain.tendencias.Normal;

public class TendenciasTests {
  private Cancion cancion;
  private Artista artista;
  private Album album;

  @BeforeEach
  public void init() {
    this.artista = new Artista();
    this.artista.setNombre("Coldplay");

    this.album = new Album();
    this.album.setAnio(2002);
    this.album.setArtista(artista);
    this.album.setNombre("A Rush of Blood to the head");

    this.cancion = new Cancion();
    this.cancion.setTitulo("The Scientist");
    this.cancion.setAlbum(this.album);

    Normal.maxReproduccionesEnPopularidad = 2;
    EnAuge.maxReproduccionesEnPopularidad = 3;
    EnAuge.maxLikesEnPopularidad = 3;
    EnAuge.maxDislikesEnPopularidad = 5;
    EnTendencia.maxHorasSinEscucharEnPopularidad = 24;
  }

  @Test
  @DisplayName("(Normal) The Scientist recién se lanza (tiene popularidad normal)")
  public void cancionMuestraDetalleDeTendenciaNormal() {
    cancion.reproducir();
    String detalle = cancion.detalle();
    assertEquals("🎵 Coldplay - A Rush of Blood to the head - The Scientist", detalle);
    assertEquals(Normal.class.getName(), cancion.getPopularidad().getClass().getName());
  }

  @Test
  @DisplayName("(Normal -> Auge) The Scientist está en auge")
  public void cancionMuestraDetalleEnAugeTest() {
    cancion.reproducir();
    cancion.reproducir();
    cancion.reproducir();

    String detalle = cancion.detalle();
    assertEquals("🚀 Coldplay - The Scientist (A Rush of Blood to the head - 2002)", detalle);
    assertEquals(EnAuge.class.getName(), cancion.getPopularidad().getClass().getName());
  }

  @Test
  @DisplayName("(Auge -> Normal) The Scientist vuelve a Normal por muchos dislikes")
  public void cancionVuelveANormalPorDislikes() {
    EnAuge.maxDislikesEnPopularidad = 5;
    cancion.reproducir();
    cancion.reproducir();
    cancion.reproducir();

    assertEquals(EnAuge.class.getName(), cancion.getPopularidad().getClass().getName());

    cancion.recibirDislike();
    cancion.recibirDislike();
    cancion.recibirDislike();
    cancion.recibirDislike();
    cancion.recibirDislike();
    cancion.recibirDislike();

    cancion.reproducir();

    assertEquals(Normal.class.getName(), cancion.getPopularidad().getClass().getName());
  }

  @Test
  @DisplayName("(Auge -> Tendencia) The Scientist es tendencia por reproducciones y likes")
  public void cancionMuestraDetalleEnTendenciaTest() {
    cancion.reproducir();
    cancion.reproducir();
    cancion.reproducir();

    // En este punto pasa a ser en auge
    cancion.recibirLike();
    cancion.recibirLike();
    cancion.recibirLike();
    cancion.recibirLike();

    cancion.reproducir();
    cancion.reproducir();
    cancion.reproducir();
    cancion.reproducir();

    // En este punto pasa a ser en tendencia

    assertEquals("🔥 The Scientist - Coldplay (A Rush of Blood to the head - 2002)", cancion.detalle());
    assertEquals(7, this.cancion.getCantReproducciones());
    assertEquals(EnTendencia.class.getName(), cancion.getPopularidad().getClass().getName());
  }

  @Test
  @DisplayName("(Tendencia -> Normal) The Scientist vuelve a ser normal por no ser escuchada en las últimas horas")
  public void cancionTendenciaVuelveASerNormal() {
    EnTendencia.maxHorasSinEscucharEnPopularidad = 24;
    cancion.reproducir();
    cancion.reproducir();
    cancion.reproducir();
    // En este punto pasa a ser en auge
    cancion.recibirLike();
    cancion.recibirLike();
    cancion.recibirLike();
    cancion.recibirLike();

    cancion.reproducir();
    cancion.reproducir();
    cancion.reproducir();
    cancion.reproducir();
    // En este punto pasa a ser en tendencia

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    LocalDateTime fechaFutura = LocalDateTime.parse("2030-04-20 12:00:00", formatter);

    EnTendencia estadoActualCancion = (EnTendencia) cancion.getPopularidad();
    estadoActualCancion.setFechaActualParaSimular(fechaFutura);

    cancion.reproducir();

    assertEquals(Normal.class.getName(), cancion.getPopularidad().getClass().getName());
  }
}