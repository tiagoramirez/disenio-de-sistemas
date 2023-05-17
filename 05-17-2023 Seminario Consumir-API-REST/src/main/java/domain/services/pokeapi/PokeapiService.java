package domain.services.pokeapi;

import domain.services.pokeapi.entities.ListadoPokemons;
import domain.services.pokeapi.entities.Pokemon;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PokeapiService {
  @GET("pokemon")
  Call<ListadoPokemons> listadoPokemons(@Query("limit") int limit, @Query("offset") int offset);

  @GET("pokemon/{id}")
  Call<Pokemon> pokemon(@Path("id") int id);
}
