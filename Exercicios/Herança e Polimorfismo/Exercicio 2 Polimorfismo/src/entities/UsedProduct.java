package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UsedProduct extends Product {
	
	private static final SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");
	
	private Date manufactureDate;
	
	// Construtores
	
	public UsedProduct() {
		super();
	}

	public UsedProduct(String name, Double price, Date manufactureDate) {
		super(name, price);
		this.manufactureDate = manufactureDate;
	}

	// Getters e Setters
	
	public Date getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}
	
	// Métodos
	
	@Override
	public String priceTag() {
		StringBuilder sb = new StringBuilder();
		sb.append(name).append(" (used) $ ").append(String.format("%.2f", price));
		sb.append(" (Manufacture date: ").append(SDF.format(manufactureDate)).append(")");
		return sb.toString();
	}
	
}
