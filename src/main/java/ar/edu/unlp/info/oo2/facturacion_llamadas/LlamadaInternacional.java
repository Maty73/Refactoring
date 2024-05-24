package ar.edu.unlp.info.oo2.facturacion_llamadas;

public class LlamadaInternacional extends Llamada{

    public LlamadaInternacional(String origen, String destino, int duracion) {
        super(origen, destino, duracion);
    }

    @Override
    public double calcularCosto(){
        return super.calcularCosto() + 50;
    }

    @Override
    public double getCostoPorSegundo(){
        return 150;
    }
}
