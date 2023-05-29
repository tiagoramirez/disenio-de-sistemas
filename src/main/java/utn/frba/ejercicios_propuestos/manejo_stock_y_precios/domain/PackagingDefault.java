package utn.frba.ejercicios_propuestos.manejo_stock_y_precios.domain;

public class PackagingDefault extends ProductoDecorado {
	private Double precio;

	public PackagingDefault(Producto producto, Double precio) {
		super(producto);
		this.precio = precio;
	}

	@Override
	public Integer obtenerStock() {
		return this.producto.obtenerStock();
	}

	@Override
	public Double obtenerPrecio() {
		return this.producto.obtenerPrecio() + precio;
	}
}