package utn.frba.ejercicios_propuestos.pro_services.dominio.main;

import java.util.List;

import javax.persistence.EntityTransaction;

import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;
import utn.frba.ejercicios_propuestos.pro_services.dominio.servicios.Tarea;

public class Main implements WithSimplePersistenceUnit {
    public static void main(String[] args) {
        Main main = new Main();
        main.start();
        List<Tarea> todasLasTareas = main.buscarTodasTareas();
        System.out.println(todasLasTareas);
        Tarea tareaEncontrada2 = main.buscarTareaPorId(Long.parseLong("2"));
        Tarea tareaEncontrada1 = main.buscarTareaPorNombre("Programacion");
        main.modificarDescripcionTarea(tareaEncontrada1, tareaEncontrada1.getDescripcion() + "!!!!!");
        main.eliminarTarea(tareaEncontrada2);
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
        System.out.println(tareaEncontrada);
        return tareaEncontrada;
    }

    private Tarea buscarTareaPorNombre(String nombreABuscar) {
        Tarea tareaEncontrada = (Tarea) entityManager()
                .createQuery("from " + Tarea.class.getName() + " where nombre = :nombre")
                .setParameter("nombre", nombreABuscar)
                .getSingleResult();
        System.out.println(tareaEncontrada);
        return tareaEncontrada;
    }

    private List<Tarea> buscarTodasTareas() {
        List<Tarea> tareasEncontradas = entityManager()
                .createQuery("from " + Tarea.class.getName())
                .getResultList();
        System.out.println(tareasEncontradas);
        return tareasEncontradas;
    }

    private void modificarDescripcionTarea(Tarea tarea, String descripcion) {
        tarea.setDescripcion(descripcion);
        EntityTransaction tx = entityManager().getTransaction();
        tx.begin();
        entityManager().merge(tarea);
        tx.commit();
    }

    private void eliminarTarea(Tarea tarea) {
        EntityTransaction tx = entityManager().getTransaction();
        tx.begin();
        entityManager().remove(tarea);
        tx.commit();
    }
}