package utn.frba.seminarios.consumir_api_rest.services.pokeapi.entities;

import java.util.List;

public class Pokemon {
	public String name;
	public int height;
	public int weight;
	public Sprites sprites;
	public List<PokeTypes> types;
}