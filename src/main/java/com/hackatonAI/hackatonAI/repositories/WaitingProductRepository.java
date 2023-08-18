package com.hackatonAI.hackatonAI.repositories;

import com.hackatonAI.hackatonAI.WaitingProduct;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WaitingProductRepository extends MongoRepository<WaitingProduct, String> {

    List<WaitingProduct> findAllByProcessed(boolean processed);
}