package com.enoca.ecommerce.controller;
import com.enoca.ecommerce.entity.Cart;
import com.enoca.ecommerce.entity.Customer;
import com.enoca.ecommerce.service.CartService;
import com.enoca.ecommerce.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;
    @Autowired
    private CustomerService customerService;



    @PostMapping("/add")
    public ResponseEntity<Cart> createCart(@RequestBody Cart cart, @RequestParam long customerId) {
        Customer customer = customerService .getCustomer(customerId);
        if (customer != null) {
            return ResponseEntity.ok(cartService.createCart(cart, customer));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Cart> getCart(@PathVariable long id) {
        Cart cart = cartService.getCart(id);
        if (cart != null) {
            return ResponseEntity.ok(cart);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Cart> updateCart(@RequestBody Cart cart) {
        return ResponseEntity.ok(cartService.updateCart(cart));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCart(@PathVariable long id) {
        cartService.deleteCart(id);
        return ResponseEntity.noContent().build();
    }
}
