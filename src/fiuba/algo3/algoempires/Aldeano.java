package fiuba.algo3.algoempires;

import java.util.HashMap;

public class Aldeano extends Unidad implements Ubicable{

    public Aldeano() {
        this.vida = 50;
        this.costo = 25;
        this.origen = "Plaza central";
    }


    public void UbicarEn(Posicion pos, HashMap<Posicion, Ubicable> Ubicaciones){
    Ubicaciones.put(pos,this);
    }



}

