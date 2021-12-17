package projeto.g69.fase3;

import java.util.List;

/**
 * As instâncias desta classe definem a base de um Sistema Solar
 *
 */
public abstract class AbstractSistemaSolar implements SistemaSolar {
    /**
     * Nome do Sistema Solar
     */
    private String nome;

    /**
     * Inicializa um novo Sistema Solar
     * @param nome Nome do Sistema Solar
     */
    public AbstractSistemaSolar(String nome) {
        this.nome = nome;
    }

    /**
     * Devolve o nome do Sistema Solar
     * @return Nome do Sistema Solar
     */
    public String nome() {
        return this.nome;
    }

    /**
     * Determina se os CorposCelestes nas posições aVisitar podem ser visitados
     * @param aVisitar CorposCelestes a visitar
     * @return true se podem ser visitados, false caso contrário
     * @requires aVisitar != null
     */
    public boolean podeVisitar(List<Integer> aVisitar) {
        for (Integer i : aVisitar) {
            if (i <= 0 || i > this.quantosElementos())
                return false;
        }

        return true;
    }

    /**
     * Representação do SistemaSolar em String
     * @return O nome do Sistema Solar
     */
    @Override
    public String toString() {
        return this.nome();
    }
}
