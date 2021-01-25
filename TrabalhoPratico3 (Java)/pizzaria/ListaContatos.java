package pizzaria;

import java.util.ArrayList;
import java.util.Scanner;

public class ListaContatos {
	public ArrayList<String> lista = new ArrayList<>();
	private Scanner scanner = new Scanner(System.in);
	/*
	private ArrayList<String> iniciarLista () {
		return lista;
	}
	*/
	public void inserir() {
		System.out.println("Digite o nome:");
		String nome = scanner.nextLine();
		lista.add(nome);
	}
	
	public void consultar() {
		if (lista.isEmpty()) System.out.println("Lista Vazia!");
		else System.out.println(lista);
	}
	
	public void remover(int indice) {
		if (indice >= lista.size()) System.out.println("Indice invalido!");
		else {
			System.out.println("Nome removido: " + lista.remove(indice));
			System.out.println(lista);
		}
	}
	
}
