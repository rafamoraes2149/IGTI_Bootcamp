package entidades;

public class Cliente extends Pessoa{
	private String endereço;

	public String getEndereço() {
		return endereço;
	}
	public void setEndereço(String endereço) {
		this.endereço = endereço;
	}
	
	public void imprimeCliente() {
		System.out.println("Nome: " + this.getNome());
		System.out.println("Endereço: " + this.endereço);
		System.out.println("CPF: " + this.getCpf());
	}
}
