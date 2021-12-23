package projeto.g69.fase3;

import java.util.*;

/**
 * Grande prémio sideral.
 *
 * @author G69 - 53741 Lívia Batalha, 56926 Lucas Pinto, 56941 Bruno Gonzalez;
 * @date 17 de dezembro de 2021.
 */
public class GrandePremioSideral {
    /**
     * Taxa de risco
     */
    static int TAXA_RISCO = 5;
    /**
     * Pontuação de um BuracoNegro
     */
    static int PONTOS_BURACO_NEGRO = Integer.MAX_VALUE;

    /**
     * Sistema solar
     */
    private SistemaSolar sistemaSolar;
    /**
     * Mapa de viajantes
     */
    private Map<String, Viajante> viajantes;
    /**
     * Prémio base
     */
    private int premioBase;

    /**
     * Inicializa um novo GrandePremioSideral com sistema solar, viajantes, e posição
     * @param ss Sistema solar a utilizar
     * @param jogs Jogadores que irão jogar
     * @param premioBase Prémio base do vencedor
     */
    public GrandePremioSideral(SistemaSolar ss, List<Viajante> jogs, int premioBase) {
        this.sistemaSolar = ss;
        this.premioBase = premioBase;

        this.viajantes = new HashMap();
        for (Viajante viajante : jogs)
            this.viajantes.put(viajante.nome(), viajante);
    }

    /**
     * Prémio base
     * @return o prémio base
     */
    public int premioBase() {
        return this.premioBase;
    }

    /**
     * Regista as jogadas dos vários viajantes que participam no grande prémio
     * @param jogadas As jogadas dos jogadores
     * @requires jogadas != null &amp;&amp; jogadas[*] != null
     */
    public void fazJogada(List<Par<String, Integer>> jogadas) {
        for (Par<String, Integer> jogada : jogadas) {
            CorpoCeleste corpoCeleste = this.sistemaSolar.getElemento(jogada.segundo());
            Viajante viajante = this.viajantes.get(jogada.primeiro());

            int toAdd = 0;
            if (corpoCeleste == null) {
                if (viajante.pontuacao() != 0)
                    toAdd = 1 / viajante.pontuacao();
            } else {
                if (!corpoCeleste.posicao().equals(viajante.posicaoGlobal())
                    && this.sistemaSolar.podeVisitar(Arrays.asList(jogada.segundo()))) {
                    viajante.mudaPosicaoGlobal(corpoCeleste.posicao());

                    if (corpoCeleste instanceof BuracoNegro)
                        toAdd = -GrandePremioSideral.PONTOS_BURACO_NEGRO;
                    else {
                        toAdd = this.premioBase();

                        BuracoNegro buracoNegroMaisPerto = this.sistemaSolar.buracoNegroMaisPerto(corpoCeleste);
                        if (buracoNegroMaisPerto != null) {
                            double distanciaSeguranca = buracoNegroMaisPerto.distanciaMinimaSeguranca(corpoCeleste);
                            if (corpoCeleste.distancia(buracoNegroMaisPerto) < distanciaSeguranca)
                                toAdd *= GrandePremioSideral.TAXA_RISCO;
                        }
                    }
                } else if (viajante.pontuacao() != 0)
                    toAdd = -1 / viajante.pontuacao();
            }

            viajante.registaPontos(toAdd);
        }
    }

    /**
     * Obtém os vencedores
     * @return o nome dos vencedores
     */
    public List<String> vencedores() {
        List<String> vencedores = new ArrayList();
        int maior = 0;
        for (Viajante viajante : this.viajantes.values()) {
            if (viajante.pontuacao() >= maior) {
                vencedores.clear();
                vencedores.add(viajante.nome());
                maior = viajante.pontuacao();
            }
        }

        return vencedores;
    }

    /**
     * Representação do GrandePremioSideral em String
     * @return a representação textual
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("============ GRANDE PREMIO ============\n");
        sb.append("Premio base: " + this.premioBase() + "\n");
        sb.append("Sistema Solar:\n");
        sb.append( this.sistemaSolar.toString() );

        sb.append("\nViajantes:\n");
        for (Viajante v : this.viajantes.values())
            sb.append(v.toString() + "\n");

        return sb.deleteCharAt(sb.length() - 1).toString();
    }
}
