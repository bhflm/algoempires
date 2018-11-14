package fiuba.algo3.algoempires;

public class EstadoEdificioNormal implements EstadoEdificio{
    @Override
    public void reparar(Edificio unEdificio, int vidaReparada){
        if (unEdificio.tieneVidaCompleta()){
            throw new EdificioVidaMaximaException;
        }

        unEdificio.asignarReparacion();
        unEdificio.sumarVida(vidaReparada);
        unEdificio.terminarReparacion();
        }
    }
}
