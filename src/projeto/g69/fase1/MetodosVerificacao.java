package projeto.g69.fase1;

/**
 * Métodos de verificação
 *
 * @author G69 - 53741 Lívia Batalha, 56926 Lucas Pinto, 56941 Bruno Gonzalez
 * @date Outubro 2021
 */
public class MetodosVerificacao {
    /**
     * Um dado trajeto, num dado sentido, satisfaz uma dada propriedade?
     *
     * @param trajeto     O trajeto em questão
     * @param propriedade A propriedade a ser verificada
     * @param sentido     O sentido a considerar no trajeto para a verificação
     * @requires trajeto != null &amp;&amp; propriedade != null &amp;&amp;
     * sentido in {"REGULAR","INVERSO"} &amp;&amp;
     * os elementos de trajeto são sequencias de características da
     * forma caract_1,...,caract_m
     * propriedade é da forma k_1:prop_1;...;kn:prop_n onde cada k_i é
     * um inteiro e cada prop_i é uma sequência de características da
     * forma caract_1,...,caract_m
     * @return Se o trajeto satisfaz a propriedade
     */
    public static boolean verificaPropriedade(String[] trajeto, String propriedade, String sentido) {
        // Parte as propriedades em partes, cada uma para um planeta no trajeto
        String[] propPartes = propriedade.split(";"); // TODO q tal separar por ;|: ?

        // i começa a 0 se regular, caso contrário começa no último índice
        int i = sentido.equals("REGULAR") ? 0 : trajeto.length - 1;

        for (String parte : propPartes) {
            // Partir a soma e as propriedades da parte
            String[] dividido = parte.split(":");

            // o Integer#valueOf retorna um Integer e não um int, portanto usamos o Integer#parseInt
            int incremento = Integer.parseInt(dividido[0]);
            i = MetodosVerificacao.proxIndice(i, incremento, trajeto.length, sentido);

            // Partir as propriedades
            String[] props = dividido[1].split(",");

            // Testar se o planeta contém cada propriedade
            if (!MetodosVerificacao.contemTodas(props, trajeto[i]))
                return false;
        }

        return true;
    }

    /**
     * Verifica se uma String contém as substrings de um vetor.
     *
     * @param v Substrings a conter
     * @param s String que deve conter as sub-Strings
     * @requires v != null &amp;&amp; s != null
     * @return Se as substrings de v estão contidas em s
     */
    private static boolean contemTodas(String[] v, String s) {
        for (String str : v)
            if (!s.contains(str))
                return false;
        return true;
    }

    /**
     * Obtém o próximo índice válido dentro de dado intervalo.
     *
     * @param atual Índice atual
     * @param incremento Quanto somar ao índice atual
     * @param maximo Máximo valor do índice, exclusivo
     * @param sentido Sentido regular ou inverso
     * @requires sentido in {"REGULAR","INVERSO"} &amp;&amp; atual >= 0 &amp;&amp; atual < maximo
     * @return Próximo índice
     */
    private static int proxIndice(int atual, int incremento, int maximo, String sentido) {
        // i cresce no sentido regular e decresce no sentido inverso
        if (sentido.equals("REGULAR")) {
            atual += incremento;

            // Se ultrapassa o comprimento de trajeto, por quanto ultrapassa?
            atual %= maximo;
        } else {
            atual -= incremento;
            atual %= maximo;

            // se i negativo tem de se dar a volta
            if (atual < 0)
                atual += maximo;
        }

        return atual;
    }
}
