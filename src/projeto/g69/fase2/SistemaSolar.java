package projeto.g69.fase2;

import java.util.ArrayList;
import java.util.List;

/**
 * Sistema Solar.
 *
 * @author G69 - 53741 Lívia Batalha, 56926 Lucas Pinto, 56941 Bruno Gonzalez;
 * @date 21 de novembro de 2021.
 */
public class SistemaSolar {
    /**
     * Nome do Sistema Solas
     */
    private final String nome;

    /**
     * Matriz dos planetas
     */
    private final Planeta[][] planetas;

    /**
     * Inicializa Sistema Solar.
     *
     * @param nome String representando o nome de Sistema Solar.
     * @param planetas matriz de Planetas de um universo válido.
     */
    public SistemaSolar(String nome, Planeta[][] planetas) {
        this.nome = nome;
        this.planetas = planetas;
    }

    /**
     * Verifica se Planetas estão representados numa matriz sem elementos nulos.
     *
     * @param arrayBi Array bidimensional de Planetas a verificar.
     * @requires arrayBi != null &amp;&amp; arrayBi.length >= 1
     * @return Boolean true se arrayBi for uma matriz e não tem elementos nulos, boolean false se não.
     */
    public static boolean universoValido(Planeta[][] arrayBi) {
        int len = arrayBi[0].length;
        boolean valido = true;

        for (int lin=0; valido && lin<arrayBi.length; lin++) {
            if (arrayBi[lin].length != len)
                valido = false;

            for (int col=0; valido && col<arrayBi[lin].length; col++) {
                if (arrayBi[lin][col] == null)
                    valido = false;
            }
        }

        return valido;
    }

    /**
     * Nome de Sistema Solar.
     *
     * @return String representando o nome de Sistema Solar.
     */
    public String nome() {
        return this.nome;
    }

    /**
     * Verifica se Sistema Solar tem Planeta.
     *
     * @param nome String representando o nome de Planeta a verificar.
     * @return Boolean true se tiver, boolean false se não.
     */
    public boolean temPlaneta(String nome) {
        for (Planeta[] pLinha : this.planetas) {
            for (Planeta p : pLinha) {
                if (p.nome().equals(nome))
                    return true;
            }
        }

        return false;
    }

    /**
     * Planetas de Sistema Solar que têm um conjunto de Propriedades.
     *
     * @param props lista de Propriedades a verificar.
     * @requires props != null
     * @return lista de Strings que representam os nomes de Planetas de Sistema
     *         Solar com dado conjunto de Propriedades.
     */
    public List<String> comPropriedades(List<Propriedade> props) {
        List<String> result = new ArrayList();

        for (Planeta[] pLinha : this.planetas) {
            for (Planeta p : pLinha) {
                if (p.temTodas(props))
                    result.add(p.nome());
            }
        }

        return result;
    }

    /**
     * Quantos Planetas de Sistema Solar têm conjunto de Propriedades.
     *
     * @return Array de ints representando o número de Planetas que
     *         possuem cada Propriedade de dado conjunto.
     */
    public int[] quantosPorPropriedade() {
        int[] quantos = new int[Propriedade.values().length];

        for (Planeta[] pLinha : this.planetas) {
            for (Planeta p : pLinha) {
                for (Propriedade prop : Propriedade.values()) {
                    if (p.temPropriedade(prop))
                        quantos[prop.ordinal()]++;
                }
            }
        }

        return quantos;
    }

    /**
     * Verifica se Planeta de Sistema Solar tem um conjunto de Propriedades.
     *
     * @param n que representa o número do Planeta a verificar.
     * @param props lista de Propriedades a verificar.
     * @requires n >= 0
     * @return Boolean true se tiver, boolean false se não.
     */
    public boolean nEsimoTem(int n, List<Propriedade> props) {
        // No enunciado, n refere-se à posição, mas é usado como índice
        // Para tornar n num índice:
        // n--;

        int lin = (n / this.planetas[0].length) % this.planetas.length;
        int col = n % this.planetas[0].length;

        // Movimento lagarta: se a o indice da linha for ímpar o sentido é inverso
        if (lin % 2 != 0)
            col = this.planetas[0].length - col - 1;

        return this.planetas[lin][col].temTodas(props);
    }

    /**
     * Propriedade mais frequente entre Planetas de Sistema Solar.
     *
     * @return Propriedade mais frequente em Sistema Solar.
     */
    public Propriedade maisFrequente() {
        int[] quantos = this.quantosPorPropriedade();
        int maxIdx = 0;

        for (int i=1; i<quantos.length; i++) {
            if (quantos[i] > quantos[maxIdx])
                maxIdx = i;
        }

        return Propriedade.values()[maxIdx];
    }

    /**
     * Sistema Solar em String.
     *
     * @return String que representa Sistema Solar.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(this.nome()).append("\n");

        for (Planeta[] pLinha : this.planetas) {
            for (Planeta p : pLinha)
                sb.append(p.toString()).append(" ");

            sb.deleteCharAt(sb.length()-1).append("\n");
        }

        return sb.deleteCharAt(sb.length()-1).toString();
    }
}
