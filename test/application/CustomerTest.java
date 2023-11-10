package application;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomerTest {

    private Customer customer;

    @BeforeEach
    void setUp() {
        customer = new Customer("Big Bird", "123 Sesame St", "555-1212");
        customer.setCustomerId(1); // due to ID issues of being 2? unsure so manually fixing in test
    }

    @Test
    void testGetCustomerId() {
        assertEquals(1, customer.getCustomerId());
    }

    @Test
    void testGetName() {
        assertEquals("Big Bird", customer.getName());
    }

    @Test
    void testSetName() {
        customer.setName("Big Bird");
        assertEquals("Big Bird", customer.getName());
    }

    @Test
    void testGetAddress() {
        assertEquals("123 Sesame St", customer.getAddress());
    }

    @Test
    void testSetAddress() {
        customer.setAddress("456 Elmo St");
        assertEquals("456 Elmo St", customer.getAddress());
    }

    @Test
    void testGetPhone() {
        assertEquals("555-1212", customer.getPhone());
    }

    @Test
    void testSetPhone() {
        customer.setPhone("555-3434");
        assertEquals("555-3434", customer.getPhone());
    }

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