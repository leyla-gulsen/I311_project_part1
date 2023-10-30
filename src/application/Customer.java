package application;

import java.util.UUID;

public class Customer extends Person {
	private UUID id = UUID.randomUUID();
	private String name = "";
	private String address = "";
	private String phone = "";
	
	public Customer(UUID id, String name, String address, String phone) {
		super(name);
		this.id = id;
		this.address = address;
		this.phone = phone;
	}
	
	public String getName() {
		return name;
	}
	
	public UUID getID() {
		return id;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getPhone() {
		return phone;
	}
	
	@Override
	public String toString() {
		return this.getName();
	}
}

class Person {
	private String name = "";
	
	
	public Person(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String newName) {
		if (!newName.equals("")) {
			name = newName;
		}
		else
			System.out.println("Can't change name. Empty names aren't allowed");
	}
}
