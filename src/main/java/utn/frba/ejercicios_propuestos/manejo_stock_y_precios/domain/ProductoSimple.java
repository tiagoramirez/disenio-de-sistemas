package utn.frba.ejercicios_propuestos.manejo_stock_y_precios.domain;

public class ProductoSimple extends Producto {
	private Integer stock;
	private Double precio;

	@Override
	public Integer obtenerStock() {
		return stock;
	}

	@Override
	public Double obtenerPrecio() {
		return precio;
	}
}