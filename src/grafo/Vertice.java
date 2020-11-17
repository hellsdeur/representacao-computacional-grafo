package grafo;

import java.util.LinkedList;

public class Vertice {
	protected int index; // identificação do vértice
	protected int grau; // vértices adjacentes
	protected LinkedList<Vertice> listaAdjacencias; // lista de vertices adjacentes ao atual
	
	public Vertice(int index) {
		this.index = index;
		this.grau = 0; // iniciar vértice com grau 0
		this.listaAdjacencias = new LinkedList<Vertice>();
	}
	
	public int getIndex() { // obter index
		return this.index;
	}
	
	public int getGrau() { // obter grau
		return this.grau;
	}
	
	public void addVerticeAdjacente(Vertice adjacente) { // adicionar vértice adjacente na lista de adjacências
		this.listaAdjacencias.add(adjacente);
		++this.grau;
	}
	
	public LinkedList<Vertice> getListaAdjacencias() { // obter lista
		return this.listaAdjacencias;
	}
	
	public String toString() { // toString para printar o index do vértice
	    return Integer.toString(this.index);
	}

}
