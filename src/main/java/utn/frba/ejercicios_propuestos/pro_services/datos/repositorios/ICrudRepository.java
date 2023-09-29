package utn.frba.ejercicios_propuestos.pro_services.datos.repositorios;

import java.util.List;

import javax.persistence.EntityTransaction;

import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;

public interface ICrudRepository<T> extends WithSimplePersistenceUnit {
    default void agregar(T nuevo) {
        EntityTransaction tx = entityManager().getTransaction();
        tx.begin();
        entityManager().persist(nuevo);
        tx.commit();
    }

    // default void agregarVarios(T... nuevos) {
    //     EntityTransaction tx = entityManager().getTransaction();
    //     tx.begin();
    //     for (T nuevo : nuevos) {
    //         entityManager().persist(nuevo);
    //     }
    //     tx.commit();
    // }

    public T buscarTareaPorId(Long id);

    public List<T> buscarTodos();

    default void modificar(T modificado) {
        EntityTransaction tx = entityManager().getTransaction();
        tx.begin();
        entityManager().merge(modificado);
        tx.commit();
    }

    default void eliminar(T eliminar) {
        EntityTransaction tx = entityManager().getTransaction();
        tx.begin();
        entityManager().remove(eliminar);
        tx.commit();
    }
}
