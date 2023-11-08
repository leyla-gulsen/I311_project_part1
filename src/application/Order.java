package application;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
	private static int nextOrderID = 1;
	private int orderNumber;
	private Customer customer;
	private Date dateOrdered;
	private Date dateFilled;
	private List<ThneedOrders> thneeds;
	
	// No-arg constructor
	public Order(Customer customer) {
		this.orderNumber = nextOrderID ++;
		this.customer = customer;
		this.thneeds = new ArrayList<>();
		this.dateOrdered = new Date();
		this.dateFilled = null;	
	}
	
	//// access method
	public int getorderNumber() {
		return orderNumber;
	}
	
	//access method
	public Customer getCustomer() {
		return customer;
	}
	
	//access method
	public Date getDateOrdered() {
		return dateOrdered;
	}
	
	//access method
	public Date getDateFilled() {
		return dateFilled;
	}
	
	public List<ThneedOrders> getThneeds() {
		return thneeds;
	}
	
	public void addThneed(ThneedOrders thneed) {
		this.thneeds.add(thneed);
	}

	public void setDateOrdered(Date dateOrdered) {
		this.dateOrdered = dateOrdered;
		
	}

	public void setDateFilled(Date dateFilled) {
		this.dateFilled = dateFilled;
		
	}
}

