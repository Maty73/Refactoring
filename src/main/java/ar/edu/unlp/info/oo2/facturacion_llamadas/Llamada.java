package ar.edu.unlp.info.oo2.facturacion_llamadas;

public abstract class Llamada {
    private String clienteOrigen;
    private String clienteDestino;
    private int duracion;

    public Llamada(String origen, String destino, int duracion) {
        this.clienteOrigen = origen;
        this.clienteDestino = destino;
        this.duracion = duracion;
    }

    public double calcularCosto() {
        return this.getDuracion() * this.getCostoPorSegundo() + this.getDuracion() * this.getCostoPorSegundo() * 0.21;

    }

    public abstract double getCostoPorSegundo();

	public String getClienteOrigen() {
		return clienteOrigen;
	}

	public void setClienteOrigen(String clienteOrigen) {
		this.clienteOrigen = clienteOrigen;
	}

	public String getClienteDestino() {
		return clienteDestino;
	}

	public void setClienteDestino(String clienteDestino) {
		this.clienteDestino = clienteDestino;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
}

