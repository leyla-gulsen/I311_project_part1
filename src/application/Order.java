package application;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
	private static int nextOrderNumber = 1;
	private int orderNumber;
	private Customer customer;
	private Date dateOrdered;
	private Date dateFilled;
	private List<ThneedOrders> thneeds;
	
	// No-arg constructor
	public Order(Customer customer) {
		this.orderNumber = nextOrderNumber;
		this.customer = customer;
		this.thneeds = new ArrayList<>();
		this.dateOrdered = new Date();
		this.dateFilled = null;	
		nextOrderNumber ++;
	}
	
	//// access method
	public int getorderNumber() {
		return orderNumber;
	}
	
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
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
	
	public void addThneed(ThneedOrders thneed) {
		this.thneeds.add(thneed);
	}
	
	public List<ThneedOrders> getThneeds() {
		return thneeds;
	}

	public void setDateOrdered(Date dateOrdered) {
		// added boundary for if date is null
//	    if (dateOrdered == null) {
//	        throw new IllegalArgumentException("Date cannot be empty.");
//	    }
		this.dateOrdered = dateOrdered;	
	}

	public void setDateFilled(Date dateFilled) {
		// added boundary for if date is null
//        if (dateFilled == null) {
//            throw new NullPointerException("Date cannot be empty.");
//        }
		this.dateFilled = dateFilled;
	}

}

