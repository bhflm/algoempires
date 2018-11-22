package fiuba.algo3.algoempires;

public interface Atacante {

    void atacarA(Ubicable unidadAtacada);

    public Posicion getPosicion();
    public int getRangoDeAtaque();
}
