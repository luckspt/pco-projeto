package projeto.g69.fase2;

import java.util.List;

/**
 * Planeta.
 *
 * @author G69 - 53741 Lívia Batalha, 56926 Lucas Pinto, 56941 Bruno Gonzalez;
 * @date 21 de novembro de 2021.
 */
public class Planeta {
    /**
     * Nome do planeta
     */
    private final String nome;

    /**
     * Lista de propriedades do planeta
     */
    private final List<Propriedade> props;

    /**
     * Inicializa Planeta.
     *
     * @param nome String representando o nome de Planeta.
     * @param props lista de Propriedades de Planeta.
     */
    public Planeta(String nome, List<Propriedade> props) {
        this.nome = nome;
        this.props = props;
    }

    /**
     * Nome de Planeta.
     *
     * @return String representando o nome de Planeta.
     */
    public String nome() {
        return this.nome;
    }

    /**
     * Verifica se Planeta tem uma Propriedade.
     *
     * @param p Propriedade a verificar.
     * @return Boolean true se tiver, boolean false se não.
     */
    public boolean temPropriedade(Propriedade p) {
        return this.props.contains(p);
    }

    /**
     * Verifica se Planeta tem um conjunto de Propriedades.
     *
     * @param props lista de Propriedades a verificar.
     * @return Boolean true se tiver, boolean false se não.
     */
    public boolean temTodas(List<Propriedade> props) {
        return this.props.containsAll(props);
    }

    /**
     * Planeta em String.
     *
     * @return String que representa Planeta.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(this.nome()).append(": ");

        for (Propriedade p : this.props)
            sb.append(p.toString()).append(" ");

        return sb.deleteCharAt(sb.length()-1).toString();
    }
}

