package fiuba.algo3.algoempires;

import java.util.HashMap;

public class Arquero extends Unidad implements Movible,Atacante{

    public Arquero() {
        vida = 75;
        costo = 75;
        origen = "Cuartel";
        this.estado=new EstadoArqueroDisponible();
        this.PosicionUnidad=new Posicion(0,0);
        this.rangoDeAtaque = 3;
        this.puntosDeAtaqueUnidad = 15;
        this.puntosDeAtaqueEdificio = 10;
    }

    public void actualizarUbicacion(Posicion pos){
        this.PosicionUnidad=pos;
    }

    public void RealizarMovimiento(Posicion nuevaPosicion){
        this.PosicionUnidad=nuevaPosicion;
    }
    public boolean esPisableEnElMapa(){return this.PisableEnElMapa;};



    public void atacarA(Unidad unidadAtacada){
        Posicion posicionAtacable = unidadAtacada.getPosicion();
        Posicion posicionAtacante = this.PosicionUnidad;
        boolean esAtacable = posicionAtacante.estaAlAlcance(posicionAtacable,this.rangoDeAtaque);
        if(esAtacable)
            unidadAtacada.recibirDanio(this.puntosDeAtaqueUnidad);


        else throw new AtaqueFueraDeRango();
    }

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
                if(esAtacableDesde){ esAtacable=true;}
            }
        }
        if(esAtacable)
            edificio.recibirDanio(this.puntosDeAtaqueEdificio);
        else throw new AtaqueFueraDeRango();
    }
}
