package com.hackatonAI.hackatonAI;

import com.hackatonAI.hackatonAI.services.ItemService;
import com.hackatonAI.hackatonAI.services.WatingProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class VeriyNotification {
    private final WatingProductService waitingProductService;
    private final ItemService itemService;

    @Autowired
    public VeriyNotification(WatingProductService waitingProductService, ItemService itemService) {
        this.waitingProductService = waitingProductService;
        this.itemService = itemService;
    }

    public void getAllWaitingProducts() {
        System.out.println("Checking waiting products");

        List<WaitingProduct> allWaitingProducts = waitingProductService.getAllWaitingProducts();


        allWaitingProducts.forEach(waitingProduct -> {

            String sku = waitingProduct.getSku();
            Optional<Item> itemBySku = itemService.findItemBySku(sku).stream().findFirst();
            if(itemBySku.isEmpty()){
                System.out.println("Item not found");
            } else {
                if (itemBySku.get().getInventoryCount() > 0) {
                    System.out.println("Restock for product " + sku + " was performed");
                    waitingProduct.setProcessed(true);
                    waitingProductService.save(waitingProduct);
                    waitingProductService.sendNotification(waitingProduct,itemBySku.get().getName(), itemBySku.get().getImage());

                } else {
                    System.out.println("Not enouth products to restock: " + sku);
                }
            }
        });
    }
}
