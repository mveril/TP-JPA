package org.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.example.dao.CustomerDao;
import org.example.entity.Customer;
import org.junit.Test;

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
}
