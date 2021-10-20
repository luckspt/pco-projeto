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
        String[] propPartes = propriedade.split(";"); // TODO q tal separar por ;|: ?
        /*
            0:hasWater
            2:canRefuel,isFriendly
            3:hasWater,hasLight
         */

        for (String parte : propPartes) {
            String[] dividido = parte.split(":");
            int ki = Integer.valueOf(dividido[0]); // 0; 2; 3
            String propi = dividido[1]; // hasWater; canRefuel,isFriendly; hasWater,hasLight

            boolean contem = "ola asd sifduhsfh".contains("asd");
        }

        return false;
    }

    // novos métodos privados
}
