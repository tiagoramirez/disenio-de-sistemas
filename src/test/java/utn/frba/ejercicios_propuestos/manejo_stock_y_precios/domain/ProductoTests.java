package utn.frba.ejercicios_propuestos.manejo_stock_y_precios.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductoTests {
	private ProductoSimple guantes;
	private ProductoSimple casco;
	private ProductoSimple chaleco;
	private ProductoSimple piloto;
	private Combo comboBasico;
	private Combo comboPremium;

	@BeforeEach
	public void init() {
		guantes = new ProductoSimple("guantes", 10, 600.00);

		casco = new ProductoSimple("Casco", 4, 1200.00);

		chaleco = new ProductoSimple("Chaleco", 7, 400.00);

		piloto = new ProductoSimple("Piloto", 1, 500.00);

		comboBasico = new Combo();
		comboBasico.agregarProductos(guantes, casco, chaleco);

		comboPremium = new Combo();
		comboPremium.agregarProductos(comboBasico, piloto);
	}

	@Test
	public void comboBasicoVale2200Test() {
		assertEquals(2200, comboBasico.obtenerPrecio(), 0.0);
	}

	@Test
	public void comboPremiumVale2700Test() {
		assertEquals(2700, comboPremium.obtenerPrecio(), 0.0);
	}

	@Test
	public void comboBasicoConDescuentoVale2000Test() {
		ProductoDecorado descuentoDe200pe = new DescuentoSocio(comboBasico, 200.00);
		assertEquals(2000, descuentoDe200pe.obtenerPrecio(), 0.0);
	}

	@Test
	public void chalecoConPackagingVale500Test() {
		ProductoDecorado caja = new PackagingDefault(chaleco, 100.00);
		assertEquals(500, caja.obtenerPrecio(), 0.0);
	}

	@Test
	public void premiumConDescuentoYPackagingVale2400() {
		ProductoDecorado descuentoDe500Pe = new DescuentoSocio(comboPremium, 500.00);
		ProductoDecorado cajon = new PackagingDefault(descuentoDe500Pe, 200.00);
		assertEquals(2400.00, cajon.obtenerPrecio(), 0.0);
	}

	@Test
	public void basicoStockEs4() {
		assertEquals(4, comboBasico.obtenerStock());
	}

	@Test
	public void premiumStockEs1() {
		assertEquals(1, comboPremium.obtenerStock());
	}
}