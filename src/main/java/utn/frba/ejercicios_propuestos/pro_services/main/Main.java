package utn.frba.ejercicios_propuestos.pro_services.main;

import java.util.List;

import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;
import utn.frba.ejercicios_propuestos.pro_services.datos.repositorios.Semilla;
import utn.frba.ejercicios_propuestos.pro_services.datos.repositorios.TareasRepositorio;
import utn.frba.ejercicios_propuestos.pro_services.dominio.servicios.Tarea;

public class Main implements WithSimplePersistenceUnit {
    public static void main(String[] args) {
        System.out.println("Empezando...");
        Semilla.ejecutar();
        TareasRepositorio tr = new TareasRepositorio();
        List<Tarea> tareasEncontradas = tr.buscarTodos();
        for (Tarea tarea : tareasEncontradas) {
            System.out.println("TAREA ENCONTRADA: " + tarea);
        }
    }
}