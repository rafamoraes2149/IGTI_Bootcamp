package entidades;

public class Cliente extends Pessoa{
	private String enderešo;

	public String getEnderešo() {
		return enderešo;
	}
	public void setEnderešo(String enderešo) {
		this.enderešo = enderešo;
	}
	
	public void imprimeCliente() {
		System.out.println("Nome: " + this.getNome());
		System.out.println("Enderešo: " + this.enderešo);
		System.out.println("CPF: " + this.getCpf());
	}
}
