package com.enoca.ecommerce.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product", schema = "enoca")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "product_name")
    private String name;
    @Column(name = "product_stock")
    private long stock;
    @Column(name = "product_price")
    private double price;
    @Column(name = "product_description")
    private String description;
    @Column(name = "product_image")
    private String image;
    @Column(name = "product_color")
    private String color;
    @Column(name = "product_brand")
    private String brand;
    @Column(name = "guarantee")
    private String guarantee;
    @Column(name = "ram")
    private long ram;
    @Column(name = "memory")
    private long memory;



    @ManyToOne(cascade ={CascadeType.DETACH, CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne(cascade ={CascadeType.DETACH, CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "costumer_cart")
    private Cart cart;

}
