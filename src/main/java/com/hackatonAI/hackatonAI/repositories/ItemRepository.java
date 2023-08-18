package com.hackatonAI.hackatonAI.repositories;

import com.hackatonAI.hackatonAI.Item;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends MongoRepository<Item, String> {

    public List<Item> findItemBySku(String sku);
}