package com.vdab.retrying.service;

import com.vdab.retrying.client.KszClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Backoff;
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
}
