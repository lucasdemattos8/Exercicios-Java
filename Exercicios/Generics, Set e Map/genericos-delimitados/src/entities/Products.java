package entities;

public class Products implements Comparable<Products> {
	
	private String name;
	private Double price;
	
	public Products() {
	}
	
	public Products(String nome, Double preco) {
		this.name = nome;
		this.price = preco;
	}

	public String getNome() {
		return name;
	}

	public void setNome(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public int compareTo(Products o) {
		return price.compareTo(o.getPrice());
	}

	@Override
	public String toString() {
		return "Products " + name + ", $" + price;
	}

	
}
