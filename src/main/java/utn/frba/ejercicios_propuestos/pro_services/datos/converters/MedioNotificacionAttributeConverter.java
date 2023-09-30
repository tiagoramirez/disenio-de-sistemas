package utn.frba.ejercicios_propuestos.pro_services.datos.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import utn.frba.ejercicios_propuestos.pro_services.dominio.notificaciones.MedioNotificacion;
import utn.frba.ejercicios_propuestos.pro_services.dominio.notificaciones.MedioNotificacionEmail;
import utn.frba.ejercicios_propuestos.pro_services.dominio.notificaciones.MedioNotificacionWhatsapp;

@Converter(autoApply = true)
public class MedioNotificacionAttributeConverter implements AttributeConverter<MedioNotificacion, String> {
    @Override
    public String convertToDatabaseColumn(MedioNotificacion arg0) {
        if (arg0.getClass().getName() == "MedioNotidicacionEmail") {
            return "Email";
        } else {
            return "Whatsapp";
        }
    }

    @Override
    public MedioNotificacion convertToEntityAttribute(String arg0) {
        if (arg0.equals("Email")) {
            return new MedioNotificacionEmail();
        } else {
            return new MedioNotificacionWhatsapp();
        }
    }
}