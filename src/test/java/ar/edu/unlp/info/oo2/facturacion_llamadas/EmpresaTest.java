package ar.edu.unlp.info.oo2.facturacion_llamadas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmpresaTest {
	Empresa sistema;

	@BeforeEach
	public void setUp() {
		this.sistema = new Empresa();
		this.sistema.guia.agregarNumeroTelefono("2214444554");
		this.sistema.guia.agregarNumeroTelefono("2214444555");
		this.sistema.guia.agregarNumeroTelefono("2214444556");
		this.sistema.guia.agregarNumeroTelefono("2214444557");
		this.sistema.guia.agregarNumeroTelefono("2214444558");
		this.sistema.guia.agregarNumeroTelefono("2214444559");
	}

	@Test
	void testcalcularMontoTotalLlamadas() {
		Cliente emisorPersonaFisca = sistema.registrarClienteFisico("Brendan Eich", "11555666");
		Cliente remitentePersonaFisica = sistema.registrarClienteFisico("Doug Lea", "00000001");
		Cliente emisorPersonaJuridica = sistema.registrarClienteJuridico("Nvidia Corp", "17555222");
		Cliente remitentePersonaJuridica = sistema.registrarClienteJuridico("Sun Microsystems", "25765432");

		this.sistema.registrarLlamadaNacional(emisorPersonaJuridica, remitentePersonaFisica, 10);
		this.sistema.registrarLlamadaInternacional(emisorPersonaJuridica, remitentePersonaFisica, 8);
		this.sistema.registrarLlamadaNacional(emisorPersonaJuridica, remitentePersonaJuridica, 5);
		this.sistema.registrarLlamadaInternacional(emisorPersonaJuridica, remitentePersonaJuridica, 7);
		this.sistema.registrarLlamadaNacional(emisorPersonaFisca, remitentePersonaFisica, 15);
		this.sistema.registrarLlamadaInternacional(emisorPersonaFisca, remitentePersonaFisica, 45);
		this.sistema.registrarLlamadaNacional(emisorPersonaFisca, remitentePersonaJuridica, 13);
		this.sistema.registrarLlamadaInternacional(emisorPersonaFisca, remitentePersonaJuridica, 17);

		assertEquals(11454.64, emisorPersonaFisca.calcularMontoTotalLlamadas(), 0.01);
		assertEquals(2445.40, emisorPersonaJuridica.calcularMontoTotalLlamadas(), 0.01);
		assertEquals(0, remitentePersonaFisica.calcularMontoTotalLlamadas());
		assertEquals(0, remitentePersonaJuridica.calcularMontoTotalLlamadas());
	}

	@Test
	void testAgregarUsuario() {
		assertEquals(this.sistema.cantidadDeClientes(), 0);
		this.sistema.guia.agregarNumeroTelefono("2214444558");
		Cliente nuevaPersona = this.sistema.registrarClienteFisico("Alan Turing","2444555");

		assertEquals(1, this.sistema.cantidadDeClientes());
		assertTrue(this.sistema.existeCliente(nuevaPersona));
	}

	@Test
	void obtenerNumeroLibre() {
		// por defecto es el ultimo
		assertEquals("2214444559", this.sistema.obtenerNumeroLibre());

		this.sistema.getGestorNumeros().setTipoGenerador(new TipoPrimero());
		assertEquals("2214444554", this.sistema.obtenerNumeroLibre());

		this.sistema.getGestorNumeros().setTipoGenerador(new TipoRandom());
		assertNotNull(this.sistema.obtenerNumeroLibre());
	}
}
