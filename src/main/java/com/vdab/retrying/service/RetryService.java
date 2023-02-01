package com.vdab.retrying.service;

import com.vdab.retrying.client.KszClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class RetryService {
    final KszClient kszClient;

    @Retryable(maxAttempts = 3, value = RuntimeException.class, backoff = @Backoff(delay = 5000))
    public void retryTest() {
        log.info("retryTest service executed");
        kszClient.executeClient();
    }
}
