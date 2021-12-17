package projeto.g69.fase3;

import java.util.List;

public class GrandePremioSideral {
    private SistemaSolar sistemaS;
    private List<Viajante> viajantes;
    private int premioB;

    public GrandePremioSideral(SistemaSolar ss, List<Viajante> jogs, int premioBase) {
        this.sistemaS = ss;
        this.viajantes = jogs;
        this.premioB = premioBase;
    }

    public int premioBase() { return  premioB; }

    public void fazJogada(List<Par<String,Integer>> jogadas) {
        return ;
    }

    public List<String> vencedores() {
        return null;
    }

    public String toString() {
        return null;
    }
}
