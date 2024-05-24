package ar.edu.unlp.info.oo2.facturacion_llamadas;

public abstract class TipoGenerador {

    public abstract String obtenerNumeroLibre(GestorNumerosDisponibles gestor);

    public void eliminarNumeroLibre(GestorNumerosDisponibles gestor, String numero){
        gestor.getNumerosDisponibles().remove(numero);
    }

}
