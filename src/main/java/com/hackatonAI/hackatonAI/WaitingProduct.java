package com.hackatonAI.hackatonAI;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "BR-WaitingProduct")
public class WaitingProduct {

    @Id
    private String id;
    private String sku;
    private String vendorId;
    private String accountId;
    private boolean processed;

}
