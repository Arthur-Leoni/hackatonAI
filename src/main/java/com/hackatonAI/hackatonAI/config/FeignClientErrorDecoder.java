package com.hackatonAI.hackatonAI.config;

import feign.Response;
import feign.RetryableException;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FeignClientErrorDecoder implements ErrorDecoder {

  @Override
  public Exception decode(String methodKey, Response response) {
    Exception exception = new Default().decode(methodKey, response);

    String message =
        String.format(
            "The request to %s returned with an error. Http status code %s. See the error:",
            response.request().url(), response.status());

    log.error(message, exception);

    if (response.status() >= 500 && response.status() <= 599) {
      log.error("Service unavailable: {}", response.status());

      return new RetryableException(
          response.status(),
          exception.getMessage(),
          response.request().httpMethod(),
          exception,
          null,
          response.request());
    }

    return new Default().decode(methodKey, response);
  }
}
