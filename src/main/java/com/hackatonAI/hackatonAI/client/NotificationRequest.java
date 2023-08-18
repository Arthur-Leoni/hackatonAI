package com.hackatonAI.hackatonAI.client;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@JsonFormat
public class NotificationRequest {

    private String image;
    private String vendorId;
    private String accountId;
    private String message;

}
