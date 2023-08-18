package com.hackatonAI.hackatonAI;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@JsonFormat
@Data
public class WaitingProductRequest {

    private String sku;
    private String vendorId;
    private String accountId;

}
