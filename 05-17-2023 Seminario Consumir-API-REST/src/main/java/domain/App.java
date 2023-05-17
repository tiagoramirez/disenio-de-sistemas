package domain;

import java.util.Scanner;

import domain.services.pokeapi.ServicioPokeapi;
import domain.services.pokeapi.entities.BasicPokemonInfo;
import domain.services.pokeapi.entities.ListadoPokemons;
import domain.services.pokeapi.entities.PokeTypes;
import domain.services.pokeapi.entities.Pokemon;

public class App {
  public static void main(String[] args) {
    ServicioPokeapi servicioPokeapi = ServicioPokeapi.instancia();
    System.out.println("1: Listado pokemons");
    System.out.println("2: Ver pokemon por id");
    Scanner scanner = new Scanner(System.in);
    System.out.print("Ingrese una opcion: ");
    int opcion = Integer.parseInt(scanner.next());
    switch (opcion) {
      case 1:
        System.out.print("Ingrese el numero de pagina: ");
        int pagina = Integer.parseInt(scanner.next());
        while (pagina != 777) {
          try {
            ListadoPokemons listadoPokemons = servicioPokeapi.listadoPokemons(pagina);
            for (BasicPokemonInfo poke : listadoPokemons.results) {
              String[] urlSplit = poke.url.split("/");
              int pokeId = Integer.parseInt(urlSplit[urlSplit.length - 1]);
              System.out.println("ID " + pokeId + ") " + poke.name);
            }
          } catch (Exception e) {
            System.out.println(e.getMessage());
          } finally {
            System.out.print("Ingrese el numero de pagina: ");
            pagina = Integer.parseInt(scanner.next());
          }
        }
        break;

      case 2:
        System.out.print("Ingrese el id del pokemon: ");
        int id = Integer.parseInt(scanner.next());
        try {
          Pokemon pokemon = servicioPokeapi.pokemon(id);
          String tipos = "";
          for (PokeTypes tipo : pokemon.types) {
            tipos += tipo.type.name + " ";
          }
          System.out.println(String.format("%s es de tipo %s", pokemon.name, tipos));
        } catch (Exception e) {
          System.out.println(e.getMessage());
        }
        break;

      default:
        System.out.println("Opcion no valida");
        break;
    }

    scanner.close();
    System.out.println("Chau");
  }
}
