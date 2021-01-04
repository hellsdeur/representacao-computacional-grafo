package grafo;

import java.util.LinkedList;

public abstract class Grafo {
	protected LinkedList<Vertice> vertices;	// lista de vértices
	protected LinkedList<Aresta> arestas;	// lista de arestas
	protected MatrizQuadrada matrizAdjacencias; // lista de listas de inteiros
	private static final int BRANCO = -1;
	private static final int CINZA = 0;
	private static final int PRETO = 1;
	protected LinkedList<Integer> cor;
	
	public Grafo() {
		vertices = new LinkedList<Vertice>();
		arestas = new LinkedList<Aresta>();
		matrizAdjacencias = new MatrizQuadrada(0);
		cor = new LinkedList<Integer>();
	}
	
	public void adicionarVertices(int n) { // o index do novo vértice é definido automaticamente
		matrizAdjacencias.aumentarMatriz(vertices.size() + n); // redimensiona a matriz
		while (n > 0) {
			Vertice novoVertice = new Vertice(vertices.size() + 1); // index do novo vertice = quantidade de vertices + 1
			vertices.add(novoVertice); // adiciona novo vértice na lista de vértices
			--n;
		}
	}
	
	public abstract void adicionarAresta(int index1, int index2); // método sobreescrito, de acordo com o tipo de grafo
	
	protected Vertice getVertice(int index) { // obter o vértice na lista de vértices, a partir do index
		for (int v = 0; v < vertices.size(); ++v) {
			if (vertices.get(v).getIndex() == index) { // se existe um vértice com esse index retorna esse vértice
				return vertices.get(v);
			}
		}
		return new Vertice(-1); // se não houver vértice compatível, retorna vértice -1
	}

	public int grauVertice(int index) { // retorna o grau de um vértice, a partir do index
		Vertice v = getVertice(index);
		return v.getGrau();
	}
	
	public Vertice verticeGrauMax() { // vértice de maior grau dentro do grafo
		int max = 0;
		Vertice verticeGrauMax = new Vertice(0);
		for (int i = 0; i < vertices.size(); ++i) {
			if (vertices.get(i).getGrau() > max) {
				max = vertices.get(i).getGrau();
				verticeGrauMax = vertices.get(i);
			}
		}
		return verticeGrauMax;
	}
	
	public void printListaAdjacencias() {
		for (int v = 0; v < vertices.size(); ++v) {
			Vertice verticeAtual = vertices.get(v);
			System.out.format("%d → ", verticeAtual.getIndex());
			System.out.println(verticeAtual.getListaAdjacencias());
		}
	}

	public void printMatrizAdjacencias() {
		matrizAdjacencias.print();
	}
	
	public void dfs() {
		for (int i = 0; i < vertices.size(); ++i) {
			cor.add(BRANCO);
		}
		
		for (int u = 0; u < vertices.size(); ++u) {
			if (cor.get(u) == BRANCO) {
				visitarVertice(u);
			}
		}
	}
	
	public void visitarVertice(Integer u) {
		cor.set(u, CINZA);
		System.out.format("Visitou o vértice %d\n", u+1);
		LinkedList<Vertice> listaAtual = vertices.get(u).getListaAdjacencias();
		for (int i = 0; i < listaAtual.size(); ++i) {
			if (cor.get(listaAtual.get(i).getIndex()-1) == BRANCO) {
				visitarVertice(listaAtual.get(i).getIndex()-1);
				
			}
		}
		cor.set(u, PRETO);
	}
}
