package fiuba.algo3.algoempires.Entidades;

import fiuba.algo3.algoempires.ExcepcionesEdificios.EdificioReparandoseException;

public class EstadoEdificioReparandose extends EstadoEdificio{
    @Override
    public void reparar(Edificio unEdificio, int vida, Aldeano unAldeano){
        unAldeano.desocupar();
        throw new EdificioReparandoseException();
    }
    public void continuarReparacion(Edificio unEdificio, int vidaReparada, Aldeano unAldeano){
        if (unEdificio.getVida() >= unEdificio.getVidaMaxima()){
            unAldeano.desocupar();
            unEdificio.terminarReparacion();
        }
        unEdificio.sumarVida(vidaReparada);
    }

}
