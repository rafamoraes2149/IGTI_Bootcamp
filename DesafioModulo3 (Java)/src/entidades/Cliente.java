package entidades;

public class Cliente extends Pessoa{
	private String endere�o;

	public String getEndere�o() {
		return endere�o;
	}
	public void setEndere�o(String endere�o) {
		this.endere�o = endere�o;
	}
	
	public void imprimeCliente() {
		System.out.println("Nome: " + this.getNome());
		System.out.println("Endere�o: " + this.endere�o);
		System.out.println("CPF: " + this.getCpf());
	}
}
