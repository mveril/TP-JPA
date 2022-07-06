package org.example;

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
}
