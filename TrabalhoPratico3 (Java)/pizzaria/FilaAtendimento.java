package pizzaria;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FilaAtendimento {
	private Scanner scanner = new Scanner(System.in);
	private Queue<String> fila = new LinkedList<>();
	
	public void inserir() {
		System.out.println("Digite o nome da pessoa para adicionar na fila:");
		String nome = scanner.nextLine();
		fila.add(nome);
		System.out.println("Fila: ");
		System.out.println(fila);
	}
	
	public void remover() {
		if (fila.isEmpty())
			System.out.println("Fila Vazia!");
		else {
			System.out.println("Pessoa chamada: " + fila.remove());
			System.out.println("Fila: ");
			System.out.println(fila);
		}
	}
	
	public void mostrar() {
		System.out.println("Fila: ");
		System.out.println(fila);
	}
}
