package projeto.g69.fase3;

public class Elipse implements Direcionador {
    private CorpoCeleste[][] universo;
    private CorpoCeleste index;

    public Elipse(CorpoCeleste[][] m, CorpoCeleste n){
        this.universo = m;
        this.index = n;
    }

    @Override
    public CorpoCeleste nEsimoElemento(int n) {
        return null;
    }

    @Override
    public void defineUniverso(CorpoCeleste[][] m) {

    }
}
