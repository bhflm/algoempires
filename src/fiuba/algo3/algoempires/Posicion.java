package fiuba.algo3.algoempires;

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
}
