package concessionaria;

import java.util.ArrayList;
import java.util.Scanner;
import entidades.Carro;
import entidades.Cliente;
import entidades.Moto;
import entidades.Vendedor;

public class ControleVeiculos {
	private Scanner scanner = new Scanner(System.in);
	private ArrayList<Carro> carros = new ArrayList<>();
	private ArrayList<Moto> motos = new ArrayList<>();
	private ArrayList<Cliente> clientes = new ArrayList<>();
	private ArrayList<Vendedor> vendedores = new ArrayList<>();
	
	private String mostrarMenu() {
		StringBuilder sb = new StringBuilder();
		sb.append("-------------------------- \n");
		sb.append("Digite o comando desejado: \n");
		sb.append("1 - consultar carros \n");
		sb.append("2 - consultar motos \n");
		sb.append("3 - consultar clientes \n");
		sb.append("4 - consultar vendedores \n");
		sb.append("5 - cadastrar carro \n");
		sb.append("6 - cadastrar moto \n");
		sb.append("7 - cadastrar cliente \n");
		sb.append("8 - cadastrar vendedor \n");
		sb.append("9 - vender carro \n");
		sb.append("10 - vender moto \n");
		sb.append("0 - sair");
		
		System.out.println(sb.toString());
		
		return scanner.nextLine();
	}

	public void iniciar(){
		String opcao = mostrarMenu();
		while(!opcao.equals("0")) {
			switch (opcao) {
			case "1":
				imprimirCarros(carros);
				opcao = mostrarMenu();
				break;
			case "2":
				imprimirMotos(motos);
				opcao = mostrarMenu();
				break;
			case "3":
				imprimirClientes(clientes);
				opcao = mostrarMenu();
				break;
			case "4":
				imprimirVendedores(vendedores);
				opcao = mostrarMenu();
				break;
			case "5":
				carros.add(cadastrarCarro());
				opcao = mostrarMenu();
				break;
			case "6":
				motos.add(cadastrarMoto());
				opcao = mostrarMenu();
				break;
			case "7":
				clientes.add(cadastrarCliente());
				opcao = mostrarMenu();
				break;
			case "8":
				vendedores.add(cadastrarVendedor());
				opcao = mostrarMenu();
				break;
			case "9":
				venderCarro();
				opcao = mostrarMenu();
				break;
			case "10":
				venderMoto();
				opcao = mostrarMenu();
				break;
			}
		}
		System.out.println("Programa finalizado!");
		scanner.close();
	}

	private void imprimirCarros(ArrayList<Carro> carros) {
		for (int i=0; i<carros.size(); i++) {
			System.out.printf("------- Carro %d ------ \n", i);
			carros.get(i).imprimeCarro();
		}
	}
	
	private void imprimirMotos(ArrayList<Moto> motos) {
		for (int i=0; i<motos.size(); i++) {
			System.out.printf("------- Moto %d ------ \n", i);
			motos.get(i).imprimeMoto();
		}
	}
	
	private void imprimirClientes(ArrayList<Cliente> listaClientes) {
		for (int i=0; i<listaClientes.size(); i++) {
			System.out.printf("------- Cliente %d ------ \n", i);
			listaClientes.get(i).imprimeCliente();
		}
	}

	private void imprimirVendedores(ArrayList<Vendedor> listaVendedores) {
		for (int i=0; i<listaVendedores.size(); i++) {
			System.out.printf("------- Vendedor %d ------ \n", i);
			listaVendedores.get(i).imprimeVendedor();
		}
	}
	
	private Carro cadastrarCarro() {
		Carro novoCarro = new Carro();
		System.out.println("Digite o modelo:");
		novoCarro.setModelo(scanner.nextLine());
		System.out.println("Digite a marca:");
		novoCarro.setMarca(scanner.nextLine());
		System.out.println("Digite o ano:");
		int anoLido = Integer.parseInt(scanner.nextLine());
		//int ano = anoLido.intValue();
		novoCarro.setAno(anoLido);
		System.out.println("Digite o valor:");
		double valorLido = Double.parseDouble(scanner.nextLine());
		//double valor = valorLido.doubleValue();
		novoCarro.setValor(valorLido);
		System.out.println("Digite o indice do vendedor responsável");
		novoCarro.setVendedor(vendedores.get(Integer.parseInt(scanner.nextLine())));
		return novoCarro;
	}
	
	private Moto cadastrarMoto() {
		Moto novaMoto = new Moto();
		System.out.println("Digite o modelo:");
		novaMoto.setModelo(scanner.nextLine());
		System.out.println("Digite a marca:");
		novaMoto.setMarca(scanner.nextLine());
		System.out.println("Digite o ano:");
		int anoLido = Integer.parseInt(scanner.nextLine());
		novaMoto.setAno(anoLido);
		System.out.println("Digite o valor:");
		double valorLido = Double.parseDouble(scanner.nextLine());
		novaMoto.setValor(valorLido);
		System.out.println("Digite o indice do vendedor responsável");
		novaMoto.setVendedor(vendedores.get(Integer.parseInt(scanner.nextLine())));
		return novaMoto;
	}
	
	private Cliente cadastrarCliente() {
		Cliente novoCliente = new Cliente();
		System.out.println("Digite o nome do cliente:");
		novoCliente.setNome(scanner.nextLine());
		System.out.println("Digite o endereço:");
		novoCliente.setEndereço(scanner.nextLine());
		System.out.println("Digite o CPF:");
		novoCliente.setCpf(scanner.nextLine());
		return novoCliente;
	}
	
	private Vendedor cadastrarVendedor() {
		Vendedor novoVendedor = new Vendedor();
		System.out.println("Digite o nome do vendedor: ");
		novoVendedor.setNome(scanner.nextLine());
		System.out.println("Digite o CPF: ");
		novoVendedor.setCpf(scanner.nextLine());
		System.out.println("Digite a matrícula:");
		novoVendedor.setMatricula(Integer.parseInt(scanner.nextLine()));
		return novoVendedor;
	}

	private void venderCarro() {
		System.out.println("Digite o indice do carro:");
		int indiceCarro = Integer.parseInt(scanner.nextLine());
		System.out.println("Digite o indice do cliente:");
		int indiceCliente = Integer.parseInt(scanner.nextLine());
		carros.get(indiceCarro).setCliente(clientes.get(indiceCliente));
	}
	
	private void venderMoto() {
		System.out.println("Digite o indice da moto:");
		int indiceMoto = Integer.parseInt(scanner.nextLine());
		System.out.println("Digite o indice do cliente:");
		int indiceCliente = Integer.parseInt(scanner.nextLine());
		motos.get(indiceMoto).setCliente(clientes.get(indiceCliente));
	}
}
