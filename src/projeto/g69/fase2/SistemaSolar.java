package projeto.g69.fase2;

import java.util.ArrayList;
import java.util.List;

public class SistemaSolar {
    private String nome;
    private Planeta[][] planetas;

    /**
     *
     * @param nome
     * @param planetas
     * @requires universoValido(planetas)
     */
    public SistemaSolar(String nome, Planeta[][] planetas) {
        this.nome = nome;
        this.planetas = planetas; // TODO copy?
    }

    /**
     *
     * @param arrayBi
     * @requires arrayBi.length >= 1
     * @return
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

    public String nome() {
        return this.nome;
    }

    public boolean temPlaneta(String nome) {
        for (Planeta[] pLinha : this.planetas) {
            for (Planeta p : pLinha) {
                if (p.nome().equals(nome))
                    return true;
            }
        }

        return false;
    }

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
     *
     * @param n
     * @param props
     * @requires n >= 1
     * @return
     */
    public boolean nEsimoTem(int n, List<Propriedade> props) {
        // Tornar n um "índice"
        n--;

        int lin = n / this.planetas[0].length;
        int col = n % this.planetas[0].length;

        // Movimento lagarta: se a o indice da linha for ímpar o sentido é inverso
        if (lin % 2 != 0)
            col = this.planetas[0].length - col - 1;

        return this.planetas[lin][col].temTodas(props);
    }

    public Propriedade maisFrequente() {
        int[] quantos = this.quantosPorPropriedade();
        int maxIdx = 0;

        for (int i=1; i<quantos.length; i++) {
            if (quantos[i] > quantos[maxIdx])
                maxIdx = i;
        }

        return Propriedade.values()[maxIdx];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(this.nome() + "\n");

        for (Planeta[] pLinha : this.planetas) {
            for (Planeta p : pLinha)
                sb.append(p.toString() + " ");

            sb.deleteCharAt(sb.length()-1).append("\n");
        }

        return sb.deleteCharAt(sb.length()-1).toString();
    }
}
