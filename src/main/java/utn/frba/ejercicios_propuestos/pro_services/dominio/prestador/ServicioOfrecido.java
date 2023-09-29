package utn.frba.ejercicios_propuestos.pro_services.dominio.prestador;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import utn.frba.ejercicios_propuestos.pro_services.dominio.servicios.Servicio;
import utn.frba.ejercicios_propuestos.pro_services.dominio.servicios.Tarea;

@Entity
@Table(name = "servicio_ofrecido")
@Getter
@Setter
public class ServicioOfrecido {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "prestador_id", referencedColumnName = "id")
    private Prestador prestador;

    @ManyToOne
    @JoinColumn(name = "servicio_id", referencedColumnName = "id")
    private Servicio servicio;

    @Column
    private Double radioCobertura;

    @Column(columnDefinition = "longtext")
    private String experiencias;

    @ElementCollection
    @CollectionTable(name = "servicio_ofrecido_foto", joinColumns = @JoinColumn(name = "servicioOfrecido_id", referencedColumnName = "id"))
    @Column(name = "ruta")
    private List<String> fotos;

    @ManyToMany
    private List<Tarea> tareas;

    public ServicioOfrecido() {
        this.fotos = new ArrayList<String>();
        this.tareas = new ArrayList<Tarea>();
    }

    public ServicioOfrecido(Prestador prestador, Servicio servicio, Double radioCobertura, String experiencias,
            List<String> fotos, List<Tarea> tareas) {
        this.prestador = prestador;
        this.servicio = servicio;
        this.radioCobertura = radioCobertura;
        this.experiencias = experiencias;
        this.fotos = fotos;
        this.tareas = tareas;
    }
}