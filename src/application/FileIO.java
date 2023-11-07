package application;

// Leyla's Class
// all theoretical code, will update when Customer and Order classes etc are finished

/*
 * IMPORTS
 */

import java.io.*;
import java.util.ArrayList;
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
            while ((line = reader.readLine()) != null) {
                // read through the line and create customer objects
                // add customer object to customer list
            	 String[] elements = line.split(",");
            	 if (elements.length >=3) {
            		 String name = elements[0];
            		 String address = elements[1];
            		 String phone = elements[2];
            		 Customer customer = new Customer(name, address, phone);
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
    
//    function to write new customers to file
//    public static void saveCustomers(List<Customer> customers) {
//    	try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) { 
//    		for (int i = 0; i< customers.size(); i++) {
//    			Customer customer = customers.get(i); 
//    			writer.write(customer.getName() + "," + customer.getAddress() + "," + customer.getPhone() + "\n");
//    			System.out.println(customer.getName() + "," + customer.getAddress() + "," + customer.getPhone());
//    		}
//    	} catch (IOException e) {
//    		e.printStackTrace();
//    	}
//    }

    // method for loading example order data
    public static List<Order> loadOrders() {
        List<Order> orders = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // read through the line and create customer objects
                // add order object to order list
            }
        } catch (FileNotFoundException e) {
            // case where the file doesn't exist
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return orders;
    }

//    // method to save customer and order data to the file
    public static void saveData(List<Customer> customers) {
    	try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) { 
    		for (int i = 0; i< customers.size(); i++) {
    			Customer customer = customers.get(i); 
    			writer.write(customer.getName() + "," + customer.getAddress() + "," + customer.getPhone() + "\n");
    			System.out.println(customer.getName() + "," + customer.getAddress() + "," + customer.getPhone());
    		}
//            for (Order order : orders) {
//                // write order data into file
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}