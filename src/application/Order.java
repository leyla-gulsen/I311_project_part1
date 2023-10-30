package application;


public class Order {
	private int orderNumber = 0;
	private String size = "Small";
	private String color = "Pink";
	private String customer = "First Last";
	private String dateOrdered = "Month Day Year";
	private String dateFilled = "Month Day Year";

// No-arg constructor
public Order() {
}
public Order(int orderNumber, String size, String color, String customer, String dateOrdered, String dateFilled) {
	this.orderNumber = orderNumber;
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



}

