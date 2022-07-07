package org.example;

import org.example.dao.CustomerDAO;
import org.example.entity.Customer;
import org.example.jpa.EntityManagerSingleton;
import org.junit.Test;

import javax.persistence.EntityManager;
import java.util.List;

import static org.junit.Assert.*;

public class AppTest
{
    @Test
    public void createCustomer()
    {
        Customer customer = new Customer();
        customer.setFirstName("Alain");
        customer.setLastName("Delon");
        CustomerDAO.create(customer);

        assertTrue( true );
    }

    @Test
    public void findById(){
        Customer customer = new Customer();
        customer.setFirstName("Alain");
        customer.setLastName("Delon");
        CustomerDAO.create(customer);

        Customer customer1 = CustomerDAO.findById(customer.getId());
        assertEquals("Alain", customer1.getFirstName());
    }

    @Test
    public void dontFindById() {
        Customer customer = CustomerDAO.findById(5);
        assertNull(customer);
    }

    @Test
    public void findAll() {

        CustomerDAO.create(new Customer("Marie"));
        CustomerDAO.create(new Customer("Michel"));
        CustomerDAO.create(new Customer("Alex"));

        List<Customer> customers = CustomerDAO.findAll();
        assertEquals(3, customers.size());
    }

    @Test
    public void deleteCustomer(){
        Customer marie = new Customer("Marie");
        CustomerDAO.create(marie);

        List<Customer> customers = CustomerDAO.findAll();
        assertEquals(1, customers.size());

        CustomerDAO.delete(marie);

        customers = CustomerDAO.findAll();
        assertEquals(0, customers.size());
    }


    @Test
    public void deleteCustomerById(){
        Customer marie = new Customer("Marie");
        CustomerDAO.create(marie);

        List<Customer> customers = CustomerDAO.findAll();
        assertEquals(1, customers.size());

        CustomerDAO.delete(marie.getId());

        customers = CustomerDAO.findAll();
        assertEquals(0, customers.size());
    }

    @Test
    public void updateCustomer(){
        Customer customer = new Customer();
        customer.setFirstName("Alain");
        customer.setLastName("Delon");
        customer.setAddress("rue de la mairie");
        customer.setCity("Paris");
        customer.setCompanyName("Google");
        customer.setCountry("France");
        customer.setEmail("alain@delon.fr");
        customer.setPhone("060606060606");
        customer.setZipCode("75000");
        customer.setState(1);
        CustomerDAO.create(customer);

        /*****************/

        Customer newCustomerData = new Customer();
        newCustomerData.setFirstName("Jean-Paul");
        newCustomerData.setLastName("Belmondo");

        CustomerDAO.update(customer.getId(), newCustomerData);

        /*****************/

        Customer updatedCustomer = CustomerDAO.findById(customer.getId());
        assertEquals("Jean-Paul", updatedCustomer.getFirstName());
        assertEquals("Belmondo", updatedCustomer.getLastName());

    }

    @Test
    public void updateCustomer2(){
        Customer customer = new Customer();
        customer.setFirstName("Alain");
        customer.setLastName("Delon");
        CustomerDAO.create(customer);
        customer.setLastName("De loin");
        CustomerDAO.update(customer);
        assertEquals("De loin",CustomerDAO.findById(customer.getId()).getLastName());
    }
}