package entities;

public class Product {
	
	protected String name;
	protected Double price;
	
	// Construtores
	
	public Product() {
	}

	public Product(String name, Double price) {
		this.name = name;
		this.price = price;
	}
	
	// Getters e Setters

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	// Métodos
	
	public String priceTag() {
		StringBuilder sb = new StringBuilder();
		sb.append(name).append(" $ ").append(String.format("%.2f", price));
		return sb.toString();
	}
	
	

}
