package projeto.g69.fase3;

/**
 * Lagarta vertical.
 *
 * @author G69 - 53741 Lívia Batalha, 56926 Lucas Pinto, 56941 Bruno Gonzalez;
 * @date 17 de dezembro de 2021.
 */
public class LagartaVertical implements Direcionador {
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
     */
    @Override
    public CorpoCeleste nEsimoElemento(int n) {
        System.out.println("vertical");
        // No enunciado, n refere-se à posição, mas é usado como índice
        // Para tornar n num índice:
        // n--;

        int lin = n % this.planetas.length;
        int col = (n / this.planetas.length) % this.planetas[0].length;

        // Movimento lagarta: se a o indice da linha for ímpar o sentido é inverso
        if (col % 2 != 0)
            lin = this.planetas.length - lin - 1;

        return this.planetas[lin][col];
    }
}
