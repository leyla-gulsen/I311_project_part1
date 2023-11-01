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
    private static final String FILE_NAME = "thneed_data.txt"; // example file name

    // method for loading example customer data
    public static List<Customer> loadCustomers() {
        List<Customer> customers = new ArrayList<>();
		
		// using BufferedReader instead of PrintWriter because it is better for structured data
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // read through the line and create customer objects
                // add customer object to customer list
                
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
            }
        } catch (FileNotFoundException e) {
            // case where the file doesn't exist
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return orders;
    }

    // method to save customer and order data to the file
    public static void saveData(List<Customer> customers, List<Order> orders) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Customer customer : customers) {
                // write customer data into file
            }

            for (Order order : orders) {
                // write order data into file
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}