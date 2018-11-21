package fiuba.algo3.algoempires;

import java.util.HashMap;

public interface Ubicable {

 void actualizarUbicacion(Posicion pos);
 boolean esPisableEnElMapa();
 int getDimension();
 void recibirDanio(Arquero arquero);
 void recibirDanio(Castillo castillo);
}