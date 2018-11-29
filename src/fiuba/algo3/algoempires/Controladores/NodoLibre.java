package fiuba.algo3.algoempires.Controladores;

import fiuba.algo3.algoempires.EspacioLibre;
import javafx.scene.Node;

public abstract class NodoLibre extends Node {
    EspacioLibre espacio;

    int a = 4;

    public NodoLibre() {
        espacio = new EspacioLibre();
    }

}
