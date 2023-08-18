package com.hackatonAI.hackatonAI.services;

import com.hackatonAI.hackatonAI.Item;
import com.hackatonAI.hackatonAI.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<Item> findItemBySku(String sku) {
        return itemRepository.findItemBySku(sku);
    }
}
