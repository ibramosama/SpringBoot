package com.example.Dao;

import com.example.Classes.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NewCustomerDao extends JpaRepository<Customer,Integer> {
    public Customer findCustomerByEmail(String email);
    public Customer findCustomerByFirstName(String firstName);
    public Customer findCustomerByLastName(String lastName);
    @Query("from Customer c where c.firstName like ?1 or c.email like ?1")
    public List<Customer> findCustomerByFirstNameOrEmail(String firstName);
}
