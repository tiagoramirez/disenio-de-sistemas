package utn.frba.ejercicios_propuestos.modulo_exportador.exportacion.estrategias.excel;

import java.util.List;
import java.util.Map;

import utn.frba.ejercicios_propuestos.modulo_exportador.exportacion.datos.Exportable;
import utn.frba.ejercicios_propuestos.modulo_exportador.exportacion.estrategias.Exportador;

public class ExportarExcel implements Exportador {
	@Override
	public String exportar(Exportable exportable) {
		Map<String, List<String>> datos = exportable.datos();
		for (Map.Entry<String, List<String>> entry : datos.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
		return "(" + datos.size() + ") Exportado datos a Excel...";
	}
}