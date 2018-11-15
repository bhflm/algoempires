package fiuba.algo3.algoempires;

public class EstadoEdificioReparandose implements EstadoEdificio{
    @Override
    public void reparar(Edificio unEdificio, int vida, Aldeano unAldeano){
        unAldeano.desocupar();
        throw new EdificioReparandoseException();
    }
}
