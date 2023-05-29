package utn.frba.ejercicios_propuestos.manejo_stock_y_precios.domain;

import lombok.Getter;

public class ProductoSimple extends Producto {
	@Getter
	private String nombre;
	private Integer stock;
	private Double precio;

	public ProductoSimple(String nombre, Integer stock, Double precio) {
		this.nombre = nombre;
		this.stock = stock;
		this.precio = precio;
	}

	@Override
	public Integer obtenerStock() {
		return stock;
	}

	@Override
	public Double obtenerPrecio() {
		return precio;
	}
}