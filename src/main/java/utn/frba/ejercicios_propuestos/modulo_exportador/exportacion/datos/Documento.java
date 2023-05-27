package utn.frba.ejercicios_propuestos.modulo_exportador.exportacion.datos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Documento implements Exportable {
	private Map<String, List<String>> datos = new HashMap<String, List<String>>();

	public void agregarDatos(String clave, String... valores) {
		List<String> valoresParaAgregar = new ArrayList<String>();
		Collections.addAll(valoresParaAgregar, valores);
		datos.put(clave, valoresParaAgregar);
	}

	@Override
	public Map<String, List<String>> datos() {
		return datos;
	}
}