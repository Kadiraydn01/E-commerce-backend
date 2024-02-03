package com.enoca.ecommerce.service;

import com.enoca.ecommerce.entity.Cart;
import com.enoca.ecommerce.entity.Customer;
import org.springframework.stereotype.Service;


public interface CartService {
    Cart createCart(Cart cart, Customer customer);
    Cart getCart(long id);
    Cart updateCart(Cart cart);
    void deleteCart(long id);
}
