package com.enoca.ecommerce.service;

import com.enoca.ecommerce.entity.Cart;
import com.enoca.ecommerce.entity.Customer;
import com.enoca.ecommerce.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService{
    @Autowired
    private CartRepository cartRepository;
    @Override
public Cart createCart(Cart cart, Customer customer) {
    
    Cart existingCart = cartRepository.findCartByCustomerId(customer.getId());
    if (existingCart != null) {
        existingCart.setQuantity(existingCart.getQuantity() + cart.getQuantity());
        return existingCart;
    } else {
        
        Cart newCart = new Cart();
        newCart.setQuantity(cart.getQuantity());
        newCart.setTotalPrice(cart.getTotalPrice());
        newCart.setCustomer(customer);
        return cartRepository.save(newCart);
    }
}

    @Override
    public Cart getCart(long id) {
        return cartRepository.findById(id).orElse(null);
    }

    @Override
    public Cart updateCart(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public void deleteCart(long id) {
        cartRepository.deleteById(id);
    }

}
