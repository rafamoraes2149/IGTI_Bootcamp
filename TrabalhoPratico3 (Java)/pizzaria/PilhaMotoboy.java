package pizzaria;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class PilhaMotoboy {
	private Stack<String> pilha = new Stack<>();
	private Scanner scanner = new Scanner(System.in);
	
	public void organizarPedidos() {
		ArrayList<String> listaPedidos = new ArrayList<>();
		ArrayList<Integer> distancias = new ArrayList<>();
		//int[] distancias = new int[50];
		int contador = 0;
		System.out.println("Digite 'sair' para terminar.");
		String nome = "semnome";
		do {
			System.out.println("Digite o " + (contador+1) + "º nome:");
			nome = scanner.nextLine();
			if (nome.equals("sair")) break;
			listaPedidos.add(nome);
			System.out.println("Digite a distância:");
			distancias.add(Integer.parseInt(scanner.nextLine()));
			contador++;
		} while ( (!nome.equals("sair")) || (contador <= 50) );
		
		//ordena a pilha de acordo com a distância
		while (!listaPedidos.isEmpty()) {
			int maiorDistancia = 0;
			int indiceMaiorDistancia = 0;
			for (int i = 0; i<listaPedidos.size(); i++) {
				if (distancias.get(i) > maiorDistancia) {
					maiorDistancia = distancias.get(i);
					indiceMaiorDistancia = i;
				}
			}
			pilha.push(listaPedidos.remove(indiceMaiorDistancia));
			distancias.remove(indiceMaiorDistancia);
		}
		//System.out.println(pilha);
		for (int i=pilha.size()-1; i>=0; i--) System.out.println(i + ": " + pilha.get(i));
	}
	
	public void desempilhar() {
		if (pilha.isEmpty()) System.out.println("Pilha Vazia!");
		else System.out.println("Pedido desempilhado: " + pilha.pop());
	}
}
