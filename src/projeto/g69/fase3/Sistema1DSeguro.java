package projeto.g69.fase3;

import java.util.ArrayList;
import java.util.List;

/**
 * Sistema 1D Seguro.
 *
 * @author G69 - 53741 Lívia Batalha, 56926 Lucas Pinto, 56941 Bruno Gonzalez;
 * @date 17 de dezembro de 2021.
 */
public class Sistema1DSeguro extends AbstractSistemaSolar {
    /**
     * Matriz de planetas
     */
    private CorpoCeleste[][] matriz;
    /**
     * Direcionador
     */
    private LinhaALinha direcionador;
    /**
     * A matriz de planetas sob forma linear
     */
    private List<CorpoCeleste> linear;

    /**
     * Inicializa um Sistema1DSeguro
     * @param nome String nome do sistema.
     * @param m CorpoCeleste[][] matriz universo.
     */
    public Sistema1DSeguro(String nome, CorpoCeleste[][] m) {
        this(nome, m, new LinhaALinha());
    }

    /**
     * Inicializa um Sistema1DSeguro com um direcionador
     * @param nome String nome do sistema.
     * @param m CorpoCeleste[][] matriz universo.
     * @param d Direcionador a ser utilizado.
     */
    public Sistema1DSeguro(String nome, CorpoCeleste[][] m, Direcionador d) {
        super(nome);
        this.matriz = m;
        this.direcionador = (LinhaALinha)d;
        this.direcionador.defineUniverso(m);

        this.linear = new ArrayList();
        this.defineLinear();
    }

    /**
     * Define a lista linear
     */
    private void defineLinear() {
        // TODO remover se o método não é usado em mais lado nenhum
        this.linear.clear();

        for (int i=0; i<this.quantosElementos(); i++) {
            CorpoCeleste corpoCeleste = this.getElemento(i);
            if (corpoCeleste != null && !(corpoCeleste instanceof BuracoNegro) )
                this.linear.add(corpoCeleste);
        }
    }

    /**
     * A quantidade de CorpoCelestes do sistema solar
     * @return a quantidade de CorpoCelestes
     */
    public int quantosElementos() {
        return this.matriz.length * this.matriz[0].length;
    }

    /**
     * Obtém o CorpoCeleste duma posição
     * @param n Número de ordem do corpo celeste
     * @return o CorpoCeleste obtido
     */
    public CorpoCeleste getElemento(int n) {
        return this.direcionador.nEsimoElemento(n);
    }

    /**
     * Descobrir qual buraco negro enconstra-se mais próximo de CorpoCeleste c.
     * @param c CorpoCeleste a considerar.
     * @return  buracoNegro mais próximo.
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
     * Representação do Sistema1DSeguro em String
     * @return a representação textual
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nome: " + this.nome() + "\n");
        sb.append("Planetas:\n");
        for (CorpoCeleste corpoCeleste : this.linear)
            sb.append(corpoCeleste.posicao() + " ");

        return sb.deleteCharAt(sb.length() - 1).toString();
    }

}
