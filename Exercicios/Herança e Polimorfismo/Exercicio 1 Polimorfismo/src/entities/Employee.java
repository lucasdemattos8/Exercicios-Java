package entities;

public class Employee {
	
	private String name;
	private Integer hours;
	private Double valuePerHour;

	// Construtores
	
	public Employee() {
	}
	
	public Employee(String name, Integer hours, Double valuePerHour) {
		this.name = name;
		this.hours = hours;
		this.valuePerHour = valuePerHour;
	}
	
	// Getters e Setters

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getHours() {
		return hours;
	}

	public void setHours(Integer hours) {
		this.hours = hours;
	}

	public Double getValuePerHour() {
		return valuePerHour;
	}

	public void setValuePerHour(Double valuePerHour) {
		this.valuePerHour = valuePerHour;
	}

	// Métodos
	
	public double payment() {
		return hours * valuePerHour;
	}

	@Override
	public String toString() {
		return name + "- $" + String.format("%.2f", payment());
	}
	
}
