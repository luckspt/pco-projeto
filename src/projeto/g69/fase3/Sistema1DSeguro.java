package projeto.g69.fase3;

import java.util.List;

public class Sistema1DSeguro extends AbstractSistemaSolar {
    private CorpoCeleste[][] matriz;
    private LinhaALinha direcionador;
    private List<CorpoCeleste> linear;

    public Sistema1DSeguro(String nome, CorpoCeleste[][] m, Direcionador d) {
        super(nome);
        this.matriz = m;
        this.direcionador = (LinhaALinha)d;
        this.direcionador.defineUniverso(m);
        this.defineLinear();
    }

    private void defineLinear() {
        // TODO remover se o método não é usado em mais lado nenhum
        this.linear.clear();

        for (int i=0; i<this.quantosElementos(); i++) {
            CorpoCeleste corpoCeleste = this.getElemento(i);
            if (corpoCeleste != null && !(corpoCeleste instanceof BuracoNegro) )
                this.linear.add(corpoCeleste);
        }
    }

    public int quantosElementos() {
        return this.matriz.length * this.matriz[0].length;
    }

    public CorpoCeleste getElemento(int n) {
        return this.direcionador.nEsimoElemento(n);
    }

    public BuracoNegro buracoNegroMaisPerto(CorpoCeleste c) {
        int linMin = 0,
            colMin = 0;
        Double distanciaMin = null;

        for (int lin=0; lin<this.matriz.length; lin++) {
            for (int col=0; col<this.matriz[lin].length; col++) {
                CorpoCeleste corpoCeleste = this.matriz[lin][col];
                if (corpoCeleste instanceof BuracoNegro) {
                    double distancia = corpoCeleste.distancia(c);
                    if (distanciaMin == null || distancia < distanciaMin) {
                        linMin = lin;
                        colMin = col;
                        distanciaMin = distancia;
                    }
                }
            }
        }

        // linMin e colMin começam a 0, e pode haver 0 BuracoNegro's na matriz
        // portanto é melhor confirmar que é um buraco negro
        CorpoCeleste buracoNegro = this.matriz[linMin][colMin];
        return (buracoNegro instanceof BuracoNegro)
                ? (BuracoNegro) buracoNegro
                : null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nome: " + this.nome() + "\n");
        sb.append("Planetas:\n");
        for (CorpoCeleste corpoCeleste : this.linear)
            sb.append(corpoCeleste.toString() + " ");

        return sb.toString();
    }

}
