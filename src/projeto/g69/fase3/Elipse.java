package projeto.g69.fase3;

/**
 * Elipse.
 *
 * @author G69 - 53741 Lívia Batalha, 56926 Lucas Pinto, 56941 Bruno Gonzalez;
 * @date 17 de dezembro de 2021.
 */
public class Elipse implements Direcionador {
    /**
     * Matriz de planetas
     */
    private CorpoCeleste[][] planetas;

    /**
     * Define o universo sobre o qual a LagartaVertical vai trabalhar
     * @param m Matriz Universo
     */
    @Override
    public void defineUniverso(CorpoCeleste[][] m) {
        this.planetas = m;
    }

    /**
     * Obtém o CorpoCeleste na posição n da matriz universo,
     *  conforme a estratégia de direcionamento implementada pelo direcionador
     * @param n Elemento a obter
     * @return o CorpoCeleste obtido
     * @requires n >= 0
     */
    @Override
    public CorpoCeleste nEsimoElemento(int n) {
        // No enunciado, n refere-se à posição, mas é usado como índice
        // Para tornar n num índice:
        // n--;

        // Esta implementação usa sucessões em escada (mas com sinal invertido a cada iteração)
        // e não volta ao início
        int metadeY = (this.planetas.length / 2) - 1;
        int metadeX = (this.planetas[0].length / 2) - 1;

        int lin = (metadeY + (int)(Math.pow((-1), n) * Math.floor((double)n/2)));
        int col = (metadeX + (int)(Math.pow((-1), n) * Math.floor((double)n/2)));

        // TODO voltar ao início
        // Bloquear a [0, qtdLinhas] e [0, qtdColunas]
        // Caso contrário dá index out of bounds
        lin = Math.max(Math.min(lin, this.planetas.length - 1), 0);
        col = Math.max(Math.min(col, this.planetas[0].length - 1), 0);

        return this.planetas[lin][col];
    }
}
