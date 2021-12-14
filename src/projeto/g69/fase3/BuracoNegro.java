package projeto.g69.fase3;

/**
 * Representa um BuracoNegro
 */
public class BuracoNegro extends CorpoCeleste {
    /**
     * Inicializa um novo BuracoNegro com massa e posição
     * @param massa Massa do CorpoCeleste
     * @param pos Posicao do CorpoCeleste
     */
    public BuracoNegro(double massa, Ponto3D pos) {
        super(massa, pos);
    }

    /**
     * Calcula a distância mínima de segurança entre o BuracoNegro e outro corpo celeste
     * @param c CorpoCeleste a comparar
     * @return A distância mínima de segurança entre os dois CorposCeleste's
     * @requires c != null
     */
    public double distanciaMinimaSeguranca(CorpoCeleste c) {
        return Math.sqrt(this.massa() * c.massa());
    }
}
