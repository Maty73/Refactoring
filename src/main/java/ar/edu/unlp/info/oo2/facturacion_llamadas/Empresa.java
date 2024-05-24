package ar.edu.unlp.info.oo2.facturacion_llamadas;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
	private List<Cliente> clientes = new ArrayList<Cliente>();
	GestorNumerosDisponibles guia = new GestorNumerosDisponibles();

	public String obtenerNumeroLibre() {
		return guia.obtenerNumeroLibre();
	}

	public ClienteJuridico registrarClienteJuridico(String nombre, String cuit) {
		String tel = this.obtenerNumeroLibre();
		ClienteJuridico var = new ClienteJuridico(nombre, tel, cuit);
		clientes.add(var);
		return var;
	}

	public ClienteFisico registrarClienteFisico(String nombre, String dni) {
		String tel = this.obtenerNumeroLibre();
		ClienteFisico var = new ClienteFisico(nombre, tel, dni);
		clientes.add(var);
		return var;
	}

	public LlamadaNacional registrarLlamadaNacional(Cliente origen, Cliente destino, int duracion) {
		LlamadaNacional llamada = new LlamadaNacional(origen.getNumeroTelefono(), destino.getNumeroTelefono(), duracion);
		origen.agregarLlamada(llamada);
		return llamada;
	}

	public LlamadaInternacional registrarLlamadaInternacional(Cliente origen, Cliente destino, int duracion) {
		LlamadaInternacional llamada = new LlamadaInternacional(origen.getNumeroTelefono(), destino.getNumeroTelefono(), duracion);
		origen.agregarLlamada(llamada);
		return llamada;
	}

	public int cantidadDeClientes() {
		return clientes.size();
	}

	public boolean existeCliente(Cliente persona) {
		return clientes.contains(persona);
	}

	public GestorNumerosDisponibles getGestorNumeros() {
		return this.guia;
	}
}
