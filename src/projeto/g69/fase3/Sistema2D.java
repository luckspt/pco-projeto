package projeto.g69.fase3;

import java.util.List;

/**
 * Sistema 2D.
 *
 * @author G69 - 53741 Lívia Batalha, 56926 Lucas Pinto, 56941 Bruno Gonzalez;
 * @date 17 de dezembro de 2021.
 */
public class Sistema2D extends AbstractSistemaSolar {
    private CorpoCeleste[][] matriz;
    private Direcionador direcionador;

    /**
     * Inicializa um Sistema2D
     * @param nome String nome do sistema
     * @param m CorpoCeleste[][] matriz universo
     * @param d Direcionador direcionador
     */
    public Sistema2D(String nome, CorpoCeleste[][] m, Direcionador d) {
        super(nome);
        this.matriz = m;
        this.direcionador = d;
        this.direcionador.defineUniverso(m);
    }

    /**
     * Número de elementos de Sistema2D
     * @return Número de elementos
     */
    public int quantosElementos() {
        return this.matriz.length * this.matriz[0].length;
    }

    /**
     * Obtém o CorpoCeleste na posição
     * @param n Número de ordem do corpo celeste
     * @return a quantidade de elementos
     */
    public CorpoCeleste getElemento(int n) {
        return this.direcionador.nEsimoElemento(n);
    }

    /**
     * Procura o BuracoNegro mais perto do CorpoCeleste
     * @param c CorpoCeleste a considerar
     * @return o BuracoNegro mais perto
     * @requires c != null
     */
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

    /**
     * Determina se os CorposCelestes nas posições aVisitar podem ser visitados
     * @param aVisitar CorposCelestes a visitar
     * @return true se podem ser visitados, false caso contrário
     * @requires aVisitar != null
     */
    public boolean podeVisitar(List<Integer> aVisitar) {
        if(!super.podeVisitar(aVisitar))
            return false;

        for (Integer n : aVisitar) {
            CorpoCeleste corpoCeleste = this.getElemento(n);
            if (corpoCeleste == null || (corpoCeleste instanceof BuracoNegro))
                return false;
        }

        return true;
    }

    /**
     * Representação do SistemaSolar em String
     * @return O nome do Sistema Solar
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nome: " + this.nome() + "\n");
        sb.append("Direcionador: " + this.direcionador.getClass().getSimpleName() + "\n");

        for (CorpoCeleste[] corpoCelestes : this.matriz) {
            for (CorpoCeleste corpoCeleste : corpoCelestes) {
                String val;
                if (corpoCeleste == null)
                    val = "null";
                else if (corpoCeleste instanceof BuracoNegro)
                    val = "B" + corpoCeleste.posicao();
                else
                    val = corpoCeleste.posicao().toString();

                // TODO representar melhor
                sb.append(
                        String.format("%-15s",
                                String.format("%" + (val.length() + (15 - val.length()) / 2) + "s",
                                        val )));
            }
            sb.append("\n");
        }

        return sb.deleteCharAt(sb.length() - 1).toString();
    }
}
