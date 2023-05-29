package utn.frba.ejercicios_propuestos.manejo_stock_y_precios.domain;

import lombok.Getter;

public abstract class Producto {
	@Getter
	private String nombre;

	public abstract Integer obtenerStock();

	public abstract Double obtenerPrecio();
}