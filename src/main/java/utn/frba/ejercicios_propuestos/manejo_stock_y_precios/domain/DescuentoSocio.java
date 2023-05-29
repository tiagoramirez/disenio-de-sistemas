package utn.frba.ejercicios_propuestos.manejo_stock_y_precios.domain;

public class DescuentoSocio extends ProductoDecorado {
	private Double valor;

	public DescuentoSocio(Producto producto) {
		super(producto);
	}

	@Override
	public Integer obtenerStock() {
		return producto.obtenerStock();
	}

	@Override
	public Double obtenerPrecio() {
		return producto.obtenerPrecio() * obtenerMultiplicadorDescuento();
	}

	private Double obtenerMultiplicadorDescuento() {
		return (100 - valor) / 100;
	}
}