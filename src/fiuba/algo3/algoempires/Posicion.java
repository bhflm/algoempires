package fiuba.algo3.algoempires;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

public class Posicion {
    private int x;
    private int y;

    public Posicion(int CoordenadaX,int CoordenadaY){
        x=CoordenadaX;
        y=CoordenadaY;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Posicion posicion = (Posicion) o;

        if (x != posicion.x) return false;
        if (y != posicion.y) return false;

        return true;

    }
    public Posicion add(Posicion o){
        this.x += o.x;
        this.y += o.y;
        return this;
    }

    @Override
    public int hashCode() {
        int resultado = 7;
        resultado = 31 * resultado + this.x;
        resultado = 31 * resultado + this.y;
        return resultado;
    }


    public int getCoordenadaHorizontal() {
        return this.x;
    }

    public int getCoordenadaVertical() {
        return this.y;
    }

    public boolean ValidarPosicion(int largoHorizontal, int largoVertical) {
        boolean esValida=false;
        if(x>largoHorizontal || x<1 || y>largoVertical || y<1){
            throw new MovimientoFueraDelMapa();}
            else esValida=true;
            return esValida;
    }

    public boolean estaAlAlcance(Posicion posicionAtacable, int rangoDeAtaque) {
        int distancia=calcularDistanciaEntrePosiciones(posicionAtacable,this);
        boolean estaEnRango=false;
        if(distancia<=rangoDeAtaque)
            estaEnRango=true;
        return estaEnRango;

    }

    private int calcularDistanciaEntrePosiciones(Posicion posicion1, Posicion posicion2) {
        int distanciaHorizontal=abs(posicion1.x-posicion2.x);
        int distanciaVertical=abs(posicion1.y-posicion2.y);
        int distanciaEntrePosiciones=0;

        while(distanciaHorizontal>0 && distanciaVertical>0){
            distanciaHorizontal--;
            distanciaVertical--;
            distanciaEntrePosiciones++;
        }
        distanciaEntrePosiciones=distanciaEntrePosiciones+distanciaHorizontal+distanciaVertical;
        return distanciaEntrePosiciones;
    }

    public Posicion PosicionCorridaA(int i, int j) {
        Posicion posicionDesplazada=new Posicion(this.x+i,this.y+j);
        return posicionDesplazada;
    }
}
