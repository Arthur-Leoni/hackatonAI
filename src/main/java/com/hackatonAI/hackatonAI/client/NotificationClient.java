package com.hackatonAI.hackatonAI.client;

import com.hackatonAI.hackatonAI.config.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(
    url = "localhost:8080",
    name = "hackaton",
    configuration = FeignConfiguration.class)
public interface NotificationClient {
  @GetMapping(value = "/notifications", name = "saveMessage.")
  ResponseEntity<?> saveMessage(
      @RequestBody NotificationRequest notificationRequest);
}
