package utn.frba.ejercicios_propuestos.pro_services.dominio.actores.reputaciones;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import utn.frba.ejercicios_propuestos.pro_services.datos.Persistente;
import utn.frba.ejercicios_propuestos.pro_services.dominio.actores.Prestador;
import utn.frba.ejercicios_propuestos.pro_services.dominio.trabajos.Calificacion;
import utn.frba.ejercicios_propuestos.pro_services.dominio.trabajos.Trabajo;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
// --- Estrategia joined: Cada clase en una tabla distinta (Quitar DiscriminatorColumn)
// @Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "reputacion")
@DiscriminatorColumn(name = "tipo")
public abstract class Reputacion extends Persistente {
    @Column
    private String nombre;

    public abstract void serContratado(Trabajo trabajo, Prestador prestador);

    public abstract void recibirCalificacion(Calificacion calificacion, Prestador prestador);
}
