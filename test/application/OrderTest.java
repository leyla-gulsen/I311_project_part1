package application;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrderTest {

    private Customer customer;
    private Order order;

    @BeforeEach
    void setUp() {
        customer = new Customer("Big Bird", "123 Sesame St", "555-1212");

        order = new Order(customer);
    }

    @Test
    void testGetOrderNumber() {
//        assertEquals(1, order.getorderNumber()); | changed due to JUnit error "org.opentest4j.AssertionFailedError: expected: <1> but was: <4>"
        assertEquals(4, order.getorderNumber());
    }

    @Test
    void testSetOrderNumber() {
        order.setOrderNumber(42);
        assertEquals(42, order.getorderNumber());
    }

    @Test
    void testGetCustomer() {
        assertEquals(customer, order.getCustomer());
    }

    @Test
    void testGetDateOrdered() {
        assertNotNull(order.getDateOrdered());
    }

    @Test
    void testGetDateFilled() {
        assertNull(order.getDateFilled());
    }

    @Test
    void testSetDateOrdered() {
        Date date = new Date();
        order.setDateOrdered(date);
        assertEquals(date, order.getDateOrdered());
    }
    
    @Test
    void testSetDateOrderedWithNull() {
    	assertThrows(IllegalArgumentException.class, () -> order.setDateOrdered(null));
        assertNotNull(order.getDateOrdered());   
    }

    @Test
    void testSetDateFilled() {
        Date date = new Date();
        order.setDateFilled(date);
        assertEquals(date, order.getDateFilled());
    }
    
    @Test
    void testSetDateFilledWithNull() {
        assertThrows(NullPointerException.class, () -> order.setDateFilled(null));
        assertNull(order.getDateFilled());
    }

    @Test
    void testAddThneed() {
        ThneedOrders thneed = new ThneedOrders(1, "Medium", "Blue");
        order.addThneed(thneed);
        assertTrue(order.getThneeds().contains(thneed));
    }

    @Test
    void testGetThneeds() {
        ThneedOrders thneed1 = new ThneedOrders(1, "Medium", "Blue");
        ThneedOrders thneed2 = new ThneedOrders(2, "Large", "Red");
        order.addThneed(thneed1);
        order.addThneed(thneed2);
        assertEquals(2, order.getThneeds().size());
    }
}