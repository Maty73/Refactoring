package ar.edu.unlp.info.oo2.facturacion_llamadas;

public class TipoUltimo extends TipoGenerador{

    @Override
    public String obtenerNumeroLibre(GestorNumerosDisponibles gestor) {
           String numero = gestor.getNumerosDisponibles().last();
           super.eliminarNumeroLibre(gestor, numero);
           return numero;
    }
}
