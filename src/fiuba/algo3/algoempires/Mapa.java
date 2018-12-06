package fiuba.algo3.algoempires;
import fiuba.algo3.algoempires.Excepciones.DimensionInvalidaMapa;
import fiuba.algo3.algoempires.Excepciones.UbicacionFueraDelMapaException;
import fiuba.algo3.algoempires.Excepciones.UbicacionOcupadaPorOtraUnidad;
import fiuba.algo3.algoempires.Excepciones.MovimientoFueraDelMapa;

import java.util.HashMap;

public class Mapa {
    private int LargoHorizontal;
    private int LargoVertical;
    private HashMap<Posicion, Ubicable> Ubicaciones;

public Mapa(int DimensionHorizontal,int DimensionVertical){
    if(DimensionHorizontal<=0 || DimensionVertical<=0 )
        throw new DimensionInvalidaMapa();

    this.LargoHorizontal=DimensionHorizontal;
    this.LargoVertical=DimensionVertical;
    this.Ubicaciones=new HashMap<Posicion, Ubicable>();
    this.GenerarPosiciones();;
}
private void GenerarPosiciones(){
    int i;
    int j;
    Ubicable EspacioDesocupado = new EspacioLibre();

    for (i=1;i<=LargoHorizontal;i++) {
        for (j = 1; j <= LargoVertical; j++) {

            Posicion PosicionIJ = new Posicion(i,j);
            this.Ubicaciones.put(PosicionIJ,EspacioDesocupado);
        }
   }
}

    public void UbicarUnidadEnMapa(Posicion PosicionUnidad,Ubicable Unidad){
    int dimension = Unidad.getDimension() - 1;
    int CoordHorizontal = PosicionUnidad.getCoordenadaHorizontal();
    int CoordVertical = PosicionUnidad.getCoordenadaVertical();
    if (CoordHorizontal + dimension > this.LargoHorizontal || CoordVertical + dimension > this.LargoVertical){
            throw new UbicacionFueraDelMapaException();}


        Ubicable UbicableEnLaNuevaPosicion=this.Ubicaciones.get(PosicionUnidad);

        for (int i = 0; i < dimension+1; i++){
            for (int j = 0; j < dimension+1; j++){
                Posicion posicionActual = new Posicion(CoordHorizontal+i, CoordVertical+j);
                UbicableEnLaNuevaPosicion=this.Ubicaciones.get(posicionActual);
                if(UbicableEnLaNuevaPosicion.esPisableEnElMapa()==false){
                    throw new UbicacionOcupadaPorOtraUnidad();}
                Ubicaciones.put(posicionActual, Unidad);
            }
        }

        Ubicaciones.put(PosicionUnidad,Unidad);
        Unidad.actualizarUbicacion(PosicionUnidad);

    }

    public int getLargoHorizontal() {
        return this.LargoHorizontal;
    }

    public int getLargoVertical() {
        return LargoVertical;
    }

    public HashMap<Posicion, Ubicable> getUbicaciones(){return Ubicaciones;}

    public Ubicable GetUbicableEn(Posicion posicionAldeano) {

    return Ubicaciones.get(posicionAldeano);
    }

    public void MoverUnidad(Posicion nuevaPosicion, Movible unidadAMover){
    try{
        nuevaPosicion.ValidarPosicion(LargoHorizontal,LargoVertical);
    }
    catch(MovimientoFueraDelMapa e){
        throw new MovimientoFueraDelMapa();
    }
    Ubicable UbicableEnLaNuevaPosicion=this.Ubicaciones.get(nuevaPosicion);
    if(UbicableEnLaNuevaPosicion.esPisableEnElMapa()==false){
        throw new UbicacionOcupadaPorOtraUnidad();}
    Posicion posicionPrevia= unidadAMover.getPosicion();
    Ubicable ubicacionLiberada=new EspacioLibre();
    this.Ubicaciones.put(nuevaPosicion,unidadAMover);

        UbicableEnLaNuevaPosicion=unidadAMover;
    unidadAMover.RealizarMovimiento(nuevaPosicion);
    this.Ubicaciones.put(posicionPrevia,ubicacionLiberada);
    }

}
