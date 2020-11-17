package grafo;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
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
			
			switch (menuPrincipal) {
			case 1:
				GrafoOrientado grafoOrientado = new GrafoOrientado();
				
				int menuOrientado = -1;
				while (menuOrientado != 0) {
					System.out.println(new String(new char[45]).replace("\0", "-"));
					System.out.println("GRAFO ORIENTADO");
					System.out.println("1 - Adicionar vértices");
					System.out.println("2 - Adicionar aresta");
					System.out.println("3 - Obter grau de um vértice");
					System.out.println("4 - Obter vértice de grau máximo do grafo");
					System.out.println("5 - Imprimir lista de adjacências");
					System.out.println("6 - Imprimir matriz de adjacências");
					System.out.println("0 - Voltar para PRINCIPAL");
					System.out.format("\nEscolha uma opção: ");
					menuOrientado = entrada.nextInt();
					entrada.nextLine();
					
					switch (menuOrientado) {
					case 1:
						System.out.println(new String(new char[45]).replace("\0", "-"));
						System.out.format("\nQuantidade de vértices a adicionar: ");
						grafoOrientado.adicionarVertices(entrada.nextInt());
						entrada.nextLine();
						break;
					case 2:
						System.out.println(new String(new char[45]).replace("\0", "-"));
						System.out.format("\nPar de vértices da aresta (separados por espaço simples): ");
						String[] strIndexes = entrada.nextLine().split(" ");
						grafoOrientado.adicionarAresta(Integer.parseInt(strIndexes[0]), Integer.parseInt(strIndexes[1]));
						break;
					case 3:
						System.out.println(new String(new char[45]).replace("\0", "-"));
						System.out.format("\nVértice a obter grau: ");
						int indexVertice = entrada.nextInt();
						entrada.nextLine();
						System.out.format("\nGrau do vértice %d: \n", grafoOrientado.grauVertice(indexVertice));
						break;
					case 4:
						System.out.println(new String(new char[45]).replace("\0", "-"));
						System.out.format("\nVértice de grau máximo: %d", grafoOrientado.verticeGrauMax());
						break;
					case 5:
						System.out.println(new String(new char[45]).replace("\0", "-"));
						System.out.println("\nLista de adjacências:");
						grafoOrientado.printListaAdjacencias();
						break;
					case 6:
						System.out.println(new String(new char[45]).replace("\0", "-"));
						System.out.println("\nMatriz de adjacências:");
						grafoOrientado.printMatrizAdjacencias();
					default:
						break;
					}
				}
				break;
			case 2:
				GrafoNaoOrientado grafoNaoOrientado = new GrafoNaoOrientado();
				
				int menuNaoOrientado = -1;
				while (menuNaoOrientado != 0) {
					System.out.println(new String(new char[45]).replace("\0", "-"));
					System.out.println("GRAFO NÃO-ORIENTADO");
					System.out.println("1 - Adicionar vértices");
					System.out.println("2 - Adicionar aresta");
					System.out.println("3 - Obter grau de um vértice");
					System.out.println("4 - Obter vértice de grau máximo do grafo");
					System.out.println("5 - Imprimir lista de adjacências");
					System.out.println("6 - Imprimir matriz de adjacências");
					System.out.println("0 - Voltar para PRINCIPAL");
					System.out.format("\nEscolha uma opção: ");
					menuNaoOrientado = entrada.nextInt();
					entrada.nextLine();
					
					switch (menuNaoOrientado) {
					case 1:
						System.out.println(new String(new char[45]).replace("\0", "-"));
						System.out.format("\nQuantidade de vértices a adicionar: ");
						grafoNaoOrientado.adicionarVertices(entrada.nextInt());
						entrada.nextLine();
						break;
					case 2:
						System.out.println(new String(new char[45]).replace("\0", "-"));
						System.out.format("\nPar de vértices da aresta (separados por espaço simples): ");
						String[] strIndexes = entrada.nextLine().split(" ");
						grafoNaoOrientado.adicionarAresta(Integer.parseInt(strIndexes[0]), Integer.parseInt(strIndexes[1]));
						break;
					case 3:
						System.out.println(new String(new char[45]).replace("\0", "-"));
						System.out.format("\nVértice a obter grau: ");
						int indexVertice = entrada.nextInt();
						entrada.nextLine();
						System.out.format("\nGrau do vértice %d: \n", grafoNaoOrientado.grauVertice(indexVertice));
						break;
					case 4:
						System.out.println(new String(new char[45]).replace("\0", "-"));
						System.out.format("\nVértice de grau máximo: %d", grafoNaoOrientado.verticeGrauMax());
						break;
					case 5:
						System.out.println(new String(new char[45]).replace("\0", "-"));
						System.out.println("\nLista de adjacências:");
						grafoNaoOrientado.printListaAdjacencias();
						break;
					case 6:
						System.out.println(new String(new char[45]).replace("\0", "-"));
						System.out.println("\nMatriz de adjacências:");
						grafoNaoOrientado.printMatrizAdjacencias();
					default:
						break;
					}
				}
				break;
			default:
				break;
			}
		}
		System.out.println(new String(new char[45]).replace("\0", "-"));
		System.out.println("Programa finalizado");
		entrada.close();
	}
}
