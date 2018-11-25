package fiuba.algo3.algoempires;

public interface Atacante {

    void atacarA(Unidad unidadAtacada);
    void atacarA(Edificio edificioAtacado);
    public Posicion getPosicion();
    public int getRangoDeAtaque();
    public int getPuntosDeAtaqueUnidad();
    public int getPuntosDeAtaqueEdificio();
}
