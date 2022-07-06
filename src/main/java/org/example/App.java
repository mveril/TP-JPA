package org.example;

import org.example.dao.CustomerDao;
import org.example.entity.Customer;
import org.example.jpa.EntityManagerSingleton;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        Customer customer = new Customer();
        customer.setFirstName("Alain");
        customer.setLastName("Delon");

        CustomerDao.create(customer);
    }
}
