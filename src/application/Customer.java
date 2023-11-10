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

	/* 
	 * customer
	 */
    
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
	
	/*
	 * name
	 */
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
//        // added boundary case for empty string (didn't input name)
//        if (name == null || name.isEmpty()) {
//            throw new IllegalArgumentException("Name cannot be empty.");
//        }
//        
//        // added boundary case for max length of the name
//        if (name.length() > 30) {
//            throw new IllegalArgumentException("Name must not exceed 30 characters.");
//        }
		this.name = name;
	}
	
	/*
	 * address
	 */
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
//		// added boundary case for empty string (didnt input address)
//	    if (address == null || address.isEmpty()) {
//	        throw new IllegalArgumentException("Address cannot be empty.");
//	    }
//	    
//	    // added boundary case for max length of address
//	    if (address.length() > 100) {
//	        throw new IllegalArgumentException("Address must not exceed 100 characters.");
//	    }
		this.address = address;
	}
	
	/*
	 * phone
	 */
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
//		// added boundary case for empty string (didn't input phone number)
//	    if (phone == null || phone.isEmpty()) {
//	        throw new IllegalArgumentException("Phone number cannot be empty.");
//	    }
//	    
//	    // added boundary case for max set of numbers AND regular expression for dashes (-)
//	    if (!phone.matches("\\d{3}-\\d{3}-\\d{4}")) {
//	        throw new IllegalArgumentException("Invalid phone number format. Use the format: 555-555-5555");
//	    }
	    
		this.phone = phone;
	}
	
	/*
	 * orders
	 */
	
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
	
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
}