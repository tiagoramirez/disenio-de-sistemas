package utn.frba.ejercicios_propuestos.pro_services.dominio.notificaciones;

import utn.frba.ejercicios_propuestos.pro_services.dominio.actores.Prestador;

public interface MedioNotificacion {
    void notificar(Prestador prestador, String mensaje);
}
