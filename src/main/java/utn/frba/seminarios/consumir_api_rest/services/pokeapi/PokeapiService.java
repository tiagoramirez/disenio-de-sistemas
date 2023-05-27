package utn.frba.seminarios.consumir_api_rest.services.pokeapi;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import utn.frba.seminarios.consumir_api_rest.services.pokeapi.entities.ListadoPokemons;
import utn.frba.seminarios.consumir_api_rest.services.pokeapi.entities.Pokemon;

public interface PokeapiService {
	@GET("pokemon")
	Call<ListadoPokemons> listadoPokemons(@Query("limit") int limit, @Query("offset") int offset);

	@GET("pokemon/{id}")
	Call<Pokemon> pokemon(@Path("id") int id);
}