package domain.universidad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Materia {
    private List<Materia> correlativas;

    public Materia() {
        correlativas = new ArrayList<Materia>();
    }

    public List<Materia> getCorrelativas() {
        return correlativas;
    }

    public void setCorrelativas(Materia... correlativas) {
        Collections.addAll(this.correlativas, correlativas);
    }
}
