package utn.frba.ejercicios_propuestos.pro_services.dominio.servicios;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class Tarea {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String nombre;

    @Column
    private String descripcion;

    @Transient
    private Servicio servicio;

    public Tarea() {
    }

    public Tarea(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return String.format("[%d] %s - %s", this.id, this.nombre, this.descripcion);
    }

}