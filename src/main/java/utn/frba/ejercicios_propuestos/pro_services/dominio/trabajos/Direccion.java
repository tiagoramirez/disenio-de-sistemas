package utn.frba.ejercicios_propuestos.pro_services.dominio.trabajos;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class Direccion {
    @Column
    private String calle;

    @Column
    private String altura;

    @Column
    private String piso;

    @Column
    private String depto;

    @Column
    private String cp;

    @Column
    private String referencia;

    @Column
    private String barrio;

    @Column
    private String provincia;
}