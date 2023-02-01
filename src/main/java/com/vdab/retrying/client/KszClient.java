package com.vdab.retrying.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;

@Slf4j
@Component
public class KszClient {
    public void executeClient() {
        log.info("call to KSZ GWY");
        throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
