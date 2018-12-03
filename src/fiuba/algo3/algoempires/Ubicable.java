package fiuba.algo3.algoempires;

import fiuba.algo3.algoempires.Entidades.ArmaDeAsedio;
import fiuba.algo3.algoempires.Entidades.Arquero;
import fiuba.algo3.algoempires.Entidades.Castillo;
import fiuba.algo3.algoempires.Entidades.Espadachin;

public interface Ubicable {

 void actualizarUbicacion(Posicion pos);
 boolean esPisableEnElMapa();
 int getDimension();
 void recibirDanio(Arquero arquero);
 void recibirDanio(Castillo castillo);
 void recibirDanio(Espadachin espadachin);
 void recibirDanio(ArmaDeAsedio armaDeAsedio);
 String getNombre();

}