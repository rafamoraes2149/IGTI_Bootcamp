package folhaDePagamento;

import java.util.ArrayList;
import java.util.Scanner;
//import java.util.regex.Pattern;

public class Contracheque {
	private Scanner scanner = new Scanner(System.in);
	private ArrayList<Funcionario> funcionarios = new ArrayList<>();
	
	private String mostrarMenu() {
		StringBuilder sb = new StringBuilder();
		sb.append("-------------------------- \n");
		sb.append("Digite o comando desejado: \n");
		sb.append("1 - cadastrar funcionário \n");
		sb.append("2 - imprimir contracheque \n");
		sb.append("0 - sair");
		System.out.println(sb.toString());
		
		return scanner.nextLine();
	}
	
	public void Iniciar() {
		String opcao = mostrarMenu();
		while (!opcao.equals("0")) {
			switch (opcao) {
			case "1":
				funcionarios.add(cadastrarFuncionario());
				opcao = mostrarMenu();
				break;
			case "2":
				imprimirListaFuncionarios();
				imprimirContracheque();
				opcao = mostrarMenu();
				break;
			}
		}
		System.out.println("Programa Finalizado!");
		scanner.close();
	}
	
	private Funcionario cadastrarFuncionario() {
		Funcionario novoFuncionario = new Funcionario();
		System.out.println("Digite o nome: ");
		novoFuncionario.setNome(scanner.nextLine());
		System.out.println("Digite o salario: ");
		novoFuncionario.setSalario(Float.parseFloat(scanner.nextLine()));
		return novoFuncionario;
	}
	
	private void imprimirContracheque(){
		if (funcionarios.isEmpty()) {
			System.out.println("Lista de funcionários vazia!");
		}
		else {
		System.out.println("Digite o indice do funcionário: ");
		int indiceFuncionario = Integer.parseInt(scanner.nextLine());
		String nome = funcionarios.get(indiceFuncionario).getNome();
		double salario = funcionarios.get(indiceFuncionario).getSalario();
		System.out.println("Funcionário: " + nome);
		System.out.println("Salário Bruto: " + salario);
		double descINSS = descontoINSS(salario);
		System.out.printf("Desconto INSS: %.2f\n",descINSS);
		salario -= descINSS;
		System.out.printf("Base p/ IRRF: %.2f\n", salario);
		double descIRRF = descontoIRRF(salario);
		System.out.printf("Desconto IRRF: %.2f\n",descIRRF);
		salario -= descIRRF;
		System.out.printf("Salário Líquido: %.2f\n",salario);
		}
	}
	
	private void imprimirListaFuncionarios() {
		for (int i=0; i<funcionarios.size(); i++) {
			String nome = funcionarios.get(i).getNome();
			double salario = funcionarios.get(i).getSalario();
			System.out.printf("%d: %s - %.2f\n",i,nome,salario);
		}
	}
	
	private double descontoINSS(double valor) {
		double desconto = 0;
		if (valor <= 1045)
			desconto = aliquotaINSS_1(valor);
		else if (valor <= 2089.6)
			desconto = aliquotaINSS_2(valor);
		else if (valor <= 3134.4)
			desconto = aliquotaINSS_3(valor);
		else if (valor <= 6101.06)
			desconto = aliquotaINSS_4(valor);
		else
			desconto = 713.10;
		return desconto;
	}
	
	private double aliquotaINSS_1(double valor) {
		return valor*0.075;
	}
	
	private double aliquotaINSS_2(double valor) {
		double base = 1045;
		double aliquota = 0.09;
		return ((valor-base)*aliquota) + aliquotaINSS_1(base);
	}
	
	private double aliquotaINSS_3(double valor) {
		double base = 2089.61;
		double aliquota = 0.12;
		return ((valor-base)*aliquota) + aliquotaINSS_2(base);
	}
	
	private double aliquotaINSS_4(double valor) {
		double base = 3134.4;
		double aliquota = 0.14;
		return ((valor-base)*aliquota) + aliquotaINSS_3(base);
	}
	
	private double descontoIRRF(double valor) {
		if (valor <= 1903.98)
			return 0;
		else if (valor <= 2826.65)
			return (valor*0.075) - 142.80;
		else if (valor <= 3751.05)
			return (valor*0.15) - 354.80;
		else if (valor <= 4664.68)
			return (valor*0.225) - 636.13;
		else
			return (valor*0.275) - 869.36;
	}
	
	/*
	private String testarDouble(String myString) {
		  final String Digits     = "(\\p{Digit}+)";
		  final String HexDigits  = "(\\p{XDigit}+)";
		  // an exponent is 'e' or 'E' followed by an optionally
		  // signed decimal integer.
		  final String Exp        = "[eE][+-]?"+Digits;
		  final String fpRegex    =
		      ("[\\x00-\\x20]*"+  // Optional leading "whitespace"
		       "[+-]?(" + // Optional sign character
		       "NaN|" +           // "NaN" string
		       "Infinity|" +      // "Infinity" string

		       // A decimal floating-point string representing a finite positive
		       // number without a leading sign has at most five basic pieces:
		       // Digits . Digits ExponentPart FloatTypeSuffix
		       //
		       // Since this method allows integer-only strings as input
		       // in addition to strings of floating-point literals, the
		       // two sub-patterns below are simplifications of the grammar
		       // productions from section 3.10.2 of
		       // The Java Language Specification.

		       // Digits ._opt Digits_opt ExponentPart_opt FloatTypeSuffix_opt
		       "((("+Digits+"(\\.)?("+Digits+"?)("+Exp+")?)|"+

		       // . Digits ExponentPart_opt FloatTypeSuffix_opt
		       "(\\.("+Digits+")("+Exp+")?)|"+

		       // Hexadecimal strings
		       "((" +
		        // 0[xX] HexDigits ._opt BinaryExponent FloatTypeSuffix_opt
		        "(0[xX]" + HexDigits + "(\\.)?)|" +

		        // 0[xX] HexDigits_opt . HexDigits BinaryExponent FloatTypeSuffix_opt
		        "(0[xX]" + HexDigits + "?(\\.)" + HexDigits + ")" +

		        ")[pP][+-]?" + Digits + "))" +
		       "[fFdD]?))" +
		       "[\\x00-\\x20]*");// Optional trailing "whitespace"

		  if (Pattern.matches(fpRegex, myString)) {
		      System.out.println("Valor testado: " + Double.valueOf(myString)); // Will not throw NumberFormatException
			  return myString;
		  }
		  else {
		      // Perform suitable alternative action
			  return "Numero invalido";
		  }
	}
	*/
}
