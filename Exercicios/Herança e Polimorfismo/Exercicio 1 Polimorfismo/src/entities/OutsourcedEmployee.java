package entities;

public class OutsourcedEmployee extends Employee{
	
	private Double additionalCharge;
	
	// Construtores
	
	public OutsourcedEmployee() {
		super();
	}

	public OutsourcedEmployee(String name, Integer hours, Double valuePerHour, Double additionalCharge) {
		super(name, hours, valuePerHour);
		this.additionalCharge = additionalCharge;
	}
	
	// Getters e setters

	public Double getAdditionalCharge() {
		return additionalCharge;
	}

	public void setAdditionalCharge(Double additionalCharge) {
		this.additionalCharge = additionalCharge;
	}

	// Métodos personalizados
	@Override
	public double payment() {
		double salarioBruto = super.payment();
		return salarioBruto + (additionalCharge * 1.1);
	}
	
}
