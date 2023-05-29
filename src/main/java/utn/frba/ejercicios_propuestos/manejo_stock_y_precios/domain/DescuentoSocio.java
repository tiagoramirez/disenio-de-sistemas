package utn.frba.ejercicios_propuestos.manejo_stock_y_precios.domain;

public class DescuentoSocio extends ProductoDecorado {
	private Double descuento;

	public DescuentoSocio(Producto producto, Double descuento) {
		super(producto);
		this.descuento = descuento;
	}

	@Override
	public Integer obtenerStock() {
		return producto.obtenerStock();
	}

	@Override
	public Double obtenerPrecio() {
		return producto.obtenerPrecio() - descuento;
	}
}