package utn.frba.ejercicios_propuestos.pro_services.dominio.servicios;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Servicio {
    private Long id;
    private String nombre;
    private List<Tarea> tareas;
    
    public Servicio() {
        this.tareas=new ArrayList<Tarea>();
    }

    @Override
    public String toString(){
        return this.nombre;
    }

    public void agregarTarea(Tarea unaTarea){
        this.tareas.add(unaTarea);
        unaTarea.setServicio(this);
    }
}
