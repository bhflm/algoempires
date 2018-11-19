package fiuba.algo3.algoempires;

public class EstadoEdificioReparandose implements EstadoEdificio{
    @Override
    public void reparar(Edificio unEdificio, int vida, Aldeano unAldeano){
        unAldeano.desocupar();
        throw new EdificioReparandoseException();
    }
    public void continuarReparacion(Edificio unEdificio, int vidaReparada, Aldeano unAldeano){
        unEdificio.sumarVida(vidaReparada);
        if (unEdificio.getVida() >= unEdificio.getVidaMaxima()){
            unEdificio.setVida(unEdificio.getVidaMaxima());
            unAldeano.desocupar();
            unEdificio.terminarReparacion();
        }
    }

}
