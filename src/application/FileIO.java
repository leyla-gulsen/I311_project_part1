package application;

// Leyla's Class
// all theoretical code, will update when Customer and Order classes etc are finished

/*
 * IMPORTS
 */

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
 * MAIN CLASS
 */

public class FileIO {

    // defining file were data will be stored
    public static final String FILE_NAME = "thneed_data.txt"; // example file name

    // method for loading example customer data
    public static List<Customer> loadCustomers() {
        List<Customer> customers = new ArrayList<>();
		
		// using BufferedReader instead of PrintWriter because it is better for structured data
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
//            read each line from file
            while ((line = reader.readLine()) != null) {
                // read through the line and create customer objects
                // add customer object to customer list
            	 String[] elements = line.split(",");
//            	 getting data from array with indexes
            	 if (elements.length >=3) {
            		 String name = elements[0];
            		 String address = elements[1];
            		 String phone = elements[2];
//            		 new customer object
            		 Customer customer = new Customer(name, address, phone);
//            		 adding to list
            		 customers.add(customer);
            	 }
            }
        } catch (FileNotFoundException e) {
            // case where the file doesn't exist
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customers;
    }
    
    
    
    // method for loading example order data
    public static List<Order> loadOrders() {
        List<Order> orders = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // read through the line and create customer objects
                // add order object to order list
            	String[] elements = line.split(",");
//           	 getting data from array with indexes
            	if (elements.length >= 7) {
            		int orderNumber = Integer.parseInt(elements[0]);
            		int customerId = Integer.parseInt(elements[1]);
            		Date dateOrdered = parseDate(elements[2]);
                    Date dateFilled = parseDate(elements[3]);
                    int quantity = Integer.parseInt(elements[4]);
                    String size = elements[5];
                    String color = elements[6];
                    
                    
//                    find the customer object with the given id
                    Customer customer = findCustomerId(customerId, loadCustomers());
                    if (customer != null ) {
	                    Order order = new Order(customer);
	                    order.setOrderNumber(orderNumber);
	                    order.setDateOrdered(dateOrdered);
	                    order.setDateFilled(dateFilled);
	                    
//	                    creating new thneedOrder object, adding thneedorder to order, adding order to order list
	                    ThneedOrders thneed = new ThneedOrders(quantity, size, color);
	                    order.addThneed(thneed);
	                    orders.add(order);
                    }
            	}
            }
        } catch (FileNotFoundException e) {
            // case where the file doesn't exist
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return orders;
    }
    
//    function to find customer with a given ID
    public static Customer findCustomerId(int customerId, List<Customer> customers) {
//    	loop through list of customers
    	for (int i = 0; i < customers.size(); i++) {
//    		getting current customer object
    		Customer customer = customers.get(i);
    		if (customer.getCustomerId() == customerId) {
//    			returning the customer if found
    			return customer;
    		}
    	}
    	return null;
    }


    public static void saveCustomers(List<Customer> customers) {
    	try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
//    		looping through list of customers
    		for (int i = 0; i < customers.size(); i++) {
    			Customer customer = customers.get(i);
//    			outputting the elements for the customers to the file
    			writer.write(customer.getName() + "," + customer.getAddress() + "," + customer.getPhone() + "\n");
    		}
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    }
    
    public static void saveOrders(List<Order> orders) {
    	try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
//    		looping through list of orders
    		for (int i = 0; i < orders.size(); i++) {
    			Order order = orders.get(i);
//    			writing out orders to file
    			writer.write(order.getorderNumber() + "," + order.getCustomer().getCustomerId() + ","
                        + formatDate(order.getDateOrdered()) + ","
                        + formatDate(order.getDateFilled()) + "\n");
    			
//    			getting the elements from thneedOrders
    			List<ThneedOrders> thneeds = order.getThneeds();
//    			outputting the elements to file from based on specific order
    			for (ThneedOrders thneed : thneeds) {
    				writer.write(thneed.getQuantity() + "," + thneed.getSize() + "," + thneed.getColor() + "\n");
    			}
    		}
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    }

	//    // method to save customer and order data to the file
//    public static void saveData(List<Customer> customers, List<Order> orders) {
//    	try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) { 
//  
//    		for (int i = 0; i < customers.size(); i++) {
//    			Customer customer = customers.get(i); 
//    			writer.write(customer.getName() + "," + customer.getAddress() + "," + customer.getPhone() + "\n");
//    			
//    			List<Order> customerOrders = customer.getpreviousOrders();
//    			for (int j = 0; j < customerOrders.size(); j++) {
//    				Order order = customerOrders.get(j);
//    				writer.write(order.getorderNumber() + "," + customer.getCustomerId() + ","
//                            + formatDate(order.getDateOrdered()) + ","
//                            + formatDate(order.getDateFilled()) + "\n");	
//    				
//    				List<ThneedOrders> thneeds = order.getThneeds();
//    				for (int k = 0; k < thneeds.size(); k++) {
//    					ThneedOrders thneed = thneeds.get(k);
//    					writer.write(order.getorderNumber() + "," + customer.getCustomerId() + ","
//                                + formatDate(order.getDateOrdered()) + ","
//                                + formatDate(order.getDateFilled()) + ","
//                                + thneed.getQuantity() + "," + thneed.getSize() + ","
//                                + thneed.getColor() + "\n");
//    				}
//    			} 
//    		}
//    	} catch (IOException e) {
//    		e.printStackTrace();
//    	}
//    }
    
//    formatting dates with given format
	private static String formatDate(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return dateFormat.format(date);
	}
	
//	parsing dates with given format
	private static Date parseDate(String date) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	    try {
	        return dateFormat.parse(date);
	    } catch (ParseException e) {
	        e.printStackTrace();
	        return null;
	    }
	}
}