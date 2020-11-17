package grafo;

public class Aresta {
	private Vertice vertice1;
	private Vertice vertice2;
	
	public Aresta(Vertice vertice1, Vertice vertice2) {
		this.vertice1 = vertice1;
		this.vertice2 = vertice2;
	}
	
	public boolean contem(int index) { // verifica se um vértice está em uma aresta
		if (this.vertice1.getIndex() == index || this.vertice2.getIndex() == index) {
			return true;
		}
		return false;
	}
	
	public Vertice verticeAdjacente(Vertice vertice) { // retorna o vértice oposto em um aresta
		if (vertice == this.vertice1) {
			return this.vertice2;
		}
		return this.vertice1;
	}
}
