package application;

import java.util.ArrayList;

public class Customer {
    private static int nextCustomerId = 1;

    private int customerId;
	private String name;
	private String address;
	private String phone;
    private ArrayList<Order> orders;

	
	public Customer(String name, String address, String phone) {
		 this.customerId = nextCustomerId++;
	     this.name = name;
	     this.address = address;
	     this.phone = phone;
	     this.orders = new ArrayList<>();
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
	
	public ArrayList<Order> getOrders(){
		return orders;
	}
	
	public void addOrder(Order order) {
		orders.add(order);
	}
	
	public String toString() {
		return "ID: " + customerId + ", Name: " + name + ", Address: " + address + ", Phone Number: " + phone + "Previous Orders: " + orders;
	}
}