package com.itemtransaction.controllers;

import java.util.List;

import com.itemtransaction.dto.CartTotalPrice;
import com.itemtransaction.models.CartModels;
import com.itemtransaction.services.CartServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartServices cartServices;

    @GetMapping("/{userId}")
    public Iterable<CartModels> findByUserId(@PathVariable("userId") Long userId){
        return cartServices.showItems(userId);
    }
    @PostMapping
    public CartModels addItem(@RequestBody CartModels cartModels){
        return cartServices.addItem(cartModels);
    }
    @PostMapping("/saveAll")
    public Iterable<CartModels> addItems(@RequestBody Iterable<CartModels> cartModels){
        return cartServices.addItems(cartModels);
    }
    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable("id") Long id){
        cartServices.deleteItem(id);
    }
    @DeleteMapping
    public void deleteItems(@RequestBody List<CartModels> cartModels){
        cartServices.deleteItems(cartModels);
    }
    @GetMapping("/price/{userId}")
    public CartTotalPrice countTotalPrice(@PathVariable("userId") Long userId){
        return cartServices.countTotalPrice(userId);
    }
}
