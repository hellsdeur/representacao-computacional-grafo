package grafo;

public class MatrizQuadrada { // a matriz de adjacências é um objeto matriz quadrada
	protected int n; // tamanho da lista de vértices
	protected int[][] elementos; // armazenando em um array
	
	public MatrizQuadrada(int n) { // inicia com zeros nas n*n posições
		this.n = n;
		elementos = new int[n][n];
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				elementos[i][j] = 0;
			}
		}
	}
	
	public void aumentarMatriz(int novoN) { // redimensionar, copiando os elementos antigos para uma nova matriz
		MatrizQuadrada novaMatriz = new MatrizQuadrada(novoN);
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				novaMatriz.elementos[i][j] = this.elementos[i][j];
			}
		}
		this.elementos = novaMatriz.elementos;
		this.n = novoN;
	}
	
	public void atualizarMatriz(int index1, int index2) { // chamado ao adicionar uma aresta
		this.elementos[index1][index2] = 1;
	}
	
	public void print() {
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				System.out.format("%d ", elementos[i][j]);
			}
			System.out.println();
		}
	}
}
