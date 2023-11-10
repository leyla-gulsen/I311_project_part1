package application;

public class ThneedOrders {
	private int quantity;
	private String size;
	private String color;
	
	public ThneedOrders(int quantity, String size, String color) {
		this.quantity = quantity;
		this.size = size;
		this.color = color;
	}
	
//	quantity
//	access method
	public int getQuantity() {
		return quantity;
	}
//	setter method quantity
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
//	Size
	//access method
	public String getSize() {
		return size;
	}
//	setter method size
	public void setSize(String size) {
		this.size = size;
	}
	
//	Color
	//access method
	public String getColor() {
		return color;
	}
//	setter method color
	public void setColor(String color) {
		this.color = color;
	}
}
