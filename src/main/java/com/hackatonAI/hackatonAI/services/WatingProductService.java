package com.hackatonAI.hackatonAI.services;

import com.hackatonAI.hackatonAI.WaitingProduct;
import com.hackatonAI.hackatonAI.client.NotificationClient;
import com.hackatonAI.hackatonAI.client.NotificationRequest;
import com.hackatonAI.hackatonAI.repositories.WaitingProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WatingProductService {

    private final WaitingProductRepository waitingProductRepository;

    private final NotificationClient itemClient;

    @Autowired
    public WatingProductService(WaitingProductRepository waitingProductRepository, NotificationClient itemClient) {
        this.waitingProductRepository = waitingProductRepository;
        this.itemClient = itemClient;
    }

    public void save(String sku, String vendorId, String accountId) {
        WaitingProduct waitingProduct = new WaitingProduct();
        waitingProduct.setSku(sku);
        waitingProduct.setVendorId(vendorId);
        waitingProduct.setAccountId(accountId);
        waitingProduct.setProcessed(false);
        waitingProductRepository.save(waitingProduct);
    }

    public List<WaitingProduct> getAllWaitingProducts() {
        return waitingProductRepository.findAllByProcessed(false);
    }

    public void save(WaitingProduct waitingProduct) {
        waitingProductRepository.save(waitingProduct);
    }

    public void sendNotification(WaitingProduct waitingProduct, String name, String image){

        NotificationRequest notificationRequest = new NotificationRequest();
        notificationRequest.setAccountId(waitingProduct.getAccountId());
        notificationRequest.setVendorId(waitingProduct.getVendorId());
        notificationRequest.setImage(image);
        notificationRequest.setMessage("Produto "+ name +" voltou ao estoque");
        itemClient.saveMessage(notificationRequest);
    }
}



