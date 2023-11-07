package application;

import java.util.ArrayList;

public class Customer {
    private static int nextCustomerId = 1;
    private int customerId;
	private String name;
	private String address;
	private String phone;
    public ArrayList<Order> previousOrders;
    public ArrayList<Order> currentOrders;

	
	public Customer(String name, String address, String phone) {
		 this.customerId = nextCustomerId++;
	     this.name = name;
	     this.address = address;
	     this.phone = phone;
	     this.previousOrders = new ArrayList<>();
	     this.currentOrders = new ArrayList<>();
	}
	
	public int getCustomerId() {
		return customerId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public ArrayList<Order> getpreviousOrders(){
		return previousOrders;
	}
	
	public void addOrder(Order previousOrder) {
		this.previousOrders.add(previousOrder);
	}
	
	public ArrayList<Order> getCurrentOrders() {
		return currentOrders;
	}
	
	public void addPastOrder(Order order) {
		this.currentOrders.add(order);
	}
	
	public String toString() {
		return "ID: " + customerId + ", Name: " + name + ", Address: " + address + ", Phone Number: " + phone + "Previous Orders: " + previousOrders;
	}
}