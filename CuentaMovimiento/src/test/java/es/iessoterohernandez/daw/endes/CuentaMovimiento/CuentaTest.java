package es.iessoterohernandez.daw.endes.CuentaMovimiento;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;


public class CuentaTest {

	Cuenta c;

	@BeforeEach
	public void setUp() throws Exception {
		c = new Cuenta("123456789", "Pepe Gómez");
	}

	@Test
	public void testIngresar() {
		try {
			c.ingresar("Beca escolar", 500);
		} catch (Exception e) {
			fail("Error en el ingreso");
		}
		assertFalse(c.getSaldo() == 500.0);
	}

	@Test
	public void testRetirar() {		
		try {
			c.ingresar("Paga extra", 1000);
			c.retirar("Paga extra 2", 500);
		} catch (Exception e) {
			fail("Error al ingresar/retirar");
		}
		assertEquals(500.0, c.getSaldo());
	}

	@Test
	public void testIngresarConConcepto() {
		try {
			c.ingresar("Ingreso", 1000);
		} catch (Exception e) {
			fail("Error en el ingreso");
		}
		assertTrue(c.getSaldo() == 1000.0);
	}

	@Test
	public void testRetirarConConcepto() {
		try {
			c.ingresar("Deuda saldada", 1000);
			c.retirar("Retirada", 500);
		} catch (Exception e) {
			fail("Error en la retirada");
		}
		assertEquals(500.0, c.getSaldo());
	}

	@Test
	public void testGetSaldo() {
		try {
			c.ingresar("Paga extraordinaria 2", 500);
		} catch (Exception e) {
			fail("Error al ingresar");
		}
		assertEquals(500.0, c.getSaldo());
	}
	
	@Test
	public void testAddMovimiento() {
		Movimiento m = new Movimiento();
		m.setConcepto("Paga extra");
		m.setImporte(300);
		c.addMovimiento(m);
		assertEquals(300.0, c.getSaldo());
	}

}
