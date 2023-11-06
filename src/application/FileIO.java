package application;

// Leyla's Class
// all theoretical code, will update when Customer and Order classes etc are finished

/*
 * IMPORTS
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import application.Customer;
import application.Order;

/*
 * MAIN CLASS
 */

public class FileIO {

    // defining file were data will be stored
    private static final String FILE_NAME = "thneed_data.txt"; // example file name

    // method to save the customer and order data to the file
    public static void saveData(List<Customer> customers, List<Order> orders) {
		
		// using BufferedWriter instead of PrintWriter because it is better for structured data
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
        	// loop through each customer
            for (Customer customer : customers) {
            	// write customer data to the file
            	writer.write(customer.getCustomerId() + "," + customer.getName() + "," + customer.getAddress() + "," + customer.getPhone());
            	writer.newLine();
            	
            	// loop through each order associated with the customer
            	for (Order order : customer.getOrders()) {
            		// write the order information to the file
            		writer.write(order.getorderNumber() + "," + order.getSize() + "," + order.getColor() + "," + order.getCustomer() + "," + order.getDateOrdered() + "," + order.getDateFilled());
                    writer.newLine();
            	}
            }
            // loop through each solo order that are not with a customer
            for (Order order : orders) {
            	// write order to file
            	writer.write(order.getorderNumber() + "," + order.getSize() + "," + order.getColor() + "," + order.getCustomer() + "," + order.getDateOrdered() + "," + order.getDateFilled());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    //method to load customoer data from the file
    public static List<Customer> loadCustomers() {
    	List<Customer> customers = new ArrayList<>();
    	try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
    		String line;
    		while ((line = reader.readLine()) != null) {
    			// split line into an array of values
    			String[] customerData = line.split(",");
    			int customerId = Integer.parseInt(customerData[0]);
    			String name = customerData[1];
    			String address = customerData[2];
                String phone = customerData[3];
                
                // create a new customer object and add to the list
                Customer customer = new Customer(name, address, phone);
                customer.setCustomerId(customerId);
                customers.add(customer);
    		}
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return customers;
    }
    
    
    // method to load order data from file
    public static List<Order> loadOrders() {
        List<Order> orders = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
            	// split line into an array of values
                String[] orderData = line.split(",");
                int orderNumber = Integer.parseInt(orderData[0]);
                String size = orderData[1];
                String color = orderData[2];
                String customer = orderData[3];
                String dateOrdered = orderData[4];
                String dateFilled = orderData[5];
                
                // create a new order object and add it to the list
                Order order = new Order(orderNumber, size, color, customer, dateOrdered, dateFilled);
                orders.add(order);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return orders;
    }
}

//    // method for loading example order data
//    public static List<Order> loadOrders() {
//        List<Order> orders = new ArrayList<>();
//
//        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                // read through the line and create customer objects
//                // add order object to order list
//            }
//        } catch (FileNotFoundException e) {
//            // case where the file doesn't exist
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return orders;
//    }
//            while ((line = reader.readLine()) != null) {
//                // read through the line and create customer objects
//                // add customer object to customer list
//            	
//            	String[] customerData = line.split(","); // this is assuming data is comma separated, hard to tell as of right now
//            	
//            	int customerId = Integer.parseInt(customerData[0].substring(customerData[0].indexOf(": ") + 2));
//                String name = customerData[1].substring(customerData[1].indexOf(": ") + 2);
//                String address = customerData[2].substring(customerData[2].indexOf(": ") + 2);
//                String phone = customerData[3].substring(customerData[3].indexOf(": ") + 2);
//
//                Customer customer = new Customer(name, address, phone);
//                customer.setCustomerId(customerId);
//                customers.add(customer);
//                
//            }
//        } catch (FileNotFoundException e) {
//            // case where the file doesn't exist
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return customers;
//    }
//    // method to save customer and order data to the file
//    public static void saveData(List<Customer> customers, List<Order> orders) {
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
//            for (Customer customer : customers) {
//                // write customer data into file
//            }
//
//            for (Order order : orders) {
//                // write order data into file
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}