package utn.frba.ejercicios_propuestos.pro_services.datos.repositorios;

import utn.frba.ejercicios_propuestos.pro_services.dominio.servicios.Tarea;

public class Semilla {
    public static void ejecutar(){
        TareasRepositorio tareasRepositorio = new TareasRepositorio();
        Tarea nuevaTarea = new Tarea("Programacion", "Programo en varios lenguajes :D");
        Tarea nuevaTarea2 = new Tarea("Estudio", "Estudio Ingenieria en Sistemas en la mejor facu c:");
        tareasRepositorio.agregar(nuevaTarea);
        tareasRepositorio.agregar(nuevaTarea2);
    }
}
