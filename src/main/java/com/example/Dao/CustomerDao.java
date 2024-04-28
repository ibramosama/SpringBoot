package com.example.Dao;

import com.example.Classes.Customer;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDao {
    @Autowired
    private EntityManager em;
    @Autowired
    private NewCustomerDao newCustomerDao;

    public Customer getCustomer(int id) {
        return em.find(Customer.class, id);
    }

    @Transactional
    public void save(Customer customer) {
        em.persist(customer);
    }

    @Transactional
    public void update(Customer customer) {
        em.merge(customer);
    }
    @Transactional
    public void delete(int id) {
        em.remove(em.find(Customer.class, id));
    }
    @Transactional
    public List getAllCustomers() {
        return em.createQuery("from Customer c").getResultList();
    }
}
