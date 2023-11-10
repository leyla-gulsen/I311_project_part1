/*
 * !!! IMPORTANT !!!
 * 
 * Leyla made these tests on her local PC that has JUnit 5 (Jupiter)
 * This file does NOT pass due to issues with how FileIO.java runs. 
 * FileIO.java runs, but in ways that are confusing that was hard to make tests for.
 * Leyla will add screenshots to the documentation showing how the tests do NOT work in this file.
 * 
 */


package application;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FileIOTest {

    private static final String TEST_FILE_NAME = "test_thneed_data.txt";

    /*
     * creating and deleting a temporary file for testing
     */
    
    @BeforeEach
    void setUp() {
        // create temporary file for testing
        try {
            Files.createFile(Paths.get(TEST_FILE_NAME));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterEach
    void tearDown() {
        // delete the temporary file after each test
        try {
            Files.deleteIfExists(Paths.get(TEST_FILE_NAME));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /*
     * loading customers and orders
     */

    @Test
    void testLoadCustomers() {
        // random data to file
        String testData = "Big Bird,123 Sesame St,555-555-1212\nElmo Mo,456 Elmo St,555-3434";
        writeToFile(TEST_FILE_NAME, testData);

        // load customers from the temporary file
        List<Customer> customers = FileIO.loadCustomers(TEST_FILE_NAME);

        assertEquals(2, customers.size());
        assertEquals("Big Bird", customers.get(0).getName());
        assertEquals("Elmo Mo", customers.get(1).getName());
    }

    @Test
    void testLoadOrders() {
    	// random data to file
    	String testData = "1,1,01-01-2023,02-01-2023\n2,2,03-01-2023,04-01-2023\n3,3,05-01-2023,06-01-2023\n4,4,07-01-2023,08-01-2023";
        writeToFile(TEST_FILE_NAME, testData);

        // load orders from the temporary file
        List<Order> orders = FileIO.loadOrders(TEST_FILE_NAME);

        assertEquals(2, orders.size());
        assertEquals(2, orders.get(0).getThneeds().size());
        assertEquals("Small", orders.get(1).getThneeds().get(0).getSize());
        assertEquals("Red", orders.get(1).getThneeds().get(0).getColor());
    }
    
    /*
     * saving customers and orders
     */

    @Test
    void testSaveCustomers() {
        // create a list of customers
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Big Bird", "123 Sesame St", "555-555-1212"));
        customers.add(new Customer("Elmo Mo", "456 Elmo St", "555-555-3434"));

        // save customers to the temporary file
        FileIO.saveCustomers(TEST_FILE_NAME, customers);
        String fileContent = readFile(TEST_FILE_NAME);

        assertTrue(fileContent.contains("Big Bird,123 Sesame St,555-555-1212"));
        assertTrue(fileContent.contains("Elmo Mo,456 Elmo St,555-555-3434"));
    }

    @Test
    void testSaveOrders() {
        // create a list of orders
        List<Order> orders = new ArrayList<>(Arrays.asList(
                new Order(new Customer("Big Bird", "123 Sesame St", "555-555-1212")),
                new Order(new Customer("Elmo Mo", "456 Elmo St", "555-555-3434"))
        ));

        // save orders to the temporary file
        FileIO.saveOrders(TEST_FILE_NAME, orders);
        String fileContent = readFile(TEST_FILE_NAME);

        assertTrue(fileContent.contains("1,1,01-01-2023,02-01-2023,"));
        assertTrue(fileContent.contains("2,2,03-01-2023,04-01-2023,"));
    }
    
    /* 
     * read and writing file
     */

    // write data to a file
    private void writeToFile(String fileName, String content) {
        try {
            Files.write(Paths.get(fileName), content.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // read the content of a file
    private String readFile(String fileName) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));
            return String.join(System.lineSeparator(), lines);
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
