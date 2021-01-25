package pizzaria;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		ListaContatos lista = new ListaContatos();
		FilaAtendimento fila = new FilaAtendimento();
		PilhaMotoboy pilha = new PilhaMotoboy();
		String comando;
		
		//Menu principal
		StringBuilder sb = new StringBuilder();
		sb.append("Digite o comando desejado: \n");
		sb.append("1 - Consultar lista de contatos \n");
		sb.append("2 - Inserir contato \n");
		sb.append("3 - Remover contato \n");
		sb.append("4 - Inserir Pedido na fila \n");
		sb.append("5 - Remover Pedido da fila \n");
		sb.append("6 - Organizar entregas \n");
		sb.append("7 - Desenpilhar Pedido \n");
		sb.append("8 - Sair");
		
		do {
		System.out.println(sb.toString()); //mostra o menu principal
		
		comando = scanner.nextLine();
		
		switch (comando) {
			case "1":
				lista.consultar(); break;
			case "2":
				lista.inserir(); break;
			case "3":
				if (lista.lista.isEmpty())
					System.out.println("Lista Vazia!");
				else {
					System.out.println(lista.lista);
					System.out.println("Digite o indice: ");
					lista.remover(Integer.parseInt(scanner.nextLine()));
				}
				break;
			case "4":
				fila.inserir(); break;
			case "5":
				fila.remover(); break;
			case "6":
				pilha.organizarPedidos(); break;
			case "7":
				pilha.desempilhar(); break;
			case "8":
				System.out.println("Programa finalizado!");
				break;
		}
		} while (!comando.equals("8"));
		scanner.close();
	}

}
