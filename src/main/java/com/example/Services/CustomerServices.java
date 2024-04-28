package com.example.Services;

import com.example.Classes.Customer;
import com.example.Dao.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServices {
    @Autowired
    private CustomerDao customerDao;

    public List<Customer> getAllCustomers() {
        return customerDao.getAllCustomers();
    }
    public Customer getCustomerById(int id) {
        return customerDao.getCustomer(id);
    }
    public void addCustomer(Customer customer) {
        customerDao.save(customer);
    }
    public void updateCustomer(int id, Customer customer) {
        Customer c = customerDao.getCustomer(id);
        c.setFirstName(customer.getFirstName());
        c.setLastName(customer.getLastName());
        c.setEmail(customer.getEmail());
        customerDao.update(c);
    }
    public void deleteCustomer(int id) {
        customerDao.delete(id);
    }
}
