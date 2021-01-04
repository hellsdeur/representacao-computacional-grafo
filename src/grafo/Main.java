package grafo;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		// escolha entre grafo orientado e não orientado
		int menuPrincipal = -1;
		while (menuPrincipal != 0) {
			System.out.println(new String(new char[45]).replace("\0", "-"));
			System.out.println("PRINCIPAL");
			System.out.println("1 - Criar grafo orientado");
			System.out.println("2 - Criar grafo não orientado");
			System.out.println("0 - Finalizar Programa");
			System.out.format("\nEscolha uma opção: ");
			menuPrincipal = entrada.nextInt();
			entrada.nextLine();
			
			Grafo grafo; // declaração de um grafo genérico
			
			switch (menuPrincipal) {
			case 1:
				grafo = new GrafoOrientado(); // inicializando como orientado
				break;
			case 2:
				grafo = new GrafoNaoOrientado(); // inicializando como não orientado
				break;
			default:
				grafo = null;
				break;
			}
			
			int menuGrafo = -1;
			while (menuGrafo != 0) {
				System.out.println(new String(new char[45]).replace("\0", "-"));
				System.out.println("1 - Adicionar vértices");
				System.out.println("2 - Adicionar aresta");
				System.out.println("3 - Obter grau de um vértice");
				System.out.println("4 - Obter vértice de grau máximo do grafo");
				System.out.println("5 - Imprimir lista de adjacências");
				System.out.println("6 - Imprimir matriz de adjacências");
				System.out.println("7 - Aplicar Busca em Largura (DFS)");
				System.out.println("0 - Voltar para PRINCIPAL");
				System.out.format("\nEscolha uma opção: ");
				menuGrafo = entrada.nextInt();
				entrada.nextLine();
				
				switch (menuGrafo) {
				case 1:
					System.out.println(new String(new char[45]).replace("\0", "-"));
					System.out.format("\nQuantidade de vértices a adicionar: ");
					grafo.adicionarVertices(entrada.nextInt());
					entrada.nextLine();
					break;
				case 2:
					System.out.println(new String(new char[45]).replace("\0", "-"));
					System.out.format("\nPar de vértices da aresta (separados por espaço simples): ");
					String[] strIndexes = entrada.nextLine().split(" ");
					grafo.adicionarAresta(Integer.parseInt(strIndexes[0]), Integer.parseInt(strIndexes[1]));
					break;
				case 3:
					System.out.println(new String(new char[45]).replace("\0", "-"));
					System.out.format("\nVértice a obter grau: ");
					int indexVertice = entrada.nextInt();
					entrada.nextLine();
					System.out.format("\nGrau do vértice %d: \n", grafo.grauVertice(indexVertice));
					break;
				case 4:
					System.out.println(new String(new char[45]).replace("\0", "-"));
					System.out.format("\nVértice de grau máximo: %d", grafo.verticeGrauMax());
					break;
				case 5:
					System.out.println(new String(new char[45]).replace("\0", "-"));
					System.out.println("\nLista de adjacências:");
					grafo.printListaAdjacencias();
					break;
				case 6:
					System.out.println(new String(new char[45]).replace("\0", "-"));
					System.out.println("\nMatriz de adjacências:");
					grafo.printMatrizAdjacencias();
				case 7:
					grafo.dfs();
					grafo.visitarVertice(grafo.getVertice(0).getIndex());
				default:
					break;
				}
			}
		}
		System.out.println(new String(new char[45]).replace("\0", "-"));
		System.out.println("Programa finalizado");
		entrada.close();
	}
}
