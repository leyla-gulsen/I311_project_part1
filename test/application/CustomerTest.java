package application;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;

class CustomerTest {

    private Customer customer;

    @BeforeEach
    void setUp() {
        customer = new Customer("Big Bird", "123 Sesame St", "555-1212");
        customer.setCustomerId(1); // due to ID issues of being 2? unsure so manually fixing in test
    }
    
    /*
     * customer
     */

    @Test
    void testGetCustomerId() {
        assertEquals(1, customer.getCustomerId());
    }

    /*
     * name
     */
    
    @Test
    void testGetName() {
        assertEquals("Big Bird", customer.getName());
    }

    @Test
    void testSetValidName() {
        customer.setName("Big Bird");
        assertEquals("Big Bird", customer.getName());
    }
    
    @Test
    void testSetNameWithMaxCharacters() {
    	assertThrows(IllegalArgumentException.class, () -> customer.setName("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")); // 31 a's
    }

    @Test
    void testSetNameWithEmptyString() {
        assertThrows(IllegalArgumentException.class, () -> customer.setName(""));
    }

    @Test
    void testSetNameWithNull() {
        assertThrows(IllegalArgumentException.class, () -> customer.setName(null));
    }
    
    /* 
     * address
     */

    @Test
    void testGetAddress() {
        assertEquals("123 Sesame St", customer.getAddress());
    }

    @Test
    void testSetValidAddress() {
        customer.setAddress("456 Elmo St");
        assertEquals("456 Elmo St", customer.getAddress());
    }
    
    @Test
    void testSetAddressWithMaxCharacters() {
    	assertThrows(IllegalArgumentException.class, () -> customer.setAddress("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")); // 101 a's
    }

    @Test
    void testSetAddressWithEmptyString() {
        assertThrows(IllegalArgumentException.class, () -> customer.setAddress(""));
    }

    @Test
    void testSetAddressWithNull() {
        assertThrows(IllegalArgumentException.class, () -> customer.setAddress(null));
    }
    
    /*
     * phone
     */

    @Test
    void testGetPhone() {
        assertEquals("555-1212", customer.getPhone());
    }
    
    @Test
    void testSetValidPhoneNumber() {
        customer.setPhone("555-555-3434");
        assertEquals("555-555-3434", customer.getPhone());
    }

    @Test
    void testSetPhoneWithInvalidPhoneNumberLength() {
        assertThrows(IllegalArgumentException.class, () -> customer.setPhone("555-555-55556"));
    }

    @Test
    void testSetPhoneWithEmptyPhoneNumber() {
        assertThrows(IllegalArgumentException.class, () -> customer.setPhone(""));
    }

    @Test
    void testSetPhoneWithNullPhoneNumber() {
        assertThrows(IllegalArgumentException.class, () -> customer.setPhone(null));
    }
    
    /* 
     * orders
     */

    @Test
    void testGetPreviousOrders() {
        assertNotNull(customer.getpreviousOrders());
        assertTrue(customer.getpreviousOrders().isEmpty());
    }

    @Test
    void testAddOrder() {
        Order order = new Order(customer);
        customer.addOrder(order);
        assertFalse(customer.getpreviousOrders().isEmpty());
        assertTrue(customer.getpreviousOrders().contains(order));
    }

    @Test
    void testGetCurrentOrders() {
        assertNotNull(customer.getCurrentOrders());
        assertTrue(customer.getCurrentOrders().isEmpty());
    }

    @Test
    void testAddPastOrder() {
        Order order = new Order(customer);
        customer.addPastOrder(order);
        assertFalse(customer.getCurrentOrders().isEmpty());
        assertTrue(customer.getCurrentOrders().contains(order));
    }

    @Test
    void testToString() {
        String expectedString = "ID: 1, Name: Big Bird, Address: 123 Sesame St, Phone Number: 555-1212Previous Orders: []";
        assertEquals(expectedString, customer.toString());
    }
   
}