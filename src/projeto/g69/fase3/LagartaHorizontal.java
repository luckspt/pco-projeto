package projeto.g69.fase3;

public class LagartaHorizontal implements Direcionador {
    private CorpoCeleste[][] planetas;

    /**
     * Define o universo sobre o qual o direcionador vai trabalhar
     * @param m Universo
     */
    @Override
    public void defineUniverso(CorpoCeleste[][] m) {
        this.planetas = m;
    }

    /**
     * Obtém o CorpoCeleste na posição n da matriz universo,
     * conforme a estratégia de direcionamento implementada pelo direcionador
     * @param n Elemento a obter
     * @return O CorpoCeleste obtido
     */
    @Override
    public CorpoCeleste nEsimoElemento(int n) {
        // No enunciado, n refere-se à posição, mas é usado como índice
        // Para tornar n num índice:
        // n--;

        int lin = (n / this.planetas[0].length) % this.planetas.length;
        int col = n % this.planetas[0].length;

        // Movimento lagarta: se a o indice da linha for ímpar o sentido é inverso
        if (lin % 2 != 0)
            col = this.planetas[0].length - col - 1;

        return this.planetas[lin][col];
    }
}
