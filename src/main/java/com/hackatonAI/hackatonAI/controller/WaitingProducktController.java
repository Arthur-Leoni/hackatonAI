package com.hackatonAI.hackatonAI.controller;

import com.hackatonAI.hackatonAI.WaitingProductRequest;
import com.hackatonAI.hackatonAI.services.WatingProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class WaitingProducktController {

    @Autowired
    private WatingProductService watingProductService;
    @PostMapping("/waitingProduct")
    public ResponseEntity<?> waitingProduct(@RequestBody WaitingProductRequest request) {
        watingProductService.save(request.getSku(), request.getVendorId(), request.getAccountId());
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
