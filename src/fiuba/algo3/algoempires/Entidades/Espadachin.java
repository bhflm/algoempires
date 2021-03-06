package fiuba.algo3.algoempires.Entidades;

import fiuba.algo3.algoempires.Excepciones.AtaqueFueraDeRango;
import fiuba.algo3.algoempires.Movible;
import fiuba.algo3.algoempires.Posicion;
import fiuba.algo3.algoempires.Ubicable;

public class Espadachin extends Unidad implements Movible {

    public Espadachin() {
        vida = 100;
        costo = 50;
        origen = "Cuartel";
        this.estado=new EstadoEspadachinDisponible();
        this.PosicionUnidad=new Posicion(0,0);
        this.rangoDeAtaque = 1;
        this.Nombre="Espadachin";

    }

    public void actualizarUbicacion(Posicion pos){
        this.PosicionUnidad=pos;
    }

    public void RealizarMovimiento(Posicion nuevaPosicion){
        this.PosicionUnidad=nuevaPosicion;
    }
    public boolean esPisableEnElMapa(){return this.PisableEnElMapa;};

    public void atacarA(Ubicable unidadAtacada){
        try{unidadAtacada.recibirDanio(this);}
        catch(AtaqueFueraDeRango e){
            throw new AtaqueFueraDeRango();
        }

    }

}
