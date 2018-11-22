package fiuba.algo3.algoempires;

public class EstadoEdificioConstruyendose implements EstadoEdificio {

    @java.lang.Override
    public void reparar(Edificio unEdificio, int vida, Aldeano unAldeano) {
        throw new EdificioConstruyendoseException();
    }
    public void continuarReparacion (Edificio e, int i, Aldeano a){};

    public void recibirDanio(Edificio edificio, int danioRecibido){
        throw new EdificioConstruyendoseException();
    }
}
