package grafo;

public class GrafoOrientado extends Grafo{

	@Override
	public void adicionarAresta(int index1, int index2) {
		Vertice verticePartida = getVertice(index1); // obter o vértice de partida na lista de vértices com um dado index1
		Vertice verticeDestino = getVertice(index2); // obter o vértice de destino na lista de vértices com um dado index2
		--index1; // decrementado para poder referenciar na matriz, que começa a contar de zero
		--index2;
		
		if (verticePartida.getIndex() != -1 && verticeDestino.getIndex() != -1) { // se ambos os vértices estiverem na lista de vértices
			Aresta novaAresta = new Aresta(verticePartida, verticeDestino);
			this.arestas.add(novaAresta);
			
			// ajusta a adjacência para os dois vértices, independente se for laço ou não
			verticePartida.addVerticeAdjacente(verticeDestino);
			this.matrizAdjacencias.atualizarMatriz(index1, index2);
		}
	}
}
