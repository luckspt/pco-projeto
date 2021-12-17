package projeto.g69.fase3;

public class LagartaVertical implements Direcionador {
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
     * @return O CorpoCeleste obtido
     */
    @Override
    public CorpoCeleste nEsimoElemento(int n) {
        // No enunciado, n refere-se à posição, mas é usado como índice
        // Para tornar n num índice:
        // n--;

        int lin = (n / this.planetas.length) % this.planetas[0].length;
        int col = (n / this.planetas[0].length) % this.planetas.length;

        // Movimento lagarta: se a o indice da linha for ímpar o sentido é inverso
        if (col % 2 != 0)
            lin = this.planetas.length - lin - 1;

        return this.planetas[lin][col];
    }
}
