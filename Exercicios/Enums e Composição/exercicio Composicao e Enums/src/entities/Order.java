package entities;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	
	private static SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private static SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
	
	private Date moment;
	private OrderStatus status;
	private Client client;
	private List<OrderItem> items = new ArrayList<>();
	
	// Construtores
	
	public Order() {
	}
	
	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	// Getters e Setters
	
	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	// Métodos personalizados
	
	public void addItem(OrderItem item) {
		items.add(item);
	}
	
	public void removeItem(OrderItem item) {
		items.remove(item);
	}
	
	public double total() {
		double valorTotal = 0;
		for(OrderItem item : items) {
			valorTotal += item.subTotal();
		}
		return valorTotal;
	}
	
	public String toString() {
	    StringBuilder sb = new StringBuilder();
	    double total = 0.0;

	    sb.append("Order moment: ");
	    sb.append(sdf1.format(moment)).append("\n");
	    
	    sb.append("Order status: ").append(status).append("\n");
	    
	    sb.append("Client: ");
	    sb.append(client.getName()).append(" (");
	    sb.append(sdf2.format(client.getBirthDate())).append(") - ");
	    sb.append(client.getEmail()).append("\n");
	    
	    sb.append("Order items:\n");
	    for(OrderItem item : items) {
	        sb.append(item.getProduct().getName()).append(", ");
	        sb.append("$").append(String.format("%.2f", item.getPrice())).append(", ");
	        sb.append("Quantity: ").append(item.getQuantity()).append(", ");
	        sb.append("Subtotal: $").append(String.format("%.2f", item.subTotal())).append("\n");
	        
	        total += item.subTotal();
	    }
	    
	    sb.append("Total price: $").append(String.format("%.2f", total));
	    
	    return sb.toString();
	}
	
	
}
