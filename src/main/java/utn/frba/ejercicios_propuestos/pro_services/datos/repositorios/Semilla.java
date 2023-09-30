package utn.frba.ejercicios_propuestos.pro_services.datos.repositorios;

import java.util.ArrayList;
import java.util.List;

import utn.frba.ejercicios_propuestos.pro_services.dominio.servicios.Servicio;
import utn.frba.ejercicios_propuestos.pro_services.dominio.servicios.Tarea;

public class Semilla {
    public static void ejecutar() {
        Tarea nuevaTarea = new Tarea("Limpiar baño", "Limpio mejor que nadie!!");
        Tarea nuevaTarea2 = new Tarea("Limpiar cocina", "Soy bastante rapido limpiando!");
        List<Tarea> nuevasTareas = new ArrayList<Tarea>();
        nuevasTareas.add(nuevaTarea);
        nuevasTareas.add(nuevaTarea2);
        Servicio nuevoServicio = new Servicio("Limpieza de hogar", nuevasTareas);
        ServiciosRepositorio sr = new ServiciosRepositorio();
        sr.agregar(nuevoServicio);
    }
}
