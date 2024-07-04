package entities;

public class OrderItem {
	
	private Integer quantity;
	private double price;
	private Product product;
	
	// Construtores
	
	public OrderItem() {
	}

	public OrderItem(Integer quantity, double price, Product product) {
		this.quantity = quantity;
		this.price = price;
		this.product = product;
	}
	
	// Getters e Setters

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	// Método personalizado
	
	public double subTotal() {
		return price * quantity;
	}
}
