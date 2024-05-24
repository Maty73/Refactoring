package ar.edu.unlp.info.oo2.facturacion_llamadas;

import java.util.ArrayList;
import java.util.Random;

public class TipoRandom extends TipoGenerador{

        @Override
        public String obtenerNumeroLibre(GestorNumerosDisponibles gestor) {
            String numero = new ArrayList<String>(gestor.getNumerosDisponibles())
                    .get(new Random().nextInt(gestor.getNumerosDisponibles().size()));
            super.eliminarNumeroLibre(gestor, numero);
            return numero;
        }
}
