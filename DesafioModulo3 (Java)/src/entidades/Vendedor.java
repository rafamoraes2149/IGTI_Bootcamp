package entidades;

public class Vendedor extends Pessoa{
	private Integer matricula;

	public Integer getMatricula() {
		return matricula;
	}
	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}
	
	public void imprimeVendedor() {
		System.out.println("Nome: " + this.getNome());
		System.out.println("CPF: " + this.getCpf());
		System.out.println("Matrícula: " + this.matricula);
	}
}
