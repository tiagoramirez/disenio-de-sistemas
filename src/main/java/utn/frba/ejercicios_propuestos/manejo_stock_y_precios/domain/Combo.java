package utn.frba.ejercicios_propuestos.manejo_stock_y_precios.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Combo extends Producto {
	private List<Producto> productos;

	public Combo() {
		productos = new ArrayList<Producto>();
	}

	@Override
	public Integer obtenerStock() {
		Integer stockMinimo = productos.get(0).obtenerStock();
		for (Producto producto : productos) {
			if (producto.obtenerStock() < stockMinimo)
				stockMinimo = producto.obtenerStock();
		}
		return stockMinimo;
	}

	@Override
	public Double obtenerPrecio() {
		Double precioFinal = 0.0;
		for (Producto producto : productos) {
			precioFinal += producto.obtenerPrecio();
		}
		return precioFinal;
	}

	public void agregarProductos(Producto... productos) {
		Collections.addAll(this.productos, productos);
	}
}