package utn.frba.ejercicios_propuestos.pro_services.dominio.trabajos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import utn.frba.ejercicios_propuestos.pro_services.datos.Persistente;
import utn.frba.ejercicios_propuestos.pro_services.dominio.actores.Consumidor;
import utn.frba.ejercicios_propuestos.pro_services.dominio.servicios.ServicioOfrecido;
import utn.frba.ejercicios_propuestos.pro_services.dominio.servicios.Tarea;

@Entity
@Table(name = "trabajo")
@Getter
@Setter
public class Trabajo extends Persistente {
    @ManyToOne
    @JoinColumn(name = "consumidor_id", referencedColumnName = "id")
    private Consumidor consumidor;

    @ManyToOne
    @JoinColumn(name = "servicioOfrecido_id", referencedColumnName = "id")
    private ServicioOfrecido servicioOfrecido;

    @ManyToMany
    private List<Tarea> tareas;

    @Column(columnDefinition = "DATE")
    private LocalDate fecha;

    @Column(columnDefinition = "TIME")
    private LocalTime horaInicio;

    @Column(columnDefinition = "TIME")
    private LocalTime horaFin;

    @Embedded
    private Direccion direccion;

    @Column
    private Boolean aceptado;

    @Column
    private Boolean finalizadoSegunPrestador;

    @Column
    private Boolean finalizadoSegunConsumidor;

    public Trabajo() {
        this.tareas = new ArrayList<Tarea>();
    }

    public Trabajo(Consumidor consumidor, ServicioOfrecido servicioOfrecido, List<Tarea> tareas, LocalDate fecha,
            LocalTime horaInicio, LocalTime horaFin, Direccion direccion) {
        this.consumidor = consumidor;
        this.servicioOfrecido = servicioOfrecido;
        this.tareas = tareas;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.direccion = direccion;
        this.aceptado = false;
        this.finalizadoSegunPrestador = false;
        this.finalizadoSegunConsumidor = false;
    }
}