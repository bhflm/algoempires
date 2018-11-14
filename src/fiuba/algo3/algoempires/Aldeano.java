package fiuba.algo3.algoempires;

import java.util.HashMap;

public class Aldeano extends Unidad implements Ubicable{

    public Aldeano() {
        this.vida = 50;
        this.costo = 25;
        this.origen = "Plaza central";
    }


   // public void construir(Edificio unEdificio) {
        // plaza central o un cuartel ? a
   // };
    public void UbicarEn(Posicion PosicionAldeano, HashMap<Posicion, Ubicable> Ubicaciones){
    Ubicaciones.put(PosicionAldeano,this);

    }
}

