package utn.frba.seminarios.git_maven_java.domain.lugares;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pais {
    private String nombre;
    private Continente continente;
    private List<Ciudad> ciudades;

    public Pais() {
        this.ciudades = new ArrayList<Ciudad>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Continente getContinente() {
        return continente;
    }

    public void setContinente(Continente continente) {
        this.continente = continente;
    }

    public List<Ciudad> getCiudades() {
        return ciudades;
    }

    // public void setCiudad(Ciudad ciudad) {
    // this.ciudades.add(ciudad);
    // }

    // public void setCiudades(List<Ciudad> ciudades) {
    // this.ciudades = ciudades;
    // }

    public void setCiudades(Ciudad... ciudades) {
        Collections.addAll(this.ciudades, ciudades);
    }

}
