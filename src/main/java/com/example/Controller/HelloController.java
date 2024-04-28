package com.example.Controller;

import com.example.Classes.Address;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("hello")
public class HelloController {
    @PostMapping
    public ResponseEntity<Address> helloPost(@RequestBody Address address ) {
        return ResponseEntity.ok(address);
    }

    @GetMapping
    public Address helloGet() {
        return new Address("Mohamed Al Sebai","Cairo","Al Nozha","72901");
    }
    @DeleteMapping
    public String helloDelete() {
        return "hello Delete Method";
    }
}
