package utn.frba.ejercicios_propuestos.pro_services.datos.repositorios;

import java.util.List;

import utn.frba.ejercicios_propuestos.pro_services.dominio.servicios.Tarea;

public class TareasRepositorio implements ICrudRepository<Tarea> {

    @Override
    public Tarea buscarTareaPorId(Long id) {
        Tarea tareaEncontrada = entityManager().find(Tarea.class, id);
        return tareaEncontrada;
    }

    @Override
    public List<Tarea> buscarTodos() {
        List<Tarea> tareasEncontradas = entityManager()
                .createQuery("from " + Tarea.class.getName())
                .getResultList();
        return tareasEncontradas;    
    }

    public Tarea buscarTareaPorNombre(String nombre) {
        Tarea tareaEncontrada = (Tarea) entityManager()
                .createQuery("from " + Tarea.class.getName() + " where nombre = :nombre")
                .setParameter("nombre", nombre)
                .getSingleResult();
        return tareaEncontrada;
    }
}