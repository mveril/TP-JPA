package org.example.dao;

import org.example.entity.Customer;
import org.example.jpa.EntityManagerSingleton;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class CustomerDAO {

    public static void create(Customer customerToCreate) {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(customerToCreate);
        tx.commit();
    }

    public static Customer findById(long id) {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        Customer customer = entityManager.find(Customer.class, id);

        return customer;
    }

    public static List<Customer> findAll() {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        Query findAllQuery = entityManager.createQuery("select c from Customer c");
        return findAllQuery.getResultList();
    }

    public static void delete(Customer customer) {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.remove(customer);
        tx.commit();
    }

    public static void delete(long customerId) {
        delete(findById(customerId));
    }

    public static void update(Long id, Customer newCustomerData) {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        Customer customerToUpdate = entityManager.find(Customer.class, id);
        customerToUpdate.setNotNullData(newCustomerData);

        EntityTransaction tx = null;
        try {
            tx = entityManager.getTransaction();
            tx.begin();
            entityManager.merge(customerToUpdate);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }
    }

    public static void update(Customer customer) {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();
        EntityTransaction tx = null;
        try {
            tx = entityManager.getTransaction();
            tx.begin();
            entityManager.merge(customer);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }
    }
}