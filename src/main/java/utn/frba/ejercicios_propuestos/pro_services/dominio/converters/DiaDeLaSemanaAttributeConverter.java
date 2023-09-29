package utn.frba.ejercicios_propuestos.pro_services.dominio.converters;

import java.time.DayOfWeek;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class DiaDeLaSemanaAttributeConverter implements AttributeConverter<DayOfWeek, String> {

    @Override
    public String convertToDatabaseColumn(DayOfWeek attribute) {
        String dia = null;
        switch (attribute) {
            case MONDAY:
                dia = "Lunes";
                break;
            case TUESDAY:
                dia = "Martes";
                break;
            case WEDNESDAY:
                dia = "Miercoles";
                break;
            case THURSDAY:
                dia = "Jueves";
                break;
            case FRIDAY:
                dia = "Viernes";
                break;
            case SATURDAY:
                dia = "Sabado";
                break;
            case SUNDAY:
                dia = "Domingo";
                break;
        }
        return dia;
    }

    @Override
    public DayOfWeek convertToEntityAttribute(String dbData) {
        DayOfWeek dia = null;
        if (dbData != null) {
            switch (dbData) {
                case "Lunes":
                    dia = DayOfWeek.MONDAY;
                    break;
                case "Martes":
                    dia = DayOfWeek.TUESDAY;
                    break;
                case "Miercoles":
                    dia = DayOfWeek.WEDNESDAY;
                    break;
                case "Jueves":
                    dia = DayOfWeek.THURSDAY;
                    break;
                case "Viernes":
                    dia = DayOfWeek.FRIDAY;
                    break;
                case "Sabado":
                    dia = DayOfWeek.SATURDAY;
                    break;
                case "Domingo":
                    dia = DayOfWeek.SUNDAY;
                    break;
                default:
                    throw new IllegalArgumentException(dbData + " no se puede convertir a un DayOfWeek");
            }
        }
        return dia;
    }

}
