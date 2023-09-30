package utn.frba.ejercicios_propuestos.pro_services.dominio.actores;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import utn.frba.ejercicios_propuestos.pro_services.datos.Persistente;

@Entity
@Table(name = "consumidor")
@Getter
@Setter
public class Consumidor extends Persistente {
    @Column
    private String nombre;

    @Column
    private String apellido;

    public Consumidor() {
    }

    public Consumidor(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }
}