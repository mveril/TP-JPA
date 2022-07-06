package org.example;

import org.example.dao.CustomerDao;
import org.example.entity.Customer;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void createCustomer()
    {

        Customer customer = new Customer();
        customer.setFirstName("Alain");
        customer.setLastName("Delon");

        CustomerDao.create(customer);
        assertTrue( true );
    }

    @Test
    public void findByid()
    {
        Customer customer = new Customer();
        customer.setFirstName("Alain");
        customer.setLastName("Delon");
        CustomerDao.create(customer);
        Customer customer1 = CustomerDao.findByid(customer.getId());
        assertEquals("Alain",customer.getFirstName());
    }

    @Test
    public void dontFindByid()
    {
        assertNull(CustomerDao.findByid(5L));
    }
}
