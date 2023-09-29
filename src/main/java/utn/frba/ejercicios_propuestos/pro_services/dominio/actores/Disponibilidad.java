package utn.frba.ejercicios_propuestos.pro_services.dominio.actores;

import java.time.DayOfWeek;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import utn.frba.ejercicios_propuestos.pro_services.datos.converters.DiaDeLaSemanaAttributeConverter;

@Entity
@Table(name = "disponibilidad")
@Getter
@Setter
public class Disponibilidad {
    @Id
    @GeneratedValue
    private Long id;

    // @Enumerated(EnumType.ORDINAL) // 1 - 2 - 3 - 4 - 5 - 6 - 7
    // @Enumerated(EnumType.STRING) // MONDAY - TUESDAY - WEDNESDAY - THURSDAY -
    // FRIDAY - SATURDAY - SUNDAY
    @Convert(converter = DiaDeLaSemanaAttributeConverter.class)
    private DayOfWeek dia;

    @Column(columnDefinition = "TIME")
    private LocalTime horaInicio;

    @Column(columnDefinition = "TIME")
    private LocalTime horaFin;

    public Disponibilidad() {
    }

    public Disponibilidad(DayOfWeek dia, LocalTime horaInicio, LocalTime horaFin) {
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }
}