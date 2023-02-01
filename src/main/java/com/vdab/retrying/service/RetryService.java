package com.vdab.retrying.service;

import com.vdab.retrying.client.KszClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

@Slf4j
@RequiredArgsConstructor
@Service
public class RetryService {
    final KszClient kszClient;

    @Retryable(maxAttemptsExpression = "${retry.max-attempts}", value = HttpClientErrorException.class, backoff = @Backoff(delayExpression = "${retry.max-delay}"))
    public void retryTest() {
        log.info("retryTest service executed");
        kszClient.executeClient();
    }

    /*
    The @Recover annotation defines a separate recovery method when a @Retryable method fails with a specified exception.
    Consequently, if the retryTest method keeps throwing an HttpClientErrorException after three attempts, the recover() method will be called.
     */
    @Recover
    public void recoverFromExceptionAfterRetries(HttpClientErrorException ex) {
        log.warn("Persist ERROR RepertoriumActie");
    }
}
