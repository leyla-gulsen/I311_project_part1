package application;

import java.util.ArrayList;

public class Order {
	private static int nextOrderID = 1;
	private int orderNumber;
	private String size = "Small";
	private String color = "Pink";
	private String customer = "First Last";
	private String dateOrdered = "Month Day Year";
	private String dateFilled = "Month Day Year";
	//Add ArrayList to Controller
	//public ArrayList<Order> thneedOrders;

// No-arg constructor
public Order() {
}

public Order(int orderNumber, String size, String color, String customer, String dateOrdered, String dateFilled) {
	this.orderNumber = nextOrderID ++;
	this.size = size;
	this.color = color;
	this.customer = customer;
	this.dateOrdered = dateOrdered;
	this.dateFilled = dateFilled;
	
}


// access method
public int getorderNumber() {
	return orderNumber;
}

//access method
public String getSize() {
	return size;
}

//access method
public String getColor() {
	return color;
}

//access method
public String getCustomer() {
	return customer;
}

//access method
public String getDateOrdered() {
	return dateOrdered;
}

//access method
public String getDateFilled() {
	return dateFilled;
}

public ArrayList<Order> getOrders(){
	return thneedOrders;
}

public void addOrder(Order order) {
	thneedOrders.add(order);
}



}

