package utn.frba.ejercicios_propuestos.pro_services.datos.repositorios;

import java.util.List;

import utn.frba.ejercicios_propuestos.pro_services.dominio.servicios.Servicio;

public class ServiciosRepositorio implements ICrudRepository<Servicio> {

    @Override
    public Servicio buscarTareaPorId(Long id) {
        Servicio servicioEncontrado = entityManager().find(Servicio.class, id);
        return servicioEncontrado;
    }

    @Override
    public List<Servicio> buscarTodos() {
        List<Servicio> serviciosEncontrados = entityManager()
                .createQuery("from " + Servicio.class.getName())
                .getResultList();
        return serviciosEncontrados;
    }
}