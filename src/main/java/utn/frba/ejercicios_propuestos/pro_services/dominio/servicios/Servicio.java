package utn.frba.ejercicios_propuestos.pro_services.dominio.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import utn.frba.ejercicios_propuestos.pro_services.datos.Persistente;

@Entity
@Table(name = "servicio")
@Getter
@Setter
public class Servicio extends Persistente {
    @Column
    private String nombre;

    // mappedBy = "Encontrame en la otra clase como el atributo 'servicio'"
    @OneToMany(mappedBy = "servicio", cascade = CascadeType.ALL)
    private List<Tarea> tareas;

    public Servicio() {
        this.tareas = new ArrayList<Tarea>();
    }

    public Servicio(String nombre) {
        this.nombre = nombre;
    }

    public Servicio(String nombre, List<Tarea> tareas) {
        this.nombre = nombre;
        this.tareas = tareas;
    }

    @Override
    public String toString() {
        return this.nombre;
    }

    public void agregarTarea(Tarea unaTarea) {
        this.tareas.add(unaTarea);
        unaTarea.setServicio(this);
    }
}
