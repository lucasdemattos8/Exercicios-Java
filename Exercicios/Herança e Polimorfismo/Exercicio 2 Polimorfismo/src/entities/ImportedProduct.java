package entities;

public class ImportedProduct extends Product{

	private Double customsFee;
	
	// Construtores
	
	public ImportedProduct() {	
		super();
	}

	public ImportedProduct(String name, Double price, Double customsFee) {
		super(name, price);
		this.customsFee = customsFee;
	}

	// Getters e Setters
	
	public Double getCustomsFee() {
		return customsFee;
	}

	public void setCustomsFee(Double customsFee) {
		this.customsFee = customsFee;
	}
	
	// Métodos
	
	public Double totalPrice() {
		return price + customsFee;
	}
	
	@Override
	public String priceTag() {
		StringBuilder sb = new StringBuilder();
		sb.append(name).append(" $ ").append(String.format("%.2f", totalPrice()));
		sb.append(" (Customs fee: $ ").append(String.format("%.2f", customsFee)).append(")");
		return sb.toString();
	}
}
