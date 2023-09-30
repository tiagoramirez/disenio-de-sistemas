package utn.frba.ejercicios_propuestos.pro_services.dominio.actores.reputaciones;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import utn.frba.ejercicios_propuestos.pro_services.dominio.actores.Prestador;
import utn.frba.ejercicios_propuestos.pro_services.dominio.trabajos.Calificacion;
import utn.frba.ejercicios_propuestos.pro_services.dominio.trabajos.Trabajo;

@Entity
@DiscriminatorValue("mala")
public class ReputacionMala extends Reputacion {
    @Column
    private String nombreMala;

    @Override
    public void serContratado(Trabajo trabajo, Prestador prestador) {
        // TODO
    }

    @Override
    public void recibirCalificacion(Calificacion calificacion, Prestador prestador) {
        // TODO
    }
}