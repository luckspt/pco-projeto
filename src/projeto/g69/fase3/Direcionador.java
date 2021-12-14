package projeto.g69.fase3;

public interface Direcionador {
    /**
     * Define o universo sobre o qual o direcionador vai trabalhar
     * @param m Universo
     */
    void defineUniverso(CorpoCeleste[][] m);

    /**
     * Obtém o CorpoCeleste na posição n da matriz universo,
     *  de acordo com a estratégia de direcionamento implementada pelo direcionador
     * @param n Elemento a obter
     * @return O CorpoCeleste obtido
     */
    CorpoCeleste nEsimoElemento(int n);
}
