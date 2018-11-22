package fiuba.algo3.algoempires;

public class LimpiadorDeUnidadesMapa  {

    public void limpiarCelda (Mapa unMapa, Unidad unaUnidad){
        if (unaUnidad.estaMuerto()){
            Posicion posUnidad = unaUnidad.getPosicion();
            Posicion estaMuerto = null;
            unaUnidad.modificarPosicion(estaMuerto);
            unMapa.resetearPosicion(posUnidad);
        }
    }


}
