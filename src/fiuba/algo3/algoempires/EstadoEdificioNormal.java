package fiuba.algo3.algoempires;

public class EstadoEdificioNormal extends EstadoEdificio{
    @Override
    public void reparar(Edificio unEdificio, int vidaReparada, Aldeano unAldeano){
        if (unEdificio.tieneVidaCompleta()){
            unAldeano.desocupar();
            throw new EdificioVidaMaximaException();
        }
        unEdificio.asignarReparacion();
        unEdificio.sumarVida(vidaReparada);
    }


}
