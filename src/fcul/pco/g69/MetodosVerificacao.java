package fcul.pco.g69;

/**
 * Métodos de verificação
 *
 * @author G69 - 53741 Lívia Batalha; 56926 Lucas Pinto, 56941 Bruno Gonzalez
 */
class MetodosVerificacao {
    /**
     * Um dado trajeto, num dado sentido, satisfaz uma dada propriedade?
     *
     * @param trajeto     O trajeto em questão
     * @param propriedade A propriedade a ser verificada
     * @param sentido     O sentido a considerar no trajeto para a verificação
     * @requires trajeto != null && propriedade != null &&
     * sentido in {"REGULAR","INVERSO"} &&
     * os elementos de trajeto são sequencias de características da
     * forma caract_1,...,caract_m
     * propriedade é da forma k1:prop_1;...;kn:prop_n onde cada k_i é
     * um inteiro e cada prop_i é uma sequência de características da
     * forma caract_1,...,caract_m
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
            int mais = Integer.parseInt(dividido[0]);

            // i cresce no sentido regular e decresce no sentido inverso
            if (sentido.equals("REGULAR")) {
                i += mais;

                // Se ultrapassa o comprimento de trajeto, por quanto ultrapassa?
                i %= trajeto.length;
            } else {
                i -= mais;
                i %= trajeto.length;

                // se i negativo tem de se dar a volta
                if (i < 0)
                    i += trajeto.length;
            }

            // Partir as propriedades
            String[] props = dividido[1].split(",");

            // Testar se o planeta contém as propriedades
            for (String prop : props) {
                boolean contem = trajeto[i].contains(prop);
                if (!contem)
                    return false;
            }
        }

        return true;
    }
}
