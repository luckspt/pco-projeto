package projeto.g69.fase3;

/**
 * As instancias desta classe representam direcionadores que
 * utilizam uma ordem linha a linha na procura dos elementos
 * 
 * @author minunes
 */
public class LinhaALinha implements Direcionador {
	private CorpoCeleste[][] matriz;

	/**
	 * Define o universo sobre o qual este direcionador vai
	 * trabalhar
	 * @param m A matriz que representa o universo de corpos
	 *          celestes
	 * @requires m != null &amp;&amp; m e' matriz
	 */
	@Override
	public void defineUniverso(CorpoCeleste[][] m) {
		this.matriz = m;
	}

	/**
	 * O elemento numa dada posicao da matriz universo
	 * @param n O numero de ordem do elemento requerido
	 * @return O elemento na n-esima posicao da matriz universo
	 * @requires n >= 0
	 */
	@Override
	public CorpoCeleste nEsimoElemento(int n) {
		int p = n % (this.matriz.length * this.matriz[0].length);
		return matriz[p / matriz[0].length][p % matriz[0].length];
	}

}
