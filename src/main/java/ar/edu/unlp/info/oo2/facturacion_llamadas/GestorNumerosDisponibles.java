package ar.edu.unlp.info.oo2.facturacion_llamadas;

import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Random;
import java.util.SortedSet;

public class GestorNumerosDisponibles {
	private SortedSet<String> numerosDisponibles = new TreeSet<String>();
	private TipoGenerador tipoGenerador;


	public GestorNumerosDisponibles() {
		this.tipoGenerador = new TipoUltimo();
	}

	public GestorNumerosDisponibles(TipoGenerador tipoGenerador) {
		this.tipoGenerador = tipoGenerador;
	}

	public void setTipoGenerador(TipoGenerador tipoGenerador) {
		this.tipoGenerador = tipoGenerador;
	}

	public SortedSet<String> getNumerosDisponibles() {
		return numerosDisponibles;
	}

	public String obtenerNumeroLibre() {
		return this.tipoGenerador.obtenerNumeroLibre(this);
	}

	public boolean agregarNumeroTelefono(String str) {
		return getNumerosDisponibles().add(str);
	}
}
