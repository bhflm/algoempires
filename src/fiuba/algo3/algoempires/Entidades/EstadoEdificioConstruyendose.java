package fiuba.algo3.algoempires.Entidades;

import fiuba.algo3.algoempires.Excepciones.EdificioConstruyendoseException;

public class EstadoEdificioConstruyendose extends EstadoEdificio {

    @java.lang.Override
    public void reparar(Edificio unEdificio, int vida, Aldeano unAldeano) {
        unAldeano.desocupar();
        throw new EdificioConstruyendoseException();
    }

    Arquero crearArquero(){
        throw new EdificioConstruyendoseException();
    };
    Espadachin crearEspadachin(){ throw new EdificioConstruyendoseException();};
    Aldeano crearAldeano() {throw new EdificioConstruyendoseException();}
}
