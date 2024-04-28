package com.example.Controller;

import com.example.Classes.Customer;
import com.example.Dao.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customer")
public class CustomerRestController {

        @Autowired
        private CustomerDao customerDao ;

        @GetMapping("{id}")
        public Customer getCustomer(@PathVariable int id) {

            return customerDao.getCustomer(id);
        }
        @PostMapping
        public Customer addCustomer(@RequestBody Customer customer) {
            customerDao.save(customer);
            return customer;
        }
        @GetMapping
        public List<Customer> getAllCustomers() {
            return customerDao.getAllCustomers();
        }
        @DeleteMapping("{id}")
        public ResponseEntity deleteCustomer(@PathVariable int id) {
            customerDao.delete(id);
            return ResponseEntity.ok("Deleted Customer with id " + id);
        }
        @PutMapping("{id}")
        public ResponseEntity updateCustomer(@PathVariable("id") int id,@RequestBody Customer customer){
            customer.setId(id);
            customerDao.update(customer);
            return ResponseEntity.ok("Updated Customer with id " + id);
        }
}
