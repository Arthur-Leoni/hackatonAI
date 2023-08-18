package com.hackatonAI.hackatonAI;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "BR-Items")
@Data
public class Item {

  @Id private String id;
  private String sku;
  private int inventoryCount;
  private String name;
  private String brandName;
  private String image;
}