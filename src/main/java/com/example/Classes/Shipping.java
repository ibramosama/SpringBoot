package com.example.Classes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
public class Shipping {
    private int id;
    private Address address;
    private int code;
    private boolean isShipping;
}
