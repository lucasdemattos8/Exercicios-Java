package entities;

public class Products {
	
	private String nome;
	private int quantidade;
	private double valor;
	
	// Construtores
	
	public Products() {
	}

	public Products(String nome, int quantidade, double valor) {
		this.nome = nome;
		this.quantidade = quantidade;
		this.valor = valor;
	}
	
	// Getters e Setters

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	// Métodos
	
	public double valorTotal() {
		return valor * quantidade;
	}
	

}
