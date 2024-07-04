package entities;

import entities.enums.Color;

public abstract class Shape {
	
	Color color;
	
	// Construtores
	
	public Shape(){
	}
	
	public Shape(Color color) {
		this.color = color;
	}
	
	// Getters e Setters

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	// Método
	
	public abstract Double area();

}
