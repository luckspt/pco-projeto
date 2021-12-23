package projeto.g69.fase3;

// TODO numero ordem n

import java.util.List;

/**
 * Sistema solar.
 *
 * @author G69 - 53741 Lívia Batalha, 56926 Lucas Pinto, 56941 Bruno Gonzalez;
 * @date 17 de dezembro de 2021.
 */
public interface SistemaSolar {
    /**
     * Nome de Sistema Solar
     */
    String nome();

    /**
     * Possibilidade de visitar elementos de Sistema Solar
     * @param aVisitar Lista de int números de ordem dos elementos
     */
    boolean podeVisitar(List<Integer> aVisitar);

    /**
     * Quantidade de elementos definidos por Sistema Solar
     */
    int quantosElementos();

    /**
     * Corpo celeste de Sistema Solar
     * @param n Número de ordem do corpo celeste
     */
    CorpoCeleste getElemento(int n);

    /**
     * Buraco negro de Sistema Solar mais perto do corpo celeste
     * @param c CorpoCeleste a considerar
     */
    BuracoNegro buracoNegroMaisPerto(CorpoCeleste c);
}
