package projeto.g69.fase3;

/**
 * Direcionador.
 *
 * @author G69 - 53741 Lívia Batalha, 56926 Lucas Pinto, 56941 Bruno Gonzalez;
 * @date 17 de dezembro de 2021.
 */
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
     * @return o CorpoCeleste obtido
     */
    CorpoCeleste nEsimoElemento(int n);
}
