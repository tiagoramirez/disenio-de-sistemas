package utn.frba.ejercicios_propuestos.pro_services.dominio.actores;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "consumidor")
@Getter
@Setter
public class Consumidor {
    @Id
    @GeneratedValue
    private Long id;

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