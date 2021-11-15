package projeto.g69.fase2;

import java.util.List;

public class Planeta {
    private String nome;
    private List<Propriedade> props;

    public Planeta(String nome, List<Propriedade> props) {
        this.nome = nome;
        this.props = props; // TODO copy?
    }

    public String nome() {
        return this.nome;
    }

    public boolean temPropriedade(Propriedade p) {
        return this.props.contains(p);
    }

    public boolean temTodas(List<Propriedade> props) {
        return this.props.containsAll(props);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(this.nome() + ": ");

        for (Propriedade p : this.props)
            sb.append(p.toString() + " ");

        return sb.deleteCharAt(sb.length()-1).toString();
    }
}
