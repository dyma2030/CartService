package com.itemtransaction.services;

import java.util.List;

import javax.transaction.Transactional;

import com.itemtransaction.dto.CartTotalPrice;
import com.itemtransaction.models.CartModels;
import com.itemtransaction.repos.CartRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class CartServices {
    
    @Autowired
    private CartRepo cartRepo;

    public Iterable<CartModels> showItems(Long userId){
        return cartRepo.findByUserId(userId);
    }
    public CartModels addItem(CartModels cartModels){
        return cartRepo.save(cartModels);
    }
    public Iterable<CartModels> addItems(Iterable<CartModels> cartModels){
        return cartRepo.saveAll(cartModels);
    }
    public void deleteItem(Long id){
        cartRepo.deleteById(id);
    }
    public void deleteItems(List<CartModels> cartModels){
        for(int i = 0; i < cartModels.size();i++){
            cartRepo.deleteById(cartModels.get(i).getCartId());
        } 
    }
    public CartTotalPrice countTotalPrice(Long id){
        CartTotalPrice cartTotalPrice = new CartTotalPrice();
        cartTotalPrice.setTotalPrice(cartRepo.countTotalPrice(id));
        return cartTotalPrice;
    }
}
