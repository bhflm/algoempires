package fiuba.algo3.algoempires;

public class Mapa {
    private int LargoHorizontal;
    private int LargoVertical;

public Mapa(int DimensionHorizontal,int DimensionVertical){
    if(DimensionHorizontal<=0 || DimensionVertical<=0 )
        throw new DimensionInvalidaMapa();

    this.LargoHorizontal=DimensionHorizontal;
    this.LargoVertical=DimensionVertical;
}


    public int getLargoHorizontal() {
        return this.LargoHorizontal;
    }

    public int getLargoVertical() {
        return LargoVertical;
    }
}
