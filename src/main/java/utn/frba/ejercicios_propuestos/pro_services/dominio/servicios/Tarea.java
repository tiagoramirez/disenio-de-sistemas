package utn.frba.ejercicios_propuestos.pro_services.dominio.servicios;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Tarea {
    private Long id;
    private String nombre;
    private String descripcion;
    private Servicio servicio;
}
