package ar.edu.unlp.info.oo2.facturacion_llamadas;

public class TipoPrimero extends TipoGenerador{

        @Override
        public String obtenerNumeroLibre(GestorNumerosDisponibles gestor) {
            String numero = gestor.getNumerosDisponibles().first();
            super.eliminarNumeroLibre(gestor, numero);
            return numero;
        }
}
