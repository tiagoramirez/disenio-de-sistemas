package domain.services.pokeapi;

import domain.services.pokeapi.entities.ListadoPokemons;
import domain.services.pokeapi.entities.Pokemon;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServicioPokeapi {
  private static ServicioPokeapi instancia = null;
  private final int limite = 20;
  private static final String urlApi = "https://pokeapi.co/api/v2/";
  private Retrofit retrofit;

  private ServicioPokeapi() {
    this.retrofit = new Retrofit.Builder()
        .baseUrl(urlApi)
        .addConverterFactory(GsonConverterFactory.create())
        .build();
  }

  public static ServicioPokeapi instancia() {
    if (instancia == null) {
      instancia = new ServicioPokeapi();
    }
    return instancia;
  }

  public ListadoPokemons listadoPokemons(int page) throws Exception {
    PokeapiService service = this.retrofit.create(PokeapiService.class);
    Call<ListadoPokemons> listadoPokemonsCall = service.listadoPokemons(limite, page * 20);
    Response<ListadoPokemons> response = listadoPokemonsCall.execute();
    return response.body();
  }

  public Pokemon pokemon(int id) throws Exception {
    PokeapiService service = this.retrofit.create(PokeapiService.class);
    Call<Pokemon> pokemonCall = service.pokemon(id);
    Response<Pokemon> response = pokemonCall.execute();
    return response.body();
  }
}
