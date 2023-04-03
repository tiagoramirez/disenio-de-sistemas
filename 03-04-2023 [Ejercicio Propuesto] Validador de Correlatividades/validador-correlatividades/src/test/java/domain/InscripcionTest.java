package domain;

import org.junit.Assert;
import org.junit.Test;

import domain.persona.Alumno;
import domain.universidad.Inscripcion;
import domain.universidad.Materia;

public class InscripcionTest {

    @Test
    public void cumpleCorrelatividades() {
        Materia aga = new Materia();
        Materia am1 = new Materia();
        Materia am2 = new Materia();
        am2.setCorrelativas(aga, am1);

        Materia pdep = new Materia();
        Materia ads = new Materia();
        Materia ssl = new Materia();
        Materia dds = new Materia();
        dds.setCorrelativas(pdep, ads, ssl);

        Alumno yo = new Alumno();
        yo.setMateriasAprobadas(aga,am1,pdep,ads,ssl);

        Inscripcion anio2023=new Inscripcion(yo);
        anio2023.setMaterias(am2,dds);

        Assert.assertEquals(true, anio2023.aprobada());
    }

    @Test
    public void noCumpleCorrelatividades() {
        Materia aga = new Materia();
        Materia am1 = new Materia();
        Materia am2 = new Materia();
        am2.setCorrelativas(aga, am1);

        Materia pdep = new Materia();
        Materia ads = new Materia();
        Materia ssl = new Materia();
        Materia dds = new Materia();
        dds.setCorrelativas(pdep, ads, ssl);

        Alumno yo = new Alumno();
        yo.setMateriasAprobadas(aga,pdep,ads,ssl);

        Inscripcion anio2023=new Inscripcion(yo);
        anio2023.setMaterias(am2,dds);

        Assert.assertEquals(false, anio2023.aprobada());
    }
}
