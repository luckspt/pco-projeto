package projeto.g69.fase3;

/**
 * Corpo celeste.
 *
 * @author G69 - 53741 Lívia Batalha, 56926 Lucas Pinto, 56941 Bruno Gonzalez;
 * @date 17 de dezembro de 2021.
 */
public class CorpoCeleste {
    /**
     * Massa do CorpoCeleste
     */
    private double massa;
    /**
     * Posicao do CorpoCeleste
     */
    private Ponto3D posicao;

    /**
     * Inicializa um novo CorpoCeleste com massa e posição
     * @param massa Massa do CorpoCeleste
     * @param pos Posicao do CorpoCeleste
     */
    public CorpoCeleste(double massa, Ponto3D pos) {
        this.massa = massa;
        this.posicao = pos;
    }

    /**
     * Massa do CorpoCeleste
     * @return a massa do CorpoCeleste
     */
    public double massa() {
        return this.massa;
    }

    /**
     * Posicao do CorpoCeleste
     * @return a posicao do CorpoCeleste
     */
    public Ponto3D posicao() {
        return this.posicao;
    }

    /**
     * Distância do CorpoCeleste a outro CorpoCeleste
     * @param c CorpoCeleste a comparar
     * @return a distância entre os CorpoCeleste's
     * @requires c != null &amp;&amp; c.posicao != null
     */
    public double distancia(CorpoCeleste c) {
        return this.posicao.distancia(c.posicao);
    }

    /**
     * Noção de igualdade entre o CorpoCeleste e um outro objeto
     * @param other Objeto a comparar
     * @return se o CorpoCeleste e o objeto são iguais
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof CorpoCeleste)) return false;

        CorpoCeleste corpoCeleste = (CorpoCeleste) other;

        if (Math.abs(this.massa() - corpoCeleste.massa()) > 0.00001) return false;
        return this.posicao != null
                ? posicao.equals(corpoCeleste.posicao())
                : corpoCeleste.posicao() == null;
    }

    /**
     * Representação em hash code de CorpoCeleste.
     * @return o hash code
     */
    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(this.massa);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + (this.posicao != null ? this.posicao.hashCode() : 0);
        return result;
    }
}
