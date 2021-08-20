package com.itemtransaction.dto;

import com.itemtransaction.models.CartModels;

public class CartPriceItem extends CartModels {
    private Double price;

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    
}
