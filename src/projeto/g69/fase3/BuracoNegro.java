package projeto.g69.fase3;

/**
 * Buraco negro.
 *
 * @author G69 - 53741 Lívia Batalha, 56926 Lucas Pinto, 56941 Bruno Gonzalez;
 * @date 17 de dezembro de 2021.
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
     * Calcula a distância mínima de segurança entre o BuracoNegro e outro CorpoCeleste
     * @param c CorpoCeleste a comparar
     * @return a distância mínima de segurança entre os dois CorposCeleste's
     * @requires c != null
     */
    public double distanciaMinimaSeguranca(CorpoCeleste c) {
        return Math.sqrt(this.massa() * c.massa());
    }
}
