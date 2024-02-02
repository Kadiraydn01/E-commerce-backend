package com.enoca.ecommerce.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cart", schema = "enoca")
public class Cart {
    @Id
    private long id;
    

    private int quantity;
    private double totalPrice;
    

}
