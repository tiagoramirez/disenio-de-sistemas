package utn.frba.ejercicios_propuestos.pro_services.datos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public class Persistente {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private Boolean activo;

    @Column
    private LocalDate fechaAlta;

    @Column
    private LocalDate fechaBaja;
}
