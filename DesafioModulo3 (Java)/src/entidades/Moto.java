package entidades;

public class Moto extends Veiculo{
	private Vendedor vendedor;
	private Cliente cliente;
	
	public Vendedor getVendedor() {
		return vendedor;
	}
	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public void imprimeMoto() {
		System.out.println("Modelo: " + this.getModelo());
		System.out.println("Marca: " + this.getMarca());
		System.out.printf("Ano: %d\n", this.getAno());
		System.out.printf("Valor: %.2f\n", this.getValor());
		if (this.vendedor == null)
			System.out.println("Vendedor não cadastrado!");
		else
			System.out.println("Vendedor: " + this.vendedor.getNome());
		if (this.cliente == null)
			System.out.println("Cliente não cadastrado!");
		else
			System.out.println("Cliente: " + this.cliente.getNome() + " " + this.cliente.getEndereço() 
									+ " " + this.cliente.getCpf());
	}
}
