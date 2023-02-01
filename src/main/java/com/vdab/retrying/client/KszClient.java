package com.vdab.retrying.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KszClient {
    public void executeClient() {
        log.info("call to KSZ GWY");
        throw new RuntimeException("KSZ GWY exception is thrown");
    }
}
