package fiuba.algo3.algoempires;
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
        Unidad.UbicarEn(PosicionUnidad,this.Ubicaciones);
    }

    public int getLargoHorizontal() {
        return this.LargoHorizontal;
    }

    public int getLargoVertical() {
        return LargoVertical;
    }


    public Ubicable GetUbicableEn(Posicion posicionAldeano) {

    return Ubicaciones.get(posicionAldeano);
    }

    public void MoverUnidad(Posicion nuevaPosicion,Movible unidadAMover){

    try{
        nuevaPosicion.ValidarPosicion(LargoHorizontal,LargoVertical);
    }
    catch(MovimientoFueraDelMapa e){
        throw new MovimientoFueraDelMapa();
    }
    Posicion posicionPrevia= unidadAMover.getPosicion();
    Ubicable ubicacionLiberada=new EspacioLibre();
    this.Ubicaciones.put(nuevaPosicion,unidadAMover);
    unidadAMover.RealizarMovimiento(nuevaPosicion);
    this.Ubicaciones.put(posicionPrevia,ubicacionLiberada);
    }

}
