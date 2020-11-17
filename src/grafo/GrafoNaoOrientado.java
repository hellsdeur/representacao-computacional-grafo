package grafo;

import java.util.LinkedList;

public class GrafoNaoOrientado extends Grafo {

	@Override
	public void adicionarAresta(int index1, int index2) {
		Vertice vertice1 = getVertice(index1); // obter o vértice na lista de vértices com um dado index1
		Vertice vertice2 = getVertice(index2); // obter o vértice na lista de vértices com um dado index2
		--index1; // decrementado para poder referenciar na matriz, que começa a contar de zero
		--index2;
		
		if (vertice1.getIndex() != -1 && vertice2.getIndex() != -1) { // se ambos os vértices estiverem na lista de vértices
			Aresta novaAresta = new Aresta(vertice1, vertice2);
			this.arestas.add(novaAresta);
			
			if (vertice1 == vertice2) { // ajusta adjacências para um laço
				vertice1.addVerticeAdjacente(vertice2); // adiciona v2 como adjacente de v1
				matrizAdjacencias.atualizarMatriz(index1, index2); // atualiza a matriz, mapeando a posição da aresta para 1
			}
			else { // caso não seja um laço, ajusta a adjacência para os dois vértices
				vertice1.addVerticeAdjacente(vertice2);
				matrizAdjacencias.atualizarMatriz(index1, index2);
				
				vertice2.addVerticeAdjacente(vertice1);
				matrizAdjacencias.atualizarMatriz(index2, index1);
			}
			
		}
	}
	
}
