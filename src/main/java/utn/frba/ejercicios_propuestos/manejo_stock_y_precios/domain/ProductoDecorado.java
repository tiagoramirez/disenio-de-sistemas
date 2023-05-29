package utn.frba.ejercicios_propuestos.manejo_stock_y_precios.domain;

public abstract class ProductoDecorado extends Producto {
	protected Producto producto;

	public ProductoDecorado(Producto producto) {
		this.producto = producto;
	}
}