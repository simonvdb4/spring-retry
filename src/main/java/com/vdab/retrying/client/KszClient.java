package com.vdab.retrying.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;

@Slf4j
@Component
public class KszClient {
    private int counterNumberOfErrorsThrown = 0;
    private static final int MAXIMUM_NUMBER_OF_ERRORS_THROWN = 2;

    public void executeClient() {
        log.info("call to KSZ GWY");
        if (counterNumberOfErrorsThrown != MAXIMUM_NUMBER_OF_ERRORS_THROWN) {
            counterNumberOfErrorsThrown = counterNumberOfErrorsThrown + 1;
            log.info("counterNumberOfErrorsThrown: " + counterNumberOfErrorsThrown);
            throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
