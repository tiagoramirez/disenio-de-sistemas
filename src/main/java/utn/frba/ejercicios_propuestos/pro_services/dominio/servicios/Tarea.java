package utn.frba.ejercicios_propuestos.pro_services.dominio.servicios;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import utn.frba.ejercicios_propuestos.pro_services.datos.Persistente;

@Entity
@Table(name = "tarea")
@Getter
@Setter
public class Tarea extends Persistente {
    @Column
    private String nombre;

    @Column
    private String descripcion;

    @ManyToOne
    // Nombre de la columna de la fk, nombre de la pk a la que hace referencia
    @JoinColumn(name = "servicio_id", referencedColumnName = "id")
    private Servicio servicio;

    public Tarea() {
    }

    public Tarea(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return String.format("%s - %s", this.nombre, this.descripcion);
    }
}