package ar.edu.unlp.info.oo2.facturacion_llamadas;

import java.util.ArrayList;
import java.util.List;

public abstract class Cliente {
	private List<Llamada> llamadas = new ArrayList<Llamada>();
	private String nombre;
	private String numeroTelefono;

	public Cliente(String nombre, String numeroTelefono) {
		this.nombre = nombre;
		this.numeroTelefono = numeroTelefono;
	}

	public abstract double calcularDescuento(double costo);

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNumeroTelefono() {
		return numeroTelefono;
	}

	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}

	public List<Llamada> getLlamadas() {
		return llamadas;
	}

	public double calcularMontoTotalLlamadas() {
		return getLlamadas().stream().mapToDouble(l -> this.calcularDescuento(l.calcularCosto())).sum();
	}

	public void agregarLlamada(Llamada llamada) {
		this.getLlamadas().add(llamada);
	}
}
