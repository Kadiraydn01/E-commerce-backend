package com.enoca.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
    private long id;
    private String name;
    private double price;
    private long stock;
    private String description;
    private String image;
    private String color;
    private String brand;
    private String guarantee;
    private long ram;
    private long memory;



}
