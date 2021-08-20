package com.itemtransaction.repos;

import com.itemtransaction.models.CartModels;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.PathVariable;

public interface CartRepo extends CrudRepository<CartModels, Long> {
    
    @Query("Select a FROM CartModels a where userId = :userId")
    public Iterable<CartModels> findByUserId(Long userId); 

    @Query(value="Select SUM(price*quantity) as price from tr_cart c join m_item i on c.item_id=i.id where user_id=:userId",nativeQuery = true)
    public Double countTotalPrice(@PathVariable("userId") Long userId); 
}
