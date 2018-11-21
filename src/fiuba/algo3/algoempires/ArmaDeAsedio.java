package fiuba.algo3.algoempires;

import java.util.HashMap;

public class ArmaDeAsedio extends Unidad implements Movible{

    public ArmaDeAsedio() {
        vida = 150;
        costo = 200;
        origen = "Castillo";
        this.estado=new EstadoArmaDeAsedioDisponible();
        this.PosicionUnidad=new Posicion(0,0);
        this.rangoDeAtaque = 5;
        this.puntosDeAtaqueEdificio = 10;

    }

    public void actualizarUbicacion(Posicion pos){
        this.PosicionUnidad=pos;
    }

    public void RealizarMovimiento(Posicion nuevaPosicion){
        this.PosicionUnidad=nuevaPosicion;
    }
    public boolean esPisableEnElMapa(){return this.PisableEnElMapa;};

    public void atacarA(Edificio edificio){
        Posicion posicionAtacable = edificio.getPosicion();
        Posicion posicionAtacante = this.PosicionUnidad;
        boolean esAtacable = false;
        boolean esAtacableDesde = false;
        int dim = edificio.getDimension();

        for(int i=0;i<dim;i++){
            for (int j=0;j<dim;j++){
                Posicion posicionDelAtacable = posicionAtacable.PosicionCorridaA(i,j);
                esAtacableDesde=posicionAtacante.estaAlAlcance(posicionDelAtacable,this.rangoDeAtaque);
                if(esAtacableDesde){
                    esAtacable=true;
                }
            }
        }
        if(esAtacable)
            edificio.recibirDanio(this.puntosDeAtaqueEdificio);
        else throw new AtaqueFueraDeRango();
    }
}
