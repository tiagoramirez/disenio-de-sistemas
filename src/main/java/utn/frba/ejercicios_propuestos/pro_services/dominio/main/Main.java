package utn.frba.ejercicios_propuestos.pro_services.dominio.main;

import javax.persistence.EntityTransaction;

import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;
import utn.frba.ejercicios_propuestos.pro_services.dominio.servicios.Tarea;

public class Main implements WithSimplePersistenceUnit {
    public static void main(String[] args) {
        Main main = new Main();
        main.start();
        Tarea tareaEncontrada = main.buscarTareaPorId(Long.parseLong("2"));
        System.out.println(tareaEncontrada);
    }

    private void start() {
        Tarea nuevaTarea = new Tarea("Programacion", "Programo en varios lenguajes :D");
        Tarea nuevaTarea2 = new Tarea("Estudio", "Estudio Ingenieria en Sistemas en la mejor facu c:");
        EntityTransaction tx = entityManager().getTransaction();
        tx.begin();
        entityManager().persist(nuevaTarea);
        entityManager().persist(nuevaTarea2);
        tx.commit();
    }

    private Tarea buscarTareaPorId(Long id) {
        Tarea tareaEncontrada = entityManager().find(Tarea.class, id);
        return tareaEncontrada;
    }

}
